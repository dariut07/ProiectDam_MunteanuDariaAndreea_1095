package ro.ase.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Spinner spnEconomii;
Button adaugaBuget;
Button salvareEconomii;
Button cataEconomie;
    private static final int GROUP_ID=0;
    private static final int ID_OPTIUNE1=1;
    private static final int ID_OPTIUNE2=2;
    private static final int ID_OPTIUNE3=3;
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
spnEconomii=findViewById(R.id.spnProcentEconomii);
        String[] procente={"5%","10%","15%"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,procente);
        spnEconomii.setAdapter(adapter);
        salvareEconomii=findViewById(R.id.btnSalvareEconomie);
        cataEconomie=findViewById(R.id.btnEconomiiTotal);
        adaugaBuget=findViewById(R.id.btnAdaugaBuget);
        adaugaBuget.setOnClickListener(view->{
            Intent intent=new Intent(getApplicationContext(),AdaugaBuget.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(GROUP_ID,ID_OPTIUNE1,1,R.string.optiune_1);
        menu.add(GROUP_ID,ID_OPTIUNE2,2,R.string.optiune_2);
        menu.add(GROUP_ID,ID_OPTIUNE3,3,R.string.optiune_3);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case ID_OPTIUNE1:
                Intent intent1=new Intent(getApplicationContext(),AdaugaCheltuiala.class);
                startActivity(intent1);

            case ID_OPTIUNE2:
                Intent intent2=new Intent(getApplicationContext(), AdaugaVenit.class);
                startActivity(intent2);
            case ID_OPTIUNE3:
                Intent intent3=new Intent(getApplicationContext(), Rapoarte.class);
                startActivity(intent3);

        }
        return true;
    }
}