import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
// Задание 1
    println("Задание 1")
    println("Введите сумму перевода ")
    val amountTransfer = scanner.nextInt()
    val minAmount = 35
    val percentCommission = 0.75
    val sumPercentCommission = (amountTransfer * percentCommission) / 100
    val errorSumTransfer = "Сумма перевода меньше $minAmount руб."
    val transfer = if (amountTransfer > minAmount) {amountTransfer - sumPercentCommission} else errorSumTransfer
    println("\tВаша сумма $amountTransfer руб.\n\tКомиссия $sumPercentCommission руб.\n\tСумма вашего перевода равна $transfer")

// Задание 2
    println("\nЗадание 2")
    println("Введите кол-во лайков ")
    val likes = scanner.nextInt()
    val dependentText: String
    if (likes % 10 == 1 && likes % 100 != 11) {
        dependentText = "человеку"
    } else dependentText = "людям"
    println("\tПонравилось $likes $dependentText")

// Задание 3
    println("\nЗадание 3")
    println("Введите сумму покупки ")
    val amount = scanner.nextInt()
    val discountHundred = 100
    val discountPercnet = .95
    val discountRegular = .99
    println("Введите regular если являетесь постоянным покупателем")
    val inputRegular = scanner.next()
    val regular: Boolean = inputRegular == "regular" || inputRegular == "Regular"
    if (amount <= 1000) {
        if (regular) {
            println("Сумма вашей покупки равна " + amount * discountRegular)
        } else println("Сумма вашей покупки равна $amount ")
    } else if (amount > 1000 && amount <= 10_000) {
        if (regular) {
            println("Сумма вашей покупки равна " + (amount - discountHundred) * discountRegular)
        } else println("Сумма вашей покупки равна " + (amount - discountHundred))
    } else {
        if (regular) {
            println("Сумма вашей покупки равна " + (amount * discountPercnet) * discountRegular)
        } else println("Сумма вашей покупки равна " + (amount * discountPercnet))
    }
}