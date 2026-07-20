package xn;

import eo.t0;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class l<V> extends q<V> implements un.k<V> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final a0.b<a<V>> f20381z;

    public static final class a<R> extends t.d<R> implements un.k.b<R> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final l<R> f20382i;

        public a(@os.l l<R> lVar) {
            l0.p(lVar, "property");
            this.f20382i = lVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20382i;
        }

        @os.l
        public l<R> O() {
            return this.f20382i;
        }

        public void P(R r10) throws vn.a {
            this.f20382i.set(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) throws vn.a {
            P(obj);
            return l2.f10208a;
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20382i;
        }
    }

    public static final class b extends n0 implements jn.a<a<V>> {
        final /* synthetic */ l<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l<V> lVar) {
            super(0);
            this.this$0 = lVar;
        }

        @Override // jn.a
        public final a<V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20381z = bVarB;
    }

    @Override // un.k, un.j
    @os.l
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        a<V> aVarInvoke = this.f20381z.invoke();
        l0.o(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    @Override // un.k
    public void set(V v10) throws vn.a {
        getSetter().call(v10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        super(jVar, str, str2, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20381z = bVarB;
    }
}
