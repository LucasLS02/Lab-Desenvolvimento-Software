package Implementação;

public class app {

    public static void main(String args[]){
        usuario user = new usuario();
        user.create("Lucas", "lucasLs02", "123123");
        user.create("joao", "js02", "123123");
        user.create("Julia", "julia", "123123");

        System.out.println(user.list());
        System.out.println("--------------------------");

        user.edit("js02", "pedro,pd,123");

        System.out.println(user.list());
        System.out.println("--------------------------");
//
        user.remove("lucasLs02");

        System.out.println(user.list());
        System.out.println("--------------------------");

    }
}