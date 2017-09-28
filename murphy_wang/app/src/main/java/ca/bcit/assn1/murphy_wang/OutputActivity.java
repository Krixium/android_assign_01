package ca.bcit.assn1.murphy_wang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView textView = (TextView) findViewById(R.id.textResult);
        textView.setText(parseIntent(getIntent()));
    }

    /**
     * Processes the intent sent by InputActivity
     *
     * @param intent The intent passed by the previous activity
     * @return A sentence with the unit conversions
     */
    private String parseIntent(Intent intent) {
        Bundle data = intent.getExtras();
        int conversion;
        double value;
        double result;
        String returnStr;

        try {
            conversion = (int) data.get(getResources().getString(R.string.CONV));
        } catch (Exception e) {
            conversion = 0;
        }

        try {
            value = (double) data.get(getResources().getString(R.string.VALUE));
        } catch (Exception e) {
            value = 0;
        }

        if (conversion == getResources().getInteger(R.integer.HECTARES_TO_ACRES)) {
            result = UnitConverter.hectaresToAcres(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.hectare,
                    R.array.acre);
        } else if (conversion == getResources().getInteger(R.integer.ACRES_TO_HECTARES)) {
            result = UnitConverter.acresToHectares(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.acre,
                    R.array.hectare);
        } else if (conversion == getResources().getInteger(R.integer.HECTARES_TO_SQUARE_FEET)) {
            result = UnitConverter.hectaresToSquareFeet(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.hectare,
                    R.array.square_feet);
        } else if (conversion == getResources().getInteger(R.integer.SQUARE_FEET_TO_HECTARES)) {
            result = UnitConverter.squareFeetToHectares(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.square_feet,
                    R.array.hectare);
        } else if (conversion == getResources().getInteger(R.integer.SQUARE_METERS_TO_SQUARE_FEET)) {
            result = UnitConverter.squareMetersToSquareFeet(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.square_meter,
                    R.array.square_feet);
        } else if (conversion == getResources().getInteger(R.integer.SQUARE_FEET_TO_SQUARE_METERS)) {
            result = UnitConverter.squareFeetToSquareMeters(value);
            returnStr = UnitConverter.stringifyConversion(this, value, result,
                    R.array.square_feet,
                    R.array.square_meter);
        } else {
            returnStr = getResources().getString(R.string.ERROR_NO_CALCULATION_PREFORMED);
        }

        return returnStr;
    }
}
