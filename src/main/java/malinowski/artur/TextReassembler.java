package malinowski.artur;

import malinowski.artur.domain.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextReassembler {

    private Comparator comparator;
    private List<String> fragments;
    private List<Pair> pairs = new ArrayList<>();

    public TextReassembler() {
        comparator = new Comparator();
    }

    public String reassemble(String fragment) {
        String[] textSplit = fragment.split(";");
        fragments = new ArrayList<>(Arrays.asList(textSplit));

        String answer = reassembleText();

        return answer;
    }

    public String reassembleText() {
        for (int i = 0; i < fragments.size(); i++) {
            for (int j = i + 1; j < fragments.size(); j++) {
                String first = fragments.get(i);
                String second = fragments.get(j);

                if(comparator.checkIfOverlaps(first, second)) {
                    pairs.add(
                            new Pair(first, second, comparator.findOverlapSizeBetween(second, first))
                    );
                } else if (comparator.checkIfOverlaps(second, first)) {
                    pairs.add
                            (new Pair(second, first, comparator.findOverlapSizeBetween(first, second))
                    );
                }
            }
        }

        Pair pairWithLargestSize = getPairWithLargestSize();

        removeUsedFragmentsAndAddNew(pairWithLargestSize);

        if (fragments.size() == 1) {
            return fragments.get(0);
        } else {
            pairs.clear();
            return reassembleText();
        }
    }

    public String join(String left, String right) {
        if(left.contains(right)) return left;
        if(right.contains(left)) return right;

        if (!left.contains(right.substring(0,1)))
            return left + right;
        int index = right.length();
        try {
            while (!left.endsWith(right.substring(0, index--))) ;
        } catch (Exception e) {

        }
        return left + right.substring(index + 1);
    }

    private void removeUsedFragmentsAndAddNew(Pair pairWithLargestSize) {
        fragments.remove(pairWithLargestSize.getLeft());
        fragments.remove(pairWithLargestSize.getRight());

        String joinedStrings = join(pairWithLargestSize.getRight(), pairWithLargestSize.getLeft());

        fragments.add(joinedStrings);
    }

    private Pair getPairWithLargestSize() {
        int index = 0;
        int currentSize = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if(currentSize < pairs.get(i).getSize()) {
                index = i;
                currentSize = pairs.get(i).getSize();
            }
        }

        return pairs.get(index);
    }
}
