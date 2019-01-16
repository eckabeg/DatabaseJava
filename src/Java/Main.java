package Java;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;
import static javafx.scene.control.TableView.UNCONSTRAINED_RESIZE_POLICY;

public class Main extends Application {

    private BorderPane root;
    private Scene scene;

    private BorderPane bpRight, bpButtons;
    private VBox vButtons;
    private HBox hInPut;
    private ScrollPane scrollPane;

    private RadioButton rbUpdate, rbOutput, rbInput, rbDelete;
    private Button btnExecute, btnCancel;
    private ToggleGroup buttonGroup;

    private Label inputLbl, tableLbl;
    private TextField inputField;

    private ListView<String> tableNameList;

    private EventHandler eventBtnExecute;

    private ObservableList<String> tableNames = FXCollections.observableArrayList("Futter", "Gehege", "Tier", "Gattung", "Futterration", "Gehegebetreuung", "Tierpfleger");

    private TableView table;

    private ColumnNames columnNames;

    private String selectedTable;


    @Override
    public void start(Stage primaryStage) throws Exception {

        columnNames = new ColumnNames();

        root = new BorderPane();
        scene = new Scene(root, 500, 400);

        bpRight = new BorderPane();
        bpButtons = new BorderPane();

        vButtons = new VBox();

        hInPut = new HBox();

        scrollPane = new ScrollPane();

        rbUpdate = new RadioButton();
        rbDelete = new RadioButton();
        rbInput = new RadioButton();
        rbOutput = new RadioButton();

        btnCancel = new Button();
        btnExecute = new Button();

        buttonGroup = new ToggleGroup();

        inputLbl = new Label();

        inputField = new TextField();

        table = new TableView();

        tableNameList = new ListView<>();
        tableNameList.setItems(tableNames);
        tableNameList.setOrientation(Orientation.VERTICAL);
        tableNameList.setPrefHeight(100);
        tableNameList.setPrefWidth(20);

        tableNameList.getSelectionModel().selectFirst();

        inputLbl.setText("Please Enter a Value: ");

        rbUpdate.setText("Update");
        rbDelete.setText("Delete");
        rbInput.setText("Input");
        rbOutput.setText("Output");

        btnCancel.setText("Cancel");
        btnExecute.setText("OK");

        table.setEditable(false);
        table.setColumnResizePolicy(UNCONSTRAINED_RESIZE_POLICY);

        setSelectedTable();

        table = columnNames.setColumn(selectedTable);

        scrollPane.setContent(table);

        rbUpdate.setToggleGroup(buttonGroup);
        rbInput.setToggleGroup(buttonGroup);
        rbOutput.setToggleGroup(buttonGroup);
        rbDelete.setToggleGroup(buttonGroup);

        rbOutput.setSelected(true);

        root.setRight(bpRight);
        root.setCenter(scrollPane);
        root.setBottom(bpButtons);

        bpRight.setTop(tableNameList);
        bpRight.setCenter(vButtons);
        bpRight.setBottom(hInPut);

        vButtons.getChildren().add(rbOutput);
        vButtons.getChildren().add(rbInput);
        vButtons.getChildren().add(rbUpdate);
        vButtons.getChildren().add(rbDelete);

        bpButtons.setLeft(btnCancel);
        bpButtons.setRight(btnExecute);

        hInPut.getChildren().add(inputLbl);
        hInPut.getChildren().add(inputField);

        eventBtnExecute = event -> btnExecute_EventPerformed(event);

        btnExecute.setOnAction(eventBtnExecute);
        btnCancel.setOnAction(event -> System.exit(0));

        primaryStage.setTitle("Database Zoo in Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void btnExecute_EventPerformed(Event evt){

        String selectedOption = buttonGroup.getSelectedToggle().toString();

        setSelectedTable();

        table = columnNames.setColumn(selectedTable);

    }

    public void setSelectedTable(){

        selectedTable = tableNameList.getSelectionModel().getSelectedItem();

    }

    public String getSelectedTable(){

        return selectedTable;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
