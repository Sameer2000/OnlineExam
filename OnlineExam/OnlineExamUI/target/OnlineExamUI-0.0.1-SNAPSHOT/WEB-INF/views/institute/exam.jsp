<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script>
	function save(reg) {
		$('#examId').submit();
		window.opener.location.href = "student-exam?reg="+reg;
		window.close();
	}
</script>

<script>
	$(document).on("keydown", disableRefresh);
	function disableRefresh(e){
		if( (e.which || e.keycode) == 116){
			e.preventDefault();
		}
	}
</script>

<!-- <script>
	function confirm(){
	
	}
</script> -->


<!-- <script type="text/javascript">
	window.onbeforeunload = function(){
		return "Exam Will Cancel if u leave this page without Submit..!";
	}
</script> -->

<!-- <script type="text/javascript">
window.onbeforeunload = function (event) {
    var message = 'Exam Will Cancel if u leave this page without Submit..!';
    if (typeof event == 'undefined') {
        event = window.event;
    }
    if (event) {
        event.returnValue = message;
    }
    return message;
};
    $('#sub').click(function () {
        window.onbeforeunload = function(){ return 'submit'; }
        });
</script> -->



<c:set var="remainingTime" value="${exam.time}"/>

<script>
	var timeout = ${remainingTime}
	//$('#clock').val(timeout);
	function timer() {
		if (--timeout > 0) {
			// use below line.remember every . is name...
			//document.examForm.clock.value = timeout;
			$('#clock').val(timeout);
			window.setTimeout("timer()", 1000);
		} else {
			$('#clock').val('Time over');
			///disable submit-button etc 
		}
	}
</script>

<script>
	$(document).ready(function() {
		$(document).on("contextmenu",function(e){
        if(e.keycode == 2)
             e.preventDefault();
     	});	
	});
</script>

<script>
	timer();
</script>



</br></br></br></br></br></br></br></br></br></br></br></br></br></br>

<td width="71%" valign="top" style="position: relative; top: -235px;">
				<form:form action="${pageContext.request.contextPath}/institute/submitExam" name="exam" method="post" modelAttribute="examForm" id="examId">
				<input type="hidden" name="reg" value="${reg}"/>
				<p>Subject : ${exam.subjectName}<input type="hidden" name="subjectName" value="${exam.subjectName}"/>  </p>
				<div id="time" style="margin-bottom: 65px;">
				 	Time remaining: <input type="button" id="clock" value="${remainingTime-1}" disabled="disabled"/>
				 					<input type="hidden" name="time" value="${exam.time}"/>
				 </div>
				 
				 <c:forEach var="form" items="${exam.questionFormsList}" varStatus="qStatus">
				 	<p>Question: ${qStatus.index+1}	
				 			 <p class="examQ">${form.question}<input type="hidden" name="questionFormsList[${qStatus.index}].question" value="${form.question}"/></p>
				 		<ul id="examUl">
				 			<c:forEach var="option" items="${form.options}" varStatus="opStatus">
								<li><input type="radio" name = "questionFormsList[${qStatus.index}].answer" value="${option}" class="eoption" />${option}</li>
							</c:forEach>					 				
				 		</ul>
				 </c:forEach>
				 </br></br></br></br></br>
				 <input type="submit" value="Submit Exam" onclick="save(${reg});">
				</form:form>

</body>
