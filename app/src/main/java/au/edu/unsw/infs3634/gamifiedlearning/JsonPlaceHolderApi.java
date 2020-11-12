package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("insight_weather/?api_key=umeVLC3jadNVwXw4wZQdc3CS1pCRu9BvUnDyamZn&feedtype=json&ver=1.0")//this is the relative url
    Call<List<Post>> getPosts();
}
