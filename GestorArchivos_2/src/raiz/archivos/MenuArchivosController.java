
package raiz.archivos;

import java.awt.event.MouseEvent;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import raiz.GestorArchivos;
import raiz.crearArchivosCarpetas.CrearArchivosCarpetasFxmlController;
import raiz.main.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class MenuArchivosController implements Initializable {

    

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     */
    private String s="sdfgsd";
    private String titulo;
    private CrearArchivosCarpetasFxmlController controlador;
    private FXMLDocumentController controladorPrincipal;
    @FXML
    public TilePane tlPane;
    private BorderPane border;
    private FileReader fr;
    private  String textoo;
    private String alas;
    
    private String nombreRuta;
    private String a="";
    public String Ruta="FILES";
    @FXML
    private Button atras;
    
    
    public String getTitulo(){
        return titulo;
    }
    
    public static void borrarDirectorio (File directorio){
    File[] ficheros = directorio.listFiles();
    
    for (int x=0;x>=ficheros.length;x++){
        if (ficheros[x].isDirectory()) {
  borrarDirectorio(ficheros[x]);
}
ficheros[x].delete();
    }
    }
    
    public void setControladorPrincipal(FXMLDocumentController instance){
        this.controladorPrincipal=instance;
    }
    public static void borrar(String nombre){
        
        File archivo= new  File (nombre);
        //borrarDirectorio(archivo);
        if (archivo.delete())
        System.out.println("El fichero ha sido borrado satisfactoriamente");
    else
        System.out.println("El fichero no pudó ser borrado");
    }
    public void pasarElemento(String a, int b){
        
        
        ContextMenu menu2 =new ContextMenu();
        MenuItem Borrar = new MenuItem("Borrar");
        menu2.getItems().addAll(Borrar);
        
         
        Text texto = new Text();
        texto.setText(a);
        ImageView imageView = new ImageView();
        if (b==1){
            Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
            imageView.setImage(imagE);
                         
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 10, 10,10) );
        border.setAlignment(texto, Pos.CENTER);
        border.setCenter(imageView);
        border.setBottom(texto);
        
        this.tlPane.getChildren().addAll(border);
        
       ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
        
                    
                    borrarArchivo.setOnAction(event ->{
                     borrar(a);
                     tlPane.getChildren().removeAll(border);
                         
        });
        
        border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                  contextMenu.show(tlPane, e.getScreenX(), e.getScreenY());
                  e.consume();
                    });
        
        
                          border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                               titulo=texto.toString();
                               Node source = (Node) mouseEvent.getSource();
                               Stage stage = (Stage) source.getScene().getWindow();
                               stage.close(); 
                               GestorArchivos.titulo().setTitle(Ruta+"/"+a);
                               TextArea lal =new TextArea();
                               
                              lal.setText("sdfgs");
                              //FXMLDocumentController.limpiar();
                               



}
}
}
});
        
        
        
        }
        if (b==0){
            
            
            Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
            imageView.setImage(imagE);
                          
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 10, 10,10) );
        border.setAlignment(texto, Pos.CENTER);
        border.setCenter(imageView);
        border.setBottom(texto);
        
        this.tlPane.getChildren().addAll(border);
        
         Borrar.setOnAction(event ->{
                     borrar(a);
                     tlPane.getChildren().removeAll(border);
         });
        border.setOnContextMenuRequested((ContextMenuEvent e) -> {
            e.consume();
                  menu2.show(tlPane, e.getScreenX(), e.getScreenY());
                    });
        
        border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                                tlPane.getChildren().clear();
                                
                                segundaCarpeta(nombreRuta);
                
               }
}
}
}); 
        }   
        
        
        
    }
    
    public  void menu_crearARchivos(ActionEvent event, int b){
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("crearArchivosCarpetas/CrearArchivosCarpetasFxml.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CrearArchivosCarpetasFxmlController controlador = fxmlLoader.getController();
            //controlador.recogerNumero(b);
            controlador.numero=b;
            controlador.setMenuArchivosControllerInstance(this);
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            
            
            
            if (b==1) controlador.recogerTexto("Crear Archivo");
            if (b==0) controlador.recogerTexto("Crear Carpeta");
              
            stage.setTitle("");
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) {
        }
        
    }
            
    public void segundaCarpeta(String ala){
        
        
        String primRuta=Ruta+ala;
        Ruta=primRuta;
        FXMLDocumentController.devolverEscena().setTitle(Ruta);
        File carpeta = new File(primRuta);
        File[] files = carpeta.listFiles();
        //File carpeta = new File(a);
        //File[] files = carpeta.listFiles();
        //path = carpeta.getAbsolutePath();
        
        tlPane.getChildren().clear();
        for (int i = 0; i< files.length; i++){
            if (files[i].isDirectory()){
                Text texto = new Text();
                texto.setText(files[i].getName());
                nombreRuta="/"+files[i].getName();
                ImageView imageView = new ImageView();
                Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
                imageView.setImage(imagE);

                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                BorderPane border = new BorderPane();
                border.setPadding(new Insets(10, 10, 10,10) );
                border.setCenter(imageView);
                border.setAlignment(texto, Pos.CENTER);
                border.setBottom(texto);
                tlPane.getChildren().addAll(border); 
                
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
                    
                    borrarArchivo.setOnAction(event ->{
                     borrar(Ruta+nombreRuta);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                
                
                border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                                tlPane.getChildren().clear();
                                
                                segundaCarpeta(nombreRuta);
                
               }
}
}
}); 
                
            }
            else if (files[i].isFile()){
                Text texto = new Text();
                texto.setText(files[i].getName());
                ImageView imageView = new ImageView();
                Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
                imageView.setImage(imagE);
                nombreRuta="/"+files[i].getName(); 

                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                BorderPane border = new BorderPane();
                border.setPadding(new Insets(10, 10, 10,10) );
                border.setCenter(imageView);
                border.setAlignment(texto, Pos.CENTER);
                border.setBottom(texto);
                tlPane.getChildren().addAll(border);
                
                
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
                    
                    borrarArchivo.setOnAction(event ->{
                     borrar(Ruta+nombreRuta);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                
                
                 border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                               titulo=texto.toString();
                               Node source = (Node) mouseEvent.getSource();
                               Stage stage = (Stage) source.getScene().getWindow();
                               stage.close(); 
                               GestorArchivos.titulo().setTitle(Ruta+nombreRuta);
                               
                               File f = new File(Ruta+nombreRuta);
                               Scanner s;
                               String linea="";
                               try {
                                    s = new Scanner(f);
                                    //
                                    // Aquí la lectura del fichero
                                    //
                                    
                                    
                               while (s.hasNextLine()) {
                                    linea = s.nextLine()+"\n";
                                    // 
                                    // Aquí el tratamiento de la línea
                                    //
                                 }
                                    s.close();
                                 } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                 }
                               
                               controladorPrincipal.textArea.setText(linea);
                              
                               TextArea lal =new TextArea();
                               
                              lal.setText("sdfgs");
                              //FXMLDocumentController.limpiar();
                               



}
}
}
});
                
                
                
                
            }


       }
        
        
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       /* ContextMenu menu2 =new ContextMenu();
        MenuItem borrar = new MenuItem("Eliminar");
        menu2.getItems().addAll(borrar);
        */     
       File carpeta = new File("FILES");
        File[] files = carpeta.listFiles();
    
          for (int i = 0; i< files.length; i++){
             
              if (files[i].isDirectory()){
                  Text texto = new Text();
                  texto.setText(files[i].getName());
                  String ala =files[i].getName();
                  String alas="/"+files[i].getName();
                  ImageView imageView = new ImageView();
                  Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
                  imageView.setImage(imagE);
                          
                  imageView.setFitHeight(60);
                  imageView.setFitWidth(60);
                  BorderPane border = new BorderPane();
                  border.setPadding(new Insets(10, 10, 10,10) );
                  border.setCenter(imageView);
                  border.setAlignment(texto, Pos.CENTER);
                  border.setBottom(texto);
                  tlPane.getChildren().addAll(border);
                  
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
                    
                    borrarArchivo.setOnAction(event ->{
                     borrar(carpeta.getName()+"/"+ala);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                  
                    border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                                
                               /*File carpeta = new File("FILES/"+alas);
                               File[] files = carpeta.listFiles();
                               tlPane.getChildren().clear();
                               for (int i = 0; i< files.length; i++){
                                    if (files[i].isDirectory()){
                                        Text texto = new Text();
                                        texto.setText(files[i].getName());
                                        String ala=files[i].getName();
                                        ImageView imageView = new ImageView();
                                        Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
                                        imageView.setImage(imagE);

                                        imageView.setFitHeight(60);
                                        imageView.setFitWidth(60);
                                        BorderPane border = new BorderPane();
                                        border.setPadding(new Insets(10, 10, 10,10) );
                                        border.setCenter(imageView);
                                        border.setAlignment(texto, Pos.CENTER);
                                        border.setBottom(texto);
                                        tlPane.getChildren().addAll(border); 
                                        border.setOnMouseClicked(this);
                                    }
                                    else if (files[i].isFile()){
                                        Text texto = new Text();
                                        texto.setText(files[i].getName());
                                        ImageView imageView = new ImageView();
                                        Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
                                        imageView.setImage(imagE);
                                        String ala=files[i].getName(); 

                                        imageView.setFitHeight(60);
                                        imageView.setFitWidth(60);
                                        BorderPane border = new BorderPane();
                                        border.setPadding(new Insets(10, 10, 10,10) );
                                        border.setCenter(imageView);
                                        border.setAlignment(texto, Pos.CENTER);
                                        border.setBottom(texto);
                                        tlPane.getChildren().addAll(border);
                                    }
                                   
                                   
                               }*/
                                segundaCarpeta(alas);
                                 


}
}
}
                    
});
                  
                  
                                    
              }              
              
              else if (files[i].isFile()){
                  Text texto = new Text();
                  texto.setText(files[i].getName());
                  ImageView imageView = new ImageView();
                  Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
                  imageView.setImage(imagE);
                  String ala=files[i].getName(); 
                  
                  imageView.setFitHeight(60);
                  imageView.setFitWidth(60);
                  BorderPane border = new BorderPane();
                  border.setPadding(new Insets(10, 10, 10,10) );
                  border.setCenter(imageView);
                  border.setAlignment(texto, Pos.CENTER);
                  border.setBottom(texto);
                  tlPane.getChildren().addAll(border);
                  //border.seto
                  
                                
                  
                  
                  
                  border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                               titulo=texto.toString();
                               Node source = (Node) mouseEvent.getSource();
                               Stage stage = (Stage) source.getScene().getWindow();
                               stage.close(); 
                               GestorArchivos.titulo().setTitle(Ruta+"/"+ala);
                               File f = new File(Ruta+"/"+ala);
                               Scanner s;
                               String linea="";
                               try {
                                    s = new Scanner(f);
                                    //
                                    // Aquí la lectura del fichero
                                    //
                                    
                                    
                               while (s.hasNextLine()) {
                                    linea = s.nextLine()+"\n";
                                    // 
                                    // Aquí el tratamiento de la línea
                                    //
                                 }
                                    s.close();
                                 } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                 }
                               
                               controladorPrincipal.textArea.setText(linea);
                               TextArea lal =new TextArea();
                               
                              lal.setText("sdfgs");
                              //FXMLDocumentController.limpiar();
                               



}
}
}
});
                  
                  
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
                    
                    borrarArchivo.setOnAction(event ->{
                     borrar(carpeta.getName()+"/"+ala);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                  
                  
                  
              }
              
              
                
          }
              
        ContextMenu contextMenu = new ContextMenu();
        MenuItem crearArchivo = new MenuItem("crear archivo");
        MenuItem crearCarpeta = new MenuItem("crear carpeta");
        contextMenu.getItems().addAll(crearArchivo, crearCarpeta);
        
        
        
        
        crearArchivo.setOnAction(event ->{
            menu_crearARchivos(event, 1);
                        
            
        });
        
        crearCarpeta.setOnAction(event ->{
            menu_crearARchivos(event, 0);
            
                        
        });
    
        
        
        

         
        
       
       tlPane.setOnContextMenuRequested((ContextMenuEvent e) -> {
           contextMenu.show(tlPane, e.getScreenX(), e.getScreenY());
       });
       
      
       
  
   
}

    /*public void menu_crearARchivos() throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        FXMLLoader fxmlLoader = new FXMLLoader(GestorArchivos.class.getResource("crearArchivosCarpetas/CrearArchivosCarpetasFxml.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CrearArchivosCarpetasFxmlController controlador = fxmlLoader.getController();
            //controlador.recogerNumero(b);
            
            controlador.setMenuArchivosControllerInstance(this);
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            
            
            controlador.recogerTexto("Crear Archivo");
            
              
            stage.setTitle("");
            stage.setScene(new Scene(root));
            
            stage.show();
        } */

    @FXML
    private void retroceder(ActionEvent event) {
        if (Ruta.equals("FILES")){
            return;
        }
        tlPane.getChildren().clear();
       File f = new File(Ruta);
       
       File Parent = f.getParentFile();
       
       Ruta=Parent.getPath();
       System.out.println(Parent);
       FXMLDocumentController.devolverEscena().setTitle(Ruta);
       
       
       
               File[] files = Parent.listFiles();
    
          for (int i = 0; i< files.length; i++){
             
              if (files[i].isDirectory()){
                  Text texto = new Text();
                  texto.setText(files[i].getName());
                  String ala =files[i].getName();
                  String alas="/"+files[i].getName();
                  ImageView imageView = new ImageView();
                  Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
                  imageView.setImage(imagE);
                          
                  imageView.setFitHeight(60);
                  imageView.setFitWidth(60);
                  BorderPane border = new BorderPane();
                  border.setPadding(new Insets(10, 10, 10,10) );
                  border.setCenter(imageView);
                  border.setAlignment(texto, Pos.CENTER);
                  border.setBottom(texto);
                  tlPane.getChildren().addAll(border);
                  
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo1 = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo1);
                    
                    borrarArchivo1.setOnAction(evento ->{
                     borrar(ala);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                  
                    border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                                
                               /*File carpeta = new File("FILES/"+alas);
                               File[] files = carpeta.listFiles();
                               tlPane.getChildren().clear();
                               for (int i = 0; i< files.length; i++){
                                    if (files[i].isDirectory()){
                                        Text texto = new Text();
                                        texto.setText(files[i].getName());
                                        String ala=files[i].getName();
                                        ImageView imageView = new ImageView();
                                        Image imagE = new Image(GestorArchivos.class.getResource("imagenes/carpeta_icon.png").toString());
                                        imageView.setImage(imagE);

                                        imageView.setFitHeight(60);
                                        imageView.setFitWidth(60);
                                        BorderPane border = new BorderPane();
                                        border.setPadding(new Insets(10, 10, 10,10) );
                                        border.setCenter(imageView);
                                        border.setAlignment(texto, Pos.CENTER);
                                        border.setBottom(texto);
                                        tlPane.getChildren().addAll(border); 
                                        border.setOnMouseClicked(this);
                                    }
                                    else if (files[i].isFile()){
                                        Text texto = new Text();
                                        texto.setText(files[i].getName());
                                        ImageView imageView = new ImageView();
                                        Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
                                        imageView.setImage(imagE);
                                        String ala=files[i].getName(); 

                                        imageView.setFitHeight(60);
                                        imageView.setFitWidth(60);
                                        BorderPane border = new BorderPane();
                                        border.setPadding(new Insets(10, 10, 10,10) );
                                        border.setCenter(imageView);
                                        border.setAlignment(texto, Pos.CENTER);
                                        border.setBottom(texto);
                                        tlPane.getChildren().addAll(border);
                                    }
                                   
                                   
                               }*/
                                segundaCarpeta(alas);
                                 


}
}
}
                    
});
                  
                  
                                    
              }              
              
              else if (files[i].isFile()){
                  Text texto = new Text();
                  texto.setText(files[i].getName());
                  ImageView imageView = new ImageView();
                  Image imagE = new Image(GestorArchivos.class.getResource("imagenes/archivo_icon.png").toString());
                  imageView.setImage(imagE);
                  String ala=files[i].getName(); 
                  
                  imageView.setFitHeight(60);
                  imageView.setFitWidth(60);
                  BorderPane border = new BorderPane();
                  border.setPadding(new Insets(10, 10, 10,10) );
                  border.setCenter(imageView);
                  border.setAlignment(texto, Pos.CENTER);
                  border.setBottom(texto);
                  tlPane.getChildren().addAll(border);
                  //border.seto
                  
                                
                  
                  
                  
                  border.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                  @Override
                        public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                               titulo=texto.toString();
                               Node source = (Node) mouseEvent.getSource();
                               Stage stage = (Stage) source.getScene().getWindow();
                               stage.close(); 
                               GestorArchivos.titulo().setTitle(Ruta+"/"+ala);
                               
                               File f = new File(Ruta+"/"+ala);
                               Scanner s;
                               String linea="";
                               try {
                                    s = new Scanner(f);
                                    //
                                    // Aquí la lectura del fichero
                                    //
                                    
                                    
                               while (s.hasNextLine()) {
                                    linea = s.nextLine()+"\n";
                                    // 
                                    // Aquí el tratamiento de la línea
                                    //
                                 }
                                    s.close();
                                 } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                 }
                               
                               controladorPrincipal.textArea.setText(linea);
                               
                               
                               TextArea lal =new TextArea();
                               
                              lal.setText("sdfgs");
                              //FXMLDocumentController.limpiar();
                               



}
}
}
});
                  
                  
                  ContextMenu contextMenu = new ContextMenu();
                    MenuItem borrarArchivo = new MenuItem("borrar");
                    contextMenu.getItems().addAll(borrarArchivo);
                    
                    borrarArchivo.setOnAction(evento ->{
                     borrar(ala);
                     tlPane.getChildren().removeAll(border);
                         
        });
                    
                     border.setOnContextMenuRequested((ContextMenuEvent e) -> {
                    e.consume();
                    contextMenu.show(border, e.getScreenX(), e.getScreenY());
                    });
                  
                  
                  
              }
              
              
                
          }
       
       
       
       
       
     
     
    
    
    }


}
        
    
