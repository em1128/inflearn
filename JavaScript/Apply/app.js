
function sum() {
    var _sum = 0; 
    for (num in this){
        if(typeof this[num] !== 'function')
            _sum += this[num];
    }
    return _sum;
    
}
o1 = {val1:1, val2:2, val3:3, sum:sum}
o2 = {v1:10, v2:20, v3:100, v4:5, sum:sum}

alert(o1.sum());
alert(o2.sum());
//alert(sum.apply(o1)); 위의 2줄과 같음(o1에서 sum:sum을 빼야 함)
//alert(sum.apply(o2));
