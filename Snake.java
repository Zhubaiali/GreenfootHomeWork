import greenfoot.*;
import java.util.ArrayList;
/**
 *  贪食蛇类，用来控制蛇头移动，获取食物，并对蛇身进行管理
 */
public class Snake extends Actor{
    private ArrayList<Body> body;             //body列表用来保存蛇身
    private int length;                       //蛇身长度
    private int speed;                        //蛇头移动速度
    private int direction;                    //蛇头移动方向
    public static final int SOUTH = 0;        //该常量代表向下移动
    public static final int NORTH = 1;        //该常量代表向上移动
    public static final int EAST = 2;         //该常量代表向右移动
    public static final int WEST = 3;         //该常量代表向左移动

    //构造方法，初始化基本字段值
    public Snake() {   
        body = new ArrayList<Body>();
        length = 1;
        speed = getImage().getAwtImage().getWidth()+2;

    }

    //处理游戏逻辑
    public void act() {
        checkKeydown();
        move();
        updateBody();
        checkFood();
        checkGameOver();
    } 

    //检查是否获取食物
    public void checkFood(){
        if(isTouching(Food.class)){  //若蛇头碰到食物，且蛇身未达到上限，则
            length++;                                 //蛇身长度增加一个单位
        }
    }

    //更新贪食蛇身体
    public void updateBody(){
        if (length > 1) {
            if(body.size()==length){
                body.remove(0);     //从蛇身列表中移除蛇尾对应的Body对象
            }
            World w=getWorld();
            w.removeObjects(w.getObjects(Body.class));  //将蛇身从游戏世界中移除
            for(Body b:body){      //根据蛇身各部分的位置重新添加至游戏世界
                w.addObject(b, b.getLocX(),b.getLocY());
            }
            body.add(new Body(getX(),getY()));  //将蛇头对应的Body对象添加至蛇身列表
        }
    }
    
    //控制蛇头朝不同方向移动
    public void move(){
        switch (direction) {
            case SOUTH:
            setLocation(getX(), getY()+speed);
            break;
            case NORTH:
            setLocation(getX(), getY()-speed);
            break;
            case EAST:
            setLocation(getX()+speed, getY());
            break;
            case WEST:
            setLocation(getX()-speed, getY());
            break;
        }           
    }

    //检查游戏是否结束
    public void checkGameOver(){
        if(isAtEdge()||isTouching(Body.class)){  //若蛇头碰到窗口边界或是蛇身，则
            getWorld().showText("Game Over! ",  300, 200);
            Greenfoot.stop();                    //游戏停止
        }
    }

    //检测键盘按键事件，若按下方向键，则分别控制贪食蛇朝相应方向移动
    public void checkKeydown(){
        if(Greenfoot.isKeyDown("up")&&direction!=SOUTH){
            direction=NORTH;
        }
        else  if(Greenfoot.isKeyDown("down")&&direction!=NORTH){
            direction=SOUTH;
        }
        else  if(Greenfoot.isKeyDown("left")&&direction!=EAST){
            direction=WEST;
        }
        else  if(Greenfoot.isKeyDown("right")&&direction!=WEST){
            direction=EAST;
        }

    }
}
