package com.company;

import enumerations.CardRanking;
import enumerations.CardSuitType;
import interfaces.IPokerMainDeckRandomizer;
import models.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class PokerMainDeckRandomizer extends PlayerHandEvaluationLogic implements IPokerMainDeckRandomizer {

    @Override
    public List<Card> buildPokerDeck() {
        List<CardSuitType> possibleSuits = new ArrayList<CardSuitType>(EnumSet.allOf(CardSuitType.class));
        List<CardRanking> possibleCardRankings = new ArrayList<CardRanking>(EnumSet.allOf(CardRanking.class));
        List<Card> pokerMainDeck = generateAllCardsForDeck(possibleSuits, possibleCardRankings);
        Collections.shuffle(pokerMainDeck);
        return pokerMainDeck;
    }

    @Override
    public List<Card> generateAllCardsForDeck(List<CardSuitType> possibleSuits, List<CardRanking> possibleCardRankings) {
        List<Card> collectionOfCards = new ArrayList<Card>();
        for (CardSuitType cardSuitType : possibleSuits) {
            for (CardRanking cardRanking : possibleCardRankings) {
                Card card = new Card();
                card.setSuitType(cardSuitType);
                card.setRanking(cardRanking);
                collectionOfCards.add(card);
            }
        }
        return collectionOfCards;
    }
}
