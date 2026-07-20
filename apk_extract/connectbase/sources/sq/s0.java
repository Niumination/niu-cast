package sq;

import kn.k1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements p0 {

    @xm.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<j<? super n0>, um.d<? super l2>, Object> {
        final /* synthetic */ u0<Integer> $subscriptionCount;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: sq.s0$a$a, reason: collision with other inner class name */
        public static final class C0393a<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k1.a f15332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j<n0> f15333b;

            /* JADX INFO: renamed from: sq.s0$a$a$a, reason: collision with other inner class name */
            @xm.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", i = {}, l = {158}, m = "emit", n = {}, s = {})
            public static final class C0394a extends xm.d {
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0393a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0394a(C0393a<? super T> c0393a, um.d<? super C0394a> dVar) {
                    super(dVar);
                    this.this$0 = c0393a;
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.a(0, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0393a(k1.a aVar, j<? super n0> jVar) {
                this.f15332a = aVar;
                this.f15333b = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @os.m
            public final Object a(int i10, @os.l um.d<? super l2> dVar) {
                C0394a c0394a;
                if (dVar instanceof C0394a) {
                    c0394a = (C0394a) dVar;
                    int i11 = c0394a.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        c0394a.label = i11 - Integer.MIN_VALUE;
                    } else {
                        c0394a = new C0394a(this, dVar);
                    }
                } else {
                    c0394a = new C0394a(this, dVar);
                }
                Object obj = c0394a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i12 = c0394a.label;
                if (i12 == 0) {
                    d1.n(obj);
                    if (i10 > 0) {
                        k1.a aVar2 = this.f15332a;
                        if (!aVar2.element) {
                            aVar2.element = true;
                            j<n0> jVar = this.f15333b;
                            n0 n0Var = n0.START;
                            c0394a.label = 1;
                            if (jVar.emit(n0Var, c0394a) == aVar) {
                                return aVar;
                            }
                        }
                    }
                    return l2.f10208a;
                }
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }

            @Override // sq.j
            public /* bridge */ /* synthetic */ Object emit(Object obj, um.d dVar) {
                return a(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u0<Integer> u0Var, um.d<? super a> dVar) {
            super(2, dVar);
            this.$subscriptionCount = u0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$subscriptionCount, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j jVar = (j) this.L$0;
                k1.a aVar2 = new k1.a();
                u0<Integer> u0Var = this.$subscriptionCount;
                C0393a c0393a = new C0393a(aVar2, jVar);
                this.label = 1;
                if (u0Var.a(c0393a, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            throw new lm.y();
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l j<? super n0> jVar, @os.m um.d<? super l2> dVar) {
            return ((a) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @Override // sq.p0
    @os.l
    public i<n0> a(@os.l u0<Integer> u0Var) {
        return new i0(new a(u0Var, null));
    }

    @os.l
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
