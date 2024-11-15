package ro.ase.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
Button logIn;
Button register;
EditText email;
EditText parola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        logIn=findViewById(R.id.btnLogIn);

        register=findViewById(R.id.btnRegister);
        register.setOnClickListener(view->{
            Intent intent=new Intent(getApplicationContext(), Rapoarte.class);
            startActivity(intent);
        });

        email=findViewById(R.id.editTextEmail);
        parola=findViewById(R.id.editTextPassword);
        logIn.setOnClickListener(view -> {
            String emailText = email.getText().toString().trim();
            String parolaText = parola.getText().toString().trim();

            ContUser utilizator = UserManager.valideazaUtilizator(emailText, parolaText);

            if (utilizator != null) {
                Toast.makeText(this, "Autentificare reușită!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Credentiale invalide!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}