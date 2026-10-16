<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<header class="guest-navbar">
    <div class="container navbar-container">
      <!-- Logo -->
		<a href="${pageContext.request.contextPath}/home"
		   class="navbar-logo">
		    <img src="${pageContext.request.contextPath}/Logo/FoodHub.png"
		         alt="FoodHub">
		     <span id="app-name">FoodHub</span>
		</a>

        <!-- Navigation -->
        <nav class="navbar-menu">
            <a href="${pageContext.request.contextPath}/home">
                Home
            </a>
            <a href="${pageContext.request.contextPath}/guest/restaurants">
                Restaurants
            </a>
        </nav>

        <!-- Right Side -->
        <div class="navbar-actions">
            <c:choose>
                <c:when test="${not empty sessionScope.loggedInUser}">
                    <a href="${pageContext.request.contextPath}/cart"
                       class="nav-icon">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </a>
                    <a href="${pageContext.request.contextPath}/orders"
                       class="nav-link">
                        Orders
                    </a>
                    <a href="${pageContext.request.contextPath}/profile"
                       class="nav-link">
                        Profile
                    </a>
                    <a href="${pageContext.request.contextPath}/logout"
                       class="btn btn-outline">
                        Logout
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/auth/login"
                       class="btn btn-outline">
                        Sign In
                    </a>
                    <a href="${pageContext.request.contextPath}/auth/register"
                       class="btn btn-primary">
                        Sign Up
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>