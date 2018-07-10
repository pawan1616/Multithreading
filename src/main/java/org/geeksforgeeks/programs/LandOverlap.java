package org.geeksforgeeks.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LandOverlap {

    private static int totalCost;
    private static List<ParentCoordinate> coordinates = new ArrayList<ParentCoordinate>();
    
    private static class ParentCoordinate
    {
        boolean isTraversed;
        TreeSet<Coordinates> xCoordinates, yCoordinates, xyCoordinates;
         
    }
    
    private static class Coordinates {
        int x1, x2, y1, y2;
        double distance;
    }

    private static void calculateDistance(Coordinates coordinate) {
        coordinate.distance = Math.sqrt(Math.pow(coordinate.x1 - coordinate.x2, 2)
                + Math.pow(coordinate.y1 - coordinate.y2, 2));
    }

    
    public static void main(String[] args) {
        List<? extends Number> aa = new ArrayList<Integer>();
        aa.add(1);
        
        int[][] coords =  {
            {1,2}, {5, 6}, {3, 9}, {5, 4}
        };
        
        for (int i = 0; i < coords.length; i++)
        {
            ParentCoordinate parentCoordinate = new ParentCoordinate();
            parentCoordinate.isTraversed = true;
            
            for (int j = 0; j < coords[i].length; j+=2)
            {
                
                
            }
            coordinates.add(parentCoordinate);
        }
    }
}
