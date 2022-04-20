fun main() {
    println(agoToText(20))
    println(agoToText(61))
    println(agoToText(5000))
    println(agoToText(95000))
    println(agoToText(190000))
    println(agoToText(400000))
}

fun agoToText(secondsAgo: Int): String {
    return when (secondsAgo) {
        in 0..60 -> "Был(а) только что"
        in 61..60 * 60 -> "${secondToMinutes(secondsAgo)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${secondToHour(secondsAgo)} назад"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "Был(а) сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "Был(а) вчера"
        else -> "Был(а) давно"
    }
}

fun secondToMinutes(secondsAgo: Int): String {
    val minutesAgo = secondsAgo / 60
    var secondToMinutes = ""
    when {
        minutesAgo in 2..4 || (minutesAgo % 10) in 2..4 -> secondToMinutes = "$minutesAgo минуты"
        minutesAgo == 1 || ((minutesAgo % 10) == 1 && minutesAgo != 11 && minutesAgo %100 != 11) -> secondToMinutes = "$minutesAgo минуту"
        else -> secondToMinutes = "$minutesAgo минут"

    }
    return secondToMinutes
}

fun secondToHour(secondsAgo: Int): String {
    val hourAgo = secondsAgo / 60 / 60
    var secondToHour = ""
    when {
        hourAgo in 2..4 || (hourAgo % 10) in 2..4 -> secondToHour = "$hourAgo часа"
        hourAgo == 1 || ((hourAgo % 10) == 1 && hourAgo != 11 && hourAgo %100 != 11) -> secondToHour = "$hourAgo час"
        else -> secondToHour = "$hourAgo часов"
    }
    return secondToHour
}
