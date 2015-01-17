<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<td width="71%" valign="top">
		<h1 class="heading admin_heading">View <span>Queries</span></h1>
			<c:choose>
					<c:when test="${not empty queries}">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0" style="background-color: white;" class="tableList table_bottom">
								<thead>
									<tr>
										<td>S.No</td>
										<td>Email</td>
										<td>Message</td>
										<td>Submitted On</td>
										<td>Submitted Time</td>
									</tr>
								</thead>
								
									<c:forEach var="query" items="${queries}" varStatus="status">
									<tr class="tableData">
										<td>${status.index+1}</td>
										<td>${query.email}</td>
										<td>${query.message}</td>
										<td>${query.createdOn}</td>
										<td>${query.createdTime}</td>
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
