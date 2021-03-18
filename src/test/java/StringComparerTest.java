import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringComparerTest {

    private static Stream<Arguments> provideStringsMatching() {
        return Stream.of(Arguments.of("MARA", "RAMA"), Arguments.of("talk", "klat"), Arguments.of("UmBrElLa", "LlaebRum"), Arguments.of("kot", "KOT"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsMatching")
    void should_return_true_for_two_strings_containing_the_same_set_of_letters(String s1, String s2) {
        assertTrue(StringComparer.compare(s1, s2));
    }

    private static Stream<Arguments> provideStringsNotMatching() {
        return Stream.of(Arguments.of("MARA", "RAMAA"), Arguments.of("talk", ""), Arguments.of("Ala", "Kot"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsNotMatching")
    void should_return_false_for_two_strings_containing_different_set_of_letters(String s1, String s2) {
        assertFalse(StringComparer.compare(s1, s2));
    }

    @Test
    void should_throw_null_pointer() {
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> StringComparer.compare("kot", null));

        assertEquals(NullPointerException.class, nullPointerException.getClass());
    }

}