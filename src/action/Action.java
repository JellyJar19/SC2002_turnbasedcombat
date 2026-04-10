package action;
import statusEffects.*;
import entities.*;

public interface Action{
    public <T> boolean execute(T activechar, T target, Battle battle);
    public string getName();
}