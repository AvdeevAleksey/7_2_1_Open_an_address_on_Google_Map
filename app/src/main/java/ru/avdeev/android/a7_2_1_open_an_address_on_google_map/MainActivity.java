package ru.avdeev.android.a7_2_1_open_an_address_on_google_map;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText pathTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pathTextName = findViewById(R.id.pathEditText);
        Button searchBtn = findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = pathTextName.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (searchText.length()>0) {
                    if (searchLetter(searchText)){
                        Uri uri = Uri.parse("geo:?q=" + searchText);
                        intent.setData(uri);
                    } else{
                        String[] coordinates = searchText.split(",");
                        Uri uri = Uri.parse("geo:" + coordinates[0] + "," + coordinates[1]);
                        intent.setData(uri);
                    }
                    startActivity(intent);
                } else {
                    showMyMessage(R.string.No_data_to_search_for, MainActivity.this);
                }

            }
        });
    }

    public boolean searchLetter(String string) {
        char[] chars = string.toCharArray();
        Boolean result = false;
        for (int i = 0;i<chars.length && !result; i++) {
            result = Character.isLetter(chars[i]);
        }
        return result;
    }

    public static void showMyMessage(int massage, Context context) {
        String text = context.getString(massage);
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(context, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}