<footer class="guest-footer">
    <div class="container footer-container">
        <div class="footer-brand">
            <h3>FoodHub</h3>
            <p>
                Delicious food delivered fast,
                fresh and right to your doorstep.
            </p>
        </div>
        <div class="footer-links">
            <h4>Quick Links</h4>
            <a href="${pageContext.request.contextPath}/home">Home</a>
            <a href="${pageContext.request.contextPath}/guest/restaurants">Restaurants</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </div>
        <div class="footer-links">
            <h4>Legal</h4>
            <a href="#">Privacy Policy</a>
            <a href="#">Terms & Conditions</a>
            <a href="#">Refund Policy</a>
        </div>
        <div class="footer-links">
            <h4>Contact</h4>
            <p>support@foodhub.com</p>
            <p>+91 9876543210</p>
        </div>
    </div>
    <div class="footer-bottom">
         © <%= java.time.LocalDate.now().getYear() %> FoodHub. All Rights Reserved.
    </div>
</footer>

