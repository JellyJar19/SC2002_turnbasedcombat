import java.util.List;

public class Wolf extends Enemy {
    public Wolf(){
        super("Wolf", 40, 45, 5, 25, new BasicAttackOnlyStrategy());
        // waiting for EnemyActionStrategy class to be made
    }

    public List<Actions> getAvailableActions() {
        System.out.print("not implemented yet");
        return(null);
        
    };
}
