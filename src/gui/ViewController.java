package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//class that control the scene
public class ViewController implements Initializable{

	// @FXML allows to be associated with the screen

	@FXML
	private TextField txtQuanti;

	@FXML
	private TextField txtPrecoMetro;

	@FXML
	private TextField txtLargura;

	@FXML
	private TextField txtAltura;
	
	@FXML
	private Label labelPrecoFinal;
	
	@FXML
	private Label LabelDescription;

	@FXML
	private Button btArea;

	@FXML
	public void onBtAreaAction() {

		try {

			
			int quantidade = Integer.parseInt(txtQuanti.getText());
			double preco = Double.parseDouble(txtPrecoMetro.getText());
			double largura = Double.parseDouble(txtLargura.getText());
			double altura = Double.parseDouble(txtAltura.getText());
			double precoFinal = quantidade * preco * altura * largura;
			
			LabelDescription.setText(quantidade+" tapetes.\n"+altura+" m de altura e "+largura+" m de largura.");
			labelPrecoFinal.setText(String.format("R$ %.2f", precoFinal));
		}

		catch (NumberFormatException erro) {
			Alerts.showAlert("ERRO", "Tente Novamente, você inseriu um tipo de dado inválido. Use ponto como separador de casa decimal", erro.getMessage(),
					AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		Constraints.setTextFieldInteger(txtQuanti);
		Constraints.setTextFieldDouble(txtPrecoMetro);
		Constraints.setTextFieldDouble(txtLargura);
		Constraints.setTextFieldDouble(txtPrecoMetro);
		Constraints.setTextFieldMaxLength(txtQuanti, 5);
		
		
	}

}
