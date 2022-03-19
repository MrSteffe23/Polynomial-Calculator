import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolController {
    private final PolView view;
    private final PolModel model;

    public PolController(PolModel pModel, PolView pView) {
        view = pView;
        model = pModel;

        view.addListener(new Add());
        view.subListener(new Subtract());
        view.mulListener(new Multiply());
        view.divListener(new Divide());
        view.derivativeListener(new Derivative());
        view.integrateListener(new Integrate());
    }

    public String extractFirstPolynomial() throws Exception {
        String polynomial1 = view.getFirstPol();
        if (polynomial1.equals(""))
            throw new Exception("Introduce the first polynomial");
        return polynomial1;
    }

    public String extractSecondPolynomial() throws Exception {
        String polynomial2 = view.getSecondPol();
        if (polynomial2.equals(""))
            throw new Exception("Introduce the second polynomial");
        return polynomial2;
    }

    class Add implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String polynomial2 = extractSecondPolynomial();
                String s = model.addition(polynomial1, polynomial2);
                view.setRemainderVisible(false);
                view.setResult(s);
                System.out.println("Addition: " + s);
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }

    class Subtract implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String polynomial2 = extractSecondPolynomial();
                String s = model.subtraction(polynomial1, polynomial2);
                view.setRemainderVisible(false);
                view.setResult(s);
                System.out.println("Division");
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }

    class Multiply implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String polynomial2 = extractSecondPolynomial();
                String s = model.multiplication(polynomial1, polynomial2);
                view.setRemainderVisible(false);
                view.setResult(s);
                System.out.println("Multiply");
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }

    class Divide implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String polynomial2 = extractSecondPolynomial();
                if (polynomial2.equals("0"))
                    throw new Exception("ERROR: Division by 0");
                String[] s = model.division(polynomial1, polynomial2);
                view.setRemainderVisible(true);
                view.setResult(s[0]);
                view.setResultRemainder(s[1]);
                System.out.println("Division");
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }

    class Derivative implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String s = model.derivative(polynomial1);
                view.setRemainderVisible(false);
                view.setResult(s);
                System.out.println("Derivative");
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }

    class Integrate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String polynomial1 = extractFirstPolynomial();
                String s = model.integral(polynomial1);
                view.setRemainderVisible(false);
                view.setResult(s);
                System.out.println("Integrate");
            } catch (Exception a) {
                view.showError(a.getMessage());
            }
        }
    }
}
