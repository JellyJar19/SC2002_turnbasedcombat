public class Warrior extends Playable {
    public Warrior(){
        super(260, 40, 20, 30);
    }
    public String getName() {
        return("Warrior");
    }
    public String getSpecialDesc() {
        return("Special Skill: Shield Bash Effect: Deal\r\n" + //
                        "BasicAttack damage to selected enemy.\r\n" + //
                        "Selected enemy is unable to take actions for\r\n" + //
                        "the current turn and the next turn.\n");
    }
    
}
