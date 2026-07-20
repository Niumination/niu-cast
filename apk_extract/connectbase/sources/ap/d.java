package ap;

import el.b0;
import java.util.LinkedList;
import java.util.List;
import kn.l0;
import lm.o1;
import nm.h0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final yo.a.p f668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final yo.a.o f669b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f670a;

        static {
            int[] iArr = new int[yo.a.o.c.EnumC0585c.values().length];
            iArr[yo.a.o.c.EnumC0585c.CLASS.ordinal()] = 1;
            iArr[yo.a.o.c.EnumC0585c.PACKAGE.ordinal()] = 2;
            iArr[yo.a.o.c.EnumC0585c.LOCAL.ordinal()] = 3;
            f670a = iArr;
        }
    }

    public d(@l yo.a.p pVar, @l yo.a.o oVar) {
        l0.p(pVar, "strings");
        l0.p(oVar, "qualifiedNames");
        this.f668a = pVar;
        this.f669b = oVar;
    }

    @Override // ap.c
    public boolean a(int i10) {
        return d(i10).getThird().booleanValue();
    }

    @Override // ap.c
    @l
    public String b(int i10) {
        o1<List<String>, List<String>, Boolean> o1VarD = d(i10);
        List<String> listComponent1 = o1VarD.component1();
        String strM3 = h0.m3(o1VarD.component2(), ".", null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strM3;
        }
        return h0.m3(listComponent1, "/", null, null, 0, null, null, 62, null) + b0.f4502a + strM3;
    }

    @Override // ap.c
    @l
    public String c(int i10) {
        String string = this.f668a.getString(i10);
        l0.o(string, "strings.getString(index)");
        return string;
    }

    public final o1<List<String>, List<String>, Boolean> d(int i10) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i10 != -1) {
            yo.a.o.c qualifiedName = this.f669b.getQualifiedName(i10);
            String string = this.f668a.getString(qualifiedName.getShortName());
            yo.a.o.c.EnumC0585c kind = qualifiedName.getKind();
            l0.m(kind);
            int i11 = a.f670a[kind.ordinal()];
            if (i11 == 1) {
                linkedList2.addFirst(string);
            } else if (i11 == 2) {
                linkedList.addFirst(string);
            } else if (i11 == 3) {
                linkedList2.addFirst(string);
                z10 = true;
            }
            i10 = qualifiedName.getParentQualifiedName();
        }
        return new o1<>(linkedList, linkedList2, Boolean.valueOf(z10));
    }
}
