package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Struct {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f1140bb;
    protected int bb_pos;

    public void __reset(int i8, ByteBuffer byteBuffer) {
        this.f1140bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i8;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, null);
    }
}
