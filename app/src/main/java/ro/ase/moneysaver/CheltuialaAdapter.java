package ro.ase.moneysaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class CheltuialaAdapter extends ArrayAdapter<Cheltuiala> {
    private Context context;
    private int layoutId;
    private List<Cheltuiala> cheltuieli;
    private LayoutInflater layoutInflater;
    public CheltuialaAdapter(@NonNull Context context, int layoutId, @NonNull List<Cheltuiala> cheltuieli, LayoutInflater layoutInflater) {
        super(context, layoutId, cheltuieli);
       this.context = context;
        this.layoutId = layoutId;
        this.cheltuieli = cheltuieli;
        this.layoutInflater = layoutInflater;
    }
    @NonNull
   @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        Cheltuiala cheltuiala = cheltuieli.get(position);
        TextView tvSuma = view.findViewById(R.id.textCSuma);
        TextView tvData = view.findViewById(R.id.textCData);
        TextView tvDescriere = view.findViewById(R.id.textCDescriere);
        TextView tvCategorie = view.findViewById(R.id.textCCategorie);
        TextView tvUrgenta = view.findViewById(R.id.textCUrgenta);
        ImageView imgUrgenta = view.findViewById(R.id.imgCUrgenta);
        tvSuma.setText(String.valueOf(cheltuiala.getSuma()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dataFormatata = sdf.format(cheltuiala.getData());
        tvData.setText(dataFormatata);
        tvDescriere.setText(cheltuiala.getDescriere());
        tvCategorie.setText(cheltuiala.getCategorie().toString());
        if (cheltuiala.esteUrgenta()==true) {
            tvUrgenta.setVisibility(View.VISIBLE);
            imgUrgenta.setVisibility(View.VISIBLE);
        } else {
            tvUrgenta.setVisibility(View.GONE);
            imgUrgenta.setVisibility(View.GONE);
        }

        return view;
    }
}

