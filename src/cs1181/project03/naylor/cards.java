package cs1181.project03.naylor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cards {

    private final Scanner in = new Scanner(System.in);
    
    private final ArrayList<Queue> shuffledDeck = new ArrayList<>();
    private Queue deck;
    private Deque<String> stack = new ArrayDeque<>();

    public Deque<String> getStack() {
        return stack;
    }

    public void setStack(Deque<String> stack) {
        this.stack = stack;
    }
    
    
    public cards() {
        this.deck = new LinkedList<>();
    }
//    private ArrayList<cards> deck = new ArrayList<>();

    /**
     * The purpose of this method is to build our deck of cards. This method
     * takes the parameter(s) cardType which is passed "Spades", "Hearts",
     * "Clubs" and Diamonds in the main method. This method also scambles the 
     * cards in the deck. 
     *
     * @param cardType
     * @return
     */
    public Queue creatingDeck(String cardType1, String cardType2, 
            String cardType3, String cardType4, String exclusive1, 
            String exclusive2, String exclusive3) {
        //INFO: Cards  
        //52 cards total:
        //Each card has a number 2 - 10, and a suit:(hearts, diamonds, clubs or spades).
        //Example: 8 of spades
        // Or exclusive: jack, queen, king, or ace

        // Data Structure for the deck of cards
//        Queue<String> deck = new LinkedList<>();
      
        // Adding suit to LinkedList
        for (int i = 1; i <= 10; i++) {
            if (i == 1) { //There is no one of anything. It is called an ace
                deck.add("Ace of " + cardType1);
                deck.add("Ace of " + cardType2);
                deck.add("Ace of " + cardType3);
                deck.add("Ace of " + cardType4);

            }
            
            // Card type number values are mixed to aide in shuffling
            if(i > 1){
                
            deck.add(i + " of " + cardType4);
            deck.add(i + " of " + cardType1);
            deck.add(i + " of " + cardType2);
            deck.add(i + " of " + cardType3);
            
            }
        }

        // Card type number values are mixed to aide in shuffling

        deck.add(exclusive1 + " of " + cardType1);
        deck.add(exclusive1 + " of " + cardType2);
        deck.add(exclusive1 + " of " + cardType4);
        deck.add(exclusive1 + " of " + cardType3);

        // Card type number values are mixed to aide in shuffling
        deck.add(exclusive2 + " of " + cardType4);
        deck.add(exclusive2 + " of " + cardType3);
        deck.add(exclusive2 + " of " + cardType2);
        deck.add(exclusive2 + " of " + cardType1);

        // Card type number values are mixed to aide in shuffling
        deck.add(exclusive3 + " of " + cardType4);
        deck.add(exclusive3 + " of " + cardType3);
        deck.add(exclusive3 + " of " + cardType1);
        deck.add(exclusive3 + " of " + cardType2);
        
        //Exclusives:
        //2 Jokers in every deck
        for (int i = 0; i < 2; i++) {
            deck.add("Joker");
        }

        //shuffle Cards
        Collections.shuffle((LinkedList) deck);

        return deck;
    }
    


}
