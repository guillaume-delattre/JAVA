<!DOCTYPE html>
<html>
	<head>
		<!-- jQuery from CDN -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	</head>
	<body>
		<p>Open the console and click "Add user" and "List users" to execute the tests</p>
		<br>
		<input type="text" id="user-first-name" value="John"><input type="text" id="user-last-name" value="Doe"><button id="add-user">Add user</button>
		<br>
		<button id="list-users">List users</button>
	
		<script type="text/javascript">
		
$("#add-user").click(function() {

	var userDTO = {firstName: $("#user-first-name").val(), lastName: $("#user-last-name").val()};
	
	console.log("--> POST test: post " + JSON.stringify(userDTO)) + " to URL user/save";
	
	$.ajax({
		method: 'POST',
		url: "user/save",
		contentType: 'application/json',
		data: JSON.stringify(userDTO)
	})
	.done(function(id) {
		
		console.log("<-- POST successful, received: created user id: " + id);
		
		console.log("--> GET test: get from URL user/get/" + id);
		
		$.get("user/get/" + id)
		.done(function(resultUserDTO) {
			console.log("<-- GET successful, received: " + JSON.stringify(resultUserDTO));
		});
	});
});
		
$("#list-users").click(function() {
	console.log("--> GET test: get from URL ajax/user/get-all-users");
	
	$.get("user/get-all-users")
	.done(function(resultUserDTOs) {
		console.log("<-- GET successful, received: " + JSON.stringify(resultUserDTOs));
	});
});
		
		</script>	
	</body>
</html>