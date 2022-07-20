<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<caption>Hint: use first name</caption>
	<form:form method="post">
		Name:<input type="text" required="required" name="name"> Password:<input
			type="password" name="password">
		<br />
		<br />
		<button onClick=""
			class="bg-blue-400 text-white px-2 py-3 w-full text-left rounded-t-md">
			Login</button>
	</form:form>

</div>
<%@ include file="common/footer.jspf"%>

