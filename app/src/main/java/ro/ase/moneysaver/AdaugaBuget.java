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
        Intent editIntent = getIntent();
        if (editIntent.hasExtra("edit")) {
            isEditing = true;
            Buget editBuget = (Buget) editIntent.getSerializableExtra("edit");
            sumaBuget.setText(String.valueOf(editBuget.getSuma()));
        }
    salveazaBuget.setOnClickListener(view->{
        float sumaBugetText=Float.parseFloat(sumaBuget.getText().toString());
        Buget buget=new Buget(sumaBugetText);
        getSharedPreferences("local", MODE_PRIVATE)
                .edit()
                .putFloat("bugetSalvat", (float) sumaBugetText)
                .apply();
        Intent intent=getIntent();
        if (isEditing) {
            intent.putExtra("edit", buget);
            isEditing = false;
        } else {
            intent.putExtra("bugetFromIntent", buget);
        }
        setResult(RESULT_OK,intent);
        finish();
    });
    }
}