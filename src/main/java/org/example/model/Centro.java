package org.example.model;
import java.util.Map;
import java.util.Objects;

public class Centro {

    private final Map<String, Double> coordenadas;

    public Centro(Map<String, Double> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Map<String, Double> getCoordenadas() {
        return coordenadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centro centro = (Centro) o;
        return coordenadas.equals(centro.coordenadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenadas);
    }

    @Override
    public String toString() {
        return "Centro : " + coordenadas;
    }
}
