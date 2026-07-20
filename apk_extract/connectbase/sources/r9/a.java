package r9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import fc.b;
import sc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14299c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14300d = "package name should not be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14301e = "userId is wrong";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z6.a f14303b;

    public Intent a(Intent intent) {
        return h(b.a.f5989i).i(intent);
    }

    public ComponentName b() {
        return h(b.a.f5995o).b();
    }

    public long c(ComponentName componentName, int i10) {
        return h(b.a.E).f(componentName, i10);
    }

    public ComponentName d() {
        return h(b.a.f5995o).e();
    }

    public ComponentName e(int i10) {
        return h(b.a.E).g(i10);
    }

    public ComponentName f(UserHandle userHandle) {
        if (userHandle != null) {
            return h(b.a.f6005y).d(userHandle);
        }
        throw new IllegalArgumentException("user is null");
    }

    public ComponentName g(Context context) {
        if (context != null) {
            return h(b.a.f5996p).j(context);
        }
        throw new IllegalArgumentException("Param context cannot be null");
    }

    public lf.a h(String str) {
        if (b.b(str)) {
            dc.e.f(f14299c, "TranThubDevicePolicyManager");
            e eVar = this.f14302a;
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e();
            this.f14302a = eVar2;
            return eVar2;
        }
        dc.e.f(f14299c, "TranAospDevicePolicyManager");
        z6.a aVar = this.f14303b;
        if (aVar != null) {
            return aVar;
        }
        z6.a aVar2 = new z6.a();
        this.f14303b = aVar2;
        return aVar2;
    }

    public boolean i(String str) {
        if (str == null) {
            return false;
        }
        return h(b.a.E).h(str);
    }

    public boolean j() throws ac.a {
        return h(b.a.f5996p).a();
    }

    @yb.a(level = 1)
    public void k(ComponentName componentName, int i10) {
        if (componentName == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i10 < 0 || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        h(b.a.f5987g).c(componentName, i10);
    }
}
