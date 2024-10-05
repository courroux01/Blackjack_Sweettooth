package com.sweettooth.blackjack;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// Some of the code here is for future project reference
public class Blackjack {
    
    private ArrayList<Card> currentDeck;
    private ArrayList<UserPlayer> players;
    private Dealer dealer;
    
    // Constructor for Blackjack
    public Blackjack() {
        // Initialize currentDeck to fullDeck
        this.currentDeck = this.getRandomizedDeck();
        this.players = this.getPlayers();
        this.dealer = this.getDealer();
        
        this.startGame();
    }
    
    // Method to initialize the deck of 52 cards
    private final ArrayList<Card> getRandomizedDeck(){        
        // Create an array for the deck
        ArrayList<Card> deck = new ArrayList<Card>(); 
        
        // Loop through all values and suits to create each card
        for (Card.Value value : Card.Value.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
        
        // Shuffle the deck
        Collections.shuffle(deck);
        
        // Return the completed deck
        return deck; 
    }
    
    private final ArrayList<UserPlayer> getPlayers(){
        Scanner sc = new Scanner(System.in);
        ArrayList<UserPlayer> players = new ArrayList<UserPlayer>();
        
        int numPlayers;
        // Get number of players;
        while(true){
            System.out.println("How many players are playing?");
            
            try {
                numPlayers = sc.nextInt();
                sc.nextLine();
                
            } catch (Exception e) {
                System.out.println("Please choose a number greater than 1");
                continue;
            }
            
            if(!(numPlayers > 0)) {
                System.out.println("Please choose a number greater than 1");
                continue;
            }   
            
            break;
        }
        
        while(players.size() < numPlayers){
            System.out.printf(
                "What is Player #%d's name? \n", 
                players.size()
            );
            
            String name = sc.nextLine();
            
            players.add(new UserPlayer(name));
        }
        
        return players;
    }
    
    private final Dealer getDealer(){
        return new Dealer();
    }
    
    private void startGame(){
        System.out.println("Here");
    }
    
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        
    }
}