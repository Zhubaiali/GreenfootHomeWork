import greenfoot.*;

/**
 * 食物类
 */
public class Food extends Actor{    
    //更新食物位置
    public void act() {
        if(isTouching(Snake.class)){  //若是碰到贪食蛇，则随机移动到新的位置                   
            int x = 10+Greenfoot.getRandomNumber(getWorld().getWidth()-20);
            int y = 10+Greenfoot.getRandomNumber(getWorld().getHeight()-20);
            World w = getWorld();
            while(w.getObjectsAt(x, y, Body.class).size()!=0){
                x = 10+Greenfoot.getRandomNumber(w.getWidth()-20);
                y = 10+Greenfoot.getRandomNumber(w.getHeight()-20);
            }
            setLocation(x, y);
        }
    }    
}
