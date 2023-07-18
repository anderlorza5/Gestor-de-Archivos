/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import raiz.archivos.MenuArchivosController;
import raiz.main.FXMLDocumentController;

/**
 *
 * @author ander
 */
public class GestorArchivos extends Application {
    
    private static Stage stager;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main/FXMLDocument.fxml"));
        
        
        FXMLLoader fxmlLoad = new FXMLLoader(GestorArchivos.class.getResource("main/FXMLDocument.fxml"));
        fxmlLoad.load();
        FXMLDocumentController contmain= fxmlLoad.getController();
        
        FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("archivos/menuArchivos.fxml"));
        fxmlLoader.load();
        MenuArchivosController controlador = fxmlLoader.getController();
        
        contmain.setController(controlador);
        
        
        Scene scene = new Scene(root);
        stager=stage;
        stage.setTitle(FXMLDocumentController.getTitulo());
        stage.setScene(scene);
        stage.show();
    }
    
    public static Stage titulo(){
        return stager;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
