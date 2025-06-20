public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double forecastRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return (1 + growthRate) * forecastRecursive(currentValue, growthRate, years - 1);
    }

    // Iterative (optimized) method
    public static double forecastIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double initialValue = 10000.0;
        double growthRate = 0.1;  // 10%
        int years = 5;

        // Recursive method
        double recursiveResult = forecastRecursive(initialValue, growthRate, years);
        System.out.printf("Recursive Forecast: ₹%.2f after %d years%n", recursiveResult, years);

        // Iterative method
        double iterativeResult = forecastIterative(initialValue, growthRate, years);
        System.out.printf("Iterative Forecast: ₹%.2f after %d years%n", iterativeResult, years);
    }
}
