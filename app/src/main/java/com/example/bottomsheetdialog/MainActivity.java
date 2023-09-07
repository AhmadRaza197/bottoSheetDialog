package com.example.bottomsheetdialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomsheetdialog.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
public class MainActivity extends AppCompatActivity {
Button show;
BottomSheetDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.show);
        dialog = new BottomSheetDialog(this);
        createDialogue();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
    private void createDialogue() {
        View view = getLayoutInflater().inflate(R.layout.bottom_dialogue,null,false);
        Button submit = view.findViewById(R.id.submit);
        EditText name = view.findViewById(R.id.name);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setContentView(view);
    }
}