package ru.skillbox;

public class Table {
    private static String name = "Стол";
    private String colorTable;
    private String materialTable;

    public Table(String colorTable, String materialTable) {
        this.materialTable = materialTable;
        this.colorTable = colorTable;
    }

    private double weightTable;
    private double heightTable;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Table.name = name;
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
}
