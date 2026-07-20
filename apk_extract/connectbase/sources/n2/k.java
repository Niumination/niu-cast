package n2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11303a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11304b = 2;

    @SerializedName("orientation")
    private int mOrientation;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    @SerializedName("rotateWindow")
    private boolean mRotateWindow;

    public k() {
    }

    public int a() {
        return this.mOrientation;
    }

    public int b() {
        return this.mPort;
    }

    public boolean c() {
        return this.mRotateWindow;
    }

    public void d(int i10) {
        this.mOrientation = i10;
    }

    public void e(int i10) {
        this.mPort = i10;
    }

    public void f(boolean z10) {
        this.mRotateWindow = z10;
    }

    public String toString() {
        return "DisplayOrientationChangeDto{orientation=" + this.mOrientation + ", port=" + this.mPort + ", rotateWindow=" + this.mRotateWindow + rs.f.f14860b;
    }

    public k(int i10, int i11, boolean z10) {
        this.mOrientation = i10;
        this.mPort = i11;
        this.mRotateWindow = z10;
    }
}
