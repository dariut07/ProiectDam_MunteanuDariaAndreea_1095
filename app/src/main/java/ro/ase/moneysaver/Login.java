package ro.ase.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    Button logIn;
    Button register;
    EditText email;
    EditText parola;
    List<ContUser> userList = new ArrayList<>();
    ListView lvUseri;
    private int pozitieUserEditatInLista;
    private ActivityResultLauncher<Intent> launcher;

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
        UserDB dbInstance = UserDB.getInstance(getApplicationContext());
        lvUseri = findViewById(R.id.listViewUseri);
        actualizeazaListaUtilizatori(dbInstance);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Intent intent = result.getData();
            if (intent != null) {
                if (intent.hasExtra("userFromIntent")) {
                    ContUser user = (ContUser) intent.getSerializableExtra("userFromIntent");
                    if (user != null) {
                        dbInstance.getUserDAO().insertUser(user);
                        actualizeazaListaUtilizatori(dbInstance);
                    }
                } else if (intent.hasExtra("edit")) {
                    ContUser user = (ContUser) intent.getSerializableExtra("edit");
                    if (user != null) {
                        ContUser userDeActualizat = userList.get(pozitieUserEditatInLista);
                        userDeActualizat.setNume(user.getNume());
                        userDeActualizat.setPrenume(user.getPrenume());
                        userDeActualizat.setEmail(user.getEmail());
                        userDeActualizat.setParola(user.getParola());
                        actualizeazaListaUtilizatori(dbInstance);

                    }
                }
            }
        });

        logIn = findViewById(R.id.btnLogIn);
        register = findViewById(R.id.btnRegister);
        email = findViewById(R.id.editTextEmail);
        parola = findViewById(R.id.editTextPassword);

        logIn.setOnClickListener(view -> {
            String emailText = email.getText().toString().trim();
            String parolaText = parola.getText().toString().trim();

            ContUser utilizator = dbInstance.getUserDAO().getUserByEmailAndPassword(emailText, parolaText);
            if (utilizator != null) {
                Toast.makeText(this, "Autentificare reușită!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Credentiale invalide!", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Inregistrare.class);
            launcher.launch(intent);
        });

        lvUseri.setOnItemClickListener((adapterView, view, position, id) -> {
            pozitieUserEditatInLista = position;
            Intent intent = new Intent(getApplicationContext(), Inregistrare.class);
            intent.putExtra("edit", userList.get(position));
            launcher.launch(intent);
        });
    }

    private void actualizeazaListaUtilizatori(UserDB dbInstance) {
        userList = dbInstance.getUserDAO().getAll();
        UserAdapter userAdapter = new UserAdapter(getApplicationContext(), R.layout.view_useri, userList, getLayoutInflater());
        lvUseri.setAdapter(userAdapter);
    }
}
