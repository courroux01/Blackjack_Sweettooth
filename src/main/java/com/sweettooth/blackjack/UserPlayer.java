package com.sweettooth.blackjack;

import java.util.ArrayList;
public class UserPlayer extends Player {
    private String name;
    private ArrayList<Card> hand;
    private int handValue;
    
    public UserPlayer(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.handValue = 0;
    }
    
    public UserPlayer(String name, ArrayList<Card> hand, int handValue){
        this.name = name;
        this.hand = hand;
        this.handValue = handValue;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }
    
    public void hit(){}
    
    public void stand(){}
}

