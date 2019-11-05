package com.example.mysqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, ageEditText, genderEditText;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);
        Button addButton = findViewById(R.id.addButtonId);

        myDatabaseHelper = new MyDatabaseHelper(this);
//        try {
//            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(),"Exceptin : " +e, Toast.LENGTH_LONG).show();
//        }


        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if (view.getId() == R.id.addButtonId) {

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(gender)){
                Toast.makeText(getApplicationContext(), "Insert all value ", Toast.LENGTH_LONG).show();
            }else {
                long rowId = myDatabaseHelper.insertData(name, age, gender);

                if (rowId == -1) {
                    Toast.makeText(getApplicationContext(), "unsuccessfull ", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Row " + rowId + " is sucessfully inserted ", Toast.LENGTH_LONG).show();

                }


            }


        }

    }

}
