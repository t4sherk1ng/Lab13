import java.util.*;

public class Main {
    private static Chest[] chests;
    static {
        chests = new Chest[11];
        chests[0] = new Chest("Pax", 236, 200, 60, 6825.0);
        chests[1] = new Chest("Platsa", 180, 160, 42, 2895.0);
        chests[2] = new Chest("Fabrikor", 150, 57, 47, 1495.0);
        chests[3] = new Chest("Hemnes", 197, 90, 37, 2995.0);
        chests[4] = new Chest("Rakkestad", 176, 89, 55, 995.0);
        chests[5] = new Chest("Skurup", 176, 89, 55, 995.0);
        chests[6] = new Chest("Sundvik", 171, 80, 50, 1795.0);
        chests[7] = new Chest("Ivar", 179, 89, 30, 2310.0);
        chests[8] = new Chest("Billy", 202, 80, 28, 595.0);
        chests[9] = new Chest("Kallax", 147, 147, 39, 1495.0);
        chests[10] = new Chest("Aas", 123, 321, 222, 55555.0);
    }
    public static void main(String[] args){
        OnlineStore store = new ChestOnlineStore("Мир шкафов", ChestOnlineStore ::compareAlphabetically );
        for (Chest obj: chests){
            store.add(obj);
        }
        System.out.println(store.getHighPrice());

    }
    public static int compare(String str1, String str2){
        return str2.compareTo(str1);
    }
    static class ChestComparator implements Comparator<Chest>{
        @Override
        public int compare(Chest chest1, Chest chest2){
            if (chest1.getCost() != chest2.getCost()) {
                return Double.compare(chest1.getCost(), chest2.getCost());
            } else {
                return Integer.compare(chest2.getVolume(), chest1.getVolume());
            }
        }
    }
    public static int compare(Chest chest1, Chest chest2){
        return (int) (chest1.getCost() - chest2.getCost());
    }

}