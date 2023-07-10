// 1.Если жизни 0 вернуть управление
// 2.Если стрел 0 вернуть управление
// 3.Найти ближайшего противника
// 4.Нанести ему среднее повреждение
// 5.Если среди своих есть крестьянин вернуть управление
// 6.Уменьшить кол-во стрел на одну и вернуть управление

// Вызывать персонажей из обеих комманд в порядке инициативы.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainGame {

    public static void main(String[] args) {
        int teamCount = 10;
        int init1 = 0;
        int init2 = 0;
        boolean sortedInitiative = false;

        ArrayList<Unit> team1 = new ArrayList<>();
        ArrayList<Unit> team2 = new ArrayList<>();

        for (int i = 0; i < teamCount; i++) {
            int value = new Random().nextInt(7);
            addRandomUnit(value, team1, 1);

            value = new Random().nextInt(7);
            addRandomUnit(value, team2, 10);
        }  

        while(!sortedInitiative) {
            sortedInitiative = true;
            for (int i = 0; i < team1.size() - 1; i++) {
                if (team1.get(i).initiative < team1.get(i + 1).initiative) {
                    Collections.swap(team1, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }

        sortedInitiative = false;

        while(!sortedInitiative) {
            sortedInitiative = true;
            for (int i = 0; i < team2.size() - 1; i++) {
                if (team2.get(i).initiative < team2.get(i + 1).initiative) {
                    Collections.swap(team2, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }

        System.out.println("Team 1:");
        team1.forEach(n -> System.out.println(n.getInfo() + " initiative: " + n.initiative));

        System.out.println();

        System.out.println("Team 2:");
        team2.forEach(n -> System.out.println(n.getInfo() + " initiative: " + n.initiative));

//Инициатива
        Unit tmpTeam1 = team1.get(init1);
        Unit tmpTeam2 = team2.get(init2);

        System.out.println();
        System.out.println("Round 1:");

        for (int i = 0; i < teamCount * 2; i++) {
            if ((tmpTeam1.initiative >= tmpTeam2.initiative && init1 < 10) || (tmpTeam1.initiative < tmpTeam2.initiative && init2 == 10)) {
                tmpTeam1.step(team2, team1);
                init1++;
                if (init1 < 10) tmpTeam1 = team1.get(init1);
            } else {
                tmpTeam2.step(team1, team2);
                init2++;
                if (init2 < 10) tmpTeam2 = team2.get(init2);
            }

        }
    }    
    

    private static void addRandomUnit(int num, ArrayList<Unit> list, int teamPos) {
        switch (num) {
            case 0:
                list.add(new Archer(teamPos, num + 1, new Random().nextInt(21)));
                break;
            case 1:
                list.add(new Lancer(teamPos, num + 1, new Random().nextInt(21)));
                break;
            case 2:
                list.add(new Mage(teamPos, num + 1, new Random().nextInt(21), 1));
                break;
            case 3:
                list.add(new Monk(teamPos, num + 1, new Random().nextInt(21), 1));
                break;
            case 4:
                list.add(new Peasant(teamPos, num + 1, new Random().nextInt(21), 1));
                break;
            case 5: 
                list.add(new Rogue(teamPos, num + 1, new Random().nextInt(21)));
                break;
            case 6:
                list.add(new Sniper(teamPos, num + 1, new Random().nextInt(21)));
                break;
        }
    }
}
