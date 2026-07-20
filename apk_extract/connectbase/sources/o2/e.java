package o2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    @SerializedName(dc.d.f3692w)
    private int mId;

    @SerializedName("orientation")
    private int mOrientation;

    public e(int i10, int i11) {
        this.mOrientation = i10;
        this.mId = i11;
    }

    public int a() {
        return this.mId;
    }

    public int b() {
        return this.mOrientation;
    }

    public void c(int i10) {
        this.mId = i10;
    }

    public void d(int i10) {
        this.mOrientation = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ExtendedOrientationChangeRequest{orientation=");
        sb2.append(this.mOrientation);
        sb2.append(", id=");
        return u.a.a(sb2, this.mId, rs.f.f14860b);
    }
}
