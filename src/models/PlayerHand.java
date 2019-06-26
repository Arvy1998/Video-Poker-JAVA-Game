package models;

import enumerations.HandScoreValue;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
    public HandScoreValue handScoreValue;
    public int playerHandSize;
    public List<Card> cards = new ArrayList<>();

    public void setHandScoreValue(HandScoreValue handScoreValue) {
        this.handScoreValue = handScoreValue;
    }

    public void setPlayerHandSize(int playerHandSize) {
        this.playerHandSize = cards.size();
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public HandScoreValue getHandScoreValue() {
        return handScoreValue;
    }

    public int getPlayerHandSize() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}
