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

public class UpdateUserActivity extends AppCompatActivity {
    private Button button6;
    private EditText editText1,editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        button6=findViewById(R.id.update_put);
        editText1=findViewById(R.id.edit_text_update_id);
        editText2=findViewById(R.id.edit_text_update_name);
        editText3=findViewById(R.id.edit_text_update_job);
        ApiService apiService= RetrofitHelper.getApiService();



        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")
                        ||editText3.getText().toString().equals("")){
                    Toast.makeText(UpdateUserActivity.this, "Please insert value", Toast.LENGTH_SHORT).show();
                }else {
                    int id=Integer.parseInt(editText1.getText().toString());
                    String name=editText2.getText().toString();
                    String job=editText3.getText().toString();

                    Intent intent=new Intent(UpdateUserActivity.this,UpdateUserDataActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("name",name);
                    intent.putExtra("job",job);
                    startActivity(intent);
                }




                //openUpdateDataActivity();
            }
        });
    }
//    public void openUpdateDataActivity(){
//        Intent intent=new Intent(this, UpdateUserDataActivity.class);
//        startActivity(intent);
//
//    }
}