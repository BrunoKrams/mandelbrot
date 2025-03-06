package de.brunokrams;

import org.apache.commons.numbers.complex.Complex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CanvasMapperTest {

    @Test
    public void throwsIllegalArgumentException_when_lowerleftCornerIsAboveUpperRightCorner() {
        // given
        Canvas canvas = new Canvas(100, 100);

        // when/then
        assertThatThrownBy(() -> new CanvasMapper(canvas, Complex.ofCartesian(-1, -1), Complex.ofCartesian(0, -2))).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void throwsIllegalArgumentException_when_lowerLeftCornerIsToTheRightOfUpperRightCorner() {
        // given
        Canvas canvas = new Canvas(100, 100);

        // when/then
        assertThatThrownBy(() -> new CanvasMapper(canvas, Complex.ofCartesian(-1, -1), Complex.ofCartesian(-2, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void map_mapsCornersToCorners() {
        // given
        int heigth = 100;
        int width = 200;
        Canvas canvas = new Canvas(heigth, width);
        CanvasMapper canvasMapper = new CanvasMapper(canvas, Complex.ofCartesian(-1, -1), Complex.ofCartesian(1, 1));

        // when / then
        assertThat(canvasMapper.map(new Pixel(0, 0))).isEqualTo(Complex.ofCartesian(-1, 1));
        assertThat(canvasMapper.map(new Pixel(heigth - 1, 0))).isEqualTo(Complex.ofCartesian(-1, -1));
        assertThat(canvasMapper.map(new Pixel(0, width - 1))).isEqualTo(Complex.ofCartesian(1, 1));
        assertThat(canvasMapper.map(new Pixel(heigth - 1, width - 1))).isEqualTo(Complex.ofCartesian(1, -1));
    }

}
