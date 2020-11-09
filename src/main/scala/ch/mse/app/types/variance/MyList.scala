package ch.mse.app.types.variance

trait ListReader[+T] {
  def get(index: Int): T
  def sort(comparer: Order[T]): Unit
}
trait ListWriter[-T] {
  def add(item: T): Unit
  def addRange(items: Seq[T]): Unit
}

trait Order[-T] {
  def compare(x1: T, x2: T): Int
}

class MyList[T](elem: T) extends ListReader[T] with ListWriter[T] {
  def get(index: Int): T = elem
  def sort(comparar: Order[T]): Unit = { }
  def add(item: T): Unit = { }
  def addRange(items: Seq[T]): Unit = { }
}

class A
class B extends A
class C extends B

object TestList {

  def main(args: Array[String]): Unit = {
    val x: MyList[B] = new MyList[B](new B)
    
    val r: ListReader[B] = x;
    val oa: Order[A] = null
    val ob: Order[B] = null
    val oc: Order[C] = null
    r.sort(oa)
    r.sort(ob)
//  r.sort(oc)  // type mismatch
    
    val xa: ListReader[A] = x
    val xc: ListWriter[C] = x
    
    xa.sort(oa)
//  xa.sort(ob)
//  xa.sort(oc)
    
//    val xx: ListReader[C] = x
//    val yy: ListWriter[A] = x
    
  }
}