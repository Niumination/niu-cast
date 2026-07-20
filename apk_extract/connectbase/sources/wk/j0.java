package wk;

import androidx.core.app.NotificationCompat;
import ik.b1;
import ik.c1;
import ik.q1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final v f19624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final dk.b f19625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<jn.l<l0, l2>> f19626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<String> f19627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final l0 f19629f;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(@os.l v vVar, @os.l dk.b bVar, @os.l List<? extends jn.l<? super l0, l2>> list) throws gk.c {
        kn.l0.p(vVar, "routing");
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        kn.l0.p(list, "tracers");
        this.f19624a = vVar;
        this.f19625b = bVar;
        this.f19626c = list;
        l0 l0Var = null;
        this.f19628e = jq.h0.Y2(uk.e.v(bVar.d()), el.b0.f4502a, false, 2, null);
        try {
            List<String> listH = h(uk.e.v(bVar.d()));
            this.f19627d = listH;
            if (!list.isEmpty()) {
                l0Var = new l0(bVar, listH);
            }
            this.f19629f = l0Var;
        } catch (q1 e10) {
            throw new gk.c(kn.l0.C("Url decode failed for ", uk.e.p(this.f19625b.d())), e10);
        }
    }

    public static final int c(List list, List list2) {
        int i10;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < list.size() && i13 < list2.size()) {
            double d10 = ((k0.b) list.get(i12)).f19633c;
            double d11 = ((k0.b) list2.get(i13)).f19633c;
            if (d10 == -1.0d) {
                i12++;
            } else {
                if (d11 != -1.0d) {
                    if (d10 != d11) {
                        return rm.g.l(Double.valueOf(d10), Double.valueOf(d11));
                    }
                    i12++;
                }
                i13++;
            }
        }
        kn.l0.o(list, "result1");
        List list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            i10 = 0;
        } else {
            Iterator it = list3.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (!(((k0.b) it.next()).f19633c == -1.0d) && (i10 = i10 + 1) < 0) {
                    nm.y.Y();
                }
            }
        }
        Integer numValueOf = Integer.valueOf(i10);
        kn.l0.o(list2, "result2");
        List list4 = list2;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            int i14 = 0;
            while (it2.hasNext()) {
                if (!(((k0.b) it2.next()).f19633c == -1.0d) && (i14 = i14 + 1) < 0) {
                    nm.y.Y();
                }
            }
            i11 = i14;
        }
        return rm.g.l(numValueOf, Integer.valueOf(i11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k0 b(v vVar, List<? extends List<k0.b>> list) {
        if (list.isEmpty()) {
            return new k0.a(vVar, "No matched subtrees found");
        }
        Object objV3 = nm.h0.V3(list, new i0());
        kn.l0.m(objV3);
        List list2 = (List) objV3;
        List list3 = list2;
        c1 c1Var = new c1(0, null, 3, 0 == true ? 1 : 0);
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            c1Var.b(((k0.b) it.next()).f19632b);
        }
        b1 b1VarF = c1Var.f();
        v vVar2 = ((k0.b) nm.h0.p3(list2)).f19630a;
        Iterator it2 = list3.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double dMin = ((k0.b) it2.next()).f19633c;
        if (dMin == -1.0d) {
            dMin = 1.0d;
        }
        while (it2.hasNext()) {
            double d10 = ((k0.b) it2.next()).f19633c;
            if (d10 == -1.0d) {
                d10 = 1.0d;
            }
            dMin = Math.min(dMin, d10);
        }
        return new k0.b(vVar2, b1VarF, dMin);
    }

    @os.l
    public final dk.b d() {
        return this.f19625b;
    }

    public final boolean e() {
        return this.f19628e;
    }

    @os.l
    public final v f() {
        return this.f19624a;
    }

    @os.l
    public final List<String> g() {
        return this.f19627d;
    }

    public final List<String> h(String str) {
        if (str.length() == 0 || kn.l0.g(str, "/")) {
            return nm.k0.INSTANCE;
        }
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            i10++;
            if (cCharAt == '/') {
                i11++;
            }
        }
        ArrayList arrayList = new ArrayList(i11);
        int iO3 = 0;
        int i12 = 0;
        while (iO3 < length) {
            iO3 = jq.h0.o3(str, el.b0.f4502a, i12, false, 4, null);
            if (iO3 == -1) {
                iO3 = length;
            }
            if (iO3 != i12) {
                arrayList.add(ik.e.i(str, i12, iO3, null, 4, null));
            }
            i12 = iO3 + 1;
        }
        if (!i.b(this.f19625b) && jq.e0.J1(str, "/", false, 2, null)) {
            arrayList.add("");
        }
        return arrayList;
    }

    @os.l
    public final k0 i() {
        v vVar = this.f19624a;
        x xVarA = vVar.J.a(this, 0);
        if (!xVarA.f19681a) {
            k0.a aVar = new k0.a(vVar, "rootPath didn't match");
            l0 l0Var = this.f19629f;
            if (l0Var != null) {
                l0Var.i(vVar, 0, aVar);
            }
            return aVar;
        }
        ArrayList arrayList = new ArrayList();
        k0.b bVar = new k0.b(vVar, xVarA.f19683c, xVarA.f19682b);
        List<k0.b> listK = nm.x.k(bVar);
        l0 l0Var2 = this.f19629f;
        if (l0Var2 != null) {
            l0Var2.a(vVar, 0);
        }
        j(vVar, arrayList, listK, xVarA.f19684d);
        l0 l0Var3 = this.f19629f;
        if (l0Var3 != null) {
            l0Var3.c(vVar, 0, bVar);
        }
        l0 l0Var4 = this.f19629f;
        if (l0Var4 != null) {
            l0Var4.h(arrayList);
        }
        k0 k0VarB = b(vVar, arrayList);
        l0 l0Var5 = this.f19629f;
        if (l0Var5 != null) {
            l0Var5.g(k0VarB);
        }
        l0 l0Var6 = this.f19629f;
        if (l0Var6 != null) {
            Iterator<T> it = this.f19626c.iterator();
            while (it.hasNext()) {
                ((jn.l) it.next()).invoke(l0Var6);
            }
        }
        return k0VarB;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00cb A[LOOP:0: B:20:0x004b->B:55:0x00cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cf A[EDGE_INSN: B:57:0x00cf->B:56:0x00cf BREAK  A[LOOP:0: B:20:0x004b->B:55:0x00cb], SYNTHETIC] */
    public final boolean j(v vVar, List<List<k0.b>> list, List<k0.b> list2, int i10) {
        boolean z10;
        if (vVar.K.isEmpty() && i10 != this.f19627d.size()) {
            l0 l0Var = this.f19629f;
            if (l0Var != null) {
                l0Var.i(vVar, i10, new k0.a(vVar, "Not all segments matched"));
            }
            return false;
        }
        if (vVar.L.isEmpty() || i10 != this.f19627d.size()) {
            z10 = false;
        } else {
            list.add(list2);
            z10 = true;
        }
        int iJ = nm.y.J(vVar.K);
        if (iJ >= 0) {
            double d10 = -1.7976931348623157E308d;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                v vVar2 = vVar.K.get(i11);
                x xVarA = vVar2.J.a(this, i10);
                if (xVarA.f19681a) {
                    double d11 = xVarA.f19682b;
                    if (d11 != -1.0d && d11 < d10) {
                        l0 l0Var2 = this.f19629f;
                        if (l0Var2 != null) {
                            l0Var2.i(vVar2, i10, new k0.a(vVar2, "Better match was already found"));
                        }
                    } else {
                        k0.b bVar = new k0.b(vVar2, xVarA.f19683c, d11);
                        int i13 = xVarA.f19684d + i10;
                        l0 l0Var3 = this.f19629f;
                        if (l0Var3 != null) {
                            l0Var3.a(vVar2, i13);
                        }
                        boolean zJ = j(vVar2, list, nm.h0.F4(list2, bVar), i13);
                        l0 l0Var4 = this.f19629f;
                        if (l0Var4 != null) {
                            l0Var4.c(vVar2, i13, bVar);
                        }
                        if (zJ && d10 < bVar.f19633c) {
                            d10 = xVarA.f19682b;
                        }
                        z10 = z10 || zJ;
                    }
                    if (i11 == iJ) {
                        break;
                    }
                    i11 = i12;
                } else {
                    l0 l0Var5 = this.f19629f;
                    if (l0Var5 != null) {
                        l0Var5.i(vVar2, i10, new k0.a(vVar2, "Selector didn't match"));
                    }
                }
                if (i11 == iJ) {
                    break;
                    break;
                }
                i11 = i12;
            }
        }
        return z10;
    }
}
