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
    val line1 = "1";
    val line2 = "* + 2 3 4";
    val line3 = "/ 8 15";
    val line4 = "* 2147483646 2"; //int overflows,  2 to the power of 31 minus 1 being the biggest int
    val line5 = "* + 12 1 -2"; //int overflows,  2 to the power of 31 minus 1 being the biggest int

    val list = List(line1) :+ line2 :+ line3 :+ line4 :+ line5

    val filePath =
      if(args.length > 0) args(0)
      else "polish_notations.dat"

    for(line <- Source.fromFile(filePath).getLines()){
      val eval: Int = line.split(" ").foldRight(List[Int]())((elem, resultList) =>{
        elem match {
          case "+" => calculate(resultList, _ + _)
          case "*" => calculate(resultList, _ * _)
          case "/" => calculate(resultList, _ / _)  //default to floor() to achieve arbitrary rounding, change Int to Double and choose either floor() or ceil()
          case _ => resultList :+ elem.toInt
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

