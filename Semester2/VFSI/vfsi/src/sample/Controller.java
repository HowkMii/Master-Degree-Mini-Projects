package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label lblSalleAttente, lblSalleExamen, lblMedecineDisponible;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onStart() {
        new Thread() {
            @Override
            public void run() {
                while (Integer.parseInt(lblSalleAttente.getText()) > 0) {
                    if (Integer.parseInt(lblMedecineDisponible.getText()) > 0) {
                        addValue(lblSalleExamen, 2);
                        addValue(lblSalleAttente, -1);
                        addValue(lblMedecineDisponible, -1);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }

                    addValue(lblSalleExamen, -2);
                    addValue(lblMedecineDisponible, 1);





                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }}

                System.out.println(Integer.parseInt(lblSalleAttente.getText()) == 0);
            }

        }.start();
    }

    private void addValue(Label lbl, int value) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lbl.setText(String.valueOf(Integer.parseInt(lbl.getText()) + value));
            }
        });
    }

    private void cleanValue(Label lbl) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(Integer.parseInt(lbl.getText()) < 0)
                    lbl.setText("0");
            }
        });
    }
}