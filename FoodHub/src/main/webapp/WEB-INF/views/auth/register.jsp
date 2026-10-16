<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Create account | FoodHub</title>
        <%@ include file="/WEB-INF/views/common/guest-header.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/auth.css">
    </head>
    <body class="auth-body">
        <main class="auth-page">

            <!-- Photo panel -->
            <aside class="auth-visual">
                <div class="auth-visual-content">
                    <h2>Join FoodHub and order in a few taps.</h2>
                    <p>
                        Save your delivery address once and check out
                        faster every time you order.
                    </p>
                </div>
            </aside>

            <!-- Form panel -->
            <section class="auth-panel">
                <div class="auth-card auth-card-wide">

                    <a href="${pageContext.request.contextPath}/home"
                       class="auth-logo">
                        <img src="${pageContext.request.contextPath}/Logo/FoodHub.png"
                             alt="FoodHub">
                    </a>

                    <h1>Create your account</h1>
                    <p class="auth-subtitle">
                        It takes less than a minute.
                    </p>

                    <c:if test="${not empty error}">
                        <div class="auth-alert auth-error" role="alert">
                            <i class="fa-solid fa-circle-exclamation"></i>
                            <span><c:out value="${error}"/></span>
                        </div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/register"
                          method="post"
                          class="auth-form">

                        <div class="form-row">
                            <div class="form-group">
                                <label for="fullName">Full name</label>
                                <div class="input-wrap">
                                    <i class="fa-regular fa-user"></i>
                                    <input type="text"
                                           id="fullName"
                                           name="fullName"
                                           placeholder="Your full name"
                                           value="<c:out value='${param.fullName}'/>"
                                           autocomplete="name"
                                           required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phone">Phone number</label>
                                <div class="input-wrap">
                                    <i class="fa-solid fa-phone"></i>
                                    <input type="tel"
                                           id="phone"
                                           name="phone"
                                           placeholder="10-digit mobile number"
                                           value="<c:out value='${param.phone}'/>"
                                           pattern="[6-9][0-9]{9}"
                                           maxlength="10"
                                           title="Enter a 10-digit mobile number"
                                           autocomplete="tel"
                                           required>
                                </div>
                            </div>
                        </div>

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
                            <label for="address">Delivery address</label>
                            <div class="input-wrap input-wrap-top">
                                <i class="fa-solid fa-location-dot"></i>
                                <textarea id="address"
                                          name="address"
                                          rows="2"
                                          placeholder="House no, street, area, city, PIN code"
                                          autocomplete="street-address"
                                          required><c:out value="${param.address}"/></textarea>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="password">Create password</label>
                                <div class="input-wrap">
                                    <i class="fa-solid fa-lock"></i>
                                    <input type="password"
                                           id="password"
                                           name="password"
                                           class="has-toggle"
                                           placeholder="Create a password"
                                           minlength="8"
                                           autocomplete="new-password"
                                           required>
                                    <button type="button"
                                            class="toggle-pass"
                                            data-target="password"
                                            aria-label="Show password">
                                        <i class="fa-regular fa-eye"></i>
                                    </button>
                                </div>
                                <p class="input-hint">Use at least 8 characters.</p>
                            </div>

                            <div class="form-group">
                                <label for="confirmPassword">Confirm password</label>
                                <div class="input-wrap">
                                    <i class="fa-solid fa-lock"></i>
                                    <input type="password"
                                           id="confirmPassword"
                                           name="confirmPassword"
                                           class="has-toggle"
                                           placeholder="Re-enter your password"
                                           autocomplete="new-password"
                                           required>
                                    <button type="button"
                                            class="toggle-pass"
                                            data-target="confirmPassword"
                                            aria-label="Show password">
                                        <i class="fa-regular fa-eye"></i>
                                    </button>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="auth-submit">
                            Create account
                        </button>
                    </form>

                    <p class="auth-switch">
                        Already have an account?
                        <a href="${pageContext.request.contextPath}/auth/login">
                            Sign in
                        </a>
                    </p>

                </div>
            </section>
        </main>

        <script>
            // Show / hide password
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

            // Passwords must match
            var pw = document.getElementById('password');
            var cpw = document.getElementById('confirmPassword');

            function checkMatch() {
                cpw.setCustomValidity(
                    cpw.value && cpw.value !== pw.value
                        ? 'Passwords do not match' : '');
            }

            pw.addEventListener('input', checkMatch);
            cpw.addEventListener('input', checkMatch);
        </script>
    </body>
</html>
