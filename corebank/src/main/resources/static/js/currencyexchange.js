const dropList = document.querySelectorAll("form select"),
    getButton = document.querySelector("form button");

for (let i = 0; i < dropList.length; i++) {
    for (let currency_code in country_list) {
        // selecting USD by default as FROM currency and EUR as TO currency
        let selected = i == 0 ? currency_code == "USD" ? "selected" : "" : currency_code == "EUR" ? "selected" : "";
        // creating option tag with passing currency code as a text and value
        let optionTag = `<option value="${currency_code}" ${selected}>${currency_code}</option>`;
        // inserting options tag inside select tag
        dropList[i].insertAdjacentHTML("beforeend", optionTag);
    }
    dropList[i].addEventListener("change", e => {
        loadFlag(e.target); // calling loadFlag with passing target element as an argument
    });
}

function loadFlag(element) {
    for (let code in country_list) {
        if (code == element.value) { // if currency code of country list is equal to option value
            let imgTag = element.parentElement.querySelector("img"); // selecting img tag of particular drop list
            // passing country code of a selected currency code in a img url
            imgTag.src = `https://flagcdn.com/48x36/${country_list[code].toLowerCase()}.png`;
        }
    }
}

window.addEventListener("load", () => {
    getExchangeRate();
});

getButton.addEventListener("click", e => {
    e.preventDefault(); //preventing form from submitting
    getExchangeRate();
});

function getExchangeRate() {
}

function onFromCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;
    console.log(userId);

    const fromCurrency = document.getElementById("fromCurrency").value;

    //Get the account list of the selected currency from
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + fromCurrency;
    fetch(url)
        .then(response => response.json())
        .then(fromAccounts => {
            console.log(fromAccounts);
            let accountList = fromAccounts;
            let accountListHtml = "<option value= '"+ + "'>" + "-- Select From Account --" + "</option>";
            for (let i = 0; i < accountList.length; i++) {
                accountListHtml += "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + "</option>";
            }
            document.getElementById("fromAccount").innerHTML = accountListHtml;
        })
        .catch(error => console.log(error));

    getExchangeRate();
}


function onToCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;
    console.log(userId);

    const toCurrency = document.getElementById("toCurrency").value;

    //Get the account list of the selected currency from
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + toCurrency;
    fetch(url)
        .then(response => response.json())
        .then(toAccounts => {
            console.log(toAccounts);
            let accountList = toAccounts;
            let accountListHtml = "<option value= '"+ + "'>" + "-- Select To Account --" + "</option>";
            for (let i = 0; i < accountList.length; i++) {
                accountListHtml += "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + "</option>";
            }
            document.getElementById("fromAccount").innerHTML = accountListHtml;
        })
        .catch(error => console.log(error));

    getExchangeRate();
}