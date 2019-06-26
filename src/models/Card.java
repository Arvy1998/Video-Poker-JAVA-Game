package models;

import enumerations.CardRanking;
import enumerations.CardSuitType;

public class Card {
    public CardSuitType suitType;
    public CardRanking ranking;
    public boolean isCardSelected;

    public void setSuitType(CardSuitType suitType) {
        this.suitType = suitType;
    }

    public void setRanking(CardRanking ranking) {
        this.ranking = ranking;
    }

    public void setIsCardSelectedState(boolean isCardSelected) {
        this.isCardSelected = isCardSelected;
    }

    public CardSuitType getSuitType() {
        return this.suitType;
    }

    public CardRanking getRanking() {
        return this.ranking;
    }

    public boolean getIsCardSelectedState() {
        return this.isCardSelected;
    }
}
