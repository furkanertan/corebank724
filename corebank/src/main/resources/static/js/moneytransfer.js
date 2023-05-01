function onAmountChange() {
    // Get the value of the amount input field
    const amount = parseFloat(document.getElementById("amount").value);

    // Calculate the commission and total amounts
    const commission = amount * 0.1;
    const total = amount + commission;

    // Set the values of the commission and total input fields
    document.getElementById("commissionAmount").value = commission;
    document.getElementById("totalAmount").value = total;
}