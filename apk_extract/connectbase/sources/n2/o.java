package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    @SerializedName("navMode")
    private int mNavMode;

    public o() {
    }

    public int a() {
        return this.mNavMode;
    }

    public void b(int i10) {
        this.mNavMode = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("NavModeSyncRequest{navMode="), this.mNavMode, rs.f.f14860b);
    }

    public o(int i10) {
        this.mNavMode = i10;
    }
}
