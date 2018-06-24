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

    public boolean checkIfLeftOverlapsRight(String left, String right) {
        if(left.contains(right)) {
            return true;
        }
        if (left.length() >= right.length()) {
            return checkForOverlapWhenFirstArgIsLarger(left, right);
        } else
            return checkForOverlapWhenSecondArgIsLarger(left, right);
    }

    public boolean checkIfRightOverlapsLeft(String left, String right) {
        if(right.contains(left)) {
            return true;
        }
        if (right.length() >= left.length()) {
            return checkForOverlapWhenFirstArgIsLarger(right, left);
        } else {
            return checkForOverlapWhenSecondArgIsLarger(right, left);
        }
    }

    private boolean checkForOverlapWhenFirstArgIsLarger(String first, String second) {
        String substring = first.substring(0, findOverlapSizeBetween(second, first));
        if (substring.equals("")) return false;

        return second.endsWith(substring);
    }

    private boolean checkForOverlapWhenSecondArgIsLarger(String first, String second) {
        String substring = first.substring(0, findOverlapSizeBetween(second, first));
        if (substring.equals("")) return false;

        return second.endsWith(substring);
    }
}
