/*******这里存放，怎么改进MusicSheet1的********/

public void act() {
    List<String> list = new ArrayList<String>();// 存储琴谱中的音符名
    list.add("W");
    list.add("E");
    list.add("T");
    list.add("Y");
    list.add("U");

    if (Greenfoot.mouseClicked(this)) {

        List<Key> keys = getWorld().getObjects(Key.class);//先把所有的key对象取出来，存到keys

        for (String note : list) {

            for (Key k : keys) {
                if (k.getKey().equals(note)) {
                    k.play();
                }
            }
        }

    }
}

