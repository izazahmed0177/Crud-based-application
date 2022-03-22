package com.example.codeware2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codeware2.R;
import com.example.codeware2.http.ApiService;
import com.example.codeware2.http.RetrofitHelper;

public class CreateUserActivity extends AppCompatActivity {
    private Button button5;
    private EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        button5=findViewById(R.id.create_post);
        editText1=findViewById(R.id.edit_text_create_name);
        editText2=findViewById(R.id.edit_text_create_job);
        ApiService apiService= RetrofitHelper.getApiService();




        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")){
                    Toast.makeText(CreateUserActivity.this, "Please insert value", Toast.LENGTH_SHORT).show();
                }else {
                    String name=editText1.getText().toString();
                    String job=editText2.getText().toString();

                    Intent intent=new Intent(CreateUserActivity.this,CreateUserDataActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("job",job);
                    startActivity(intent);
                }
               // openCreateDataActivity();
            }
        });



    }

//    public void openCreateDataActivity(){
//        Intent intent=new Intent(this, CreateUserDataActivity.class);
//        startActivity(intent);
//
//    }



}