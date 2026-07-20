package tq;

import lm.l2;
import vq.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class b0<T> implements sq.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.g f16025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Object f16026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.p<T, um.d<? super l2>, Object> f16027c;

    @xm.f(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<T, um.d<? super l2>, Object> {
        final /* synthetic */ sq.j<T> $downstream;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(sq.j<? super T> jVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$downstream = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$downstream, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to tq.b0$a for r3v4 'this'  um.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r4) {
            /*
                r3 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                lm.d1.n(r4)
                goto L25
            Ld:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L15:
                lm.d1.n(r4)
                java.lang.Object r4 = r3.L$0
                sq.j<T> r1 = r3.$downstream
                r3.label = r2
                java.lang.Object r3 = r1.emit(r4, r3)
                if (r3 != r0) goto L25
                return r0
            L25:
                lm.l2 r3 = lm.l2.f10208a
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: tq.b0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(T t10, @os.m um.d<? super l2> dVar) {
            return ((a) create(t10, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public b0(@os.l sq.j<? super T> jVar, @os.l um.g gVar) {
        this.f16025a = gVar;
        this.f16026b = a1.b(gVar);
        this.f16027c = new a(jVar, null);
    }

    @Override // sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        Object objC = f.c(this.f16025a, t10, this.f16026b, this.f16027c, dVar);
        return objC == wm.a.COROUTINE_SUSPENDED ? objC : l2.f10208a;
    }
}
