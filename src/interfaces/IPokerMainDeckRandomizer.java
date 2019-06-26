package interfaces;

import enumerations.CardRanking;
import enumerations.CardSuitType;
import models.Card;

import java.util.List;

public interface IPokerMainDeckRandomizer {
    List<Card> buildPokerDeck();
    List<Card> generateAllCardsForDeck(List<CardSuitType> possibleSuits, List<CardRanking> possibleRankings);
}
