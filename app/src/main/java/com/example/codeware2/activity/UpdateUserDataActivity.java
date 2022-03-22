package com.example.codeware2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.codeware2.R;
import com.example.codeware2.http.ApiService;
import com.example.codeware2.http.RetrofitHelper;
import com.example.codeware2.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUserDataActivity extends AppCompatActivity {

    public TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_data);
        textViewResult = findViewById(R.id.text_view_result2);
        ApiService apiService= RetrofitHelper.getApiService();

        Intent intent=getIntent();
        final int id=intent.getIntExtra("id",0);
        final String name=intent.getStringExtra("name");
        final String job=intent.getStringExtra("job");

        Call<Post> call=apiService.put_Post(id,name,job);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post postResponse= response.body();

                String content = "";
                content += "Code"+response.code()+ "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "Name: " + postResponse.getName() + "\n";
                content += "Job: " + postResponse.getJob() + "\n";
                content += "CreatedAt: " + postResponse.getCreatedAt() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });


    }
}