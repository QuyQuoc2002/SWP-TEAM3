<%-- 
    Document   : error-404
    Created on : Jan 12, 2023, 11:13:53 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>404 - Page not found</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="assets/css/404.css" />
        <style>
            * {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
            }

            body {
                padding: 0;
                margin: 0;
                background-color: #292929;
            }

            #notfound {
                position: relative;
                height: 100vh;
            }

            #notfound .notfound {
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

            .notfound {
                max-width: 410px;
                width: 100%;
                text-align: center;
            }

            .notfound .notfound-404 {
                margin-bottom: 75px;
            }

            .notfound .notfound-404 img{
                width: 100%;
                height: 100%;
                text-align: center;

            }


            .notfound h2 {
                font-family: 'Montserrat', sans-serif;
                color: #fff;
                font-size: 24px;
                font-weight: 700;
                text-transform: uppercase;
                margin-top: 0;
            }

            .notfound p {
                font-family: 'Montserrat', sans-serif;
                color: #fff;
                font-size: 14px;
                font-weight: 400;
                margin-bottom: 50px;
                margin-top: 0px;

            }

            .notfound a {
                font-family: 'Montserrat', sans-serif;
                font-size: 14px;
                text-decoration: none;
                text-transform: uppercase;
                background: #fe0000c2;
                display: inline-block;
                padding: 15px 30px;
                border-radius: 40px;
                color: #fff;
                font-weight: 700;
                -webkit-box-shadow: 0px 4px 15px -5px #fe0000c2;
                box-shadow: 0px 4px 15px -5px #fe0000c2;
            }
        </style>

    </head>

    <body>

        <div id="notfound">
            <div class="notfound">
                <div class="notfound-404" >
                    <img src="../assets/images/logo.png">
                </div>
                <h2>404 - Page not found</h2>
                <p>The page you are looking for might have been removed had its name changed or is temporarily unavailable.
                </p>
                <a href="/ApaMan">Go To Homepage</a>
            </div>
        </div>

    </body>

</html>