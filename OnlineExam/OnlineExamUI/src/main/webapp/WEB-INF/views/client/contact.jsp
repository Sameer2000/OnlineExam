<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
  function initialize() {
  	var address = 'London, UK';
    var mapCanvas = document.getElementById('map_canvas');
    var mapOptions = {
      zoom: 2,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };	
    var map = new google.maps.Map(mapCanvas, mapOptions);
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({
      'address': address
   },
   function(results, status) {
      if(status == google.maps.GeocoderStatus.OK) {
         new google.maps.Marker({
            position: results[0].geometry.location,
            map: map
         });
         map.setCenter(results[0].geometry.location);
      }
      else {
         // Google couldn't geocode this request. Handle appropriately.
      }
   });
    
}
  google.maps.event.addDomListener(window, 'load', initialize);
</script>
<td width="71%" valign="top">
						<table width="100%" border="0"
								cellspacing="10" cellpadding="0">
								<tr>
									<td class="heading">Contact <span>us</span></td>
								</tr>
								<c:if test="${not empty msg}">
									<tr>
										<td>${msg}</td>
									</tr>
								</c:if>
								<tr>
						</table>
										<div id="login">
										<form:form action="${pageContext.request.contextPath}/submitQuery" name="contactForm" method="post" modelAttribute="query">
											<table>
												<tr>
													<td>Email:</td>
													<td><input type="email" name="email" required="required"/></td>
												</tr><tr>
													<td>Message:</td>
													<td><textarea rows="4" cols="70" required="required" name="message"></textarea></td>
												</tr>
												<tr>
													<td></td>
													<td><input type="submit" value="Submit"/></td>
												</tr>
											</table>
											</form:form>
										</div>
										<div id="map_canvas">
											
										</div>
						
						</td>
	
</body>

