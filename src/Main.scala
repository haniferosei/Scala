import java.time.LocalTime
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Main extends App {

val trade =  Trade("AA","BTC",100,8)
  val trade1 =  Trade.apply("AA","BTC",100,8)              //apply is a static method


//  println(trade)
//
// println(trade.value())
//  println(trade.equals())
//  println(trade.hashCode())
//  println(trade.toString())




  val KK= Trade.ttt
  println(KK)
  val tradecase = TradeCase.apply("SSS","TTT",0,9.0)
  println(tradecase)

  val tradecase2 = TradeCase.apply("gg","jj",1,9.0)

  println(tradecase.equals(tradecase2))

    println(trade.hashCode())
    println(trade.toString())


  println("bhjmvgggggggggggggg")
val  transaction = new Transaction("hh",10.0,"uu",10)
println(transaction.value())

  println(transaction.amount())


  println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
//Basic Functional Scala
//Currying

def function(calculation:String):(Int,Int) =>Double =(a:Int, b:Int) =>{
  calculation match {
    case "add" => a+b
    case "subtract" =>a-b
    case "power" => scala.math.pow(a,b)
    case _ => 0

  }

  }

  val calculation = function("add")
  println(calculation(4,5))

  val calculation2 = function("subtract")
  println(calculation2(10,5))

  val calculation3 = function("power")
  println(calculation3(2,2))

println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")

  //Functional Collections

  val files = (new java.io.File(".")).listFiles
  println(files)

  //1
  val filesNotHidden =files.filter(file => !file.isHidden)
 files.filter(file => !file.getName.head.equals('.')).foreach(println)

  println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")

  //2
  val regularFiles = files.filter(file => !file.isDirectory)
  val directories = files.filter(file => file.isDirectory)

  regularFiles.foreach(println)
  directories.foreach(println)

println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
  //3
//  val something = files.filter(file => file.getName:Boolean)
//println(something)

  //4
  val largestFiles = files.filter(_.isFile).sortWith(_.length() > _.length()).take(10)
  val smallestFiles = files.filter(_.isFile).sortWith(_.length() < _.length()).take(5)

  largestFiles.foreach(println)
  println("cccccccccccccccccc")
  smallestFiles.foreach(println)

  println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")

//5
//val largestFilesMap = files.filter(_.isFile)
//  .sortWith(_.length() > _.length())
//  .take(10)
//  .toMap()

  //6
//  val groupedFiles = files.sortWith(_.getName.head > _.getName.head)
//    .groupBy(s =>s)
//    .values
//
//  groupedFiles.foreach(println())



//COLLECTIONS
  def remove(coll: Seq[Int], idx: Int): Seq[Int] = coll.filter(s => s !=coll(idx))
  println(remove(Seq(1,2,3,4,5), 1))


  //2
  var mapOfNumbers = Map[Int,Int]()

  var counter =1

  while(counter <=6){
    val number =Random.between(1,50)

    if(!mapOfNumbers.contains(number)){
      mapOfNumbers ++=Map(number -> number)
      counter =counter+1
    }
  }

println(mapOfNumbers.values.toList.sortWith(_<_))


  //New Exercise
  val source = io.Source.fromFile("/Users/User/NewScalaStuff/src/Trades.txt")
  var list = ArrayBuffer[Trade]()
  for ((record,x) <- source.getLines.zipWithIndex){          //zipwithIndex returns a list of tuples...first item returns item itself and the second is the index of item

    val fields = record.split(",").map(_.trim)             //trim removes all whitespaces   (,) separates with a delimiter
//    println(s"${fields(0)}\t${fields(3)}\t${fields(4)}")
//    val trade3 = Trade(Range(1,100).head.toString,fields(0),fields(3).toInt,fields(4).toDouble)
//       val trade3 = Trade(Random.between(1,100).toString,fields(0),fields(3).toInt,fields(4).toDouble)
    val trade3=Trade((x+1).toString,fields(0),fields(3).toInt,fields(4).toDouble)

    list += trade3                                                 //adding item to end of list(appending)
  }
//  val range=Range(1,100)
//  println(range.toList)
  list.foreach(println)

  source.close()



  //tIMESTAMP
  val source1 = io.Source.fromFile("/Users/User/NewScalaStuff/src/Trades.txt")
  var list1 = ArrayBuffer[TradeTimestamp]()
  for ((record,x) <- source1.getLines.zipWithIndex){          //zipwithIndex returns a list of tuples...first item returns item itself and the second is the index of item

    val fields = record.split(",").map(_.trim)             //trim removes all whitespaces   (,) separates with a delimiter
    //    println(s"${fields(0)}\t${fields(3)}\t${fields(4)}")
    //    val trade3 = Trade(Range(1,100).head.toString,fields(0),fields(3).toInt,fields(4).toDouble)
    //       val trade3 = Trade(Random.between(1,100).toString,fields(0),fields(3).toInt,fields(4).toDouble)
    val time: LocalTime = LocalTime.ofNanoOfDay(fields(2).toLong*1000000)
    val trade4=TradeTimestamp((x+1).toString,fields(0),fields(3).toInt,fields(4).toDouble,time)

    list1 += trade4                                                 //adding item to end of list(appending)
  }
  //  val range=Range(1,100)
  //  println(range.toList)
  list1.foreach(println)

  source1.close()



}
