<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<td width="71%" valign="top">
		<h1 class="heading admin_heading">Students <span>List</span></h1>
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0" style="background-color: white;" class="tableList table_bottom">
								<thead>
									<tr>
										<td>S.No</td>
										<td>Registration No.</td>
										<td>Student Name</td>
										<td>Contact</td>
										<td>DOB</td>
										<td>Email</td>
										<td>Stream</td>
									</tr>
								</thead>
						<c:choose>
							<c:when test="${not empty students}">
							<c:forEach var="student" items="${students}" varStatus="status">
								<tr class="tableData">
									<td>${status.index+1}</td>
									<td>${student.registration_no}</td>
									<td>${student.firstName} ${student.lastName}</td>
									<td>${student.contact}</td>
									<td>${student.dob}</td>
									<td>${student.email}</td>
									<td>${student.stream}</td>
								</tr>
							</c:forEach>
							</c:when>
						</c:choose>
							</table>
						<%-- <a href="${pageContext.request.contentType}/admin/next" class="pagination">Next</a> --%>
						</td>
	
</body>


