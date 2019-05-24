package APITask;

import APITask.api.JsonTypicodeHandler;
import APITask.models.CommentsUploadModel;
import APITask.models.PostsModel;
import Logger.TaskLogger;
import java.io.IOException;
import java.util.Comparator;
import org.testng.annotations.Test;

public class Runner {

  private int highestId;

  @Test
  private void taskOne() throws IOException {
    int highestUserId = JsonTypicodeHandler.getPosts()
        .stream().max(Comparator.comparingInt(PostsModel::getUserId))
        .get().getUserId();
    TaskLogger.log.info("Highest user id: " + highestUserId);
  }

  @Test(dependsOnMethods = "taskOne")
  private void taskTwo() throws IOException {
    int userId = 10;
    highestId = JsonTypicodeHandler.getPostsForUser(userId)
        .stream().max(Comparator.comparingInt(PostsModel::getId))
        .get().getId();
    TaskLogger.log.info("Highest id for userId=" + userId + " : " + highestId);
  }

  @Test(dependsOnMethods = "taskTwo")
  private void taskThree() throws IOException {
    CommentsUploadModel commentsUploadModel = JsonTypicodeHandler
        .postNewComment(highestId, "Hello", "World", 10);
    TaskLogger.log.info("Successfully uploaded comment with id: " + commentsUploadModel.getId());

  }


}
