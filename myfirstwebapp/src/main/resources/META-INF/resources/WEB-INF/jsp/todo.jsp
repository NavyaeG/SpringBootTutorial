<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<!-- <div>Welcome ${name}!</div><// variable that holds name passed from controller-->
	<h1>Enter Todo Details</h1>
	
	<form:form method="post" modelAttribute="todo"><!-- This form is mapped to todo controller-->
	
		<fieldset class ="mb-3">
			<form:label path="description">Description</form:label><!-- path ="description" here we are mapping description in Todo.java to html element -->
			<form:input type="text" path="description" required="required"/><!--inside todo bean mapping form element to the actual class attribute  -->
			<form:errors  path="description" cssClass="text-warning"/><!-- Used to show error there is validation problem of minimum characters in description -->
		</fieldset>
		
		<fieldset class ="mb-3">
			<form:label path="targetDate">Target Date</form:label><!-- path ="targetDate here we are mapping targetDate in Todo.java to html element -->
			<form:input type="text" path="targetDate" required="required"/><!--inside todo bean mapping form element to the actual class attribute  -->
			<form:errors  path="targetDate" cssClass="text-warning"/><!-- Used to show error there is validation problem of minimum characters in description -->
		</fieldset>
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<input type="submit" class="btn btn-success"/>
		
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd'
});
</script>
