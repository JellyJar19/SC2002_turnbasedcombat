public class Entity {
    private int HP;
    private int Atk;
    private int Def;
    private int Spd;
    public Entity(int hitpoint, int attack, int defense, int Speed){
        HP = hitpoint;
        Atk = attack;
        Def = defense;
        Spd = Speed;
    }
    public void basicAttack(Entity target){
        target.setHP(target.getHP() - this.Atk);
    }
    public void setHP(int hitpoint){
        HP = hitpoint;
    }
    public void setAtk(int attack){
        Atk = attack;
    }
    public void setDef(int defense){
        Def = defense;
    }
    public void setSpd(int Speed){
        Spd = Speed;
    }
    public int getHP(){
        return this.HP;
    }
    public int getAttack(){
        return this.Atk;
    }
    public int getDef(){
        return this.Def;
    }
    public int getSpd(){
        return this.Spd;
    }
}