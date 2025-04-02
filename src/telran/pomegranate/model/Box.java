package telran.pomegranate.model;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Box implements Iterable<Pomegranate> {
    private String name;
    private List<Pomegranate> granates;

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }



    public Iterator<Pomegranate> iterator(){
        return granates.iterator();
    }


    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", granates=" + granates +
                '}';
    }

    public Stream<Pomegranate> stream(){
        return granates.stream();
    }

    public String getName() {
        return name;
    }
}
