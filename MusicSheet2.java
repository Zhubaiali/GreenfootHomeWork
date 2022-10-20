import greenfoot.*;

/**
 * Write a description of class MusicSheet2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MusicSheet2 extends Actor {
    /**
     * Act - do whatever the MusicSheet2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {

            Key key = (Key) getWorld().getObjects(Key.class).get(0);
            key.play();
            Key key1 = (Key) getWorld().getObjects(Key.class).get(1);
            key1.play();
            Key key2 = (Key) getWorld().getObjects(Key.class).get(2);
            key2.play();
            Key key3 = (Key) getWorld().getObjects(Key.class).get(5);
            key3.play();
        }

    }

}
