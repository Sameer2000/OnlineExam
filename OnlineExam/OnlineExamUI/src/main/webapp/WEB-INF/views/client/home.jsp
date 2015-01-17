<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<td width="71%" valign="top">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
								<tr>
									<td><img
										src="${pageContext.request.contextPath}/resources/images/welcome.png"
										width="299" height="26" alt=""></td>
								</tr>
								<tr>
									<td><img
										src="${pageContext.request.contextPath}/resources/images/center.png"
										width="299" height="26" alt="" style="margin-left: -6px;"></td>
								</tr>
						</table>
										<div id="login">
										<form:form action="${pageContext.request.contextPath}/validate" modelAttribute="">
											<table>
												<tr>
													<td>Center Code	:</td>
													<td><input type="text" name="username"/></td>
												</tr><tr>
													<td>Center Password:</td>
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


<script>
	$(document).ready(function(){
		alert('hello');
	});
</script>















