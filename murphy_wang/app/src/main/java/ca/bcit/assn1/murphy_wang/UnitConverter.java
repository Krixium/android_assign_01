package ca.bcit.assn1.murphy_wang;

import android.content.Context;

/**
 * UnitConverter.java
 * <p>
 * Contains functions that convert based units back and forth between metric and imperal.
 */
class UnitConverter {
    static double hectaresToAcres(double x) {
        return (x * 2.47105);
    }

    static double acresToHectares(double x) {
        return (x / 2.47105);
    }

    static double hectaresToSquareFeet(double x) {
        return (x * 107639);
    }

    static double squareFeetToHectares(double x) {
        return (x / 107639);
    }

    static double squareMetersToSquareFeet(double x) {
        return (x * 10.7639);
    }

    static double squareFeetToSquareMeters(double x) {
        return (x / 10.7639);
    }

    /**
     * Produces a string that is easy for people to read based based on the result of the conversion
     *
     * @param value      The value being calculated
     * @param result     The result of the conversion
     * @param valueUnit  The unit for the value
     * @param resultUnit The unit for the result
     * @return A string that is nice to read
     */
    static String stringifyConversion(Context context, double value, double result,
                                      int valueUnit, int resultUnit) {

        String temp = value + " " + parseUnit(context, value, valueUnit);
        temp += " " + context.getResources().getString(R.string.equal) + " ";
        temp += result + " " + parseUnit(context, result, resultUnit);
        temp += ".";

        return temp;
    }


    private static String parseUnit(Context context, double value, int unit) {
        String[] temp = context.getResources().getStringArray(unit);
        if (value == 1) {
            return temp[0];
        } else {
            return temp[1];
        }
    }
}
