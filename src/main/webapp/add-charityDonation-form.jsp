<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-charityDonation-style.css">
</head>

<body>
    <div id="wrappper">
        <div id="header">
        <h2>Charity Donation Tracker</h2></div>
        </div>
        <div class="container">
            
            <h3>Add CharityDonation</h3>
            <form action="CharityDonationControllerServlet" method="GET">
                <input type="hidden" name="command" value="ADD">
                <table>
                    <tr>
                        <td><label>Financial Year: </label></td>
                        <td><input type="text" name="financialYear" required></td>
                    </tr>
                    <tr>
                        <td><label>Amount: </label></td>
                        <td><input type="text" name="amount" required></td>
                    </tr>
                    <tr>
                        <td><label>Receipt: </label></td>
                        <td><input type="text" name="receipt" required></td>
                    </tr>
                    <tr>
                        <td><label>Institution: </label></td>
                        <td><input type="text" name="institution" required></td>
                    </tr>
                    <tr>
                        <td><label>Address: </label></td>
                        <td><input type="text" name="address" required></td>
                    </tr>
                    <tr>
                        <td><label>PAN: </label></td>
                        <td><input type="text" name="pan" required></td>
                    </tr>
                    <tr>
                        <td><label>Receipts: </label></td>
                        <td><input type="text" name="receipts" required></td>
                    </tr>
                    <tr>
                        <td><label>Remarks: </label></td>
                        <td><input type="text" name="remarks" required></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </table>
            </form>
            <div style="clear: both;"></div>
            <p>
                <a href="CharityDonationControllerServlet">Back to List</a>
            </p>
        </div>
</body>

</html>