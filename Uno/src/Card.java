/**
 * @author Brandon Tenorio
 * A class to hold information about the cards in a deck. It tells you the name, the color, and the number of a card, as well as what it does
 */

public class Card implements CardConstants{

    private String color;
    private int value;
    private String type;

    public Card(){
        this.color = "";
        this.value = 0;
        this.type = "";
    }
    /**
     * Parameterized constructor for regular cards. Initiates 76 cards (19 for each color) with their color and their number
     * @param color The color of the card
     * @param value The number of the card
     */
    public Card(String color, int value){
        this.color = color;
        this.value = value;
        this.type = "REGULAR";
    }

    /**
     * Parameterized constructor for non-wild cards. Initializes 24 non-wild cards to their color and the type of cards they are
     * @param color The color of the card
     * @param type The type of the card
     */
    public Card(String color, String type){
        this.color = color;
        this.value = -1;
        this.type = type;
    }

    /**
     * Parameterized constructor for wild cards. Initializes wild card with the type of wild card that it is.
     * @param type
     */
    public Card(String type){
        this.color = "N/A";
        this.value = -1;
        this.type = type;
    }

    /**
     * sets Color for a particular Card
     * @param color color of the card
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the type for a particular card
     * @param type the type of the card
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * sets the number that a particular card will hold
     * @param value the number on the card
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the color of the card
     * @return card's color
     */
    public String getColor(){
        return color;
    }

    /**
     * Returns the number/value of the card
     * @return value
     */
    public int getValue(){
        return value;
    }

    /**
     * Returns the type of the card
     * @return type
     */
    public String getType(){
        return type;
    }

    /**
     * Overrides built-in toString method. Prints out information about a card
     * @return a String with information about the card
     */
    @Override
    public String toString(){
        return "Information about this card about this card:\n -Color: " + color + "\n -Type: " + type + "\n -Value: " + value;
    }


}
