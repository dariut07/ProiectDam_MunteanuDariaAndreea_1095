package ro.ase.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Rapoarte extends AppCompatActivity {
Spinner perioadeTimp;
Switch swCheltuieli;
Switch swVenituri;
Spinner spnCateg;
Button btnDocument;
ListView listViewTranzactii;
    ArrayList<Tranzactie> tranzactiiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rapoarte);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spnCateg=findViewById(R.id.spnCateg);
        perioadeTimp=findViewById(R.id.spnPerioadaTimp);
String[] categorii={"Sanatate","Casa","Cadouri","Educatie","Alimente"};
        ArrayAdapter<String> arrayAdapterCateg=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,categorii);
        spnCateg.setAdapter(arrayAdapterCateg);
        String[] perioade={"Azi","O saptamana","O luna"};
        ArrayAdapter<String> arrayAdapterPerioade=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,perioade);
        perioadeTimp.setAdapter(arrayAdapterPerioade);
        swCheltuieli=findViewById(R.id.switchCheltuieli);
        swVenituri=findViewById(R.id.switchVenituri);
        btnDocument=findViewById(R.id.btnObtineDocument);
        listViewTranzactii=findViewById(R.id.lv);
        tranzactiiList = new ArrayList<>();
        Intent intent = getIntent();
        Tranzactie tranzactie = (Tranzactie) intent.getSerializableExtra("tranzactie");
        if (tranzactie != null) {
            tranzactiiList.add(tranzactie);
        }
        ArrayAdapter<Tranzactie> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tranzactiiList);

        listViewTranzactii.setAdapter(adapter);
    }
}