/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package poker

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows

class CardTest {
    @Test
    fun testHasSuit() {
        val card = Card("Queen", "Hearts")
        assertEquals(card.rank, "Queen")
    }

    @Test
    fun testHasRank() {
        val card = Card("Queen", "Hearts")

        assertEquals(card.suit, "Hearts")
    }

    @Test
    fun testHasToString() {
        val card = Card("Queen", "Hearts")

        assertEquals("Card('Queen', 'Hearts')", card.toString(), "Getting ${card.toString()}")
    }

    @Test
    fun testHasFourPossibleRankOptions() {
        val expected = arrayListOf("Hearts", "Clubs", "Spades", "Diamonds")

        assertTrue(
                Card.SUITS.equals(expected),
                "Getting ${Card.SUITS.toString()}, It should be ${expected}"
        )
    }
    @Test
    fun testHasThirteenPossibleSuitOptions() {
        val expected =
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

        assertTrue(
                Card.RANKS.equals(expected),
                "Getting ${Card.RANKS.toString()}, It should be ${expected}"
        )
    }
    @Test
    fun testInvalidRankDidRaise() {
        assertThrows(
                IllegalArgumentException::class.java,
                { Card("test", "Spades") },
                "Invalid rank should be throw"
        )
    }

    @Test
    fun testInvalidSuitDidRaise() {
        assertThrows(
                IllegalArgumentException::class.java,
                { Card("2", "test") },
                "Invalid suit should be throw"
        )
    }
    @Test
    fun testDeckDidHave52Cards() {
        val cards = Card.Create52Cards()
        assertEquals(52, cards.size, "Should have 52 cards, getting ${cards.size}")
    }
    @Test
    fun testCanCreate52Cards() {
        val _52Cards = Card.Create52Cards()
        val firstCard = Card("2", "Hearts")
        val finalCard = Card("Ace", "Diamonds")
        assertEquals(firstCard, _52Cards[0], "First card should be $firstCard, getting ${_52Cards[0]}")
        assertEquals(finalCard, _52Cards[_52Cards.lastIndex], "Final card should be $finalCard, getting ${_52Cards[_52Cards.lastIndex]}")

    }

    @Test
    fun testIfTwoCardsAreEqual() {
        assertEquals(Card("Queen", "Hearts"), Card("Queen", "Hearts"))
    }
}

class DeckTest {

    @Test
    fun testStoresNoCardsAtStart() {
        val deck = Deck()
        assertEquals(0, deck.cards.size, "New deck should contains no cards at all")
    }
    @Test
    fun testAddCardsToDeckCollection() {
        val deck = Deck()
        val cards = arrayListOf(Card("Queen", "Hearts"))
        deck.addCards(cards)
        assertEquals(arrayListOf(Card("Queen", "Hearts")), deck.cards)
    }
    
}

class HandTest{
    companion object {
        val highCards = arrayListOf(
            Card("Ace", "Spades"),
            Card("6", "Clubs")
        )
        val pair = arrayListOf(
            Card("Ace", "Spades"),
            Card("Ace", "Clubs")
        )

        val twoPair = arrayListOf(
            Card("Ace", "Spades"),
            Card("Ace", "Clubs"),
            Card("3", "Spades"),
            Card("3", "Clubs")
        )
        val threeOfAKind = arrayListOf(
            Card("Ace", "Spades"),
            Card("Ace", "Clubs"),
            Card("Ace", "Hearts"),
            Card("3", "Clubs")
        )
    }

    @Test
    fun testReceiveAndStoreCards() {
        val hand = Hand(highCards)
        assertEquals(hand.cards, highCards)
    }

    @Test
    fun testHighCardIsBestRank() {
        val hand = Hand(highCards)

        assertEquals("High Card", hand.bestHand())
    }

    @Test
    fun testPairIsBestRank() {
        val hand = Hand(pair)
        assertEquals("Pair", hand.bestHand())
    }

    @Test
    fun testTwoPairIsBestRank() {
        val hand = Hand(twoPair)
        assertEquals("Two Pair", hand.bestHand())
    }

    @Test
    fun testThreeOfAKindIsBestRank() {
        val hand = Hand(threeOfAKind)
        assertEquals("Three Of A Kind", hand.bestHand())
    }



}