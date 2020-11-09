package EdgarGame.Enemies;

/* Classe abstract implementa um metodo abstrato */
public class Enemy {
    protected String type;
    protected double life = 100.00;
    protected int defenseFactor;
    protected int attackFactor; //

    /* CONSTRUTOR */
    public Enemy(String type, int defenseFactor, int attackFactor){
        this.type = type;
        this.defenseFactor = defenseFactor;
        this.attackFactor = attackFactor;
    }

    public void printEnemy(){
        System.out.println("Type: " + type + "\n Life:" + life);
    }


   // public abstract void sleep();
   public void sleep(){
       System.out.println("zzzzz");
   }

}


