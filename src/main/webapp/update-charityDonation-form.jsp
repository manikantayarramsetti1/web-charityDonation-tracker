<!DOCTYPE html>
<html>

<head>
	<title>Update CharityDonation</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-charityDonation-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Charity Donation Tracker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update CharityDonation</h3>
		
		<form action="CharityDonationControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="charityDonationId" value="${THE_CHARITYDONATION.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Financial Year:</label></td>
						<td><input type="text" name="financialYear" required
								   value="${THE_CHARITYDONATION.financialYear}" /></td>
					</tr>

					<tr>
						<td><label>Amount:</label></td>
						<td><input type="text" name="amount" required
								   value="${THE_CHARITYDONATION.amount}" /></td>
					</tr>

					<tr>
						<td><label>Receipt:</label></td>
						<td><input type="text" name="receipt" required
								   value="${THE_CHARITYDONATION.receipt}" /></td>
					</tr>

					<tr>
						<td><label>Institution:</label></td>
						<td><input type="text" name="institution" required
								   value="${THE_CHARITYDONATION.institution}" /></td>
					</tr>

					<tr>
						<td><label>Address:</label></td>
						<td><input type="text" name="address" required
								   value="${THE_CHARITYDONATION.address}" /></td>
					</tr>

					<tr>
						<td><label>PAN:</label></td>
						<td><input type="text" name="pan" required
								   value="${THE_CHARITYDONATION.pan}" /></td>
					</tr>

					<tr>
						<td><label>Receipts:</label></td>
						<td><input type="text" name="receipts" required 
								   value="${THE_CHARITYDONATION.receipts}" /></td>
					</tr>

					<tr>
						<td><label>Remarks:</label></td>
						<td><input type="text" name="remarks" required
								   value="${THE_CHARITYDONATION.remarks}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="CharityDonationControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











