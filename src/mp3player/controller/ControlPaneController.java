package mp3player.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class ControlPaneController implements Initializable{

    @FXML
    private Button nextButton;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider songSlider;

    @FXML
    private Button prevButton;

    @FXML
    private ToggleButton playButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureButtons();
        //configureVolume();
        //configureSong();
        configureSliders();

    }

    private void configureSliders() {
    	volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Zmiana głośności " + newValue.doubleValue());
            }
        });

    	songSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Przesuniecie piosenki " + newValue.doubleValue());
            }
        });

	}

//	private void configureSong() {
//    	songSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("test suwak piosenek");
//            }
//        });
//
//	}
//
//	private void configureVolume() {
//        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("test suwak głośności");
//            }
//        });
//    }

    private void configureButtons() {
        prevButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Poprzednia piosenka");
            }
        });


        nextButton.setOnAction (new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(playButton.isSelected()) {
                    System.out.println("Następna piosenka");
                    }
			}
        });



        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(playButton.isSelected()) {
                    System.out.println("Play");
                } else {
                    System.out.println("Stop");
                }
            }
        });
    }
}
