import kotlin.random.Random

fun main() {

    // отладка на рандомно генерящихся примерах
    for (i in 1..10) {
        val random = Random.nextInt(0, 20_000)
        val people = Random.nextInt(0, 2)
        println(
            "Цена $random с учетом скидки по акции составила ${
                calcPrice(
                    people == 1,
                    random
                )
            }. Ваш уровень ${if (people == 1) "завсегдатай" else "новичок"}"
        )
    }

}

/**
 * цена с учетом скидки по акции
 *
 * isLover - признак постоянного покупателя
 * fullPrice - цена без скидки
 */
fun calcPrice(isLover: Boolean, fullPrice: Int): Int {
    val fix = 100 // фиксированная скидка
    val percentBigBuy = 5 // процент за большую покупку
    val percentLover = 1 // процент постоянным покупателям
    val fixBuy = 1000
    val bigBuy = 10_000

    var price = fullPrice
    if (fullPrice in fixBuy..<bigBuy) {
        price -= fix
    } else if (fullPrice >= bigBuy) {
        price -= (price * percentBigBuy / 100).toInt()
    }
    return if (isLover) price - (price * percentLover / 100).toInt() else price;
}