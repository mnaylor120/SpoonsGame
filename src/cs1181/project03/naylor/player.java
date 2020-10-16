package cs1181.project03.naylor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class player {

    private Scanner in = new Scanner(System.in);
    private ArrayList<String> personalDeck = new ArrayList<>();
    Stack<String> discardDeck = new Stack<>();

    public ArrayList<String> getPersonalDeck() {
        return personalDeck;
    }

    public void setPersonalDeck(ArrayList<String> personalDeck) {
        this.personalDeck = personalDeck;
    }

    /**
     * The purpose of this method is to add cards from the master deck to each
     * players personal deck that corresponds to them. This method also
     * implements gameplay with the if statement at the end of the method
     *
     * @param deck
     * @return
     */
    public ArrayList distributeCards(Queue deck) {

        // Distribute  cards to players
        for (int i = 0; i < 4; i++) { //Give each player 4 cards
            personalDeck.add((String) deck.poll());
        }

        // Printing out results
        String display = "";
        for (int i = 0; i < personalDeck.size(); i++) {
            display += (i + 1) + ". " + personalDeck.get(i) + "\n";
        }
        System.out.println(display);

        if (discardDeck.isEmpty()) {
            System.out.println("Your discard pile is empty -- You must draw a card.");
            drawRandCard(deck, personalDeck);
        }

        return personalDeck;
    }

    /**
     * This method draws a random card from the master deck and gives it to the
     * personal deck
     *
     * @param deck
     * @param personalDeck
     */
    public void drawRandCard(Queue deck, ArrayList personalDeck) {
        // getting the card on the top of the drawing deck
        String onTop = (String) deck.poll();
        System.out.println("You drew the " + onTop);

        //Adding our recently drawn card to our deck
        personalDeck.add(onTop);

        //Printing out our updated personalDeck
        String display = "";
        for (int i = 0; i < personalDeck.size(); i++) {
            display += (i + 1) + ". " + personalDeck.get(i) + "\n";
        }

        System.out.println(display);

        //We cannot have more than 4 cards without
        //taking affermative action. 
        if (personalDeck.size() > 4) {
            discardCard(deck, discardDeck, personalDeck);
        }

    }

    public void play(Queue deck, Stack discardDeck, ArrayList personalDeck) {

        System.out.println("The top card in the discard deck: " + discardDeck.lastElement());
        int answer = 0;

        while (true) {
            try {
                
                System.out.println(cardType1);
                //TODO: Check if player is winner
                //Get player info first
                //If four of the same suite then winner = true
                //Explore different searching algorithms to find most effecient one. 
                System.out.println("Do you want to draw (1) or get the " + discardDeck.lastElement() + " (2). ");
                answer = in.nextInt();
            } catch (InputMismatchException e) {
                in.next();
                System.err.println("Please enter a valid integer. ");
            }
            if (answer < 1 || answer > 2) {
                System.err.println("Please enter a valid entry, either one or two ");
                continue;
            }
            if (answer == 1) {//Drawing a new card. 
                drawRandCard(deck, personalDeck);
            } else if (answer == 2) { //user wants to draw from discard deck
                personalDeck.add(discardDeck.lastElement());
                drawRandCard(deck, personalDeck);
            }

        }
    }

    /**
     * This method adds a card that the user selects to the discard pile
     *
     * @param deck
     * @param discardDeck
     * @param personalDeck
     */
    public void discardCard(Queue deck, Stack discardDeck, ArrayList personalDeck) {
        int cardToDiscard = 0;
        int index = 0;
        while (true) {
            try {

                System.out.print("You have to get rid of a card, type which"
                        + " number you want to get rid of. ");
                // number associated with card they're discarding
                cardToDiscard = in.nextInt();
                //Change number to work with the ArrayList index
                index = cardToDiscard - 1;
                // If the user inputs everything correctly, exit loop
                break;
            } catch (InputMismatchException e) {
                //stop while loop
                in.next();
                //Inform user of their error 
                System.err.println("Please type in a valid card number");
            }
        }
        //Get the name of the card that the player wants to remove
        String removedCard = (String) personalDeck.get(index);

        //Remove the card from the deck
        personalDeck.remove(index);
        // Move it to discard deck 
        discardDeck.add(removedCard);

        //Printing our most recent version of this deck. 
        String display = "";
        display = "Your cards are: \n";
        for (int i = 0; i < personalDeck.size(); i++) {
            display += (i + 1) + ". " + personalDeck.get(i) + "\n";
        }

        System.out.println(display);
        play(deck, discardDeck, personalDeck);

    }

    public boolean isWinner() {
      return false;

    }

}
