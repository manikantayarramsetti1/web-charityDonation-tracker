<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>CharityDonation Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Charity Donation Tracker</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add CharityDonation -->
			
			<input type="button" value="Add CharityDonation" 
				   onclick="window.location.href='add-charityDonation-form.jsp'; return false;"
				   class="add-charityDonation-button"
			/>
			
			<table>
			
				<tr>
					<th>Financial Year</th>
					<th>Amount</th>
					<th>Receipt</th>
					<th>Institution</th>
					<th>Address</th>
					<th>PAN</th>
					<th>Receipts</th>
					<th>Remarks</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCharityDonation" items="${CHARITYDONATION_LIST}">
					
					<!-- set up a link for each charityDonation -->
					<c:url var="tempLink" value="CharityDonationControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="charityDonationId" value="${tempCharityDonation.id}" />
					</c:url>

					<!--  set up a link to delete a charityDonation -->
					<c:url var="deleteLink" value="CharityDonationControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="charityDonationId" value="${tempCharityDonation.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempCharityDonation.financialYear} </td>
						<td> ${tempCharityDonation.amount} </td>
						<td> ${tempCharityDonation.receipt} </td>
						<td> ${tempCharityDonation.institution} </td>
						<td> ${tempCharityDonation.address} </td>
						<td> ${tempCharityDonation.pan} </td>
						<td> ${tempCharityDonation.receipts} </td>
						<td> ${tempCharityDonation.remarks} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this charityDonation?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








