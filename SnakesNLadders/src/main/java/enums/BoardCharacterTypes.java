package enums;

public enum BoardCharacterTypes {
    LADDER {
        public boolean validate(int starting, int ending) {
            return starting < ending;
        }
    },
    SNAKE {
        public boolean validate(int starting, int ending) {
            return starting > ending;
        }
    };

    public abstract boolean validate(int starting, int ending);
}
