package p6;

import android.content.res.Configuration;
import android.graphics.Rect;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class w implements bf.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13020a = "w";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13021b = cc.a.a("android.app.WindowConfiguration");

    @Override // bf.s
    public boolean a(int i10) {
        Object objJ = cc.a.j(cc.a.g(f13021b, "inMultiWindowMode", Integer.TYPE), null, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.s
    public Rect b(Configuration configuration) {
        Object objF = cc.a.f(cc.a.d(configuration.getClass(), "windowConfiguration"), configuration);
        if (objF != null) {
            return (Rect) cc.a.j(cc.a.g(objF.getClass(), "getBounds", new Class[0]), objF, new Object[0]);
        }
        return null;
    }

    @Override // bf.s
    public boolean c(Configuration configuration) {
        Object objF;
        Method methodG;
        Method methodG2 = cc.a.g(configuration.getClass(), "isThunderbackWindow", new Class[0]);
        if (methodG2 != null) {
            Object objJ = cc.a.j(methodG2, configuration, new Object[0]);
            if (objJ instanceof Boolean) {
                return ((Boolean) objJ).booleanValue();
            }
            return false;
        }
        Field fieldD = cc.a.d(configuration.getClass(), "windowConfiguration");
        if (fieldD == null || (objF = cc.a.f(fieldD, configuration)) == null || (methodG = cc.a.g(objF.getClass(), "isThunderbackWindow", new Class[0])) == null) {
            return false;
        }
        Object objJ2 = cc.a.j(methodG, objF, new Object[0]);
        if (objJ2 instanceof Boolean) {
            return ((Boolean) objJ2).booleanValue();
        }
        return false;
    }
}
