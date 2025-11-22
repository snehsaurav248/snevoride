package com.snevoride.snevoride.util;

public class FareUtil {

    // Haversine Formula to calculate distance (KM)
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) *
                        Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return R * c;
    }

    // Base fare + per KM charge
    public static double calculateFare(double distanceKm) {
        double baseFare = 50;    // fixed
        double perKm = 12;       // rate/km
        return baseFare + (distanceKm * perKm);
    }
}
