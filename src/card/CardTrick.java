/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * add a date
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Zaid, 991643824
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            int value = (int) (Math.random() * 13 + 1);
            int suitIndex = (int) (Math.random() * 4);
            c.setValue(value);
            c.setSuit(Card.SUITS[suitIndex]);
            magicHand[i] = c;
        }
        
        try ( // clicking username input
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a card value (1-13):");
            int userValue = scanner.nextInt();
            System.out.println("Enter a suit (Hearts, Diamonds, Spades, Clubs):");
            String userSuit = scanner.next();
            Card userCard = new Card();
            userCard.setValue(userValue);
            userCard.setSuit(userSuit);
            
            // carfound and break line after
            boolean cardFound = false;
            for (Card card : magicHand) {
                if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                    cardFound = true;
                    break;
                }
            }
            
            // Result
            // card found and else
            if (cardFound) {
                System.out.println("Congratulations! Your card is in the magic hand!");
            } else {
                System.out.println("Sorry! Your card is not in the magic hand.");
            }
        }
    }
}
    
