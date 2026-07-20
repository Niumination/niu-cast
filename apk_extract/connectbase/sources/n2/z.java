package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11338a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11339b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11340c = 3;

    @SerializedName("fromPort")
    private int mFromPort;

    @SerializedName("mode")
    private int mMode;

    @SerializedName("toPort")
    private int mToPort;

    public z() {
    }

    public int a() {
        return this.mFromPort;
    }

    public int b() {
        return this.mMode;
    }

    public int c() {
        return this.mToPort;
    }

    public void d(int i10) {
        this.mFromPort = i10;
    }

    public void e(int i10) {
        this.mMode = i10;
    }

    public void f(int i10) {
        this.mToPort = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ReparentContentRequest{fromPort=");
        sb2.append(this.mFromPort);
        sb2.append(", mode=");
        sb2.append(this.mMode);
        sb2.append(", toPort=");
        return u.a.a(sb2, this.mToPort, rs.f.f14860b);
    }

    public z(int i10, int i11, int i12) {
        this.mFromPort = i10;
        this.mMode = i11;
        this.mToPort = i12;
    }
}
