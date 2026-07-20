package rb;

import android.view.KeyEvent;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14385c = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.j f14386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.i f14387b;

    public lh.e a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14385c, "TranThubTranKeyEvent");
            re.j jVar = this.f14386a;
            if (jVar != null) {
                return jVar;
            }
            re.j jVar2 = new re.j();
            this.f14386a = jVar2;
            return jVar2;
        }
        dc.e.f(f14385c, "TranAospTranKeyEvent");
        b9.i iVar = this.f14387b;
        if (iVar != null) {
            return iVar;
        }
        b9.i iVar2 = new b9.i();
        this.f14387b = iVar2;
        return iVar2;
    }

    public KeyEvent b(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str) {
        return a(fc.b.a.f5989i).a(j10, j11, i10, i11, i12, i13, i14, i15, i16, i17, i18, str);
    }
}
