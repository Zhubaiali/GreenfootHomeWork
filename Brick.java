import greenfoot.*; // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）

/**
 * 砖块类，用来供小球敲击
 */
public class Brick extends Actor {

    public static final int width = 50; // 砖块的宽度
    public static final int height = 20; // 砖块的高度
    private static final Color color = Color.RED; // 砖块的颜色
    public int hard;// 砖块的硬度

    // 构造方法，初始化砖块对象
    public Brick() {
        GreenfootImage image = new GreenfootImage(width, height); // 生成图像对象
        image.setColor(color); // 设置图像颜色
        image.fill(); // 用设置好的颜色填充图像
        setImage(image); // 将填充后的图像设置为砖块的图像
        hard = 0;
    }

    public Brick(int hard) {
        GreenfootImage image = new GreenfootImage(width, height); // 生成图像对象
        image.setColor(Color.BLUE); // 设置图像颜色
        image.fill(); // 用设置好的颜色填充图像
        setImage(image); // 将填充后的图像设置为砖块的图像
        this.hard =hard ;
    }

    // 获取砖块的水平半径
    public int getRadiusX() {
        return width / 2;
    }

    // 获取砖块的垂直半径
    public int getRadiusY() {
        return height / 2;
    }
}