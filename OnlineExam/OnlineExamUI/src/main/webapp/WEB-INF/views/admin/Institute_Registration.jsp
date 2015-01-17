<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<td width="71%" valign="top">
		<h1 class="heading admin_heading">Institute <span>Form</span></h1>
					<form:form action="${pageContext.request.contextPath}/admin/save_institute" name="instituteform" modelAttribute="institute_reg">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
								<tr class="tableData">
									<td>Institute Name: </td>
									<td><input type="text" name="center_name"/></td>
								</tr>
								<tr class="tableData">
									<td>Create Institute Password: </td>
									<td><input type="password" name="center_password"/></td>
								</tr>
								<tr class="tableData">
									<td>Contact Number: </td>
									<td><input type="text" name="contact"/></td>
								</tr>
								<tr class="tableData">
									<td>Address: </td>
									<td><textarea rows="4" cols="70" name="address"></textarea></td>
								</tr>
								<tr class="tableData">
									<td>Street No: </td>
									<td><input type="text" name="street" /></td>
								</tr>
								<tr class="tableData">
									<td>State: </td>
									<td>
										<select name="state">
											<c:forEach var="state" items="${states}" varStatus="status">
												<option value="${state.state}">${state.state}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr class="tableData">
									<td>Pincode: </td>
									<td><input type="text" name="pincode" /></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Submit"></td>
								</tr>
							</table>
							</form:form>
</td>
	
</body>
