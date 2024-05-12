package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void appTest() {
        var v = new Validator();
        var s = v.string().required().minLength(3).contains("j");
        assertThat(s.isValid("java")).isEqualTo(true);

        assertThat(s.isValid(null)).isEqualTo(false);
    }

    @Test
    public void testStringSchemaRequired() {
        var v = new Validator();
        var s = v.string();
        assertThat(s.isValid(null)).isEqualTo(true);
        assertThat(s.isValid("")).isEqualTo(true);

        s.required();
        assertThat(s.isValid(null)).isEqualTo(false);
        assertThat(s.isValid("")).isEqualTo(false);
        assertThat(s.isValid("Test StringSchema required field")).isEqualTo(true);
        assertThat(s.isValid("hexlet")).isEqualTo(true);
    }

    @Test
    public void testStringSchemaMinLength() {
        var v = new Validator();
        var s = v.string().minLength(4);

        assertThat(s.isValid(null)).isEqualTo(false);
        assertThat(s.isValid("")).isEqualTo(false);
        assertThat(s.isValid("Test StringSchema required field")).isEqualTo(true);
        assertThat(s.isValid("hexlet")).isEqualTo(true);
        assertThat(s.isValid("hex")).isEqualTo(false);
    }

    @Test
    public void testStringSchemaContains() {
        var v = new Validator();
        var s = v.string();

        assertThat(s.contains("abc").isValid(null)).isEqualTo(false);
        assertThat(s.contains("abc").isValid("")).isEqualTo(false);
        assertThat(s.contains("tes").isValid("test StringSchema here")).isEqualTo(true);
        assertThat(s.contains("test S").isValid("test StringSchema here")).isEqualTo(true);
        assertThat(s.contains("teststring").isValid("test StringSchema here")).isEqualTo(false);
        assertThat(s.isValid("test StringSchema here")).isEqualTo(false);
        assertThat(s.isValid("teststringSchema here")).isEqualTo(true);
    }

    @Test
    public void testStringSchema() {
        var v = new Validator();
        var schema = v.string().required().minLength(3).contains("j");
        assertThat(schema.isValid("java")).isEqualTo(true);

        var schema1 = v.string().required().minLength(5).contains("cdefg");
        assertThat(schema.isValid("abcdefghijklmnopqrstuvwxyz")).isEqualTo(true);
    }
}
