import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * ?????????????????
 */
public class Piano extends World {
    private String[] whiteKeys = { "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "\\" };
    private String[] whiteNotes = { "3c", "3d", "3e", "3f", "3g", "3a", "3b", "4c", "4d", "4e", "4f", "4g" };

    private String[] blackKeys = { "W", "E", "", "T", "Y", "U", "", "O", "P", "", "]" };
    private String[] blackNotes = { "3c#", "3d#", "", "3f#", "3g#", "3a#", "", "4c#", "4d#", "", "4f#" };

    public Piano() {
        super(800, 340, 1);
        makeKeys(); // ????makeKeys()?????????????????????????е????
        prepare();
    }

    private void makeKeys() {
        int i = 0;

        // ?????????
        while (i < whiteKeys.length) {
            Key key = new Key(whiteKeys[i], whiteNotes[i] + ".wav", "white-key.png", "white-key-down.png");
            addObject(key, 54 + (i * 63), 140); // ???63??????????,???λ????????????
            i = i + 1;
        }

        // ?????????
        for (i = 0; i < blackKeys.length; i++) {
            if (!blackKeys[i].equals("")) {
                Key key = new Key(blackKeys[i], blackNotes[i] + ".wav", "black-key.png", "black-key-down.png");
                addObject(key, 85 + (i * 63), 86);
            }
        }
    }

    /**
     * ��ʼǰ��Ϊ��ľ籾��������
     * ����Ԫ������ĳ���
     */
    private void prepare() {
        MusicSheet1 musicsheet1 = new MusicSheet1();
        addObject(musicsheet1, 136, 307);
        musicsheet1.setLocation(131, 303);
        MusicSheet2 musicsheet2 = new MusicSheet2();
        addObject(musicsheet2, 234, 310);
        musicsheet2.setLocation(227, 303);
    }
}
