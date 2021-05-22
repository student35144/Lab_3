package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;

public class Controller
{
    public TextField txtPromien;
    public TextField txtWysokosc;
    public TextField txtGrubosc;
    public TextField txtWagaNormalna;
    public TextField txtWagaNierdzewna;
    public TextField txtCenaStalowa;
    public TextField txtCenaNierdzewna;

    DecimalFormat dec = new DecimalFormat("#0.00");

    public void onBtnClick(ActionEvent actionEvent)
    {
        txtWagaNormalna.setText("");
        txtWagaNierdzewna.setText("");
        txtCenaStalowa.setText("");
        txtCenaNierdzewna.setText("");

        if (IsValueNumber(txtPromien)&&IsValueNumber(txtWysokosc)&&IsValueNumber(txtGrubosc))
        {
            double promien = Double.parseDouble(txtPromien.getText().replaceAll(",","."));
            double wysokosc = Double.parseDouble(txtWysokosc.getText().replaceAll(",","."));
            double grubosc = Double.parseDouble(txtGrubosc.getText().replaceAll(",","."));
            double objetosc = (2*3.14*promien*wysokosc*grubosc)/1000; //podzielić przez 1000, aby uzyskać dm3

            double wagaStalowa = objetosc*7.5;
            double wagaNierdzewna = objetosc*7.86;

            double cenaNierdzewna = wagaStalowa*6.1;
            double cenaStalowa = wagaNierdzewna*2.90;

            txtWagaNormalna.setText(String.valueOf(dec.format(wagaStalowa))+" kg");
            txtWagaNierdzewna.setText(String.valueOf(dec.format(wagaNierdzewna))+" kg");

            txtCenaNierdzewna.setText(String.valueOf(dec.format(cenaNierdzewna))+" PLN");
            txtCenaStalowa.setText(String.valueOf(dec.format(cenaStalowa))+" PLN");

            txtPromien.setText("");
            txtWysokosc.setText("");
            txtGrubosc.setText("");
        }

    }

    public boolean IsValueNumber(TextField value)
    {
        try {
            Double.parseDouble(value.getText().replaceAll(",","."));
        }
        catch (Exception exception) {
            StringWriter sw = new StringWriter();
            exception.printStackTrace(new PrintWriter(sw));

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Podane wartości muszą być liczbami!");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
            alert.showAndWait();
            return false;
        }
        return true;
    }
}