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
		String strRepeatedKey = "";
		while(strSource.length() > strRepeatedKey.length()) {
			strRepeatedKey = strRepeatedKey + strKey;
		}

		// check through each character in the Source string
		for(int intCharCounter = 0; intCharCounter < strSource.length(); intCharCounter = intCharCounter + 1) {
			char chCipher = chCipherWithVigenere( 
					strSource.charAt(intCharCounter), 
					strRepeatedKey.charAt(intCharCounter), 
					isToEncipher
					);
			strCiphered = strCiphered + chCipher;			
		}
		return strCiphered;
}

	public static char chCipherWithVigenere(char chSource, char chKey, boolean isToEncipher) {
		// get the source character and turn it into a number A=1, B=2, etc
		int numSource = numberFromLetter(chSource);
		// don't do anything with the character unless its a letter
		if (numSource < 1 || (numSource > 26 && numSource < 33) || numSource > 58) {
			return chSource;
		} else {				

			int numKey = numberFromLetter(chKey);
			int numCipher;

			if (isToEncipher) {
				// enciphering adds the key
				numCipher = numSource + numKey;
				if (numCipher > 26) {
					numCipher = numCipher - 26;
				}
			} else {
				// Deciphering subtracts the key
				numCipher = numSource - numKey;
				if (numCipher < 1 ) {
					numCipher = numCipher + 26;
				}
			}
			// in Vegenere tables Key A means no translation so we minus 1
			numCipher = numCipher - 1;

			char chCipher = letterFromNumber(numCipher);
			if (Character.isLowerCase(chSource)) {
				chCipher = Character.toLowerCase(chCipher);
			}
			return chCipher;
		}
	}


/*	private static int numberFromLetter(char letter) {
		if (numSource >= 65 || numSource <= 90 ) {
			int number = ((int) letter) - 64;	
		}
		else
			int number = ((int)letter) - 96;
		return number;
	}
*/
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
