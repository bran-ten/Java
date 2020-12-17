import java.util.ArrayList;
import java.util.*;

/**
 * @author Brandon Tenorio
 * A class representing a deck of cards. Is-a relationship with class card.
 */
public class Deck extends Card implements CardConstants{

    private int cardsUsed = 0;
    ArrayList<Card> deckOfCards = new ArrayList<>();
    Card rCard,  bCard,  yCard,  gCard,
         rsCard, bsCard, ysCard, gsCard,
         rwCard, bwCard, ywCard, gwCard;

    /**
     * Default constructor. Creates a Deck of Card objects with Regular, Wild, and Special type cards.
     * int i serves as a counter to iterate through the various arrays in this constructor.
     */
    public Deck(){
        int i = 0;
        // 76 regular cards
        int REGULAR_CARDS = (REGULAR_CARDS_PER_COLOR * TOTAL_COLORS);
        while(deckOfCards.size() < REGULAR_CARDS){
            if(i == 10) {
                i = 1;
            }
            rCard = new Card(RED, i);
            bCard = new Card(BLUE, i);
            yCard = new Card(YELLOW, i);
            gCard = new Card(GREEN, i);

            deckOfCards.add(rCard);
            deckOfCards.add(bCard);
            deckOfCards.add(yCard);
            deckOfCards.add(gCard);
            i++;
        }

        i=0;
        // 100 regular + special cards
        int REGULAR_SPECIAL_CARDS = (REGULAR_CARDS + (SPECIAL_CARDS_PER_COLOR * TOTAL_COLORS * TOTAL_SPECIAL_CARDS));
        while(deckOfCards.size() >= REGULAR_CARDS && deckOfCards.size() < REGULAR_SPECIAL_CARDS){
            if(i == 3){
                i = 0;
            }
            // Array containing the 3 different types of special cards
            String[] specialTypes = {"DRAW TWO", "REVERSE", "SKIP"};
            rsCard = new Card(RED, specialTypes[i]);
            bsCard = new Card(BLUE, specialTypes[i]);
            ysCard = new Card(YELLOW, specialTypes[i]);
            gsCard = new Card(GREEN, specialTypes[i]);

            deckOfCards.add(rsCard);
            deckOfCards.add(bsCard);
            deckOfCards.add(ysCard);
            deckOfCards.add(gsCard);
            i++;
        }

        i = 0;
        // Array holding the types of wild type cards
        String[] wildTypes = {"WILD", "DRAW FOUR"};
        while(deckOfCards.size() >= REGULAR_SPECIAL_CARDS && deckOfCards.size() < (TOTAL_CARDS - TOTAL_WILD_DRAW_FOUR_CARDS)){
            if(i == 1){
                i = 0;
            }
            rwCard = new Card(wildTypes[i]);
            bwCard = new Card(wildTypes[i]);
            ywCard = new Card(wildTypes[i]);
            gwCard = new Card(wildTypes[i]);

            deckOfCards.add(rwCard);
            deckOfCards.add(bwCard);
            deckOfCards.add(ywCard);
            deckOfCards.add(gwCard);
            i++;
        }

        i = 1;
        // 112 - 4 = 108
        int REGULAR_SPECIAL_WILD_CARDS = TOTAL_CARDS - TOTAL_WILD_DRAW_FOUR_CARDS;
        while(deckOfCards.size() >= REGULAR_SPECIAL_WILD_CARDS && deckOfCards.size() < TOTAL_CARDS){
            rwCard = new Card(wildTypes[i]);
            bwCard = new Card(wildTypes[i]);
            ywCard = new Card(wildTypes[i]);
            gwCard = new Card(wildTypes[i]);

            deckOfCards.add(rwCard);
            deckOfCards.add(bwCard);
            deckOfCards.add(ywCard);
            deckOfCards.add(gwCard);
        }
    }

    /**
     * Returns an array list of card objects
     * @return Deck
     */
    public ArrayList<Card> getDeck(){
        return deckOfCards;
    }

