package com.company;

import interfaces.IPlayerHandEvaluationType;
import models.Card;
import java.util.*;

import static enumerations.CardRanking.*;

public class PlayerHandEvaluationType implements IPlayerHandEvaluationType {

    @Override
    public boolean containsFourOfAKind(List<Card> playerHand) {
        int quadripleCheck = 0;
        for (int iterator = 0; iterator < playerHand.size(); iterator++) {
            for (int fourthSameElement = 0; fourthSameElement < playerHand.size(); fourthSameElement++) {
                if (playerHand.get(iterator).ranking.label == playerHand.get(fourthSameElement).ranking.label) {
                    quadripleCheck++;
                }
                if (quadripleCheck > 3) return true;
            }
            quadripleCheck = 0;
        }
        return false;
    }

    @Override
    public boolean containsThreeOfAKind(List<Card> playerHand) {
        int tripleCheck = 0;
        for (int iterator = 0; iterator < playerHand.size(); iterator++) {
            for (int thirdSameElement = 0; thirdSameElement < playerHand.size(); thirdSameElement++) {
                if (playerHand.get(iterator).ranking.label == playerHand.get(thirdSameElement).ranking.label) {
                    tripleCheck++;
                }
                if (tripleCheck > 2) return true;
            }
            tripleCheck = 0;
        }
        return false;
    }

    @Override
    public boolean containsTwoPair(List<Card> playerHand) {
        int pairCheck = 0;
        for (int iterator = 0; iterator < playerHand.size(); iterator++) {
            for (int secondSameElement = 0; secondSameElement < playerHand.size(); secondSameElement++) {
                if (playerHand.get(iterator).ranking.label == playerHand.get(secondSameElement).ranking.label) {
                    pairCheck++;
                }
                if (pairCheck > 1) return true;
            }
            pairCheck = 0;
        }
        return false;
    }

    @Override
    public boolean containsFullHouse(List<Card> playerHand) {
        List<Card> sortedPlayerHand = sortPlayerHand(playerHand);
        if((sortedPlayerHand.get(0).ranking.label == sortedPlayerHand.get(1).ranking.label  &&
            sortedPlayerHand.get(2).ranking.label == sortedPlayerHand.get(4).ranking.label) ||
           (sortedPlayerHand.get(0).ranking.label == sortedPlayerHand.get(2).ranking.label  &&
            sortedPlayerHand.get(3).ranking.label == sortedPlayerHand.get(4).ranking.label)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsFlush(List<Card> playerHand) {
        int flushCount = 0;
        for (int iterator = 1; iterator < playerHand.size(); iterator++) {
            if (playerHand.get(iterator).getSuitType() == playerHand.get(0).getSuitType()) {
                flushCount++;
            }
            if (flushCount == 5) return true;
        }
        return false;
    }

    @Override
    public boolean containsStraight(List<Card> playerHand) {
        if (containsRoyalFlush(playerHand)) return true;
        List<Card> sortedPlayerHand = sortPlayerHand(playerHand);
        for (int iterator = 0; iterator < sortedPlayerHand.size() - 1; iterator++) {
            if (sortedPlayerHand.get(iterator).ranking.label != (sortedPlayerHand.get(iterator + 1).ranking.label - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsStraightFlush(List<Card> playerHand) {
        if (containsFlush(playerHand) && containsStraight(playerHand)) return true;
        return false;
    }

    @Override
    public boolean containsRoyalFlush(List<Card> playerHand) {
        List<Card> sortedPlayerHand = sortPlayerHand(playerHand);
        if (sortedPlayerHand.get(0).ranking == TEN &&
            sortedPlayerHand.get(1).ranking == JACK &&
            sortedPlayerHand.get(2).ranking == QUEEN &&
            sortedPlayerHand.get(3).ranking == KING &&
            sortedPlayerHand.get(4).ranking == ACE) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsJacksOrBetter(List<Card> playerHand) {
        for (int iterator = 0; iterator < playerHand.size(); iterator++) {
            if (containsTwoPair(playerHand) && (playerHand.get(iterator).ranking.label > 10)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Card> sortPlayerHand(List<Card> playerHand) {
        playerHand.sort(Comparator.comparing(Card::getRanking));
        return playerHand;
    }

    @Override
    public int maxRankGroupCount(List<Card> playerHand) {
        if (containsFourOfAKind(playerHand)) return 4;
        else if (containsThreeOfAKind(playerHand)) return 3;
        else if (containsTwoPair(playerHand)) return 2;
        else return 1;
    }
}