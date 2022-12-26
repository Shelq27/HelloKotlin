fun main() {
// Задание 1
    println("Задание 1")
    val minAmount = 35
    val amountTransfer = 20_000
    val percentCommission = 0.75
    val sumPercentCommission = (amountTransfer * percentCommission) / 100
    val errorSumTransfer = "Сумма перевода меньше $minAmount руб."
    var transfer = if (amountTransfer > minAmount) {
        amountTransfer - sumPercentCommission
    } else errorSumTransfer
    println("\tВаша сумма $amountTransfer руб.\n\tКомиссия $sumPercentCommission руб.\n\tСумма вашего перевода равна $transfer")

// Задание 2
    println("\nЗадание 2")
    var likes = 61
    var dependentText: String
    if (likes % 10 == 1 && likes % 100 != 11) {
        dependentText = "человеку"
    } else dependentText = "людям"
    println("\tПонравилось $likes $dependentText")

// Задание 3
    println("\nЗадание 3")
    

}