<!DOCTYPE td PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<td width="71%" valign="top" style="padding-left: 16em;">
		<h1 class="heading">Admin <span>Login</span></h1>
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
						</table>
										<div id="login">
										<form:form action="${pageContext.request.contextPath}/admin/validate" modelAttribute="adminDetails" name="adminform">
											<table>
												<tr>
													<td>Username:</td>
													<td><input type="text" name="username"/></td>
												</tr><tr>
													<td>Password:</td>
													<td><input type="password" name="password"/></td>
												</tr>
												<tr>
													<td></td>
													<td><input type="submit" value="login"/></td>
												</tr>
											</table>
											</form:form>
										</div>
						
						</td>
	
</body>

