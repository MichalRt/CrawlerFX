package FXJava;

import crawler.Crawler;
import crawler.EventDTO;
import crawler.FileEditor;
import crawler.HttpStreamToObjectTransformation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class Main extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;
    private Text formTitle, notification;
    private TextArea loadedFile;
    private Label urlLabel,fileNameLabel, notificationLabel,fileContentLabel;
    private TextField urlInput, fileNameInput;
    private Button sendButton;
    private Scene scene;
    private String cssPath;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Crawler URL");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        formTitle = new Text("Welcome");
        grid.add(formTitle,0,0,2,1);


        urlLabel = new Label("Input URL");
        grid.add(urlLabel,0,1);

        urlInput = new TextField();
        grid.add(urlInput,1,1);

        fileNameLabel = new Label("File name");
        grid.add(fileNameLabel,0,2);

        fileNameInput = new TextField();
        grid.add(fileNameInput,1,2);

        sendButton = new Button("Download data!!!");
        sendButton.setOnAction(this);

        grid.add(sendButton,1,4);

        loadedFile = new TextArea();
        grid.add(loadedFile,1,8);

        fileContentLabel = new Label("File Content");
        grid.add(fileContentLabel,0,8);

        notification = new Text();
        grid.add(notification,1,5);

        notificationLabel = new Label("STATUS");
        grid.add(notificationLabel,0,5);

        scene = new Scene(grid,800,275);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

        notification.setText("IN PROGRESS");
        System.out.println(event.getSource().toString());
        EventDTO dto= new EventDTO();
        try {
            Crawler robot = new Crawler(urlInput.getText());
            new HttpStreamToObjectTransformation(robot.returnInputStream(), dto.getEventListEdited(), dto.getEventListRaw());
            FileEditor.saveToFile(fileNameInput.getText(), dto.getEventListEdited());

            notification.setText(String.valueOf(robot.getResponseCode()));

            ArrayList arrayList = FileEditor.readFile(fileNameInput.getText());
            loadedFile.setText(arrayList.toString());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
            notification.setText("URL ERROR");

            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            notification.setText("FILE ERROR");
            e.printStackTrace();
        }
    }
}
