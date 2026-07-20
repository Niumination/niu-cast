package fp;

import fp.h.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f6234d = new h(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6237c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v<FieldDescriptorType, Object> f6235a = v.r(16);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6239b;

        static {
            int[] iArr = new int[z.b.values().length];
            f6239b = iArr;
            try {
                iArr[z.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6239b[z.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6239b[z.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6239b[z.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6239b[z.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6239b[z.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6239b[z.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6239b[z.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6239b[z.b.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6239b[z.b.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6239b[z.b.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6239b[z.b.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6239b[z.b.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6239b[z.b.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6239b[z.b.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6239b[z.b.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6239b[z.b.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6239b[z.b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[z.c.values().length];
            f6238a = iArr2;
            try {
                iArr2[z.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f6238a[z.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f6238a[z.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f6238a[z.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f6238a[z.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f6238a[z.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f6238a[z.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f6238a[z.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f6238a[z.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        q.a g(q.a aVar, q qVar);

        z.c getLiteJavaType();

        z.b getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    public h() {
    }

    public static int d(z.b bVar, int i10, Object obj) {
        int iD = f.D(i10);
        if (bVar == z.b.GROUP) {
            iD *= 2;
        }
        return e(bVar, obj) + iD;
    }

    public static int e(z.b bVar, Object obj) {
        switch (a.f6239b[bVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return 8;
            case 2:
                ((Float) obj).floatValue();
                return 4;
            case 3:
                return f.w(((Long) obj).longValue());
            case 4:
                return f.w(((Long) obj).longValue());
            case 5:
                return f.p(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return 8;
            case 7:
                ((Integer) obj).intValue();
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                return 1;
            case 9:
                return f.C((String) obj);
            case 10:
                return obj instanceof d ? f.e((d) obj) : f.c((byte[]) obj);
            case 11:
                return f.v(((Integer) obj).intValue());
            case 12:
                ((Integer) obj).intValue();
                return 4;
            case 13:
                ((Long) obj).longValue();
                return 8;
            case 14:
                return f.z(((Integer) obj).intValue());
            case 15:
                return f.B(((Long) obj).longValue());
            case 16:
                return ((q) obj).getSerializedSize();
            case 17:
                return obj instanceof l ? f.r((l) obj) : f.t((q) obj);
            case 18:
                return obj instanceof j.a ? f.p(((j.a) obj).getNumber()) : f.p(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        z.b liteType = bVar.getLiteType();
        int number = bVar.getNumber();
        if (!bVar.isRepeated()) {
            return d(liteType, number, obj);
        }
        int iD = 0;
        if (!bVar.isPacked()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD += d(liteType, number, it.next());
            }
            return iD;
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD += e(liteType, it2.next());
        }
        return f.v(iD) + f.D(number) + iD;
    }

    public static <T extends b<T>> h<T> g() {
        return f6234d;
    }

    public static int l(z.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.getWireType();
    }

    public static <T extends b<T>> h<T> t() {
        return new h<>();
    }

    public static Object u(e eVar, z.b bVar, boolean z10) throws IOException {
        switch (a.f6239b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.C());
            case 4:
                return Long.valueOf(eVar.C());
            case 5:
                return Integer.valueOf(eVar.A());
            case 6:
                return Long.valueOf(eVar.z());
            case 7:
                return Integer.valueOf(eVar.y());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                return z10 ? eVar.J() : eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.A());
            case 12:
                return Integer.valueOf(eVar.y());
            case 13:
                return Long.valueOf(eVar.z());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    public static void w(z.b bVar, Object obj) {
        obj.getClass();
        boolean z10 = true;
        boolean z11 = false;
        switch (a.f6238a[bVar.getJavaType().ordinal()]) {
            case 1:
                z11 = obj instanceof Integer;
                break;
            case 2:
                z11 = obj instanceof Long;
                break;
            case 3:
                z11 = obj instanceof Float;
                break;
            case 4:
                z11 = obj instanceof Double;
                break;
            case 5:
                z11 = obj instanceof Boolean;
                break;
            case 6:
                z11 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof d) && !(obj instanceof byte[])) {
                    z10 = false;
                }
                z11 = z10;
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof j.a)) {
                    z10 = false;
                }
                z11 = z10;
                break;
            case 9:
                if (!(obj instanceof q) && !(obj instanceof l)) {
                    z10 = false;
                }
                z11 = z10;
                break;
        }
        if (!z11) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static void x(f fVar, z.b bVar, int i10, Object obj) throws IOException {
        if (bVar == z.b.GROUP) {
            fVar.Y(i10, (q) obj);
        } else {
            fVar.w0(i10, l(bVar, false));
            y(fVar, bVar, obj);
        }
    }

    public static void y(f fVar, z.b bVar, Object obj) throws IOException {
        switch (a.f6239b[bVar.ordinal()]) {
            case 1:
                fVar.R(((Double) obj).doubleValue());
                break;
            case 2:
                fVar.X(((Float) obj).floatValue());
                break;
            case 3:
                fVar.p0(((Long) obj).longValue());
                break;
            case 4:
                fVar.p0(((Long) obj).longValue());
                break;
            case 5:
                fVar.b0(((Integer) obj).intValue());
                break;
            case 6:
                fVar.n0(((Long) obj).longValue());
                break;
            case 7:
                fVar.m0(((Integer) obj).intValue());
                break;
            case 8:
                fVar.g0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 9:
                fVar.v0((String) obj);
                break;
            case 10:
                if (!(obj instanceof d)) {
                    fVar.N((byte[]) obj);
                } else {
                    fVar.P((d) obj);
                }
                break;
            case 11:
                fVar.o0(((Integer) obj).intValue());
                break;
            case 12:
                fVar.m0(((Integer) obj).intValue());
                break;
            case 13:
                fVar.n0(((Long) obj).longValue());
                break;
            case 14:
                fVar.s0(((Integer) obj).intValue());
                break;
            case 15:
                fVar.u0(((Long) obj).longValue());
                break;
            case 16:
                fVar.getClass();
                ((q) obj).writeTo(fVar);
                break;
            case 17:
                fVar.e0((q) obj);
                break;
            case 18:
                if (!(obj instanceof j.a)) {
                    fVar.b0(((Integer) obj).intValue());
                } else {
                    fVar.b0(((j.a) obj).getNumber());
                }
                break;
        }
    }

    public static void z(b<?> bVar, Object obj, f fVar) throws IOException {
        z.b liteType = bVar.getLiteType();
        int number = bVar.getNumber();
        if (!bVar.isRepeated()) {
            if (obj instanceof l) {
                x(fVar, liteType, number, ((l) obj).e());
                return;
            } else {
                x(fVar, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!bVar.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x(fVar, liteType, number, it.next());
            }
            return;
        }
        fVar.w0(number, 2);
        Iterator it2 = list.iterator();
        int iE = 0;
        while (it2.hasNext()) {
            iE += e(liteType, it2.next());
        }
        fVar.o0(iE);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            y(fVar, liteType, it3.next());
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List arrayList;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        w(fielddescriptortype.getLiteType(), obj);
        Object objH = h(fielddescriptortype);
        if (objH == null) {
            arrayList = new ArrayList();
            this.f6235a.put(fielddescriptortype, arrayList);
        } else {
            arrayList = (List) objH;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h<FieldDescriptorType> clone() {
        h<FieldDescriptorType> hVar = new h<>();
        for (int i10 = 0; i10 < this.f6235a.j(); i10++) {
            Map.Entry<K, Object> entryI = this.f6235a.i(i10);
            hVar.v((b) entryI.getKey(), entryI.getValue());
        }
        Iterator it = this.f6235a.l().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            hVar.v((b) entry.getKey(), entry.getValue());
        }
        hVar.f6237c = this.f6237c;
        return hVar;
    }

    public final Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f6235a.get(fielddescriptortype);
        return obj instanceof l ? ((l) obj).e() : obj;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i10) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objH = h(fielddescriptortype);
        if (objH != null) {
            return ((List) objH).get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object objH = h(fielddescriptortype);
        if (objH == null) {
            return 0;
        }
        return ((List) objH).size();
    }

    public int k() {
        int iF = 0;
        for (int i10 = 0; i10 < this.f6235a.j(); i10++) {
            Map.Entry<K, Object> entryI = this.f6235a.i(i10);
            iF += f((b) entryI.getKey(), entryI.getValue());
        }
        Iterator it = this.f6235a.l().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f6235a.get(fielddescriptortype) != null;
    }

    public boolean n() {
        for (int i10 = 0; i10 < this.f6235a.j(); i10++) {
            if (!o(this.f6235a.i(i10))) {
                return false;
            }
        }
        Iterator it = this.f6235a.l().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == z.c.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((q) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof q)) {
                    if (value instanceof l) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((q) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        return this.f6237c ? new l.c(this.f6235a.entrySet().iterator()) : this.f6235a.entrySet().iterator();
    }

    public void q() {
        if (this.f6236b) {
            return;
        }
        this.f6235a.q();
        this.f6236b = true;
    }

    public void r(h<FieldDescriptorType> hVar) {
        for (int i10 = 0; i10 < hVar.f6235a.j(); i10++) {
            s(hVar.f6235a.i(i10));
        }
        Iterator it = hVar.f6235a.l().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    public final void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).e();
        }
        if (key.isRepeated()) {
            Object objH = h(key);
            if (objH == null) {
                objH = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objH).add(c(it.next()));
            }
            this.f6235a.put(key, objH);
            return;
        }
        if (key.getLiteJavaType() != z.c.MESSAGE) {
            this.f6235a.put(key, c(value));
            return;
        }
        Object objH2 = h(key);
        if (objH2 == null) {
            this.f6235a.put(key, c(value));
        } else {
            this.f6235a.put(key, key.g(((q) objH2).toBuilder(), (q) value).build());
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            w(fielddescriptortype.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                w(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof l) {
            this.f6237c = true;
        }
        this.f6235a.put(fielddescriptortype, obj);
    }

    public h(boolean z10) {
        q();
    }
}
