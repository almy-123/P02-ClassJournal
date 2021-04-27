package sg.edu.rp.id19037610.p02_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> al;
    private TextView tvModuleCode;
    private TextView tvModuleName;
    private Context context;


    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        al = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.module_row, parent, false);

        tvModuleCode = rowView.findViewById(R.id.tvModuleCode);
        tvModuleName = rowView.findViewById(R.id.tvModuleName);

        Module current = al.get(position);

        tvModuleCode.setText(current.getModuleCode());
        tvModuleName.setText(current.getModuleName());

        return rowView;
    }
}

