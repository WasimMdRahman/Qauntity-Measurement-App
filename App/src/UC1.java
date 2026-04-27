public class QuantityMeasurementApp {

    // Tolerance for floating point comparison
    private static final double EPSILON = 0.0001;

    // Method to compare two values in feet
    public boolean areEqual(Double value1, Double value2) {

        // Validation
        if (value1 == null || value2 == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }

        // Check if values are valid numbers
        if (value1.isNaN() || value2.isNaN()) {
            throw new IllegalArgumentException("Values must be valid numbers");
        }

        // Comparison using tolerance
        return Math.abs(value1 - value2) < EPSILON;
    }

    // Main method for testing
    public static void main(String[] args) {
        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Double val1 = 5.0;
        Double val2 = 5.00001;

        boolean result = app.areEqual(val1, val2);

        System.out.println("Are values equal? " + result);
    }
}