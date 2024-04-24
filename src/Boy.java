import java.util.ArrayList;
import java.util.Scanner;

public class Boy {
    private String id;// айди не мальчика, а игрушки, которую он хочет
    private String name;

    public Boy( String id, String name){
        this.id  = id;
        this.name = name;

    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public static ArrayList<Boy> addBoys(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Boy> list= new ArrayList<>();
        System.out.println("Введите id игрушки, которую хочет мальчик или /, если хотите прекратить ввод игрушек");
        String id =scanner.next();
        while (!id.equals("/")){
            System.out.println("Введите имя мальчика");
            String name =scanner.next();
            Boy boy = new Boy(id,name);
            list.add(boy);
            System.out.println("Введите id игрушки, которую хочет мальчик");
            id =scanner.next();
        }
        return list;
    }
}
