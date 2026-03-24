import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Entity{
    public Player(int hitpoint, int attack, int defense, int Speed) {
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
