package graycatdeveloper.javafxconstraintlayout;

import graycatdeveloper.javafxconstraintlayout.widget.ConstraintBorderPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image(getClass().getResource("/res/drawable/ic_launcher.png").toString()));
        stage.setTitle("JavaFX ConstraintLayout");
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.centerOnScreen();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/res/layout/main_activity.fxml"), null);
        loader.setController(this);

        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("/res/values/styles/main_activity.css");
        stage.setScene(scene);

        stage.show();

        ConstraintBorderPane pane2 = (ConstraintBorderPane) root.lookup("#pane2");
        postDelayed(() -> {
            final double ch = pane2.getHeight();
            for (int i = 0; i < 300; i++) {
                final int h = i;
                Platform.runLater(() -> {
                    pane2.setPrefHeight(ch + h);
                    pane2.setMinHeight(ch + h);
                    pane2.setMaxHeight(ch + h);
                });
                sleep(1);
            }
            final double ch2 = pane2.getWidth();
            for (int i = 0; i < 100; i++) {
                final int h = i;
                Platform.runLater(() -> {
                    pane2.setPrefHeight(ch2 + h);
                    pane2.setMinWidth(ch2 + h);
                    pane2.setMaxWidth(ch2 + h);
                });
                sleep(1);
            }
            final double ch3 = pane2.getWidth();
            for (int i = 0; i < 300; i++) {
                final int h = i;
                Platform.runLater(() -> {
                    pane2.setPrefHeight(ch3 - h);
                    pane2.setMinWidth(ch3 - h);
                    pane2.setMaxWidth(ch3 - h);
                });
                sleep(1);
            }
        }, 1000);
    }

    private Thread postDelayed(final Runnable runnable, final long delayMillis) {
        long requested = System.currentTimeMillis();
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    long leftToSleep = requested + delayMillis - System.currentTimeMillis();
                    if (leftToSleep > 0) {
                        Thread.sleep(leftToSleep);
                    }
                    break;
                } catch (InterruptedException ignored) {
                    //
                }
            }
            if (!Thread.currentThread().isInterrupted()) runnable.run();
        });
        t.start();
        return t;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {}
    }

    public static void main(String[] args) {
        launch(args);
    }

}
