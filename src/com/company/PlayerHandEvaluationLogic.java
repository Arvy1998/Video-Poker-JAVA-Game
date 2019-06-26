package com.company;

import enumerations.HandScoreValue;
import interfaces.IPlayerHandEvaluationLogic;
import models.Card;

import java.util.List;

public class PlayerHandEvaluationLogic extends PlayerHandEvaluationType implements IPlayerHandEvaluationLogic {

    @Override
    public HandScoreValue evaluateHand(List<Card> playerHand) {
        int maxMatchingRankGroupCount = maxRankGroupCount(playerHand);

        switch (maxMatchingRankGroupCount) {
            case 1: return flushOrStraight(playerHand);
            case 2: return pairOrJackOrNothing(playerHand);
            case 3: return threeOrFullHouse(playerHand);
            case 4: return HandScoreValue.FOUR_OF_A_KIND;
            default: return HandScoreValue.NOTHING;
        }
    }

    private HandScoreValue threeOrFullHouse(List<Card> playerHand) {
        if (containsThreeOfAKind(playerHand)) return HandScoreValue.THREE_OF_A_KIND;
        else if (containsFullHouse(playerHand)) return HandScoreValue.FULL_HOUSE;
        else return HandScoreValue.NOTHING;
    }

    private HandScoreValue pairOrJackOrNothing(List<Card> playerHand) {
        if (containsTwoPair(playerHand)) return HandScoreValue.TWO_PAIR;
        else if (containsJacksOrBetter(playerHand)) return HandScoreValue.JACKS_OR_BETTER;
        else return HandScoreValue.NOTHING;
    }

    private HandScoreValue flushOrStraight(List<Card> playerHand) {
        if (containsRoyalFlush(playerHand)) return HandScoreValue.ROYAL_FLUSH;
        else if (containsStraightFlush(playerHand)) return HandScoreValue.STRAIGHT_FLUSH;
        else if (containsStraight(playerHand)) return HandScoreValue.STRAIGHT;
        else if (containsFlush(playerHand)) return HandScoreValue.FLUSH;
        else return HandScoreValue.NOTHING;
    }
}
