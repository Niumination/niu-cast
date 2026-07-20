package ms;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final int A = 5;
    public static final int B = 6;
    public static final int C = 7;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10887b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10888c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10889d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10890e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10891f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10892g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10893h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10894i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10895j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10896k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10897l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10898m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10899n = 7;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10900o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10901p = 21;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10902q = 22;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10903r = 24;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10904s = 25;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10905t = 27;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f10906u = 28;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10907v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f10908w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f10909x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f10910y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f10911z = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f10912a;

    public b(OutputStream outputStream) {
        this.f10912a = outputStream;
    }

    public void A() throws IOException {
    }

    public void B(int i10) throws IOException {
    }

    public void C(int i10) throws IOException {
    }

    public void D(int i10) throws IOException {
    }

    public void E(int i10) throws IOException {
        F(i10, false);
    }

    public void F(int i10, boolean z10) throws IOException {
    }

    public void G(int i10) throws IOException {
    }

    public void H(int i10, int i11, int i12) throws IOException {
    }

    public void I(int i10) throws IOException {
        J(i10, false);
    }

    public void J(int i10, boolean z10) throws IOException {
    }

    public void K(int i10) throws IOException {
    }

    public void L(int i10, int i11, int i12) throws IOException {
    }

    public void M(ArrayList<Object> arrayList, int i10) {
    }

    public void N(int i10, String str) {
    }

    public int a(Iterator<Object> it) throws IOException {
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                return ((Integer) next).intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public final int b(ArrayList<Object> arrayList, int i10) {
        if (arrayList.size() <= i10) {
            throw new IllegalArgumentException();
        }
        Object obj = arrayList.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (obj.getClass().equals(Integer.class)) {
            return ((Integer) obj).intValue();
        }
        throw new IllegalArgumentException();
    }

    public final int c(ArrayList<Object> arrayList, int i10, int i11) {
        Object obj;
        return (arrayList.size() <= i10 || (obj = arrayList.get(i10)) == null) ? i11 : ((Integer) obj).intValue();
    }

    public void d() throws IOException {
    }

    public void e(String str) {
    }

    public void f(String str) {
        e(str);
        g(str);
    }

    public void g(String str) {
    }

    public void h(int i10, char c10) {
    }

    public boolean i(ArrayList<Object> arrayList) {
        h(b(arrayList, 0), ((Character) arrayList.get(1)).charValue());
        return true;
    }

    public void j(int i10) throws IOException {
    }

    public void k(int i10) throws IOException {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f10912a.write(10);
        }
    }

    public void l(int i10) throws IOException {
    }

    public void m(int i10) throws IOException {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f10912a.write(32);
        }
    }

    public void n(int i10, int i11) throws IOException {
    }

    public void o(int i10) throws IOException {
    }

    public void p(int i10) throws IOException {
    }

    public void q(int i10) throws IOException {
    }

    public void r() throws IOException {
    }

    public void s() throws IOException {
    }

    public void t(int i10) throws IOException {
    }

    public void u(int i10) throws IOException {
    }

    public void v(int i10) throws IOException {
    }

    public boolean w(ArrayList<Object> arrayList, int i10) throws IOException {
        try {
            if (i10 == 83) {
                C(c(arrayList, 0, 1));
                return true;
            }
            if (i10 == 84) {
                B(c(arrayList, 0, 1));
                return true;
            }
            if (i10 != 102) {
                if (i10 == 109) {
                    for (Object obj : arrayList) {
                        if (obj != null && obj.getClass() != Integer.class) {
                            throw new IllegalArgumentException();
                        }
                    }
                    Iterator<Object> it = arrayList.iterator();
                    int i11 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            i11++;
                            int iIntValue = ((Integer) next).intValue();
                            if (30 <= iIntValue && iIntValue <= 37) {
                                I(iIntValue - 30);
                            } else if (40 <= iIntValue && iIntValue <= 47) {
                                E(iIntValue - 40);
                            } else if (90 <= iIntValue && iIntValue <= 97) {
                                J(iIntValue - 90, true);
                            } else if (100 <= iIntValue && iIntValue <= 107) {
                                F(iIntValue - 100, true);
                            } else if (iIntValue == 38 || iIntValue == 48) {
                                if (it.hasNext()) {
                                    int iA = a(it);
                                    if (iA == 2) {
                                        int iA2 = a(it);
                                        int iA3 = a(it);
                                        int iA4 = a(it);
                                        if (iA2 < 0 || iA2 > 255 || iA3 < 0 || iA3 > 255 || iA4 < 0 || iA4 > 255) {
                                            throw new IllegalArgumentException();
                                        }
                                        if (iIntValue == 38) {
                                            L(iA2, iA3, iA4);
                                        } else {
                                            H(iA2, iA3, iA4);
                                        }
                                    } else {
                                        if (iA != 5) {
                                            throw new IllegalArgumentException();
                                        }
                                        int iA5 = a(it);
                                        if (iA5 < 0 || iA5 > 255) {
                                            throw new IllegalArgumentException();
                                        }
                                        if (iIntValue == 38) {
                                            K(iA5);
                                        } else {
                                            G(iA5);
                                        }
                                    }
                                }
                            } else if (iIntValue == 0) {
                                d();
                            } else if (iIntValue == 39) {
                                s();
                            } else if (iIntValue != 49) {
                                D(iIntValue);
                            } else {
                                r();
                            }
                        }
                    }
                    if (i11 == 0) {
                        d();
                    }
                    return true;
                }
                if (i10 == 115) {
                    A();
                    return true;
                }
                if (i10 == 117) {
                    z();
                    return true;
                }
                switch (i10) {
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        p(c(arrayList, 0, 1));
                        return true;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        j(c(arrayList, 0, 1));
                        return true;
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        m(c(arrayList, 0, 1));
                        return true;
                    case 68:
                        l(c(arrayList, 0, 1));
                        return true;
                    case 69:
                        k(c(arrayList, 0, 1));
                        return true;
                    case 70:
                        q(c(arrayList, 0, 1));
                        return true;
                    case 71:
                        o(b(arrayList, 0));
                        return true;
                    case TabLayout.f3131k0 /* 72 */:
                        break;
                    default:
                        switch (i10) {
                            case 74:
                                v(c(arrayList, 0, 0));
                                return true;
                            case 75:
                                u(c(arrayList, 0, 0));
                                return true;
                            case en.a.f4563i /* 76 */:
                                x(c(arrayList, 0, 1));
                                return true;
                            case 77:
                                t(c(arrayList, 0, 1));
                                return true;
                            default:
                                if (97 <= i10 && i10 <= 122) {
                                    M(arrayList, i10);
                                    return true;
                                }
                                if (65 > i10 || i10 > 90) {
                                    return false;
                                }
                                M(arrayList, i10);
                                return true;
                        }
                }
            }
            n(c(arrayList, 0, 1), c(arrayList, 1, 1));
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void x(int i10) throws IOException {
    }

    public boolean y(ArrayList<Object> arrayList) {
        int iB = b(arrayList, 0);
        String str = (String) arrayList.get(1);
        try {
            if (iB == 0) {
                f(str);
                return true;
            }
            if (iB == 1) {
                e(str);
                return true;
            }
            if (iB != 2) {
                N(iB, str);
                return true;
            }
            g(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void z() throws IOException {
    }
}
