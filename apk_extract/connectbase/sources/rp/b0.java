package rp;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f14697c;

        static {
            int[] iArr = new int[yo.a.j.values().length];
            iArr[yo.a.j.DECLARATION.ordinal()] = 1;
            iArr[yo.a.j.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[yo.a.j.DELEGATION.ordinal()] = 3;
            iArr[yo.a.j.SYNTHESIZED.ordinal()] = 4;
            f14695a = iArr;
            int[] iArr2 = new int[eo.b.a.values().length];
            iArr2[eo.b.a.DECLARATION.ordinal()] = 1;
            iArr2[eo.b.a.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[eo.b.a.DELEGATION.ordinal()] = 3;
            iArr2[eo.b.a.SYNTHESIZED.ordinal()] = 4;
            f14696b = iArr2;
            int[] iArr3 = new int[yo.a.x.values().length];
            iArr3[yo.a.x.INTERNAL.ordinal()] = 1;
            iArr3[yo.a.x.PRIVATE.ordinal()] = 2;
            iArr3[yo.a.x.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[yo.a.x.PROTECTED.ordinal()] = 4;
            iArr3[yo.a.x.PUBLIC.ordinal()] = 5;
            iArr3[yo.a.x.LOCAL.ordinal()] = 6;
            f14697c = iArr3;
        }
    }

    @os.l
    public static final eo.u a(@os.l a0 a0Var, @os.m yo.a.x xVar) {
        l0.p(a0Var, "<this>");
        switch (xVar == null ? -1 : a.f14697c[xVar.ordinal()]) {
            case 1:
                eo.u uVar = eo.t.f4632d;
                l0.o(uVar, "INTERNAL");
                return uVar;
            case 2:
                eo.u uVar2 = eo.t.f4629a;
                l0.o(uVar2, "PRIVATE");
                return uVar2;
            case 3:
                eo.u uVar3 = eo.t.f4630b;
                l0.o(uVar3, "PRIVATE_TO_THIS");
                return uVar3;
            case 4:
                eo.u uVar4 = eo.t.f4631c;
                l0.o(uVar4, "PROTECTED");
                return uVar4;
            case 5:
                eo.u uVar5 = eo.t.f4633e;
                l0.o(uVar5, "PUBLIC");
                return uVar5;
            case 6:
                eo.u uVar6 = eo.t.f4634f;
                l0.o(uVar6, "LOCAL");
                return uVar6;
            default:
                eo.u uVar7 = eo.t.f4629a;
                l0.o(uVar7, "PRIVATE");
                return uVar7;
        }
    }

    @os.l
    public static final eo.b.a b(@os.l a0 a0Var, @os.m yo.a.j jVar) {
        l0.p(a0Var, "<this>");
        int i10 = jVar == null ? -1 : a.f14695a[jVar.ordinal()];
        if (i10 == 1) {
            return eo.b.a.DECLARATION;
        }
        if (i10 == 2) {
            return eo.b.a.FAKE_OVERRIDE;
        }
        if (i10 != 3) {
            return i10 != 4 ? eo.b.a.DECLARATION : eo.b.a.SYNTHESIZED;
        }
        return eo.b.a.DELEGATION;
    }
}
