package malinowski.artur;

public class Comparator {

    public Comparator() {
    }

    public Integer findOverlapSizeBetween(String left, String right) {
        if (left.contains(right)) return right.length();
        if (right.contains(left)) return left.length();

        int maxOverlap = right.length() - 1;
        while (!left.regionMatches(left.length() - maxOverlap, right, 0,
                maxOverlap)) {
            maxOverlap--;
        }
        return maxOverlap;
    }

    public boolean checkIfOverlaps(String left, String right) {
        if(left.contains(right)) {
            return true;
        }
        return checkForOverlapBetween(left, right);
    }

    private boolean checkForOverlapBetween(String first, String second) {
        String substring = first.substring(0, findOverlapSizeBetween(second, first));
        if (substring.equals("")) return false;

        return second.endsWith(substring);
    }
}
