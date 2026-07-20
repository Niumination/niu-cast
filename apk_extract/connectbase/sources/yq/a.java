package yq;

import kn.h0;
import kn.l0;
import kn.r1;
import kn.u1;
import lm.l2;
import nq.d1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21701a;

    /* JADX INFO: renamed from: yq.a$a, reason: collision with other inner class name */
    @r1({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
    public static final class RunnableC0602a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f21702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f21703b;

        public RunnableC0602a(m mVar, a aVar) {
            this.f21702a = mVar;
            this.f21703b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f21702a.i(this.f21703b, l2.f10208a);
        }
    }

    public /* synthetic */ class b extends h0 implements jn.q<a, m<?>, Object, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l a aVar, @os.l m<?> mVar, @os.m Object obj) {
            aVar.d(mVar, obj);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(a aVar, m<?> mVar, Object obj) {
            invoke2(aVar, mVar, obj);
            return l2.f10208a;
        }
    }

    public a(long j10) {
        this.f21701a = j10;
    }

    public static /* synthetic */ void c() {
    }

    @os.l
    public final e b() {
        b bVar = b.INSTANCE;
        l0.n(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new f(this, (jn.q) u1.q(bVar, 3), null, 4, null);
    }

    public final void d(m<?> mVar, Object obj) {
        if (this.f21701a <= 0) {
            mVar.f(l2.f10208a);
            return;
        }
        RunnableC0602a runnableC0602a = new RunnableC0602a(mVar, this);
        l0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        um.g context = mVar.getContext();
        mVar.g(d1.d(context).E(this.f21701a, runnableC0602a, context));
    }
}
