object CoinCalculator {

    fun runApp() {
        var inputs = readlnOrNull().toString().toInt()
        val cents = listOf(100, 50, 25, 10, 5, 1)

        val divisorCount = mutableMapOf<Int, Int>()

        for (unitCents in cents) {
            while (inputs >= unitCents) {
                divisorCount[unitCents] = divisorCount.getOrDefault(unitCents, 0) + 1
                inputs -= unitCents

            }
        }

        println("${divisorCount.values.sum()}")
        for (unitCents in cents) {
            if (divisorCount.containsKey(unitCents)) {
               println("${divisorCount[unitCents]}")
            } else {
                println(0)
            }
        }
    }
}