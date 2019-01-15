package Java;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    private BorderPane root;
    private Scene scene;

    private BorderPane bpRight, bpButtons;
    private VBox vButtons;
    private HBox hInPut;
    private ScrollPane scrollPane;

    private RadioButton bUpdate, bOutput, bInput, bDelete;

    private Button btnStart, btnCancel;

    private ToggleGroup buttonGroup;

    private Label inputLbl, tableLbl;

    private TextField inputField;

    private ListView<String> tableNameList;

    private ObservableList<String> tableNames = FXCollections.observableArrayList("Futter", "Gehege", "Tier", "Gattung", "Futterration", "Gehegebetreuung", "Tierpfleger");

    private TableView table;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();
        scene = new Scene(root, 550, 400);

        bpRight = new BorderPane();
        bpButtons = new BorderPane();

        vButtons = new VBox();

        hInPut = new HBox();

        scrollPane = new ScrollPane();

        bUpdate = new RadioButton();
        bDelete = new RadioButton();
        bInput = new RadioButton();
        bOutput = new RadioButton();

        btnCancel = new Button();
        btnStart = new Button();

        buttonGroup = new ToggleGroup();

        inputLbl = new Label();

        inputField = new TextField();

        table = new TableView();

        tableNameList = new ListView<String>();
        tableNameList.setItems(tableNames);
        tableNameList.setOrientation(Orientation.VERTICAL);
        tableNameList.setPrefHeight(70);
        tableNameList.setPrefWidth(20);

        tableNameList.getSelectionModel().selectFirst();

        inputLbl.setText("Please Enter a Value: ");

        bUpdate.setText("Update");
        bDelete.setText("Delete");
        bInput.setText("Input");
        bOutput.setText("Output");

        btnCancel.setText("Cancel");
        btnStart.setText("OK");

        table.setEditable(true);

        scrollPane.setContent(table);

        bUpdate.setToggleGroup(buttonGroup);
        bInput.setToggleGroup(buttonGroup);
        bOutput.setToggleGroup(buttonGroup);
        bDelete.setToggleGroup(buttonGroup);

        bOutput.setSelected(true);

        root.setRight(bpRight);
        root.setCenter(scrollPane);
        root.setBottom(bpButtons);

        bpRight.setTop(tableNameList);
        bpRight.setCenter(vButtons);
        bpRight.setBottom(hInPut);

        vButtons.getChildren().add(bOutput);
        vButtons.getChildren().add(bInput);
        vButtons.getChildren().add(bUpdate);
        vButtons.getChildren().add(bDelete);

        bpButtons.setLeft(btnCancel);
        bpButtons.setRight(btnStart);

        hInPut.getChildren().add(inputLbl);
        hInPut.getChildren().add(inputField);

        primaryStage.setTitle("Database Zoo in Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
