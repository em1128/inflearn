function Character (hp, atk, level) {
        this.hp = hp;
        this.atk = atk;
        this.level = level;
}

var myPokemon=[];
var monDex=[];
var pokeNum = 0;

function Monster (hp, atk, level, catchPercent) {
    
        Character.apply(this, arguments);
        this.catchPercent = catchPercent;

        Monster.prototype.CatchMonster = function(){
            
            console.log("포획률 : " + this.catchPercent);
        
            if(this.catchPercent<0){
                alert("Error : catchPercent is minus!");
                return -1;
            }
            else if(this.catchPercent>100){
                alert("Error : catchPercent is over 100%");
                return 101;
            }
    
            if(Math.random()*100<=this.catchPercent){
                console.log(" 포획 성공!");
                alert(" 포획 성공!");
                myPokemon[pokeNum] = this;
                pokeNum++;
            }
            else{
                console.log(" 포획 실패!");
                alert(" 포획 실패!");
            }
    }
}



function NewMonster(stage){
    var randomLevel = Math.random()*10;
    randomLevel = Math.floor(randomLevel) + 1;
    switch(stage){
        case 1:
            let chico = new Monster(4*randomLevel,2*randomLevel,randomLevel,50);
            monDex[0] = chico;
            alert(
                "HP : " + chico.hp + "\n" +
                "ATK : " + chico.atk + "\n" +
                "LV : " + chico.level + "\n");
            break;
        case 2:
            let rita = new Monster(3*randomLevel,5*randomLevel,randomLevel,40);
            monDex[1] = rita;
            alert(
                "HP : " + rita.hp + "\n" +
                "ATK : " + rita.atk + "\n" +
                "LV : " + rita.level + "\n");
            break;
        default:
            alert("ERROR : stage not exist!");

        
    
    }
   
    
}
