import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

//这是琴谱1，点那个四叶草自动让钢琴动起来弹奏并播放音乐
//首先用列表集合保存所有琴键对象，接着根据琴谱中的音符名获取对应的琴键对象
//然后调用琴键对象的play方法，让琴键对象弹奏

public class MusicSheet1 extends Actor {
    /*
     * private String[] whiteKeys =
     * { "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "\\" };
     * private String[] whiteNotes =
     * { "3c", "3d", "3e", "3f", "3g", "3a", "3b", "4c", "4d", "4e", "4f", "4g" };
     * 
     * private String[] blackKeys =
     * { "W", "E", "", "T", "Y", "U", "", "O", "P", "", "]" };
     * private String[] blackNotes =
     * { "3c#", "3d#", "", "3f#", "3g#", "3a#", "", "4c#", "4d#", "", "4f#" };
     */
    public void act() {
        List<String> list = new ArrayList<String>();// 存储琴谱

        list.add("3c");
        list.add("3d");
        list.add("3e");
        list.add("3f");
        list.add("3g");

        // 需要写个播放的方法，读一次调用一次，个它加个延迟

        if (Greenfoot.mouseClicked(this)) {
            /*
             * 把list里的音符名取出来，根据音符名找到对应的琴键对象，然后调用琴键对象的play方法
             */
            for (String note : list) {
                // 根据音符名找到对应的琴键对象

                // 每一个note对应一个琴键对象
                if (note.length() == 2) {
                    // 是白键，调用白键的构造器
                    Key key = new Key(whiteKeys[i], whiteNotes[i] + ".wav", "white-key.png", "white-key-down.png");

                } else {

                }

                key.play();
            }
        }

    }
}

// if(Greenfoot.mouseClicked(this)) {
// //1. list映射到keys
//
// for(int i = 0; i < list.size(); i++) {
// //获取世界中所有的Key对象
// List<Key> keys = getWorld().getObjects(Key.class);
// for(Key key : keys) {
// keyList.add(key);
// }
// }