class Transaction(id: String,  _price: Double, symbol: String,  quantity: Int)
  extends EquityTrades(id, _price, symbol, quantity)with FeePayable with Taxable {


  override def fee(): Int = 10

  override def tax(): Double = 12.5/100

  def amount(): Double ={

    val total = value() +fee()
    total+total*tax()

  }
}
