package com.manikanta.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CharityDonationControllerServlet
 * @param <Date>
 */
@WebServlet("/CharityDonationControllerServlet")
public class CharityDonationControllerServlet<Date> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CharityDonationDbUtil charityDonationDbUtil;
	
	@Resource(name="jdbc/web_charityDonation_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our charityDonation db util ... and pass in the conn pool / datasource
		try {
			charityDonationDbUtil = new CharityDonationDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			if(theCommand == null) {
				theCommand = "LIST";
			}

			switch(theCommand) {
			case "LIST":
				listCharityDonation(request, response);
				break;
			case "ADD":
				addCharityDonation(request, response);
				break;
			case "LOAD":
				loadCharityDonation(request, response);
				break;
			case "UPDATE":
				updateCharityDonation(request, response);
				break;
			case "DELETE":
				deleteCharityDonation(request, response);
			    break;
			default:
				listCharityDonation(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}



	private void deleteCharityDonation(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read charityDonation id from form data
			String theCharityDonationId = request.getParameter("charityDonationId");
			
			// delete charityDonation from database
			charityDonationDbUtil.deleteCharityDonation(theCharityDonationId);
			
			// send them back to "list charityDonations" page
			listCharityDonation(request, response);
		}

		private void updateCharityDonation(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read charityDonation info from form data
			int id = Integer.parseInt(request.getParameter("charityDonationId"));
			String financialYear = request.getParameter("financialYear");
			double amount=Double.parseDouble(request.getParameter("amount"));
			String receipt = request.getParameter("receipt");
			String institution = request.getParameter("institution");
			String address = request.getParameter("address");
			String pan = request.getParameter("pan");
			String receipts = request.getParameter("receipts");
			String remarks = request.getParameter("remarks");

			// create a new charityDonation object
			CharityDonation theCharityDonation = new CharityDonation(id, financialYear, amount, receipt, institution, address, pan, receipts, remarks);
			
			// perform update on database
			charityDonationDbUtil.updateCharityDonation(theCharityDonation);
			
			// send them back to the "list charityDonations" page
			listCharityDonation(request, response);
			
		}

		private void loadCharityDonation(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// read charityDonation id from form data
			String theCharityDonationId = request.getParameter("charityDonationId");
			
			// get charityDonation from database (db util)
			CharityDonation theCharityDonation = charityDonationDbUtil.getCharityDonation(theCharityDonationId);
			
			// place charityDonation in the request attribute
			request.setAttribute("THE_CHARITYDONATION", theCharityDonation);
			
			// send to jsp page: update-charityDonation-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-charityDonation-form.jsp");
			dispatcher.forward(request, response);		
		}



	private void addCharityDonation(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read charityDonation info from form data
		String financialYear = request.getParameter("financialYear");
		double amount=Double.parseDouble(request.getParameter("amount"));
		String receipt = request.getParameter("receipt");
		String institution = request.getParameter("institution");		
		String address = request.getParameter("financialYear");
		String receipts = request.getParameter("receipts");
		String pan = request.getParameter("pan");	
		String remarks = request.getParameter("remarks");	
		// create a new charityDonation object
		CharityDonation theCharityDonation = new CharityDonation(financialYear, amount, receipt, institution, address, pan, receipts, remarks);
		
		// add the charityDonation to the database
		charityDonationDbUtil.addCharityDonation(theCharityDonation);
				
		// send back to main page (the charityDonation list)
		listCharityDonation(request, response);
	}



	private void listCharityDonation(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get charityDonations from db util
			List<CharityDonation> charityDonations = charityDonationDbUtil.getCharityDonations();
			
			// add charityDonations to the request
			request.setAttribute("CHARITYDONATION_LIST", charityDonations);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lists-charityDonation.jsp");
			dispatcher.forward(request, response);
		}

}
