package org.example.model;

import java.util.Map;
import java.util.Objects;


public class Artista {

    private  String description;
    /**
     * Encapsulates all attributes and their corresponding values, i.e. features.
     */
    private  Map<String, Double> features;
    public Artista() {
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setFeatures(Map<String, Double> features) {
        this.features = features;
    }
    public Artista(String description, Map<String, Double> features) {
        this.description = description;
        this.features = features;
    }
    public Artista(Map<String, Double> features) {
        this("", features);
    }
    public String getDescription() {
        return description;
    }
    public Map<String, Double> getFeatures() {
        return features;
    }
    @Override
    public String toString() {
        String prefix = description == null || description
                .trim()
                .isEmpty() ? "Record" : description;
        return prefix + ": " + features;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Artista artistas = (Artista) o;
        return Objects.equals(getDescription(), artistas.getDescription()) && Objects.equals(getFeatures(), artistas.getFeatures());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getFeatures());
    }
}
