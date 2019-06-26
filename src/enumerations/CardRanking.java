package enumerations;

import java.util.HashMap;
import java.util.Map;

public enum CardRanking {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private int value;
    private static Map map = new HashMap<>();
    public final int label;

    private CardRanking(int label) {
        this.label = label;
    }

    static {
        for (CardRanking rankingType : CardRanking.values()) {
            map.put(rankingType.value, rankingType);
        }
    }

    public static CardRanking valueOf(int rankingType) {
        return (CardRanking) map.get(rankingType);
    }

    public int getValue() {
        return value;
    }
}
