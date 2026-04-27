public class QuantityLength {

    private static final double EPSILON = 0.0001;

    private double value;
    private Unit unit;

    // Conversion constants
    private static final double INCH_TO_FEET = 1.0 / 12.0;

    public QuantityLength(double value, Unit unit) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value must be a valid number");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (FEET)
    private double toFeet() {
        switch (unit) {
            case FEET:
                return value;
            case INCHES:
                return value * INCH_TO_FEET;
            default:
                throw new IllegalArgumentException("Unsupported unit");
        }
    }

    // Equality check
    public boolean isEqual(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Comparison object cannot be null");
        }

        double thisInFeet = this.toFeet();
        double otherInFeet = other.toFeet();

        return Math.abs(thisInFeet - otherInFeet) < EPSILON;
    }
}