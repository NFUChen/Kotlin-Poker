package poker

data class Hand(val cards: ArrayList<Card>) {
    

    private fun rankWithTargetCount(target: Int): Map<String, Int> {
        val countMap = mutableMapOf<String, Int>()
        for (card in cards) {
            countMap.put(card.rank, countMap.getOrDefault(card.rank, 0) + 1) 
        }

        return countMap.filter { (_, count) -> count >= target }
    }

    private fun isStraight(): Boolean {
        val sortedCards = ArrayList(cards.map { card -> card.copy() })
        sortedCards.sort()
        for (idx in 1..<cards.size ) {
            val prevCard = sortedCards[idx - 1]
            val currCard = sortedCards[idx]
            if (currCard.rankIdx != (prevCard.rankIdx + 1)) {
                return false
            }
        }

        return true
    }

    private fun isThreeOfAKind(): Boolean {

        val rankCount = rankWithTargetCount(3)
        val isValid = rankCount.size == 1
        if (isValid) {
            return true
        }

        return false
    }

    private fun isTwoPair(): Boolean {
        val rankCount = rankWithTargetCount(2)
        val isValid = rankCount.size == 2
        if (isValid) {
            return true
        }


        return false
    }

    private fun isPair(): Boolean {
        val rankCount = rankWithTargetCount(2)
        val isValid = rankCount.size == 1
        if (isValid) {
            return true
        }

        return false
    }

    private fun isHighCard(): Boolean {
        return true
    }

    fun bestHand(): String {

        val validatorsWithRankNames = mapOf(
            "Straight" to ::isStraight,
            "Three Of A Kind" to ::isThreeOfAKind,
            "Two Pair" to ::isTwoPair,
            "Pair" to ::isPair, 
            "High Card" to ::isHighCard
        )

        for ((rankName, func) in validatorsWithRankNames) {
            if (func()) {
                return rankName
            }
        }
        return ""
    }
}