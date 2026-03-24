public class Wolf extends Enemy {
    public Wolf(){
        super("Wolf", 40, 45, 5, 25, new BasicAttackOnlyStrategy());
        //waiting for the class to be made
    }
}
