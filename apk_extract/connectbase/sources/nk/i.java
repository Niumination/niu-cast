package nk;

import ik.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jq.e0;
import jq.h0;
import jq.j0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f11522d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final i f11523e = new i("*", false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f11524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f11526c;

    public static final class a {
        public a() {
        }

        @os.l
        public final i a() {
            return i.f11523e;
        }

        @os.l
        public final List<i> b(@os.l String str) {
            l0.p(str, "headerValue");
            List<ik.x> listE = i0.e(str, false);
            ArrayList arrayList = new ArrayList(nm.z.b0(listE, 10));
            for (ik.x xVar : listE) {
                if (xVar.f8202c != 1.0d) {
                    throw new IllegalStateException(("entity-tag quality parameter is not allowed: " + xVar.f8202c + n1.e.f11183c).toString());
                }
                if (!xVar.f8201b.isEmpty()) {
                    throw new IllegalStateException(("entity-tag parameters are not allowed: " + xVar.f8201b + n1.e.f11183c).toString());
                }
                arrayList.add(i.f11522d.c(xVar.f8200a));
            }
            return arrayList;
        }

        @os.l
        public final i c(@os.l String str) {
            boolean z10;
            l0.p(str, "value");
            if (l0.g(str, "*")) {
                return i.f11523e;
            }
            if (e0.s2(str, "W/", false, 2, null)) {
                str = j0.y6(str, 2);
                z10 = true;
            } else {
                z10 = false;
            }
            if (!e0.s2(str, "\"", false, 2, null)) {
                str = ik.a0.h(str);
            }
            return new i(str, z10);
        }

        public a(kn.w wVar) {
        }
    }

    public i(@os.l String str, boolean z10) {
        l0.p(str, "etag");
        this.f11524a = str;
        this.f11525b = z10;
        int i10 = 0;
        this.f11526c = (l0.g(str, "*") || e0.s2(str, "\"", false, 2, null)) ? str : ik.a0.h(str);
        int length = str.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = this.f11524a.charAt(i10);
            if ((l0.t(cCharAt, 32) <= 0 || cCharAt == '\"') && i10 != 0 && i10 != h0.g3(this.f11524a)) {
                throw new IllegalArgumentException(("Character '" + cCharAt + "' is not allowed in entity-tag.").toString());
            }
            i10 = i11;
        }
    }

    public static /* synthetic */ i g(i iVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = iVar.f11524a;
        }
        if ((i10 & 2) != 0) {
            z10 = iVar.f11525b;
        }
        return iVar.f(str, z10);
    }

    @Override // nk.a0
    @os.l
    public b0 a(@os.l ik.b0 b0Var) {
        List<i> listB;
        b0 b0VarJ;
        List<i> listB2;
        b0 b0VarL;
        l0.p(b0Var, "requestHeaders");
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        String str = b0Var.get(ik.j0.K);
        if (str != null && (listB2 = f11522d.b(str)) != null && (b0VarL = l(listB2)) != b0.OK) {
            return b0VarL;
        }
        j0Var.getClass();
        String str2 = b0Var.get(ik.j0.I);
        return (str2 == null || (listB = f11522d.b(str2)) == null || (b0VarJ = j(listB)) == b0.OK) ? b0.OK : b0VarJ;
    }

    @Override // nk.a0
    public void b(@os.l ik.c0 c0Var) {
        l0.p(c0Var, "builder");
        ik.b.a(c0Var, this.f11526c);
    }

    @os.l
    public final String d() {
        return this.f11524a;
    }

    public final boolean e() {
        return this.f11525b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return l0.g(this.f11524a, iVar.f11524a) && this.f11525b == iVar.f11525b;
    }

    @os.l
    public final i f(@os.l String str, boolean z10) {
        l0.p(str, "etag");
        return new i(str, z10);
    }

    @os.l
    public final String h() {
        return this.f11524a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int iHashCode = this.f11524a.hashCode() * 31;
        boolean z10 = this.f11525b;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    public final boolean i() {
        return this.f11525b;
    }

    @os.l
    public final b0 j(@os.l List<i> list) {
        l0.p(list, "givenMatchEtags");
        if (!list.isEmpty() && !list.contains(f11523e)) {
            Iterator<i> it = list.iterator();
            while (it.hasNext()) {
                if (k(it.next())) {
                    return b0.OK;
                }
            }
            return b0.PRECONDITION_FAILED;
        }
        return b0.OK;
    }

    public final boolean k(@os.l i iVar) {
        l0.p(iVar, "other");
        i iVar2 = f11523e;
        if (l0.g(this, iVar2) || l0.g(iVar, iVar2)) {
            return true;
        }
        return l0.g(this.f11526c, iVar.f11526c);
    }

    @os.l
    public final b0 l(@os.l List<i> list) {
        l0.p(list, "givenNoneMatchEtags");
        if (list.contains(f11523e)) {
            return b0.OK;
        }
        List<i> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (k((i) it.next())) {
                    return b0.NOT_MODIFIED;
                }
            }
        }
        return b0.OK;
    }

    @os.l
    public String toString() {
        return "EntityTagVersion(etag=" + this.f11524a + ", weak=" + this.f11525b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ i(String str) {
        this(h0.a4(str, "W/"), e0.s2(str, "W/", false, 2, null));
        l0.p(str, "etag");
    }
}
