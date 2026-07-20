package o2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    @SerializedName("height")
    private int mHeight;

    @SerializedName("width")
    private int mWidth;

    public f(int i10, int i11) {
        this.mWidth = i10;
        this.mHeight = i11;
    }

    public int a() {
        return this.mHeight;
    }

    public int b() {
        return this.mWidth;
    }

    public void c(int i10) {
        this.mHeight = i10;
    }

    public void d(int i10) {
        this.mWidth = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ScreenConfig{width=");
        sb2.append(this.mWidth);
        sb2.append(", height=");
        return u.a.a(sb2, this.mHeight, rs.f.f14860b);
    }
}
