package sg.edu.rp.id19037610.p02_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvDailyGrades;
    ArrayList<DailyCA> al;
    ArrayList<DailyCA> alChecked;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent i = getIntent();
        String modCode = i.getStringExtra("moduleCode");

        lvDailyGrades = findViewById(R.id.lvDailyGrades);
        al = new ArrayList<DailyCA>();
        al.add(new DailyCA("B","C347",1));
        al.add(new DailyCA("C","C347",2));
        al.add(new DailyCA("A","C347",3));
        al.add(new DailyCA("D","C300",1));
        al.add(new DailyCA("C","C300",2));
        al.add(new DailyCA("A","C300",3));

        alChecked = new ArrayList<DailyCA>();
        for(int x=0; x<al.size(); x++){
            if(al.get(x).getModuleCode().equals(modCode)){
                alChecked.add(al.get(x));
            }
        }

        aa = new DGAdapter(this, R.layout.daily_grade_row,alChecked);
        lvDailyGrades.setAdapter(aa);
    }
}
