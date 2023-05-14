const fromCurrencyList = document.querySelector(".from select"),
    toCurrencyList = document.querySelector(".to select");

let fromIcon = document.querySelector(".from img"),
    toIcon = document.querySelector(".to img");

fillCurrencyLists();
onToFlagChange();
onFromFlagChange();

function fillCurrencyLists() {
    for (let currency_code in country_list) {
        //select tag for from and to
        let fromOptionTag = `<option value="${currency_code}">${currency_code}</option>`;
        //select PLN as default from currency
        if (currency_code === "PLN") {
            fromOptionTag = `<option value="${currency_code}" selected>${currency_code}</option>`;
        }
        let toOptionTag = `<option value="${currency_code}">${currency_code}</option>`;
        //select USD as default to currency
        if (currency_code === "USD") {
            toOptionTag = `<option value="${currency_code}" selected>${currency_code}</option>`;
        }
        // inserting option tag inside select tag
        fromCurrencyList.insertAdjacentHTML("beforeend", fromOptionTag);
        toCurrencyList.insertAdjacentHTML("beforeend", toOptionTag);
    }
}

function onFromFlagChange() {
    loadFlagForFrom(fromCurrencyList);
    onFromCurrencyChange();
}

function onToFlagChange() {
    loadFlagForTo(toCurrencyList);
    onToCurrencyChange();
}

function loadFlagForFrom(element) {
    console.log(element.value + " element.value");
    for (let code in country_list) {
        if (code === element.value) { // if currency code of country list is equal to option value

            fromIcon = document.querySelector(".from img"); // selecting img tag of particular drop list
            // passing country code of a selected currency code in an img url
            fromIcon.src = `https://flagcdn.com/48x36/${country_list[code].toLowerCase()}.png`;
        }
    }
}

function loadFlagForTo(element) {
    console.log(element.value + " element.value");
    for (let code in country_list) {
        if (code === element.value) { // if currency code of country list is equal to option value

            toIcon = document.querySelector(".to img"); // selecting img tag of particular drop list
            // passing country code of a selected currency code in an img url
            toIcon.src = `https://flagcdn.com/48x36/${country_list[code].toLowerCase()}.png`;
        }
    }
}

function getExchangeRate() {
    //get selected from currency
    const fromCurrency = document.getElementById("fromCurrency").value;
    //get selected to currency
    const toCurrency = document.getElementById("toCurrency").value;

    if (fromCurrency === toCurrency) {
        document.getElementById("exchangeRate").value = "1";
        onAmountChange();
        return;
    }
    //if fromCurrency or toCurrency is empty, then return
    if (fromCurrency === "" || toCurrency === "") {
        document.getElementById("exchangeRate").value = "0";
        onAmountChange();
        return;
    }

    const url = "http://localhost:8080/currencyRates/getCurrencyRates?fromCurrency=" + fromCurrency + "&toCurrency=" + toCurrency;
    fetch(url)
        .then(response => response.text())
        .then(result => {
            console.log("exchange rate: " + result);
            document.getElementById("exchangeRate").value = result;
            onAmountChange();
        })
        .catch(error => console.log('error', error));
}

function onFromCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;

    const fromCurrency = document.getElementById("fromCurrency").value;
    console.log("fromCurrency: " + fromCurrency);

    let accountListHtml = "";
    getExchangeRate();

    //Get the account list of the selected currency from, if the list is empty, then clear the list
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + fromCurrency;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                accountListHtml = "";
            }
            return response.json();
        })
        .then(fromAccounts => {
            console.log(fromAccounts);
            let accountList = fromAccounts;
            if (accountList.length > 0) {
                for (let i = 0; i < accountList.length; i++) {
                    accountListHtml += "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + " (" + accountList[i].accountName + ")" + "</option>";
                }
            } else {
                accountListHtml = "";
            }
            document.getElementById("fromAccount").innerHTML = accountListHtml;
        })
    document.getElementById("fromAccount").innerHTML = accountListHtml;
}

function onToCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;

    const toCurrency = document.getElementById("toCurrency").value;

    console.log("toCurrency: " + toCurrency);

    let accountListHtml = "";
    getExchangeRate();

    //Get the account list of the selected currency from, if the list is empty, then clear the list
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + toCurrency;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                accountListHtml = "";
            }
            return response.json();
        })
        .then(toAccounts => {
            console.log(toAccounts);
            let accountList = toAccounts;
            if (accountList.length > 0) {
                for (let i = 0; i < accountList.length; i++) {
                    accountListHtml += "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + " (" + accountList[i].accountName + ")" + "</option>";
                }
            } else {
                accountListHtml = "";
            }
            document.getElementById("toAccount").innerHTML = accountListHtml;
        })
    document.getElementById("toAccount").innerHTML = accountListHtml;
}

function onAmountChange(){
    console.log("onAmountChange");
    const amount = document.getElementById("amount").value;
    const exchangeRate = document.getElementById("exchangeRate").value;
    console.log("amount: " + amount);
    console.log("exchangeRate: " + exchangeRate);
    console.log("exchangeAmount: " + amount * exchangeRate);
    document.getElementById("exchangeAmount").value = amount * exchangeRate;
}