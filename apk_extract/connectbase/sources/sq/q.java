package sq;

import kn.k1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q {

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {17}, m = "count", n = {b9.i.f771b}, s = {"L$0"})
    public static final class a<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.b(null, this);
        }
    }

    public static final class b<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.f f15325a;

        public b(k1.f fVar) {
            this.f15325a = fVar;
        }

        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15325a.element++;
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {29}, m = "count", n = {b9.i.f771b}, s = {"L$0"})
    public static final class c<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.a(null, null, this);
        }
    }

    public static final class d<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p<T, um.d<? super Boolean>, Object> f15326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.f f15327b;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", i = {0}, l = {30}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends xm.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ d<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(d<? super T> dVar, um.d<? super a> dVar2) {
                super(dVar2);
                this.this$0 = dVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, k1.f fVar) {
            this.f15326a = pVar;
            this.f15327b = fVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object objInvoke = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(objInvoke);
                jn.p<T, um.d<? super Boolean>, Object> pVar = this.f15326a;
                aVar.L$0 = this;
                aVar.label = 1;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (d) aVar.L$0;
                d1.n(objInvoke);
            }
            if (((Boolean) objInvoke).booleanValue()) {
                this.f15327b.element++;
            }
            return l2.f10208a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object a(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super Integer> dVar) {
        c cVar;
        k1.f fVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.f fVar2 = new k1.f();
            j<? super Object> dVar2 = new d<>(pVar, fVar2);
            cVar.L$0 = fVar2;
            cVar.label = 1;
            if (iVar.a(dVar2, cVar) == aVar) {
                return aVar;
            }
            fVar = fVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) cVar.L$0;
            d1.n(obj);
        }
        return new Integer(fVar.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object b(@os.l i<? extends T> iVar, @os.l um.d<? super Integer> dVar) {
        a aVar;
        k1.f fVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.f fVar2 = new k1.f();
            j<? super Object> bVar = new b<>(fVar2);
            aVar.L$0 = fVar2;
            aVar.label = 1;
            if (iVar.a(bVar, aVar) == aVar2) {
                return aVar2;
            }
            fVar = fVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) aVar.L$0;
            d1.n(obj);
        }
        return new Integer(fVar.element);
    }
}
