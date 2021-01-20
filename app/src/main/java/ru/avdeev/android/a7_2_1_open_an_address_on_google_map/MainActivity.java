package ru.avdeev.android.a7_2_1_open_an_address_on_google_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText pathTextName = findViewById(R.id.pathEditTextName);
        EditText coordinateX = findViewById(R.id.pathEditTextCoordinatesX);
        EditText coordinateY = findViewById(R.id.pathEditTextCoordinatesY);
        Button searchBtn = findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (!pathTextName.getText().toString().equals("")) {
                    Uri uri = Uri.parse("geo:?q=" + pathTextName.getText().toString());
                    intent.setData(uri);
                }
                
            }
        });
    }
}