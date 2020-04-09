public class Fraction implements IFraction {
    private long numerator;
    private long denominator;

    public Fraction(long numerator, long denominator) {
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            if (denominator == 0) {
                System.out.println("Знаменатель равен нулю");
                throw new ArithmeticException();
            }
            this.denominator = denominator;
        }
    }

    @Override
    public Fraction plus(Fraction fraction) {
        Fraction res = new Fraction(numerator * fraction.denominator + fraction.numerator * denominator, fraction.denominator * denominator);
        return reduction(res);
    }

    @Override
    public Fraction minus(Fraction fraction) {
        Fraction res = new Fraction(numerator * fraction.denominator - fraction.numerator * denominator, fraction.denominator * denominator);
        return reduction(res);
    }

    @Override
    public Fraction multiply(Fraction fraction) {
        Fraction res = new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
        if (res.numerator == 0) {
            res.denominator = 1;
        }
        return reduction(res);
    }

    @Override
    public Fraction divide(Fraction fraction) {
        if (fraction.numerator == 0) {
            System.out.println("Деление дроби на 0");
            throw new ArithmeticException();
        } else {
            Fraction res = new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
            return reduction(res);
        }
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    private Fraction reduction(Fraction fraction) {
        long a = Math.abs(fraction.numerator);
        long b = Math.abs(fraction.denominator);
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return new Fraction(fraction.numerator / a, fraction.denominator / a);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}