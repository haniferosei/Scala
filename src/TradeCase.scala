case class TradeCase (id: String, symbol: String, var quantity: Int,  private var _price: Double){


  def price = _price                                      //getter

  def price_=(value:Double)  = {if(value>=0) _price=value}              //setter

  def value() = quantity*price
}


