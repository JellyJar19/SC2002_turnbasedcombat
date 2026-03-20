public abstract class Item {
    //extended by subclasses: Potion, SmokeBomb, PowerStone
    public String getName() {
        return("This shouldn't be printed cuz its supposed to be overriden by the actual items");
    }
}
