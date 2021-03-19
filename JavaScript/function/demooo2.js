function cal(mode)
{
    var funcs = {
        'plus' : (left, right) => left + right,
        'minus' : function(left, right) {return left - right}
        
    }
    return funcs[mode];
}