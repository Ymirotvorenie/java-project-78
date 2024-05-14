package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> rules;
    protected boolean isRequired;

    public BaseSchema() {
        rules = new LinkedHashMap<>();
    }

    public boolean isValid(T obj) {
        if (obj == null) {
            return !isRequired;
        }
        return rules.values().stream().allMatch(r -> r.test(obj));
    }

    public BaseSchema<T> required() {
        isRequired = true;
        return this;
    }
}
