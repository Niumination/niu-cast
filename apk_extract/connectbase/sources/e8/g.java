package e8;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements pg.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4106c = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ClassLoader f4107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ClassLoader f4108b = null;

    public g() {
        e();
    }

    @Override // pg.g
    public byte a(String str, int i10, List list) {
        Class clsB = cc.a.b("vendor.mediatek.hardware.nvram.V1_1.INvram", this.f4108b);
        Object objJ = cc.a.j(cc.a.g(cc.a.b("vendor.mediatek.hardware.nvram.V1_1.INvram$Proxy", this.f4108b), "writeFileByNamevec", String.class, Integer.TYPE, ArrayList.class), cc.a.j(cc.a.g(clsB, "getService", Boolean.TYPE), clsB, Boolean.TRUE), str, Integer.valueOf(i10), (ArrayList) list);
        if (objJ instanceof Byte) {
            return ((Byte) objJ).byteValue();
        }
        return (byte) 0;
    }

    @Override // pg.g
    public boolean b() {
        return false;
    }

    @Override // pg.g
    public String c(String str, int i10) {
        Class clsB = cc.a.b("vendor.mediatek.hardware.nvram.V1_1.INvram", this.f4108b);
        Object objJ = cc.a.j(cc.a.g(cc.a.b("vendor.mediatek.hardware.nvram.V1_1.INvram$Proxy", this.f4108b), "readFileByName", String.class, Integer.TYPE), cc.a.j(cc.a.g(clsB, "getService", Boolean.TYPE), clsB, Boolean.TRUE), str, Integer.valueOf(i10));
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // pg.g
    public boolean d(String str) {
        return false;
    }

    public final ClassLoader e() {
        try {
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            this.f4107a = parent;
            Class<?> cls = Class.forName("com.android.internal.os.ZygoteInit", true, parent);
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Object objJ = cc.a.j(cc.a.g(cls, "getOrCreateSystemServerClassLoader", new Class[0]), declaredConstructor.newInstance(null), new Object[0]);
            if (objJ instanceof ClassLoader) {
                this.f4108b = (ClassLoader) objJ;
            }
        } catch (Exception e10) {
            p6.b.a("getSystemServerClassLoader fail ", e10, f4106c);
        }
        return this.f4108b;
    }
}
