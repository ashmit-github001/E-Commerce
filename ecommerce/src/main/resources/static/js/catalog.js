const displayProducts = (products, userKeywords) => {
	console.log("Products = " + products);
	const catalogDiv = document.querySelector('.products-container');
	
	if(userKeywords != null){
		[... catalogDiv.children].forEach(c => c.remove());
	}
	
	products.forEach(product => {
		console.log(product);
		const productDiv = document.createElement('div');
		productDiv.setAttribute("class", "product-div");
		
		const productName = document.createElement('h4');
		productName.id = "product-name";
		productName.innerText = `${product.name}`;
		productDiv.appendChild(productName);
		
		const productSeller = document.createElement('p');
		productSeller.id = "product-seller";
		productSeller.innerHTML = `Sold by: <b>${product.seller}</b>`;
		productDiv.appendChild(productSeller);
		
		const productImage = document.createElement('img');
		productImage.id = "product-image";
		productImage.innerHTML = `${product.image}`;
		productDiv.appendChild(productImage);
		
		const productPrice = document.createElement('h4');
		productPrice.id = "product-price";
		productPrice.innerText = `Rs. ${product.price}`;
		productDiv.appendChild(productPrice);
		
		const addToCartButton = document.createElement('input');
		addToCartButton.type = "button";
		addToCartButton.id = "add-to-card";
		addToCartButton.value = "Add to Cart";
		addToCartButton.onclick = addtoCart(product);
		productDiv.appendChild(addToCartButton);
		
		catalogDiv.appendChild(productDiv);
	});
};

function fetchAllProducts() {
	fetch('http://localhost:8080/allProducts')
		.then(response => response.json())
		.then(products => displayProducts(products, null));
};

function fetchProductsByKeywords(event){
	event.preventDefault();
	const userKeywords = document.getElementById("product-keywords").value;
	fetch(`http://localhost:8080/getProductsByKeywords?keywords=${userKeywords}`)
	.then(response => response.json())
	.then(products => displayProducts(products, userKeywords));
};

function addtoCart(product) {
	
};