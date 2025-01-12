function onPageLoad() {
	fetch('http://localhost:8080/allProducts')
		.then(response => response.json())
		.then(products => displayProducts(products));

	const displayProducts = products => {
		const catalogDiv = document.querySelector('.products-container');
		
		products.forEach(product => {
			console.log(product);
			const itemDiv = document.createElement('div');
			itemDiv.setAttribute("class", "item-div");
			
			const productName = document.createElement('h4');
			productName.id = "item-name";
			productName.innerText = `${product.name}`;
			itemDiv.appendChild(productName);
			
			const productSeller = document.createElement('p');
			productSeller.id = "item-seller";
			productSeller.innerHTML = `Sold by: <b>${product.seller}</b>`;
			itemDiv.appendChild(productSeller);
			
			const productImage = document.createElement('img');
			productImage.id = "item-image";
			productImage.innerHTML = `${product.image}`;
			itemDiv.appendChild(productImage);
			
			const productPrice = document.createElement('h4');
			productPrice.id = "item-price";
			productPrice.innerText = `Rs. ${product.price}`;
			itemDiv.appendChild(productPrice);
			
			const addToCartButton = document.createElement('input');
			addToCartButton.type = "Submit";
			addToCartButton.id = "add-to-card";
			addToCartButton.value = "Add to Cart";
			itemDiv.appendChild(addToCartButton);
			
			catalogDiv.appendChild(itemDiv);
		});
	}
}