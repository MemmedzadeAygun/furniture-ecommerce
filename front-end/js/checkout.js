
const token = localStorage.getItem('token');

document.getElementById('orderBtn').addEventListener('click', () => {

    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let state = document.getElementById('state').value;
    let address = document.getElementById('address').value;
    let city = document.getElementById('city').value;
    let phone = document.getElementById('phone').value;
    let email = document.getElementById('email').value;
    let cartNumber = document.getElementById('cartNumber').value;
    let zipCode = document.getElementById('zipCode').value;
    let expiryMonth = document.getElementById('expiryMonth').value;
    let expiryYear = document.getElementById('expiryYear').value;

    let cartIds = JSON.parse(localStorage.getItem('cartIdss'));

    cartIds.map(cartId => {
        const order = {
            cartId: cartId,
            firstName: firstName,
            lastName: lastName,
            country: state,
            address: address,
            city: city,
            phone: phone,
            email: email,
            cartNumber: cartNumber,
            zipCode: zipCode,
            expiryMonth: expiryMonth,
            expiryYear: expiryYear
        }
        fetch(`http://localhost:8086/orders/add`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(order)
        })
        .then(async response => {
            if (response.ok) {
                let message = await response.text();
                alert(message);
    
                document.getElementById('firstName').value = "";
                document.getElementById('lastName').value = "";
                document.getElementById('state').value = "";
                document.getElementById('address').value = "";
                document.getElementById('city').value = "";
                document.getElementById('phone').value = "";
                document.getElementById('email').value = "";
                document.getElementById('cartNumber').value = "";
                document.getElementById('zipCode').value = "";
                document.getElementById('expiryMonth').value = "";
                document.getElementById('expiryYear').value = "";

                localStorage.removeItem('cartIdss');
            }
        })
    })

})