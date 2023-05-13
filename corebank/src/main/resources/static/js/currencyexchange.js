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
    getExchangeRate();
    onFromCurrencyChange();
}

function onToFlagChange() {
    loadFlagForTo(toCurrencyList);
    getExchangeRate();
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
    onAmountChange();

    if (fromCurrency === toCurrency) {
        document.getElementById("exchangeRate").value = "1";
        return;
    }
    //if fromCurrency or toCurrency is empty, then return
    if (fromCurrency === "" || toCurrency === "") {
        document.getElementById("exchangeRate").value = "0";
        return;
    }

    const url = "http://localhost:8080/currencyRates/getCurrencyRates?fromCurrency=" + fromCurrency + "&toCurrency=" + toCurrency;
    fetch(url)
        .then(response => response.text())
        .then(result => {
            console.log("exchange rate: " + result);
            document.getElementById("exchangeRate").value = result;
        })
        .catch(error => console.log('error', error));
    onAmountChange();
}

function onFromCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;

    const fromCurrency = document.getElementById("fromCurrency").value;
    console.log("fromCurrency: " + fromCurrency);

    let accountListHtml;

    //Get the account list of the selected currency from, if the list is empty, then clear the list
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + fromCurrency;
    fetch(url)
        //if response fromAccount is not empty, then populate the list
        .then(response => response.json())
        .then(fromAccounts => {
            console.log(fromAccounts);
            let accountList = fromAccounts;
            for (let i = 0; i < accountList.length; i++) {
                accountListHtml += "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + " (" + accountList[i].accountName + ")" + "</option>";
            }
            document.getElementById("fromAccount").innerHTML = accountListHtml;
        })
        //if response fromAccount is not empty, then set empty option
        .catch(document.getElementById("fromAccount").innerHTML = accountListHtml);
    getExchangeRate();
}

function onToCurrencyChange() {
    // Get userId from hidden input
    const userId = document.getElementById("userId").value;

    const toCurrency = document.getElementById("toCurrency").value;

    console.log("toCurrency: " + toCurrency);

    let accountListHtml;

    //Get the account list of the selected currency from, if the list is empty, then clear the list
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&currencyType=" + toCurrency;
    fetch(url)
        //if response toAccount is not empty, then populate the list
        .then(response => response.json())
        .then(toAccounts => {
            console.log(toAccounts);
            let accountList = toAccounts;
            for (let i = 0; i < accountList.length; i++) {
                accountListHtml = "<option value='" + accountList[i].accountNumber + "'>" + accountList[i].accountNumber + " - " + accountList[i].currencyType + " (" + accountList[i].accountName + ")" + "</option>";
            }
            document.getElementById("toAccount").innerHTML = accountListHtml;
        })
        //catch error
        .catch(document.getElementById("toAccount").innerHTML = accountListHtml);
    getExchangeRate();
}

function onAmountChange(){
    const amount = document.getElementById("amount").value;
    const exchangeRate = document.getElementById("exchangeRate").value;
    document.getElementById("exchangeAmount").value = amount * exchangeRate;
}