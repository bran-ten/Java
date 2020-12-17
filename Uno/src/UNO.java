public class UNO extends Card implements CardConstants{
    public static void main(String[] args) {
        Deck d1 = new Deck();
        Hand h1 = new Hand();

        d1.shuffle();

        h1.add(d1.dealCard());
        h1.add(d1.dealCard());
        h1.add(d1.dealCard());
        h1.add(d1.dealCard());
        h1.add(d1.dealCard());
        h1.add(d1.dealCard());
        h1.add(d1.dealCard());


        for(int i = 0; i < h1.cardCount(); i++){
            System.out.println(h1.getHand().get(i));
            System.out.println();
        }

        System.out.println(d1.toString());


    }
}
