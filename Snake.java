import greenfoot.*;
import java.util.ArrayList;

/**
 * 贪食蛇类，用来控制蛇头移动，获取食物，并对蛇身进行管理
 */
public class Snake extends Actor {
    private ArrayList<Body> body; // body列表用来保存蛇身
    private int length; // 蛇身长度
    private int speed; // 蛇头移动速度
    private int direction; // 蛇头移动方向
    public static final int SOUTH = 0; // 该常量代表向下移动
    public static final int NORTH = 1; // 该常量代表向上移动
    public static final int EAST = 2; // 该常量代表向右移动
    public static final int WEST = 3; // 该常量代表向左移动

    int flag; // 判断length是增加还是减少了。0表示刚刚一步没吃到食物，1表示刚刚吃到好吃的食物，2表示刚刚吃到坏吃的食物

    // 构造方法，初始化基本字段值
    public Snake() {
        body = new ArrayList<Body>();
        length = 1;
        speed = getImage().getAwtImage().getWidth() + 2;
        flag = 0;// 0表示无状态。1表示刚刚增加了长度。2表示刚刚减少了长度。
    }

    // 处理游戏逻辑
    // 处理游戏逻辑
    public void act() {
        System.out.println("body" + body.size());
        System.out.println("length" + length);

        checkKeydown();
        move();
        updateBody();
        checkFood();
        checkBadFood();
        checkGameOver();
    }// act方法是每一帧都在执行。是循环执行

    // 检查是否获取食物
    public void checkFood() {
        if (isTouching(Food.class)) { // 若蛇头碰到食物，且蛇身未达到上限，则
            length++; // 蛇身长度增加一个单位
            flag = 1;
        }
    }

    public void checkBadFood() {
        if (isTouching(BadFood.class) && length > 1) {
            // 若蛇头碰到坏食物，且蛇身长度大于1，则蛇身长度减少一个单位
            length--;
            flag = 2;
        }
    }

    // 更新贪食蛇身体
    public void updateBody() {
        if (flag == 1) {
            if (body.size() == length) {
                body.remove(0); // 从蛇身列表中移除蛇尾对应的Body对象
            }
            World w = getWorld();
            w.removeObjects(w.getObjects(Body.class)); // 将蛇身从游戏世界中移除
            for (Body b : body) { // 根据蛇身各部分的位置重新添加至游戏世界
                w.addObject(b, b.getLocX(), b.getLocY());
            }
            body.add(new Body(getX(), getY())); // 将蛇头对应的Body对象添加至蛇身列表

        }
        if (flag == 2) {
            flag = 1;
            body.remove(0);
            World w = getWorld();
            w.removeObjects(w.getObjects(Body.class)); // 将蛇身从游戏世界中移除
            for (Body b : body) { // 根据蛇身各部分的位置重新添加至游戏世界
                w.addObject(b, b.getLocX(), b.getLocY());
            }

        }

    }

    // 控制蛇头朝不同方向移动
    public void move() {
        switch (direction) {
            case SOUTH:
                setLocation(getX(), getY() + speed);
                break;
            case NORTH:
                setLocation(getX(), getY() - speed);
                break;
            case EAST:
                setLocation(getX() + speed, getY());
                break;
            case WEST:
                setLocation(getX() - speed, getY());
                break;
        }
    }

    // 检查游戏是否结束
    public void checkGameOver() {
        if (isAtEdge() || isTouching(Body.class)) { // 若蛇头碰到窗口边界或是蛇身，则
            getWorld().showText("Game Over! ", 300, 200);
            Greenfoot.stop(); // 游戏停止
        }
    }

    // 检测键盘按键事件，若按下方向键，则分别控制贪食蛇朝相应方向移动
    public void checkKeydown() {
        if (Greenfoot.isKeyDown("up") && direction != SOUTH) {
            direction = NORTH;
        } else if (Greenfoot.isKeyDown("down") && direction != NORTH) {
            direction = SOUTH;
        } else if (Greenfoot.isKeyDown("left") && direction != EAST) {
            direction = WEST;
        } else if (Greenfoot.isKeyDown("right") && direction != WEST) {
            direction = EAST;
        }

    }
}
