package org.example;

import java.util.Scanner;

public class HexaDecimalValue
{

    public static void main(String[] args)
    {
        // create scanner object
        Scanner scanner = new Scanner(System.in);
        // take input from user
        var hex = scanner.nextLine(); // hexadecimal number
        var decimalValue = 0;
        // iterate trough hex number
        for (int i = 0; i < hex.length(); i++)
        {
            var currentChar = hex.charAt(i); // current character
            // convert to decimal
            decimalValue = decimalValue * 16 + hexValue(currentChar);
        }

        System.out.println(decimalValue);





    }


    /**
     * This method returns decimal representation of given hexadecimal character
     * @param ch hexadecimal character
     * @return integer representation of hex number
     */
    public static int hexValue(char ch)
    {
        return  switch(ch) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'A', 'a' -> 10;
            case 'B', 'b' -> 11;
            case 'C', 'c' -> 12;
            case 'D', 'd' -> 13;
            case 'E', 'e' -> 14;
            case 'F', 'f' -> 15;
            default  -> -1;
        };


    }



}
