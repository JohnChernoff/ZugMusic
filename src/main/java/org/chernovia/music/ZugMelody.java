package org.chernovia.music;

public class ZugMelody extends ZugPitch { //TODO: add pitch and dur history
    public double currentTick = 0;
    public ZugMelody(int p, int min, int max) {
        super(p, min, max);
    }
    public void setPitch(ZugPitch p) {
        pitch = attenuatePitch(p.pitch);
    }
    public void reset() {
        currentTick = 0; setMiidlePitch();
    }
}
