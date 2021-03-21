function outter() {
    function inner() {
        var title = 'coding everybody';
        alert(title);
    }
    inner();
}

outter();

var arr = []
for(var i=0;i<5;i++){
    arr[i] = function(id) {
        return function(){
            return id;
        }
    }(i);

}
for(var index in arr) {
    console.log(arr[index]());
}
