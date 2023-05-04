function onAmountChange() {
    // Get the value of the account input field
    const fromAccount = document.getElementById("fromAccount").value;

    //Get the value of the amount input field
    const amount = parseFloat(document.getElementById("amount").value);

    //Get commission code
    //TODO: get commission code from a variable
    const commissionCode = "EFTPLN";

    //call calculateCommissionAmount service
    const url = "http://localhost:8080/commission/calculate?fromAccount=" + fromAccount + "&commissionCode=" + commissionCode + "&amount=" + amount;
    fetch(url)
        .then(response => response.json())
        .then(data => {
                document.getElementById("commissionAmount").value = data;
                document.getElementById("totalAmount").value = amount + data;
            }
        );
}

function onAccountChange() {
    // Get the value of the account input field
    const fromAccount = document.getElementById("fromAccount").value;

    //Get the value of the amount input field
    const amount = parseFloat(document.getElementById("amount").value);

    //Get commission code
    //TODO: get commission code from a variable
    const commissionCode = "EFTPLN";

    //call calculateCommissionAmount service
    const url = "http://localhost:8080/commission/calculate?fromAccount=" + fromAccount + "&commissionCode=" + commissionCode + "&amount=" + amount;
    fetch(url)
        .then(response => response.json())
        .then(data => {
                console.log(data);
                document.getElementById("commissionAmount").value = data;
                document.getElementById("totalAmount").value = amount + data;
            }
        );
}