// Description: Main JavaScript file for the application
// Get transaction type
const transactType = document.querySelector("#transact-type");

// Get Transaction forms
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawCard = document.querySelector(".withdraw-card");

transactType.addEventListener("change", () => {
  switch (transactType.value) {
    case "payment":
      paymentCard.style.display = "block";
      paymentCard.nextElementSibling.style.display = "none";
      transferCard.style.display = "none";
      depositCard.style.display = "none";
      withdrawCard.style.display = "none";
      break;
    case "transfer":
      transferCard.previousElementSibling.style.display = "none";
      transferCard.style.display = "block";
      paymentCard.style.display = "none";
      depositCard.style.display = "none";
      withdrawCard.style.display = "none";
      break;
    case "deposit":
      depositCard.previousElementSibling.style.display = "none";
      depositCard.style.display = "block";
      paymentCard.style.display = "none";
      transferCard.style.display = "none";
      withdrawCard.style.display = "none";
      break;
    case "withdraw":
      withdrawCard.previousElementSibling.style.display = "none";
      withdrawCard.style.display = "block";
      paymentCard.style.display = "none";
      transferCard.style.display = "none";
      depositCard.style.display = "none";
      break;
    default:
      paymentCard.style.display = "none";
      transferCard.style.display = "none";
      depositCard.style.display = "none";
      withdrawCard.style.display = "none";
  }
});
