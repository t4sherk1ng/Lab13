import java.util.Set;

public interface OnlineStore {
    int DEPTH_LIMIT = 50;
    int LOW_PRICE_HIGH_LIMIT = 1000;
    int HIGH_PRICE_LOW_LIMIT = 5000;
    void add(Chest chest);
    Set<Chest> getNarrow();
    Set<Chest> getStandart();
    Set<Chest> getHighPrice();
    Set<Chest> getMiddlePrice();
    Set<Chest> getLowPrice();
}
