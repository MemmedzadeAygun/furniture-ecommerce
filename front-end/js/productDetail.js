function getProduct(){
    let token = localStorage.getItem('token');

    let urlParams = new URLSearchParams(window.location.search);
    let productId = urlParams.get('id');

    fetch(`http://localhost:8086/products/getById/${productId}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        let object = await response.json();
        console.log(object);
        
        let img = document.querySelector('.left-side img');
        img.src = object.image;

        let h3 = document.querySelector('.right-side h3');
        h3.textContent = object.name;

        let p = document.querySelector('.right-side p');
        p.textContent = object.price + " AZN";
    })
}

getProduct()