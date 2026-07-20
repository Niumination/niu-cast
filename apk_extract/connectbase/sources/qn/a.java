package qn;

import jn.q;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f14050a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: qn.a$a, reason: collision with other inner class name */
    @r1({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$observable$1\n*L\n1#1,73:1\n*E\n"})
    public static final class C0342a<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q<o<?>, T, T, l2> f14051b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0342a(T t10, q<? super o<?>, ? super T, ? super T, l2> qVar) {
            super(t10);
            this.f14051b = qVar;
        }

        @Override // qn.c
        public void c(@l o<?> oVar, T t10, T t11) {
            l0.p(oVar, "property");
            this.f14051b.invoke(oVar, t10, t11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n*L\n1#1,73:1\n*E\n"})
    public static final class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q<o<?>, T, T, Boolean> f14052b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t10, q<? super o<?>, ? super T, ? super T, Boolean> qVar) {
            super(t10);
            this.f14052b = qVar;
        }

        @Override // qn.c
        public boolean d(@l o<?> oVar, T t10, T t11) {
            l0.p(oVar, "property");
            return this.f14052b.invoke(oVar, t10, t11).booleanValue();
        }
    }

    @l
    public final <T> f<Object, T> a() {
        return new qn.b();
    }

    @l
    public final <T> f<Object, T> b(T t10, @l q<? super o<?>, ? super T, ? super T, l2> qVar) {
        l0.p(qVar, "onChange");
        return new C0342a(t10, qVar);
    }

    @l
    public final <T> f<Object, T> c(T t10, @l q<? super o<?>, ? super T, ? super T, Boolean> qVar) {
        l0.p(qVar, "onChange");
        return new b(t10, qVar);
    }
}
