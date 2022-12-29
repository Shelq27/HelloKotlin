import java.util.Scanner

fun main() {
    val scr = Scanner(System.`in`)

    // ДЗ_1
//    println("Введите секунды")
//    val time = scr.nextInt();
//    println(agoToText(time))

    //ДЗ_2

    println("Введите тип карты (Mastercard,Maestro,Visa,Мир,VKPay)")
    val cardType = scr.next()
    println("Введите сумму перевода ")
    val amountTransfer = scr.nextDouble()
    val amountPreviousTransfer = 7600

    println(calculation(cardType, amountPreviousTransfer, amountTransfer))
}


fun agoToText(wasOnline: Int): String {
    val time = endInWord(wasOnline)
    return ("Был(а) в сети ") + when {
        (wasOnline < 60) -> "только что. "
        (wasOnline >= 60 && wasOnline <= (60 * 60)) -> "$time  назад. "
        (wasOnline >= (60 * 60) && wasOnline < (24 * 60 * 60)) -> "$time назад. "
        (wasOnline >= (24 * 60 * 60) && wasOnline < (48 * 60 * 60)) -> "вчера "
        (wasOnline >= (48 * 60 * 60) && wasOnline <= (72 * 60 * 60)) -> "позавчера "
        else -> "давно"
    }

}

fun endInWord(wasOnline: Int): String {
    var time: Int = 0
    var endWord: Array<String> = arrayOf("", "", "")
    when {
        (wasOnline >= 60 && wasOnline < (60 * 60)) -> {
            time = wasOnline / 60
            endWord = arrayOf("минут", "минуту", "минуты")
        }

        (wasOnline >= (60 * 60) && wasOnline <= (24 * 60 * 60)) -> {
            time = wasOnline / (60 * 60)
            endWord = arrayOf("часов", "час", "часа")
        }
    }
    var inTime = time
    inTime %= 100
    if (inTime >= 5 && time <= 20) {
        return "$time " + endWord[0]
    }
    inTime %= 10;
    if (inTime == 1) {
        return "$time " + endWord[1]
    }
    if (inTime >= 2 && inTime <= 4) {
        return "$time " + endWord[2]
    }
    return "$time " + endWord[0]
}

fun calculation(cardType: String = "VKPay", amountPreviousTransfer: Int = 0, amountTransfer: Double): String {
    if ((cardType != "VKPay" && amountTransfer > 150_000)||amountPreviousTransfer>600_000) {
        return "Превышен лимит на перевод"
    } else if ((cardType == "VKPay" && amountTransfer > 15000)||(cardType=="VKPay")&&amountPreviousTransfer>40_000) {return "Превышен лимит на перевод"}
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (amountTransfer > 75_000) {
                "Сумма вашего перевода равна : " + ((amountTransfer * 0.994) - 20) + " руб."
            } else "Сумма вашего перевода равна : $amountTransfer руб."
        }

        "Visa", "Мир" -> {
            if (amountTransfer < 35) {
                "Минимальная сумма с картой Visa|Мир 35 руб."
            } else {
                "Сумма вашего перевода равна : " + (amountTransfer * 0.9925) + " руб."
            }
        }
        else -> "Сумма вашего перевода равна : $amountTransfer руб."
    }
}
