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
    /**
     * Performs an object check in accordance with the specified rules.
     * @param obj Generic object to be checked.
     * @return Return true if all validation rules are correct.
     */
    public boolean isValid(T obj) {
        if (obj == null) {
            return !isRequired;
        }
        return rules.values().stream().allMatch(r -> r.test(obj));
    }
    /**
     * Changes required flag to true.
     * @return this.
     */
    public BaseSchema<T> required() {
        isRequired = true;
        return this;
    }
}
