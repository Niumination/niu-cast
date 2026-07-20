package l2;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final o f9680a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f9681b = "TextureUtil";

    public final int a(@os.m Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            return 0;
        }
        if (bitmap == null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            return 0;
        }
        if (bitmap.isRecycled()) {
            a.f9640a.b(f9681b, "bitmap isRecycled");
            return 0;
        }
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public final void b(int i10) {
        if (i10 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        }
    }
}
