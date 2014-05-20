<%@ include file="/WEB-INF/views/include.jsp"%>

<html>

<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>Offices</h3>


	<b>Calle: </b>
	<c:out value="${office.getAddress()}" />
	<i><b>Balance: </b></i> <c:out value="${office.getBalance()}" />
	<br>
	<br>



	<br>
	<a href="<c:url value="searcher.htm"/>">Searcher</a>
	<br>
</body>
</html>