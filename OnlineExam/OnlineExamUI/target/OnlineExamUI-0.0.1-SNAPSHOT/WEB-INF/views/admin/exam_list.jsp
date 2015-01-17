<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<td width="71%" valign="top">
		<h1 class="heading admin_heading">Exams <span>List</span></h1>
			<a href="${pageContext.request.contextPath}/admin/createExam" class="pagination" style="margin-top: -24px;">Create Exam</a>
			<c:choose>
					<c:when test="${not empty exams}">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0" style="background-color: white;" class="tableList table_bottom">
								<thead>
									<tr>
										<td>S.No</td>
										<td>Exam Code</td>
										<td>Subject</td>
										<td>Stream</td>
										<td>Exam Date</td>
										<td>Created On</td>
										<td>Created By</td>
										<td>Time Duration</td>
										<td>Exam Status</td>
									</tr>
								</thead>
						
							<%-- <c:set var="question" value="${exams.questions}" scope="request"/> --%>
							<c:forEach var="exam" items="${exams}" varStatus="status">
								<tr class="tableData">
									<td>${status.index+1}</td>
									<td>${exam.examCode}</td>
									<td>${exam.subjectName}</td>
									<td>${exam.stream}</td>
									<td>${exam.examdate}</td>
									<td>${exam.createdOn}</td>
									<td>${exam.createdBy}</td>
									<td>${exam.time}</td>
									<td>${exam.examStatus}</td>
									<td><a href="${pageContext.request.contextPath}/admin/deleteExam?id=${exam.id}">delete</a></td>
								</tr>
							</c:forEach>
							</table>
							</c:when>
							<c:otherwise>
							<div id="noData">
								<p>no Data Found</p>
							</div>
						</c:otherwise>
						</c:choose>
						<%-- <a href="${pageContext.request.contentType}/admin/next" class="pagination">Next</a> --%>
						</td>
	
</body>


