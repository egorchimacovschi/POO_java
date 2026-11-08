import java.util.*;

public class WarriorPack {
    private Vector<Warrior> warriors ;

    public WarriorPack () {
        warriors = new Vector<Warrior>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector<Warrior> getWarriors() {
        return warriors ;
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < warriors.size(); i++) {
            damage += warriors.get(i).getDamage();
        }
        return damage;
    }

    @Override
    public String toString(){
        String result = "";

        for (Warrior warrior : warriors){
            result += warrior.toString() + "\n";
        }

        return result;
    }
}
