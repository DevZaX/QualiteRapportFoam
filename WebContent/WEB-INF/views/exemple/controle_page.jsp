<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<form action="../test/4" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 

	<input type="date" name="date1">
	<input type="date" name="date2">
	<select name="zone">
	<option>All</option>
	</select>
	<select name="equipe">
		<option>All</option>
	</select>
	<select name="prototype">
		<option>All</option>
	</select>
	<select name="projet"><option></option><option>X1</option></select>
	<select name="famille"><option></option></select>
	<select name="designation"><option></option></select>
	<input type="submit" value="test" >
</form>

<table border="1">
	<tr>
		<th>projet</th>
		<th>taux de scrap</th>
	</tr>
	<c:forEach items="${scrapProjets }" var="e">
		<tr>
			<td>${e.getProjet() }</td>
			<td>${e.getScrap() }</td>
		</tr>
	</c:forEach>
</table>