package poker

data class Card(val rank: String, val suit: String) : Comparable<Card> {
    val rankIdx = RANKS.indexOf(rank)
    val suitIdx = SUITS.indexOf(suit)
    companion object {
        val SUITS = arrayListOf("Hearts", "Clubs", "Spades", "Diamonds")
        val RANKS =
                arrayListOf(
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "10",
                        "Jack",
                        "Queen",
                        "King",
                        "Ace"
                )
        fun Create52Cards(): ArrayList<Card> {
            val cards: ArrayList<Card> = arrayListOf()
            
            for (suit in Card.SUITS) {
                for (rank in Card.RANKS) {
                    cards.add(Card(rank, suit))
                }
            }

            return cards
        }
    }
    init {
        require(SUITS.contains(suit)) {
            "Invalid suit: $suit, please enter one of the following: $SUITS"
        }
        require(RANKS.contains(rank)) {
            "Invalid suit: $rank, please enter one of the following: $RANKS"
        }
    }

    override fun compareTo(other: Card): Int {
        if (other.rank == rank && other.suit == suit) {
            return 0
        }
        if (rankIdx < other.rankIdx) {
            return -1
        }


        return 1
    }

    override fun toString(): String {
        return "Card('$rank', '$suit')"
    }
}
