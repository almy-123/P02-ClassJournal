package sg.edu.rp.id19037610.p02_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayList<String> modules;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = findViewById(R.id.lvModules);

        modules = new ArrayList<>();
        modules.add("C347");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, modules);
        lvModules.setAdapter(adapter);
    }
}