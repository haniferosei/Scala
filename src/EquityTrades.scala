class EquityTrades(   id: String, var price: Double,var symbol: String,  var quantity: Int)
  extends TradeAbstract(id,price)
   {
  override def isExecutable(): Boolean = true

  override def toString: String = s"EQUITY TRADES SYMBOL = $symbol and QUANTITY = $quantity"

     def value(): Double = quantity*price
}
