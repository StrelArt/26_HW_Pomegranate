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

//    @Override
//    public final boolean equals(Object object) {
//        if (!(object instanceof Box box)) return false;
//
//        return name.equals(box.name) && granates.equals(box.granates);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + granates.hashCode();
//        return result;
//    }

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
