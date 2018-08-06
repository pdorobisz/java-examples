package examples.enums;

public enum AdvancedOperation implements Operation {
    MIN {
        @Override
        public int apply(int x, int y) {
            return Math.min(x, y);
        }
    };
}
