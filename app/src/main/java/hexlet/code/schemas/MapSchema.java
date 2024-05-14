package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    Map<K, BaseSchema<V>> schemas;

    @Override
    public boolean isValid(Map<K, V> data) {
        if (schemas == null) {
            return super.isValid(data);
        } else {
            for (var element : data.entrySet()) {
                K key = element.getKey();
                V value = element.getValue();

                if (!schemas.get(key).isValid(value)) {
                    return false;
                }
            }
            return true;
        }
    }

    public MapSchema<K, V> shape(Map<K, BaseSchema<V>> dataSchemas) {
        this.schemas = new HashMap<>(dataSchemas);
        return this;
    }

    public MapSchema<K, V> required() {
        super.required();
        return this;
    }

    public MapSchema<K, V> sizeof(int count) {
        rules.put("sizeof", m -> m.entrySet().size() == count);
        return this;
    }
}

