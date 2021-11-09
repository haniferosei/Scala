import java.time.LocalTime

class TradeTimestamp private(val id: String, val symbol: String, var quantity: Int, var _price: Double,Timestamp:LocalTime){


  require(_price >= 0)    // throws an IllegalArgumentException when condition is not met

  def price = _price                                      //getter

  def price_=(value:Double)  = {if(value>=0) _price=value}                  //setter

  //  def price_=(value:Double) = price = if (value>=0) value else _price         //if else


  def value(): Double = quantity*price
  override def toString: String = s" ID = $id , SYMBOL = $symbol, QUANTITY = $quantity , PRICE = $price, TIMESTAMP =$Timestamp"


}

//value()
//...Static methods (no need to create an instance of class before being used)can be put there..methods called that can be put without creating an instance
object  TradeTimestamp{
  def apply(  id: String,  symbol: String,   quantity: Int,  _price: Double,timestamp:LocalTime): TradeTimestamp ={
    val t = new TradeTimestamp(id,symbol,quantity,_price,timestamp)                //use it to construct an instance

    t

  }
  val ttt=0
}
