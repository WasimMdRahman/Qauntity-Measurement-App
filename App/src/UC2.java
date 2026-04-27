public class QuantityMeasurementApp {

    // Static method for Feet comparison
    public static boolean compareFeet(Double value1, Double value2) {
        Feet feet = new Feet();
        return feet.isEqual(value1, value2);
    }

    // Static method for Inches comparison
    public static boolean compareInches(Double value1, Double value2) {
        Inches inches = new Inches();
        return inches.isEqual(value1, value2);
    }

    public static void main(String[] args) {

        // Hard-coded values (as per requirement)
        Double feet1 = 5.0;
        Double feet2 = 5.00001;

        Double inch1 = 12.0;
        Double inch2 = 12.0;

        boolean feetResult = compareFeet(feet1, feet2);
        boolean inchResult = compareInches(inch1, inch2);

        System.out.println("Feet Equal? " + feetResult);
        System.out.println("Inches Equal? " + inchResult);
    }
}