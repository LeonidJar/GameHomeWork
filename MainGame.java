// Добавить файл с описанием интерфейса.
// В котором описать два метода, void step(); и String getInfo();
// Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
// Создать два списка в классе main. В каждый из списков добавить по десять случайных экземнляров наследников BaseHero.
// Удалить ненужные методы из абстрактного класса, если такие есть. В main пройти по спискам и вызвать у всех персонажей getInfo.

import java.util.ArrayList;
import java.util.Random;

public class MainGame {

    public static void main(String[] args) {
        int teamCount = 10;

        ArrayList<Unit> team1 = new ArrayList<>();
        ArrayList<Unit> team2 = new ArrayList<>();

        for (int i = 0; i < teamCount; i++) {
            int value = new Random().nextInt(7);
            addRandomUnit(value, team1);

            value = new Random().nextInt(7);
            addRandomUnit(value, team2);
        }

        System.out.println("Team 1:");
        for (int i = 0; i < teamCount; i++) {
            System.out.println(team1.get(i).getInfo());
        }

        System.out.println();

        System.out.println("Team 2:");
        for (int i = 0; i < teamCount; i++) {
            System.out.println(team2.get(i).getInfo());
        }
        
    }    
    

    private static void addRandomUnit(int num, ArrayList<Unit> list) {
        switch (num) {
            case 0:
                list.add(new Archer(new int[]{2, 1}, new Random().nextInt(21)));
            case 1:
                list.add(new Lancer(new int[]{6, 1}, new Random().nextInt(21)));
            case 2:
                list.add(new Mage(new int[]{3, 1}, new Random().nextInt(21), 1));
            case 3:
                list.add(new Monk(new int[]{4, 1}, new Random().nextInt(21), 1));
            case 4:
                list.add(new Peasant(new int[]{4, 1}, new Random().nextInt(21), 1));
            case 5: 
                list.add(new Rogue(new int[]{7, 1}, new Random().nextInt(21)));
            case 6:
                list.add(new Sniper(new int[]{1, 1}, new Random().nextInt(21)));
        }
    }
}
