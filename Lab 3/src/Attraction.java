public abstract class Attraction implements Comparable<Attraction> {
    protected String name;

    public Attraction(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Attraction other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Attraction)) {
            return false;
        }
        Attraction other = (Attraction) obj;
        return name.equals(other.name);
    }
}