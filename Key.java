import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * �ټ��࣬������ʾ���ٵ��ټ�
 */
public class Key extends Actor {
    private boolean isDown; // ��¼�ټ������Ƿ񱻰��µı�Ǳ���
    private String key; // �����Ա����key��ʾ���԰����ļ���
    private String sound; // �����Ա����sound��ʾ�ټ���Ӧ�������ļ�
    private String upImage; // �ټ������Ч��ͼƬ��
    private String downImage; // �ټ����µ�Ч��ͼƬ��

    // Key��Ĺ�������������
    public Key(String keyName, String soundFile, String img1, String img2) {
        sound = soundFile;
        key = keyName;
        upImage = img1;
        downImage = img2;
        setImage(upImage);
        isDown = false;
    }

    // public Key(String keyName) {
    // key = keyName;
    // }// 这里有空指针异常

    public void act() {
        if (!isDown && Greenfoot.isKeyDown(key)) {
            Greenfoot.playSound(sound);
            setImage(downImage);
            isDown = true;
        }
        if (isDown && !Greenfoot.isKeyDown(key)) {
            setImage(upImage);
            isDown = false;
        }
    }

    // �ټ������play���������������ټ�
    public void play() {
        setImage(downImage);
        Greenfoot.playSound(sound);
        Greenfoot.delay(10);
        setImage(upImage);
    }

    // 获取音符名
    public String getKey() {
        return key;
    }

}