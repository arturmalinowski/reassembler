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
        boolean check = underTest.checkIfOverlaps( "DEFG", "ABCDEF");
        assertThat(check, is(true));
    }

    @Test
    public void canDetermineOverlapInALongString() {
        boolean check = underTest.checkIfOverlaps("uam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam ei");
        assertThat(check, is(true));
    }

    @Test
    public void canDetermineOverlapForSpecialCharacters() {
        boolean check = underTest.checkIfOverlaps("conian devil! Oh la", "O draconia");
        assertThat(check, is(true));
    }

    @Test
    public void canDetermineOverlapReversed() {
        boolean check = underTest.checkIfOverlaps("ABCDEF", "XYZABC");
        assertThat(check, is(true));
    }

    @Test
    public void canDetermineOverlapContains() {
        boolean check = underTest.checkIfOverlaps("ABCDEF", "BCDE");
        assertThat(check, is(true));
    }

    @Test
    public void doesNotDetectOverlap() {
        boolean check = underTest.checkIfOverlaps("ABCDEF", "XCDEZ");
        assertThat(check, is(false));
    }

}