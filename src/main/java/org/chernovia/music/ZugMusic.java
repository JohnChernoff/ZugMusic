package org.chernovia.music;

public class ZugMusic {
    public static final int octave = 12;
    public record Degree (int chromaticDegree, int scaleDegree) {}
    public record ZugKey (ZugNote keyNote, Scale keyScale) {
        public ZugPitch getNextPitch(ZugPitch currentPitch, int steps) {
            int chromaticDegree = (currentPitch.pitch % octave) - keyNote.ordinal();
            if (chromaticDegree < 0) chromaticDegree += octave;
            Degree degree = keyScale.findScaleDegree(chromaticDegree);
            int nextPitch = currentPitch.pitch;
            nextPitch += (degree.chromaticDegree() - chromaticDegree);
            int id = steps > 0 ? 1 : -1;
            for (int step = 0; steps > 0 ? step < steps : step > steps; step+=id) {
                int v = degree.scaleDegree() + step;
                int i = Math.abs(v % keyScale.intervals.length); if (v <= 0) i = keyScale.intervals.length - i - 1;
                nextPitch += steps > 0 ? keyScale.intervals[i] : -keyScale.intervals[i]; //log("Step " + step + ": " + pNote(nextPitch) + " [" + i + "," + v  +"]");
            }
            return new ZugPitch(nextPitch);
        }
    }
    public enum ZugNote { noteC,noteDb,noteD,noteEb,noteE,noteF,noteGb,noteG,noteAb,noteA,noteBb,noteB }

    public enum Scale {
        majorScale(new int[] {2, 2, 1, 2, 2, 2, 1}),
        naturalMinorScale(new int[] {2, 1, 2, 2, 1, 2, 2}),
        bluesScale(new int[] {3, 2, 1, 1, 3, 2}),
        chromaticScale(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
        final int[] intervals;
        Scale(int[] intervals) {
            this.intervals = intervals;
        }
        private Degree findScaleDegree(int chromaticDegree) {
            int p = 0;
            int interval = 0;
            for (int i : intervals) { //log("pitch: " + p);
                if (p >= chromaticDegree) return new Degree(p,interval);
                p += i;
                interval++;
            }
            return new Degree(p,interval);
        }

    }

    static public ZugNote getNote(ZugPitch pitch) {
        return ZugNote.values()[pitch.pitch % octave];
    }

    static public void log(String msg) {
        System.out.println(msg);
    }

}
