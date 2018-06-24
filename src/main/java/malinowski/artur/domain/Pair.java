package malinowski.artur.domain;

public class Pair {

    private String left;
    private String right;
    private Integer size;

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
