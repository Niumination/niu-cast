package tq;

import kn.h0;
import kn.l0;
import kn.u1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final jn.q<sq.j<Object>, Object, um.d<? super l2>, Object> f16065a;

    public /* synthetic */ class a extends h0 implements jn.q<sq.j<? super Object>, Object, um.d<? super l2>, Object>, xm.n {
        public static final a INSTANCE = new a();

        public a() {
            super(3, sq.j.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ Object invoke(sq.j<? super Object> jVar, Object obj, um.d<? super l2> dVar) {
            return invoke2((sq.j<Object>) jVar, obj, dVar);
        }

        @os.m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@os.l sq.j<Object> jVar, @os.m Object obj, @os.l um.d<? super l2> dVar) {
            return jVar.emit(obj, dVar);
        }
    }

    static {
        a aVar = a.INSTANCE;
        l0.n(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f16065a = (jn.q) u1.q(aVar, 3);
    }

    public static /* synthetic */ void b() {
    }
}
