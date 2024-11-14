package ro.ase.moneysaver;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Spinner spnEconomii;
Button adaugaBuget;
Button rapoarte;
Button cataEconomie;
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

        String[] procente={"5%","10%","15%"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,procente);
        spnEconomii.setAdapter(adapter);
        rapoarte=findViewById(R.id.btnRapoarte);
        cataEconomie=findViewById(R.id.btnEconomiiTotal);
        adaugaBuget=findViewById(R.id.btnAdaugaBuget);
    }
}