package b7;

import android.content.Context;
import java.lang.reflect.Method;
import p6.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements mf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f753a = "a";

    @Override // mf.a
    public boolean a(String str, Context context) {
        Method methodG;
        Class clsA = cc.a.a("com.transsion.hubsdk.factorymode.TranFactoryModeManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "isFactoryCode", String.class, Context.class)) == null) {
            return false;
        }
        try {
            return ((Boolean) cc.a.j(methodG, clsA.newInstance(), str, context)).booleanValue();
        } catch (Exception e10) {
            b.a(" isFactoryCode fail:", e10, f753a);
            return false;
        }
    }
}
