package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testStringSchemaRequired() {
        var schema = validator.string();

        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid("")).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);
        assertThat(schema.isValid("Test StringSchema required field")).isEqualTo(true);
        assertThat(schema.isValid("hexlet")).isEqualTo(true);
    }

    @Test
    public void testStringSchemaMinLength() {
        var schema = validator.string().minLength(4);

        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid("")).isEqualTo(true);
        assertThat(schema.isValid("Test StringSchema required field")).isEqualTo(true);
        assertThat(schema.isValid("hexlet")).isEqualTo(true);
        assertThat(schema.isValid("hex")).isEqualTo(false);
    }

    @Test
    public void testStringSchemaContains() {
        var schema = validator.string();

        assertThat(schema.contains("abc").isValid(null)).isEqualTo(true);
        assertThat(schema.contains("abc").isValid("")).isEqualTo(true);
        assertThat(schema.contains("tes").isValid("test StringSchema here")).isEqualTo(true);
        assertThat(schema.contains("test S").isValid("test StringSchema here")).isEqualTo(true);
        assertThat(schema.contains("teststring").isValid("test StringSchema here")).isEqualTo(false);
        assertThat(schema.isValid("test StringSchema here")).isEqualTo(false);
        assertThat(schema.isValid("teststringSchema here")).isEqualTo(true);
    }

    @Test
    public void testStringSchema() {
        var schema = validator.string().required().minLength(3).contains("j");
        assertThat(schema.isValid("java")).isEqualTo(true);

        var schema1 = validator.string().required().minLength(5).contains("cdefg");
        assertThat(schema1.isValid("abcdefghijklmnopqrstuvwxyz")).isEqualTo(true);
    }
}
