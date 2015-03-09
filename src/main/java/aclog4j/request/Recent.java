package aclog4j.request;

import lombok.Getter;
import lombok.NonNull;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public final class Recent {

    public static enum Unit {
        DAY("d"),
        WEEK("w"),
        MONTH("m"),
        YEAR("y"),
        ;

        private final String str;

        private Unit(String str) {
            this.str = str;
        }

        public String toShortString() {
            return str;
        }
    }

    @Getter
    private final int period;

    @Getter
    private final Unit unit;

    public Recent(int period, @NonNull Unit unit) {
        if (period < 1) {
            throw new IllegalArgumentException("require: 0 < period");
        }

        this.period = period;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return period + unit.str;
    }
}
