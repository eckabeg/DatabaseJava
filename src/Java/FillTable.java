package Java;


import javafx.scene.control.TableView;

public class FillTable {

    private ConnectionToDb connection;

    private TableView table;

    public FillTable(){

        connection = new ConnectionToDb();
    }

    public TableView getAnimal(){

        String command = "Select * from tier";
        connection.setRset(command);

        try {
            while (connection.getRset().next()){


            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return getTable();
    }


    public TableView getTable(){
        return table;
    }
}