    /**
     * This method iterates through the ArrayList deckOfCards searching for cards whose color is param color and returns
     * how many of that color card there are left in the deck
     * @param color The color of the card that the user wants to search for in the arrayList
     * @return colorToReturn
     */
    public int getColorAndTypeTotal(String color, String type){
        color = color.toUpperCase();
        type = type.toUpperCase();
        int colorAndTypeTotal = 0;

        for (Card cardInDeck : deckOfCards) {
            if (cardInDeck.getColor().equals(color)  && cardInDeck.getType().equals(type)) {
                colorAndTypeTotal += 1;
            }
        }
        return colorAndTypeTotal;
    }

    /**
     * Method iterates through the arrayList deckOfCards searching for the type of cards passed into the param.
     * Returns how many of that card type are found in the deck.
     * this method is primarily reserved for wild cards and wild draw four cards
     * @param type the type to be searched
     * @return the total amount of cards of that special type in the deck
     */
    public int getTypeTotal(String type){
        type = type.toUpperCase();
        int specialTypeTotal = 0;

        for (Card cardInDeck : deckOfCards) {
            if (cardInDeck.getType().equals(type)) {
                specialTypeTotal += 1;
            }
        }
        return specialTypeTotal;
    }

    /**
     * Returns the difference of total cards in the deck minus cards used
     * @return total cards - cards used
     */
    public int cardsLeft(){
        return TOTAL_CARDS - cardsUsed;
    }

    /**
     * Using the java.util.Collections class, this method shuffles an arrayList of Card objects
     */
    public void shuffle(){
        Collections.shuffle(deckOfCards);
    }

    /**
     * Deals a card from the deck
     * @return card object from deck arrayList
     * @throws IllegalStateException if there are no cards left
     */
    public Card dealCard(){
        if (cardsUsed == 112)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        Card c = deckOfCards.get(TOTAL_CARDS - cardsUsed);
        deckOfCards.remove(TOTAL_CARDS - cardsUsed);
        return c;
    }

    /**
     * Returns a String object with information about how many cards are left in this deck
     * @return information about how many cards are left in this Deck object
     */
    @Override
    public String toString(){
        return "Information about this deck:" +
                "\n-Cards left: " + cardsLeft() +
                "\n-Cards used: " + cardsUsed +

                "\n\n-Yellow Regular cards left: " + getColorAndTypeTotal("yellow", "regular") +
                "\n-Yellow Draw two cards left: " + getColorAndTypeTotal("yellow", "draw two") +
                "\n-Yellow Reverse cards left: " + getColorAndTypeTotal("yellow", "reverse") +
                "\n-Yellow Skip cards left: " + getColorAndTypeTotal("yellow", "skip") +

                "\n\n-Green Regular cards left: " + getColorAndTypeTotal("green", "regular") +
                "\n-Green Draw two cards left: " + getColorAndTypeTotal("blue", "draw two") +
                "\n-Green Reverse cards left: " + getColorAndTypeTotal("blue", "reverse") +
                "\n-Green Skip cards left: " + getColorAndTypeTotal("blue", "skip") +

                "\n\n-Blue Regular cards left: " + getColorAndTypeTotal("blue", "regular") +
                "\n-Blue Draw two cards left: " + getColorAndTypeTotal("blue", "draw two") +
                "\n-Blue Reverse cards left: " + getColorAndTypeTotal("blue", "reverse") +
                "\n-Blue Skip cards left: " + getColorAndTypeTotal("blue", "skip") +

                "\n\n-Red Regular cards left: " + getColorAndTypeTotal("red", "regular") +
                "\n-Red Draw two cards left: " + getColorAndTypeTotal("red", "draw two") +
                "\n-Red Reverse cards left: " + getColorAndTypeTotal("red", "reverse") +
                "\n-Red Skip cards left: " + getColorAndTypeTotal("red", "skip") +

//                "\n-Total Draw two cards left: " + getTypeTotal("draw two") +
//                "\n-Total Reverse cards left: " + getTypeTotal("reverse") +
//                "\n-Total Skip cards left: " + getTypeTotal("skip") +

                "\n\n-Wild cards left: "+ getTypeTotal("wild") +
                "\n-Draw four cards left: " + getTypeTotal("draw four");
    }
}
