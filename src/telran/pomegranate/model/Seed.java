package telran.pomegranate.model;

public class Seed {
    private double weight;

    public Seed(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "weight=" + weight +
                '}';
    }
}
