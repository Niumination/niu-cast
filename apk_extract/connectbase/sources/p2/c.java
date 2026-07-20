package p2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    @SerializedName(lb.f.f9782f)
    private int mVersion;

    public int a() {
        return this.mVersion;
    }

    public void b(int i10) {
        this.mVersion = i10;
    }

    public String toString() {
        return u.a.a(new StringBuilder("ConfirmFileVersionResponse{version="), this.mVersion, rs.f.f14860b);
    }
}
