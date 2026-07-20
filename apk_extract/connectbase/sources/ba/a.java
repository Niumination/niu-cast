package ba;

import cd.c;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f801c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k7.a f803b;

    public vf.a a(String str) {
        if (b.b(str)) {
            e.f(f801c, "TranThubSensorPrivacyManager");
            c cVar = this.f802a;
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            this.f802a = cVar2;
            return cVar2;
        }
        e.f(f801c, "TranAospSensorPrivacyManager");
        k7.a aVar = this.f803b;
        if (aVar != null) {
            return aVar;
        }
        k7.a aVar2 = new k7.a();
        this.f803b = aVar2;
        return aVar2;
    }

    public boolean b(int i10, int i11) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("toggleType is wrong");
        }
        if (i11 <= Integer.MIN_VALUE || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("sensor is wrong");
        }
        return a(b.a.f5992l).a(i10, i11);
    }

    public void c(int i10, boolean z10) {
        a(b.a.f5995o).b(i10, z10);
    }
}
