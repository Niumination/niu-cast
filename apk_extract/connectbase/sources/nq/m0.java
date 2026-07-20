package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f11885a = " @";

    public static final class a extends kn.n0 implements jn.p<um.g, um.g.b, um.g> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final um.g invoke(@os.l um.g gVar, @os.l um.g.b bVar) {
            return bVar instanceof k0 ? gVar.plus(((k0) bVar).e0()) : gVar.plus(bVar);
        }
    }

    public static final class b extends kn.n0 implements jn.p<um.g, um.g.b, um.g> {
        final /* synthetic */ boolean $isNewCoroutine;
        final /* synthetic */ kn.k1.h<um.g> $leftoverContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kn.k1.h<um.g> hVar, boolean z10) {
            super(2);
            this.$leftoverContext = hVar;
            this.$isNewCoroutine = z10;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, um.g] */
        @Override // jn.p
        @os.l
        public final um.g invoke(@os.l um.g gVar, @os.l um.g.b bVar) {
            if (!(bVar instanceof k0)) {
                return gVar.plus(bVar);
            }
            um.g.b bVar2 = this.$leftoverContext.element.get(bVar.getKey());
            if (bVar2 == null) {
                return gVar.plus(this.$isNewCoroutine ? ((k0) bVar).e0() : (k0) bVar);
            }
            kn.k1.h<um.g> hVar = this.$leftoverContext;
            hVar.element = hVar.element.minusKey(bVar.getKey());
            return gVar.plus(((k0) bVar).Y1(bVar2));
        }
    }

    public static final class c extends kn.n0 implements jn.p<Boolean, um.g.b, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @os.l
        public final Boolean invoke(boolean z10, @os.l um.g.b bVar) {
            return Boolean.valueOf(z10 || (bVar instanceof k0));
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, um.g.b bVar) {
            return invoke(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final um.g a(um.g gVar, um.g gVar2, boolean z10) {
        boolean zC = c(gVar);
        boolean zC2 = c(gVar2);
        if (!zC && !zC2) {
            return gVar.plus(gVar2);
        }
        kn.k1.h hVar = new kn.k1.h();
        hVar.element = gVar2;
        um.i iVar = um.i.INSTANCE;
        um.g gVar3 = (um.g) gVar.fold(iVar, new b(hVar, z10));
        if (zC2) {
            hVar.element = ((um.g) hVar.element).fold(iVar, a.INSTANCE);
        }
        return gVar3.plus((um.g) hVar.element);
    }

    @os.m
    public static final String b(@os.l um.g gVar) {
        return null;
    }

    public static final boolean c(um.g gVar) {
        return ((Boolean) gVar.fold(Boolean.FALSE, c.INSTANCE)).booleanValue();
    }

    @a2
    @os.l
    public static final um.g d(@os.l s0 s0Var, @os.l um.g gVar) {
        um.g gVarA = a(s0Var.getCoroutineContext(), gVar, true);
        return (gVarA == k1.a() || gVarA.get(um.e.G) != null) ? gVarA : gVarA.plus(k1.f11876b);
    }

    @g2
    @os.l
    public static final um.g e(@os.l um.g gVar, @os.l um.g gVar2) {
        return !c(gVar2) ? gVar.plus(gVar2) : a(gVar, gVar2, false);
    }

    @os.m
    public static final z3<?> f(@os.l xm.e eVar) {
        while (!(eVar instanceof g1) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof z3) {
                return (z3) eVar;
            }
        }
        return null;
    }

    @os.m
    public static final z3<?> g(@os.l um.d<?> dVar, @os.l um.g gVar, @os.m Object obj) {
        if (!(dVar instanceof xm.e) || gVar.get(a4.f11824a) == null) {
            return null;
        }
        z3<?> z3VarF = f((xm.e) dVar);
        if (z3VarF != null) {
            z3VarF.W1(gVar, obj);
        }
        return z3VarF;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e A[DONT_GENERATE] */
    public static final <T> T h(@os.l um.d<?> dVar, @os.m Object obj, @os.l jn.a<? extends T> aVar) {
        um.g context = dVar.getContext();
        Object objC = vq.a1.c(context, obj);
        z3<?> z3VarG = objC != vq.a1.f17796a ? g(dVar, context, objC) : null;
        try {
            return aVar.invoke();
        } finally {
            if (z3VarG == null || z3VarG.V1()) {
                vq.a1.a(context, objC);
            }
        }
    }

    public static final <T> T i(@os.l um.g gVar, @os.m Object obj, @os.l jn.a<? extends T> aVar) {
        Object objC = vq.a1.c(gVar, obj);
        try {
            return aVar.invoke();
        } finally {
            vq.a1.a(gVar, objC);
        }
    }
}
