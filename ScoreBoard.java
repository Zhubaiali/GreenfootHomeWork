import greenfoot.*;  // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）

import java.util.ArrayList;
import java.util.List;

/**
 * 计分板类，用来游戏结束后显示总分数
 */
public class ScoreBoard extends Actor{
    private static final Color backgroundColor = Color.PINK;    //计分板背景颜色为粉红色
    private static final Color transparent = new Color(255, 255, 255, 0);  //分数背景为透明色

    //初始化计分板对象，设置计分板图像和显示内容的图像
    public ScoreBoard(int score) {
        List<GreenfootImage> lines = new ArrayList<GreenfootImage>();    //图像列表，保存各个显示内容的图像
        lines.add(new GreenfootImage("游戏结束", 48, Color.WHITE, transparent));  //游戏结束提示图像
        lines.add(new GreenfootImage("得分： " + score, 48, Color.WHITE, transparent));  //分数图像

        int width = 0;
        int height = 0;
        for (GreenfootImage line : lines) {  //根据显示的内容来设置计分板的宽度和高度
            height += line.getHeight();
            if (width < line.getWidth()) {
                width = line.getWidth();
            }
        }

        GreenfootImage image = new GreenfootImage(width + 20, height + 20); //创建计分板图像
        image.setColor(backgroundColor);
        image.fill();
        for (int i = 0, y = 10; i < lines.size(); i++) {   //将各个显示内容的图像绘制在计分板图像上
            GreenfootImage line = lines.get(i);
            image.drawImage(line, (image.getWidth() - line.getWidth()) / 2, y);
            y += line.getHeight();
        }
        setImage(image);    //设置计分板图像
    }
}
