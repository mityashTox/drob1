import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class FractionTest {
    private Fraction fraction;
    private Fraction fraction1;
    private Fraction fraction2;
    private Fraction fraction3;
    private Fraction fraction4;
    private Fraction fraction5;

    @BeforeEach
    public void setUp() throws Exception {
        fraction = new Fraction(1, 3);
        fraction1 = new Fraction(7, 5);
        fraction3 = new Fraction(4, 4);
        fraction4 = new Fraction(0, 7);
        fraction5 = new Fraction(5, 1);
    }

    @Test
    void plus() throws Exception {
        Fraction res = fraction.plus(fraction1);
        Fraction res2 = fraction.plus(fraction3);
        Fraction res3 = fraction.plus(fraction4);
        Fraction res4 = fraction.plus(fraction5);

        Assert.assertEquals(26, res.getNumerator());
        Assert.assertEquals(15, res.getDenominator());
        Assert.assertEquals(4, res2.getNumerator());
        Assert.assertEquals(3, res2.getDenominator());
        Assert.assertEquals(1, res3.getNumerator());
        Assert.assertEquals(3, res3.getDenominator());
        Assert.assertEquals(16, res4.getNumerator());
        Assert.assertEquals(3, res4.getDenominator());

        Assert.assertNotNull(res);
        Assert.assertNotNull(res2);
        Assert.assertNotNull(res3);
        Assert.assertNotNull(res4);
    }

    @Test
    void constructorWithArithmeticException() throws ArithmeticException {
        assertThrows(ArithmeticException.class, () -> {fraction2 = new Fraction(1, 0);});
    }

    @Test
    void minus() throws Exception {
        Fraction res = fraction.minus(fraction1);
        Fraction res2 = fraction.minus(fraction3);
        Fraction res3 = fraction.minus(fraction4);
        Fraction res4 = fraction.minus(fraction5);

        Assert.assertEquals(-16, res.getNumerator());
        Assert.assertEquals(15, res.getDenominator());
        Assert.assertEquals(-2, res2.getNumerator());
        Assert.assertEquals(3, res2.getDenominator());
        Assert.assertEquals(1, res3.getNumerator());
        Assert.assertEquals(3, res3.getDenominator());
        Assert.assertEquals(-14, res4.getNumerator());
        Assert.assertEquals(3, res4.getDenominator());
        Assert.assertNotNull(res);

        Assert.assertNotNull(res2);
        Assert.assertNotNull(res3);
        Assert.assertNotNull(res4);
    }

    @Test
    void multiply() throws Exception {
        Fraction res = fraction.multiply(fraction1);
        Fraction res2 = fraction.multiply(fraction3);
        Fraction res3 = fraction.multiply(fraction4);
        Fraction res4 = fraction.multiply(fraction5);

        Assert.assertEquals(7, res.getNumerator());
        Assert.assertEquals(15, res.getDenominator());
        Assert.assertEquals(1, res2.getNumerator());
        Assert.assertEquals(3, res2.getDenominator());
        Assert.assertEquals(0, res3.getNumerator());
        Assert.assertEquals(1, res3.getDenominator());
        Assert.assertEquals(5, res4.getNumerator());
        Assert.assertEquals(3, res4.getDenominator());

        Assert.assertNotNull(res);
        Assert.assertNotNull(res2);
        Assert.assertNotNull(res3);
        Assert.assertNotNull(res4);
    }

    @Test
    void divide() throws Exception {
        Fraction res = fraction.divide(fraction1);
        Fraction res2 = fraction.divide(fraction3);
        Fraction res4 = fraction.divide(fraction5);

        Assert.assertEquals(5, res.getNumerator());
        Assert.assertEquals(21, res.getDenominator());
        Assert.assertEquals(1, res2.getNumerator());
        Assert.assertEquals(3, res2.getDenominator());
        Assert.assertEquals(1, res4.getNumerator());
        Assert.assertEquals(15, res4.getDenominator());

        Assert.assertNotNull(res);
        Assert.assertNotNull(res2);
        Assert.assertNotNull(res4);
    }

    @Test
    void divideWithArithmeticException() throws ArithmeticException {
        assertThrows(ArithmeticException.class, () -> {Fraction res3 = fraction.divide(fraction4);
            Assert.assertEquals(0, res3.getNumerator());
            Assert.assertEquals(21, res3.getDenominator());});
    }


}