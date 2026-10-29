import java.util.Hashtable;

public class Problema3 {
    public static void main(String args[]) {
        HSet set = new HSet();
        set.add("Laborator");
        set.add("Agregare");
        set.add("Mostenire");
        System.out.println(set);
        System.out.println(set.size());
        set.add("Laborator");
        if(set.size() == 4) {
            System.out.println("Multimea nu trebuie sa contina duplicate!");
        }
        System.out.println(set.remove("POO"));
        System.out.println(set.remove("Laborator"));
        if(set.size() != 2) {
            System.out.println("Stergerea nu functioneaza!");
        }
        set.add("Supradefinire");
        set.add("Supraincarcare");
        System.out.println(set);
    }
}

class HSet extends Hashtable<Object, Object>{
    public boolean add(Object value){
        if(containsKey(value)){
            return false;
        }
        put(value, value);
        return true;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer("{");
        boolean first = true;
        for(Object key : keySet()){
            if(!first){
                buff.append(", ");
            }
            buff.append(key);
            first = false;
        }
        buff.append("}");
        return buff.toString();
    }
}