package l3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public static int a(Map.Entry entry) {
        return ((o0) entry.getKey()).f7276a;
    }

    public static i0 b(Object obj) {
        return ((n0) obj).zza;
    }

    public static void c(Object obj) {
        ((n0) obj).zza.e();
    }

    public static void d(l1 l1Var, Map.Entry entry) throws d0 {
        o0 o0Var = (o0) entry.getKey();
        a3 a3Var = a3.zza;
        int iOrdinal = o0Var.f7277b.ordinal();
        int i8 = o0Var.f7276a;
        switch (iOrdinal) {
            case 0:
                l1Var.h(i8, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                l1Var.l(i8, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                l1Var.o(i8, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                l1Var.d(i8, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                l1Var.n(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                l1Var.k(i8, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                l1Var.j(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                l1Var.e(i8, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                ((c0) l1Var.f7264a).h(i8, (String) entry.getValue());
                break;
            case 9:
                l1Var.m(i8, entry.getValue(), y1.f7325c.b(entry.getValue().getClass()));
                break;
            case 10:
                l1Var.p(i8, entry.getValue(), y1.f7325c.b(entry.getValue().getClass()));
                break;
            case 11:
                l1Var.g(i8, (b0) entry.getValue());
                break;
            case 12:
                l1Var.c(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                l1Var.n(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                l1Var.r(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                l1Var.s(i8, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                l1Var.a(i8, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                l1Var.b(i8, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
