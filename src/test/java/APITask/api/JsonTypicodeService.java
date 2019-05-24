package APITask.api;

import APITask.models.CommentsUploadModel;
import APITask.models.PostsModel;
import java.util.List;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonTypicodeService {

  @GET("/posts")
  Call<List<PostsModel>> getPosts();

  @GET("/posts")
  Call<List<PostsModel>> getPostsForUser(@Query("userId") int userId);

  @POST("/comments")
  Call<CommentsUploadModel> postComment(@Body RequestBody body);



}
