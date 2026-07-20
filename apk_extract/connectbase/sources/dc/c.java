package dc;

import java.util.HashMap;
import java.util.Map;
import ks.g;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f3666b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Boolean> f3667c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3668d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f3669e = null;

    public c(String str) {
        this.f3665a = str;
    }

    public final boolean a() {
        try {
            Class.forName(this.f3665a);
            return true;
        } catch (ClassNotFoundException | Exception unused) {
            return false;
        }
    }

    public final boolean b(String str) {
        try {
            Class.forName(this.f3665a).getField(str);
            return true;
        } catch (NoSuchFieldException | Exception unused) {
            return false;
        }
    }

    public final boolean c(String str, Class<?>[] clsArr) {
        try {
            Class.forName(this.f3665a).getMethod(str, clsArr);
            return true;
        } catch (NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public void d() {
        synchronized (this.f3668d) {
            this.f3666b.clear();
            this.f3667c.clear();
            this.f3669e = null;
        }
    }

    public final String e(String str, Class<?>[] clsArr) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append("(");
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(g.f9491d);
            }
            sb2.append(clsArr[i10].getSimpleName());
        }
        sb2.append(")");
        return sb2.toString();
    }

    public String f() {
        return this.f3665a;
    }

    public boolean g(String str) {
        if (this.f3666b.containsKey(str)) {
            return this.f3666b.get(str).booleanValue();
        }
        synchronized (this.f3668d) {
            try {
                if (this.f3666b.containsKey(str)) {
                    return this.f3666b.get(str).booleanValue();
                }
                if (this.f3669e == null) {
                    this.f3669e = Boolean.valueOf(a());
                }
                if (!this.f3669e.booleanValue()) {
                    this.f3666b.put(str, Boolean.FALSE);
                    return false;
                }
                boolean zB = b(str);
                this.f3666b.put(str, Boolean.valueOf(zB));
                return zB;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean h(String str) {
        return i(str, new Class[0]);
    }

    public boolean i(String str, Class<?>[] clsArr) {
        String strE = e(str, clsArr);
        if (this.f3667c.containsKey(strE)) {
            return this.f3667c.get(strE).booleanValue();
        }
        synchronized (this.f3668d) {
            try {
                if (this.f3667c.containsKey(strE)) {
                    return this.f3667c.get(strE).booleanValue();
                }
                if (this.f3669e == null) {
                    this.f3669e = Boolean.valueOf(a());
                }
                if (!this.f3669e.booleanValue()) {
                    this.f3667c.put(strE, Boolean.FALSE);
                    return false;
                }
                boolean zC = c(str, clsArr);
                this.f3667c.put(strE, Boolean.valueOf(zC));
                return zC;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
