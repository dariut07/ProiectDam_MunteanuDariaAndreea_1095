package ro.ase.moneysaver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spnEconomii;
    Button adaugaBuget;
    Button salvareEconomii;
    Button cataEconomie;
    ListView listaBuget;
    List<Buget> bugete = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;
    private static final int GROUP_ID = 0;
    private static final int ID_OPTIUNE1 = 1;
    private static final int ID_OPTIUNE2 = 2;
    private static final int ID_OPTIUNE3 = 3;
    private int pozitieBugetEditatInLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaBuget = findViewById(R.id.listviewBuget);
        spnEconomii = findViewById(R.id.spnProcentEconomii);
        salvareEconomii = findViewById(R.id.btnSalvareEconomie);
        cataEconomie = findViewById(R.id.btnEconomiiTotal);
        adaugaBuget = findViewById(R.id.btnAdaugaBuget);


        SharedPreferences sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        Float bugetSalvat = sharedPreferences.getFloat("bugetSalvat", 0.0f);

        // Configurare TextView pentru buget
        TextView textBuget = findViewById(R.id.textViewBuget);
        if (bugetSalvat > 0) {
            textBuget.setText("Bugetul pe săptămâna aceasta este " + bugetSalvat + " RON");
        } else {
            textBuget.setText("Nu ai setat un buget încă.");
        }


        String[] procente = {"5%", "10%", "15%"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, procente);
        spnEconomii.setAdapter(adapter);


        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() == null) return;

            if (result.getData().hasExtra("bugetFromIntent")) {
                Intent intent = result.getData();
                Buget buget = (Buget) intent.getSerializableExtra("bugetFromIntent");
                if (buget != null) {
                    bugete.add(buget);
                    BugetAdapter adapterBuget = new BugetAdapter(getApplicationContext(), R.layout.view_buget, bugete, getLayoutInflater());
                    listaBuget.setAdapter(adapterBuget);


                    textBuget.setText("Bugetul pe săptămâna aceasta este " + buget.getSuma() + " RON");
                    sharedPreferences.edit().putFloat("bugetSalvat", (float) buget.getSuma()).apply();
                }
            } else if (result.getData().hasExtra("edit")) {
                Intent intent = result.getData();
                Buget buget = (Buget) intent.getSerializableExtra("edit");
                if (buget != null) {
                    Buget bugetDeActualizat = bugete.get(pozitieBugetEditatInLista);
                    bugetDeActualizat.setSuma(buget.getSuma());
                    BugetAdapter bugetAdapter = (BugetAdapter) listaBuget.getAdapter();
                    bugetAdapter.notifyDataSetChanged();


                    textBuget.setText("Bugetul pe săptămâna aceasta este " + buget.getSuma() + " RON");
                    sharedPreferences.edit().putFloat("bugetSalvat", (float) buget.getSuma()).apply();
                }
            }
        });


        listaBuget.setOnItemClickListener((adapterView, view, position, l) -> {
            pozitieBugetEditatInLista = position;
            Intent intent1 = new Intent(getApplicationContext(), AdaugaBuget.class);
            intent1.putExtra("edit", bugete.get(position));
            launcher.launch(intent1);
        });


        adaugaBuget.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdaugaBuget.class);
            launcher.launch(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(GROUP_ID, ID_OPTIUNE1, 1, R.string.optiune_1);
        menu.add(GROUP_ID, ID_OPTIUNE2, 2, R.string.optiune_2);
        menu.add(GROUP_ID, ID_OPTIUNE3, 3, R.string.optiune_3);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case ID_OPTIUNE1:
                Intent intent1 = new Intent(getApplicationContext(), AdaugaCheltuiala.class);
                startActivity(intent1);
                return true;

            case ID_OPTIUNE2:
                Intent intent2 = new Intent(getApplicationContext(), AdaugaVenit.class);
                startActivity(intent2);
                return true;

            case ID_OPTIUNE3:
                Intent intent3 = new Intent(getApplicationContext(), Rapoarte.class);
                startActivity(intent3);
                return true;
        }
        return true;
    }
}
