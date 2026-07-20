package v4;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    @SerializedName("count")
    private int mCount;

    public b(int i10) {
        this.mCount = i10;
    }

    public int a() {
        return this.mCount;
    }

    public void b(int i10) {
        this.mCount = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("Heartbeat{count="), this.mCount, rs.f.f14860b);
    }
}
