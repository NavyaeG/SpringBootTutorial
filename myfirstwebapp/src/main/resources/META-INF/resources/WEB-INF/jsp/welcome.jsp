<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Welcome to learn springboot!</h1><!-- variable that holds name passed from controller -->
	<div>Your name ${name}</div>
	<div><a href="list-todos">Manage your todos</a></div>
</div>
<%@ include file="common/footer.jspf" %>