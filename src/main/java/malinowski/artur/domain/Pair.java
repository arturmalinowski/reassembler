package malinowski.artur.domain;

public class Pair {

    private final String left;
    private final String right;
    private final Integer size;

    public Pair(String left, String right, Integer size) {
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public Integer getSize() {
        return size;
    }
}
