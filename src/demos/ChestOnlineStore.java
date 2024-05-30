import java.util.*;

public class ChestOnlineStore implements OnlineStore{
    private String label;
    private Set<Chest> narrow;
    private Set<Chest> standart;
    private Set<Chest> high_price;
    private Set<Chest> middle_price;
    private Set<Chest> low_price;
    private Comparator<Chest> comparator = null;
    public ChestOnlineStore(String label, Comparator<Chest> comparator) {
        this.label = label;
        if (comparator != null){
            this.comparator = comparator;
            this.narrow = new TreeSet<Chest>(comparator);
            this.standart = new TreeSet<Chest>(comparator);
            this.high_price = new TreeSet<Chest>(comparator);
            this.middle_price = new TreeSet<Chest>(comparator);
            this.low_price = new TreeSet<Chest>(comparator);
        }
    }
    public static int compareAlphabetically(Chest chest1, Chest chest2){
        return chest1.getLabel().compareTo(chest2.getLabel());
    }
    public static int compareCost(Chest chest1, Chest chest2){
        return (int) (chest1.getCost() - chest2.getCost());
    }
    public static int compareComplex(Chest chest1, Chest chest2){
        int result =
                chest1.getWeight() * chest1.getDepth() * chest1.getHeight() -
                    chest2.getHeight() * chest2.getWeight() * chest2.getDepth();
        if (result == 0){
            return (int) (chest1.getCost() - chest2.getCost());
        }
        return result;
    }
    @Override
    public void add(Chest chest) {
        if (chest != null){
            if (chest != null){
                if (chest.getDepth() < OnlineStore.DEPTH_LIMIT) narrow.add(chest);
                else standart.add(chest);

                if (chest.getCost() < OnlineStore.LOW_PRICE_HIGH_LIMIT) low_price.add(chest);
                else if (chest.getCost() > OnlineStore.HIGH_PRICE_LOW_LIMIT) high_price.add(chest);
                else middle_price.add(chest);
            }
        }
    }
    @Override
    public Set<Chest> getNarrow() {
        return Collections.unmodifiableSet(this.narrow);
    }

    @Override
    public Set<Chest> getStandart() {
        return Collections.unmodifiableSet(this.standart);
    }

    @Override
    public Set<Chest> getHighPrice() {
        return Collections.unmodifiableSet(this.high_price);
    }

    @Override
    public Set<Chest> getMiddlePrice() {
        return Collections.unmodifiableSet(this.middle_price);
    }

    @Override
    public Set<Chest> getLowPrice() {
        return Collections.unmodifiableSet(this.low_price);
    }
}
