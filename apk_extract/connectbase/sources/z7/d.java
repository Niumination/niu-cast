package z7;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.internal.annotations.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class d implements kg.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21868c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21869a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21870b;

    public d() {
        try {
            this.f21870b = cc.a.g(cc.a.a("android.net.NetworkPolicyManager"), TypedValues.TransitionType.S_FROM, Context.class).invoke(null, this.f21869a);
        } catch (Throwable th2) {
            m7.a.a("TranAospNetworkPolicyManager fail ", th2, f21868c);
        }
    }

    @Override // kg.c
    public int a(int i10) {
        Object objJ;
        Object obj = this.f21870b;
        if (obj == null || (objJ = cc.a.j(cc.a.g(obj.getClass(), "getUidPolicy", Integer.TYPE), this.f21870b, Integer.valueOf(i10))) == null) {
            return 0;
        }
        return ((Integer) objJ).intValue();
    }

    @Override // kg.c
    public void b(boolean z10) {
        try {
            Object obj = this.f21870b;
            if (obj != null) {
                cc.a.g(obj.getClass(), "setRestrictBackground", Boolean.class).invoke(this.f21870b, Boolean.valueOf(z10));
            }
        } catch (Throwable th2) {
            m7.a.a("setRestrictBackground fail ", th2, f21868c);
        }
    }

    @Override // kg.c
    public boolean c() {
        Object obj = this.f21870b;
        if (obj == null) {
            return false;
        }
        Object objJ = cc.a.j(cc.a.g(obj.getClass(), "getRestrictBackground", new Class[0]), this.f21870b, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // kg.c
    public void d(int i10, int i11) {
        Object obj = this.f21870b;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            cc.a.j(cc.a.g(cls, "setUidPolicy", cls2, cls2), this.f21870b, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @VisibleForTesting
    public void e(Object obj) {
        this.f21870b = obj;
    }
}
