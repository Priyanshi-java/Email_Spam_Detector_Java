document.getElementById("checkButton").addEventListener("click", function () {

    let subject = document.getElementById("subject").value;
    let message = document.getElementById("message").value;

    if(subject==="" || message==="")
    {
        document.getElementById("output").innerHTML="⚠ Please enter Subject and Message.";
        document.getElementById("output").style.color="orange";
    }
    else
    {
        document.getElementById("output").innerHTML="Checking Email...";
        document.getElementById("output").style.color="blue";
    }

});