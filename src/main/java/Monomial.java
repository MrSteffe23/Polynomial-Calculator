import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {
    private double coefficient;
    private int power;

    public Monomial() {
        coefficient = 0;
        power = 0;
    }

    public Monomial(double c, int p) {
        coefficient = c;
        power = p;
    }

    public void extract(String s) {
        String regex = "(([+-]?(\\d+)?)?(\\*?[a-zA-Z]\\^?)?(-?\\d+)?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher mt = pattern.matcher(s);
        while (mt.find()) {
            if (mt.group(1).trim().length() > 0) {
                System.out.println(mt.group(2) + "; " + mt.group(4) + "; " + mt.group(5) + "--- ");
                if (mt.group(2).trim().length() > 0) { //when we have a coefficient
                    String pol = mt.group(2);
                    if (pol.equals("-"))
                        coefficient = -1;
                    else if (pol.equals("+"))
                        coefficient = 1;
                    else
                        coefficient = Double.parseDouble(pol);
                } else
                    coefficient = 1;
                if (mt.group(5) != null && mt.group(5).trim().length() > 0) {//when the power is > 1 or < 0
                    String pol = mt.group(5);
                    power = Integer.parseInt(pol);
                } else if (mt.group(4) != null && mt.group(4).trim().length() > 0)//when the power is equal to 1 ('x')
                    power = 1;
                else //the last Monomials, with the power of the variable equal to '0'
                    power = 0;
            }

        }
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setCoefficient(double n) {
        coefficient = n;
    }

    public String toString() {
        return "Monomials with coefficient: " + coefficient + "; power:" + power;
    }
}
