
public class TestWarrior {
    public static void main(String[] args) {
        WarriorPack pack = new WarriorPack();

        pack.addWarrior(new Snake(100, "Kaa"));
        pack.addWarrior(new Ogre(80, "Shrek"));
        pack.addWarrior(new MarshmallowMan(60, "Stay Puft"));
        pack.addWarrior(new Snake(50, "Nagini"));

        for (Warrior warrior : pack.getWarriors()) {
            System.out.println(warrior);
        }

        System.out.println();
        System.out.println(pack);
        System.out.println();
        System.out.println("Total damage: " + pack.calculateDamage());
    }
}
