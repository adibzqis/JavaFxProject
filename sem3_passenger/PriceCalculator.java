package sem3_project;

public class PriceCalculator {
    // Price matrix for 9 locations
    private static final double[][] priceMap = {
        {0, 50, 70, 100, 120, 150, 180, 200, 220}, // KC
        {50, 0, 30, 60, 90, 120, 150, 180, 200},   // KTDI
        {70, 30, 0, 50, 80, 110, 140, 170, 190},   // KPZ
        {100, 60, 50, 0, 40, 70, 100, 130, 150},   // K12
        {120, 90, 80, 40, 0, 30, 60, 90, 110},     // PFC
        {150, 120, 110, 70, 30, 0, 40, 70, 90},    // IOI CITY MALL
        {180, 150, 140, 100, 60, 40, 0, 30, 50},   // RESTAURANT PKS
        {200, 180, 170, 130, 90, 70, 30, 0, 20},   // SULTAN ABDUL SAMAD LIBRARY
        {220, 200, 190, 150, 110, 90, 50, 20, 0}   // MRT UPM
    };

    public static double calculatePrice(String from, String to) {
        int fromIndex = getLocationIndex(from);
        int toIndex = getLocationIndex(to);
        if (fromIndex >= 0 && toIndex >= 0) {
            return priceMap[fromIndex][toIndex];
        }
        return -1; // Return -1 for invalid locations
    }

    private static int getLocationIndex(String location) {
        switch (location) {
            case "KC": return 0;
            case "KTDI": return 1;
            case "KPZ": return 2;
            case "K12": return 3;
            case "PFC": return 4;
            case "IOI CITY MALL": return 5;
            case "RESTAURANT PKS": return 6;
            case "SULTAN ABDUL SAMAD LIBRARY": return 7;
            case "MRT UPM": return 8;
            default: return -1;
        }
    }
}
