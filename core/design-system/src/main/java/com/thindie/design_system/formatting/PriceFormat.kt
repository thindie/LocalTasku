package com.thindie.design_system.formatting


fun Double.priceFormat(currencySign: String): String {
    require(this >= 0.0)
    require(currencySign.length < 8)
    require(currencySign.isNotBlank())
    return this.toString().plus(currencySign)
}

fun Double.prettyPrice(currencySign: String): String {
    require(this > 0.0)
    require(currencySign.isNotBlank())
    return String.format("%1$.1f$currencySign", this)
}

fun String.parseFromPrice(currencySign: String): Double {
    require(contains(currencySign))
    val resultString = replace(currencySign, "").trim()
    val parsedDouble = resultString.toDouble()
    require(this.contains(parsedDouble.toString()))

    return parsedDouble
}