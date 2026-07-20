package rb;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14444c = "t";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.t f14445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.q f14446b;

    @yb.a(level = 1)
    public void a(IBinder iBinder, String str, String str2) {
        b(fc.b.a.f5989i).a(iBinder, str, str2);
    }

    public lh.q b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14444c, "TranThubToastPresenter");
            re.t tVar = this.f14445a;
            if (tVar != null) {
                return tVar;
            }
            re.t tVar2 = new re.t();
            this.f14445a = tVar2;
            return tVar2;
        }
        dc.e.f(f14444c, "TranAospToastPresenter");
        b9.q qVar = this.f14446b;
        if (qVar != null) {
            return qVar;
        }
        b9.q qVar2 = new b9.q();
        this.f14446b = qVar2;
        return qVar2;
    }
}
