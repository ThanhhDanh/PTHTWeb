function deleteProduct(endpoint, id) {
    if (confirm("Are you sure... ?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`product${id}`);
                d.style.display = "none";
            } else {
                alert("Something Wrong!");
            }

        });
    }

}