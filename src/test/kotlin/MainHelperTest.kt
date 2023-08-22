import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import MainHelper.checkIsPalindrome
import MainHelper.filterPalindromes
import MainHelper.filterWithSpecialChars
import MainHelper.getCharValues
import MainHelper.getSubsequences
import MainHelper.processPositions
import kotlin.test.assertFalse

class MainHelperTest {

    @Test
    fun `given special char is greater than 0 when calls processPositions then should return processed value`() {
        val processedList = processPositions("1 7", "BANANAS")
        assertEquals("7", processedList)
    }

    @Test
    fun `given special char is 0 when calls processPositions then should return processed value`() {
        val processedList = processPositions("0", "BANANAS")
        assertEquals("71234567", processedList)
    }

    @Test
    fun `given word is abc when calls getSubsequences then should return all subs sequences`() {
        val expected = listOf("", "c", "b", "bc", "a", "ac", "ab", "abc")
        val actual = getSubsequences("abc")
        assertTrue(expected.containsAll(actual))
    }

    @Test
    fun `given subsequence is valid when calls filterPalindromes then should return a list of palindromes`() {
        val expected = listOf("", "a", "n", "n", "nn", "a", "aa", "ana", "ana", "anna", "b")
        val mockSubsequences = listOf(
            "", "a", "n", "an", "n", "an", "nn", "ann",
            "a", "aa", "na", "ana", "na", "ana", "nna", "anna",
            "b", "ab", "nb", "anb", "nb", "anb", "nnb", "annb",
            "ab", "aab", "nab", "anab", "nab", "anab", "nnab", "annab"
        )
        val filteredSubs = filterPalindromes(mockSubsequences)
        assertEquals(filteredSubs, expected)
    }

    @Test
    fun `given word is palindrome when calls checkIsPalindrome then should return true`() {
        assertTrue(checkIsPalindrome("ANANA"))
    }

    @Test
    fun `given word is not palindrome when calls checkIsPalindrome then should return false`() {
        assertFalse(checkIsPalindrome("NANA"))
    }

    @Test
    fun `given special position is valid when calls getCharValues then should return list of special char`() {
        val specialChar = getCharValues("ACDAAACX", "238")
        assertEquals(listOf('C', 'D', 'X'), specialChar)
    }

    @Test
    fun `given palindromesSubsequence is valid whe calls filterWithSpecialChars then should return list of subsequence with specials chars`() {
        val mockPalindromeSubsequence = listOf("", "a", "n", "n", "nn", "a", "aa", "ana", "ana", "anna", "b")
        val result = filterWithSpecialChars(mockPalindromeSubsequence, listOf('b'))
        assertEquals("b", result.last())
    }

}