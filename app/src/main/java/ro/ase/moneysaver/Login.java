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
import androidx.activity.result.contract.ActivityResultContract;
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
List<ContUser> userList=new ArrayList<>();
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
        lvUseri=findViewById(R.id.listViewUseri);
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{

        if(result.getData().hasExtra("userFromIntent")){
            Intent intent=result.getData();
            ContUser user=(ContUser) intent.getSerializableExtra("userFromIntent");
        if(user!=null){
            userList.add(user);
           UserAdapter userAdapter=new UserAdapter(getApplicationContext(),R.layout.view_useri,userList,getLayoutInflater());
        lvUseri.setAdapter(userAdapter);
        }
        }else if(result.getData().hasExtra("edit")){
            Intent intent = result.getData();
            ContUser user = (ContUser) intent.getSerializableExtra("edit");

            if (user != null){
                ContUser userDeActualizat = userList.get(pozitieUserEditatInLista);
                userDeActualizat.setNume(user.getNume());
                userDeActualizat.setPrenume(user.getPrenume());
                userDeActualizat.setEmail(user.getEmail());
                userDeActualizat.setParola(user.getParola());
                UserAdapter userAdapter = (UserAdapter) lvUseri.getAdapter();
                userAdapter.notifyDataSetChanged();
            }
        }
        });
        logIn=findViewById(R.id.btnLogIn);
        lvUseri.setOnItemClickListener((adapterView,view,position,l)->{
            pozitieUserEditatInLista=position;
            Intent intent1=new Intent(getApplicationContext(), Inregistrare.class);
            intent1.putExtra("edit",userList.get(position));
            launcher.launch(intent1);

        });
        register=findViewById(R.id.btnRegister);
        register.setOnClickListener(view->{
            Intent intent1=new Intent(getApplicationContext(), Inregistrare.class);
            launcher.launch(intent1);
        });

        email=findViewById(R.id.editTextEmail);
        parola=findViewById(R.id.editTextPassword);

        logIn.setOnClickListener(view -> {
            String emailText = email.getText().toString().trim();
            String parolaText = parola.getText().toString().trim();

            ContUser utilizator = UserManager.valideazaUtilizator(emailText, parolaText);

            if (utilizator != null) {
                Toast.makeText(this, "Autentificare reusita!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                finish();
            } else {
                Toast.makeText(this, "Credentiale invalide!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}