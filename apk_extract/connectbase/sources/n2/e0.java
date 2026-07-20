package n2;

import com.google.gson.annotations.SerializedName;
import ik.y0;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {

    @SerializedName(y0.a.f8215h)
    private int type;

    @SerializedName("videoPort")
    private int videoPort;

    public e0(int i10, int i11) {
        this.videoPort = i10;
        this.type = i11;
    }

    public int a() {
        return this.type;
    }

    public int b() {
        return this.videoPort;
    }

    public void c(int i10) {
        this.type = i10;
    }

    public void d(int i10) {
        this.videoPort = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ShortcutKeyRequest{videoPort=");
        sb2.append(this.videoPort);
        sb2.append(", type=");
        return u.a.a(sb2, this.type, rs.f.f14860b);
    }
}
