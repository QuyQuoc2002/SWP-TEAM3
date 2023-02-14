<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    footer {
        bottom: 0;
        width: 100%;
        background: #0f1521;
        color: #fff;
    }

    .footer .container-footer {
        display: flex;
        padding: 3rem;
    }

    .footer .container-footer .section {
        flex-basis: 50%;
        padding: 0 20px;
    }

    .footer .container-footer .section .content-footer .social a {
        color: #fff;
    }

    .footer .section h2 {
        font-size: 1.125rem;
        font-weight: 600;
        text-transform: uppercase;
    }

    .footer .section .content-footer {
        margin: 20px 0 0 0;
        position: relative;
    }

    .footer .section .content-footer::after {
        position: absolute;
        content: '';
        height: 2px;
        width: 15%;
        background-color: #ff0909;
        top: -10px;
    }

    .footer .left .content-footer .social {
        margin: 20px 0 0 0;
    }

    .footer .left .content-footer .social a {
        padding: 0 2px;
    }

    .footer .left .content-footer .social a span {
        height: 40px;
        width: 40px;
        background: transparent;
        line-height: 40px;
        text-align: center;
        font-size: 18px;
        border-radius: 50px;
        transition: 0.4s;
        border: 1px solid #fff;
    }


    .footer .left .content-footer .social a span:hover {
        background: #ff0909;
    }

    .footer .center .content-footer .fas {
        font-size: 1.1rem;
        background: transparent;
        height: 45px;
        width: 45px;
        line-height: 45px;
        text-align: center;
        border-radius: 50px;
        transition: 0.3s;
        cursor: pointer;
        border: 1px solid #fff;
    }

    .footer .center .content-footer .fas:hover {
        background: #ff0909;
        border: 1px solid #ff0909;
    }

    .footer .center .content-footer .text {
        font-size: 1.0.6rem;
        font-weight: 500;
        padding-left: 10px;
    }

    .footer .center .content-footer .phone {
        margin: 15px 0;
    }

    .footer .right form .text {
        font-size: 1.0625rem;
        margin-bottom: 2px;
        color: #fff;
    }

    .footer .right form input {
        width: 100%;
        font-size: 1.0625rem;
        background: transparent;
        color: #fff;
        border: 1px solid #fff;
    }

    .footer .right form input {
        height: 35px;
    }

    .footer .right form .btn-footer {
        margin-top: 10px;
    }

    .footer .right form .btn-footer button {
        height: 40px;
        width: 100%;
        border: none;
        outline: none;
        background: #fff;
        color: #ff0909;
        font-size: 1.0625rem;
        font-weight: 500;
        cursor: pointer;
        transition: 0.3s;
    }


    .footer .right form .btn-footer button:hover {
        background: #ff0909;
        color: white;
        transition: ease-in all 0.5s;
    }
</style>

<footer>
    <div class="footer">
        <div class="container-footer">
            <div class="left section">
                <h2>About Us</h2>
                <div class="content-footer">
                    <p>Focus on quality with all your heart and create trust for customers with actions. Rent our
                        home
                        to make your life easier.</p>
                    <div class="social">
                        <a href="https://www.facebook.com/"><span class="fab fa-facebook-f"></span></a>
                        <a href="https://instagram.com/"><span class="fab fa-instagram"></span></a>
                        <a href="https://www.youtube.com/"><span class="fab fa-youtube"></span></a>
                    </div>
                </div>
            </div>

            <div class="center section">
                <h2>Contact Us</h2>
                <div class="content-footer">
                    <div class="place">
                        <span class="fas fa-map-marker-alt"></span>
                        <span class="text"> Hoa Lac, Ha Noi</span>
                    </div>
                    <div class="phone">
                        <span class="fas fa-phone-alt"></span>
                        <span class="text"> 0123456789</span>
                    </div>
                    <div class="email">
                        <span class="fas fa-envelope"></span>
                        <span class="text"> apaman@gmail.com</span>
                    </div>
                </div>
            </div>

            <div class="right section">
                <h2>Subscribe</h2>
                <div class="content-footer">
                    <form action="subscriber" method="post">
                        <div class="email">
                            <div class="text">Email</div>
                        </div>
                        <c:if test="${requestScope.apartment.apartmentId != null}">
                        <input hidden value="${requestScope.apartment.apartmentId}" name="apartmentId">
                        <input hidden name="page" value="homePage">
                        </c:if>
                        <c:if test="${requestScope.apartment.apartmentId == null}">
                            <input hidden name="page" value="index">
                        </c:if>
                        <input type="email" name="subscriberEmail" required>
                        <div class="btn-footer">
                            <button type="submit">SUBSCRIBE</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</footer>