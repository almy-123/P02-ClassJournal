package sg.edu.rp.id19037610.p02_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvDailyGrades;
    ArrayList<DailyCA> al;
    ArrayList<DailyCA> alChecked;
    ArrayList<DailyCA> newAL;
    ArrayAdapter aa;
    Button btnEmail;
    Button btnInfo;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        newAL = new ArrayList<DailyCA>();

        Intent i = getIntent();
        String modCode = i.getStringExtra("selectedModCode");
        newAL = (ArrayList<DailyCA>) i.getSerializableExtra("arraylist");

        lvDailyGrades = findViewById(R.id.lvDailyGrades);
        al = new ArrayList<DailyCA>();

        if (newAL == null) {
            al.add(new DailyCA("B", "C347", 1));
            al.add(new DailyCA("C", "C347", 2));
            al.add(new DailyCA("A", "C347", 3));
            al.add(new DailyCA("D", "C302", 1));
            al.add(new DailyCA("C", "C302", 2));
            al.add(new DailyCA("A", "C302", 3));
        } else {
            al = newAL;
        }

        alChecked = new ArrayList<DailyCA>();
        for (int x = 0; x < al.size(); x++) {
            if (al.get(x).getModuleCode().equals(modCode)) {
                alChecked.add(al.get(x));
            }
        }

        aa = new DGAdapter(this, R.layout.daily_grade_row, alChecked);
        lvDailyGrades.setAdapter(aa);

        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = new String();
                message += "Hi faci \n I am ... \n Please see my remarks so far, thank you! \n";
                for (int y = 0; y < alChecked.size(); y++) {
                    message += "Week " + alChecked.get(y).getWeek() + ": DG : " + alChecked.get(y).getDgGrade() + "\n";
                }

                Intent i = new Intent();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send Email"));
            }
        });

        btnInfo = findViewById(R.id.buttonInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/diploma-in-digital-design-and-development"));
                startActivity(webIntent);
            }
        });

        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = al.size() - 1;
                if (al.get(id).getWeek() != 0) {
                    int week = al.get(id).getWeek() + 1;
                    String text = String.valueOf(week);
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("add", text);

                    // passing the arraylist to ThirdActivity
                    intent.putExtra("arraylist", al);

                    // passing the module code to ThirdActivity
                    intent.putExtra("currModCode", modCode);

                    startActivity(intent);
                }

//                Intent i = new Intent();
//                i.putExtra("added", "added");
//                setResult(RESULT_OK, i);
//                finish();
            }
        });
    }
}
