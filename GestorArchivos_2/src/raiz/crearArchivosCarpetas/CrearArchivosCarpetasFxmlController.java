
package raiz.crearArchivosCarpetas;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import raiz.GestorArchivos;
import raiz.archivos.MenuArchivosController;
import raiz.main.FXMLDocumentController;

import static sun.nio.cs.Surrogate.is;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class CrearArchivosCarpetasFxmlController implements Initializable {

    public int numero;
    @FXML
    public Text texto;
    @FXML
    private TextField caja_texto;
    @FXML
    private Button boton_crear;
    @FXML
    private Button boton_cancelar;
    private MenuArchivosController menuArchivosController;
    public String e;
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }  
    
    public void dameTexto(String c){
        this.e=c;
    }
    
    public void recogerNumero(int a){
        this.numero=a;
    }
    
     public void setMenuArchivosControllerInstance(MenuArchivosController instance){
        this.menuArchivosController=instance;
    }
    public void recogerTexto(String a){
        this.texto.setText(a);
    }

    @FXML
    private void solo_letras(KeyEvent event) {
        if (!event.getCharacter().matches("[a-zA-Z]+" )) {
            event.consume();
        } 
        
               
        
    }
    
   

    @FXML
    private void crear(ActionEvent event) throws IOException {
        
        String texto= this.caja_texto.getText();
        System.out.println(e);
        
        if (menuArchivosController!=null){
            if (this.numero==1){
            File ruta =new File(menuArchivosController.Ruta);
            File archivo =new File(ruta, texto+".txt");
            
            try {
                archivo.createNewFile();
                
                
            
                
                
                menuArchivosController.pasarElemento(texto+".txt", 1);
            }catch (Exception e) {
            }
            //esto es lo de coger el texto para guardar
            /*try
                {
                //String ele= asd(FXMLDocumentController.getTexto());
                        //FXMLDocumentController.getTextArea().getText().toString();
                String filename= "FILES/"+texto+".txt";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write(e);//appends the string to the file
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }
          
            */
        }
        
            
            if (this.numero==0){
            File ruta =new File(menuArchivosController.Ruta);
             File archivo =new File(ruta, texto);
            try {
                archivo.mkdir();
                menuArchivosController.pasarElemento(texto, 0);
            }catch (Exception e) {
        }
        } 
                   
            
        }
         
        
        else{
            File ruta = new File("FILES");
            File archivo =new File(ruta, texto+".txt");
            
            try {
                archivo.createNewFile();
                
                    
                //String nombreArchivo=GestorArchivos.titulo().getTitle();
            //File ruta =new File(nombreArchivo);
            //File archivo =new File(ruta, titulo);
            PrintWriter writer = new PrintWriter(archivo);
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter(archivo.getPath(),true); //the true will append the new data
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(e);//appends the string to the file
            bw.close();
                
                //menuArchivosController.pasarElemento(texto+".txt", 1);
            }catch (Exception e) {
            }
        }
        
        
        
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();     
    }

    @FXML
    private void cerrar_ventana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
  
    }

    @FXML
    private void activar_boton(KeyEvent event) {
         if (caja_texto.getLength()>0){
            boton_crear.setDisable(false);
        }
        
        if (caja_texto.getLength()==0){
            boton_crear.setDisable(true);
        }

    }
    
}
