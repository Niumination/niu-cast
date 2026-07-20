package za;

import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21878c = 4194304;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21879d = 4194560;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zd.a f21880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j8.a f21881b;

    public tg.a a(String str) {
        if (b.b(str)) {
            zd.a aVar = this.f21880a;
            if (aVar != null) {
                return aVar;
            }
            zd.a aVar2 = new zd.a();
            this.f21880a = aVar2;
            return aVar2;
        }
        j8.a aVar3 = this.f21881b;
        if (aVar3 != null) {
            return aVar3;
        }
        j8.a aVar4 = new j8.a();
        this.f21881b = aVar4;
        return aVar4;
    }

    public int b(int i10, int i11, int[] iArr) {
        if (iArr != null) {
            return a(b.a.f5989i).a(i10, i11, iArr);
        }
        throw new IllegalArgumentException("invalid list");
    }

    public void c(int i10) {
        a(b.a.f5989i).b(i10);
    }
}
