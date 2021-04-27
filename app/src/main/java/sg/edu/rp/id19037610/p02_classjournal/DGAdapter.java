package sg.edu.rp.id19037610.p02_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> al;
    private TextView tvWeeks;
    private TextView tvDailyGrade;
    private Context context;


    public DGAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        al = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.daily_grade_row, parent, false);

        tvWeeks = rowView.findViewById(R.id.tvWeeks);
        tvDailyGrade = rowView.findViewById(R.id.tvDailyGrade);



        DailyCA current = al.get(position);

        String week = "Week " + current.getWeek();
        tvWeeks.setText(week);
        tvDailyGrade.setText(current.getDgGrade());


        return rowView;
    }
}

