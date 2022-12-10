public class ECC {

    // Y² = x³ + ax + b
    // Bitcoin a = 0 and b = 7 (y² = x³ + 7)
    private double a;
    private double b;

    public ECC(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Point pointAddition(Point p, Point q) {
        double x1 = p.getX();
        double y1 = p.getY();

        double x2 = q.getX();
        double y2 = q.getY();

        double m = 0;

        // Sometimes we have to make point addition and
        // if P = Q then we need to do point doubling
        if (Double.compare(x1, x2) == 0 && Double.compare(y1, y2) == 0) {
            // Point doubling (P = Q)
            m = (3 * x1 * x2 + a) / (2 * y1);
        } else {
            // Point addition (P != Q)
            m = (y2 - y1) / (x2 - x1);

        }

        // We can calculate the point R (x, y)
        double x3 = m * m - x2 - x1;
        double y3 = m * (x1 - x3) - y1;

        return new Point(x3, y3);

    }

}
