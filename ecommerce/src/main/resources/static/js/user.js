function registerUser(event){
	event.preventDefault(); // Would prevent values from being displayed in browser as default method is GET for form
	console.log("here i am");
	let form = document.forms.registerForm;
	let formData = new FormData(form);
	fetch("http://localhost:8080/user/register",
	{
		method: "POST",
		body: JSON.stringify({
			"fullName": formData.get("fullName"),
			"email": formData.get("email"),
			"password": formData.get("password")
		}),
		headers: {
			"Content-type": "application/json; charset=UTF-8"
		}
	})
	.then(response => response.text())
	.then(promise => console.log(promise));
};
