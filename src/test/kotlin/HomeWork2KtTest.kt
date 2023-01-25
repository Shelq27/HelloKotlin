import org.junit.Test

import org.junit.Assert.*

class HomeWork2KtTest {


    @Test
    fun calculationVKPay() {
        val cardType = "VKPay"
        val amountTransfer = 5000.0
        val amountPreviousTransfer = 7600
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Сумма вашего перевода равна : 5000.0 руб.",result)
    }

    @Test
    fun calculationVKPayAmountTransferMore(){
        val cardType = "VKPay"
        val amountTransfer = 150_000.1
        val amountPreviousTransfer = 7600
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
    @Test
    fun calculationVKPayAmountPreviousTransferMore(){
        val cardType = "VKPay"
        val amountTransfer = 1000.0
        val amountPreviousTransfer = 600_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
    @Test
    fun calculationVisa(){
        val cardType = "Visa"
        val amountTransfer = 10_000.0
        val amountPreviousTransfer = 30_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Сумма вашего перевода равна : 9925.0 руб.",result)
    }
    @Test
    fun calculationVisaAmountTransferMore(){
        val cardType = "Visa"
        val amountTransfer = 151_000.0
        val amountPreviousTransfer = 600_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
    @Test
    fun calculationVisaSmallAmount(){
        val cardType = "Visa"
        val amountTransfer = 32.0
        val amountPreviousTransfer = 30_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Минимальная сумма с картой Visa|Мир 35 руб.",result)
    }
    @Test
    fun calculationVisaAmountPreviousTransferMore(){
        val cardType = "Visa"
        val amountTransfer = 10_000.0
        val amountPreviousTransfer = 700_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
    @Test
    fun calculationMaestro(){
        val cardType = "Maestro"
        val amountTransfer = 10_000.0
        val amountPreviousTransfer = 30_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Сумма вашего перевода равна : 10000.0 руб.",result)
    }
    @Test
    fun calculationMaestroAmountTransferCommission(){
        val cardType = "Maestro"
        val amountTransfer = 77_000.0
        val amountPreviousTransfer = 30000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Сумма вашего перевода равна : 76518.0 руб.",result)
    }
    @Test
    fun calculationMaestroAmountPreviousTransferCommission(){
        val cardType = "Maestro"
        val amountTransfer = 77_000.0
        val amountPreviousTransfer = 700_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
    @Test
    fun calculationCardWorld(){
        val cardType = "Мир"
        val amountTransfer = 10_000.0
        val amountPreviousTransfer = 10_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Сумма вашего перевода равна : 9925.0 руб.",result)
    }

    @Test
    fun calculationCardWorldAmountTransferMore(){
        val cardType = "Мир"
        val amountTransfer = 151_000.0
        val amountPreviousTransfer = 10_000
        val result = calculation(cardType, amountPreviousTransfer, amountTransfer)
        assertEquals("Превышен лимит на перевод",result)
    }
}