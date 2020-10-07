package cs1181.project03.naylor;

import java.util.Queue;
import java.util.Scanner;

public class driver {

    private static final Scanner in = new Scanner(System.in);
    private static Queue shuffledDeck;

    public static void main(String[] args) {
        //Welcome the user
        System.out.println("Welcome to Spoons! ");

        // cards object
        cards setup = new cards();
//TODO: Consider calling this method several times, using more versatile 
//create deck method

        //This adds cards to group's deck, including Joker
        shuffledDeck = setup.creatingDeck("Clubs", "Spades", "Diamonds",
                "Hearts", "Jack", "Queen", "King");
        //The deck is now setup

        player p = new player();
        
        //Starting game process
        p.distributeCards(shuffledDeck);

    }

}
