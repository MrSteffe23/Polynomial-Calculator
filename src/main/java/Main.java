public class Main {
    public static void main(String[] args) {
        PolView view = new PolView();
        PolModel model = new PolModel();
        new PolController(model, view);
        view.setVisible(true);
    }
}
