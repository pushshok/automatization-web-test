package ru.geekbrains.dz;

import java.io.IOException;

public class TriangleSquare {

    private int a;
    private int b;
    private int c;

    public TriangleSquare(int a, int b, int c) throws TriangleSideException {
        if (a >= (b + c) || b >= (a + c) || c >= (a + b)) {
            throw new TriangleSideException("The one of side triangle can't be equal or larger than the other two!");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public Double getSquare () {
        double a = Double.parseDouble(String.valueOf(this.a));
        double b = Double.parseDouble(String.valueOf(this.b));
        double c = Double.parseDouble(String.valueOf(this.c));

        double semiperimeter = (a + b + c) / 2;
        double square = semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c);

        return Math.sqrt(square);
    }

    public static void main(String[] args) throws TriangleSideException, IOException {
        TriangleSquare triangleSquare = new TriangleSquare(3, 4, 5);
        System.out.println(triangleSquare.getSquare());
    }
}
