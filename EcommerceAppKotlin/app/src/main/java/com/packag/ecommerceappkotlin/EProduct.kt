package com.packag.ecommerceappkotlin

class EProduct {

    private var id: Int
    private var name: String
    private var price: Int
    private var productPicature: Int

    constructor(i: Int, n: String, p: Int, pp: Int){

        this.id = i
        this.name = n
        this.price = p
        this.productPicature = pp

    }
}