package sg.edu.rp.id19037610.p02_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayList<Module> modules;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = findViewById(R.id.lvModules);

        modules = new ArrayList<Module>();
        modules.add(new Module("C302","Web Services"));
        modules.add(new Module("C347","Android Programming II"));

        aa = new ModuleAdapter(this, R.layout.module_row,modules);
        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                String moduleCodeSelected = modules.get(position).getModuleCode();
                i.putExtra("selectedModCode", moduleCodeSelected);
                startActivity(i);
            }
        });
    }

}