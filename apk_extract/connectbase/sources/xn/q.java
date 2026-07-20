package xn;

import eo.t0;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public class q<V> extends t<V> implements un.p<V> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final a0.b<a<V>> f20403x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final lm.d0<Object> f20404y;

    public static final class a<R> extends t.c<R> implements un.p.b<R> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final q<R> f20405i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l q<? extends R> qVar) {
            l0.p(qVar, "property");
            this.f20405i = qVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20405i;
        }

        @os.l
        public q<R> O() {
            return this.f20405i;
        }

        @Override // jn.a
        public R invoke() {
            return this.f20405i.get();
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20405i;
        }
    }

    public static final class b extends n0 implements jn.a<a<? extends V>> {
        final /* synthetic */ q<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(q<? extends V> qVar) {
            super(0);
            this.this$0 = qVar;
        }

        @Override // jn.a
        public final a<V> invoke() {
            return new a<>(this.this$0);
        }
    }

    public static final class c extends n0 implements jn.a<Object> {
        final /* synthetic */ q<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(q<? extends V> qVar) {
            super(0);
            this.this$0 = qVar;
        }

        @Override // jn.a
        @os.m
        public final Object invoke() {
            q<V> qVar = this.this$0;
            return qVar.O(qVar.M(), null, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20403x = bVarB;
        this.f20404y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }

    @Override // un.o
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a<V> getGetter() {
        a<V> aVarInvoke = this.f20403x.invoke();
        l0.o(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    @Override // un.p
    public V get() {
        return Q().call(new Object[0]);
    }

    @Override // un.p
    @os.m
    public Object getDelegate() {
        return this.f20404y.getValue();
    }

    @Override // jn.a
    public V invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        super(jVar, str, str2, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20403x = bVarB;
        this.f20404y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }
}
