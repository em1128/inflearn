function Person(name) {
    
    this.name = name;
    this.introduce = function(){
        return 'My name is '+this.name;
    }
}

var p1 = new Person('em1128');
document.write(p1.introduce() + "<br />");

var p2 = new Person('lowplace');
document.write(p2.introduce() + "<br />");
