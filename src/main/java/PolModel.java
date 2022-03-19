public class PolModel {
    private Polynomial p = new Polynomial();//we build the null polynomial, "p"
    private Polynomial q = new Polynomial();//we build the null polynomial, "q"

    private void extract(String s, String which) {
        if (which.equals("p")) {
            p = new Polynomial();
            p.extract(s);
            p.sort();
            p.minimize();
        } else {
            q = new Polynomial();
            q.extract(s);
            q.sort();
            q.minimize();
        }
    }

    public String getResult(Polynomial result, String integrate) { //builds the result after a used variable
        if (!p.getVariable().equals("-"))
            return result.convert(p.getVariable(), integrate);
        else
            return result.convert(q.getVariable(), integrate);
    }

    public String addition(String a, String b) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        extract(b, "q");//this function builds the polynomial from the String "b"
        q.viewMonomialList();
        Polynomial result = Polynomial.add(p, q);
        result.viewMonomialList();
        String output = getResult(result, "no");
        if (output.equals(""))
            return "0";
        return output;
    }

    public String subtraction(String a, String b) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        extract(b, "q");//this function builds the polynomial from the String "b"
        q.viewMonomialList();
        Polynomial result = Polynomial.subtract(p, q);
        result.viewMonomialList();
        String output = getResult(result, "no");//this function turns the Polynomial 'result' into a string "output", which is returned in the end
        if (output.equals(""))
            return "0";
        return output;
    }

    public String multiplication(String a, String b) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        extract(b, "q");//this function builds the polynomial from the String "b"
        q.viewMonomialList();
        Polynomial result = Polynomial.multiply(p, q);
        result.viewMonomialList();
        String output = getResult(result, "no");//this function turns the Polynomial 'result' into a string "output", which is returned in the end
        if (output.equals(""))
            return "0";
        return output;
    }

    public String[] division(String a, String b) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        extract(b, "q");//this function builds the polynomial from the String "b"
        q.viewMonomialList();
        Polynomial[] result = Polynomial.divide(p, q);
        result[1].viewMonomialList();
        String quotient;
        if (!p.getVariable().equals("-"))
            quotient = result[0].convert(p.getVariable(), "no");
        else
            quotient = result[0].convert(q.getVariable(), "no");
        String remainder;
        if (!p.getVariable().equals("-"))
            remainder = result[1].convert(p.getVariable(), "no");
        else
            remainder = result[1].convert(q.getVariable(), "no");
        if (quotient.equals(""))
            quotient = "0";
        if (remainder.equals(""))
            remainder = "0";
        return new String[]{quotient, remainder};
    }

    public String derivative(String a) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        Polynomial result = Polynomial.derivative(p);
        result.viewMonomialList();
        String output = getResult(result, "no");//this function turns the Polynomial 'result' into a string "output", which is returned in the end
        if (output.equals(""))
            return "0";
        return output;
    }

    public String integral(String a) {
        extract(a, "p");//this function builds the polynomial from the String "a"
        p.viewMonomialList();
        Polynomial result = Polynomial.integrate(p);
        result.viewMonomialList();
        String output = getResult(result, "yes");//this function turns the Polynomial 'result' into a string "output", which is returned in the end
        if (output.equals(""))
            return "C";
        return output + "+C";
    }
}
