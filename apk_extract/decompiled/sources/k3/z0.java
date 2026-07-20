package k3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements q4.e {
    public static final Charset f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f6732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f6733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y0 f6734i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f6735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f6737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f6738d;
    public final a1 e = new a1(this, 0);

    static {
        w0 w0Var = w0.DEFAULT;
        t0 t0Var = new t0(1, w0Var);
        HashMap map = new HashMap();
        map.put(x0.class, t0Var);
        f6732g = new q4.c("key", h0.a.s(map));
        t0 t0Var2 = new t0(2, w0Var);
        HashMap map2 = new HashMap();
        map2.put(x0.class, t0Var2);
        f6733h = new q4.c("value", h0.a.s(map2));
        f6734i = y0.f6717b;
    }

    public z0(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, y0 y0Var) {
        this.f6735a = byteArrayOutputStream;
        this.f6736b = map;
        this.f6737c = map2;
        this.f6738d = y0Var;
    }

    public static int f(q4.c cVar) {
        x0 x0Var = (x0) ((Annotation) cVar.f8962b.get(x0.class));
        if (x0Var != null) {
            return ((t0) x0Var).f6649a;
        }
        throw new q4.b("Field has no @Protobuf config");
    }

    @Override // q4.e
    public final q4.e a(q4.c cVar, Object obj) {
        c(cVar, obj, true);
        return this;
    }

    @Override // q4.e
    public final /* synthetic */ q4.e b(q4.c cVar, long j8) throws IOException {
        e(cVar, j8, true);
        return this;
    }

    public final void c(q4.c cVar, Object obj, boolean z2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z2 && charSequence.length() == 0) {
                return;
            }
            h((f(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            h(bytes.length);
            this.f6735a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                c(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                g(f6734i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z2 && dDoubleValue == 0.0d) {
                return;
            }
            h((f(cVar) << 3) | 1);
            this.f6735a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z2 && fFloatValue == 0.0f) {
                return;
            }
            h((f(cVar) << 3) | 5);
            this.f6735a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            e(cVar, ((Number) obj).longValue(), z2);
            return;
        }
        if (obj instanceof Boolean) {
            d(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z2);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z2 && bArr.length == 0) {
                return;
            }
            h((f(cVar) << 3) | 2);
            h(bArr.length);
            this.f6735a.write(bArr);
            return;
        }
        q4.d dVar = (q4.d) this.f6736b.get(obj.getClass());
        if (dVar != null) {
            g(dVar, cVar, obj, z2);
            return;
        }
        q4.f fVar = (q4.f) this.f6737c.get(obj.getClass());
        if (fVar != null) {
            a1 a1Var = this.e;
            a1Var.f6348b = false;
            a1Var.f6350d = cVar;
            a1Var.f6349c = z2;
            fVar.a(obj, a1Var);
            return;
        }
        if (obj instanceof v0) {
            d(cVar, ((v0) obj).zza(), true);
        } else if (obj instanceof Enum) {
            d(cVar, ((Enum) obj).ordinal(), true);
        } else {
            g(this.f6738d, cVar, obj, z2);
        }
    }

    public final void d(q4.c cVar, int i8, boolean z2) {
        if (z2 && i8 == 0) {
            return;
        }
        x0 x0Var = (x0) ((Annotation) cVar.f8962b.get(x0.class));
        if (x0Var == null) {
            throw new q4.b("Field has no @Protobuf config");
        }
        w0 w0Var = w0.DEFAULT;
        t0 t0Var = (t0) x0Var;
        int iOrdinal = t0Var.f6650b.ordinal();
        int i9 = t0Var.f6649a;
        if (iOrdinal == 0) {
            h(i9 << 3);
            h(i8);
        } else if (iOrdinal == 1) {
            h(i9 << 3);
            h((i8 + i8) ^ (i8 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((i9 << 3) | 5);
            this.f6735a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i8).array());
        }
    }

    public final void e(q4.c cVar, long j8, boolean z2) throws IOException {
        if (z2 && j8 == 0) {
            return;
        }
        x0 x0Var = (x0) ((Annotation) cVar.f8962b.get(x0.class));
        if (x0Var == null) {
            throw new q4.b("Field has no @Protobuf config");
        }
        w0 w0Var = w0.DEFAULT;
        t0 t0Var = (t0) x0Var;
        int iOrdinal = t0Var.f6650b.ordinal();
        int i8 = t0Var.f6649a;
        if (iOrdinal == 0) {
            h(i8 << 3);
            i(j8);
        } else if (iOrdinal == 1) {
            h(i8 << 3);
            i((j8 >> 63) ^ (j8 + j8));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            h((i8 << 3) | 1);
            this.f6735a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j8).array());
        }
    }

    public final void g(q4.d dVar, q4.c cVar, Object obj, boolean z2) throws IOException {
        u0 u0Var = new u0(0);
        u0Var.f6659b = 0L;
        try {
            OutputStream outputStream = this.f6735a;
            this.f6735a = u0Var;
            try {
                dVar.a(obj, this);
                this.f6735a = outputStream;
                long j8 = u0Var.f6659b;
                u0Var.close();
                if (z2 && j8 == 0) {
                    return;
                }
                h((f(cVar) << 3) | 2);
                i(j8);
                dVar.a(obj, this);
            } catch (Throwable th2) {
                this.f6735a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                u0Var.close();
            } catch (Throwable th4) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                } catch (Exception unused) {
                }
            }
            throw th3;
        }
    }

    public final void h(int i8) throws IOException {
        while ((i8 & (-128)) != 0) {
            this.f6735a.write((i8 & 127) | 128);
            i8 >>>= 7;
        }
        this.f6735a.write(i8 & 127);
    }

    public final void i(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            this.f6735a.write((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        this.f6735a.write(((int) j8) & 127);
    }
}
