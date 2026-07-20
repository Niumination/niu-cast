package z4;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @SerializedName("dpi")
    private final int dpi;

    @SerializedName("height")
    private final int height;

    @SerializedName("orientation")
    private final int orientation;

    @SerializedName(RtspHeaders.Values.PORT)
    private final int port;

    @SerializedName("width")
    private final int width;

    public c(int i10, int i11, int i12, int i13, int i14) {
        this.width = i10;
        this.height = i11;
        this.orientation = i12;
        this.dpi = i13;
        this.port = i14;
    }

    public static c g(c cVar, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = cVar.width;
        }
        if ((i15 & 2) != 0) {
            i11 = cVar.height;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = cVar.orientation;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = cVar.dpi;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = cVar.port;
        }
        cVar.getClass();
        return new c(i10, i16, i17, i18, i14);
    }

    public final int a() {
        return this.width;
    }

    public final int b() {
        return this.height;
    }

    public final int c() {
        return this.orientation;
    }

    public final int d() {
        return this.dpi;
    }

    public final int e() {
        return this.port;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.width == cVar.width && this.height == cVar.height && this.orientation == cVar.orientation && this.dpi == cVar.dpi && this.port == cVar.port;
    }

    @os.l
    public final c f(int i10, int i11, int i12, int i13, int i14) {
        return new c(i10, i11, i12, i13, i14);
    }

    public final int h() {
        return this.dpi;
    }

    public int hashCode() {
        return Integer.hashCode(this.port) + k0.d.a(this.dpi, k0.d.a(this.orientation, k0.d.a(this.height, Integer.hashCode(this.width) * 31, 31), 31), 31);
    }

    public final int i() {
        return this.height;
    }

    public final int j() {
        return this.orientation;
    }

    public final int k() {
        return this.port;
    }

    public final int l() {
        return this.width;
    }

    @os.l
    public String toString() {
        int i10 = this.width;
        int i11 = this.height;
        int i12 = this.orientation;
        int i13 = this.dpi;
        int i14 = this.port;
        StringBuilder sbA = i0.a.a("ExtendMirrorInfo(width=", i10, ", height=", i11, ", orientation=");
        sbA.append(i12);
        sbA.append(", dpi=");
        sbA.append(i13);
        sbA.append(", port=");
        return c.a.a(sbA, i14, ")");
    }
}
