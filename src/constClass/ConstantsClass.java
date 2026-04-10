public final class ConstantsClass {
    public static final int MAXENEMIES = 5;
    public static final int TOTALCOMBATANTS = MAXENEMIES + 1;
    public static final int MAXITEMS = 2;

    // Prevent instantiation
    private ConstantsClass() {
        throw new UnsupportedOperationException("Constants class");
    }
}
