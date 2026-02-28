<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String course = (String) session.getAttribute("selectedCourse");
    Integer price = (Integer) session.getAttribute("coursePrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Payment</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #f0f4ff, #e2ebff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .payment-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        width: 400px;
        text-align: center;
    }
    h2 {
        color: #2563eb;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 25px;
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
    }
    th {
        background-color: #2563eb;
        color: #fff;
        border-radius: 8px 8px 0 0;
    }
    tr:nth-child(even) {
        background-color: #f1f5ff;
    }
    .pay-btn {
        background-color: #2563eb;
        color: #fff;
        padding: 12px 25px;
        font-size: 16px;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        transition: 0.3s;
    }
    .pay-btn:hover {
        background-color: #1e40af;
    }
</style>
</head>
<body>

<div class="payment-container">
    <h2>Confirm Your Payment</h2>
    <table>
        <tr>
            <th>Course</th>
            <td><%= course %></td>
        </tr>
        <tr>
            <th>Amount</th>
            <td>₹<%= price %></td>
        </tr>
    </table>

    <form action="PaymentProcess" method="post">
        <input type="hidden" name="course" value="<%= course %>">
        <input type="hidden" name="price" value="<%= price %>">
        <button type="submit" class="pay-btn">Pay Now</button>
    </form>
</div>

</body>
</html>
