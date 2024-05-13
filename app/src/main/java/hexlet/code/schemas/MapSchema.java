package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int count) {
        rules.put("sizeof", m -> m.entrySet().size() == count);
        return this;
    }
}

