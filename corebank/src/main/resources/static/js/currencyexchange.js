const dropList = document.querySelectorAll("form select"),
fromCurrency = document.querySelector(".from select"),
toCurrency = document.querySelector(".to select"),
getButton = document.querySelector("form button");

for (let i = 0; i < dropList.length; i++) {
    for(let currency_code in country_list){
        // selecting USD by default as FROM currency and EUR as TO currency
        let selected = i == 0 ? currency_code == "USD" ? "selected" : "" : currency_code == "EUR" ? "selected" : "";
        // creating option tag with passing currency code as a text and value
        let optionTag = `<option value="${currency_code}" ${selected}>${currency_code}</option>`;
        // inserting options tag inside select tag
        dropList[i].insertAdjacentHTML("beforeend", optionTag);
    }
    dropList[i].addEventListener("change", e =>{
        loadFlag(e.target); // calling loadFlag with passing target element as an argument
    });
}

function loadFlag(element){
    for(let code in country_list){
        if(code == element.value){ // if currency code of country list is equal to option value
            let imgTag = element.parentElement.querySelector("img"); // selecting img tag of particular drop list
            // passing country code of a selected currency code in a img url
            imgTag.src = `https://flagcdn.com/48x36/${country_list[code].toLowerCase()}.png`;
        }
    }
}

window.addEventListener("load", ()=>{
    getExchangeRate();
});

getButton.addEventListener("click", e =>{
    e.preventDefault(); //preventing form from submitting
    getExchangeRate();
});

const exchangeIcon = document.querySelector("form .icon");
exchangeIcon.addEventListener("click", ()=>{
    let tempCode = fromCurrency.value; // temporary currency code of FROM drop list
    fromCurrency.value = toCurrency.value; // passing TO currency code to FROM currency code
    toCurrency.value = tempCode; // passing temporary currency code to TO currency code
    loadFlag(fromCurrency); // calling loadFlag with passing select element (fromCurrency) of FROM
    loadFlag(toCurrency); // calling loadFlag with passing select element (toCurrency) of TO
    getExchangeRate(); // calling getExchangeRate
})

function getExchangeRate(){
}

function onFromCurrencyChange(){
    //We should update account list, exchange rate and exchange amount
    //call getAllActiveAccountsByCustomerNoAndCurrencyType service
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&commissionCode=" + fromCurrency;
    fetch(url)
        .then(response => response.json())
        .then(data => {
                console.log(data);
                let accountList = data;
                let accountListHtml = "";
                for (let i = 0; i < accountList.length; i++) {
                    accountListHtml += "<option value='" + accountList[i].accountNo + "'>" + accountList[i].accountNo + "</option>";
                }
                document.getElementById("fromAccountNo").innerHTML = accountListHtml;
            }
        );

    //Get the account list of the selected currency from
    getExchangeRate();
}

function onToChange(){
    //call getAllActiveAccountsByCustomerNoAndCurrencyType service
    const url = "http://localhost:8080/account/getAllActiveAccountsByCustomerNoAndCurrencyType?userId=" + userId + "&commissionCode=" + toCurrency;
    fetch(url)
        .then(response => response.json())
        .then(data => {
                console.log(data);
                let accountList = data;
                let accountListHtml = "";
                for (let i = 0; i < accountList.length; i++) {
                    accountListHtml += "<option value='" + accountList[i].accountNo + "'>" + accountList[i].accountNo + "</option>";
                }
                document.getElementById("fromAccountNo").innerHTML = accountListHtml;
            }
        );

    getExchangeRate();
}