package interfaces;

import models.Card;

import java.util.List;

public interface IPlayerHandEvaluationType {
    boolean containsFourOfAKind(List<Card> playerHand);
    boolean containsThreeOfAKind(List<Card> playerHand);
    boolean containsTwoPair(List<Card> playerHand);
    boolean containsFullHouse(List<Card> playerHand);
    boolean containsFlush(List<Card> playerHand);
    boolean containsStraight(List<Card> playerHand);
    boolean containsStraightFlush(List<Card> playerHand);
    boolean containsRoyalFlush(List<Card> playerHand);
    boolean containsJacksOrBetter(List<Card> playerHand);
    List<Card> sortPlayerHand(List<Card> playerHand);
    int maxRankGroupCount(List<Card> playerHand);
}
