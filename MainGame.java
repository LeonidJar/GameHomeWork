// 1. Проверяем здоровье
// 2. Ищем ближайшего врага
// 3. Двигаемся в сторну врага
// 4. Не наступаем на живых персонажей
// 5. Если расстояние до врага одна клетка бём его!



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

    public static ArrayList<Unit> team1 = new ArrayList<>();
    public static ArrayList<Unit> team2 = new ArrayList<>();

    public static void main(String[] args) {
        int teamCount = 10;
        boolean sortedInitiative = false;


        for (int i = 0; i < teamCount; i++) {
            int value = new Random().nextInt(7);
            addRandomUnit(value, i, team1, 1);

            value = new Random().nextInt(7);
            addRandomUnit(value, i, team2, 10);
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

        View.view();

        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            String massege = "";

            int init1 = 0;
            int init2 = 0;
            Unit tmpTeam1 = team1.get(init1);
            Unit tmpTeam2 = team2.get(init2);

            for (int i = 0; i < teamCount * 2; i++) {
                if (teamDead(team1)) {
                    massege = "Team 2 win!";
                    break;
                }
                if (teamDead(team2)) {
                    massege = "Team 1 win!";
                    break;
                }
                
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

            View.view();

            if (massege.equals("Team 2 win!") || massege.equals("Team 1 win!")) {
                System.out.println(massege);
                break;
            }
        }
    }    
    

    private static void addRandomUnit(int num, int i, ArrayList<Unit> list, int teamPos) {
        switch (num) {
            case 0:
                list.add(new Archer(teamPos, i + 1, new Random().nextInt(21)));
                break;
            case 1:
                list.add(new Lancer(teamPos, i + 1, new Random().nextInt(21)));
                break;
            case 2:
                list.add(new Mage(teamPos, i + 1, new Random().nextInt(21), 1));
                break;
            case 3:
                list.add(new Monk(teamPos, i + 1, new Random().nextInt(21), 1));
                break;
            case 4:
                list.add(new Peasant(teamPos, i + 1, new Random().nextInt(21), 1));
                break;
            case 5: 
                list.add(new Rogue(teamPos, i + 1, new Random().nextInt(21)));
                break;
            case 6:
                list.add(new Sniper(teamPos, i + 1, new Random().nextInt(21)));
                break;
        }
    }

    public static boolean teamDead(ArrayList<Unit> list) {
        for (Unit unit: list) {
            if (!unit.state.equals("Dead")) {
                return false;
            }
        }

        return true;
    }
}