package ch.mse.app.types.variance

trait Function1[T, R] {
  self =>

  // Apply the body of this function to the argument.
  def apply(arg: T): R

  // Composes two instances of Function1 in a new Function1, 
  // with this function applied last.
  def compose[A](g: Function1[A, T]): Function1[A, R] = {
    new Function1[A, R] {
      def apply(arg: A) = self.apply(g.apply(arg))
    }
  }

  // Composes two instances of Function1 in a new Function1, 
  // with this function applied first.
  def andThen[A](g: Function1[R, A]): Function1[T, A] = {
    new Function1[T, A] {
      def apply(arg: T) = g.apply(self.apply(arg))
    }
  }

  override def toString() = "<function1>"
}


object TestFunction1 {
    def main(args: Array[String]): Unit = {
      val inc: Function1[Int, Int] = new Function1[Int, Int] {
        def apply(x: Int): Int = x+1
      }
      val sqr: Function1[Int, Int] =new Function1[Int, Int] {
        def apply(x: Int): Int = x*x
      }
      
      val f1 = inc.compose(sqr)
      println(f1(3)) // 10
      
      val f2 = inc.andThen(sqr)
      println(f2(3)) // 16
    }
}
