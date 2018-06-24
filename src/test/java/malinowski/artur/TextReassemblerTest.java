package malinowski.artur;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TextReassemblerTest {

    private TextReassembler underTest;

    @Before
    public void setUp() {
        underTest = new TextReassembler();
    }

    @Test
    public void canJoinTwoStringTogether() {
        String joinedString = underTest.join("hello", "llo");
        assertThat(joinedString, CoreMatchers.is("hello"));
    }

    @Test
    public void canJoinTwoStringsWithWhitespaceTogether() {
        String joinedString = underTest.join("O draconia", "conian devil! Oh la");
        assertThat(joinedString, CoreMatchers.is("O draconian devil! Oh la"));
    }

    @Test
    public void canReassembleShortText() {
        String reassembledText = underTest.reassemble("O draconia;conian devil! Oh la;h lame sa;saint!");

        assertThat(reassembledText, is("O draconian devil! Oh lame saint!"));
    }

    @Test
    public void canReassembleLongText() {
        String reassembledText = underTest.reassemble("m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al");

        assertThat(reassembledText, is("Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."));
    }
}