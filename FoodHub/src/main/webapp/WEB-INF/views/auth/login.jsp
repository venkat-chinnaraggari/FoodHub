<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sign in | FoodHub</title>
        <%@ include file="/WEB-INF/views/common/guest-header.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/auth.css">
    </head>
    <body class="auth-body">
        <main class="auth-page">

            <!-- Photo panel -->
            <aside class="auth-visual">
                <div class="auth-visual-content">
                    <h2>Good food is waiting for you.</h2>
                    <p>
                        Sign in to reorder your favorites and
                        track every order in one place.
                    </p>
                </div>
            </aside>

            <!-- Form panel -->
            <section class="auth-panel">
                <div class="auth-card">

                    <a href="${pageContext.request.contextPath}/home"
                       class="auth-logo">
                        <img src="${pageContext.request.contextPath}/Logo/FoodHub.png"
                             alt="FoodHub">
                    </a>

                    <h1>Welcome back</h1>
                    <p class="auth-subtitle">
                        Sign in with your email and password.
                    </p>

                    <c:if test="${not empty error}">
                        <div class="auth-alert auth-error" role="alert">
                            <i class="fa-solid fa-circle-exclamation"></i>
                            <span><c:out value="${error}"/></span>
                        </div>
                    </c:if>

                    <c:if test="${not empty success}">
                        <div class="auth-alert auth-success" role="status">
                            <i class="fa-solid fa-circle-check"></i>
                            <span><c:out value="${success}"/></span>
                        </div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/login"
                          method="post"
                          class="auth-form">

                        <div class="form-group">
                            <label for="email">Email address</label>
                            <div class="input-wrap">
                                <i class="fa-regular fa-envelope"></i>
                                <input type="email"
                                       id="email"
                                       name="email"
                                       placeholder="you@example.com"
                                       value="<c:out value='${param.email}'/>"
                                       autocomplete="email"
                                       required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label>
                            <div class="input-wrap">
                                <i class="fa-solid fa-lock"></i>
                                <input type="password"
                                       id="password"
                                       name="password"
                                       class="has-toggle"
                                       placeholder="Enter your password"
                                       autocomplete="current-password"
                                       required>
                                <button type="button"
                                        class="toggle-pass"
                                        data-target="password"
                                        aria-label="Show password">
                                    <i class="fa-regular fa-eye"></i>
                                </button>
                            </div>
                        </div>

                        <button type="submit" class="auth-submit">
                            Sign in
                        </button>
                    </form>

                    <p class="auth-switch">
                        New to FoodHub?
                        <a href="${pageContext.request.contextPath}/auth/register">
                            Create an account
                        </a>
                    </p>

                </div>
            </section>
        </main>

        <script>
            document.querySelectorAll('.toggle-pass').forEach(function (btn) {
                btn.addEventListener('click', function () {
                    var input = document.getElementById(btn.dataset.target);
                    var show = input.type === 'password';
                    input.type = show ? 'text' : 'password';
                    btn.querySelector('i').className =
                        show ? 'fa-regular fa-eye-slash' : 'fa-regular fa-eye';
                    btn.setAttribute('aria-label',
                        show ? 'Hide password' : 'Show password');
                });
            });
        </script>
    </body>
</html>
