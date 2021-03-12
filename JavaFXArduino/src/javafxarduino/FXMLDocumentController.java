/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxarduino;

import com.fazecast.jSerialComm.SerialPort;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author rhyan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox cbPortas;

    @FXML
    private Button btnConectar;

    private SerialPort porta;
    private int LED_1 = 0;
    private int LED_2 = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarPortas();
    }

    private void carregarPortas() {
        SerialPort[] portNames = SerialPort.getCommPorts();

        for (SerialPort portName : portNames) {

            cbPortas.getItems().add(portName.getSystemPortName());

        }

    }

    @FXML
    private void conectar() {
        //System.out.println("teste");
        if (btnConectar.getText().equals("Conectar")) {
            porta = SerialPort.getCommPort(cbPortas.getSelectionModel().getSelectedItem().toString());

            if (porta.openPort()) {
                btnConectar.setText("Desconectar");
                cbPortas.setDisable(true);
            }

        } else {
            porta.closePort();
            cbPortas.setDisable(false);
            btnConectar.setText("Conectar");
        }

    }

    @FXML
    private void ligarLed1() {
        PrintWriter outputLED1 = new PrintWriter(porta.getOutputStream());

        if (LED_1 == 0) {
            outputLED1.print("1");
            outputLED1.flush();
            LED_1 = 1;
        } else {
            outputLED1.print("0");
            outputLED1.flush();
            LED_1 = 0;
        }

    }

    @FXML
    private void ligarLed2() {
        PrintWriter outputLED2 = new PrintWriter(porta.getOutputStream());

        if (LED_2 == 0) {
            outputLED2.print("1");
            outputLED2.flush();
            LED_2 = 1;
        } else {
            outputLED2.print("0");
            outputLED2.flush();
            LED_2 = 0;
        }
    }

}
