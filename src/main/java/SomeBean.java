/**
 * Класс в котором необхоимо заменить типы полей
 */
class SomeBean{
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Метод вызывающий вывод на экран
     */
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
