package l2;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final float[] f9644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public FloatBuffer f9645b;

    public c() {
        float[] fArr = new float[8];
        this.f9644a = fArr;
        FloatBuffer floatBufferPut = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        l0.o(floatBufferPut, "allocateDirect(array.size * 4)\n            .order(ByteOrder.nativeOrder())\n            .asFloatBuffer()\n            .put(array)");
        this.f9645b = floatBufferPut;
    }

    @os.l
    public final float[] a() {
        return this.f9644a;
    }

    public final void b(@os.l float[] fArr) {
        l0.p(fArr, dc.d.f3685p);
        this.f9645b.position(0);
        this.f9645b.put(fArr);
    }

    public final void c(int i10) {
        this.f9645b.position(0);
        GLES20.glVertexAttribPointer(i10, 2, 5126, false, 0, (Buffer) this.f9645b);
        GLES20.glEnableVertexAttribArray(i10);
    }
}
