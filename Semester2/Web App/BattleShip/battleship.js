




var model = {
    boardSize: 7,
    numOfShips: 3,
    shipsSunk: 0,
    ships: [
        { locations: [0], hits: [""] },
        { locations: [0], hits: [""] },
        { locations: [0], hits: [""] }
    ],

    fire: function(guess) {
            var ship0 = this.ships[0];
            var index0 = ship0.locations.indexOf(guess);
            var loc0 = ship0.locations[0];

            var ship1 = this.ships[1];
            var index1 = ship1.locations.indexOf(guess);
            var loc1 = ship1.locations[0];

            var ship2 = this.ships[2];
            var index2 = ship2.locations.indexOf(guess);
            var loc2 = ship2.locations[0];


            console.log(loc0);
            console.log(loc1);
            console.log(loc2);

            if(index0 >= 0){
                //It's a hit
                if(ship0.hits[index0]=="hit"){
                    controller.guesses--;
                    return false;
                }
                ship0.hits[index0] = "hit";
                view.displayHit(guess);
                this.shipsSunk++;
                return true;
            }

            if(index1 >= 0){
                //It's a hit
                if(ship1.hits[index1]=="hit"){
                    controller.guesses--;
                    return false;
                }
                ship1.hits[index1] = "hit";
                view.displayHit(guess);
                this.shipsSunk++;
                return true;
            }

            if(index2 >= 0){
                //It's a hit
                if(ship2.hits[index2]=="hit"){
                    controller.guesses--;
                    return false;
                }
                ship2.hits[index2] = "hit";
                view.displayHit(guess);
                this.shipsSunk++;
                return true;
            }

            guessx = parseInt(guess)//if(guessx+1 == loc || guessx+10 == loc || guessx+9 == loc || guessx+11 == loc || guessx-1 == loc || guessx-10 == loc  || guessx-9 == loc  || guessx-11 == loc){

            if(guessx+1 == loc0 || guessx+10 == loc0 || guessx+9 == loc0 || guessx+11 == loc0 || guessx-1 == loc0 || guessx-10 == loc0  || guessx-9 == loc0  || guessx-11 == loc0){
                if(ship0.hits[0]=="hit"){
                    view.displayMiss(guess);
                    return false;
                }
                view.displayClose(guess);
                return false;
            }
            if(guessx+1 == loc1 || guessx+10 == loc1 || guessx+9 == loc1 || guessx+11 == loc1 || guessx-1 == loc1 || guessx-10 == loc1  || guessx-9 == loc1  || guessx-11 == loc1){
                if(ship1.hits[0]=="hit"){
                    view.displayMiss(guess);
                    return false;
                }
                view.displayClose(guess);
                return false;
            }
            if(guessx+1 == loc2 || guessx+10 == loc2 || guessx+9 == loc2 || guessx+11 == loc2 || guessx-1 == loc2 || guessx-10 == loc2  || guessx-9 == loc2  || guessx-11 == loc2){
                if(ship2.hits[0]=="hit"){
                    view.displayMiss(guess);
                    return false;
                }
                view.displayClose(guess);
                return false;
            }






        view.displayMiss(guess);
        return false;
    },

    generateShipLocations: function() {
        var locations;
        for(var i=0; i<this.numOfShips; i++) {
            do{
                locations = this.generateShip();
            }while(this.isColliding(locations));
            this.ships[i].locations = locations;
        }
    },

    generateShip: function(){
        var r, c;
        var newShipLocations=[];
        r = Math.floor(Math.random()* (this.boardSize- 2));
        c = Math.floor(Math.random()* (this.boardSize));
        newShipLocations.push(r + "" + c);
        return newShipLocations;
    },

    isColliding: function(inputlocations){
        for(var i=0; i<this.numOfShips-1; i++){
            var ship = this.ships[i];
            for(var j=0; j<inputlocations.length; j++){
                if(ship.locations.indexOf(inputlocations[j])>=0){
                    return true;
                }
            }
        }
        return false;
    }
};



var controller = {
    guesses: 0,

    processGuess: function(guess) {
        var location = parseGuess(guess);
        if(location){
            this.guesses++;
            var hit = model.fire(location);
            if(hit && model.shipsSunk === model.numOfShips){

                alert("YOU WON... YOUR ACCURACY IS : " +(100-((this.guesses*100)/49))+ " %");
                window.location.reload();
                var inputForm = document.getElementById('inputForm');
                inputForm.outerHTML = "";
            }
        }
    }
};
function parseGuess(guess){
    var alphabet = ["A", "B", "C", "D", "E", "F", "G"];

    if(guess == null || guess.length !== 2){
        alert("please enter a letter and a number on the board. like A0");
    } else{
        guess = guess.toUpperCase();
        firstChar = guess.charAt(0);
        var row = alphabet.indexOf(firstChar);
        var column = guess.charAt(1);

        if(isNaN(row) || isNaN(column)){
            alert("Oops, that isn't on the board!");
        } else if(row<0 || row > model.boardSize || column<0 || column>=model.boardSize){
            alert("that's off the board!");
        } else{
            return row + column;
        }
    }
    return null;
}



function init() {
    var fireButton = document.getElementById('fireButton');
    fireButton.onclick = handleFireButton;

    var guessInput = document.getElementById('guessInput');
    guessInput.onkeypress = handleKeyPress;

    model.generateShipLocations();
}

function handleFireButton() {
    var guessInput = document.getElementById('guessInput');
    var guess = guessInput.value;
    controller.processGuess(guess);
    guessInput.value = ""; // clears the form field.
}

function handleKeyPress(e) {
    var fireButton = document.getElementById('fireButton');
    if(e.keyCode === 13){
        fireButton.click();
        return false; // so the form does not submit itself.
    }
}
window.onload = init;
var view = {
    displayHit: function(location) {
        var cell = document.getElementById(location);
        cell.setAttribute("class", "hit");
    },
    displayMiss: function(location){
        var cell = document.getElementById(location);
        cell.setAttribute("class", "miss");
    },
    displayClose: function(location){
        var cell = document.getElementById(location);
        cell.setAttribute("class", "close");
    }
};