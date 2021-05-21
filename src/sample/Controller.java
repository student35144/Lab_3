package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{

    public Button btnMain;
    public TextField txtLicznik;
    int clickCounter = 0;

    public void onBtnAction(ActionEvent actionEvent)
    {
        //System.out.println("Kliknięcie nr: " + ++clickCounter);
        if (clickCounter == 1)
            btnMain.setText("I jeszcze raz!");

        txtLicznik.setText(Integer.toString(++clickCounter));
    }
}
