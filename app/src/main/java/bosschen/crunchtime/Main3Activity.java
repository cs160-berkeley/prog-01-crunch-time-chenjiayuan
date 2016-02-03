package bosschen.crunchtime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //prevent keyboard appear automatically
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void calculateClickHandler(View view) {
        if (view.getId() == R.id.calculateButton) {
            //hide keyboard after button click
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow((null == getCurrentFocus())
                    ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            EditText caloriesText = (EditText)findViewById(R.id.caloriesText);
            String caloriesProject= caloriesText.getText().toString();
            //display result
            if(caloriesProject.length() == 0) {
                caloriesProject = "0";
            }
            calculateExercises(caloriesProject);
        }
    }

    private void calculateExercises(String cal) {
        int calories = Integer.parseInt(cal);
        TextView pushup = (TextView)findViewById(R.id.pushup);
        TextView situp = (TextView)findViewById(R.id.situp);
        TextView squats = (TextView)findViewById(R.id.squats);
        TextView leglift = (TextView)findViewById(R.id.leglift);
        TextView plank = (TextView)findViewById(R.id.plank);
        TextView jumpingjacks = (TextView)findViewById(R.id.jumpingjacks);
        TextView pullup = (TextView)findViewById(R.id.pullup);
        TextView cycling = (TextView)findViewById(R.id.cycling);
        TextView walking = (TextView)findViewById(R.id.walking);
        TextView jogging = (TextView)findViewById(R.id.jogging);
        TextView swimming = (TextView)findViewById(R.id.swimming);
        TextView stairclimbing = (TextView)findViewById(R.id.stairclimbing);

        pushup.setText(Integer.toString(calories*350/100));
        situp.setText(Integer.toString(calories*200/100));
        squats.setText(Integer.toString(calories*225/100));
        leglift.setText(Integer.toString(calories*25/100));
        plank.setText(Integer.toString(calories*25/100));
        jumpingjacks.setText(Integer.toString(calories*10/100));
        pullup.setText(Integer.toString(calories*100/100));
        cycling.setText(Integer.toString(calories*12/100));
        walking.setText(Integer.toString(calories*20/100));
        jogging.setText(Integer.toString(calories*12/100));
        swimming.setText(Integer.toString(calories*13/100));
        stairclimbing.setText(Integer.toString(calories*15/100));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.option1).setIcon(R.drawable.ic_filter_1_white_48dp);
        menu.findItem(R.id.option2).setIcon(R.drawable.ic_filter_2_white_48dp);
        menu.findItem(R.id.option3).setIcon(R.drawable.ic_filter_3_black_48dp);
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
