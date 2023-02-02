package pl.javastart.task;

public enum Type {
    DATE_TIME_STANDARD("yyyy-MM-dd HH:mm:ss"),
    DATE_TIME_DOT("dd.MM.yyy HH:mm:ss");

    private String pattern;

    Type(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
