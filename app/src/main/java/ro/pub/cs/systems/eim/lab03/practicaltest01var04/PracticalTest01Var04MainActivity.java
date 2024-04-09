package ro.pub.cs.systems.eim.lab03.practicaltest01var04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button nextActivityButton = (Button)findViewById(R.id.nextButton);
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        Button displayButton = (Button)findViewById(R.id.displayButton);
        TextView textView = (TextView)findViewById(R.id.textView);

        displayButton.setOnClickListener(v -> {
            StringBuilder text = new StringBuilder();
            if (checkBox1.isChecked()) {
                if (editText1.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "First edit text is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                text.append(editText1.getText().toString());
            }
            if (checkBox2.isChecked()) {
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Second edit text is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                text.append(editText2.getText().toString());
            }
            textView.setText(text);
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        TextView textView = (TextView)findViewById(R.id.textView);
        savedInstanceState.putString("editText1", editText1.getText().toString());
        savedInstanceState.putString("editText2", editText2.getText().toString());
        savedInstanceState.putString("textView", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        TextView textView = (TextView)findViewById(R.id.textView);
        editText1.setText(savedInstanceState.getString("editText1"));
        editText2.setText(savedInstanceState.getString("editText2"));
        textView.setText(savedInstanceState.getString("textView"));
    }
}