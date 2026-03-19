public class Wizard extends Playable {
    public Wizard(){
        super(200, 50, 10, 20);
    }
    public String getName() {
        return("Wizard");
    }
    public String getSpecialDesc() {
        return("Special Skill: Arcane Blast Effect: Deal \r\n" +
        "BasicAttack damage to all enemies currently \r\n" +  
        "in combat. Each enemy defeated by Arcane Blast \r\n" +
        "adds 10 to the Wizard’s Attack, lasting \r\n" +
        "until end of the level.");
    }
}
