public abstract class GraphItem {

    private final String name;

    protected GraphItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
