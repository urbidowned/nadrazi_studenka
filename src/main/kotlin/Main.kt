import utils.Generator
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    println("Vítejte na vlakovém nádraží Studénka")
    print("Zadejte prosím datum v milisekundách ")

    var datumVMilisekundach: Long? = null
    val ted = System.currentTimeMillis()
    val threeMonthsLater = ted + TimeUnit.DAYS.toMillis(360)

    while (datumVMilisekundach == null || datumVMilisekundach < ted || datumVMilisekundach > threeMonthsLater) {
        print("Zadejte validní čas v milisekundách od teď do maximálně jednoho roku v budoucnu: ")
        val userInput = readLine() ?: ""
        datumVMilisekundach = userInput.toLongOrNull()

        if (datumVMilisekundach == null) {
            println("Nevložil/a jste číslo v milisekundách. Prosím NAPRAVTE TO!")
        } else if (datumVMilisekundach < ted || datumVMilisekundach > threeMonthsLater) {
            println("Vaše datum NENÍ v horizontu jednoho roku. Zopakujte prosím zadání.")
        }
    }

    val generator = Generator()
    val početLidí = generator.generujPocetLidi(datumVMilisekundach)
    println("Number of people: $početLidí")

}
