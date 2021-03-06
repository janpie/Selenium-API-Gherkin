package APITask.models;

public class PostsModel {

  private final int userId;

  private final int id;

  private final String title;

  private final String body;

  public PostsModel(int userId, int id, String title, String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public int getUserId() {
    return userId;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }
}
