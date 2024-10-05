package com.sweettooth.blackjack;

import java.util.Objects;

public class Card {

    public enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public enum Color {
        RED, BLACK
    }

    private Value value;
    private Suit suit;
    private Color color;

    public Card() {}

    public Card(int value, String suit){
        this.value = convertValueToEnum(value);
        this.suit = convertSuitToEnum(suit);
        this.color = getColorFromSuit();
    }
    
    public Card(int value, String suit, String color) {
        this.value = convertValueToEnum(value);
        this.suit = convertSuitToEnum(suit);
        this.color = convertColorToEnum(color);
    }

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
        this.color = getColorFromSuit();
    }
    
    public Card(Value value, Suit suit, Color color) {
        this.value = value;
        this.suit = suit;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Value getValue() {
        return this.value;
    }

    public int getHandValue(boolean isOverTen) {
        return switch (this.value) {
            case ACE -> isOverTen ? 1 : 11;
            case KING, QUEEN, JACK -> 10;
            case NINE -> 9;
            case EIGHT -> 8;
            case SEVEN -> 7;
            case SIX -> 6;
            case FIVE -> 5;
            case FOUR -> 4;
            case THREE -> 3;
            case TWO -> 2;
            default -> throw new IllegalArgumentException("Unexpected value: " + this.value);
        };
    }

    public Color getColorFromSuit() {
        return switch (this.suit) {
            case SPADES, CLUBS -> Color.BLACK;
            default -> Color.RED;
        };
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.suit == other.suit && this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.value.name(), this.suit.name());
    }

    public static Suit convertSuitToEnum(String suit) {
        return switch (suit.toUpperCase()) {
            case "D", "DIAMONDS" -> Suit.DIAMONDS;
            case "S", "SPADES" -> Suit.SPADES;
            case "C", "CLUBS" -> Suit.CLUBS;
            case "H", "HEARTS" -> Suit.HEARTS;
            default -> throw new IllegalArgumentException("Bad input: " + suit);
        };
    }

    public static Value convertValueToEnum(int value) {
        return switch (value) {
            case 1, 14 -> Value.ACE;
            case 2 -> Value.TWO;
            case 3 -> Value.THREE;
            case 4 -> Value.FOUR;
            case 5 -> Value.FIVE;
            case 6 -> Value.SIX;
            case 7 -> Value.SEVEN;
            case 8 -> Value.EIGHT;
            case 9 -> Value.NINE;
            case 10 -> Value.TEN;
            case 11 -> Value.JACK;
            case 12 -> Value.QUEEN;
            case 13 -> Value.KING;
            default -> throw new IllegalArgumentException("Bad input: " + value);
        };
    }

    public static Color convertColorToEnum(String color) {
        return switch (color.toUpperCase()) {
            case "R", "RED" -> Color.RED;
            case "B", "BLACK" -> Color.BLACK;
            default -> throw new IllegalArgumentException("Bad input: " + color);
        };
    }
}
