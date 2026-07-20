package gk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6686a = 200;

    public static final class a extends kn.n0 implements jn.l<n, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l n nVar) {
            kn.l0.p(nVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(n nVar) {
            invoke2(nVar);
            return l2.f10208a;
        }
    }

    public static final class c extends kn.n0 implements jn.p<dk.b, nk.s, Boolean> {
        final /* synthetic */ ik.i[] $mimeTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ik.i[] iVarArr) {
            super(2);
            this.$mimeTypes = iVarArr;
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l dk.b bVar, @os.l nk.s sVar) {
            kn.l0.p(bVar, "$this$condition");
            kn.l0.p(sVar, t2.a.f15437d);
            ik.i iVarC = sVar.c();
            if (iVarC == null) {
                vk.g gVarB = bVar.e().b();
                ik.j0.f8048a.getClass();
                String strF = gVarB.f(ik.j0.f8086t);
                iVarC = strF == null ? null : ik.i.f7981f.b(strF);
                if (iVarC == null) {
                    return Boolean.TRUE;
                }
            }
            ik.i[] iVarArr = this.$mimeTypes;
            int length = iVarArr.length;
            boolean z10 = false;
            int i10 = 0;
            while (i10 < length) {
                ik.i iVar = iVarArr[i10];
                i10++;
                if (iVarC.h(iVar)) {
                    return Boolean.valueOf(z10);
                }
            }
            z10 = true;
            return Boolean.valueOf(z10);
        }
    }

    public static final class d extends kn.n0 implements jn.l<n, l2> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l n nVar) {
            kn.l0.p(nVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(n nVar) {
            invoke2(nVar);
            return l2.f10208a;
        }
    }

    public static final class e extends kn.n0 implements jn.l<n, l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l n nVar) {
            kn.l0.p(nVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(n nVar) {
            invoke2(nVar);
            return l2.f10208a;
        }
    }

    public static final class f extends kn.n0 implements jn.p<dk.b, nk.s, Boolean> {
        final /* synthetic */ ik.i[] $mimeTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ik.i[] iVarArr) {
            super(2);
            this.$mimeTypes = iVarArr;
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l dk.b bVar, @os.l nk.s sVar) {
            kn.l0.p(bVar, "$this$condition");
            kn.l0.p(sVar, t2.a.f15437d);
            ik.i iVarC = sVar.c();
            if (iVarC == null) {
                return Boolean.FALSE;
            }
            ik.i[] iVarArr = this.$mimeTypes;
            int length = iVarArr.length;
            boolean z10 = false;
            int i10 = 0;
            while (i10 < length) {
                ik.i iVar = iVarArr[i10];
                i10++;
                if (iVarC.h(iVar)) {
                    z10 = true;
                    break;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class g extends kn.n0 implements jn.p<dk.b, nk.s, Boolean> {
        final /* synthetic */ long $minSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j10) {
            super(2);
            this.$minSize = j10;
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.l dk.b bVar, @os.l nk.s sVar) {
            kn.l0.p(bVar, "$this$condition");
            kn.l0.p(sVar, t2.a.f15437d);
            Long lB = sVar.b();
            boolean z10 = true;
            if (lB != null) {
                if (lB.longValue() < this.$minSize) {
                    z10 = false;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(@os.l t tVar, @os.l jn.p<? super dk.b, ? super nk.s, Boolean> pVar) {
        kn.l0.p(tVar, "<this>");
        kn.l0.p(pVar, "predicate");
        tVar.a().add(pVar);
    }

    public static final void d(t tVar) {
        ik.i.h.f8039a.getClass();
        ik.i iVar = ik.i.h.f8040b;
        ik.i.d dVar = ik.i.d.f8010a;
        dVar.getClass();
        ik.i iVar2 = ik.i.d.f8013d;
        dVar.getClass();
        ik.i iVar3 = ik.i.d.f8014e;
        ik.i.b.f8005a.getClass();
        ik.i iVar4 = ik.i.b.f8006b;
        ik.i.f.f8020a.getClass();
        ik.i iVar5 = ik.i.f.f8021b;
        ik.i.g.f8029a.getClass();
        g(tVar, iVar, iVar2, iVar3, iVar4, iVar5, ik.i.g.f8038j);
        n(tVar, 200L);
    }

    public static final void e(@os.l l.c cVar, @os.l jn.l<? super n, l2> lVar) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(lVar, "block");
        cVar.e("deflate", c0.f6540a, new b(lVar));
    }

    public static /* synthetic */ void f(l.c cVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = a.INSTANCE;
        }
        e(cVar, lVar);
    }

    public static final void g(@os.l t tVar, @os.l ik.i... iVarArr) {
        kn.l0.p(tVar, "<this>");
        kn.l0.p(iVarArr, "mimeTypes");
        c(tVar, new c(iVarArr));
    }

    public static final void h(@os.l l.c cVar, @os.l jn.l<? super n, l2> lVar) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(lVar, "block");
        cVar.e("gzip", h0.f6620a, lVar);
    }

    public static /* synthetic */ void i(l.c cVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = d.INSTANCE;
        }
        h(cVar, lVar);
    }

    public static final void j(@os.l l.c cVar, @os.l jn.l<? super n, l2> lVar) {
        kn.l0.p(cVar, "<this>");
        kn.l0.p(lVar, "block");
        cVar.e("identity", k0.f6659a, lVar);
    }

    public static /* synthetic */ void k(l.c cVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = e.INSTANCE;
        }
        j(cVar, lVar);
    }

    public static final boolean l(dk.b bVar) {
        fl.c cVarC = bVar.c();
        l.f6660c.getClass();
        return cVarC.d(l.f6661d);
    }

    public static final void m(@os.l t tVar, @os.l ik.i... iVarArr) {
        kn.l0.p(tVar, "<this>");
        kn.l0.p(iVarArr, "mimeTypes");
        c(tVar, new f(iVarArr));
    }

    public static final void n(@os.l t tVar, long j10) {
        kn.l0.p(tVar, "<this>");
        c(tVar, new g(j10));
    }

    public static final class b extends kn.n0 implements jn.l<n, l2> {
        final /* synthetic */ jn.l<n, l2> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.l<? super n, l2> lVar) {
            super(1);
            this.$block = lVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l n nVar) {
            kn.l0.p(nVar, "$this$encoder");
            nVar.f6679d = 0.9d;
            this.$block.invoke(nVar);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(n nVar) {
            invoke2(nVar);
            return l2.f10208a;
        }
    }
}
