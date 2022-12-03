package org.example.Lesson4.dz;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle {
    private Double a;
    private Double b;
    private Double c;

    public void setA(Double a) {
        this.a = a;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    public Triangle(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String squareTri() {
            double p = (a + b + c) / 2;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            String result = String.format("%.2f", square);
            return result;
        }

}

