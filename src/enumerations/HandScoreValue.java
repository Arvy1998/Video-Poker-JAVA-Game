package enumerations;

import java.util.HashMap;
import java.util.Map;

public enum HandScoreValue {
    ROYAL_FLUSH(800),
    STRAIGHT_FLUSH(50),
    FOUR_OF_A_KIND(25),
    FULL_HOUSE(9),
    FLUSH(6),
    STRAIGHT(4),
    THREE_OF_A_KIND(3),
    TWO_PAIR(2),
    JACKS_OR_BETTER(1),
    NOTHING(0);

    private int value;
    private static Map map = new HashMap<>();
    public final int label;

    private HandScoreValue(int label) {
        this.label = label;
    }

    static {
        for (HandScoreValue evaluationType : HandScoreValue.values()) {
            map.put(evaluationType.value, evaluationType);
        }
    }

    public static HandScoreValue valueOf(int evaluationType) {
        return (HandScoreValue) map.get(evaluationType);
    }

    public int getValue() {
        return value;
    }
}
