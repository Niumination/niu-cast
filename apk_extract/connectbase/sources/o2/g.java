package o2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    @SerializedName("orientation")
    private int mOrientation;

    public g(int i10) {
        this.mOrientation = i10;
    }

    public int a() {
        return this.mOrientation;
    }

    public void b(int i10) {
        this.mOrientation = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("RequestResolution{signal="), this.mOrientation, rs.f.f14860b);
    }
}
