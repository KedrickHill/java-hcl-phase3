<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<style>
table {
	float: left;
}

th {
	border-bottom: 1px solid black;
}
</style>
<body>

	<h2>Search for User</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<tr>
			<td>${userSearch.id}</td>
			<td>${userSearch.name}</td>
			<td>${userSearch.email}</td>
			<td>${userSearch.password}</td>
		</tr>
	</table>

	<br />
	<br />
	<br />
	<form action="update" method="get">
		<fieldset data-role="collapsible">
			<legend>Update This User?</legend>
				<label for="id">New ID:</label>
				<input type="text" name="id" id="name" value="${userSearch.id}" required/>
				<label for="name">New Name:</label>
				<input type="text" name="name" id="name" value="${userSearch.name}" required/>
				<label for="email">New Email:</label> 
				<input type="text" name="email" id="email" value="${userSearch.email}" required/>
				<label for="password">New Password:</label>
				<input type="text" name="password" id="password" value="${userSearch.password}" required/>
				<input type="submit" value="Submit"/>
		</fieldset>
	</form>

</body>
</html>
