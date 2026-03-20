public abstract class Playable extends Entity{
    //extended by Warrior, Wizzard
    public Playable(int hitpoint, int attack, int defense, int Speed) {
        super(hitpoint, attack, defense, Speed);
    }
    public void Defend() {

    }
    public void Special() {

    }
    public void UseItem() {

    }
    public abstract String getSpecialDesc();

}
