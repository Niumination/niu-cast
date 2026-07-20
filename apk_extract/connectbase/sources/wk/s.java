package wk;

import ik.b1;
import ik.e1;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f19658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f19659c;

    /* JADX WARN: Multi-variable type inference failed */
    public s() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ s g(s sVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sVar.f19658b;
        }
        if ((i10 & 2) != 0) {
            str2 = sVar.f19659c;
        }
        return sVar.f(str, str2);
    }

    @Override // wk.w
    @os.l
    public x a(@os.l j0 j0Var, int i10) {
        List listJ5;
        b1 b1VarC;
        String str;
        kn.l0.p(j0Var, "context");
        List<String> list = j0Var.f19627d;
        if (list.isEmpty()) {
            listJ5 = nm.k0.INSTANCE;
            break;
        }
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                listJ5 = nm.k0.INSTANCE;
                break;
            }
            if (listIterator.previous().length() != 0) {
                listJ5 = nm.h0.J5(list, listIterator.nextIndex() + 1);
                break;
            }
        }
        int i11 = 0;
        if (this.f19659c.length() > 0 && ((str = (String) nm.h0.W2(listJ5, i10)) == null || !jq.e0.s2(str, this.f19659c, false, 2, null))) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        if (this.f19658b.length() == 0) {
            b1VarC = e1.a();
        } else {
            String str2 = this.f19658b;
            List listC2 = nm.h0.c2(listJ5, i10);
            ArrayList arrayList = new ArrayList(nm.z.b0(listC2, 10));
            for (Object obj : listC2) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    nm.y.Z();
                }
                String strY6 = (String) obj;
                if (i11 == 0) {
                    strY6 = jq.j0.y6(strY6, this.f19659c.length());
                }
                arrayList.add(strY6);
                i11 = i12;
            }
            b1VarC = e1.c(str2, arrayList);
        }
        return new x(true, i10 < listJ5.size() ? 0.1d : 0.2d, b1VarC, listJ5.size() - i10);
    }

    @os.l
    public final String d() {
        return this.f19658b;
    }

    @os.l
    public final String e() {
        return this.f19659c;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kn.l0.g(this.f19658b, sVar.f19658b) && kn.l0.g(this.f19659c, sVar.f19659c);
    }

    @os.l
    public final s f(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "prefix");
        return new s(str, str2);
    }

    @os.l
    public final String h() {
        return this.f19658b;
    }

    public int hashCode() {
        return this.f19659c.hashCode() + (this.f19658b.hashCode() * 31);
    }

    @os.l
    public final String i() {
        return this.f19659c;
    }

    @os.l
    public String toString() {
        return "{...}";
    }

    public /* synthetic */ s(String str, String str2, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }

    public s(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "prefix");
        this.f19658b = str;
        this.f19659c = str2;
        int i10 = 0;
        while (i10 < str2.length()) {
            char cCharAt = str2.charAt(i10);
            i10++;
            if (cCharAt == '/') {
                throw new IllegalArgumentException("Multisegment prefix is not supported");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "PathSegmentTailcardRouteSelector(name, prefix)", imports = {}))
    public s(@os.l String str, @os.l String str2, boolean z10) {
        this(str, str2);
        kn.l0.p(str, "name");
        kn.l0.p(str2, "prefix");
    }

    public /* synthetic */ s(String str, String str2, boolean z10, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, z10);
    }
}
