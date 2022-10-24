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
        List<String> list = new ArrayList<String>();// 存储琴谱中的音符名
        list.add("W");
        list.add("E");
        list.add("T");
        list.add("Y");
        list.add("U");

        // 需要写个播放的方法，读一次调用一次，个它加个延迟
        if (Greenfoot.mouseClicked(this)) {
            /*
             * 把list里的音符名取出来，根据音符名找到对应的琴键对象，然后调用琴键对象的play方法
             */

            List<Key> keys = getWorld().getObjects(Key.class);
            for (String note : list) {

                // 根据音符名找到对应的琴键对象。用反射获取世界中的所有琴键对象，然后根据note获取对应的琴键对象。

                /*
                 * 方法1：在Key里设置getKey返回音符名，然后在这里调用，如果琴键对象的音符名和list里的音符名相同，就返回这个琴键对象
                 */

                for (Key k : keys) {
                    if (k.getKey().equals(note)) {
                        k.play();
                    }
                }

                // 这里用到了反射，反射是Java中的一个很重要的概念，它可以让我们在运行时获取类的信息，比如类的属性，方法，构造方法等等。那么我知道了属性名，怎么用反射获取对象呢？这里用到了getDeclaredField方法，它可以根据属性名获取属性对象，然后用get方法获取属性值。

                // 根据音符名找到对应的琴键对象
                // Key key = (Key) getWorld().getObjects(Key.class).stream().filter(k ->
                // k.getKey().equals(note)).findFirst().get();

                // return
                // k.getClass().getDeclaredField("key").get(k).equals(note);//getDeclaredField("key")获取key属性对象，然后用get方法获取属性值

                // 这里有NoSuchElementException.因为stream()返回的是一个Stream对象，而Stream对象是一个延迟加载的对象，它的方法不会立即执行，而是在需要的时候才执行，这里的findFirst方法就是一个延迟加载的方法，它会在需要的时候执行，而这里的需要就是get方法，所以这里会抛出NoSuchElementException异常，因为get方法会立即执行，而此时Stream对象还没有执行，所以会抛出异常。那要怎么解决呢？这里用到了findFirst方法，它会在Stream对象执行完毕后返回第一个元素，这样就不会抛出异常了。

            }

            // if (Greenfoot.mouseClicked(this)) {

            // for (String note : list) {

            // 每个key都已经创建了，都有String keyName, String soundFile, String img1, String img2。
            // List<Key> keys =

            // 每一个note对应一个琴键对象
            // if (note.length() == 2) {
            // // 是白键，调用白键的构造器
            // Key key = new Key(whiteKeys[i], whiteNotes[i] + ".wav", "white-key.png",
            // "white-key-down.png");

            // } else {

            // }
            // Key key = new Key(note);key的构造方法里不能这样用。错误！！

            // 调用琴键对象的play方法

        }
    }

}
