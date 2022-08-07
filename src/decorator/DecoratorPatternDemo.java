package decorator;

public class DecoratorPatternDemo {

    public static void main(String[] args) {

        System.out.println(" -------: Plain shape :--------");
        Circle circle = new Circle();
        circle.draw();

        System.out.println(" -------: Colored circle :--------");
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();

        System.out.println(" -------: Colored rectangle :--------");
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
    }
}
