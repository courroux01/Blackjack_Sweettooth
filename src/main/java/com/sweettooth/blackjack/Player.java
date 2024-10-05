package com.sweettooth.blackjack;


import java.util.ArrayList;
public abstract class Player {
    
    private ArrayList<Card> hand;
    private int handValue;
    
    public abstract void hit();
    public abstract void stand();    
}
