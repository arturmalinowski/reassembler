package malinowski.artur;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComparatorTest {

    private Comparator underTest;

    @Before
    public void setUp() {
        underTest = new Comparator();
    }

    @Test
    public void canFindOverlapSizeOfTwoStrings() {
        Integer size = underTest.findOverlapSizeBetween("1234", "2345");
        assertThat(size, is(3));
    }

    @Test
    public void canFindOverlapSizeOfTwoStringsWithWhitespace() {
        Integer size = underTest.findOverlapSizeBetween("hello there", "llo the");
        assertThat(size, is(7));
    }

    @Test
    public void canFindOverlapSizeOfTwoLargeStringsWithWhitespace() {
        Integer size = underTest.findOverlapSizeBetween("i dolorem ipsum qu", "m quaerat voluptatem.");
        assertThat(size, is(4));
    }

    @Test
    public void canDetermineOverlap() {
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("ABCDEF", "DEFG");
        boolean checkRight = underTest.checkIfRightOverlapsLeft("ABCDEF", "DEFG");
        assertThat(checkLeft, is(false));
        assertThat(checkRight, is(true));
    }

    @Test
    public void canDetermineOverlapInALongString() {
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("uam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam ei");
        boolean checkRight = underTest.checkIfRightOverlapsLeft("uam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam ei");
        assertThat(checkLeft, is(true));
        assertThat(checkRight, is(false));
    }

    @Test
    public void canDetermineOverlapForSpecialCharacters() {
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("O draconia", "conian devil! Oh la");
        boolean checkRight = underTest.checkIfRightOverlapsLeft("O draconia", "conian devil! Oh la");
        assertThat(checkLeft, is(false));
        assertThat(checkRight, is(true));
    }

    @Test
    public void canDetermineOverlapReversed() {
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("ABCDEF", "XYZABC");
        boolean checkRight = underTest.checkIfRightOverlapsLeft("ABCDEF", "XYZABC");
        assertThat(checkLeft, is(true));
        assertThat(checkRight, is(false));
    }

    @Test
    public void canDetermineOverlapContains() {
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("ABCDEF", "BCDE");
        boolean checkRight = underTest.checkIfRightOverlapsLeft("ABCDEF", "BCDE");
        assertThat(checkLeft, is(true));
        assertThat(checkRight, is(false));
    }

    @Test
    public void doesNotDetectOverlap() {
        boolean checkRight = underTest.checkIfRightOverlapsLeft("ABCDEF", "XCDEZ");
        boolean checkLeft = underTest.checkIfLeftOverlapsRight("ABCDEF", "XCDEZ");
        assertThat(checkRight, is(false));
        assertThat(checkLeft, is(false));
    }

}