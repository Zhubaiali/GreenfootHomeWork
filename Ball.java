import greenfoot.*; // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）

import java.util.List;

/**
 * 小球类，用来与挡板和砖块交互
 */
public class Ball extends Actor {
    private static final int defaultRadius = 10; // 小球半径预设值
    private static final Color color = Color.YELLOW; // 小球颜色为黄色
    private int radius; // 小球半径
    private int speedX; // 水平方向速度
    private int speedY; // 垂直方向速度
    private int delay; // 延迟变量，防止小球在挡板内连续反弹
    private int live; // 小球生命值

    // 初始化小球对象
    public Ball() {
        radius = defaultRadius;
        speedX = 2;
        speedY = 3;
        delay = 0;
        live = 3;
        drawImage();
    }

    // 绘制小球图像
    public void drawImage() {
        GreenfootImage image = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        image.setColor(color);
        image.fillOval(0, 0, image.getWidth(), image.getHeight());
        setImage(image);
    }

    // 执行小球的游戏逻辑更新，游戏每帧调用一次
    public void act() {
        if (GameWorld.canBallMove) { // 若小球处于移动状态，则让其在屏幕四周移动并敲击砖块
            move();
            checkHitWorldEdge();
            checkHitBar();
            checkHitBrick();
            checkGameOver();
        } else { // 若小球处于非移动状态，则将其置于挡板的中央
            Bar bar = (Bar) (getWorld().getObjects(Bar.class).get(0));
            setLocation(bar.getX(), bar.getY() - bar.getHeight() - 2);
            speedX = Greenfoot.getRandomNumber(5) - 2;
            if (speedX == 0) {
                speedX = 2;
            } // 防止小球在挡板上静止
        }
    }

    // 根据水平及垂直速度进行移动
    private void move() {
        setLocation(getX() + speedX, getY() + speedY);
    }

    // 小球与窗口边界的碰撞检测及处理
    private void checkHitWorldEdge() {
        World space = getWorld();
        if (getX() - radius < 0 || getX() + radius >= space.getWidth()) {
            speedX = -speedX;
        }
        if (getY() - radius < 0) {
            speedY = -speedY;
        }
        if (getY() > space.getHeight()) {
            live--;
            GameWorld.canBallMove = false;
        }
    }

    // 小球与挡板的碰撞检测及处理
    private void checkHitBar() {
        Actor bar = getOneIntersectingObject(Bar.class);
        if (bar != null && delay <= 0) {
            if (getY() < bar.getY()) {
                speedY = -speedY;
            }
            delay = 20;
        }
        delay--;
    }

    // 小球与砖块的碰撞检测及处理
    private void checkHitBrick() {
        GameWorld space = (GameWorld) getWorld();
        List<Brick> bricks = space.getObjects(Brick.class);
        Score score = space.getScore();
        for (Brick brick : bricks) {
            if (isTouchedFromUpBottom(brick)) { // 若碰到方块的上、下两面
                speedY = -speedY;

                score.increase();
                // System.out.println("撞到了");

                // 这里要分情况讨论。看撞到的是蓝色的砖块还是红色砖块。蓝色砖块的hard是1，红色砖块的hard是0.
                if (brick.hard == 0) {
                    space.removeObject(brick);
                } else {
                    // System.out.println("蓝色砖块");
                    brick.hard = 0;
                    continue;
                }

                // space.removeObject(brick);
                //
            } else if (isTouchedFromLeftRight(brick)) { // 若碰到方块的左、右两面
                speedX = -speedX;
                score.increase();
                // System.out.println("撞到了");

                if (brick.hard == 0) {
                    space.removeObject(brick);
                } else {
                    brick.hard = 0;
                    continue;

                }
                // space.removeObject(brick);
                // score.increase();
            } else if (isTouchedCorner(brick)) { // 若碰到方块的四个角
                speedX = -speedX;
                speedY = -speedY;
                score.increase();
                // System.out.println("撞到了");

                if (brick.hard == 0) {
                    space.removeObject(brick);
                } else {
                    brick.hard = 0;
                    continue;

                }
                // space.removeObject(brick);
                // score.increase();
            }
        }
    }

    // 检测是否从上、下两个方向碰撞到方块
    private boolean isTouchedFromUpBottom(Brick rect) {
        if (Math.abs(rect.getY() - getY()) <= rect.getRadiusY() + radius
                && Math.abs(rect.getX() - getX()) <= rect.getRadiusX()) {
            return true;
        }
        return false;
    }

    // 检测是否从左、右两个方向碰撞到方块
    private boolean isTouchedFromLeftRight(Brick rect) {
        if (Math.abs(rect.getX() - getX()) <= rect.getRadiusX() + radius
                && Math.abs(rect.getY() - getY()) <= rect.getRadiusY()) {
            return true;
        }
        return false;
    }

    // 检测是否从四个边角碰撞到方块
    private boolean isTouchedCorner(Brick rect) {
        int cornerX = -1, cornerY = -1, dX = 0, dY = 0;

        // 检测左上角。
        cornerX = rect.getX() - rect.getRadiusX();
        dX = getX() - cornerX;
        cornerY = rect.getY() - rect.getRadiusY();
        dY = getY() - cornerY;
        if (dX < 0 && dY < 0 && dX * dX + dY * dY <= radius * radius) {
            return true;
        }

        // 检测右上角。
        cornerX = rect.getX() + rect.getRadiusX();
        dX = getX() - cornerX;
        cornerY = rect.getY() - rect.getRadiusY();
        dY = getY() - cornerY;
        if (dX > 0 && dY < 0 && dX * dX + dY * dY <= radius * radius) {
            return true;
        }

        // 检测左下角。
        cornerX = rect.getX() - rect.getRadiusX();
        dX = getX() - cornerX;
        cornerY = rect.getY() + rect.getRadiusY();
        dY = getY() - cornerY;
        if (dX < 0 && dY > 0 && dX * dX + dY * dY <= radius * radius) {
            return true;
        }

        // 检测右上角。
        cornerX = rect.getX() + rect.getRadiusX();
        dX = getX() - cornerX;
        cornerY = rect.getY() + rect.getRadiusY();
        dY = getY() - cornerY;
        if (dX > 0 && dY > 0 && dX * dX + dY * dY <= radius * radius) {
            return true;
        }

        return false;
    }

    // 检测游戏是否结束
    private void checkGameOver() {
        GameWorld space = (GameWorld) getWorld();
        if (live == 0 || space.getObjects(Brick.class).size() == 0) {
            space.gameOver();
        }
    }
}
