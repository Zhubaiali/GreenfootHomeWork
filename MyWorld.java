import greenfoot.*;

/**
 *  游戏世界类，贪食蛇游戏运行的场景
 */
public class MyWorld extends World
{

    //构造方法，初始化游戏设计尺寸，并添加游戏角色
    public MyWorld()
    {    
        super(600, 400, 1); 
        addObject(new Snake(), getWidth()/2, getHeight()/2);
        addObject(new Food(), 10+Greenfoot.getRandomNumber(getWidth()-20), 10+Greenfoot.getRandomNumber(getHeight()-20));
        setPaintOrder(Snake.class);     
    }

}
