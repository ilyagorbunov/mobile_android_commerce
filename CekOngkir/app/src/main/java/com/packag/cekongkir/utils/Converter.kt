package com.packag.cekongkir.utils

import java.text.NumberFormat
import java.util.*

class Converter {

    companion object {
        fun rupiah(number: Double) : String {
            val numberFormat = NumberFormat.getInstance(Locale.GERMANY)
            return numberFormat.format(number).toString()
        }
    }
}