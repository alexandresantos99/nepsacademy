object MainHelper {

    fun processPositions(specialPositions: String, word: String): String {
        return when (specialPositions) {
            "0" -> "${word.length}" + (1..<word.length + 1).joinToString("")
            else -> specialPositions.replace(" ", "").drop(1)
        }
    }

    fun getSubsequences(word: String): List<String> {
        if (word.isEmpty()) {
            return listOf("")
        }

        val firstChar = word.first()

        return getSubsequences(word.drop(1)).flatMap { subsequence ->
            listOf(subsequence, firstChar + subsequence)
        }
    }

    fun filterPalindromes(subsequences: List<String>): List<String> {
        return subsequences.filter { word ->
            checkIsPalindrome(word)
        }
    }

    fun checkIsPalindrome(insertedWord: String): Boolean = insertedWord.reversed() == insertedWord

    fun getCharValues(word: String, specialPositions: String): List<Char> {
        val listNumbersOfChar = specialPositions.map { char ->
            char.toString().toInt()
        }

        return extractCharactersByIndices(word, listNumbersOfChar)
    }

    private fun extractCharactersByIndices(word: String, listNumbersOfChar: List<Int>): List<Char> {
        return listNumbersOfChar.map { index ->
            word[index - 1]
        }
    }

    fun filterWithSpecialChars(palindromesSubsequence: List<String>, charsToFilter: List<Char>): List<String> {
        return palindromesSubsequence.filter { palindromeWord ->
            palindromeWord.all { char ->
                char in charsToFilter
            }
        }
    }
}