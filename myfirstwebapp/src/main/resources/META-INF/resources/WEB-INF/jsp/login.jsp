<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<div class="container">
			<h1>Welcome to Login</h1>><!-- variable that holds name passed from controller -->
			<pre>${errorMessage}</pre>
			<form method ="post">
			Name: <input type="text" name="name">
			Password: <input type="text" name="password">
			<input type="submit">
			</form>
		</div>
	</body>
</html>