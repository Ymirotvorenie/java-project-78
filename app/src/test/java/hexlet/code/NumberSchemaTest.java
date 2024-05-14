package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class NumberSchemaTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testNumberSchema() {
        var schema = validator.number().required().positive().range(22, 58);

        assertThat(schema.isValid(33)).isEqualTo(true);
        assertThat(schema.isValid(null)).isEqualTo(false);
    }

    @Test
    public void testNumberSchemaRequired() {
        var schema = validator.number();

        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid(5)).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(15)).isEqualTo(true);
    }

    @Test
    public void testNumberSchemaPositive() {
        var schema = validator.number().positive();

        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid(15)).isEqualTo(true);
        assertThat(schema.isValid(-15)).isEqualTo(false);
        assertThat(schema.isValid(0)).isEqualTo(false);

    }

    @Test
    public void testNumberSchemaRange() {
        var schema = validator.number().range(62, 113);

        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid(78)).isEqualTo(true);
        assertThat(schema.isValid(22)).isEqualTo(false);
        assertThat(schema.isValid(222)).isEqualTo(false);
    }
}
