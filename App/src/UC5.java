public class QuantityLength {

    private static final double EPSILON = 0.0001;

    private double value;
    private LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
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

    // ✅ UC5: Static Conversion Method
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // Step 1: Convert to base (feet)
        double valueInFeet = source.toFeet(value);

        // Step 2: Convert to target
        double result = target.fromFeet(valueInFeet);

        return result;
    }

    // ✅ Optional Instance Method
    public double convertTo(LengthUnit target) {
        return convert(this.value, this.unit, target);
    }

    // Existing equality logic
    public boolean isEqual(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Comparison object cannot be null");
        }

        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }
}