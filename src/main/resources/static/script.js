function calculateTax() {
    let income = document.getElementById("income").value;

    fetch("https://income-tax-counter-objs.onrender.com/api/tax/calculate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ income: parseFloat(income) })
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById("result").innerText = `Tax Amount: ₹${data}`;
    })
    .catch(error => console.error("Error:", error));
}
