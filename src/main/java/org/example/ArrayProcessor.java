package org.example;

/**
 * A functional interface that defines a function
 * that has one parameter of type double[] and that
 * returns a value of type double.
 */
@FunctionalInterface
public interface ArrayProcessor
{
    double apply( double[] array );
}