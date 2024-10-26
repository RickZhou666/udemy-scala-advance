package lectures.part1as

import scala.annotation.tailrec

/**
 * @Author: Rick
 * @Date: 2024/10/25 17:15
 */
object Recap extends App {

  val aCondition: Boolean = false
  val aConditionVal = if (aCondition) 42 else 65
  // instructions vs expressions

  // compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // Unit = void
  val theUnit = println("hello, Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  // this is not invoke extra stack
  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if (n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  // OOP
  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog // subtyping polymorphism

  // abstract class
  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // natural languages

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems in THIS course

  // singleton and companions
  object MyList

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and try/ catch/ finally
  // val throwsException = throw new RuntimeException // Nothing

  val aPontentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "i caught an exception"
  } finally {
    println("some logs")
  }

  // packaging and imports

  // functional programming
  val incrementer = new Function[Int, Int] {

    override def apply(v1: Int): Int = v1 + 1
  }
  println(incrementer(1))

  val anonymousIncrementer = (x: Int) => x + 1
  List(1, 2, 3).map(anonymousIncrementer) // HOF
  // map, flatMap, filter

  // for-comprehension
  // 2 loops
  val paris = for {
    num <- List(1, 2, 3)
    char <- List('a', 'b', 'c')
  } yield {
    println(f"$num - $char")
  }

  // 1 loop pair <-> pair
  val paris2 = for {
    (num, char) <- List(1, 2, 3).zip(List('a', 'b', 'c')).zipWithIndex
  } yield {
    println(f"$num - $char")
  }


  // Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 555
  )

  // "collections": Options, try
  val aOption = Some(2)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }


  val bob = Person("Bob", 22)
  val greeting = bob match {
    // with name and something we dont care about
    case Person(n, _) => println(s"Hi, my name is $n")
  }


}
