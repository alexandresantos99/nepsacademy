import MainHelper.filterPalindromes
import MainHelper.filterWithSpecialChars
import MainHelper.getCharValues
import MainHelper.getSubsequences
import MainHelper.processPositions

fun main() {
    //CoinCalculator.runApp()
    val inputs = readInputs()

    val word = inputs[0]
    val specialPositions = inputs[1]

    val subsequences = getSubsequences(word)
    val palindromicSubsequences = filterPalindromes(subsequences)

    val specialChars = getCharValues(word, specialPositions)

    val palindromesWithSpecialChars = filterWithSpecialChars(palindromicSubsequences, specialChars)

    val result = palindromesWithSpecialChars.maxByOrNull { it.length }
    println(result?.length)
}

fun readInputs(numberOfLines: Int = 2): List<String> {
    val returnListInputs = mutableListOf<String>()

    while (returnListInputs.size < numberOfLines) {
        val inputRow: String? = try {
            readlnOrNull()
        } catch (e: Exception) {
            null
        }

        if (!inputRow.isNullOrBlank() && inputRow.length <= 2000) {
            returnListInputs.add(inputRow)
        }
    }

    return validateInputs(returnListInputs)
}

fun validateInputs(returnListInputs: MutableList<String>): MutableList<String> {
    val word = returnListInputs[0]
    var specialPositions = returnListInputs[1]
    val limit = word.length + 1

    var positionsList = specialPositions.drop(1).map { it.toString().toInt() }

    while (positionsList.any { it >= limit } || specialPositions.isNullOrBlank()) {
        if (specialPositions.isNullOrBlank()) {
            println("Entrada vazia não é permitida. Por favor, insira as posições especiais.")
        } else {
            println("Uma ou mais posições especiais excedem o limite. Por favor, insira valores abaixo de $limit.")
        }
        println("Por favor, digite novamente as posições especiais:")
        specialPositions = readlnOrNull() ?: ""
        positionsList = specialPositions.drop(1).map { it.toString().toInt() }
    }

    val processedPositions = processPositions(specialPositions, word)

    returnListInputs[1] = processedPositions
    return returnListInputs
}


