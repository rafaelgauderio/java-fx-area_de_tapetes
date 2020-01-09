package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

//class that control the scene
public class ViewController {
	
	
	@FXML
	private Button btTest;
	
	@FXML
	public void onBtTestAction() {
		
		Alerts.showAlert("Alert title: WARNING", null,"Use a secure password: with letters, numbers,"
				+ " alpha numerals, and at least one uppercase character!", AlertType.WARNING);
		System.out.println("You have click on the button!");
		
		
	}

}
