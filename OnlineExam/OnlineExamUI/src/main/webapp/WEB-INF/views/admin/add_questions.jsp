<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	function saveQuestions(){
		if($('#ques').val() != "" && $('.option').val() != ""){
		var url = '${pageContext.request.contextPath}/rest/saveQuestion';
		var option = $(".option").map(function(){ // use this code to get the value of same name & return as list
 	    	return $(this).val();
		}).get().join(",");
		$.ajax({
			url: url,
			type: 'POST',
			data: {question: $('#ques').val(), options: option, correct: $('input[type="radio"]:checked').val()},
			success: function(response, status){
				$('#ques').val("");
				$('.option').val("");
				$('.message').attr('style', 'display: block');
				$('.message').html('Question has been saved successfully').fadeOut(3000, function(){
					$('#no').html(response);
				});
			},
			error: function(error, status){
				$('.message').html('Question is not saved..!').fadeOut(3000, function(){
				});
			}
		});
		}
		else{
			alert('please fill all the details');
		}
		
	}
</script>

<td width="71%" valign="top" onload="myFunction();">
	<h3 class="heading admin_heading message" style="display: none;"></h3>
	<h1 class="heading admin_heading" style="margin-bottom: 55px;font-size: 15px;">No. of <span>Saved Questions: <span id="no">0</span></span>${no}</h1>
		<h1 class="heading admin_heading">Add <span>Questions</span></h1>
				<form:form action="${pageContext.request.contextPath}/rest/saveQuestion?q=submit">
				<input type="hidden" name="id" value="${id}"/>
					<div id="questions">	
						<ul>
							<li><textarea rows="3" cols="100" placeholder="Add Question" required="required" name="question" id="ques"></textarea>
							</li>
							
							<h3 class="heading options">Options </h3>
							<li><input type="text" placeholder="Option 1" name = "options" class="option" required="required"/><input type="radio" name="correct" value="1" checked="checked"/> Correct Answer</li>
							<li><input type="text" placeholder="Option 2" name = "options" class="option" required="required"/><input type="radio" name="correct" value="2"/> Correct Answer</li>
							<li><input type="text" placeholder="Option 3" name = "options" class="option" required="required"/><input type="radio" name="correct" value="3"/> Correct Answer</li>
							<li><input type="text" placeholder="Option 4" name = "options" class="option" required="required"/><input type="radio" name="correct" value="4"/> Correct Answer</li>
							<li><input type="reset" class="pagination left" value="Reset"/></li>
							<li><input type="button" class="pagination left" value="Add More Question" onclick="saveQuestions();"/></li></br></br></br></br>
							<li><input type="submit" class="pagination left" value="Save All Questions"/></li>
						</ul>
					</div>
				</form:form>
</body>


