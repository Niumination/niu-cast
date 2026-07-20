package l3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i0 f7249c = new i0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f7250a = new h2(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7251b;

    public i0() {
    }

    public static int a(o0 o0Var, Object obj) {
        int iZzd;
        int iQ;
        a3 a3Var = o0Var.f7277b;
        int iQ2 = c0.q(o0Var.f7276a << 3);
        if (a3Var == a3.zzj) {
            Charset charset = z0.f7328a;
            iQ2 += iQ2;
        }
        b3 b3Var = b3.INT;
        int iR = 4;
        switch (a3Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iR = 8;
                return iQ2 + iR;
            case 1:
                ((Float) obj).getClass();
                return iQ2 + iR;
            case 2:
                iR = c0.r(((Long) obj).longValue());
                return iQ2 + iR;
            case 3:
                iR = c0.r(((Long) obj).longValue());
                return iQ2 + iR;
            case 4:
                iR = c0.o(((Integer) obj).intValue());
                return iQ2 + iR;
            case 5:
                ((Long) obj).getClass();
                iR = 8;
                return iQ2 + iR;
            case 6:
                ((Integer) obj).getClass();
                return iQ2 + iR;
            case 7:
                ((Boolean) obj).getClass();
                iR = 1;
                return iQ2 + iR;
            case 8:
                if (obj instanceof b0) {
                    iZzd = ((b0) obj).zzd();
                    iQ = c0.q(iZzd);
                    iR = iQ + iZzd;
                } else {
                    iR = c0.p((String) obj);
                }
                return iQ2 + iR;
            case 9:
                iR = ((q0) ((q1) obj)).c();
                return iQ2 + iR;
            case 10:
                iZzd = ((q0) ((q1) obj)).c();
                iQ = c0.q(iZzd);
                iR = iQ + iZzd;
                return iQ2 + iR;
            case 11:
                if (obj instanceof b0) {
                    iZzd = ((b0) obj).zzd();
                    iQ = c0.q(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iQ = c0.q(iZzd);
                }
                iR = iQ + iZzd;
                return iQ2 + iR;
            case 12:
                iR = c0.q(((Integer) obj).intValue());
                return iQ2 + iR;
            case 13:
                iR = obj instanceof s0 ? c0.o(((e4) ((s0) obj)).zza()) : c0.o(((Integer) obj).intValue());
                return iQ2 + iR;
            case 14:
                ((Integer) obj).getClass();
                return iQ2 + iR;
            case 15:
                ((Long) obj).getClass();
                iR = 8;
                return iQ2 + iR;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iR = c0.q((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iQ2 + iR;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iR = c0.r((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iQ2 + iR;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean i(Map.Entry entry) {
        if (((o0) entry.getKey()).f7277b.zza() != b3.MESSAGE) {
            return true;
        }
        Object value = entry.getValue();
        if (value instanceof r1) {
            return ((r1) value).a();
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static final int j(Map.Entry entry) {
        o0 o0Var = (o0) entry.getKey();
        Object value = entry.getValue();
        if (o0Var.f7277b.zza() != b3.MESSAGE) {
            return a(o0Var, value);
        }
        int iQ = c0.q(((o0) entry.getKey()).f7276a);
        int iC = ((q0) ((q1) value)).c();
        int iQ2 = c0.q(24) + c0.q(iC) + iC;
        int iQ3 = c0.q(16);
        int iQ4 = c0.q(8);
        return iQ3 + iQ + iQ4 + iQ4 + iQ2;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i0 clone() {
        h2 h2Var;
        i0 i0Var = new i0();
        int i8 = 0;
        while (true) {
            h2Var = this.f7250a;
            if (i8 >= h2Var.f7245b.size()) {
                break;
            }
            Map.Entry entryD = h2Var.d(i8);
            i0Var.f((o0) entryD.getKey(), entryD.getValue());
            i8++;
        }
        for (Map.Entry entry : h2Var.b()) {
            i0Var.f((o0) entry.getKey(), entry.getValue());
        }
        return i0Var;
    }

    public final Object c(o0 o0Var) {
        return this.f7250a.get(o0Var);
    }

    public final Iterator d() {
        return ((i4.l) this.f7250a.entrySet()).iterator();
    }

    public final void e() {
        h2 h2Var;
        if (this.f7251b) {
            return;
        }
        int i8 = 0;
        while (true) {
            h2Var = this.f7250a;
            if (i8 >= h2Var.f7245b.size()) {
                break;
            }
            Map.Entry entryD = h2Var.d(i8);
            if (entryD.getValue() instanceof q0) {
                q0 q0Var = (q0) entryD.getValue();
                q0Var.getClass();
                y1.f7325c.b(q0Var.getClass()).b(q0Var);
                q0Var.g();
            }
            i8++;
        }
        if (!h2Var.f7247d) {
            for (int i9 = 0; i9 < h2Var.f7245b.size(); i9++) {
                ((o0) h2Var.d(i9).getKey()).getClass();
            }
            Iterator it = h2Var.b().iterator();
            while (it.hasNext()) {
                ((o0) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        if (!h2Var.f7247d) {
            h2Var.f7246c = h2Var.f7246c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(h2Var.f7246c);
            h2Var.f7248h = h2Var.f7248h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(h2Var.f7248h);
            h2Var.f7247d = true;
        }
        this.f7251b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            return this.f7250a.equals(((i0) obj).f7250a);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if ((r4 instanceof l3.s0) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if ((r4 instanceof l3.q1) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(l3.o0 r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3.getClass()
            java.nio.charset.Charset r0 = l3.z0.f7328a
            r4.getClass()
            l3.a3 r0 = l3.a3.zza
            l3.b3 r0 = l3.b3.INT
            l3.a3 r0 = r3.f7277b
            l3.b3 r1 = r0.zza()
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L40;
                case 1: goto L3d;
                case 2: goto L3a;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L31;
                case 6: goto L28;
                case 7: goto L1f;
                case 8: goto L1a;
                default: goto L19;
            }
        L19:
            goto L4a
        L1a:
            boolean r1 = r4 instanceof l3.q1
            if (r1 == 0) goto L4a
            goto L44
        L1f:
            boolean r1 = r4 instanceof java.lang.Integer
            if (r1 != 0) goto L44
            boolean r1 = r4 instanceof l3.s0
            if (r1 == 0) goto L4a
            goto L44
        L28:
            boolean r1 = r4 instanceof l3.b0
            if (r1 != 0) goto L44
            boolean r1 = r4 instanceof byte[]
            if (r1 == 0) goto L4a
            goto L44
        L31:
            boolean r1 = r4 instanceof java.lang.String
            goto L42
        L34:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r1 = r4 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r1 = r4 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r1 = r4 instanceof java.lang.Long
            goto L42
        L40:
            boolean r1 = r4 instanceof java.lang.Integer
        L42:
            if (r1 == 0) goto L4a
        L44:
            l3.h2 r2 = r2.f7250a
            r2.put(r3, r4)
            return
        L4a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            int r3 = r3.f7276a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            l3.b3 r0 = r0.zza()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r0, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.i0.f(l3.o0, java.lang.Object):void");
    }

    public final boolean g() {
        int i8 = 0;
        while (true) {
            h2 h2Var = this.f7250a;
            if (i8 >= h2Var.f7245b.size()) {
                Iterator it = h2Var.b().iterator();
                while (it.hasNext()) {
                    if (!i((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!i(h2Var.d(i8))) {
                return false;
            }
            i8++;
        }
    }

    public final void h(Map.Entry entry) {
        o0 o0Var = (o0) entry.getKey();
        Object value = entry.getValue();
        o0Var.getClass();
        b3 b3VarZza = o0Var.f7277b.zza();
        b3 b3Var = b3.MESSAGE;
        h2 h2Var = this.f7250a;
        if (b3VarZza != b3Var) {
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, length);
                value = bArr2;
            }
            h2Var.put(o0Var, value);
            return;
        }
        Object obj = h2Var.get(o0Var);
        if (obj != null) {
            q0 q0Var = (q0) ((q1) obj);
            m0 m0Var = (m0) q0Var.n(5, null);
            m0Var.b(q0Var);
            m0Var.b((q0) ((q1) value));
            h2Var.put(o0Var, m0Var.c());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr3 = (byte[]) value;
            int length2 = bArr3.length;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr3, 0, bArr4, 0, length2);
            value = bArr4;
        }
        h2Var.put(o0Var, value);
    }

    public final int hashCode() {
        return this.f7250a.hashCode();
    }

    public i0(int i8) {
        e();
        e();
    }
}
