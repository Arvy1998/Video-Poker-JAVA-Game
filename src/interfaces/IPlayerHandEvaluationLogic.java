package interfaces;

import enumerations.HandScoreValue;
import models.Card;

import java.util.List;

public interface IPlayerHandEvaluationLogic {
    HandScoreValue evaluateHand(List<Card> playerHand);
}
