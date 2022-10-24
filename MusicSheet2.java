import greenfoot.*;

public class MusicSheet2 extends Actor {

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
