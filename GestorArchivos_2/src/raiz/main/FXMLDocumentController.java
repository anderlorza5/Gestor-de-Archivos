/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raiz.main;

import com.sun.javaws.Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import raiz.info.FXMLinfoMenuController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;
import raiz.GestorArchivos;
import raiz.archivos.MenuArchivosController;
import raiz.crearArchivosCarpetas.CrearArchivosCarpetasFxmlController;
import static sun.font.FontManagerNativeLibrary.load;
import static sun.font.SunLayoutEngine.instance;

/**
 *
 * @author ander
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    
    public static Stage escena;
    @FXML
    private Menu menuInfo;
    @FXML
    private MenuItem abirArchivos;
    //private FXMLDocumentController controlador;
    private MenuArchivosController cont;
    @FXML
    private MenuItem menuGuardar;
    @FXML
    public  TextArea textArea;
    public static String textoPrueba;
    public static  String titulo="Nuevo archivo";
    @FXML
    private MenuItem botonBorrar;
    @FXML
    private MenuItem botonNuevoArchivo;
    
   
    
  /* public static void getTextArea(){
       textArea.setText(textoPrueba);
   }*/
    /*public static void limpiar(){
        textArea.clear();
    }*/
    public void setController(MenuArchivosController instance){
        this.cont=instance;
    }
    /*public static void darTexto(String g){
        FXMLDocumentController.textArea.setText(g);
    }*/
    /*public   static TextArea getTextArea(){
        return textArea;
    }*/
    /*public  String getTexto(){
        return texto;
    }*/
    public  static String getTitulo(){
        return titulo;
    }
    
    
   public static Stage devolverEscena(){
       return escena;
   }
    
    
    @FXML
    private void menuInfo_Action(ActionEvent event) {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("info/FXMLinfoMenu.fxml"));
            //P2P_FileSare.class.get.Resource("AboutMain/FXML_MenuItem_About.fxml")
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("About");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }       
        
    }    
    
    @FXML
    public void menuArchivos(ActionEvent event) {
        
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("archivos/menuArchivos.fxml"));
            //P2P_FileSare.class.get.Resource("AboutMain/FXML_MenuItem_About.fxml")
            
            Parent root = (Parent) fxmlLoader.load();
            MenuArchivosController controlador=fxmlLoader.getController();
            controlador.setControladorPrincipal(this);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("FILES");
            stage.setScene(new Scene(root));
            escena=stage;
            stage.show();
            
        } catch (Exception e) {
        }
    }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // darTexto(texto);
       
        
    }    

    @FXML
    public void guardar(ActionEvent event) throws IOException {
        
        String title= GestorArchivos.titulo().getTitle();
        if (title.equals("Nuevo archivo")){
            try {
            String texto=textArea.getText();
            //String texto="asdf";
            FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("crearArchivosCarpetas/CrearArchivosCarpetasFxml.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CrearArchivosCarpetasFxmlController controlador = fxmlLoader.getController();
            //controlador.recogerNumero(b);
            controlador.e=texto;
            controlador.numero=1;
            controlador.setMenuArchivosControllerInstance(cont);
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            
            
            controlador.recogerTexto("Crear Archivo");
            
              
            stage.setTitle("");
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) {
        }
        }else{
           /* String nuevoContenido= textArea.getText();
            String titulo= GestorArchivos.titulo().getTitle();
            File ruta =new File(titulo);
           
            FileWriter fw = new FileWriter(ruta.getPath(),true); //the true will append the new data
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nuevoContenido);//appends the string to the file
            bw.close();*/
           String nuevoContenido= textArea.getText();
            //this.Texto=areaTexto.getText();
            String nombreArchivo=GestorArchivos.titulo().getTitle();
            File ruta =new File(nombreArchivo);
            //File archivo =new File(ruta, titulo);
            PrintWriter writer = new PrintWriter(ruta);
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter(ruta.getPath(),true); //the true will append the new data
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nuevoContenido);//appends the string to the file
            bw.close();

        }
        
    }

    @FXML
    private void borrar(ActionEvent event) {
        textArea.clear();
        String nombreArchivo=GestorArchivos.titulo().getTitle();
        File ruta =new File(GestorArchivos.titulo().getTitle().toString());
        File archivo =new File(ruta, nombreArchivo);
        ruta.delete();
        GestorArchivos.titulo().setTitle(titulo);
    }

    @FXML
    private void nuevoArchivo(ActionEvent event) {
         textArea.clear();
         GestorArchivos.titulo().setTitle(titulo);
        
    }

    

   

    

   

    
    
}
