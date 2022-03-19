import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private final LinkedList<Monomial> list;
    private String variable = "-";

    public Polynomial() {
        list = new LinkedList<>();
    }

    public Polynomial(LinkedList<Monomial> list) {
        this.list = list;
    }

    static class MonomialComparator implements Comparator<Monomial> { //class used for sorting a LinkedList of Monomials in descending order by the power

        @Override
        public int compare(Monomial o1, Monomial o2) {
            return -(o1.getPower() - o2.getPower());
        }
    }

    public void sort() {//a method which sorts a polynomial in descending order by the power
        Comparator<Monomial> MonomialComparator = new MonomialComparator();
        this.list.sort(MonomialComparator);
    }

    public void minimize() {
        int i = 0;
        int n = this.list.size();
        while (i < n) {
            int j = i + 1;
            int power = this.list.get(i).getPower();
            while (j < n) {
                if (this.list.get(j).getPower() == power) { //adds the coefficients of the Monomials with the same power
                    this.list.get(i).setCoefficient(this.list.get(j).getCoefficient() + this.list.get(i).getCoefficient());
                    this.list.remove(j);
                    n = this.list.size();
                } else
                    j++;
            }
            i++;
        }
    }

    public void extract(String s) { //this function extracts the Monomials from a polynomial
        String regex = "([+-]?(\\d+)?\\*?([a-zA-Z])?(\\^-?(\\d+)?)?|(\\^?\\d+)?)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher mt = pattern.matcher(s);
        while (mt.find()) {
            if (mt.group(1).trim().length() > 0) {
                System.out.println(mt.group(1));
                Monomial m = new Monomial();
                m.extract(mt.group(1));
                list.add(m);
            }
            if (mt.group(3) != null && mt.group(3).trim().length() > 0) {
                variable = mt.group(3);
                System.out.println(variable);
            }
        }
    }

    public void viewMonomialList() {
        for (Monomial Monomial : list) {
            System.out.println(Monomial);
        }
    }

    public static Polynomial add(Polynomial a, Polynomial b) {
        Polynomial rez = new Polynomial();
        int i = 0, j = 0;
        int n = a.list.size();
        int m = b.list.size();
        while (i < n && j < m)
            if (a.list.get(i).getPower() == b.list.get(j).getPower()) {
                rez.list.add(new Monomial(a.list.get(i).getCoefficient() + b.list.get(j).getCoefficient(), a.list.get(i).getPower()));
                i++;
                j++;
            } else if (a.list.get(i).getPower() > b.list.get(j).getPower()) {
                rez.list.add(new Monomial(a.list.get(i).getCoefficient(), a.list.get(i).getPower()));
                i++;
            } else {
                rez.list.add(new Monomial(b.list.get(j).getCoefficient(), b.list.get(j).getPower()));
                j++;
            }
        while (i < n) {
            rez.list.add(new Monomial(a.list.get(i).getCoefficient(), a.list.get(i).getPower()));
            i++;
        }
        while (j < m) {
            rez.list.add(new Monomial(b.list.get(j).getCoefficient(), b.list.get(j).getPower()));
            j++;
        }
        return rez;
    }

    public static Polynomial subtract(Polynomial a, Polynomial b) {
        Polynomial result = new Polynomial();
        int i = 0, j = 0;
        int n = a.list.size();
        int m = b.list.size();
        while (i < n && j < m)
            if (a.list.get(i).getPower() == b.list.get(j).getPower()) {
                result.list.add(new Monomial(a.list.get(i).getCoefficient() - b.list.get(j).getCoefficient(), a.list.get(i).getPower()));
                if (result.list.getLast().getCoefficient() == 0)
                    result.list.removeLast();
                i++;
                j++;
            } else if (a.list.get(i).getPower() > b.list.get(j).getPower()) {
                result.list.add(new Monomial(a.list.get(i).getCoefficient(), a.list.get(i).getPower()));
                i++;
            } else {
                result.list.add(new Monomial(-b.list.get(j).getCoefficient(), b.list.get(j).getPower()));
                j++;
            }
        while (i < n) {
            result.list.add(new Monomial(a.list.get(i).getCoefficient(), a.list.get(i).getPower()));
            i++;
        }
        while (j < m) {
            result.list.add(new Monomial(-b.list.get(j).getCoefficient(), b.list.get(j).getPower()));
            j++;
        }
        return result;
    }

    public static Polynomial multiply(Polynomial a, Polynomial b) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : a.list) {
            Polynomial temporary = new Polynomial();
            for (Monomial m2 : b.list) {
                temporary.list.add(new Monomial(m1.getCoefficient() * m2.getCoefficient(), m1.getPower() + m2.getPower()));
            }
            result = Polynomial.add(temporary, result);
            System.out.println("------------------");
            result.viewMonomialList();
        }
        return result;
    }

    public static Polynomial[] divide(Polynomial a, Polynomial b) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(a.list);
        if (b.list.size() > 0 && !(b.list.size() == 1 && b.list.getFirst().getCoefficient() == 0)) {//polynomial b is not null
            while (remainder.list.size() > 0 && remainder.list.getFirst().getPower() >= b.list.getFirst().getPower()) {
                Polynomial t = new Polynomial();
                t.list.add(new Monomial(remainder.list.getFirst().getCoefficient() / b.list.getFirst().getCoefficient(), remainder.list.getFirst().getPower() - b.list.getFirst().getPower()));
                quotient = add(quotient, t);
                remainder = subtract(remainder, multiply(t, b));
            }
        }
        //System.out.println("Remainder: "+rest.convert());
        return new Polynomial[]{quotient, remainder};
    }

    public static Polynomial derivative(Polynomial a) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : a.list) {
            if (m1.getPower() != 0)
                result.list.add(new Monomial(m1.getCoefficient() * m1.getPower(), m1.getPower() - 1));
        }
        return result;
    }

    public static Polynomial integrate(Polynomial a) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : a.list) {
            if (m1.getPower() != -1)
                result.list.add(new Monomial(Math.round(m1.getCoefficient() / (m1.getPower() + 1) * 100.0) / 100.0, m1.getPower() + 1));
            else
                result.list.add(new Monomial(m1.getCoefficient(), m1.getPower() + 1));
        }
        return result;
    }

    public String convert(String t, String integrate) {//this function turns a Polynomial into a string "result", which is returned in the end
        StringBuilder result = new StringBuilder();
        for (Monomial m : this.list) {
            if (m.getCoefficient() > 0) {
                if (!result.toString().equals(""))
                    result.append("+");
                if (!(m.getPower() != 0 && m.getCoefficient() == 1))
                    result.append(Math.round(m.getCoefficient() * 100.0) / 100.0);
            } else {
                if (m.getCoefficient() < 0) {
                    if (m.getPower() != 0 && m.getCoefficient() == -1)
                        result.append("-");
                    else
                        result.append(Math.round(m.getCoefficient() * 100.0) / 100.0);
                }
            }
            if (m.getCoefficient() != 0 && m.getPower() != 0) {
                if (m.getPower() == 1)
                    result.append(t);
                else
                    result.append(t).append("^").append(m.getPower());
            } else if (m.getPower() == 0 && integrate.equals("yes"))
                result.append("ln").append(t); //integration of x^-1 for example
        }
        return result.toString();
    }

    public String getVariable() {
        return variable;
    }
}
