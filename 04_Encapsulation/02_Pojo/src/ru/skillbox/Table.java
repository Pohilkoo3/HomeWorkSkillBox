package ru.skillbox;

public class Table {


    private String name;
    private String colorTable;
    private String materialTable;
    private double weightTable;
    private double heightTable;

    public Table(String name,String colorTable, String materialTable) {
        this.name = name;
        this.materialTable = materialTable;
        this.colorTable = colorTable;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialTable() {
        return materialTable;
    }

    public void setMaterialTable(String materialTable) {
        this.materialTable = materialTable;
    }

    public String getColorTable() {
        return colorTable;
    }

    public void setColorTable(String colorTable) {
        this.colorTable = colorTable;
    }

    public double getWeightTable() {
        return weightTable;
    }

    public void setWeightTable(double weightTable) {
        this.weightTable = weightTable;
    }

    public double getHeightTable() {
        return heightTable;
    }

    public void setHeightTable(double heightTable) {
        this.heightTable = heightTable;
    }
    public String toString(){
        System.out.println("\n" + "Новый стол.");
        return name + "\n" + "Цвет: " + getColorTable() + "\n" + "Материал:" + getMaterialTable() + "\n" +"Высота: " +
                getHeightTable() + "\n" + "Вес: " + getWeightTable();
    }

}
