 Vehicle = (name, speed) =>{
    this.name = name;
    this.speed = speed;
 }
  Vehicle.prototype.drive = function () {
    console.log(this.name + ' runs at ' + this.speed)
  };
  var tico = new Vehicle('tico', 50);
  tico.drive(); // 'tico runs at 50'
  function Sedan(name, speed, maxSpeed) {
    Vehicle.apply(this, arguments)
    this.maxSpeed = maxSpeed;
  }
  Sedan.prototype = Object.create(Vehicle.prototype);
  Sedan.prototype.constructor = Sedan;
  Sedan.prototype.boost = function () {
    console.log(this.name + ' boosts its speed at ' + this.maxSpeed);
  };
  var sonata = new Sedan('sonata', 100, 200);
  sonata.drive(); // 'sonata runs at 100'
  sonata.boost(); // 'sonata boosts its speed at 200'