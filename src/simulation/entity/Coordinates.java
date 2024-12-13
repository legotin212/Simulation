package simulation.entity;

import java.util.Objects;

public class Coordinates {
    public final int column;
    public final  int row;

    public Coordinates(Integer row, Integer column) {
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(column, that.column) && Objects.equals(row, that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return "row" + row + " . " + "column"+ column;
    }
}
