<!DOCTYPE html>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
	<title><tiles:insertAttribute name="title" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>

<tiles:insertAttribute name="header" />


	<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 100px; margin-bottom: 200px;">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="10" cellpadding="0">
					<tr>
						<tiles:insertAttribute name="sidebar" />
						<tiles:insertAttribute name="body" />
					</tr>
				</table>
			</td>
		</tr>
	</table>
			<tiles:insertAttribute name="footer" />

</html>