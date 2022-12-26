fun main() {
    // Задание 1
    val minAmount = 35
    val amountTransfer = 20_000
    val percentCommission = 0.75
    val sumPercentCommission = (amountTransfer * percentCommission) / 100
    val errorSumTransfer = "Сумма перевода меньше $minAmount руб."
    var transfer = if (amountTransfer > minAmount) {
        amountTransfer - sumPercentCommission
    } else errorSumTransfer
    println("Ваша сумма $amountTransfer руб.\nКомиссия $sumPercentCommission руб.\nСумма вашего перевода равна $transfer")

}