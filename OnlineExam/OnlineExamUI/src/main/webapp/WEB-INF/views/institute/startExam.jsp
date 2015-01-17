<!DOCTYPE td PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	function popup(time, reg){
		var newWindow = window.open('exam?time='+time+'&reg='+reg, 'Student Exam', 'width=796,height=610,directories=no,menubar=no,toolbar=no,scrollbars=no,location=no,resizable=no,titlebar=no');
		disable();
	}
</script>

<script>
	function disable(){
		$('input[type="button"]').attr('disabled', 'disabled');
	}
</script>
	
<td width="71%" valign="top" style="padding-left: 16em;">
		<h1 class="heading">Subject: <span>${subject.subject_name}</span></h1>
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
						</table>
										<div id="login">
											<table>
												<tr>
													<td><input type="button" value="Start Exam" onclick="popup(${time}, ${reg});"></td>
													<td><input type="button" value="Cancel" /></td>
											</table>
										</div>
						
						</td>
	
</body>

