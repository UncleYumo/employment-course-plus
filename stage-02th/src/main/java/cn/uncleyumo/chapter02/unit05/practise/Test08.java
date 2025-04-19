package cn.uncleyumo.chapter02.unit05.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Test08
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 设计一个简单的音乐播放器程序。
 * ①使用泛型类 Playlist 来管理播放列表中的音乐。
 * ②每首音乐都有一个名称和一个时长，可以用 Music 类来表示。
 * ③定义两个方法 addMusic 和 play，并分别在 Playlist 类中实现。
 * ④在 Playlist 类中，我们定义了一个泛型类型参数 T extends Music，表示 T 必须是 Music 的子类或本身。
 *  我们使用 List 来存储播放列表中的音乐，并实现了两个方法 addMusic 和 play，分别用于向播放列表中添加音乐和按添加顺序播放音乐。
 * ⑤在测试类中，新建一个 Playlist 对象，并向播放列表中添加三首音乐。然后播放音乐
 */

public class Test08 {
    public static void main(String[] args) {
        Playlist<Music> playlist = new Playlist<>();
        playlist.addMusic(new Music("Shape of You", 240));
        playlist.addMusic(new Music("Take Me to Church", 340));
        playlist.addMusic(new Music("Falling Slowly", 260));
        playlist.play();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Music {
    private String name;
    private int duration;
}

class Playlist<T extends Music> {
    private final List<T> musicList = new ArrayList<>();
    public void addMusic(T music) {
        musicList.add(music);
    }
    public void play() {
        for (T music : musicList) {
            System.out.println(music.getName() + " - " + music.getDuration());
        }
    }
}