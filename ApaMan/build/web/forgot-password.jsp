<%-- 
    Document   : login
    Created on : Jan 12, 2023, 12:35:31 AM
    Author     : DELL
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Apaman</title>
        <link rel="icon" type="image/x-icon" href="assets/system/icons8-home-pulsar-color-32.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Poppins", sans-serif;
            }

            html, body {
                height: 100%;
            }

            body {
                display: grid;
                place-items: center;
                text-align: center;
                background: #dde1e7;
            }

            .content {
                width: 400px;
                background: #dde1e7;
                border-radius: 10px;
                padding: 40px 30px;
                box-shadow: -3px -3px 7px #ffffff73,
                    2px 2px 5px rgba(94, 104, 121, 0.2888)
            }

            .content .text {
                font-size: 33px;
                font-weight: 600;
                margin-bottom: 35px;
                color: #595959;
            }

            .content .field {
                height: 50px;
                width: 100%;
                display: flex;
                position: relative;
            }

            .field input {
                height: 100%;
                width: 100%;
                padding-left: 45px;
                font-size: 18px;
                outline: none;
                border: none;
                color: #595959;
                border-radius: 25px;
                background: #dde1e7;
                box-shadow: inset 2px 2px 5px #babecc,
                    inset -5px -5px 10px #ffffff73;
            }

            .field input:focus {
                box-shadow: inset 1px 1px 2px #babecc,
                    inset -1px -1px 2px #ffffff73;
            }

            .field:nth-child(2) {
                margin-top: 20px;
            }

            .field span {
                position: absolute;
                width: 50px;
                line-height: 50px;
                color: #595959;
            }

            .field label {
                position: absolute;
                top: 50%;
                left: 45px;
                pointer-events: none;
                transform: translateY(-50%);
                color: #666666;
            }

            .field input:valid ~ label {
                opacity: 0;
            }

            button {
                margin: 15px 0;
                width: 100%;
                height: 50px;
                font-size: 18px;
                font-weight: 600;
                background: #dde1e7;
                border: none;
                outline: none;
                cursor: pointer;
                border-radius: 25px;
                box-shadow: 2px 2px 5px #babecc,
                    -5px -5px 10px #ffffff73;
            }

            button:focus {
                box-shadow:inset 2px 2px 5px #babecc,
                    inset -5px -5px 10px #ffffff73;
            }
        </style>
    </head>

    <body>
        <div class="content">
            <div class="text">Forgot Password</div>
            <form action="get-code-confirm" method="post" style="position: relative;">
                <span style="color: red; font-weight: 600; position: absolute; top: -28px; left: 0; right: 0;">${sessionScope.message}</span>
                <div class="field">
                    <span class="fa fa-user"></span>
                    <input type="text" required name="username">
                    <label for="">Email</label>
                </div>
                <input type="hidden" name="apartmentId" value="${requestScope.apartmentId}">
                <button type="submit">Get Code Confirm</button>
            </form>
        </div>
    </body>

    <%
        request.getSession().removeAttribute("message");
    %>
</html>
