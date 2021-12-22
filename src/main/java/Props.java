import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс считывающий типы полей, которые необходимо изменить
 */
public class Props {
    public String pathToProperties;

    /**
     * Метод присваивающий путь к файлу содержащему имена изменяемых полей
     * @param pathToProperties Путь к файлу
     */
    public Props(String pathToProperties) {
        this.pathToProperties = pathToProperties;
    }

    /**
     * Метод возвращающий переменную, сожержащую массив с изменяемыми полями
     * @return prop
     */
    public Properties getProp(){
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(pathToProperties)){
            prop.load(fileInputStream); //считываем замены
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
