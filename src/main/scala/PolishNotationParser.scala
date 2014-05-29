package com.liangsorg.interviews

import scala.io.Source

/**
 * Created with IntelliJ IDEA.
 * User: liliang
 * Date: 5/28/14
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
object FoldTest {
  def main(args: Array[String]){
    val filePath =
      if(args.length > 0) args(0)
      else "polish_notations.dat"

    for(line <- Source.fromFile(filePath).getLines()){
      val eval: Int = line.split(" ").foldRight(List[Int]())((elem, list) =>{
        elem match {
          case "+" => calculate(list, _ + _)
          case "*" => calculate(list, _ * _)
          case "/" => calculate(list, _ / _)  //default to floor() to achieve arbitrary rounding, change Int to Double and choose either floor() or ceil()
          case _ => list :+ elem.toInt
        }
      }).head

      if(eval>=0)
        println(eval)
      else
        println(eval*(-1))
    }

    def calculate(list: List[Int], op:(Int, Int) => Int): List[Int] = {
      list.dropRight(2) :+ op(list.dropRight(1).last,list.last).toInt
    }
  }
}

