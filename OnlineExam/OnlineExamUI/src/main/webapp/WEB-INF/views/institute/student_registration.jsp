<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<td width="71%" valign="top">
		<h1 class="heading admin_heading">Student Registration <span>Form</span></h1>
					<form:form action="${pageContext.request.contextPath}/institute/save_student" name="studentForm" modelAttribute="student_reg">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
								<tr class="tableData">
									<td>First Name: </td>
									<td><input type="text" name="firstName" required="required"/></td>
								</tr>
								<tr class="tableData">
									<td>Last Name: </td>
									<td><input type="text" name="lastName"/></td>
								</tr>
								<tr class="tableData">
									<td>Date of Birth: </td>
									<td><input type="date" name="dob" required="required"/></td>
								</tr>
								<tr class="tableData">
									<td>Contact Number: </td>
									<td><input type="text" name="contact" required="required"/></td>
								</tr>
								<tr class="tableData">
									<td>Email: </td>
									<td><input type="email" name="email" required="required"/></td>
								</tr>
								<tr class="tableData">
									<td>Stream: </td>
									<td>
										<select name="stream" required="required">
												<c:forEach var="stream" items="${streams}" varStatus="status">
													<option value="${stream}">${stream}</option>
												</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Submit"></td>
								</tr>
							</table>
							</form:form>
</td>
	
</body>
