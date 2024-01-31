package utils

import java.util.*
import kotlin.random.Random

class Generator {
    fun generujPocetLidi(datumVMilisekundach: Long): Int {
        val calendar = Calendar.getInstance().apply { timeInMillis = datumVMilisekundach }
        val denVTydnu = calendar.get(Calendar.DAY_OF_WEEK)
        val hodina = calendar.get(Calendar.HOUR_OF_DAY)
        val random = Random(datumVMilisekundach)

        val zakldniVypocet = when (hodina) {
            in 0..5 -> random.nextInt(50) // méně lidí v noci
            in 6..9, in 17..20 -> random.nextInt(3000) // více lidí když jdou do práce
            else -> random.nextInt(500) // standartní počet lidí
        }

        return when (denVTydnu) {
            Calendar.MONDAY, Calendar.FRIDAY -> (zakldniVypocet * 1.2).toInt() // 20% víc lidí, když je těžké pondělí a v pátek kdy vypadnou pryč
            Calendar.SATURDAY, Calendar.SUNDAY -> (zakldniVypocet * 0.8).toInt() // 20% méně lidí o víkendu, kdy odpočívají
            else -> zakldniVypocet
        }
    }
}