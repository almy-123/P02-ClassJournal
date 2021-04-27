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
    TextView tvtest;

    ArrayList<DailyCA> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent i = getIntent();
        Integer index = i.getIntExtra("index", 0);

        tvtest = findViewById(R.id.tvTest);
        tvtest.setText(index.toString());

        lvDailyGrades = findViewById(R.id.lvDailyGrades);
        al = new ArrayList<DailyCA>();
        al.add(new DailyCA("B","C347",1));
        al.add(new DailyCA("C","C347",2));
        al.add(new DailyCA("A","C347",3));

        aa = new DGAdapter(this, R.layout.daily_grade_row,al);
        lvDailyGrades.setAdapter(aa);
    }
}
