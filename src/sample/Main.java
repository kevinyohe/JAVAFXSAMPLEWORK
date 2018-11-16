package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application implements EventHandler {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        final HTMLEditor htmlEditor = new HTMLEditor();
        //Scene testscene = new Scene();
        Hyperlink link = new Hyperlink("hey");
        Hyperlink[] links = new Hyperlink[4];
        VBox hbox = new VBox();

        String[] link_urls = { "https://stackoverflow.com/questions/6707695/iterate-through-string-array-in-java",
                                 "http://zetcode.com/gui/javafx/events/","https://www.duckduckgo.com",
                                "https://www.jpmorgan.com" };
        link.setTranslateX(10);
        primaryStage.setScene(new Scene(hbox, 300, 275));

        // I designed this, i think its the first time i really start understanding this language.
        for(int i = 0; i < links.length; i++) {
                links[i] = new Hyperlink("Button-"+ link_urls[i]);
                hbox.getChildren().add(links[i]);
                final String url = link_urls[i];
                //ActionEventHandler for each URL
                links[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        openWebpage(url);
                    }
                });
                links[i].setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Hyperlink li = (Hyperlink) event.getSource();
                    li.setText(url.toUpperCase());
                }
            });
                links[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Hyperlink li = (Hyperlink) event.getSource();
                    li.setText(url.toLowerCase());
                }
            });

            }




        link.setOnAction(this);
        link.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                link.setText(link.getText().toUpperCase());
            }
        });
        link.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                link.setText(link.getText().toLowerCase());
            }
        });
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {


        openWebpage("https://www.zzz.com");
    }

    public  void openWebpage(String url) {
        getHostServices().showDocument(url);
    }
}
