package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public <K, V> MapSchema shape(Map<K, BaseSchema<V>> dataSchemas) {
        addShapeRules(dataSchemas);
        return this;
    }

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int count) {
        rules.put("sizeof", m -> m.entrySet().size() == count);
        return this;
    }

    public <K, V> void addShapeRules(Map<K, BaseSchema<V>> dataSchemas) {
        rules.put("shape", (schema -> dataSchemas.entrySet().stream().allMatch(s -> {
            var value = (V) schema.get(s.getKey());
            return s.getValue().isValid(value);
        }))
        );
    }
}

