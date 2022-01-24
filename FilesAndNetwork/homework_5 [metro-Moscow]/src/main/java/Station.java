public class Station {
 private Line line;
    private String name;

    public Station(Line line, String name) {
        this.line = line;
        this.name = name;
        line.addStationToLine(this);
    }

    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "\n";
    }
}
