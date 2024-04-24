import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Toy {
    private String id;
    private String name;
    public int count;
    private float chance;
    public Toy( String id, String name, int count, float chance){
        this.id  = id;
        this.name = name;
        this.count = count;
        this.chance =  chance;
    }
    public String getId(){
        return id;
    }

    public float getChance(){
        return chance;
    }
    public int getCount(){
        return count;
    }
    public String getName(){
        return name;
    }
    public static ArrayList<Toy> addToys(){ // в идеале для этого действия нужно сделать интерфейс и наследовть и мальчиками и игрушками)Но сил уже нет
        Scanner scanner = new Scanner(System.in);
        ArrayList<Toy> list= new ArrayList<>();
        System.out.println("Введите id игрушки или /, если хотите прекратить ввод игрушек");
        String id =scanner.next();
        while (!id.equals("/")){
            System.out.println("Введите имя игрушки");
            String name =scanner.next();
            System.out.println("Введите количество игрушек");
            int count = Integer.parseInt(scanner.next());
            System.out.println("Введите шанс выпадения игрушки");
            float chance =Float.parseFloat(scanner.next());
            Toy toy = new Toy(id,name,count,chance);
            list.add(toy);
            System.out.println("Введите id игрушки");
            id =scanner.next();
        }
        return list;
    }
    public static ArrayList<Toy> choice ( ArrayList<Boy> boys, ArrayList<Toy> toys){
        ArrayList<Toy> list= new ArrayList<>();
        for (Boy boy: boys) {
            for (Toy toy : toys) {
                if (toy.getId().equals(boy.getId()) && toy.getCount()>0) {
                    list.add(toy);
                    toy.count--;

                }
                else{
                    Random rand = new Random();
                    int random = rand.nextInt(boys.size());
                    Toy a = toys.get(random);
                    list.add(a);
                    a.count--;
                }

            }
        }
        Collections.sort(list, Toy.COMPARE_BY_CHANCE); // вот этой штукой прям горжусь, правда я еще не проверяла работает ли она))
        return list;

    }

    public static void raffle(ArrayList<Toy> list, ArrayList<Boy> boys) throws IOException {
        int count = 0;
        for (Boy boy: boys) {
            Toy a = list.get(count);
            String fileName = boy.getName() + ".txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(boy.getName() + " " + a.getName());
            System.out.println(boy.getName() + " " + a.getName());
            writer.close();
            count++;
            list.remove(a);

        }
    }

    public static final Comparator<Toy> COMPARE_BY_CHANCE = new Comparator<Toy>() {
        @Override
        public int compare(Toy one, Toy two) {
            return Math.round(one.getChance() - two.getChance()*1000); //умножаем на 100, чтобы не получался 0
        }
    };

}

