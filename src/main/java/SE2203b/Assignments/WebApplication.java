package SE2203b.Assignments;

import com.jpro.webapi.JProApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WebApplication extends JProApplication {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        //load user interface as FXML file
        FXMLLoader loader = new FXMLLoader(WebApplication.class.getResource("fxml/WebView.fxml"));
        Parent root = loader.load();

        WebController controller = loader.getController();
        controller.init(this);

        //create JavaFX scene
        Scene scene = new Scene(root);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        //open JavaFX window
        stage.show();


//set the background and make it resizable
        ((AnchorPane) scene.lookup("AnchorPane")).setBackground(new Background(new BackgroundImage(new Image("file:src/main/resources/SE2203b/Assignments/img/670457.jpeg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false))));


        //Set Data to FXML through controller
        controller.setData();
    }
}
