function onAmountChange() {
    // Get the value of the account input field
    const fromAccount = document.getElementById("fromAccount").value;

    //Get the value of the amount input field
    const amount = parseFloat(document.getElementById("amount").value);
    let commissionCode = "EFT";

    const commissionCodeUrl = "http://209.38.210.220:8080/account/getAccountCurrencyType?accountNumber=" + fromAccount;
    fetch(commissionCodeUrl)
        .then(response => response.text())
        .then(commissionVal => {
            commissionCode = commissionCode + commissionVal;
            console.log(commissionCode);

            const url = "http://209.38.210.220:8080/commission/calculate?fromAccount=" + fromAccount + "&commissionCode=" + commissionCode + "&amount=" + amount;
            fetch(url)
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Network response was not ok.');
                    }
                })
                .then(data => {
                    document.getElementById("commissionAmount").value = data;
                    document.getElementById("totalAmount").value = amount + data;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function onAccountChange() {
    // Get the value of the account input field
    const fromAccount = document.getElementById("fromAccount").value;

    //Get the value of the amount input field
    const amount = parseFloat(document.getElementById("amount").value);
    let commissionCode = "EFT";

    const commissionCodeUrl = "http://209.38.210.220:8080/account/getAccountCurrencyType?accountNumber=" + fromAccount;
    fetch(commissionCodeUrl)
        .then(response => response.text())
        .then(commissionVal => {
            commissionCode = commissionCode + commissionVal;
            console.log(commissionCode);

            const url = "http://209.38.210.220:8080/commission/calculate?fromAccount=" + fromAccount + "&commissionCode=" + commissionCode + "&amount=" + amount;
            fetch(url)
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Network response was not ok.');
                    }
                })
                .then(data => {
                    document.getElementById("commissionAmount").value = data;
                    document.getElementById("totalAmount").value = amount + data;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}