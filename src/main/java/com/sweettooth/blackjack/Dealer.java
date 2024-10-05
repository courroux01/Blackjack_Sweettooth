package com.sweettooth.blackjack;

import java.util.ArrayList;
public class Dealer extends Player {

    private ArrayList<Card> hand;
    private int handValue;
    
    public Dealer(){
        this.hand = new ArrayList<Card>();
        this.handValue = 0;
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
    public void hit(){};
    public void stand(){};  
}