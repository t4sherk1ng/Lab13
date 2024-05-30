import java.util.Objects;

public class Chest {
    private String label;
    private int height;
    private int weight;
    private int depth;
    private double cost;

    public Chest(String label, int height, int weight, int depth, double cost) {
        if ((label == null || label.isBlank())
                || height <= 0 || weight <= 0 || depth <= 0
                || cost <= 0)
            throw new IllegalArgumentException();
        this.label = label;
        this.height = height;
        this.weight = weight;
        this.depth = depth;
        this.cost = cost;
    }
    public String getLabel() {
        return label;
    }
    public int getVolume() {
        return height * weight * depth;
    }
    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getDepth() {
        return depth;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chest chest = (Chest) o;
        return height == chest.height
                && weight == chest.weight
                && depth == chest.depth
                && Objects.equals(label, chest.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, height, weight, depth);
    }

    @Override
    public String toString() {
        return String.format(
                "%n'%s' %dx%dx%d - %.2f$",
                label, height, weight, depth, cost
        );
    }
}
