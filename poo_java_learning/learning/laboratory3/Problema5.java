import java.lang.Math;

class Punct{
    private int x;
    private int y;

    public Punct(){
        this.x = 0;
        this.y = 0;
    }

    int getX(){
        return this.x;
    }

    void setX(int x){
        this.x = x;
    }

    int getY(){
        return this.y;
    }

    void setY(int y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    double distance(int x, int y){
        return Math.sqrt(Math.pow(Math.abs(x - this.x), 2) + Math.pow(Math.abs(y - this.y), 2));
    }

    double distance(Punct p1){
        return Math.sqrt(Math.pow(Math.abs(p1.x - this.x), 2) + Math.pow(Math.abs(p1.y - this.y), 2));
    }
}

class TestD{
    static public void main(String[] args){
        Punct p1 = new Punct();
        Punct p2 = new Punct();

        p1.setX(1);
        p2.setX(-1);
        p1.setY(2);
        p2.setY(3);

        System.out.println(p1.distance(p2));
    }
}