
package pt_semestralka;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Hlavni trida vola tridy Tree-vytvori strom, DrawTree-vykresleni stromu
 * @author Martina
 */
public class PT_Semestralka extends Application {
   
  
 public static Tree tree = new Tree();
 public static DrawTree drawTree;
 String text;
    @Override
    
    public void start(Stage primaryStage) {
      primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);    
        GridPane grid = new GridPane();
	grid.setHgap(2);
	grid.setVgap(5);
	TextField insertTF= new TextField();
	Button insertBT = new Button("Insert");
	grid.add(insertTF, 0, 0);
	grid.add(insertBT, 1, 0);
        TextField deleteTF= new TextField();
	Button deleteBT = new Button("Delete");
	grid.add(deleteTF, 0, 1);
	grid.add(deleteBT, 1, 1);
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(3);
        textArea.setPrefColumnCount(150);
        textArea.setWrapText(true);
        textArea.setPrefWidth(150);
        borderPane.setBottom(textArea);
	borderPane.setTop(grid);

         insertBT.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if(insertTF!=null){
                          //  System.out.println(insertTF.getText());
                            tree.insert(Integer.parseInt(insertTF.getText()));
                            drawTree = new DrawTree(gc, tree);
                            text = "Preorder: "+ tree.printPreOrder();
                            text = text + "\nInorder: " + tree.printInOrder();
                            text = text + "\nPostorder: " + tree.printPostOrder();
                            textArea.setText(text);
                        }
                }
       });
         deleteBT.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if(deleteBT!=null){
                           // System.out.println(insertTF.getText());
                            tree.delete(Integer.parseInt(deleteTF.getText()));
                            drawTree = new DrawTree(gc, tree);
                            text = "Preorder: " + tree.printPreOrder();
                            text = text + "\nInorder: " + tree.printInOrder();
                            text = text + "\nPostorder: " + tree.printPostOrder();
                            textArea.setText(text);
                        }
                }
       });
         
        textArea.setText(text);
        root.getChildren().add(borderPane);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }
    
    
}
