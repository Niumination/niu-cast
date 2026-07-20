package sq;

import kn.k1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final i<T> f15270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public final jn.l<T, Object> f15271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    @os.l
    public final jn.p<Object, Object, Boolean> f15272c;

    public static final class a<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g<T> f15273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.h<Object> f15274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j<T> f15275c;

        /* JADX INFO: renamed from: sq.g$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", i = {}, l = {77}, m = "emit", n = {}, s = {})
        public static final class C0386a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ a<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0386a(a<? super T> aVar, um.d<? super C0386a> dVar) {
                super(dVar);
                this.this$0 = aVar;
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
        public a(g<T> gVar, k1.h<Object> hVar, j<? super T> jVar) {
            this.f15273a = gVar;
            this.f15274b = hVar;
            this.f15275c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            C0386a c0386a;
            if (dVar instanceof C0386a) {
                c0386a = (C0386a) dVar;
                int i10 = c0386a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0386a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0386a = new C0386a(this, dVar);
                }
            } else {
                c0386a = new C0386a(this, dVar);
            }
            Object obj = c0386a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0386a.label;
            if (i11 == 0) {
                d1.n(obj);
                T t11 = (T) this.f15273a.f15271b.invoke(t10);
                Object obj2 = this.f15274b.element;
                if (obj2 != tq.u.f16062a && this.f15273a.f15272c.invoke(obj2, t11).booleanValue()) {
                    return l2.f10208a;
                }
                this.f15274b.element = t11;
                j<T> jVar = this.f15275c;
                c0386a.label = 1;
                if (jVar.emit(t10, c0386a) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@os.l i<? extends T> iVar, @os.l jn.l<? super T, ? extends Object> lVar, @os.l jn.p<Object, Object, Boolean> pVar) {
        this.f15270a = iVar;
        this.f15271b = lVar;
        this.f15272c = pVar;
    }

    @Override // sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        k1.h hVar = new k1.h();
        hVar.element = (T) tq.u.f16062a;
        Object objA = this.f15270a.a(new a(this, hVar, jVar), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }
}
