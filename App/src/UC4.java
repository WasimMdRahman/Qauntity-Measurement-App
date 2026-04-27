public class QuantityLength {

    private static final double EPSILON = 0.0001;

    private double value;
    private LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value must be a valid number");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toFeet() {
        return unit.toFeet(value);
    }

    public boolean isEqual(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Comparison object cannot be null");
        }

        double thisValue = this.toFeet();
        double otherValue = other.toFeet();

        return Math.abs(thisValue - otherValue) < EPSILON;
    }
}