import greenfoot.*; // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）
import java.awt.*;

/**
 * 游戏世界类，为游戏提供运行的场景
 */
public class GameWorld extends World {

    private Score score = null; // 游戏分数
    private Point allocation; // 砖块布局
    public static boolean canBallMove; // 小球移动标记

    // 构造方法，初始化游戏世界
    public GameWorld() {
        super(400, 400, 1, false); // 建立400x400方格的新场景，方格大小为1x1像素
        canBallMove = false; // 初始时小球静止不动
        allocation = new Point(4, 5); // 初始时砖块布局为5x4的阵列
        addBricks(); // 为游戏添加砖块角色
        Bar bar = new Bar();
        addObject(bar, getWidth() / 2, getHeight() - 30); // 添加挡板角色
        Ball ball = new Ball();
        addObject(ball, bar.getX(), bar.getY() - bar.getHeight() - 2); // 添加小球角色
        score = new Score();
        addObject(score, 0, 0); // 添加游戏分数
        setPaintOrder(Score.class, Bar.class); // 设置角色的显示顺序
    }

    // 根据砖块布局依次将每个砖块加入游戏世界
    public void addBricks() {
        for (int i = 0; i < allocation.y; i++) {
            for (int j = 0; j < 3; j++) {
                int x = getWidth() / allocation.x / 2 + j * (getWidth() / allocation.x);
                int y = (i * 2 + 1) * Brick.height;
                addObject(new Brick(), x, y);
            }
            // 分2块。上面0-2，下面3-allocation.x
            for (int j2 = 3; j2 < allocation.x; j2++) {
                int x = getWidth() / allocation.x / 2 + j2 * (getWidth() / allocation.x);
                int y = (i * 2 + 1) * Brick.height;
                addObject(new Brick(1), x, y);// 调用有参构造方法。
            }

        }
    }

    // 获取游戏分数值
    public Score getScore() {
        return score;
    }

    // 游戏结束时的操作
    public void gameOver() {
        addObject(new ScoreBoard(score.getScore()), getWidth() / 2, getHeight() / 2); // 在程序窗口中央显示记分牌
        Greenfoot.stop(); // 游戏停止
    }
}
