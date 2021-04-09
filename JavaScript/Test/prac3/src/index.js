function Character (hp, atk, level) {
        this.hp = hp;
        this.atk = atk;
        this.level = level;
}

var myPokemon=[];
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
                myPokemon[pokeNum] = this;
                pokeNum++;
            }
            else{
                console.log(" 포획 실패!");
            }
    }
}



function NewMonster(stage){
    var randomLevel = Math.random()*10;
    randomLevel = Math.floor(randomLevel);
    let chico = new Monster(4*randomLevel,2*randomLevel,randomLevel,50);
    let norin = new Monster(3*randomLevel,5*randomLevel,randomLevel,40);
    monDex=[chico, norin];
}
