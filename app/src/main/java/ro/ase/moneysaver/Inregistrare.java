package ro.ase.moneysaver;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inregistrare extends AppCompatActivity {
EditText nume;
EditText prenume;
EditText email;
EditText parola;
Button salvareCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inregistrare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nume=findViewById(R.id.editTextNume);
        prenume=findViewById(R.id.editTextPrenume);
        email=findViewById(R.id.editTextEmailReg);
        parola=findViewById(R.id.editTextParola);
        salvareCont=findViewById(R.id.btnSalveazaCont);
        salvareCont.setOnClickListener(view -> {
            String numeUtilizator = nume.getText().toString();
            String prenumeUtilizator = prenume.getText().toString();
            String emailUtilizator = email.getText().toString();
            String parolaUtilizator = parola.getText().toString();

            if (!numeUtilizator.isEmpty() && !prenumeUtilizator.isEmpty() && !emailUtilizator.isEmpty() && !parolaUtilizator.isEmpty()) {
                ContUser utilizator = new ContUser(numeUtilizator, prenumeUtilizator, emailUtilizator, parolaUtilizator);
                UserManager.adaugaUtilizator(utilizator);
                Toast.makeText(Inregistrare.this, "Cont creat cu succes!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(Inregistrare.this, "Toate câmpurile sunt obligatorii!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}