var position1 = 3;
var position1 = 4;
var position1 = 5;

var nbTouches = 0;
var proposition ;
var nbProp = 0;
var  estCouler= false;

while(estCouler == false){
    proposition = prop("Donner une proposition")
    if (proposition < 0 || proposition > 6){
        nbProp += 1;
        if(proposition == position1 || proposition == position2 || proposition == position3)
        nbTouches += 1;
    }
}
prop("Couler")
