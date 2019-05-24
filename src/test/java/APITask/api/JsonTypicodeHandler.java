package APITask.api;

import APITask.models.CommentsUploadModel;
import APITask.models.PostsModel;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonTypicodeHandler {

  private static final String API_URL = "https://jsonplaceholder.typicode.com";

  public static List<PostsModel> getPosts() throws IOException {
    Call<List<PostsModel>> postsModelCall = service.getPosts();
    return postsModelCall.execute().body();
  }

  public static List<PostsModel> getPostsForUser(int userId) throws IOException {
    Call<List<PostsModel>> postsModelCall = service.getPostsForUser(userId);
    return postsModelCall.execute().body();
  }

  public static CommentsUploadModel postNewComment(int id, String title, String body, int userId)
      throws IOException {
    RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),
        "{id: " + id + ","
            + "title: '" + title + "',"
            + "body: '" + body + "',"
            + " userId: " + userId + "}");
    Call<CommentsUploadModel> commentsUploadModelCall = service.postComment(requestBody);
    return commentsUploadModelCall.execute().body();
  }

  private static final OkHttpClient okHttpClient = new OkHttpClient()
      .newBuilder()
      .addInterceptor(
          new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
              .setLevel(HttpLoggingInterceptor.Level.BASIC)
      )
      .build();


  private static final JsonTypicodeService service = new Retrofit.Builder()
      .baseUrl(API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient)
      .build()
      .create(JsonTypicodeService.class);

}
