package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema() {
        rules.put("required", Objects::nonNull);
    }

    public <V> MapSchema shape(Map<String, BaseSchema<V>> dataSchemas) {
        rules.put("shape", (schema -> dataSchemas.entrySet().stream().allMatch(s -> {
            var value = (V) schema.get(s.getKey());
            return s.getValue().isValid(value);
        }))
        );
        return this;
    }

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int count) {
        rules.put("sizeof", m -> m.size() == count);
        return this;
    }

}

