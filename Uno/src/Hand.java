import java.util.ArrayList;

/**
 * Class representing a Hand in an UNO game. Has-a relationship with class Card
 * @author Brandon Tenorio
 */
public class Hand extends Card implements CardConstants{

    private ArrayList<Card> hand = new ArrayList<>();

    /**
     * Default constructor creates an ArrayList representing an empty hand
     */
    public Hand(){
        hand = new ArrayList<Card>();
    }

    /**
     * Returns an ArrayList containing information about the cards in the hand
     * @return arrayList of Card objects
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * Removes all elements from ArrayList "hand"
     */
    public void clear(){
        hand.clear();
    }

    /**
     * Adds a Card object to ArrayList hand
     * @param c card object
     */
    public void add(Card c){
        if(c == null){
            throw new NullPointerException("Ain't no card here mane");
        }
        hand.add(c);
    }

    /**
     * Removes card object from array list hand
     * @param c card object
     */
    public void remove(Card c){
        hand.remove(c);
    }

    /**
     * Removes card object at a specific location of arraylist hand
     * @param position index of arrayList hand
     */
    public void remove(int position){
        if(position < 0 || position > hand.size())
            throw new IllegalArgumentException("Mane, ain't no card in this position mane wtf");
        hand.remove(position);
    }

    /**
     * Returns size of arrayList hand representing total cards in hand
     * @return size of arrayList hand
     */
    public int cardCount(){
        return hand.size();
    }
}