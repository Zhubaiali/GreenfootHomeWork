import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
/**
 * 游戏世界类，用来提供游戏进行的场景
 */
public class GameWorld extends World{
    private ArrayList<Block> blocks = new ArrayList<Block>();  //方块列表，管理游戏中所有方块
    
    //构造方法，用来为游戏世界添加初始对象
    public GameWorld(){    
        super(15, 20, 25);    //建立15x15的方块阵列，每个方块尺寸为25x25像素       
        for (int i=0; i<15; i++) {   //对于游戏世界的每一列，
            for (int j=5; j<20; j++) { //对于游戏世界的每一行，
                Block block = new Block();        //创建方块对象
                blocks.add(block);                //加入方块列表
                addObject(block, i, j);           //添加至游戏世界
            }
        }
        Collections.shuffle(blocks);    //打乱方块列表中各个方块的顺序

        addObject(new ResetButton(), 3, 2);  //添加重置按钮


        for (int i=0; i<20; i++) {      //对于方块列表中的前20个方块，
            blocks.get(i).setBomb();      //在其下设置地雷
        }
    }
    
    //显示所有的地雷
    public void showAllBomb() {
        for (int i=0; i<20; i++) {           //对于方块列表中的所有地雷方块，
            blocks.get(i).setImage("Bomb.png"); //将其图像设置为地雷
        }
    }
    
    //更新游戏逻辑，游戏每帧执行一次
    public void act() {
        for (int i=0; i<20; i++) {        //对于方块列表中的所有地雷方块，
            if (!blocks.get(i).getFlag()) { //若其没有插上旗子，则
                return;                       //返回
            }            
        }
        Greenfoot.playSound("win.wav");  //播放获胜的声音
        Greenfoot.stop();                //游戏停止
    }
}
