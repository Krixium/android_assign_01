package ca.bcit.assn1.firstnamelastname1_firstnamelastname2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private EditText inputText;
    private int conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        conversion = 0;

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAction();
            }
        });

        // EditText
        inputText = (EditText) findViewById(R.id.editTextInput);

        // Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerConv);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.convArray,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSelectAction(adapterView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Unused
            }
        });
    }

    /**
     * The callback that gets executed when an item in the spinner is selected.
     *
     * @param adapterView The adapterView for the spinner that is calling the function.
     */
    private void spinnerSelectAction(AdapterView<?> adapterView) {
        conversion = adapterView.getSelectedItemPosition();
    }

    /**
     * The callback that is called when the floating action button is pressed.
     */
    private void fabAction() {
        if (inputText.getText() == null) {
            makeToast(getResources().getString(R.string.ERROR_NO_VALUE_ENTERED),
                    Toast.LENGTH_LONG);
        } else {
            double value = Double.parseDouble(inputText.getText().toString());
            if (conversion != 0) {
                Intent intent = new Intent(this, OutputActivity.class);
                intent.putExtra(getResources().getString(R.string.CONV), conversion);
                intent.putExtra(getResources().getString(R.string.VALUE), value);
                startActivity(intent);
            } else {
                makeToast(getResources().getString(R.string.ERROR_NO_CONVERSION_SELECTED),
                        Toast.LENGTH_LONG);
            }
        }
    }

    /**
     * Displays a toast message.
     *
     * @param msg The message to be displayed.
     * @param len The duration of the message.
     */
    private void makeToast(String msg, int len) {
        Toast.makeText(InputActivity.this, msg, len).show();
    }
}
