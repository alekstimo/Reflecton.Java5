public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        SomeBean sb = (new Injector()).inject(new SomeBean()); //применяем изменения
        sb.foo();
    }
}