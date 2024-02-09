package org.example;

public class RollingDiceSimulation
{


    public static void main(String[] args) {

        for (int i = 2; i <= 12; i++)
        {
            System.out.println(i + "       " + calculateAverageFor(i)); // expected num and average to obtain
        }

    }

    /**
     * This method returns what is the average number of throwing dice
     * to obtain expectedNumber.
     * @param expectedNumber
     * @return
     */
    public static double calculateAverageFor(int expectedNumber)
    {
        var sum = 0;
        for (int i = 1; i < 10_000; i++)
        {
            sum += simulateRollingDice(expectedNumber);
        }

        return sum / 10_000.;
    }


    /**
     * simulation of rolling the pair dice till sum of them are not expected number
     * Precondition: expectedNumber should be in range 2-12 inclusive
     * @param expectedNumber number that we expect to get after rolling dices
     * @return the number of times should roll dice to get expected result
     * @throws IllegalArgumentException
     */
    public static int simulateRollingDice(int expectedNumber)
    {

        if (!(expectedNumber >= 2 && expectedNumber <= 12))
        // if expected number will never come
        {
            throw new IllegalArgumentException("Expected number must be in range 2-12 inclusive");
        }

        var diceOne = 0;
        var diceTwo = 0;
        var count = 0;
        // simulate till total of dices is not expectedNumber
        while ((diceOne + diceTwo) != expectedNumber)
        {
            diceOne = (int) (Math.random() * 6) + 1;
            diceTwo = (int) (Math.random() * 6) + 1;
            count++;
        }


        return count;



    }   // end of simulateRollingDice(int)



}
