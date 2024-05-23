package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        rules.put("required", StringUtils::isNoneBlank);
    }

    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema minLength(int minLength) {
        rules.put("minLength", str -> str.length() >= minLength);
        return this;
    }

    public StringSchema contains(String text) {
        rules.put("contains", str -> str.contains(text));
        return this;
    }
}
