package bosschen.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //spinner
        final Spinner spinner = (Spinner) findViewById(R.id.exercise_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //change unit according to spinner selection
        TextView repminSelectText = (TextView)findViewById(R.id.repminSelect);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                TextView repminSelectText = (TextView) findViewById(R.id.repminSelect);
                String unit = repOrMin(spinner.getSelectedItem().toString());
                repminSelectText.setText(unit);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void calculateClickHandler(View view) {
        if (view.getId() == R.id.calculateButton) {
            Spinner exercise_spinner = (Spinner) findViewById(R.id.exercise_spinner);
            String exercise_type = exercise_spinner.getSelectedItem().toString();
            EditText repminText = (EditText)findViewById(R.id.repminText);
            String repmin= repminText.getText().toString();
            TextView resultText = (TextView)findViewById(R.id.resultLabel);
            TextView caloriesBurntText = (TextView)findViewById(R.id.calories_burnt);
            //display result
            if(repmin.length() == 0) {
                resultText.setError("");
                caloriesBurntText.setText(getString(R.string.emptyString));
                resultText.setText(getString(R.string.not_valid));
            } else {
                resultText.setError(null);
                int cal = calculateCalories(exercise_type, repmin);
                resultText.setText(String.valueOf(cal));
                caloriesBurntText.setText(getString(R.string.calories_burnt));
            }
        }
    }

    //calculate calories burnt
    private int calculateCalories(String exercise_type, String repmin) {
        int result;
        int number = Integer.parseInt(repmin);
        if(exercise_type.equals("Pushup")) {
            return number*100/350;
        } else if(exercise_type.equals("Situp")) {
            return number*100/200;
        } else if(exercise_type.equals("Squats")) {
            return number*100/225;
        } else if(exercise_type.equals("Leg-lift")) {
            return number*100/25;
        } else if(exercise_type.equals("Plank")) {
            return number*100/25;
        } else if(exercise_type.equals("Jumping Jacks")) {
            return number*100/10;
        } else if(exercise_type.equals("Pullup")) {
            return number*100/100;
        } else if(exercise_type.equals("Cycling")) {
            return number*100/12;
        } else if(exercise_type.equals("Walking")) {
            return number*100/20;
        } else if(exercise_type.equals("Jogging")) {
            return number*100/12;
        } else if(exercise_type.equals("Swimming")) {
            return number*100/13;
        } else if(exercise_type.equals("Stair-Climbing")) {
            return number*100/15;
        } else return 0;
    }

    //decide which unit to display (reps or minutes)
    private String repOrMin(String e) {
        if (e.equals("Pushup")||e.equals("Situp")||e.equals("Squats")||e.equals("Pullup")) {
            return getString(R.string.reps);
        } else
            return getString(R.string.mins);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //handle option select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent;
        switch (item.getItemId()) {
            case R.id.option1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.option2:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                return true;
            case R.id.option3:
                intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
