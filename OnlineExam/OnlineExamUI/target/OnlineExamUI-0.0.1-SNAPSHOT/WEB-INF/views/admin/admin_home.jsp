<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<td width="71%" valign="top">
		<h1 class="heading admin_heading">Institute <span>List</span></h1>
			<a href="${pageContext.request.contextPath}/admin/institute_registration" class="pagination" style="margin-top: -24px;">Register Institute</a>
			<c:choose>
					<c:when test="${not empty institutes}">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0" style="background-color: white;" class="tableList table_bottom">
								<thead>
									<tr>
										<td>S.No</td>
										<td>Center Code</td>
										<td>Center Name</td>
										<td>Center Password</td>
										<td>Contact</td>
										<td>Login Key</td>
									</tr>
								</thead>
								
									<c:forEach var="institute" items="${institutes}" varStatus="status">
									<tr class="tableData">
										<td>${status.index+1}</td>
										<td>${institute.center_code}</td>
										<td>${institute.center_name}</td>
										<td>${institute.center_password}</td>
										<td>${institute.contact}</td>
										<td>${institute.login_key}</td>
									</tr>
									</c:forEach>
						</table>
						<%-- <a href="${pageContext.request.contentType}/student/next" class="pagination">Next</a> --%>
						</c:when>
						<c:otherwise>
							<div id="noData">
								<p>no Data Found</p>
							</div>
						</c:otherwise>
					</c:choose>
</td>
	
</body>


















