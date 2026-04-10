package actions;
import entities.*;
import battleEngine.*;

interface Actions{
    public void execute(Combatant activechar, Battle battle, Combatant target);
    public String getName();
}