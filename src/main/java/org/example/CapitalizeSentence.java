package org.example;

import java.util.Scanner;

public class CapitalizeSentence
{


    public static void main(String... args)
    {
        // make scanner object
        Scanner scanner = new Scanner(System.in);
        // ask user for input
        System.out.println("Please write sentence:");
        // take user input
        var sentence = scanner.nextLine();

        // capitalize first letters in sentence
        printCapitalized(sentence);


    }

    /**
     * This function takes string that will be processed and printed,
     * by processing we mean all the first letters of words will be
     * capitalized.
     * @param sentence string that should be processed
     */
    public static void printCapitalized(String sentence)
    {

        var prevChar = '?';
        for (int i = 0; i < sentence.length(); i++)
        {
            var currentChar = sentence.charAt(i);
            if (i == 0 || prevChar == ' ' && Character.isLetter(currentChar))
            {
                System.out.print(Character.toUpperCase(currentChar));
                prevChar = '?';
            }
            else if (currentChar == ' ')
            {
                prevChar = currentChar;
                System.out.print(currentChar);
            }
            else
            {
                System.out.print(currentChar);
            }

        }
    }




}
