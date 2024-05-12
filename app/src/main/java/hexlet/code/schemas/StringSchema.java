package hexlet.code.schemas;

public class StringSchema implements Schema<String> {
    private boolean required;
    private int minLength;
    private String contains;

    public StringSchema() {
        contains = "";
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String text) {
        contains = text;
        return this;
    }

    @Override
    public boolean isValid(String text) {
        if (text == null || text.isBlank()) {
            if (minLength > 0 || !contains.isEmpty()) {
                return false;
            }
            return !required;
        }

        boolean isMinLength = (text.length() > minLength);
        boolean isContains = text.contains(contains);

        return isMinLength && isContains;

    }
}
