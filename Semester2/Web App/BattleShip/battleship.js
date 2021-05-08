var view = {
    //this method takes a string and displays
    //it in the message area
    displayMessage: function(msg) {
        var messageArea = document.getElementById('messageArea');
        messageArea.innerHTML = msg;
    },
    
	displayHit: function(location) {
        var cell = document.getElementById(location);
        cell.setAttribute("class", "hit");
    },
    displayMiss: function(location){
        var cell = document.getElementById(location);
        cell.setAttribute("class", "miss");
    }
};
var model = {
    boardSize: 7,
    numOfShips: 3,
	shipsSunk: 0,
    shipLength: 3, 
    ships: { locations: [0, 0, 0], hits: ["", "", ""] },
        { locations: [0, 0, 0], hits: ["", "", ""] },
        { locations: [0, 0, 0], hits: ["", "", ""] }
    ],
	 fire: function(guess) {
        for(var i=0; i<this.numOfShips; i++){
            var ship = this.ships[i];
            var index = ship.locations.indexOf(guess);
            if(index >= 0){
                //It's a hit
                if(ship.hits[index]=="hit"){
                    view.displayMessage("You've already hit this location! Enter some other coordinates");
                    controller.guesses--;
                    return false;
                }
				ship.hits[index] = "hit";
                view.displayHit(guess);
                view.displayMessage("HIT!");
				if(this.isSunk(ship)){
                    view.displayMessage("You sank my battleship!");
                    this.shipsSunk++;
                }
				                return true;
            }
        }
	        view.displayMiss(guess);
        view.displayMessage("You missed!");
        return false;
    },
	isSunk: function(ship){
        for(var i =0; i<this.shipLength; i++){
            if(ship.hits[i] !== "hit"){
                return false;
            }
        }
        return true;

     generateShip: function(){
        var direction = Math.floor(Math.random()*2);
        var row, col;
        var newShipLocations=[];

        if(direction === 1){
            //direction is vertical
            row = Math.floor(Math.random()* (this.boardSize- this.shipLength + 1));
            col = Math.floor(Math.random()* (this.boardSize));
        }
        else{
            row = Math.floor(Math.random()* (this.boardSize));
            col = Math.floor(Math.random()* (this.boardSize - this.shipLength + 1));
        }

        for(var i=0; i<this.shipLength; i++){
            if(direction==1){
                newShipLocations.push((row+i) + "" + col);
            }
            else{
                newShipLocations.push(row + "" + (col+i));
            }
        }
        return newShipLocations;
    },
    isColliding: function(inputlocations){
        for(var i=0; i<this.numOfShips-1; i++){
            var ship = this.ships[i];
            for(var j=0; j<inputlocations.length; j++){
                if(ship.locations.indexOf(inputlocations[j])>=0){
                    //this means the ith inputLocation is already occupied.
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
                view.displayMessage("You sank all my battleships, in " + this.guesses + " guesses");
                var inputForm = document.getElementById('inputForm');
                inputForm.outerHTML = "";
            }
        }
    }
};
function parseGuess(guess){
    var alphabet = ["A", "B", "C", "D", "E", "F", "G"];

    if(guess == null || guess.length !== 2){
        alert("Oops, please enter a letter and a number on the board.");
    } else{
        
    }
    return null;
}
window.onload = init;