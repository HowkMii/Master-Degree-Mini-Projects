var view = {
    //this method takes a string and displays
    //it in the message area
    displayMessage: function(msg) {
        var messageArea = document.getElementById('messageArea');
        messageArea.innerHTML = msg;
    },
    


window.onload = init;