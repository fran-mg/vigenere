package application;
	
import org.omg.CosNaming.IstringHelper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.lang.Character;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass()
                    .getResource("/application/Form.fxml"));
			
            primaryStage.setTitle("Vigenere Cipher");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
			
            } catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String CipherThisText(String strSource, String strKey, boolean isToEncipher) {
		String strCiphered = "";
		int intCountKey = 0;
		int intCountSource = 0; 
		// check through each character in the Source string
		while(intCountSource < strSource.length()) {
			char chSource = strSource.charAt(intCountSource);
			char chCipher;
			// only encipher letters
			if (! Character.isLetter(chSource)) {
				chCipher = chSource;
			} else {
				chCipher = chCipherWithVigenere(chSource,strKey.charAt(intCountKey),isToEncipher);
				// because we enciphered this, move to the next letter in the key
				intCountKey = intCountKey + 1;
				if (intCountKey >= strKey.length()) intCountKey = 0;
			}
			strCiphered = strCiphered + chCipher;			
			intCountSource = intCountSource + 1;
		}
		return strCiphered;
	}

	public static char chCipherWithVigenere(char chSource, char chKey, boolean isToEncipher) {
		// get the source character and turn it into a number A=1, B=2, etc
		int numSource = numberFromLetter(chSource);
		int numKey = numberFromLetter(chKey);
		int numCipher;

		if (isToEncipher) {
			// enciphering adds the key
			numCipher = numSource + numKey;
			// in Vegenere tables Key A means no translation so we minus 1
			numCipher = numCipher - 1;
		} else {
			// Deciphering subtracts the key
			numCipher = numSource - numKey;
			numCipher = numCipher + 1;
		}

		// ensure the table wraps around (always gives between 1 and 26)
		if (numCipher > 26) {
			numCipher = numCipher - 26;
		}
		if (numCipher < 1 ) {
			numCipher = numCipher + 26;
		}

		char chCipher = letterFromNumber(numCipher);
		if (Character.isLowerCase(chSource)) {
			chCipher = Character.toLowerCase(chCipher);
		}
		return chCipher;
	}

	private static int numberFromLetter(char letter) {
		int number = ((int) letter) - 64;
		if (number >= 33) {
			number = number - 32;
		}
		return number;
	}

	private static char letterFromNumber(int number ) {
		char letter = (char) (number + 64);
		return letter;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
