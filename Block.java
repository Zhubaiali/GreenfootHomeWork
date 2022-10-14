import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * 方块类，其中20个方块下藏有地雷
 */
public class Block extends Actor{
    private boolean isBomb=false;        //标记方块下是否有地雷
    private boolean isFlagged = false;   //标记方块上是否插了旗子
    private boolean isOpen=false;        //标记方块是否被翻开 

    //获取旗子的标记
    public boolean getFlag() {      
        return isFlagged;
    }

    //设置地雷
    public void setBomb() {         
        isBomb = true;
    }

    //获取地雷标记
    public boolean getBomb() {     
        return isBomb;
    }

    //更新方块对象的游戏逻辑，游戏每帧执行一次
    public void act() {
        checkMouse();  //处理鼠标单击事件
    }    

    //处理鼠标单击事件
    public void checkMouse(){     
        //若检测到鼠标的单击事件，则进行处理
        if (Greenfoot.mouseClicked(this)) {       
            MouseInfo mouse = Greenfoot.getMouseInfo();  // 创建鼠标对象，获取鼠标事件
            //若鼠标右键单击方块，同时方块没有被翻开，则进行处理
            if (mouse.getButton()==3 && !isOpen) { 
                if (!isFlagged) {                    //若方块上没有插旗子，则    
                    setImage("BlockFlagged.png");      //将方块图片换为旗子图片
                    isFlagged=true;                    //将旗子标记置为true
                } else {                            //若方块已经插了旗子，则
                    setImage("Block.png");            //重新设置为方块图片
                    isFlagged=false;                  //将旗子标记置为false
                }
            }
            //若鼠标左键单击方块，同时方块上没插旗子，则进行处理   
            if (mouse.getButton()==1 && !isFlagged) {    
                if (isBomb) {                              //若该方块下有地雷，则    
                    GameWorld world = (GameWorld) getWorld();//获取游戏世界对象
                    world.showAllBomb();                     //显示世界中所有的地雷
                    Greenfoot.playSound("bomb.wav");         //播放爆炸音效
                    Greenfoot.stop();                        //停止游戏
                } else {                                   //若该方块下没有地雷，则
                    openBlock(this);                         //翻开该方块
                }                
            }
        } 
    }

    //递归地翻开方块及其周围的所有方块
    private void openBlock(Block block) {        
        block.isOpen=true;    //标记方块状态为翻开
        int bombNumber=block.getBombNumber(block);
        block.setImage("BlockClicked["+bombNumber+"].png"); //显示方块周围的地雷数
        //若方块周围没有地雷，则进行处理
        if (bombNumber==0) {  
            List<Block> blocks = block.getNeighbours(1, true, Block.class); //获取相邻的方块对象
            for (Block nBlock: blocks) {       //逐一翻开相邻的各个方块
                if (!nBlock.isOpen) {            //若某方块没有被翻开，则
                    openBlock(nBlock);             //翻开该方块
                }
            }
        }
    }

    //获取方块周围埋藏的地雷数量
    private int getBombNumber(Block block) {
        int bombNumber=0;               //该变量用来记录地雷数
        List<Block> blocks = block.getNeighbours(1, true, Block.class);  //获取相邻的方块对象
        for (Block nBlock: blocks) {    //检测相邻各方块下是否有地雷
            if (nBlock.getBomb()) {       //若某方块下有地雷，则
                bombNumber++;               //地雷数量加一
            }
        }  
        return bombNumber;              //返回地雷数
    }
}
