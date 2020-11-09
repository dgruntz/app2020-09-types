package ch.mse.app.types.variance

object Container {
  class Animal {
    def feed: Unit = {}
  }
  
  class Bird extends Animal
  
  class Container[T](val content: T) {
    def put(x: T) = {}
  }

  def feedIt(cage: Container[_ <: Animal]): Unit = {
    cage.content.feed
//    cage.put(new Animal)
  }
  def putIt(cage: Container[_ >: Animal]): Unit = {
//    cage.content.feed
    cage.put(new Animal)
  }
  
  val c1 = new Container[Animal](new Animal)
  val c2 = new Container[Bird](new Bird)
  
  feedIt(c1)
  feedIt(c2)
}