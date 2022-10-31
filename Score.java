import greenfoot.*;  // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）


/**
 * 分数类，用来执行计分操作
 */
public class Score extends Actor{
    private final static int fontSize = 14;           //分数字体大小
    private final static Color fgColor = Color.BLUE;  //分数文字为蓝色
    private static final Color transparent = new Color(255, 255, 255, 0); //分数背景为透明色
    private int score = 0;                           //初始分数值为零 

    //分数对象加入游戏世界后便显示分数
    public void addedToWorld(World world) {
        drawScore(world, score);
    }

    //显示分数。生成分数的图像，并显示在窗口的适当位置
    public void drawScore(World world, int score) {
        GreenfootImage image = new GreenfootImage("分数： " + score, fontSize, fgColor, transparent);
        setImage(image);
        int x = 5 + image.getWidth() / 2;
        int y = world.getHeight() - 5 - image.getHeight() / 2;
        setLocation(x, y);
    }

    //增加分数。调用一次分数值加一，并重新显示分数图像
    public void increase() {
        score++;
        drawScore(getWorld(), score);
    }

    //获取当前分数
    public int getScore() {
        return score;
    }
}
