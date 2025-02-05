function registerUser(event){
	event.preventDefault(); // Would prevent values from being displayed in browser as default method is GET for form
	let form = document.forms.registerForm;
	let formData = new FormData(form).entries();
	fetch("http://localhost:8080/user/register",
	{
		method: "POST",
		body: JSON.stringify(Object.fromEntries(formData)),
		headers: {
			"Content-type": "application/json; charset=UTF-8"
		}
	})
	.then(response => response.text())
	.then(promise => displayContent(promise));
};
