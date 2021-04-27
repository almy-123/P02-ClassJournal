package sg.edu.rp.id19037610.p02_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    RadioGroup rdGrp;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rdGrp = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.buttonSubmit);

        int grade = rdGrp.getCheckedRadioButtonId();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "" + grade, Toast.LENGTH_LONG).show();
            }
        });
    }
}