package l3;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f7320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f7321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w2 f7322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7323d;
    public static final boolean e;
    public static final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f7324g;

    /* JADX WARN: Code duplicated, block: B:11:0x004a  */
    /* JADX WARN: Code duplicated, block: B:4:0x001c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0165 A[PHI: r0
      0x0165: PHI (r0v42 java.lang.reflect.Field) = (r0v35 java.lang.reflect.Field), (r0v37 java.lang.reflect.Field) binds: [B:43:0x0153, B:49:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        w2 u2Var;
        Field declaredField;
        boolean z2;
        boolean z3;
        Field declaredField2;
        Field field;
        w2 w2Var;
        Unsafe unsafeJ = j();
        f7320a = unsafeJ;
        int i8 = s.f7291a;
        f7321b = Memory.class;
        Class cls = Long.TYPE;
        boolean zS = s(cls);
        boolean zS2 = s(Integer.TYPE);
        if (unsafeJ == null) {
            u2Var = null;
        } else if (zS) {
            u2Var = new v2(unsafeJ);
        } else if (zS2) {
            u2Var = new u2(unsafeJ);
        } else {
            u2Var = null;
        }
        f7322c = u2Var;
        if (u2Var == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls2 = u2Var.f7319a.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                try {
                    declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
                } catch (Throwable unused) {
                    declaredField = null;
                }
                if (declaredField == null) {
                    try {
                        declaredField = Buffer.class.getDeclaredField("address");
                    } catch (Throwable unused2) {
                        declaredField = null;
                    }
                    if (declaredField == null || declaredField.getType() != Long.TYPE) {
                        declaredField = null;
                    }
                }
                if (declaredField == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } catch (Throwable th2) {
                Logger.getLogger(x2.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
            }
        }
        f7323d = z2;
        w2 w2Var2 = f7322c;
        if (w2Var2 == null) {
            z3 = false;
        } else {
            try {
                Class<?> cls3 = w2Var2.f7319a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z3 = true;
            } catch (Throwable th3) {
                Logger.getLogger(x2.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th3.toString()));
                z3 = false;
            }
        }
        e = z3;
        f = u(byte[].class);
        u(boolean[].class);
        a(boolean[].class);
        u(int[].class);
        a(int[].class);
        u(long[].class);
        a(long[].class);
        u(float[].class);
        a(float[].class);
        u(double[].class);
        a(double[].class);
        u(Object[].class);
        a(Object[].class);
        int i9 = s.f7291a;
        try {
            declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        if (declaredField2 == null) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("address");
            } catch (Throwable unused4) {
                declaredField2 = null;
            }
            if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
                field = null;
            } else {
                field = declaredField2;
            }
        } else {
            field = declaredField2;
        }
        if (field != null && (w2Var = f7322c) != null) {
            w2Var.f7319a.objectFieldOffset(field);
        }
        f7324g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Class cls) {
        if (e) {
            f7322c.f7319a.arrayIndexScale(cls);
        }
    }

    public static void b(Object obj, long j8, byte b9) {
        w2 w2Var = f7322c;
        long j10 = (-4) & j8;
        int i8 = w2Var.f7319a.getInt(obj, j10);
        int i9 = ((~((int) j8)) & 3) << 3;
        w2Var.f7319a.putInt(obj, j10, ((255 & b9) << i9) | (i8 & (~(255 << i9))));
    }

    public static void c(Object obj, long j8, byte b9) {
        w2 w2Var = f7322c;
        long j10 = (-4) & j8;
        int i8 = (((int) j8) & 3) << 3;
        w2Var.f7319a.putInt(obj, j10, ((255 & b9) << i8) | (w2Var.f7319a.getInt(obj, j10) & (~(255 << i8))));
    }

    public static double d(long j8, Object obj) {
        return f7322c.a(j8, obj);
    }

    public static float e(long j8, Object obj) {
        return f7322c.b(j8, obj);
    }

    public static int f(long j8, Object obj) {
        return f7322c.f7319a.getInt(obj, j8);
    }

    public static long g(long j8, Object obj) {
        return f7322c.f7319a.getLong(obj, j8);
    }

    public static Object h(Class cls) {
        try {
            return f7320a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static Object i(long j8, Object obj) {
        return f7322c.f7319a.getObject(obj, j8);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new t2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(Object obj, long j8, boolean z2) {
        f7322c.c(obj, j8, z2);
    }

    public static void l(Object obj, long j8, double d7) {
        f7322c.e(obj, j8, d7);
    }

    public static void m(Object obj, long j8, float f4) {
        f7322c.f(obj, j8, f4);
    }

    public static void n(int i8, long j8, Object obj) {
        f7322c.f7319a.putInt(obj, j8, i8);
    }

    public static void o(Object obj, long j8, long j10) {
        f7322c.f7319a.putLong(obj, j8, j10);
    }

    public static void p(long j8, Object obj, Object obj2) {
        f7322c.f7319a.putObject(obj, j8, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean q(long j8, Object obj) {
        return ((byte) ((f7322c.f7319a.getInt(obj, (-4) & j8) >>> ((int) (((~j8) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean r(long j8, Object obj) {
        return ((byte) ((f7322c.f7319a.getInt(obj, (-4) & j8) >>> ((int) ((j8 & 3) << 3))) & 255)) != 0;
    }

    public static boolean s(Class cls) {
        int i8 = s.f7291a;
        try {
            Class cls2 = f7321b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean t(long j8, Object obj) {
        return f7322c.g(j8, obj);
    }

    public static int u(Class cls) {
        if (e) {
            return f7322c.f7319a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
