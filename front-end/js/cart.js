function loadOnTable(){
    const token = localStorage.getItem('token');

    fetch(`http://localhost:8086/cart/getCart`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        let data = await response.json();
        console.log(data);

        let tableContent = '';

        let total = 0;

        data.forEach(cart => {
            total += cart.subTotal;
            tableContent += `
                <tr>
                    <td>
                        <div style="display:flex; align-items:center; gap:10px;">
                            <img src="${cart.product.image}" style="width:80px; height:70px;object-fit:cover;"/ >
                            ${cart.product.name}
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          ${cart.product.price} AZN
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          <input type="number" min="1" value="${cart.quantity}" style="width: 50px;">
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          ${cart.subTotal} AZN
                        </div>
                    </td>
                    <td>
                        <div>
                            <img src="./image/bin.png" style="width:25px; height:25px; object-fir:cover;" />
                        </div>
                    </td>
                </tr>
            `
        });
        
        document.getElementById('tbody').innerHTML = tableContent;
        document.querySelector('.subtotal p').textContent = total;
        document.querySelector('.total p').textContent = total;
    })
}

loadOnTable();