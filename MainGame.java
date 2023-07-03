// Проанализировать и описать персонажей:
// Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.

import java.util.Random;

public class MainGame {

    public static void main(String[] args) {
        Archer archer = new Archer(new int[]{2, 1}, new Random().nextInt(21));
        Lancer lancer = new Lancer(new int[]{6, 1}, new Random().nextInt(21));
        Mage mage = new Mage(new int[]{3, 1}, new Random().nextInt(21), 1);
        Monk monk = new Monk(new int[]{4, 1}, new Random().nextInt(21), 1);
        Peasant peasant = new Peasant(new int[]{4, 1}, new Random().nextInt(21), 1);
        Rogue rogue = new Rogue(new int[]{7, 1}, new Random().nextInt(21));
        Sniper sniper = new Sniper(new int[]{1, 1}, new Random().nextInt(21));


        
    }
    
}
