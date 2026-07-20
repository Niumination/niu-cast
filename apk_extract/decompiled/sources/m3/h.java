package m3;

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
public final class h implements q4.e {
    public static final Charset f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f7686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f7687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f7688i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f7689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f7690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f7691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f7692d;
    public final k3.a1 e = new k3.a1(this, 1);

    static {
        e eVar = e.DEFAULT;
        c cVar = new c(1, eVar);
        HashMap map = new HashMap();
        map.put(f.class, cVar);
        f7686g = new q4.c("key", h0.a.s(map));
        c cVar2 = new c(2, eVar);
        HashMap map2 = new HashMap();
        map2.put(f.class, cVar2);
        f7687h = new q4.c("value", h0.a.s(map2));
        f7688i = g.f7676b;
    }

    public h(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, g gVar) {
        this.f7689a = byteArrayOutputStream;
        this.f7690b = map;
        this.f7691c = map2;
        this.f7692d = gVar;
    }

    public static int f(q4.c cVar) {
        f fVar = (f) ((Annotation) cVar.f8962b.get(f.class));
        if (fVar != null) {
            return ((c) fVar).f7641a;
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
            this.f7689a.write(bytes);
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
                g(f7688i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z2 && dDoubleValue == 0.0d) {
                return;
            }
            h((f(cVar) << 3) | 1);
            this.f7689a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z2 && fFloatValue == 0.0f) {
                return;
            }
            h((f(cVar) << 3) | 5);
            this.f7689a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
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
            this.f7689a.write(bArr);
            return;
        }
        q4.d dVar = (q4.d) this.f7690b.get(obj.getClass());
        if (dVar != null) {
            g(dVar, cVar, obj, z2);
            return;
        }
        q4.f fVar = (q4.f) this.f7691c.get(obj.getClass());
        if (fVar != null) {
            k3.a1 a1Var = this.e;
            a1Var.f6348b = false;
            a1Var.f6350d = cVar;
            a1Var.f6349c = z2;
            fVar.a(obj, a1Var);
            return;
        }
        if (obj instanceof d) {
            d(cVar, ((d) obj).zza(), true);
        } else if (obj instanceof Enum) {
            d(cVar, ((Enum) obj).ordinal(), true);
        } else {
            g(this.f7692d, cVar, obj, z2);
        }
    }

    public final void d(q4.c cVar, int i8, boolean z2) {
        if (z2 && i8 == 0) {
            return;
        }
        f fVar = (f) ((Annotation) cVar.f8962b.get(f.class));
        if (fVar == null) {
            throw new q4.b("Field has no @Protobuf config");
        }
        e eVar = e.DEFAULT;
        c cVar2 = (c) fVar;
        int iOrdinal = cVar2.f7642b.ordinal();
        int i9 = cVar2.f7641a;
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
            this.f7689a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i8).array());
        }
    }

    public final void e(q4.c cVar, long j8, boolean z2) throws IOException {
        if (z2 && j8 == 0) {
            return;
        }
        f fVar = (f) ((Annotation) cVar.f8962b.get(f.class));
        if (fVar == null) {
            throw new q4.b("Field has no @Protobuf config");
        }
        e eVar = e.DEFAULT;
        c cVar2 = (c) fVar;
        int iOrdinal = cVar2.f7642b.ordinal();
        int i8 = cVar2.f7641a;
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
            this.f7689a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j8).array());
        }
    }

    public final void g(q4.d dVar, q4.c cVar, Object obj, boolean z2) throws IOException {
        k3.u0 u0Var = new k3.u0(1);
        u0Var.f6659b = 0L;
        try {
            OutputStream outputStream = this.f7689a;
            this.f7689a = u0Var;
            try {
                dVar.a(obj, this);
                this.f7689a = outputStream;
                long j8 = u0Var.f6659b;
                u0Var.close();
                if (z2 && j8 == 0) {
                    return;
                }
                h((f(cVar) << 3) | 2);
                i(j8);
                dVar.a(obj, this);
            } catch (Throwable th2) {
                this.f7689a = outputStream;
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
            this.f7689a.write((i8 & 127) | 128);
            i8 >>>= 7;
        }
        this.f7689a.write(i8 & 127);
    }

    public final void i(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            this.f7689a.write((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        this.f7689a.write(((int) j8) & 127);
    }
}
