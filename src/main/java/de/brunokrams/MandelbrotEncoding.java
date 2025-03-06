package de.brunokrams;

import org.apache.commons.numbers.complex.Complex;

import java.awt.*;

public class MandelbrotEncoding implements ColorEncoding {

    private final int nrOfIterations;

    public MandelbrotEncoding(int nrOfIterations) {
        this.nrOfIterations = nrOfIterations;
    }

    @Override
    public Color encode(Complex c) {
        Complex result = iterate(c);
        int red = (int) (255 * sigmoid(result.getReal()));
        int green = (int) (255 * sigmoid(result.getImaginary()));
        return new Color(red, green, 0);
    }

    private Complex iterate(Complex c) {
        Complex result = Complex.ZERO;
        for (int i = 0; i < nrOfIterations; i++) {
            result = (result.multiply(result)).add(c);
        }
        return result;
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }


}
