<!DOCTYPE td PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<td width="71%" valign="top" style="padding-left: 16em;">
		<h1 class="heading">Student <span>Login</span></h1>
		
		<div>
			<c:if test="${not empty score}">
				<c:forEach var="map" items="${score}" varStatus="status">
					<p>Total Score ${map.key}</p>
					<p>Your Score ${map.value}</p>
				</c:forEach>
			</c:if>
		</div>
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
						</table>
										<div id="login">
										<div>${err}</div>
										<form:form action="${pageContext.request.contextPath}/institute/validateStudent" modelAttribute="adminDetails" name="adminform">
											<table>
												<tr>
													<td>Registration No.:</td>
													<td><input type="text" name="registration" required="required" /></td>
												</tr><tr>
													<td>Key Code:</td>
													<td><input type="text" name="keycode" required="required"/></td>
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

