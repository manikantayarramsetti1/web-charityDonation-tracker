package com.manikanta.web.jdbc;

import java.util.Date;

public class CharityDonation {
	private int id;
	private String financialYear;
	private double amount;
	private String receipt;
	private String institution;
	private String address;
    private String pan;
    private String receipts;
    private String remarks;
	
	public CharityDonation(int id, String financialYear, double amount, String receipt, String institution,
						String address, String pan, String receipts, String remarks) {
		super();
		this.id = id;
		this.financialYear = financialYear;
		this.amount = amount;
		this.receipt = receipt;
		this.institution = institution;
		this.address = address;
		this.pan = pan;
		this.receipts = receipts;
		this.remarks = remarks;
	}

	public CharityDonation(String financialYear, double amount, String receipt, String institution, String address,
									 String pan, String receipts, String remarks) {
		super();
		this.financialYear = financialYear;
		this.amount = amount;
		this.receipt = receipt;
		this.institution = institution;
		this.address = address;
		this.pan = pan;
		this.receipts = receipts;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getReceipts() {
		return receipts;
	}

	public void setReceipts(String receipts) {
		this.receipts = receipts;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "CharityDonation [id=" + id + ", financialYear=" + financialYear + ", amount="
				+ amount + ", receipt=" + receipt + ", institution=" + institution + ", address=" + address + ", pan="
				+ pan + ", receipts=" + receipts + ", remarks=" + remarks + "]";
	}

}
