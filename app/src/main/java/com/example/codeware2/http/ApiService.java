package com.example.codeware2.http;

import com.example.codeware2.activity.Users;
import com.example.codeware2.model.Post;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {



    @GET("api/users")
    Call<Users>getData();

//    @POST("api/users")
//    Call<Post> createPost(@Body Post post);


    @FormUrlEncoded
    @POST("api/users")
    Call<Post> createPost(
            @Field("name")String name,
            @Field("job")String job

    );

//    @FormUrlEncoded
//    @POST("api/users")
//    Call<Post> createPost(@FieldMap Map<String, String> fields);


//    @PUT("api/users/{id}")
//    Call<Post> put_Post(@Path("id") int id, @Body Post post) ;

    @FormUrlEncoded
    @PUT("api/users/{id}")
    Call<Post>put_Post(
            @Field("id")int id,
            @Field("name")String name,
            @Field("job")String job
    );


//    @FormUrlEncoded
//    @PUT("api/users/{22}")
//    Call<Post>putPost(@FieldMap Map<String,String>fields);

//    @PATCH("api/users/{id}")
//    Call<Post> patchPost(@Path("id") int id, @Body Post post);



    @DELETE("api/users/{id}")
    Call<Void> deletePost(@Path("id") int id);
//
//    @FormUrlEncoded
//    @DELETE("api/users/{id}")
//    Call<Void>deletePost(
//            @Field("id")int id
//    );
}
