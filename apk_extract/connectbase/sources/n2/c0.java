package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    @SerializedName(dc.d.f3692w)
    private int mId;

    @SerializedName("orientation")
    private int mOrientation;

    public c0(int i10, int i11) {
        this.mId = i10;
        this.mOrientation = i11;
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
}
