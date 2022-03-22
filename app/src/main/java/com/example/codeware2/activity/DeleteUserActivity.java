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

public class DeleteUserActivity extends AppCompatActivity {
    private Button button7;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        button7=findViewById(R.id.delete_id);
        editText1=findViewById(R.id.editTextDeletId);
        ApiService apiService= RetrofitHelper.getApiService();



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText1.getText().toString().equals("")){
                    Toast.makeText(DeleteUserActivity.this, "Please insert value", Toast.LENGTH_SHORT).show();
                }else {
                    int id=Integer.parseInt(editText1.getText().toString());


                    Intent intent=new Intent(DeleteUserActivity.this,DeleteUserDataActivity.class);
                    intent.putExtra("id",id);

                    startActivity(intent);
                }





                //openDeleteDataActivity();
            }
        });
    }
//    public void openDeleteDataActivity(){
//        Intent intent=new Intent(this, DeleteUserDataActivity.class);
//        startActivity(intent);
//
//    }
}