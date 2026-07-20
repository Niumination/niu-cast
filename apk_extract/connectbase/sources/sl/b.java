package sl;

import kn.l0;
import os.l;
import qn.e;
import qn.f;
import ul.d;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements f<Object, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f15170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f15171b;

        public a(T t10) {
            this.f15171b = t10;
            this.f15170a = t10;
        }

        @Override // qn.f, qn.e
        public T a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f15170a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, T t10) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f15170a = t10;
        }
    }

    @d
    @l
    public static final <T> f<Object, T> b(T t10) {
        return new a(t10);
    }

    @d
    @l
    public static final <T> e<Object, T> c(@l final T t10) {
        l0.p(t10, "value");
        return new e() { // from class: sl.a
            @Override // qn.e
            public final Object a(Object obj, o oVar) {
                return b.d(t10, obj, oVar);
            }
        };
    }

    public static final Object d(Object obj, Object obj2, o oVar) {
        l0.p(obj, "$value");
        l0.p(obj2, "thisRef");
        l0.p(oVar, "property");
        return obj;
    }
}
