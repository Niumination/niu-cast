package pq;

import kn.r1;
import lm.a1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.s0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n514#2,6:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,6\n*E\n"})
public final /* synthetic */ class s {

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ Object $element;
        final /* synthetic */ g0<Object> $this_sendBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g0<Object> g0Var, Object obj, um.d<? super a> dVar) {
            super(2, dVar);
            this.$this_sendBlocking = g0Var;
            this.$element = obj;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$this_sendBlocking, this.$element, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                g0<Object> g0Var = this.$this_sendBlocking;
                Object obj2 = this.$element;
                this.label = 1;
                if (g0Var.L(obj2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super p<? extends l2>>, Object> {
        final /* synthetic */ E $element;
        final /* synthetic */ g0<E> $this_trySendBlocking;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(g0<? super E> g0Var, E e10, um.d<? super b> dVar) {
            super(2, dVar);
            this.$this_trySendBlocking = g0Var;
            this.$element = e10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$this_trySendBlocking, this.$element, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super p<? extends l2>> dVar) {
            return invoke2(s0Var, (um.d<? super p<l2>>) dVar);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            Object objM59constructorimpl;
            Object objA;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    g0<E> g0Var = this.$this_trySendBlocking;
                    E e10 = this.$element;
                    c1.a aVar2 = c1.Companion;
                    this.label = 1;
                    if (g0Var.L(e10, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
            } catch (Throwable th2) {
                c1.a aVar3 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
            }
            if (c1.m65isSuccessimpl(objM59constructorimpl)) {
                p.b bVar = p.f13308b;
                l2 l2Var = l2.f10208a;
                bVar.getClass();
                objA = p.c(l2Var);
            } else {
                objA = p.f13308b.a(c1.m62exceptionOrNullimpl(objM59constructorimpl));
            }
            return p.b(objA);
        }

        @os.m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@os.l s0 s0Var, @os.m um.d<? super p<l2>> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @a1(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void a(g0 g0Var, Object obj) throws InterruptedException {
        if (p.m(g0Var.w(obj))) {
            return;
        }
        nq.j.b(null, new a(g0Var, obj, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <E> Object b(@os.l g0<? super E> g0Var, E e10) {
        Object objW = g0Var.w(e10);
        if (objW instanceof p.c) {
            return ((p) nq.j.b(null, new b(g0Var, e10, null), 1, null)).f13310a;
        }
        p.b bVar = p.f13308b;
        l2 l2Var = l2.f10208a;
        bVar.getClass();
        return p.c(l2Var);
    }
}
