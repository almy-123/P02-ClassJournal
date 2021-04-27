package sg.edu.rp.id19037610.p02_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvDailyGrades;
    ArrayList<DailyCA> al;
    ArrayList<DailyCA> alChecked;
    ArrayAdapter aa;
    Button btnEmail;
    Button btnInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent i = getIntent();
        String modCode = i.getStringExtra("selectedModCode");

        btnInfo = findViewById(R.id.buttonInfo);


        lvDailyGrades = findViewById(R.id.lvDailyGrades);
        al = new ArrayList<DailyCA>();
        al.add(new DailyCA("B","C347",1));
        al.add(new DailyCA("C","C347",2));
        al.add(new DailyCA("A","C347",3));
        al.add(new DailyCA("D","C302",1));
        al.add(new DailyCA("C","C302",2));
        al.add(new DailyCA("A","C302",3));

        alChecked = new ArrayList<DailyCA>();
        for(int x=0; x<al.size(); x++){
            if(al.get(x).getModuleCode().equals(modCode)){
                alChecked.add(al.get(x));
            }
        }

        aa = new DGAdapter(this, R.layout.daily_grade_row,alChecked);
        lvDailyGrades.setAdapter(aa);

        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hi faci, ";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send Email"));
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/diploma-in-digital-design-and-development"));
                startActivity(webIntent);
            }
        });
    }
}
