package m5;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10407c;

    public b() {
    }

    public int a() {
        return this.f10407c;
    }

    public int b() {
        return this.f10406b;
    }

    public int c() {
        return this.f10405a;
    }

    public void d(int i10) {
        this.f10407c = i10;
    }

    public void e(int i10) {
        this.f10406b = i10;
    }

    public void f(int i10) {
        this.f10405a = i10;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileChannelInfo{oldPort=");
        sb2.append(this.f10405a);
        sb2.append(", filePort=");
        sb2.append(this.f10406b);
        sb2.append(", controlPort=");
        return u.a.a(sb2, this.f10407c, rs.f.f14860b);
    }

    public b(int i10, int i11, int i12) {
        this.f10405a = i10;
        this.f10406b = i11;
        this.f10407c = i12;
    }
}
