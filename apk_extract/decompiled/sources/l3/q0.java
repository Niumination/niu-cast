package l3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0 extends q {
    private static final Map zza = new ConcurrentHashMap();
    protected o2 zzc;
    private int zzd;

    public q0() {
        this.zzb = 0;
        this.zzd = -1;
        this.zzc = o2.f;
    }

    public static q0 e(Class cls) {
        Map map = zza;
        q0 q0Var = (q0) map.get(cls);
        if (q0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                q0Var = (q0) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (q0Var == null) {
            q0Var = (q0) ((q0) x2.h(cls)).n(6, null);
            if (q0Var == null) {
                throw new IllegalStateException();
            }
            map.put(cls, q0Var);
        }
        return q0Var;
    }

    public static Object f(Method method, q1 q1Var, Object... objArr) {
        try {
            return method.invoke(q1Var, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void h(Class cls, q0 q0Var) {
        q0Var.g();
        zza.put(cls, q0Var);
    }

    public static final boolean j(q0 q0Var, boolean z2) {
        byte bByteValue = ((Byte) q0Var.n(1, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zI = y1.f7325c.b(q0Var.getClass()).i(q0Var);
        if (z2) {
            q0Var.n(2, true == zI ? q0Var : null);
        }
        return zI;
    }

    @Override // l3.r1
    public final boolean a() {
        return j(this, true);
    }

    @Override // l3.q
    public final int b(f2 f2Var) {
        if (k()) {
            int iH = f2Var.h(this);
            if (iH >= 0) {
                return iH;
            }
            throw new IllegalStateException(a1.a.o(iH, "serialized size must be non-negative, was "));
        }
        int i8 = this.zzd & Integer.MAX_VALUE;
        if (i8 != Integer.MAX_VALUE) {
            return i8;
        }
        int iH2 = f2Var.h(this);
        if (iH2 < 0) {
            throw new IllegalStateException(a1.a.o(iH2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iH2;
        return iH2;
    }

    public final int c() {
        if (k()) {
            int iM = m(null);
            if (iM >= 0) {
                return iM;
            }
            throw new IllegalStateException(a1.a.o(iM, "serialized size must be non-negative, was "));
        }
        int iM2 = this.zzd & Integer.MAX_VALUE;
        if (iM2 == Integer.MAX_VALUE) {
            iM2 = m(null);
            if (iM2 < 0) {
                throw new IllegalStateException(a1.a.o(iM2, "serialized size must be non-negative, was "));
            }
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iM2;
        }
        return iM2;
    }

    public final m0 d() {
        return (m0) n(5, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return y1.f7325c.b(getClass()).c(this, (q0) obj);
    }

    public final void g() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (k()) {
            return y1.f7325c.b(getClass()).g(this);
        }
        int i8 = this.zzb;
        if (i8 != 0) {
            return i8;
        }
        int iG = y1.f7325c.b(getClass()).g(this);
        this.zzb = iG;
        return iG;
    }

    public final void i() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean k() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final void l(c0 c0Var) {
        f2 f2VarB = y1.f7325c.b(getClass());
        l1 l1Var = c0Var.f7207a;
        if (l1Var == null) {
            l1Var = new l1(c0Var);
        }
        f2VarB.e(this, l1Var);
    }

    public final int m(f2 f2Var) {
        if (f2Var != null) {
            return f2Var.h(this);
        }
        return y1.f7325c.b(getClass()).h(this);
    }

    public abstract Object n(int i8, q0 q0Var);

    public final String toString() {
        String string = super.toString();
        char[] cArr = s1.f7292a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        s1.c(this, sb2, 0);
        return sb2.toString();
    }
}
