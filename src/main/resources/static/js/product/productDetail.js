const cart_elements = document.getElementsByClassName("cart");
Array.from(cart_elements).forEach(function(element) {
    element.addEventListener('click', function() {
        if(confirm("장바구니에 담으시겠습니까?")) {
            location.href = this.dataset.uri;
        };
    });
});