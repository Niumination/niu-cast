package ib;

import android.telecom.PhoneAccountHandle;
import dc.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7764c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ie.b f7765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s8.b f7766b;

    public boolean a() {
        return d(fc.b.a.f5988h).a();
    }

    @yb.a(level = 1)
    public List<PhoneAccountHandle> b() {
        return d(fc.b.a.f5989i).c();
    }

    public String c(int i10) {
        return d(fc.b.a.f5987g).f(i10);
    }

    public ch.b d(String str) {
        if (fc.b.b(str)) {
            e.f(f7764c, "TranThubTelecomManager");
            ie.b bVar = this.f7765a;
            if (bVar != null) {
                return bVar;
            }
            ie.b bVar2 = new ie.b();
            this.f7765a = bVar2;
            return bVar2;
        }
        e.f(f7764c, "TranAospTelecomManager");
        s8.b bVar3 = this.f7766b;
        if (bVar3 != null) {
            return bVar3;
        }
        s8.b bVar4 = new s8.b();
        this.f7766b = bVar4;
        return bVar4;
    }

    public boolean e() {
        return d(fc.b.a.f5982b).e();
    }

    @yb.a(level = 1)
    public boolean f(String str) {
        return d(fc.b.a.f5989i).b(str);
    }

    @yb.a(level = 1)
    public void g(PhoneAccountHandle phoneAccountHandle) {
        d(fc.b.a.f5989i).d(phoneAccountHandle);
    }
}
