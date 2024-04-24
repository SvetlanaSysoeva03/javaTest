import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList toys = Toy.addToys();
        ArrayList boys = Boy.addBoys();
        ArrayList result = Toy.choice(boys,toys);
        try {
            Toy.raffle(result,boys);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}