package j1;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@l
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f8468b = false;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b implements c {
        public static final b INSTANCE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f8469a;

        public final enum a extends b {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // j1.z.c
            public long getLongLittleEndian(byte[] source, int offset) {
                return o1.n.k(source[offset + 7], source[offset + 6], source[offset + 5], source[offset + 4], source[offset + 3], source[offset + 2], source[offset + 1], source[offset]);
            }

            @Override // j1.z.c
            public void putLongLittleEndian(byte[] sink, int offset, long value) {
                long j10 = 255;
                for (int i10 = 0; i10 < 8; i10++) {
                    sink[offset + i10] = (byte) ((value & j10) >> (i10 * 8));
                    j10 <<= 8;
                }
            }
        }

        static {
            a aVar = new a("INSTANCE", 0);
            INSTANCE = aVar;
            f8469a = new b[]{aVar};
        }

        public b(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{INSTANCE};
        }

        public static b valueOf(String name) {
            return (b) Enum.valueOf(b.class, name);
        }

        public static b[] values() {
            return (b[]) f8469a.clone();
        }

        public b(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public interface c {
        long getLongLittleEndian(byte[] array, int offset);

        void putLongLittleEndian(byte[] array, int offset, long value);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f8470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8471b;
        public static final d UNSAFE_LITTLE_ENDIAN = new a("UNSAFE_LITTLE_ENDIAN", 0);
        public static final d UNSAFE_BIG_ENDIAN = new b("UNSAFE_BIG_ENDIAN", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ d[] f8472c = b();

        public final enum a extends d {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // j1.z.c
            public long getLongLittleEndian(byte[] array, int offset) {
                return d.f8470a.getLong(array, ((long) offset) + ((long) d.f8471b));
            }

            @Override // j1.z.c
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                d.f8470a.putLong(array, ((long) offset) + ((long) d.f8471b), value);
            }
        }

        public final enum b extends d {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // j1.z.c
            public long getLongLittleEndian(byte[] array, int offset) {
                return Long.reverseBytes(d.f8470a.getLong(array, ((long) offset) + ((long) d.f8471b)));
            }

            @Override // j1.z.c
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                d.f8470a.putLong(array, ((long) offset) + ((long) d.f8471b), Long.reverseBytes(value));
            }
        }

        static {
            Unsafe unsafeD = d();
            f8470a = unsafeD;
            f8471b = unsafeD.arrayBaseOffset(byte[].class);
            if (unsafeD.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        public d(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ d[] b() {
            return new d[]{UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN};
        }

        public static Unsafe d() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: j1.a0
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        return z.d.f();
                    }
                });
            }
        }

        public static /* synthetic */ Unsafe f() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        public static d valueOf(String name) {
            return (d) Enum.valueOf(d.class, name);
        }

        public static d[] values() {
            return (d[]) f8472c.clone();
        }

        public d(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    static {
        c cVar = b.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                cVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? d.UNSAFE_LITTLE_ENDIAN : d.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        f8467a = cVar;
    }

    public static int a(byte[] source, int offset) {
        return ((source[offset + 3] & 255) << 24) | (source[offset] & 255) | ((source[offset + 1] & 255) << 8) | ((source[offset + 2] & 255) << 16);
    }

    public static long b(byte[] input, int offset) {
        return f8467a.getLongLittleEndian(input, offset);
    }

    public static long c(byte[] input, int offset, int length) {
        int iMin = Math.min(length, 8);
        long j10 = 0;
        for (int i10 = 0; i10 < iMin; i10++) {
            j10 |= (((long) input[offset + i10]) & 255) << (i10 * 8);
        }
        return j10;
    }

    public static void d(byte[] sink, int offset, long value) {
        f8467a.putLongLittleEndian(sink, offset, value);
    }

    public static boolean e() {
        return f8467a instanceof d;
    }
}
