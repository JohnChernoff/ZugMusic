import org.chernovia.music.ZugMusic;
import org.chernovia.music.ZugPitch;

public class ScaleTest {
    public static void main(String[] args) {
        ZugPitch startPitch = new ZugPitch(70);
        ZugMusic.ZugKey key = new ZugMusic.ZugKey(ZugMusic.ZugNote.noteAb, ZugMusic.Scale.majorScale);
        System.out.println(key.getNextPitch(startPitch,6));
        System.out.println(key.getNextPitch(startPitch,-6));
        System.out.println("***");
        key = new ZugMusic.ZugKey(ZugMusic.ZugNote.noteAb, ZugMusic.Scale.majorScale);
        for (int i=0;i<8;i++) {
            System.out.println(key.getNextPitch(startPitch,i));
        }
        System.out.println("***");
        key = new ZugMusic.ZugKey(ZugMusic.ZugNote.noteA, ZugMusic.Scale.naturalMinorScale);
        for (int i=0;i<7;i++) {
            System.out.println(key.getNextPitch(startPitch,i));
        }
        System.out.println("***");
        key = new ZugMusic.ZugKey(ZugMusic.ZugNote.noteF, ZugMusic.Scale.bluesScale);
        for (int i=0;i<13;i++) {
            System.out.println(key.getNextPitch(startPitch,i));
        }
    }
}
