public abstract class Warrior {
    //0 = dead, 100 = full strength
    protected int health;
    protected String name;

    public abstract int getDamage();

    public Warrior (int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "This is the  " + getClass().getSimpleName()
                + ": name: " + name + " " + ", health: " + health
                + ", damage:" + getDamage();
    }
}

class Snake extends Warrior{
    private int damage = 10;

    public Snake(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage(){
        return damage;
    }
}

class Ogre extends Warrior{
    private int damage = 6;

    public Ogre(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage(){
        return damage;
    }
}

class MarshmallowMan extends Warrior{
    private int damage = 1;

    public MarshmallowMan(int health, String name){
        super(health, name);
    }

    @Override
    public int getDamage(){
        return damage;
    }
}

