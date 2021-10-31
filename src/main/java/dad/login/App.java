package dad.login;

import dad.login.loginController.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private LoginController loginController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loginController  = new LoginController();
		
		Scene loginScene = new Scene(loginController.getView(), 320, 200);
		
		Stage loginStage = new Stage();
		loginStage.setTitle("Login");
		loginStage.setScene(loginScene);
		loginStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
