package ro.ase.moneysaver;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaVenit extends AppCompatActivity {
    EditText suma;
    EditText data;
    EditText descriere;
    Spinner categorie;
    Spinner valuta;
    Button salveazaVenit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_venit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        suma=findViewById(R.id.editTextSumaPrimita);
        data=findViewById(R.id.editTextDataPrimire);
        descriere=findViewById(R.id.editTextDescrierePrimire);
        categorie=findViewById(R.id.spnCategorieVenit);
        valuta=findViewById(R.id.spnValutaVenit);
        String[] categorieArray={"Salariu","Cadou","Alte"};
        ArrayAdapter<String> arrayAdapterCategorie=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,categorieArray);
        categorie.setAdapter(arrayAdapterCategorie);
        String[] valutaArray={"EUR","RON","DOL","CHF"};
        ArrayAdapter<String> arrayAdapterValuta=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,valutaArray);
        valuta.setAdapter(arrayAdapterValuta);
        salveazaVenit=findViewById(R.id.btnSalvareVenit);
    }
}