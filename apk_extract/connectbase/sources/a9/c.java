package a9;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements kh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f190a = cc.a.a("com.android.internal.util.LatencyTracker");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f191b = bc.a.a();

    @Override // kh.c
    public void a(int i10, int i11) {
        Method methodG = cc.a.g(this.f190a, "getInstance", Context.class);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, null, this.f191b);
            Class cls = this.f190a;
            Class cls2 = Integer.TYPE;
            Method methodG2 = cc.a.g(cls, "logAction", cls2, cls2);
            if (objJ == null || methodG2 == null) {
                return;
            }
            cc.a.j(methodG2, objJ, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @Override // kh.c
    public String b(int i10) {
        String str;
        Method methodG = cc.a.g(this.f190a, "getNameOfAction", Integer.TYPE);
        return (methodG == null || (str = (String) cc.a.j(methodG, null, Integer.valueOf(i10))) == null) ? "" : str;
    }

    @Override // kh.c
    public void c(int i10) {
        Method methodG = cc.a.g(this.f190a, "getInstance", Context.class);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, null, this.f191b);
            Method methodG2 = cc.a.g(this.f190a, "onActionCancel", Integer.TYPE);
            if (objJ == null || methodG2 == null) {
                return;
            }
            cc.a.j(methodG2, objJ, Integer.valueOf(i10));
        }
    }

    @Override // kh.c
    public void d(int i10) {
        Method methodG = cc.a.g(this.f190a, "getInstance", Context.class);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, null, this.f191b);
            Method methodG2 = cc.a.g(this.f190a, "onActionEnd", Integer.TYPE);
            if (objJ == null || methodG2 == null) {
                return;
            }
            cc.a.j(methodG2, objJ, Integer.valueOf(i10));
        }
    }

    @Override // kh.c
    public void e(int i10, String str) {
        Method methodG = cc.a.g(this.f190a, "getInstance", Context.class);
        if (methodG != null) {
            Object objJ = cc.a.j(methodG, null, this.f191b);
            Method methodG2 = cc.a.g(this.f190a, "onActionStart", Integer.TYPE, String.class);
            if (objJ == null || methodG2 == null) {
                return;
            }
            cc.a.j(methodG2, objJ, Integer.valueOf(i10), str);
        }
    }
}
