import greenfoot.*;

/**
 * 蛇身类，用来组成贪食蛇的身体
 */
public class Body extends Actor
{
    private int locX;  //蛇身横坐标值
    private int locY;  //蛇身纵坐标值
    
    //构造方法
    public Body(int x,int y){
       locX=x;
       locY=y;
    }
    
    //获取横坐标值
    public int getLocX(){
        return locX;
    }
    
    //获取纵坐标值
    public int getLocY(){
        return locY;
    }
    
    public void act() 
    {
    }    
}
