package o2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    @SerializedName(dc.d.f3692w)
    private int mId;

    public b(int i10) {
        this.mId = i10;
    }

    public int a() {
        return this.mId;
    }

    public void b(int i10) {
        this.mId = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("ExtendScreenInfoRequest{id="), this.mId, rs.f.f14860b);
    }
}
