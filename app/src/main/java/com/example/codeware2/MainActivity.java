package com.example.codeware2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codeware2.activity.CreateUserActivity;
import com.example.codeware2.activity.DeleteUserActivity;
import com.example.codeware2.activity.UpdateUserActivity;
import com.example.codeware2.activity.UserListActivity;
import com.example.codeware2.http.ApiService;
import com.example.codeware2.http.RetrofitHelper;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.create_user);
        button2=findViewById(R.id.update_user);
        button3=findViewById(R.id.delete_user);
        button4=findViewById(R.id.user_list);

        ApiService apiService= RetrofitHelper.getApiService();



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateActivity();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUpdateActivity();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteActivity();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserListActivity();
            }
        });



    }
    public void openCreateActivity(){
        Intent intent=new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }

    public void openUpdateActivity(){
        Intent intent=new Intent(this, UpdateUserActivity.class);
        startActivity(intent);
    }

    public void openDeleteActivity(){
        Intent intent=new Intent(this, DeleteUserActivity.class);
        startActivity(intent);

    }
    public void openUserListActivity(){
        Intent intent=new Intent(this, UserListActivity.class);
        startActivity(intent);
    }
}