package poker

import kotlin.collections.arrayListOf

class Deck() {
    val cards: ArrayList<Card> = arrayListOf()

    fun addCards(newCards: ArrayList<Card>) {
        cards.addAll(newCards)
    }
}
