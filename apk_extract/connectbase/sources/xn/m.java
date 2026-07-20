package xn;

import eo.t0;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class m<T, V> extends r<T, V> implements un.l<T, V> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final a0.b<a<T, V>> f20383z;

    public static final class a<T, V> extends t.d<V> implements un.l.b<T, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final m<T, V> f20384i;

        public a(@os.l m<T, V> mVar) {
            l0.p(mVar, "property");
            this.f20384i = mVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20384i;
        }

        @os.l
        public m<T, V> O() {
            return this.f20384i;
        }

        public void P(T t10, V v10) throws vn.a {
            this.f20384i.set(t10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(Object obj, Object obj2) throws vn.a {
            P(obj, obj2);
            return l2.f10208a;
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20384i;
        }
    }

    public static final class b extends n0 implements jn.a<a<T, V>> {
        final /* synthetic */ m<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m<T, V> mVar) {
            super(0);
            this.this$0 = mVar;
        }

        @Override // jn.a
        public final a<T, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        super(jVar, str, str2, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20383z = bVarB;
    }

    @Override // un.l, un.j
    @os.l
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public a<T, V> getSetter() {
        a<T, V> aVarInvoke = this.f20383z.invoke();
        l0.o(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    @Override // un.l
    public void set(T t10, V v10) throws vn.a {
        getSetter().call(t10, v10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Setter(this) }");
        this.f20383z = bVarB;
    }
}
