package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//class that control the scene
public class ViewController {

	// @FXML allows to be associated with the screen

	@FXML
	private TextField txtQuanti;

	@FXML
	private TextField txtPrecoMetro;

	@FXML
	private TextField txtLargura;

	@FXML
	private Label labelArea;

	@FXML
	private TextField txtAltura;

	@FXML
	private Button btArea;

	@FXML
	public void onBtAreaAction() {

		try {

			Locale.setDefault(Locale.US);
			double quantidade = Double.parseDouble(txtQuanti.getText());
			double preco = Double.parseDouble(txtPrecoMetro.getText());
			double largura = Double.parseDouble(txtLargura.getText());
			double altura = Double.parseDouble(txtAltura.getText());
			double area = quantidade * preco * altura * largura;

			labelArea.setText(String.format("R$ %.2f", area));
		}

		catch (NumberFormatException erro) {
			Alerts.showAlert("ERRO", "Tente Novamente, você inseriu um tipo de dado invalálido", erro.getMessage(),
					AlertType.ERROR);
		}
	}

}
