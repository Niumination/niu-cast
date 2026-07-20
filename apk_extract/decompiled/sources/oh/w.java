package oh;

import k3.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends Exception implements li.x {
    private final long frameSize;

    public w(long j8) {
        this.frameSize = j8;
    }

    public final long getFrameSize() {
        return this.frameSize;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Frame is too big: " + this.frameSize;
    }

    @Override // li.x
    public w createCopy() {
        w wVar = new w(this.frameSize);
        c2.a(wVar, this);
        return wVar;
    }
}
