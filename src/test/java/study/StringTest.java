package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void subString() {
        String result = "{1,2}".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void subString2() {
        String result = "1";
        assertThatThrownBy(() -> {
            result.substring(1, 5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
