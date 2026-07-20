package xn;

import eo.t0;
import java.lang.reflect.Member;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public class r<T, V> extends t<V> implements un.q<T, V> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final a0.b<a<T, V>> f20406x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final lm.d0<Member> f20407y;

    public static final class a<T, V> extends t.c<V> implements un.q.b<T, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final r<T, V> f20408i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l r<T, ? extends V> rVar) {
            l0.p(rVar, "property");
            this.f20408i = rVar;
        }

        @Override // xn.t.a
        public t M() {
            return this.f20408i;
        }

        @os.l
        public r<T, V> O() {
            return this.f20408i;
        }

        @Override // jn.l
        public V invoke(T t10) {
            return this.f20408i.get(t10);
        }

        @Override // un.o.a
        public un.o j() {
            return this.f20408i;
        }
    }

    public static final class b extends n0 implements jn.a<a<T, ? extends V>> {
        final /* synthetic */ r<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(r<T, ? extends V> rVar) {
            super(0);
            this.this$0 = rVar;
        }

        @Override // jn.a
        public final a<T, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    public static final class c extends n0 implements jn.a<Member> {
        final /* synthetic */ r<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(r<T, ? extends V> rVar) {
            super(0);
            this.this$0 = rVar;
        }

        @Override // jn.a
        @os.m
        public final Member invoke() {
            return this.this$0.M();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@os.l j jVar, @os.l String str, @os.l String str2, @os.m Object obj) {
        super(jVar, str, str2, obj);
        l0.p(jVar, "container");
        l0.p(str, "name");
        l0.p(str2, "signature");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20406x = bVarB;
        this.f20407y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }

    @Override // un.o
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public a<T, V> getGetter() {
        a<T, V> aVarInvoke = this.f20406x.invoke();
        l0.o(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    @Override // un.q
    public V get(T t10) {
        return getGetter().call(t10);
    }

    @Override // un.q
    @os.m
    public Object getDelegate(T t10) {
        return O(this.f20407y.getValue(), t10, null);
    }

    @Override // jn.l
    public V invoke(T t10) {
        return get(t10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@os.l j jVar, @os.l t0 t0Var) {
        super(jVar, t0Var);
        l0.p(jVar, "container");
        l0.p(t0Var, "descriptor");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        l0.o(bVarB, "lazy { Getter(this) }");
        this.f20406x = bVarB;
        this.f20407y = lm.f0.c(lm.h0.PUBLICATION, new c(this));
    }
}
