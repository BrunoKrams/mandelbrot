package de.brunokrams;

import org.apache.commons.numbers.complex.Complex;

public class CanvasMapper {

    private final double a21;
    private final double a12;

    private final double b1;
    private final double b2;

    public CanvasMapper(Canvas canvas, Complex lowerLeftCorner, Complex upperRightCorner) {
        if (lowerLeftCorner.getImaginary() > upperRightCorner.getImaginary()) {
            throw new IllegalArgumentException("Lower left corner must not be below upper right corner");
        }

        if (lowerLeftCorner.getReal() > upperRightCorner.getReal()) {
            throw new IllegalArgumentException("Lower left corner must not be to the right of upper right corner.");
        }

        this.b1 = lowerLeftCorner.getReal();
        this.b2 = upperRightCorner.getImaginary();

        double scaleH = canvas.getHeigth() - 1;
        double scaleW = canvas.getWidth() - 1;

        this.a21 = (lowerLeftCorner.getImaginary() - upperRightCorner.getImaginary()) / scaleH;
        this.a12 = (upperRightCorner.getReal() - lowerLeftCorner.getReal()) / scaleW;
    }

    public Complex map(Pixel pixel) {
        double real = a12 * pixel.getY() + b1;
        double imaginary = a21 * pixel.getX() + b2;
        return Complex.ofCartesian(real, imaginary);
    }

}
