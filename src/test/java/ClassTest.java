import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassTest {
    public static PolModel model = new PolModel();

    @BeforeAll
    public static void InitializeModel() {
        model = new PolModel();
    }

    @Test
    public void AddTest() {
        String suma = model.addition("x^2+2", "x^3");
        String testSuma = "x^3+x^2+2.0";
        assertEquals(suma, testSuma);
    }

    @Test
    public void SubtractTest() {
        String division = model.subtraction("x^2+2", "x^3");
        String testDivision = "-x^3+x^2+2.0";
        assertEquals(division, testDivision);
    }

    @Test
    public void MultiplyTest() {
        String result = model.multiplication("x^2+2", "x^3");
        String testResult = "x^5+2.0x^3";
        assertEquals(result, testResult);
    }

    @Test
    public void DivisionTest() {
        String[] result = model.division("x^5+2x-9", "x^3-3x^2-12");
        String testCat = "x^2+3.0x+9.0";
        String testRest = "x^2+3.0x+9.0";
        assertEquals(result[0], testCat); //testing the quotient
        assertEquals(result[1], testRest); //testing the remainder
    }

    @Test
    public void DerivativeTest() {
        String result = model.derivative("x^2+2");
        String testResult = "2.0x";
        assertEquals(result, testResult);
    }

    @Test
    public void IntegrateTest() {
        String result = model.integral("x^2+2");
        String testResult = "0.33x^3+2.0x+C";
        assertEquals(result, testResult);
    }
}
