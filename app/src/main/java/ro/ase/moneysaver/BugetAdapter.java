package ro.ase.moneysaver;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BugetAdapter extends ArrayAdapter<Buget> {
    private Context context;
    private int layoutId;
    private List<Buget> bugete;
    private LayoutInflater layoutInflater;

    public BugetAdapter(@NonNull Context context, int layoutId, @NonNull List<Buget> bugete, LayoutInflater layoutInflater) {
        super(context, layoutId, bugete);
        this.context = context;
        this.layoutId = layoutId;
        this.bugete = bugete;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=layoutInflater.inflate(layoutId,parent,false);
        Buget buget=bugete.get(position);
        TextView tvSuma=view.findViewById(R.id.textVSumaBuget);
        tvSuma.setText(String.valueOf(buget.getSuma()));
        if(buget.getSuma()<100){
            tvSuma.setTextColor(Color.RED);
        }else if(buget.getSuma()<250){
            tvSuma.setTextColor(Color.YELLOW);

        }else{
            tvSuma.setTextColor(Color.GREEN);
        }
        return view;
    }
}
