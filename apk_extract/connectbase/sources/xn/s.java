package xn;

import eo.t0;
import java.lang.reflect.Member;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public class s<D, E, V> extends t<V> implements un.r<D, E, V> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final a0.b<a<D, E, V>> f20409x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final lm.d0<Member> f20410y;

    public static final class a<D, E, V> extends t.c<V> implements un.r.b<D, E, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final s<D, E, V> f20411i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l s<D, E, ? extends V> sVar) {
            l0.p(sVar, "property");
            this.f20411i = sVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20411i;
        }

        @os.l
        public s<D, E, V> O() {
            return this.f20411i;
        }

        @Override // jn.p
        public V invoke(D d10, E e10) {
            return this.f20411i.get(d10, e10);
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20411i;
        }
    }

    public static final class b extends n0 implements jn.a<a<D, E, ? extends V>> {
        final /* synthetic */ s<D, E, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(s<D, E, ? extends V> sVar) {
            super(0);
            this.this$0 = sVar;
        }

        @Override // jn.a
        public final a<D, E, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    public static final class c extends n0 implements jn.a<Member> {
        final /* synthetic */ s<D, E, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(s<D, E, ? extends V> sVar) {
            super(0);
            this.this$0 = sVar;
        }

        @Override // jn.a
        @os.m
        public final Member invoke() {
            return this.this$0.M();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@os.l j jVar, @os.l String str, @os.l String str2) {
        super(jVar, str, str2, kn.q.NO_RECEIVER);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<D, E, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20409x = bVarB;
        this.f20410y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }

    @Override // un.o
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> getGetter() {
        a<D, E, V> aVarInvoke = this.f20409x.invoke();
        l0.o(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    @Override // un.r
    public V get(D d10, E e10) {
        return getGetter().call(d10, e10);
    }

    @Override // un.r
    @os.m
    public Object getDelegate(D d10, E e10) {
        return O(this.f20410y.getValue(), d10, e10);
    }

    @Override // jn.p
    public V invoke(D d10, E e10) {
        return get(d10, e10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<D, E, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20409x = bVarB;
        this.f20410y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }
}
