package z9;

import android.hardware.fingerprint.FingerprintManager;
import android.text.TextUtils;
import com.transsion.hubsdk.api.hardware.fingerprint.TranFingerprintInfo;
import dc.e;
import fc.b;
import gm.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21873c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21874d = "package name should not be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21875e = "userId is wrong";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ad.a f21876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i7.a f21877b;

    public void a(boolean z10) throws ac.a {
        g(b.a.A).b(z10);
    }

    @yb.a(level = 2)
    public TranFingerprintInfo b(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return g(b.a.f6001u).l(i10);
    }

    public String c(int i10) {
        return g(b.a.f5987g).h(i10);
    }

    public int d(int i10) {
        return g(b.a.f5987g).o(i10);
    }

    public int e(FingerprintManager.AuthenticationResult authenticationResult) {
        return g(b.a.f5987g).j(authenticationResult);
    }

    public List<TranFingerprintInfo> f(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return g(b.a.f5987g).c(i10);
    }

    public tf.a g(String str) {
        if (b.b(str)) {
            e.f(f21873c, "TranThubFingerprintManager");
            ad.a aVar = this.f21876a;
            if (aVar != null) {
                return aVar;
            }
            ad.a aVar2 = new ad.a();
            this.f21876a = aVar2;
            return aVar2;
        }
        e.f(f21873c, "TranAospFingerprintManager");
        i7.a aVar3 = this.f21877b;
        if (aVar3 != null) {
            return aVar3;
        }
        i7.a aVar4 = new i7.a();
        this.f21877b = aVar4;
        return aVar4;
    }

    @yb.a(level = 1)
    public boolean h() {
        return g(b.a.f5989i).a();
    }

    public boolean i() {
        return g(b.a.f6001u).n();
    }

    @yb.a(level = 1)
    public void j(boolean z10) {
        g(b.a.f5989i).g(z10);
    }

    public void k(int i10, String str, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i11 <= Integer.MIN_VALUE || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        g(b.a.f5987g).m(i10, str, i11);
    }

    public void l(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parameter opPackageName must not be null or empty.");
        }
        g(b.a.f6001u).d(i10, str);
    }

    public void m(boolean z10) {
        g(b.a.f6001u).k(z10);
    }

    @yb.a(level = 2)
    public void n(@i String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parameter opPackageName must not be null or empty.");
        }
        g(b.a.f5987g).i(str, z10);
    }

    public void o(int i10) {
        g(b.a.E).f(i10);
    }

    public void p(int i10) {
        g(b.a.f6001u).e(i10);
    }
}
