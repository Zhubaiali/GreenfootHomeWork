import greenfoot.*;

/**
 * Write a description of class ResetButton here.
 * 
 * @author 杨婉平 
 * @version (a version number or a date)
 */
public class ResetButton extends Actor
{
    /**
     * Act - do whatever the ResetButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // 重置按钮类，点击之后游戏回到初始状态。
    //需要添加java的鼠标监听器吗？还是用Greenfoot的方法？
    //java的鼠标监听器是：MouseListener。需要类实现MouseListener接口，然后重写接口中的方法。
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {  //若鼠标点击了重置按钮，则
            Greenfoot.setWorld(new GameWorld());  //重置游戏
        }
    }    
}
