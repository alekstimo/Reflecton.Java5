import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс отвечающий за изменение типов интерфес на класс
 */
public class Injector {
    public Properties prop;

    {
        prop = (new Props("src/main/resources/config.properties")).getProp(); //считываем изменяемые поля
    }

    /**
     * Функция меняющая поля интерфейса на поля класса реализующего его
     * @param object имя передаваемого класса
     * @param <T> тип передаваемого класса в котором происходят изменения
     * @return объект класса с измененными типами
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public <T> T inject(T object) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<? extends Object> cl = object.getClass();
        Field[] fl = cl.getDeclaredFields(); //считываем массив полей
        for (Field f : fl) { //идем по массиву
            Annotation a = f.getAnnotation(AutoInjectable.class); //считываем анотацию
            f.setAccessible(true); //даем права на изменение поля
            if (a != null) { //если анотация присутствует
                Object classObject = Class.forName(prop.getProperty(f.getType().getName())).newInstance(); //присваиваем поле, которое соответсвует интерфейсу и делаем его в виде object
                f.set(object, classObject); //меняем
            }
        }
        return object;
    }
}