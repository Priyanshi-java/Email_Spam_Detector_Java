document.getElementById("checkButton").addEventListener("click", function () {

    let subject = document.getElementById("subject").value.toLowerCase();
    let message = document.getElementById("message").value.toLowerCase();

    let output = document.getElementById("output");

    if(subject === "" || message === ""){
        output.innerHTML = "⚠ Please enter Subject and Message.";
        output.style.color = "orange";
        return;
    }

    let spamWords = [
        "win",
        "free",
        "prize",
        "click here",
        "offer",
        "money",
        "iphone",
        "urgent",
        "lottery"
    ];

    let text = subject + " " + message;

    let spam = spamWords.some(word => text.includes(word));

    if(spam){
        output.innerHTML = "🚨 SPAM EMAIL DETECTED";
        output.style.color = "red";
    } else {
        output.innerHTML = "✅ SAFE EMAIL";
        output.style.color = "green";
    }

});