import greenfoot.*;  // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）


/**
 * 挡板类，用来反弹小球
 */
public class Bar extends Actor{

    private static final int width = 100;    //挡板的宽度 
    private static final int height = 20;    //挡板的高度
    private static final Color color = Color.BLACK;  //挡板的颜色
    private final static int speed = 5;     //挡板移动速度

    //初始化挡板，生成挡板的图像
    public Bar() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.fill();
        setImage(image);
    }

    //执行挡板对象的游戏逻辑更新，游戏每帧调用一次
    public void act() {
        checkKeys();
    }

    //获取挡板的高度
    public int getHeight(){
        return height;
    }

    //处理键盘按键事件
    public void checkKeys() {
        if (Greenfoot.isKeyDown("left")) {  //按下左键，挡板向左移动，并阻止其移出窗口左边界
            int newX = getX() - speed;
            if (newX - width/2 < 0) {  
                newX = width/2 ;
            }
            setLocation(newX, getY());
        }
        if (Greenfoot.isKeyDown("right")) {  //按下右键，挡板向右移动，并阻止其移出窗口右边界
            World space = getWorld();
            int newX = getX() + speed;
            if (newX + width/2  >= space.getWidth()) {
                newX = space.getWidth() - width/2 ;
            }
            setLocation(newX, getY());
        }
        if (Greenfoot.isKeyDown("space")) {  //按下空格键，发射小球
            GameWorld.canBallMove=true;
        }
    }
}