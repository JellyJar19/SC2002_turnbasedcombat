public abstract class StatusEffects implements StatusEffectMethods {

    protected int duration;
    protected boolean active;

    @Override
    public boolean isActive() {
        return active;
    }
}
