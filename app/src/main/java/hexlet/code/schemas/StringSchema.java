package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public boolean isValid(String text) {
        if (StringUtils.isBlank(text)) {
            return !isRequired;
        } else {
            return super.isValid(text);
        }
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
