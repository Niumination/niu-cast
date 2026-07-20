package xn;

import eo.t0;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class n<D, E, V> extends s<D, E, V> implements un.m<D, E, V> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final a0.b<a<D, E, V>> f20385z;

    public static final class a<D, E, V> extends t.d<V> implements un.m.b<D, E, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final n<D, E, V> f20386i;

        public a(@os.l n<D, E, V> nVar) {
            l0.p(nVar, "property");
            this.f20386i = nVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20386i;
        }

        @os.l
        public n<D, E, V> O() {
            return this.f20386i;
        }

        public void P(D d10, E e10, V v10) throws vn.a {
            this.f20386i.set(d10, e10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(Object obj, Object obj2, Object obj3) throws vn.a {
            P(obj, obj2, obj3);
            return l2.f10208a;
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20386i;
        }
    }

    public static final class b extends n0 implements jn.a<a<D, E, V>> {
        final /* synthetic */ n<D, E, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n<D, E, V> nVar) {
            super(0);
            this.this$0 = nVar;
        }

        @Override // jn.a
        public final a<D, E, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l j jVar, @os.l String str, @os.l String str2) {
        super(jVar, str, str2);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<D, E, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20385z = bVarB;
    }

    @Override // un.m, un.j
    @os.l
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> getSetter() {
        a<D, E, V> aVarInvoke = this.f20385z.invoke();
        l0.o(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    @Override // un.m
    public void set(D d10, E e10, V v10) throws vn.a {
        getSetter().call(d10, e10, v10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<D, E, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20385z = bVarB;
    }
}
