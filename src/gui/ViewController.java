package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Rug;

//class that control the scene
public class ViewController implements Initializable {

	// @FXML allows to be associated with the screen

	@FXML
	ComboBox<Rug> comboBoxRug;

	private ObservableList<Rug> obsList;
	
	@FXML
	public Rug onComboBoxRugAction() {
		Rug rug1 =comboBoxRug.getSelectionModel().getSelectedItem();
		return rug1;
				
	}

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
			 
			

			LabelDescription
					.setText(quantidade + " tapetes do tipo "+onComboBoxRugAction()+"\n"+ largura + " m de largura por " + altura + " m de altura.");
			labelPrecoFinal.setText(String.format("R$ %.2f", precoFinal));
		}

		catch (NumberFormatException erro) {
			Alerts.showAlert("ERRO",
					"Tente Novamente, você inseriu um tipo de dado inválido. Use ponto como separador de casa decimal",
					erro.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		List<Rug> list = new ArrayList<>();
		list.add(new Rug("3M Nobre"));
		list.add(new Rug("3M Practik"));
		list.add(new Rug("Kapazi Gold"));

		obsList = FXCollections.observableArrayList(list);
		comboBoxRug.setItems(obsList);

		Callback<ListView<Rug>, ListCell<Rug>> factory = lv -> new ListCell<Rug>() {
			@Override
			protected void updateItem(Rug item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};

		comboBoxRug.setCellFactory(factory);
		comboBoxRug.setButtonCell(factory.call(null));

		Constraints.setTextFieldInteger(txtQuanti);
		Constraints.setTextFieldDouble(txtPrecoMetro);
		Constraints.setTextFieldDouble(txtLargura);
		Constraints.setTextFieldDouble(txtPrecoMetro);
		Constraints.setTextFieldMaxLength(txtQuanti, 5);

	}

}
