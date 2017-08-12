package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MyController {

    @FXML
    private TextField SourceText;
    
    @FXML
    private TextField KeyText;
    
    @FXML
    private ToggleGroup EnDe;

    @FXML
    private RadioButton En;

    @FXML
    private RadioButton De;

    @FXML
    private Button CipherIt;
    
    @FXML
    private TextField CipheredText;
    
    @FXML
    void CipherTheText(ActionEvent event) {
    	CipheredText.setText(Main.CipherThisText(SourceText.getText(), KeyText.getText(),En.isSelected()));
    }

	void initialize() {
    	En.setSelected(true);
    }	
}
