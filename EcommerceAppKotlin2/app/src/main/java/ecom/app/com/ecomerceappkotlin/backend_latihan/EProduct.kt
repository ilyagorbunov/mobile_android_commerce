package ecom.app.com.ecomerceappkotlin

class EProduct {

    var id: Int
    var name: String
    var price: Int
    var productPicture: Int

    constructor(i: Int, n: String, p: Int, pp: Int){

        this.id = i
        this.name = n
        this.price = p
        this.productPicture = pp
    }
}