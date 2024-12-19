import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Person serialized: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Person deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
