const generateBill = (productName, unitPrice, quantity, taxRate) => {
    const subtotal = unitPrice * quantity;
    const taxAmount = (subtotal * taxRate) / 100;
    const grandTotal = subtotal + taxAmount;
    return `---------------------------------
          PRODUCT INVOICE
---------------------------------
Product:      ${productName}
Unit Price:   Rs. ${unitPrice.toFixed(2)}
Quantity:     ${quantity}
Subtotal:     Rs. ${subtotal.toFixed(2)}
Tax (${taxRate}%):   Rs. ${taxAmount.toFixed(2)}
---------------------------------
Total Bill:   Rs. ${grandTotal.toFixed(2)}
---------------------------------`;
};

const bill = generateBill("Wireless Mechanical Keyboard", 3500, 2, 18);
console.log(bill);

if (typeof document !== "undefined") {
    const el = document.getElementById("billOutput");
    if (el) {
        el.textContent = bill;
    }
}
