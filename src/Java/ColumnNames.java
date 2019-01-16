package Java;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ColumnNames {

    TableView table = new TableView();

    public TableView getFoodColumnNames() {

        TableColumn colId = new TableColumn("Futter ID");
        TableColumn colFoodName = new TableColumn("Futtername");
        TableColumn colDescription = new TableColumn("Beschreibung");

        getTable().getColumns().addAll(colId, colFoodName, colDescription);

        return getTable();
    }

    public TableView getZooKeeperColumns(){

        TableColumn colZooKeeperId = new TableColumn("Tierpfleger ID");
        TableColumn colZooKeeperAddress = new TableColumn("Anrede");
        TableColumn colZooKeeperName = new TableColumn("Name");
        TableColumn colZooKeeperPreName = new TableColumn("Vorname");
        TableColumn colZooKeeperStreet = new TableColumn("Straße");
        TableColumn colZooKeeperZip = new TableColumn("PLZ");
        TableColumn colZooKeeperPlace = new TableColumn("Ort");
        TableColumn colZooKeeperTel = new TableColumn("Telefon");
        TableColumn colZooKeeperEmail = new TableColumn("E-Mail");

        getTable().getColumns().addAll(colZooKeeperId, colZooKeeperAddress, colZooKeeperName, colZooKeeperPreName, colZooKeeperStreet, colZooKeeperZip, colZooKeeperPlace, colZooKeeperTel, colZooKeeperEmail);

        return getTable();
    }

    public TableView getSpeciesColumns(){

        TableColumn colSpeciesId = new TableColumn("Gattungs ID");
        TableColumn colSpeciesName = new TableColumn("Gattungsname");
        TableColumn colSpeciesDescription = new TableColumn("Beschreibung");

        getTable().getColumns().addAll(colSpeciesId, colSpeciesName, colSpeciesDescription);

        return getTable();
    }

    public TableView getAnimalColumns(){

        TableColumn colAnimalId = new TableColumn("Tier ID");
        TableColumn colAnimalName = new TableColumn("Tiername");
        TableColumn colSex = new TableColumn("Geschlecht");
        TableColumn colBirthDay = new TableColumn("Geburtsdatum");
        TableColumn colSpeciesId = new TableColumn("Gattungs ID");
        TableColumn colEnclosureId = new TableColumn("Gehege ID");

        getTable().getColumns().addAll(colAnimalId, colAnimalName, colSex, colBirthDay, colSpeciesId, colEnclosureId);

        return getTable();
    }

    public TableView getEnclosureColumns(){

        TableColumn colEnclosureId = new TableColumn("Gehege ID");
        TableColumn colEnclosureName = new TableColumn("Gehegename");

        getTable().getColumns().addAll(colEnclosureId, colEnclosureName);

        return getTable();
    }

    public TableView getRationColumns(){

        TableColumn colRationId = new TableColumn("Futterrations ID");
        TableColumn colRatonAnimalId = new TableColumn("Tier ID");
        TableColumn colRationFoodId = new TableColumn("Futter ID");
        TableColumn colRationAmount = new TableColumn("Menge");
        TableColumn colRationFoodTime = new TableColumn("Fütterungszeit");

        getTable().getColumns().addAll(colRationId, colRatonAnimalId, colRationFoodId, colRationAmount, colRationFoodTime);

        return getTable();
    }

    public TableView getCareColumns(){

        TableColumn colCareId = new TableColumn("Gehegebetreuungs ID");
        TableColumn colZooKeeperId = new TableColumn("Mitarbeiter ID");
        TableColumn colEnclosureId = new TableColumn("Gehege ID");

        getTable().getColumns().addAll(colCareId, colZooKeeperId, colEnclosureId);

        return getTable();
    }

    public TableView setColumn(String selectedTable){

        getTable().getItems().clear();
        getTable().getColumns().clear();

        if(selectedTable.equals("Futter")){
            getFoodColumnNames();
        } else if (selectedTable.equals("Tierpfleger")){
            getZooKeeperColumns();
        } else if (selectedTable.equals("Gattung")){
            getSpeciesColumns();
        } else if (selectedTable.equals("Tier")){
            getAnimalColumns();
        } else if (selectedTable.equals("Gehege")){
            getEnclosureColumns();
        } else if (selectedTable.equals("Futterration")){
            getRationColumns();
        } else if (selectedTable.equals("Gehegebetreuung")){
            getCareColumns();
        }

        return getTable();
    }

    public TableView getTable(){
        return table;
    }


}
