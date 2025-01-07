package org.chernovia.music;

public class ZugPitch {
    public static final int defMinPitch = 12, defMaxPitch = 127;
    public int pitch;
    public int minPitch;
    public int maxPitch;

    public ZugPitch(int pitch) {
        this(pitch,defMinPitch,defMaxPitch);
    }
    public ZugPitch(int p, int min, int max) {
        minPitch = min; maxPitch = max;
        pitch = attenuatePitch(p);
    }

    protected int attenuatePitch(int p) {
        return Math.min(Math.max(p, minPitch), maxPitch);
    }

    public void setMiidlePitch() {
        pitch = minPitch + ((maxPitch - minPitch) / 2);
    }

    @Override
    public String toString() {
        return pitch + ":" + ZugMusic.ZugNote.values()[pitch % ZugMusic.octave].toString();
    }
}
