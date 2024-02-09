package org.example;


/**
 * @author Konstantine Vashalomidze
 * This class defines several public static member variables of
 * type ArrayProcessor that process arrays in various ways.  It
 * also defines a function that can create ArrayProcessors for
 * counting occurrences of values in an array.  (Note that this
 * program depends on interface ArrayProcessor.)
 */
public class LambdaTest
{
    public static final ArrayProcessor maximumValue = (array) ->
    {
        var max = Double.NEGATIVE_INFINITY;
        for (double element : array)
        {
            max = Math.max(max, element);
        }
        return max;
    }; // to find maximum value in array
    public static final ArrayProcessor minimumValue = (array) ->
    {
        var min = Double.POSITIVE_INFINITY;
        for (double element : array)
        {
            min = Math.min(min, element);
        }
        return min;
    }; // to find minimum value in array
    public static final ArrayProcessor sumValues = (array) ->
    {
        var sum = 0.;
        for (double element : array)
        {
            sum += element;
        }
        return sum;
    }; // to sum values in array
    public static final ArrayProcessor averageValues = (array) ->
    {
        var average = 0.;
        for (double element : array)
        {
            average += element;
        }
        return average / array.length;
    }; // to find average of values in array

    public static ArrayProcessor counter( double value )
    {

        return array ->
        {
            var counter = 0; // counts # of occurence of value in array
            for (double element : array)
            {
                if (element == value)
                {
                    counter++;
                }
            }
            return counter;
        };
    } // end of counter(double)


    public static void main(String[] args) {

        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };

        System.out.println("Sum of first list (should be 55): "
                + sumValues.apply(firstList) );
        System.out.println("Average of first list (should be 5.5): "
                + averageValues.apply(firstList) );
        System.out.println("Minimum of second list (should be -3.4): "
                + minimumValue.apply(secondList) );
        System.out.println("Maximum of second list (should be 42.0): "
                + maximumValue.apply(secondList) );

        System.out.println();

        System.out.println("Count of 17.0 in second list (should be 3): "
                + counter(17.0).apply(secondList) );
        System.out.println("Count of 20.0 in second list (should be 0): "
                + counter(20.0).apply(secondList) );
        System.out.println("Count of 5.0 in first list (should be 1): "
                + counter(5.0).apply(firstList) );

    }



}
