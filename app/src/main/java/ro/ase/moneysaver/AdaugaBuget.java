package ro.ase.moneysaver;

import static java.lang.Double.parseDouble;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaBuget extends AppCompatActivity {
EditText sumaBuget;
Button salveazaBuget;
Boolean isEditing=false;
Button stergeBuget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_buget);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    sumaBuget=findViewById(R.id.editTextValoareBuget);
    salveazaBuget=findViewById(R.id.btnSalveazaBuget);
    stergeBuget=findViewById(R.id.btnSterge);
        Intent editIntent = getIntent();
        if (editIntent.hasExtra("edit")) {
            isEditing = true;
            Buget editBuget = (Buget) editIntent.getSerializableExtra("edit");
            sumaBuget.setText(String.valueOf(editBuget.getSuma()));
        }
        AppDB dbInstance = AppDB.getInstance(getApplicationContext());
    salveazaBuget.setOnClickListener(view->{
        Intent intent=getIntent();
        float sumaBugetText=Float.parseFloat(sumaBuget.getText().toString());
        ContUser user=(ContUser) intent.getSerializableExtra("user");
        Buget buget=new Buget(sumaBugetText,user.getId());
        if (isEditing) {
            Intent intent1=new Intent();
            intent1.putExtra("edit", buget);
            isEditing = false;
        } else {
            dbInstance.getBugetDAO().insertBuget(buget);
            intent.putExtra("bugetFromIntent", buget);
        }
        setResult(RESULT_OK,intent);
        finish();
    });
    stergeBuget.setOnClickListener(view->{
        if(isEditing){
            Buget buget=(Buget)editIntent.getSerializableExtra("edit");
            dbInstance.getBugetDAO().deleteBugetById(buget.getIdBuget());
            Intent intent=new Intent();
            intent.putExtra("deleteBuget",true);
            setResult(RESULT_OK,intent);
            finish();
        }
    });
    }
}