package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

class CentroTest {

    @Test
    void testConstructor() {
        Map<String, Double> input = new HashMap<>();
        input.put("latitud", 50.0);
        input.put("longitud", 20.0);
        Centro centro = new Centro(input);
        assertEquals(input, centro.getCoordenadas());
    }

    @Test
    void testEquals() { Map<String, Double> input1 = new HashMap<>(); input1.put("latitud", 50.0); input1.put("longitud", 20.0);
        Map<String, Double> input2 = new HashMap<>();
        input2.put("latitud", 50.0);
        input2.put("longitud", 20.0);
        Centro centro1 = new Centro(input1);
        Centro centro2 = new Centro(input2);
        assertEquals(centro1,centro2);
    }

    @Test
    void testNotEquals() { Map<String, Double> input1 = new HashMap<>(); input1.put("latitud", 50.0); input1.put("longitud", 20.0);
        Map<String, Double> input2 = new HashMap<>();
        input2.put("latitud", 40.0);
        input2.put("longitud", 10.0);
        Centro centro1 = new Centro(input1);
        Centro centro2 = new Centro(input2);
        assertNotEquals(centro1,centro2);
    }

    @Test
    void testHashCode() {
        Map<String, Double> input1 = new HashMap<>();
        input1.put("latitud", 50.0);
        input1.put("longitud", 20.0);
        Map<String, Double> input2 = new HashMap<>();
        input2.put("latitud", 50.0); input2.put("longitud", 20.0);
        Centro centro1 = new Centro(input1);
        Centro centro2 = new Centro(input2);
        assertEquals(centro1.hashCode(), centro2.hashCode());
    }

    @Test
    void testToString() {
        Map<String, Double> input = new HashMap<>();
        input.put("latitud", 50.0);
        input.put("longitud", 20.0);
        Centro centro = new Centro(input);
        String expected = "Centro : {latitud=50.0, longitud=20.0}";
        assertEquals(expected, centro.toString());
    }
}
