/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author DELL
 */
public class Map {

    public static double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2, double longitude2, String unit) {
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * (180 / Math.PI) * Math.acos(
                Math.sin(latitude1 * (Math.PI / 180)) * Math.sin(latitude2 * (Math.PI / 180))
                + Math.cos(latitude1 * (Math.PI / 180)) * Math.cos(latitude2 * (Math.PI / 180)) * Math.cos(theta * (Math.PI / 180))
        );
        switch (unit) {
            case "miles":
                return distance;
            case "kilometers":
                return distance * 1.609344;
            default:
                return 0;
        }
    }
}
