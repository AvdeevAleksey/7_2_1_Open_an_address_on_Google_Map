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
        final EditText pathTextName = findViewById(R.id.pathEditText);
        Button searchBtn = findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String searchText = pathTextName.getText().toString();
                if (!searchText.equals("") && (searchLetter(searchText))) {
                    Uri uri = Uri.parse("geo:?q=" + pathTextName.getText().toString());
                    intent.setData(uri);
                } else {
                    String[] coordinates = searchText.split(",");
                    Uri uri = Uri.parse("geo:" + coordinates[0] + "," + coordinates[1]);
                    intent.setData(uri);
                }
                startActivity(intent);
            }
        });
    }

    public boolean searchLetter(String string) {
        char[] chars = string.toCharArray();
        Boolean result = false;
        for (int i = 0; result; i++) {
            result = Character.isLetter(chars[i]);
            if (result) {
                return true;
            }
        }
        return false;
    }
}