package com.example.codeware2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codeware2.R;
import com.example.codeware2.http.ApiService;
import com.example.codeware2.http.RetrofitHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

       // ApiService apiService= RetrofitHelper.getApiService();


        recyclerView=findViewById(R.id.recycle);
        LinearLayoutManager linear=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linear);


        listingdata();


    }


    private void listingdata(){
        ApiService apiService=RetrofitHelper.getInstance().create(ApiService.class);
        Call<Users>listindata=apiService.getData();

        listindata.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                if (response.isSuccessful()){
                    recycleadapter adapter=new recycleadapter(response.body().getData());
                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Failur", Toast.LENGTH_SHORT).show();

            }
        });

    }




    class recycleadapter extends RecyclerView.Adapter<recycleadapter.MyViewHolder>{


        List<Users.Datum> list;

        public recycleadapter(List<Users.Datum>list){
            this.list=list;
        }


        @NonNull
        @Override
        public recycleadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
            recycleadapter.MyViewHolder viewHolder=new recycleadapter.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull recycleadapter.MyViewHolder holder, int position) {

            holder.email.setText(list.get(position).getEmail());
            holder.fstname.setText(list.get(position).getFirstName());
            holder.lstname.setText(list.get(position).getLastName());
            //  holder.userid.setText(list.get(position).getId());
            //____________________________
            Picasso.with(getApplicationContext())
                    .load(list.get(position).getAvatar())
                    .placeholder(R.drawable.ic_launcher_background)
                    .fit()
                    .into(holder.imgs);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }




        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView fstname,userid,lstname,email;
            ImageView imgs;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);



                email=itemView.findViewById(R.id.email);
                // userid=itemView.findViewById(R.id.ids);
                fstname=itemView.findViewById(R.id.fast_name);
                lstname=itemView.findViewById(R.id.last_name);
                imgs=itemView.findViewById(R.id.imgs);
            }

        }



    }
}