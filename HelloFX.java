import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();

        Pane textPane = new Pane();
        textPane.setStyle("-fx-border-color: gray;");
        Text message = new Text(50, 100, "Programming is fun");
        message.setFill(Color.BLACK);
        textPane.getChildren().add(message);
        mainPane.setCenter(textPane);

        HBox topHBox = new HBox(15);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setStyle("-fx-padding: 10px;");

        ToggleGroup colorGroup = new ToggleGroup();

        RadioButton rbRed = new RadioButton("Red");
        rbRed.setToggleGroup(colorGroup);
        rbRed.setOnAction(e -> message.setFill(Color.RED));

        RadioButton rbYellow = new RadioButton("Yellow");
        rbYellow.setToggleGroup(colorGroup);
        rbYellow.setOnAction(e -> message.setFill(Color.YELLOW));

        RadioButton rbBlack = new RadioButton("Black");
        rbBlack.setToggleGroup(colorGroup);
        rbBlack.setOnAction(e -> message.setFill(Color.BLACK));

        RadioButton rbOrange = new RadioButton("Orange");
        rbOrange.setToggleGroup(colorGroup);
        rbOrange.setOnAction(e -> message.setFill(Color.ORANGE));

        RadioButton rbGreen = new RadioButton("Green");
        rbGreen.setToggleGroup(colorGroup);
        rbGreen.setOnAction(e -> message.setFill(Color.GREEN));

        topHBox.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        mainPane.setTop(topHBox);

        HBox bottomHBox = new HBox(15);
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.setStyle("-fx-padding: 10px;");

        Button btnLeft = new Button("<=");
        Button btnRight = new Button("=>");

        double moveStep = 10.0;

        btnLeft.setOnAction(e -> {
            double newX = message.getX() - moveStep;
            if (newX >= 0) {
                message.setX(newX);
            } else {
                message.setX(0);
            }
        });

        btnRight.setOnAction(e -> {
            double newX = message.getX() + moveStep;
            double paneWidth = textPane.getWidth();
            double textWidth = message.getLayoutBounds().getWidth();
            if (newX + textWidth <= paneWidth) {
                message.setX(newX);
            } else {
                message.setX(paneWidth - textWidth);
            }
        });

        bottomHBox.getChildren().addAll(btnLeft, btnRight);
        mainPane.setBottom(bottomHBox);

        Scene scene = new Scene(mainPane, 500, 250);
        primaryStage.setTitle("JavaFX Radio Button & Movement Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
