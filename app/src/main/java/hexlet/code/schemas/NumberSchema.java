package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        rules.put("required", Objects::nonNull);
    }

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        rules.put("positive", n -> n > 0);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        rules.put("range", n -> n >= begin && n <= end);
        return this;
    }
}
