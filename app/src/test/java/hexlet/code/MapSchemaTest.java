package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testMapSchema() {
        var schema = validator.map();

        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid(new HashMap<String, String>()));
        assertFalse(schema.isValid(null));

        var data = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertTrue(schema.isValid(data));

        schema.sizeof(3);
        assertFalse(schema.isValid(data));
    }
}
