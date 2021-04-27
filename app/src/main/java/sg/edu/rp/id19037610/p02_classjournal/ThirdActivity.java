package sg.edu.rp.id19037610.p02_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    int requestCodeForBtn = 1;

    RadioGroup rdGrp;
    RadioButton rdBtn;
    Button btnSubmit;
    ArrayList<DailyCA> al;
    String currModCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rdGrp = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.buttonSubmit);

        Intent intent = getIntent();
        String text = intent.getStringExtra("add");
        TextView tvWeek = (TextView) findViewById(R.id.week);
        tvWeek.setText("Week " + text);

        al = new ArrayList<DailyCA>();

        // getting arraylist and module code from intent
        al = (ArrayList<DailyCA>) intent.getSerializableExtra("arraylist");
        currModCode = intent.getStringExtra("currModCode");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected radio button from radio group
                int selected = rdGrp.getCheckedRadioButtonId();
                // Find radio button by returned id
                rdBtn = findViewById(selected);

                int week = Integer.parseInt(text);
                String grade = String.valueOf(rdBtn.getText());
                DailyCA newCA = new DailyCA(grade, currModCode, week);

                al.add(newCA);

                // Return to Second Activity
                Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
                i.putExtra("arraylist", al);
                i.putExtra("selectedModCode", currModCode);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                String added = data.getStringExtra("added");
                String statement = "";
                if (requestCode == requestCodeForBtn) {
                    statement = rdBtn.getText().toString() + added;
                }
                Toast.makeText(ThirdActivity.this, statement, Toast.LENGTH_LONG).show();

            }
        }
    }
}