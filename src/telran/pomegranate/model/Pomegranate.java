package telran.pomegranate.model;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Pomegranate implements Iterable<Seed> {
    private List<Seed> seeds;

    public Pomegranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public Iterator<Seed> iterator(){
        return seeds.iterator();
    }

//    @Override
//    public final boolean equals(Object object) {
//        if (!(object instanceof Pomegranate that)) return false;
//
//        return seeds.equals(that.seeds);
//    }
//
//    @Override
//    public int hashCode() {
//        return seeds.hashCode();
//    }

    @Override
    public String toString() {
        return "Pomegranate{" +
                "seeds=" + seeds +
                '}';
    }

    public Stream<Seed> stream(){
        return seeds.stream();
    }
}
