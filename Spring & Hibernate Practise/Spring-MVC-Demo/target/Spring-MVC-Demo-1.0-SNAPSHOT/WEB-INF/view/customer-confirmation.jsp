<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>Customer Confirmation</title>
</head>

<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}
Free Passes : ${customer.freePass}
Postal Code : ${customer.postalCode}
Course Name : ${customer.courseName}

</body>

</html>