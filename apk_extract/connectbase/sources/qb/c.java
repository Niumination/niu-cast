package qb;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13893c = "TranLatencyTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qe.c f13894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a9.c f13895b;

    public String a(int i10) {
        return b(fc.b.a.B).b(i10);
    }

    public kh.c b(String str) {
        if (fc.b.b(str)) {
            qe.c cVar = this.f13894a;
            if (cVar != null) {
                return cVar;
            }
            qe.c cVar2 = new qe.c();
            this.f13894a = cVar2;
            return cVar2;
        }
        dc.e.f(f13893c, "TranAospLatencyTracker");
        a9.c cVar3 = this.f13895b;
        if (cVar3 != null) {
            return cVar3;
        }
        a9.c cVar4 = new a9.c();
        this.f13895b = cVar4;
        return cVar4;
    }

    public void c(int i10, int i11) {
        b(fc.b.a.B).a(i10, i11);
    }

    public void d(int i10) {
        b(fc.b.a.B).c(i10);
    }

    public void e(int i10) {
        b(fc.b.a.B).d(i10);
    }

    public void f(int i10, String str) {
        if (str == null) {
            throw new IllegalArgumentException("tag is null");
        }
        b(fc.b.a.B).e(i10, str);
    }
}
