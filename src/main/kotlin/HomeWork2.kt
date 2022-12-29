import java.util.Scanner

fun main() {
    val scr = Scanner(System.`in`)
    val time = scr.nextInt();
    println(agoToText(time))
}

fun agoToText(wasOnline: Int): String {
    val time = endInWord(wasOnline)
    return ("Был(а) в сети ") + when {
        (wasOnline < 60) -> "только что. "
        (wasOnline >= 60 && wasOnline <= (60 * 60)) -> "$time  назад. "
        (wasOnline >= (60 * 60)  && wasOnline < (24 * 60 * 60)) -> "$time назад. "
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
        (wasOnline >= (60 * 60)  && wasOnline <= (24 * 60 * 60)) -> {
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