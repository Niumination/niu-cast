package va;

import android.os.UserHandle;
import android.text.TextUtils;
import com.transsion.hubsdk.api.os.TranUserInfo;
import java.util.List;
import java.util.Set;
import vd.a1;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16850c = "x";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16851d = "package name should not be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f16852e = "userId is wrong";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16853f = "userType is null";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16854g = "flags is wrong";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16855h = "key should not be null";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16856i = "android.os.usertype.profile.MANAGED";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16857j = "android.os.usertype.profile.CLONE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f16858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.y f16859b;

    public boolean a(int i10, boolean z10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return j(fc.b.a.f5987g).i(i10, z10);
    }

    public boolean b(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f16853f);
        }
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return j(fc.b.a.f5987g).j(str, i10);
    }

    public UserHandle c(String str, String str2, Set<String> set) {
        if (str2 == null || set == null) {
            throw new NullPointerException("params cannot be null");
        }
        return j(fc.b.a.f5991k).e(str, str2, (String[]) set.toArray(new String[set.size()]));
    }

    public TranUserInfo d(String str, String str2, int i10, int i11, String[] strArr) {
        if (str2 != null) {
            return j(fc.b.a.f6006z).m(str, str2, i10, i11, strArr);
        }
        throw new IllegalArgumentException("userType can not be null");
    }

    @gm.j
    @yb.a(level = 2)
    public TranUserInfo e(String str, String str2, int i10, int i11, String[] strArr) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(f16853f);
        }
        if (i11 <= Integer.MIN_VALUE || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return j(fc.b.a.f5987g).b(str, str2, i10, i11, strArr);
    }

    public List<UserHandle> f() {
        return j(fc.b.a.f5995o).l();
    }

    public int g(int i10) {
        return j(fc.b.a.f5982b).h(i10);
    }

    public int[] h(int i10) {
        return j(fc.b.a.f5982b).c(i10);
    }

    @gm.j
    @yb.a(level = 2)
    public List<TranUserInfo> i(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return j(fc.b.a.f5987g).q(i10);
    }

    public pg.q j(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16850c, "TranThubUserManager");
            a1 a1Var = this.f16858a;
            if (a1Var != null) {
                return a1Var;
            }
            a1 a1Var2 = new a1();
            this.f16858a = a1Var2;
            return a1Var2;
        }
        dc.e.f(f16850c, "TranAospUserManager");
        e8.y yVar = this.f16859b;
        if (yVar != null) {
            return yVar;
        }
        e8.y yVar2 = new e8.y();
        this.f16859b = yVar2;
        return yVar2;
    }

    @yb.a(level = 1)
    public TranUserInfo k(int i10) {
        if (i10 < Integer.MAX_VALUE) {
            return j(fc.b.a.f5988h).a(i10);
        }
        throw new IllegalArgumentException("userId is wrong");
    }

    public List<TranUserInfo> l() {
        return j(fc.b.a.f5988h).k();
    }

    public List<TranUserInfo> m(boolean z10) {
        return j(fc.b.a.f5992l).o(z10);
    }

    public boolean n() {
        return j(fc.b.a.f5994n).n();
    }

    public boolean o(int i10) {
        return j(fc.b.a.f5991k).f(i10);
    }

    public boolean p(int i10) {
        if (i10 < Integer.MAX_VALUE) {
            return j(fc.b.a.f5988h).p(i10);
        }
        throw new IllegalArgumentException("userId is wrong");
    }

    @yb.a(level = 2)
    public boolean q(int i10) {
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return j(fc.b.a.f5987g).d(i10);
    }

    @yb.a(level = 1)
    public void r(String str, boolean z10, UserHandle userHandle) {
        if (str == null) {
            throw new IllegalArgumentException(f16855h);
        }
        j(fc.b.a.f5988h).g(str, z10, userHandle);
    }
}
