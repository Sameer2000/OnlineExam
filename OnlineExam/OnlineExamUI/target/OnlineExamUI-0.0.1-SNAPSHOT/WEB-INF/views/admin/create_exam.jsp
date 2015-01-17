<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script>
	function subjects() {
		var s = $('#stream').val();
		var url = '${pageContext.request.contextPath}/rest/subjects/'+s;
		$.ajax({
			url: url,
			method: 'GET',
			success: function(data, status){
				var j = JSON.parse(data);
				var length = j.length;
				var subjectHTML = "";
				subjectHTML = '<select name="subjectName" onchange="showDate();"><option>Select Subject</option>)';
				for (var i = 0; i < length; i++) {
					 subjectHTML = subjectHTML + ( '<option value="'+j[i].id+'">'+j[i].subject_name+'</option>' );
				}
				subjectHTML = subjectHTML + ( '</select>' ); 
				$('#sub').html(subjectHTML);
			},
			error: function(data, status){
				alert(data+' '+status);
			}
		});
	}
</script>

<script>
	function showDate(){
		$('input[type="date"]').attr('style', 'style="display: inline;"');
	}
</script>
<script>
	function showTime(){
		$('#duration').attr('style', 'style="display: inline;"');
	}
</script>


<td width="71%" valign="top">
		<h1 class="heading admin_heading">
		Exams <span>List</span>
	</h1>
	<form:form action="${pageContext.request.contextPath}/admin/completeExam" method="post" name="examform" modelAttribute="exam">
	<table width="100%" border="0" cellspacing="10" cellpadding="0"
		style="background-color: white; margin-bottom: 100px" class="tableList table_bottom">
		<thead>
			<tr>
				<td>Exam Code</td>
				<td>Stream</td>
				<td>Subject</td>
				<td>Exam Date</td>
				<td>Time Duration</td>
			</tr>
		</thead>
		<tr class="tableData">
		<input type="hidden" name="code" value="${code}"/>
			<td>${code}</td>
			<td>
				<select name="stream" onchange="subjects();" id="stream">
					<option value="">Select Stream</option>
					<c:forEach var="streams" items="${stream}" varStatus="status">
						<option value="${streams}">${streams}</option>
					</c:forEach>
				</select>
			</td>
			<td id="sub"></td>
			<td><input type="date" name="date" required="required" style="display: none;" onchange="showTime();"/></td>
			<td><select name="time" required="required" style="display: none;" id="duration" onchange="examform.submit();">
				<option>0:30</option>
				<option>1:00</option>
				<option>1:30</option>
				<option>2:00</option>
				<option>2:30</option>
				<option>3:00</option>
			</select> Minutes</td>
		</tr>

	</table>
	</form:form>
						</td>
	
</body>


