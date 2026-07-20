package pq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kn.n0;
import kn.r1;
import lm.d1;
import lm.l2;
import lm.t0;
import lm.z0;
import nm.s0;
import nq.c2;
import nq.k1;
import wj.t1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n82#2,11:480\n82#2,11:491\n82#2,11:502\n82#2,11:513\n105#2:524\n82#2,6:525\n106#2:531\n92#2:532\n107#2:533\n88#2,3:534\n82#2,11:537\n105#2:548\n82#2,6:549\n106#2,2:555\n92#2:557\n88#2,3:558\n82#2,11:561\n82#2,11:572\n82#2,11:583\n105#2:594\n82#2,6:595\n106#2,2:601\n92#2:603\n88#2,3:604\n105#2:607\n82#2,6:608\n106#2,2:614\n92#2:616\n88#2,3:617\n105#2:620\n82#2,6:621\n106#2,2:627\n92#2:629\n88#2,3:630\n105#2:633\n82#2,6:634\n106#2,2:640\n92#2:642\n88#2,3:643\n105#2:646\n82#2,6:647\n106#2,2:653\n92#2:655\n88#2,3:656\n82#2,11:659\n105#2:670\n82#2,6:671\n106#2,2:677\n92#2:679\n88#2,3:680\n82#2,11:683\n82#2,11:694\n82#2,11:705\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n*L\n34#1:480,11\n49#1:491,11\n63#1:502,11\n73#1:513,11\n84#1:524\n84#1:525,6\n84#1:531\n84#1:532\n84#1:533\n84#1:534,3\n95#1:537,11\n110#1:548\n110#1:549,6\n110#1:555,2\n110#1:557\n110#1:558,3\n121#1:561,11\n134#1:572,11\n147#1:583,11\n232#1:594\n232#1:595,6\n232#1:601,2\n232#1:603\n232#1:604,3\n241#1:607\n241#1:608,6\n241#1:614,2\n241#1:616\n241#1:617,3\n277#1:620\n277#1:621,6\n277#1:627,2\n277#1:629\n277#1:630,3\n285#1:633\n285#1:634,6\n285#1:640,2\n285#1:642\n285#1:643,3\n298#1:646\n298#1:647,6\n298#1:653,2\n298#1:655\n298#1:656,3\n403#1:659,11\n411#1:670\n411#1:671,6\n411#1:677,2\n411#1:679\n411#1:680,3\n418#1:683,11\n432#1:694,11\n446#1:705,11\n*E\n"})
public final /* synthetic */ class u {

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
    public static final class a<E> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.a(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class a0<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public a0(um.d<? super a0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.N(null, null, this);
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ pq.f0<?> $this_consumes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pq.f0<?> f0Var) {
            super(1);
            this.$this_consumes = f0Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            pq.t.a(this.$this_consumes, th2);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    public static final class b0<E> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b0(um.d<? super b0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.O(null, this);
        }
    }

    @r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n75#2:480\n1#3:481\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n*L\n26#1:480\n*E\n"})
    public static final class c extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ pq.f0<?>[] $channels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pq.f0<?>[] f0VarArr) {
            super(1);
            this.$channels = f0VarArr;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) throws Throwable {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) throws Throwable {
            Throwable th3 = null;
            for (pq.f0<?> f0Var : this.$channels) {
                try {
                    pq.t.a(f0Var, th2);
                } catch (Throwable th4) {
                    if (th3 == null) {
                        th3 = th4;
                    } else {
                        lm.p.a(th3, th4);
                    }
                }
            }
            if (th3 != null) {
                throw th3;
            }
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c0 extends xm.o implements jn.p<Object, um.d<Object>, Object> {
        final /* synthetic */ pq.f0<Object> $this_requireNoNulls;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(pq.f0<Object> f0Var, um.d<? super c0> dVar) {
            super(2, dVar);
            this.$this_requireNoNulls = f0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c0 c0Var = new c0(this.$this_requireNoNulls, dVar);
            c0Var.L$0 = obj;
            return c0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            Object obj2 = this.L$0;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + n1.e.f11183c);
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.m Object obj, @os.m um.d<Object> dVar) {
            return ((c0) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    public static final class d<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.d(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {136, 139}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class d0<E> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public d0(um.d<? super d0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.Q(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<Object, um.d<Object>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public e(um.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            e eVar = new e(dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return this.L$0;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(Object obj, @os.m um.d<Object> dVar) {
            return ((e) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {149, 152}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class e0<E> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public e0(um.d<? super e0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.R(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    public static final class f<E> extends xm.o implements jn.p<pq.d0<? super E>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<E, um.d<? super K>, Object> $selector;
        final /* synthetic */ pq.f0<E> $this_distinctBy;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(pq.f0<? extends E> f0Var, jn.p<? super E, ? super um.d<? super K>, ? extends Object> pVar, um.d<? super f> dVar) {
            super(2, dVar);
            this.$this_distinctBy = f0Var;
            this.$selector = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            f fVar = new f(this.$this_distinctBy, this.$selector, dVar);
            fVar.L$0 = obj;
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.HashSet] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v18 */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v20 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, pq.g0] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009f -> B:29:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b2 -> B:28:0x00b4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to pq.u$f<E> for r10v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r11) {
            /*
                r10 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r10.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L4f
                if (r1 == r4) goto L3f
                if (r1 == r3) goto L2a
                if (r1 != r2) goto L22
                java.lang.Object r1 = r10.L$3
                java.lang.Object r5 = r10.L$2
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r10.L$1
                java.util.HashSet r6 = (java.util.HashSet) r6
                java.lang.Object r7 = r10.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r11)
                goto Lb4
            L22:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L2a:
                java.lang.Object r1 = r10.L$3
                java.lang.Object r5 = r10.L$2
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r10.L$1
                java.util.HashSet r6 = (java.util.HashSet) r6
                java.lang.Object r7 = r10.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r11)
                r9 = r5
                r5 = r1
                r1 = r9
                goto L9b
            L3f:
                java.lang.Object r1 = r10.L$2
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r10.L$1
                java.util.HashSet r5 = (java.util.HashSet) r5
                java.lang.Object r6 = r10.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r11)
                goto L77
            L4f:
                lm.d1.n(r11)
                java.lang.Object r11 = r10.L$0
                pq.d0 r11 = (pq.d0) r11
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                pq.f0<E> r5 = r10.$this_distinctBy
                pq.n r5 = r5.iterator()
                r6 = r11
                r9 = r5
                r5 = r1
                r1 = r9
            L65:
                r10.L$0 = r6
                r10.L$1 = r5
                r10.L$2 = r1
                r11 = 0
                r10.L$3 = r11
                r10.label = r4
                java.lang.Object r11 = r1.b(r10)
                if (r11 != r0) goto L77
                return r0
            L77:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto Lbb
                java.lang.Object r11 = r1.next()
                jn.p<E, um.d<? super K>, java.lang.Object> r7 = r10.$selector
                r10.L$0 = r6
                r10.L$1 = r5
                r10.L$2 = r1
                r10.L$3 = r11
                r10.label = r3
                java.lang.Object r7 = r7.invoke(r11, r10)
                if (r7 != r0) goto L96
                return r0
            L96:
                r9 = r5
                r5 = r11
                r11 = r7
                r7 = r6
                r6 = r9
            L9b:
                boolean r8 = r6.contains(r11)
                if (r8 != 0) goto Lb8
                r10.L$0 = r7
                r10.L$1 = r6
                r10.L$2 = r1
                r10.L$3 = r11
                r10.label = r2
                java.lang.Object r5 = r7.L(r5, r10)
                if (r5 != r0) goto Lb2
                return r0
            Lb2:
                r5 = r1
                r1 = r11
            Lb4:
                r6.add(r1)
                r1 = r5
            Lb8:
                r5 = r6
                r6 = r7
                goto L65
            Lbb:
                lm.l2 r10 = lm.l2.f10208a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super E> d0Var, @os.m um.d<? super l2> dVar) {
            return ((f) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {t1.N, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class f0 extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ pq.f0<Object> $this_take;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(int i10, pq.f0<Object> f0Var, um.d<? super f0> dVar) {
            super(2, dVar);
            this.$n = i10;
            this.$this_take = f0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            f0 f0Var = new f0(this.$n, this.$this_take, dVar);
            f0Var.L$0 = obj;
            return f0Var;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x005a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x005b  */
        /* JADX WARN: Code duplicated, block: B:26:0x0066  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x007d  */
        /* JADX WARN: Code duplicated, block: B:33:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0076 -> B:7:0x0019). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                r7 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L31
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                int r1 = r7.I$0
                java.lang.Object r4 = r7.L$1
                pq.n r4 = (pq.n) r4
                java.lang.Object r5 = r7.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r8)
            L19:
                r8 = r5
                goto L79
            L1b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L23:
                int r1 = r7.I$0
                java.lang.Object r4 = r7.L$1
                pq.n r4 = (pq.n) r4
                java.lang.Object r5 = r7.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r8)
                goto L5e
            L31:
                lm.d1.n(r8)
                java.lang.Object r8 = r7.L$0
                pq.d0 r8 = (pq.d0) r8
                int r1 = r7.$n
                if (r1 != 0) goto L3f
                lm.l2 r7 = lm.l2.f10208a
                return r7
            L3f:
                if (r1 < 0) goto L43
                r4 = r3
                goto L44
            L43:
                r4 = 0
            L44:
                if (r4 == 0) goto L83
                pq.f0<java.lang.Object> r4 = r7.$this_take
                pq.n r4 = r4.iterator()
            L4c:
                r7.L$0 = r8
                r7.L$1 = r4
                r7.I$0 = r1
                r7.label = r3
                java.lang.Object r5 = r4.b(r7)
                if (r5 != r0) goto L5b
                return r0
            L5b:
                r6 = r5
                r5 = r8
                r8 = r6
            L5e:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L80
                java.lang.Object r8 = r4.next()
                r7.L$0 = r5
                r7.L$1 = r4
                r7.I$0 = r1
                r7.label = r2
                java.lang.Object r8 = r5.L(r8, r7)
                if (r8 != r0) goto L19
                return r0
            L79:
                int r1 = r1 + (-1)
                if (r1 != 0) goto L4c
                lm.l2 r7 = lm.l2.f10208a
                return r7
            L80:
                lm.l2 r7 = lm.l2.f10208a
                return r7
            L83:
                java.lang.String r7 = "Requested element count "
                java.lang.String r8 = " is less than zero."
                java.lang.String r7 = k.b.a(r7, r1, r8)
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r7 = r7.toString()
                r8.<init>(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.f0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((f0) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$drop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, m1.c.f10305f}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    public static final class g extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ pq.f0<Object> $this_drop;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i10, pq.f0<Object> f0Var, um.d<? super g> dVar) {
            super(2, dVar);
            this.$n = i10;
            this.$this_drop = f0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            g gVar = new g(this.$n, this.$this_drop, dVar);
            gVar.L$0 = obj;
            return gVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x006e  */
        /* JADX WARN: Code duplicated, block: B:31:0x0088 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0089  */
        /* JADX WARN: Code duplicated, block: B:35:0x0094  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0063 -> B:23:0x0066). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a2 -> B:8:0x001a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r9) {
            /*
                r8 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3e
                if (r1 == r4) goto L30
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r1 = r8.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r8.L$0
                pq.d0 r4 = (pq.d0) r4
                lm.d1.n(r9)
            L1a:
                r9 = r4
                goto L7c
            L1c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L24:
                java.lang.Object r1 = r8.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r8.L$0
                pq.d0 r4 = (pq.d0) r4
                lm.d1.n(r9)
                goto L8c
            L30:
                int r1 = r8.I$0
                java.lang.Object r5 = r8.L$1
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r8.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r9)
                goto L66
            L3e:
                lm.d1.n(r9)
                java.lang.Object r9 = r8.L$0
                pq.d0 r9 = (pq.d0) r9
                int r1 = r8.$n
                if (r1 < 0) goto L4b
                r5 = r4
                goto L4c
            L4b:
                r5 = 0
            L4c:
                if (r5 == 0) goto La8
                if (r1 <= 0) goto L76
                pq.f0<java.lang.Object> r5 = r8.$this_drop
                pq.n r5 = r5.iterator()
                r6 = r9
            L57:
                r8.L$0 = r6
                r8.L$1 = r5
                r8.I$0 = r1
                r8.label = r4
                java.lang.Object r9 = r5.b(r8)
                if (r9 != r0) goto L66
                return r0
            L66:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L75
                r5.next()
                int r1 = r1 + (-1)
                if (r1 != 0) goto L57
            L75:
                r9 = r6
            L76:
                pq.f0<java.lang.Object> r1 = r8.$this_drop
                pq.n r1 = r1.iterator()
            L7c:
                r8.L$0 = r9
                r8.L$1 = r1
                r8.label = r3
                java.lang.Object r4 = r1.b(r8)
                if (r4 != r0) goto L89
                return r0
            L89:
                r7 = r4
                r4 = r9
                r9 = r7
            L8c:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto La5
                java.lang.Object r9 = r1.next()
                r8.L$0 = r4
                r8.L$1 = r1
                r8.label = r2
                java.lang.Object r9 = r4.L(r9, r8)
                if (r9 != r0) goto L1a
                return r0
            La5:
                lm.l2 r8 = lm.l2.f10208a
                return r8
            La8:
                java.lang.String r8 = "Requested element count "
                java.lang.String r9 = " is less than zero."
                java.lang.String r8 = k.b.a(r8, r1, r9)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((g) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    public static final class g0 extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<Object, um.d<? super Boolean>, Object> $predicate;
        final /* synthetic */ pq.f0<Object> $this_takeWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g0(pq.f0<Object> f0Var, jn.p<Object, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super g0> dVar) {
            super(2, dVar);
            this.$this_takeWhile = f0Var;
            this.$predicate = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            g0 g0Var = new g0(this.$this_takeWhile, this.$predicate, dVar);
            g0Var.L$0 = obj;
            return g0Var;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0057 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0060  */
        /* JADX WARN: Code duplicated, block: B:20:0x0074 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0075  */
        /* JADX WARN: Code duplicated, block: B:24:0x0082  */
        /* JADX WARN: Code duplicated, block: B:26:0x0085  */
        /* JADX WARN: Code duplicated, block: B:28:0x0094 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x0095  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0095 -> B:13:0x004b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r9) {
            /*
                r8 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3d
                if (r1 == r4) goto L31
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r8.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r8.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r9)
                goto L4b
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L23:
                java.lang.Object r1 = r8.L$2
                java.lang.Object r5 = r8.L$1
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r8.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r9)
                goto L7a
            L31:
                java.lang.Object r1 = r8.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r8.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r9)
                goto L58
            L3d:
                lm.d1.n(r9)
                java.lang.Object r9 = r8.L$0
                pq.d0 r9 = (pq.d0) r9
                pq.f0<java.lang.Object> r1 = r8.$this_takeWhile
                pq.n r1 = r1.iterator()
                r5 = r9
            L4b:
                r8.L$0 = r5
                r8.L$1 = r1
                r8.label = r4
                java.lang.Object r9 = r1.b(r8)
                if (r9 != r0) goto L58
                return r0
            L58:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L98
                java.lang.Object r9 = r1.next()
                jn.p<java.lang.Object, um.d<? super java.lang.Boolean>, java.lang.Object> r6 = r8.$predicate
                r8.L$0 = r5
                r8.L$1 = r1
                r8.L$2 = r9
                r8.label = r3
                java.lang.Object r6 = r6.invoke(r9, r8)
                if (r6 != r0) goto L75
                return r0
            L75:
                r7 = r1
                r1 = r9
                r9 = r6
                r6 = r5
                r5 = r7
            L7a:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L85
                lm.l2 r8 = lm.l2.f10208a
                return r8
            L85:
                r8.L$0 = r6
                r8.L$1 = r5
                r9 = 0
                r8.L$2 = r9
                r8.label = r2
                java.lang.Object r9 = r6.L(r1, r8)
                if (r9 != r0) goto L95
                return r0
            L95:
                r1 = r5
                r5 = r6
                goto L4b
            L98:
                lm.l2 r8 = lm.l2.f10208a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.g0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((g0) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    public static final class h extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<Object, um.d<? super Boolean>, Object> $predicate;
        final /* synthetic */ pq.f0<Object> $this_dropWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(pq.f0<Object> f0Var, jn.p<Object, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super h> dVar) {
            super(2, dVar);
            this.$this_dropWhile = f0Var;
            this.$predicate = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            h hVar = new h(this.$this_dropWhile, this.$predicate, dVar);
            hVar.L$0 = obj;
            return hVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0088  */
        /* JADX WARN: Code duplicated, block: B:27:0x009c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x009d  */
        /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:35:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:43:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:45:0x00ec A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00ed  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009d -> B:16:0x0052). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ea -> B:10:0x0021). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((h) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 278}, m = "toChannel", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv", RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class h0<E, C extends pq.g0<? super E>> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public h0(um.d<? super h0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.W(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    public static final class i<E> extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public i(um.d<? super i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.l(null, 0, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    public static final class i0<E, C extends Collection<? super E>> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public i0(um.d<? super i0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.X(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    public static final class j<E> extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public j(um.d<? super j> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.m(null, 0, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    public static final class j0<K, V, M extends Map<? super K, ? super V>> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public j0(um.d<? super j0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.Y(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    public static final class k<E> extends xm.o implements jn.p<pq.d0<? super E>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<E, um.d<? super Boolean>, Object> $predicate;
        final /* synthetic */ pq.f0<E> $this_filter;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public k(pq.f0<? extends E> f0Var, jn.p<? super E, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super k> dVar) {
            super(2, dVar);
            this.$this_filter = f0Var;
            this.$predicate = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            k kVar = new k(this.$this_filter, this.$predicate, dVar);
            kVar.L$0 = obj;
            return kVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x005d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0066  */
        /* JADX WARN: Code duplicated, block: B:20:0x007a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x007b  */
        /* JADX WARN: Code duplicated, block: B:24:0x0087  */
        /* JADX WARN: Code duplicated, block: B:26:0x0095 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0096  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v13, types: [pq.d0] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, pq.g0] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r10) {
            /*
                r9 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L41
                if (r1 == r5) goto L35
                if (r1 == r4) goto L24
                if (r1 != r3) goto L1c
                java.lang.Object r1 = r9.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r6 = r9.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r10)
                goto L4f
            L1c:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L24:
                java.lang.Object r1 = r9.L$2
                java.lang.Object r6 = r9.L$1
                pq.n r6 = (pq.n) r6
                java.lang.Object r7 = r9.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r10)
                r8 = r6
                r6 = r1
                r1 = r8
                goto L7f
            L35:
                java.lang.Object r1 = r9.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r6 = r9.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r10)
                goto L5e
            L41:
                lm.d1.n(r10)
                java.lang.Object r10 = r9.L$0
                pq.d0 r10 = (pq.d0) r10
                pq.f0<E> r1 = r9.$this_filter
                pq.n r1 = r1.iterator()
                r6 = r10
            L4f:
                r9.L$0 = r6
                r9.L$1 = r1
                r9.L$2 = r2
                r9.label = r5
                java.lang.Object r10 = r1.b(r9)
                if (r10 != r0) goto L5e
                return r0
            L5e:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L98
                java.lang.Object r10 = r1.next()
                jn.p<E, um.d<? super java.lang.Boolean>, java.lang.Object> r7 = r9.$predicate
                r9.L$0 = r6
                r9.L$1 = r1
                r9.L$2 = r10
                r9.label = r4
                java.lang.Object r7 = r7.invoke(r10, r9)
                if (r7 != r0) goto L7b
                return r0
            L7b:
                r8 = r6
                r6 = r10
                r10 = r7
                r7 = r8
            L7f:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L96
                r9.L$0 = r7
                r9.L$1 = r1
                r9.L$2 = r2
                r9.label = r3
                java.lang.Object r10 = r7.L(r6, r9)
                if (r10 != r0) goto L96
                return r0
            L96:
                r6 = r7
                goto L4f
            L98:
                lm.l2 r9 = lm.l2.f10208a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super E> d0Var, @os.m um.d<? super l2> dVar) {
            return ((k) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class k0 extends xm.o implements jn.p<pq.d0<? super s0<Object>>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.f0<Object> $this_withIndex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(pq.f0<Object> f0Var, um.d<? super k0> dVar) {
            super(2, dVar);
            this.$this_withIndex = f0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            k0 k0Var = new k0(this.$this_withIndex, dVar);
            k0Var.L$0 = obj;
            return k0Var;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0050 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0051  */
        /* JADX WARN: Code duplicated, block: B:17:0x005f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0078 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0079  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0079 -> B:11:0x0042). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r11) {
            /*
                r10 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L34
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                int r1 = r10.I$0
                java.lang.Object r4 = r10.L$1
                pq.n r4 = (pq.n) r4
                java.lang.Object r5 = r10.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r11)
                r11 = r5
                r8 = r4
                r4 = r1
                r1 = r8
                goto L42
            L1e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L26:
                int r1 = r10.I$0
                java.lang.Object r4 = r10.L$1
                pq.n r4 = (pq.n) r4
                java.lang.Object r5 = r10.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r11)
                goto L57
            L34:
                lm.d1.n(r11)
                java.lang.Object r11 = r10.L$0
                pq.d0 r11 = (pq.d0) r11
                pq.f0<java.lang.Object> r1 = r10.$this_withIndex
                pq.n r1 = r1.iterator()
                r4 = 0
            L42:
                r10.L$0 = r11
                r10.L$1 = r1
                r10.I$0 = r4
                r10.label = r3
                java.lang.Object r5 = r1.b(r10)
                if (r5 != r0) goto L51
                return r0
            L51:
                r8 = r5
                r5 = r11
                r11 = r8
                r9 = r4
                r4 = r1
                r1 = r9
            L57:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto L7d
                java.lang.Object r11 = r4.next()
                nm.s0 r6 = new nm.s0
                int r7 = r1 + 1
                r6.<init>(r1, r11)
                r10.L$0 = r5
                r10.L$1 = r4
                r10.I$0 = r7
                r10.label = r2
                java.lang.Object r11 = r5.L(r6, r10)
                if (r11 != r0) goto L79
                return r0
            L79:
                r1 = r4
                r11 = r5
                r4 = r7
                goto L42
            L7d:
                lm.l2 r10 = lm.l2.f10208a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.k0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super s0<Object>> d0Var, @os.m um.d<? super l2> dVar) {
            return ((k0) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    public static final class l extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ jn.q<Integer, Object, um.d<? super Boolean>, Object> $predicate;
        final /* synthetic */ pq.f0<Object> $this_filterIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public l(pq.f0<Object> f0Var, jn.q<? super Integer, Object, ? super um.d<? super Boolean>, ? extends Object> qVar, um.d<? super l> dVar) {
            super(2, dVar);
            this.$this_filterIndexed = f0Var;
            this.$predicate = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            l lVar = new l(this.$this_filterIndexed, this.$predicate, dVar);
            lVar.L$0 = obj;
            return lVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0069 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0072  */
        /* JADX WARN: Code duplicated, block: B:20:0x008f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0090  */
        /* JADX WARN: Code duplicated, block: B:24:0x009c  */
        /* JADX WARN: Code duplicated, block: B:26:0x00ac A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00ad  */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                r12 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r12.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L47
                if (r1 == r5) goto L39
                if (r1 == r4) goto L26
                if (r1 != r3) goto L1e
                int r1 = r12.I$0
                java.lang.Object r6 = r12.L$1
                pq.n r6 = (pq.n) r6
                java.lang.Object r7 = r12.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r13)
                goto L59
            L1e:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L26:
                int r1 = r12.I$0
                java.lang.Object r6 = r12.L$2
                java.lang.Object r7 = r12.L$1
                pq.n r7 = (pq.n) r7
                java.lang.Object r8 = r12.L$0
                pq.d0 r8 = (pq.d0) r8
                lm.d1.n(r13)
                r11 = r7
                r7 = r6
                r6 = r11
                goto L94
            L39:
                int r1 = r12.I$0
                java.lang.Object r6 = r12.L$1
                pq.n r6 = (pq.n) r6
                java.lang.Object r7 = r12.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r13)
                goto L6a
            L47:
                lm.d1.n(r13)
                java.lang.Object r13 = r12.L$0
                pq.d0 r13 = (pq.d0) r13
                pq.f0<java.lang.Object> r1 = r12.$this_filterIndexed
                pq.n r1 = r1.iterator()
                r6 = 0
                r7 = r13
                r11 = r6
                r6 = r1
                r1 = r11
            L59:
                r12.L$0 = r7
                r12.L$1 = r6
                r12.L$2 = r2
                r12.I$0 = r1
                r12.label = r5
                java.lang.Object r13 = r6.b(r12)
                if (r13 != r0) goto L6a
                return r0
            L6a:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Laf
                java.lang.Object r13 = r6.next()
                jn.q<java.lang.Integer, java.lang.Object, um.d<? super java.lang.Boolean>, java.lang.Object> r8 = r12.$predicate
                int r9 = r1 + 1
                java.lang.Integer r10 = new java.lang.Integer
                r10.<init>(r1)
                r12.L$0 = r7
                r12.L$1 = r6
                r12.L$2 = r13
                r12.I$0 = r9
                r12.label = r4
                java.lang.Object r1 = r8.invoke(r10, r13, r12)
                if (r1 != r0) goto L90
                return r0
            L90:
                r8 = r7
                r7 = r13
                r13 = r1
                r1 = r9
            L94:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lad
                r12.L$0 = r8
                r12.L$1 = r6
                r12.L$2 = r2
                r12.I$0 = r1
                r12.label = r3
                java.lang.Object r13 = r8.L(r7, r12)
                if (r13 != r0) goto Lad
                return r0
            Lad:
                r7 = r8
                goto L59
            Laf:
                lm.l2 r12 = lm.l2.f10208a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((l) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class l0 extends n0 implements jn.p<Object, Object, t0<Object, Object>> {
        public static final l0 INSTANCE = new l0();

        public l0() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final t0<Object, Object> invoke(Object obj, Object obj2) {
            return new t0<>(obj, obj2);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends xm.o implements jn.p<Object, um.d<? super Boolean>, Object> {
        final /* synthetic */ jn.p<Object, um.d<? super Boolean>, Object> $predicate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public m(jn.p<Object, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super m> dVar) {
            super(2, dVar);
            this.$predicate = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            m mVar = new m(this.$predicate, dVar);
            mVar.L$0 = obj;
            return mVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                Object obj2 = this.L$0;
                jn.p<Object, um.d<? super Boolean>, Object> pVar = this.$predicate;
                this.label = 1;
                obj = pVar.invoke(obj2, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return Boolean.valueOf(!((Boolean) obj).booleanValue());
        }

        @Override // jn.p
        @os.m
        public final Object invoke(Object obj, @os.m um.d<? super Boolean> dVar) {
            return ((m) create(obj, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    @r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n468#1:480\n468#1:481,6\n468#1:487,2\n468#1:489\n468#1:490,3\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    public static final class m0<V> extends xm.o implements jn.p<pq.d0<? super V>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.f0<R> $other;
        final /* synthetic */ pq.f0<E> $this_zip;
        final /* synthetic */ jn.p<E, R, V> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public m0(pq.f0<? extends R> f0Var, pq.f0<? extends E> f0Var2, jn.p<? super E, ? super R, ? extends V> pVar, um.d<? super m0> dVar) {
            super(2, dVar);
            this.$other = f0Var;
            this.$this_zip = f0Var2;
            this.$transform = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            m0 m0Var = new m0(this.$other, this.$this_zip, this.$transform, dVar);
            m0Var.L$0 = obj;
            return m0Var;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a3 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #2 {all -> 0x0028, blocks: (B:8:0x0024, B:24:0x0086, B:27:0x009b, B:29:0x00a3, B:39:0x00ed, B:20:0x0069, B:23:0x007e), top: B:50:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00bb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:35:0x00cb A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:33:0x00c3, B:35:0x00cb, B:15:0x0049), top: B:46:0x0049 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x00e7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x00e8  */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.m0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super V> d0Var, @os.m um.d<? super l2> dVar) {
            return ((m0) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class n<E> extends xm.o implements jn.p<E, um.d<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public n(um.d<? super n> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            n nVar = new n(dVar);
            nVar.L$0 = obj;
            return nVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return Boolean.valueOf(this.L$0 != null);
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.m E e10, @os.m um.d<? super Boolean> dVar) {
            return ((n) create(e10, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "filterNotNullTo", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    public static final class o<E, C extends Collection<? super E>> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public o(um.d<? super o> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.u(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 242}, m = "filterNotNullTo", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv", RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class p<E, C extends pq.g0<? super E>> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public p(um.d<? super p> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.v(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    public static final class q<E> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public q(um.d<? super q> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.w(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {75}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    public static final class r<E> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public r(um.d<? super r> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.x(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    public static final class s extends xm.o implements jn.p<pq.d0<Object>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.f0<Object> $this_flatMap;
        final /* synthetic */ jn.p<Object, um.d<? super pq.f0<Object>>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public s(pq.f0<Object> f0Var, jn.p<Object, ? super um.d<? super pq.f0<Object>>, ? extends Object> pVar, um.d<? super s> dVar) {
            super(2, dVar);
            this.$this_flatMap = f0Var;
            this.$transform = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            s sVar = new s(this.$this_flatMap, this.$transform, dVar);
            sVar.L$0 = obj;
            return sVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0055 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x005e  */
        /* JADX WARN: Code duplicated, block: B:20:0x0070 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x007f A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007d -> B:13:0x0049). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x005e
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                r7 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3b
                if (r1 == r4) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r7.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r8)
                goto L49
            L1b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L23:
                java.lang.Object r1 = r7.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r7.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r8)
                goto L71
            L2f:
                java.lang.Object r1 = r7.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r5 = r7.L$0
                pq.d0 r5 = (pq.d0) r5
                lm.d1.n(r8)
                goto L56
            L3b:
                lm.d1.n(r8)
                java.lang.Object r8 = r7.L$0
                pq.d0 r8 = (pq.d0) r8
                pq.f0<java.lang.Object> r1 = r7.$this_flatMap
                pq.n r1 = r1.iterator()
                r5 = r8
            L49:
                r7.L$0 = r5
                r7.L$1 = r1
                r7.label = r4
                java.lang.Object r8 = r1.b(r7)
                if (r8 != r0) goto L56
                return r0
            L56:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L80
                java.lang.Object r8 = r1.next()
                jn.p<java.lang.Object, um.d<? super pq.f0<java.lang.Object>>, java.lang.Object> r6 = r7.$transform
                r7.L$0 = r5
                r7.L$1 = r1
                r7.label = r3
                java.lang.Object r8 = r6.invoke(r8, r7)
                if (r8 != r0) goto L71
                return r0
            L71:
                pq.f0 r8 = (pq.f0) r8
                r7.L$0 = r5
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = pq.u.W(r8, r5, r7)
                if (r8 != r0) goto L49
                return r0
            L80:
                lm.l2 r7 = lm.l2.f10208a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
            return ((s) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class t<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public t(um.d<? super t> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.A(null, null, this);
        }
    }

    /* JADX INFO: renamed from: pq.u$u, reason: collision with other inner class name */
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C0333u<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C0333u(um.d<? super C0333u> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.B(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class v<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public v(um.d<? super v> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.C(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class w<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public w(um.d<? super w> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.D(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n332#1:480\n332#1:481,6\n332#1:487,2\n332#1:489\n332#1:490,3\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    public static final class x<R> extends xm.o implements jn.p<pq.d0<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.f0<E> $this_map;
        final /* synthetic */ jn.p<E, um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public x(pq.f0<? extends E> f0Var, jn.p<? super E, ? super um.d<? super R>, ? extends Object> pVar, um.d<? super x> dVar) {
            super(2, dVar);
            this.$this_map = f0Var;
            this.$transform = pVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            x xVar = new x(this.$this_map, this.$transform, dVar);
            xVar.L$0 = obj;
            return xVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0083 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0084  */
        /* JADX WARN: Code duplicated, block: B:30:0x008f A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {all -> 0x0025, blocks: (B:8:0x0020, B:24:0x0073, B:28:0x0087, B:30:0x008f, B:38:0x00c3, B:20:0x005d, B:23:0x006c), top: B:45:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:36:0x00bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x00be  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00be -> B:24:0x0073). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.x.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super R> d0Var, @os.m um.d<? super l2> dVar) {
            return ((x) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class y<R> extends xm.o implements jn.p<pq.d0<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.f0<E> $this_mapIndexed;
        final /* synthetic */ jn.q<Integer, E, um.d<? super R>, Object> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public y(pq.f0<? extends E> f0Var, jn.q<? super Integer, ? super E, ? super um.d<? super R>, ? extends Object> qVar, um.d<? super y> dVar) {
            super(2, dVar);
            this.$this_mapIndexed = f0Var;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            y yVar = new y(this.$this_mapIndexed, this.$transform, dVar);
            yVar.L$0 = obj;
            return yVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a5 -> B:13:0x0057). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to pq.u$y<R> for r11v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                r11 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r11.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L46
                if (r1 == r4) goto L38
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$1
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r11.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r12)
                r12 = r6
                goto L57
            L1e:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L26:
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$2
                pq.d0 r5 = (pq.d0) r5
                java.lang.Object r6 = r11.L$1
                pq.n r6 = (pq.n) r6
                java.lang.Object r7 = r11.L$0
                pq.d0 r7 = (pq.d0) r7
                lm.d1.n(r12)
                goto L93
            L38:
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$1
                pq.n r5 = (pq.n) r5
                java.lang.Object r6 = r11.L$0
                pq.d0 r6 = (pq.d0) r6
                lm.d1.n(r12)
                goto L69
            L46:
                lm.d1.n(r12)
                java.lang.Object r12 = r11.L$0
                pq.d0 r12 = (pq.d0) r12
                pq.f0<E> r1 = r11.$this_mapIndexed
                pq.n r1 = r1.iterator()
                r5 = 0
                r10 = r5
                r5 = r1
                r1 = r10
            L57:
                r11.L$0 = r12
                r11.L$1 = r5
                r11.I$0 = r1
                r11.label = r4
                java.lang.Object r6 = r5.b(r11)
                if (r6 != r0) goto L66
                return r0
            L66:
                r10 = r6
                r6 = r12
                r12 = r10
            L69:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto La8
                java.lang.Object r12 = r5.next()
                jn.q<java.lang.Integer, E, um.d<? super R>, java.lang.Object> r7 = r11.$transform
                int r8 = r1 + 1
                java.lang.Integer r9 = new java.lang.Integer
                r9.<init>(r1)
                r11.L$0 = r6
                r11.L$1 = r5
                r11.L$2 = r6
                r11.I$0 = r8
                r11.label = r3
                java.lang.Object r12 = r7.invoke(r9, r12, r11)
                if (r12 != r0) goto L8f
                return r0
            L8f:
                r7 = r6
                r1 = r8
                r6 = r5
                r5 = r7
            L93:
                r11.L$0 = r7
                r11.L$1 = r6
                r8 = 0
                r11.L$2 = r8
                r11.I$0 = r1
                r11.label = r2
                java.lang.Object r12 = r5.L(r12, r11)
                if (r12 != r0) goto La5
                return r0
            La5:
                r5 = r6
                r12 = r7
                goto L57
            La8:
                lm.l2 r11 = lm.l2.f10208a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.u.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super R> d0Var, @os.m um.d<? super l2> dVar) {
            return ((y) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {TypedValues.CycleType.TYPE_EASING, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class z<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public z(um.d<? super z> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.M(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x0065, B:27:0x006e, B:29:0x0078, B:32:0x0083, B:21:0x0051, B:33:0x008a), top: B:42:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0078 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x0065, B:27:0x006e, B:29:0x0078, B:32:0x0083, B:21:0x0051, B:33:0x008a), top: B:42:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0083 A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x0065, B:27:0x006e, B:29:0x0078, B:32:0x0083, B:21:0x0051, B:33:0x008a), top: B:42:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008a A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x0065, B:27:0x006e, B:29:0x0078, B:32:0x0083, B:21:0x0051, B:33:0x008a), top: B:42:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0062 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object A(pq.f0 r7, java.lang.Object r8, um.d r9) {
        /*
            boolean r0 = r9 instanceof pq.u.t
            if (r0 == 0) goto L13
            r0 = r9
            pq.u$t r0 = (pq.u.t) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$t r0 = new pq.u$t
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$3
            pq.n r7 = (pq.n) r7
            java.lang.Object r8 = r0.L$2
            pq.f0 r8 = (pq.f0) r8
            java.lang.Object r2 = r0.L$1
            kn.k1$f r2 = (kn.k1.f) r2
            java.lang.Object r4 = r0.L$0
            lm.d1.n(r9)     // Catch: java.lang.Throwable -> L35
            goto L65
        L35:
            r7 = move-exception
            goto L9a
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            lm.d1.n(r9)
            kn.k1$f r9 = new kn.k1$f
            r9.<init>()
            pq.n r2 = r7.iterator()     // Catch: java.lang.Throwable -> L96
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r6
        L51:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L35
            r0.L$3 = r7     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = r7.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r4 != r1) goto L62
            return r1
        L62:
            r6 = r4
            r4 = r9
            r9 = r6
        L65:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L35
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L35
            r5 = 0
            if (r9 == 0) goto L8a
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L35
            boolean r9 = kn.l0.g(r4, r9)     // Catch: java.lang.Throwable -> L35
            if (r9 == 0) goto L83
            int r7 = r2.element     // Catch: java.lang.Throwable -> L35
            java.lang.Integer r9 = new java.lang.Integer     // Catch: java.lang.Throwable -> L35
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L35
            pq.t.a(r8, r5)
            return r9
        L83:
            int r9 = r2.element     // Catch: java.lang.Throwable -> L35
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> L35
            r9 = r4
            goto L51
        L8a:
            lm.l2 r7 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L35
            pq.t.a(r8, r5)
            java.lang.Integer r7 = new java.lang.Integer
            r8 = -1
            r7.<init>(r8)
            return r7
        L96:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r9 = move-exception
            pq.t.a(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.A(pq.f0, java.lang.Object, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:13:0x0030, B:37:0x0089, B:39:0x0091), top: B:51:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0085 -> B:37:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object B(pq.f0 r6, um.d r7) {
        /*
            boolean r0 = r7 instanceof pq.u.C0333u
            if (r0 == 0) goto L13
            r0 = r7
            pq.u$u r0 = (pq.u.C0333u) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$u r0 = new pq.u$u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            java.lang.Object r2 = r0.L$1
            pq.n r2 = (pq.n) r2
            java.lang.Object r4 = r0.L$0
            pq.f0 r4 = (pq.f0) r4
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L34
            goto L89
        L34:
            r6 = move-exception
            r2 = r4
            goto La8
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            java.lang.Object r6 = r0.L$1
            pq.n r6 = (pq.n) r6
            java.lang.Object r2 = r0.L$0
            pq.f0 r2 = (pq.f0) r2
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L4c
            goto L67
        L4c:
            r6 = move-exception
            goto La8
        L4f:
            lm.d1.n(r7)
            pq.n r7 = r6.iterator()     // Catch: java.lang.Throwable -> L9c
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L9c
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L9c
            r0.label = r4     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r2 = r7.b(r0)     // Catch: java.lang.Throwable -> L9c
            if (r2 != r1) goto L63
            return r1
        L63:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L67:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L4c
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L4c
            if (r7 == 0) goto La0
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4c
            r5 = r2
            r2 = r6
            r6 = r5
        L76:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L9c
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L9c
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L9c
            r0.label = r3     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r4 = r2.b(r0)     // Catch: java.lang.Throwable -> L9c
            if (r4 != r1) goto L85
            return r1
        L85:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L89:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L34
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L97
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L34
            r6 = r4
            goto L76
        L97:
            r7 = 0
            pq.t.a(r4, r7)
            return r6
        L9c:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto La8
        La0:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L4c
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L4c
            throw r6     // Catch: java.lang.Throwable -> L4c
        La8:
            throw r6     // Catch: java.lang.Throwable -> La9
        La9:
            r7 = move-exception
            pq.t.a(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.B(pq.f0, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0073, B:27:0x007b, B:29:0x0085, B:30:0x0089, B:21:0x005d, B:31:0x0090), top: B:42:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0085 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0073, B:27:0x007b, B:29:0x0085, B:30:0x0089, B:21:0x005d, B:31:0x0090), top: B:42:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0090 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0073, B:27:0x007b, B:29:0x0085, B:30:0x0089, B:21:0x005d, B:31:0x0090), top: B:42:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0070 -> B:25:0x0073). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object C(pq.f0 r7, java.lang.Object r8, um.d r9) {
        /*
            boolean r0 = r9 instanceof pq.u.v
            if (r0 == 0) goto L13
            r0 = r9
            pq.u$v r0 = (pq.u.v) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$v r0 = new pq.u$v
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.L$4
            pq.n r7 = (pq.n) r7
            java.lang.Object r8 = r0.L$3
            pq.f0 r8 = (pq.f0) r8
            java.lang.Object r2 = r0.L$2
            kn.k1$f r2 = (kn.k1.f) r2
            java.lang.Object r4 = r0.L$1
            kn.k1$f r4 = (kn.k1.f) r4
            java.lang.Object r5 = r0.L$0
            lm.d1.n(r9)     // Catch: java.lang.Throwable -> L39
            goto L73
        L39:
            r7 = move-exception
            goto La2
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            lm.d1.n(r9)
            kn.k1$f r9 = new kn.k1$f
            r9.<init>()
            r2 = -1
            r9.element = r2
            kn.k1$f r2 = new kn.k1$f
            r2.<init>()
            pq.n r4 = r7.iterator()     // Catch: java.lang.Throwable -> L9e
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r6
        L5d:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L39
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L39
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L39
            r0.L$4 = r7     // Catch: java.lang.Throwable -> L39
            r0.label = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r7.b(r0)     // Catch: java.lang.Throwable -> L39
            if (r5 != r1) goto L70
            return r1
        L70:
            r6 = r5
            r5 = r9
            r9 = r6
        L73:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L39
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r9 == 0) goto L90
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L39
            boolean r9 = kn.l0.g(r5, r9)     // Catch: java.lang.Throwable -> L39
            if (r9 == 0) goto L89
            int r9 = r2.element     // Catch: java.lang.Throwable -> L39
            r4.element = r9     // Catch: java.lang.Throwable -> L39
        L89:
            int r9 = r2.element     // Catch: java.lang.Throwable -> L39
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> L39
            r9 = r5
            goto L5d
        L90:
            lm.l2 r7 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L39
            r7 = 0
            pq.t.a(r8, r7)
            int r7 = r4.element
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            return r8
        L9e:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La2:
            throw r7     // Catch: java.lang.Throwable -> La3
        La3:
            r9 = move-exception
            pq.t.a(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.C(pq.f0, java.lang.Object, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x0095 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0031, B:39:0x008d, B:41:0x0095), top: B:53:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0089 -> B:39:0x008d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object D(pq.f0 r7, um.d r8) {
        /*
            boolean r0 = r8 instanceof pq.u.w
            if (r0 == 0) goto L13
            r0 = r8
            pq.u$w r0 = (pq.u.w) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$w r0 = new pq.u$w
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r7 = r0.L$2
            java.lang.Object r2 = r0.L$1
            pq.n r2 = (pq.n) r2
            java.lang.Object r4 = r0.L$0
            pq.f0 r4 = (pq.f0) r4
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L35
            goto L8d
        L35:
            r7 = move-exception
            r2 = r4
            goto La2
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            java.lang.Object r7 = r0.L$1
            pq.n r7 = (pq.n) r7
            java.lang.Object r2 = r0.L$0
            pq.f0 r2 = (pq.f0) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L4d
            goto L67
        L4d:
            r7 = move-exception
            goto La2
        L4f:
            lm.d1.n(r8)
            pq.n r8 = r7.iterator()     // Catch: java.lang.Throwable -> L9f
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L9f
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L9f
            r0.label = r4     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r2 = r8.b(r0)     // Catch: java.lang.Throwable -> L9f
            if (r2 != r1) goto L63
            return r1
        L63:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L4d
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L4d
            if (r8 != 0) goto L73
            pq.t.a(r2, r5)
            return r5
        L73:
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L4d
            r6 = r2
            r2 = r7
            r7 = r6
        L7a:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L9f
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L9f
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L9f
            r0.label = r3     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r4 = r2.b(r0)     // Catch: java.lang.Throwable -> L9f
            if (r4 != r1) goto L89
            return r1
        L89:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L8d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L9b
            java.lang.Object r8 = r2.next()     // Catch: java.lang.Throwable -> L35
            r7 = r4
            goto L7a
        L9b:
            pq.t.a(r4, r5)
            return r7
        L9f:
            r8 = move-exception
            r2 = r7
            r7 = r8
        La2:
            throw r7     // Catch: java.lang.Throwable -> La3
        La3:
            r8 = move-exception
            pq.t.a(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.D(pq.f0, um.d):java.lang.Object");
    }

    @z0
    @os.l
    public static final <E, R> pq.f0<R> E(@os.l pq.f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super R>, ? extends Object> pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new x(f0Var, pVar, null), 6, null);
    }

    public static pq.f0 F(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return E(f0Var, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E, R> pq.f0<R> G(@os.l pq.f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.q<? super Integer, ? super E, ? super um.d<? super R>, ? extends Object> qVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new y(f0Var, qVar, null), 6, null);
    }

    public static pq.f0 H(pq.f0 f0Var, um.g gVar, jn.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return G(f0Var, gVar, qVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 I(pq.f0 f0Var, um.g gVar, jn.q qVar) {
        return t(G(f0Var, gVar, qVar));
    }

    public static /* synthetic */ pq.f0 J(pq.f0 f0Var, um.g gVar, jn.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return I(f0Var, gVar, qVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 K(pq.f0 f0Var, um.g gVar, jn.p pVar) {
        return t(E(f0Var, gVar, pVar));
    }

    public static /* synthetic */ pq.f0 L(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return K(f0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #1 {all -> 0x00b7, blocks: (B:40:0x00a1, B:42:0x00a9, B:36:0x008c, B:26:0x0060), top: B:56:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:15:0x003b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object M(pq.f0 r8, java.util.Comparator r9, um.d r10) {
        /*
            boolean r0 = r10 instanceof pq.u.z
            if (r0 == 0) goto L13
            r0 = r10
            pq.u$z r0 = (pq.u.z) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$z r0 = new pq.u$z
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L5d
            if (r2 == r4) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r8 = r0.L$3
            java.lang.Object r9 = r0.L$2
            pq.n r9 = (pq.n) r9
            java.lang.Object r2 = r0.L$1
            pq.f0 r2 = (pq.f0) r2
            java.lang.Object r4 = r0.L$0
            java.util.Comparator r4 = (java.util.Comparator) r4
            lm.d1.n(r10)     // Catch: java.lang.Throwable -> L3e
            r7 = r0
            r0 = r8
            r8 = r2
        L3b:
            r2 = r7
            goto La1
        L3e:
            r8 = move-exception
            r9 = r2
            goto Lc0
        L42:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4a:
            java.lang.Object r8 = r0.L$2
            pq.n r8 = (pq.n) r8
            java.lang.Object r9 = r0.L$1
            pq.f0 r9 = (pq.f0) r9
            java.lang.Object r2 = r0.L$0
            java.util.Comparator r2 = (java.util.Comparator) r2
            lm.d1.n(r10)     // Catch: java.lang.Throwable -> L5a
            goto L78
        L5a:
            r8 = move-exception
            goto Lc0
        L5d:
            lm.d1.n(r10)
            pq.n r10 = r8.iterator()     // Catch: java.lang.Throwable -> Lb7
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lb7
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lb7
            r0.L$2 = r10     // Catch: java.lang.Throwable -> Lb7
            r0.label = r4     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r2 = r10.b(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r2 != r1) goto L73
            return r1
        L73:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L78:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L5a
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L5a
            if (r10 != 0) goto L84
            pq.t.a(r9, r5)
            return r5
        L84:
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L5a
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L8c:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> Lb7
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lb7
            r0.L$2 = r9     // Catch: java.lang.Throwable -> Lb7
            r0.L$3 = r10     // Catch: java.lang.Throwable -> Lb7
            r0.label = r3     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r2 = r9.b(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r2 != r1) goto L9d
            return r1
        L9d:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L3b
        La1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> Lb7
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> Lb7
            if (r10 == 0) goto Lbc
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> Lb7
            int r6 = r4.compare(r0, r10)     // Catch: java.lang.Throwable -> Lb7
            if (r6 >= 0) goto Lb5
        Lb3:
            r0 = r2
            goto L8c
        Lb5:
            r10 = r0
            goto Lb3
        Lb7:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lc0
        Lbc:
            pq.t.a(r8, r5)
            return r0
        Lc0:
            throw r8     // Catch: java.lang.Throwable -> Lc1
        Lc1:
            r10 = move-exception
            pq.t.a(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.M(pq.f0, java.util.Comparator, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x009d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #1 {all -> 0x00b7, blocks: (B:40:0x00a1, B:42:0x00a9, B:36:0x008c, B:26:0x0060), top: B:56:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:15:0x003b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object N(pq.f0 r8, java.util.Comparator r9, um.d r10) {
        /*
            boolean r0 = r10 instanceof pq.u.a0
            if (r0 == 0) goto L13
            r0 = r10
            pq.u$a0 r0 = (pq.u.a0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$a0 r0 = new pq.u$a0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L5d
            if (r2 == r4) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r8 = r0.L$3
            java.lang.Object r9 = r0.L$2
            pq.n r9 = (pq.n) r9
            java.lang.Object r2 = r0.L$1
            pq.f0 r2 = (pq.f0) r2
            java.lang.Object r4 = r0.L$0
            java.util.Comparator r4 = (java.util.Comparator) r4
            lm.d1.n(r10)     // Catch: java.lang.Throwable -> L3e
            r7 = r0
            r0 = r8
            r8 = r2
        L3b:
            r2 = r7
            goto La1
        L3e:
            r8 = move-exception
            r9 = r2
            goto Lc0
        L42:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4a:
            java.lang.Object r8 = r0.L$2
            pq.n r8 = (pq.n) r8
            java.lang.Object r9 = r0.L$1
            pq.f0 r9 = (pq.f0) r9
            java.lang.Object r2 = r0.L$0
            java.util.Comparator r2 = (java.util.Comparator) r2
            lm.d1.n(r10)     // Catch: java.lang.Throwable -> L5a
            goto L78
        L5a:
            r8 = move-exception
            goto Lc0
        L5d:
            lm.d1.n(r10)
            pq.n r10 = r8.iterator()     // Catch: java.lang.Throwable -> Lb7
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lb7
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lb7
            r0.L$2 = r10     // Catch: java.lang.Throwable -> Lb7
            r0.label = r4     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r2 = r10.b(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r2 != r1) goto L73
            return r1
        L73:
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r2
            r2 = r7
        L78:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L5a
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L5a
            if (r10 != 0) goto L84
            pq.t.a(r9, r5)
            return r5
        L84:
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L5a
            r4 = r2
            r7 = r9
            r9 = r8
            r8 = r7
        L8c:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> Lb7
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lb7
            r0.L$2 = r9     // Catch: java.lang.Throwable -> Lb7
            r0.L$3 = r10     // Catch: java.lang.Throwable -> Lb7
            r0.label = r3     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r2 = r9.b(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r2 != r1) goto L9d
            return r1
        L9d:
            r7 = r0
            r0 = r10
            r10 = r2
            goto L3b
        La1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> Lb7
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> Lb7
            if (r10 == 0) goto Lbc
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> Lb7
            int r6 = r4.compare(r0, r10)     // Catch: java.lang.Throwable -> Lb7
            if (r6 <= 0) goto Lb5
        Lb3:
            r0 = r2
            goto L8c
        Lb5:
            r10 = r0
            goto Lb3
        Lb7:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lc0
        Lbc:
            pq.t.a(r8, r5)
            return r0
        Lc0:
            throw r8     // Catch: java.lang.Throwable -> Lc1
        Lc1:
            r10 = move-exception
            pq.t.a(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.N(pq.f0, java.util.Comparator, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object O(pq.f0 f0Var, um.d dVar) {
        b0 b0Var;
        if (dVar instanceof b0) {
            b0Var = (b0) dVar;
            int i10 = b0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                b0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(dVar);
            }
        } else {
            b0Var = new b0(dVar);
        }
        Object objB = b0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = b0Var.label;
        try {
            if (i11 == 0) {
                d1.n(objB);
                pq.n it = f0Var.iterator();
                b0Var.L$0 = f0Var;
                b0Var.label = 1;
                objB = it.b(b0Var);
                if (objB == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f0Var = (pq.f0) b0Var.L$0;
                d1.n(objB);
            }
            Boolean boolValueOf = Boolean.valueOf(!((Boolean) objB).booleanValue());
            pq.t.a(f0Var, null);
            return boolValueOf;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                pq.t.a(f0Var, th2);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006a A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:20:0x0044, B:29:0x0062, B:31:0x006a, B:41:0x0094, B:42:0x009b), top: B:53:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0094 A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #2 {all -> 0x0048, blocks: (B:20:0x0044, B:29:0x0062, B:31:0x006a, B:41:0x0094, B:42:0x009b), top: B:53:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object Q(pq.f0 f0Var, um.d dVar) {
        d0 d0Var;
        pq.f0 f0Var2;
        Throwable th2;
        pq.n nVar;
        Object next;
        Object objB;
        pq.f0 f0Var3;
        Object obj;
        if (dVar instanceof d0) {
            d0Var = (d0) dVar;
            int i10 = d0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                d0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(dVar);
            }
        } else {
            d0Var = new d0(dVar);
        }
        Object obj2 = d0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = d0Var.label;
        if (i11 == 0) {
            d1.n(obj2);
            try {
                pq.n it = f0Var.iterator();
                d0Var.L$0 = f0Var;
                d0Var.L$1 = it;
                d0Var.label = 1;
                Object objB2 = it.b(d0Var);
                if (objB2 == aVar) {
                    return aVar;
                }
                f0Var2 = f0Var;
                nVar = it;
                obj2 = objB2;
                if (((Boolean) obj2).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = nVar.next();
                d0Var.L$0 = f0Var2;
                d0Var.L$1 = next;
                d0Var.label = 2;
                objB = nVar.b(d0Var);
                if (objB == aVar) {
                    return aVar;
                }
                f0Var3 = f0Var2;
                obj2 = objB;
                obj = next;
            } catch (Throwable th3) {
                f0Var2 = f0Var;
                th2 = th3;
                throw th2;
            }
        } else if (i11 == 1) {
            nVar = (pq.n) d0Var.L$1;
            f0Var2 = (pq.f0) d0Var.L$0;
            try {
                d1.n(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = nVar.next();
                d0Var.L$0 = f0Var2;
                d0Var.L$1 = next;
                d0Var.label = 2;
                objB = nVar.b(d0Var);
                if (objB == aVar) {
                    return aVar;
                }
                f0Var3 = f0Var2;
                obj2 = objB;
                obj = next;
            } catch (Throwable th4) {
                th2 = th4;
                throw th2;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = d0Var.L$1;
            f0Var3 = (pq.f0) d0Var.L$0;
            try {
                d1.n(obj2);
            } catch (Throwable th5) {
                th2 = th5;
                f0Var2 = f0Var3;
                try {
                    throw th2;
                } catch (Throwable th6) {
                    pq.t.a(f0Var2, th2);
                    throw th6;
                }
            }
        }
        if (((Boolean) obj2).booleanValue()) {
            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
        }
        pq.t.a(f0Var3, null);
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object R(pq.f0 f0Var, um.d dVar) {
        e0 e0Var;
        pq.f0 f0Var2;
        Throwable th2;
        pq.n nVar;
        pq.f0 f0Var3;
        Object obj;
        if (dVar instanceof e0) {
            e0Var = (e0) dVar;
            int i10 = e0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                e0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                e0Var = new e0(dVar);
            }
        } else {
            e0Var = new e0(dVar);
        }
        Object obj2 = e0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = e0Var.label;
        if (i11 == 0) {
            d1.n(obj2);
            try {
                pq.n it = f0Var.iterator();
                e0Var.L$0 = f0Var;
                e0Var.L$1 = it;
                e0Var.label = 1;
                Object objB = it.b(e0Var);
                if (objB == aVar) {
                    return aVar;
                }
                f0Var2 = f0Var;
                nVar = it;
                obj2 = objB;
            } catch (Throwable th3) {
                f0Var2 = f0Var;
                th2 = th3;
                throw th2;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = e0Var.L$1;
                f0Var3 = (pq.f0) e0Var.L$0;
                try {
                    d1.n(obj2);
                    if (((Boolean) obj2).booleanValue()) {
                        pq.t.a(f0Var3, null);
                        return null;
                    }
                    pq.t.a(f0Var3, null);
                    return obj;
                } catch (Throwable th4) {
                    th2 = th4;
                    f0Var2 = f0Var3;
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        pq.t.a(f0Var2, th2);
                        throw th5;
                    }
                }
            }
            nVar = (pq.n) e0Var.L$1;
            f0Var2 = (pq.f0) e0Var.L$0;
            try {
                d1.n(obj2);
            } catch (Throwable th6) {
                th2 = th6;
                throw th2;
            }
        }
        if (!((Boolean) obj2).booleanValue()) {
            pq.t.a(f0Var2, null);
            return null;
        }
        Object next = nVar.next();
        e0Var.L$0 = f0Var2;
        e0Var.L$1 = next;
        e0Var.label = 2;
        Object objB2 = nVar.b(e0Var);
        if (objB2 == aVar) {
            return aVar;
        }
        f0Var3 = f0Var2;
        obj2 = objB2;
        obj = next;
        if (((Boolean) obj2).booleanValue()) {
            pq.t.a(f0Var3, null);
            return null;
        }
        pq.t.a(f0Var3, null);
        return obj;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 S(pq.f0 f0Var, int i10, um.g gVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new f0(i10, f0Var, null), 6, null);
    }

    public static /* synthetic */ pq.f0 T(pq.f0 f0Var, int i10, um.g gVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            gVar = k1.g();
        }
        return S(f0Var, i10, gVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 U(pq.f0 f0Var, um.g gVar, jn.p pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new g0(f0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ pq.f0 V(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return U(f0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0068 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076 A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:13:0x0032, B:28:0x006e, B:30:0x0076, B:33:0x0089, B:20:0x004f), top: B:46:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, pq.g0] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends pq.g0<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [pq.f0] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, pq.f0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0086 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @lm.z0
    public static final <E, C extends pq.g0<? super E>> java.lang.Object W(@os.l pq.f0<? extends E> r6, @os.l C r7, @os.l um.d<? super C> r8) {
        /*
            boolean r0 = r8 instanceof pq.u.h0
            if (r0 == 0) goto L13
            r0 = r8
            pq.u$h0 r0 = (pq.u.h0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$h0 r0 = new pq.u$h0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            pq.g0 r2 = (pq.g0) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L39
        L35:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L5a
        L39:
            r6 = move-exception
            goto L94
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            pq.g0 r2 = (pq.g0) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L39
            goto L6e
        L53:
            lm.d1.n(r8)
            pq.n r8 = r6.iterator()     // Catch: java.lang.Throwable -> L90
        L5a:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L90
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L90
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L90
            r0.label = r4     // Catch: java.lang.Throwable -> L90
            java.lang.Object r2 = r8.b(r0)     // Catch: java.lang.Throwable -> L90
            if (r2 != r1) goto L69
            return r1
        L69:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L6e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L39
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r8 == 0) goto L89
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L39
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L39
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L39
            r0.label = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r8 = r2.L(r8, r0)     // Catch: java.lang.Throwable -> L39
            if (r8 != r1) goto L35
            return r1
        L89:
            lm.l2 r6 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L39
            r6 = 0
            pq.t.a(r7, r6)
            return r2
        L90:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L94:
            throw r6     // Catch: java.lang.Throwable -> L95
        L95:
            r8 = move-exception
            pq.t.a(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.W(pq.f0, pq.g0, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:21:0x0048, B:28:0x006b), top: B:39:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0057 -> B:25:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @lm.z0
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object X(@os.l pq.f0<? extends E> r5, @os.l C r6, @os.l um.d<? super C> r7) {
        /*
            boolean r0 = r7 instanceof pq.u.i0
            if (r0 == 0) goto L13
            r0 = r7
            pq.u$i0 r0 = (pq.u.i0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$i0 r0 = new pq.u$i0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            pq.n r5 = (pq.n) r5
            java.lang.Object r6 = r0.L$1
            pq.f0 r6 = (pq.f0) r6
            java.lang.Object r2 = r0.L$0
            java.util.Collection r2 = (java.util.Collection) r2
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L33
            goto L5a
        L33:
            r5 = move-exception
            goto L76
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            lm.d1.n(r7)
            pq.n r7 = r5.iterator()     // Catch: java.lang.Throwable -> L72
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L48:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L33
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L33
            r0.label = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r2 = r5.b(r0)     // Catch: java.lang.Throwable -> L33
            if (r2 != r1) goto L57
            return r1
        L57:
            r4 = r2
            r2 = r7
            r7 = r4
        L5a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L33
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L6b
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L33
            r2.add(r7)     // Catch: java.lang.Throwable -> L33
            r7 = r2
            goto L48
        L6b:
            lm.l2 r5 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L33
            r5 = 0
            pq.t.a(r6, r5)
            return r2
        L72:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L76:
            throw r5     // Catch: java.lang.Throwable -> L77
        L77:
            r7 = move-exception
            pq.t.a(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.X(pq.f0, java.util.Collection, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:21:0x0048, B:28:0x0075), top: B:39:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0057 -> B:25:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @lm.z0
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object Y(@os.l pq.f0<? extends lm.t0<? extends K, ? extends V>> r6, @os.l M r7, @os.l um.d<? super M> r8) {
        /*
            boolean r0 = r8 instanceof pq.u.j0
            if (r0 == 0) goto L13
            r0 = r8
            pq.u$j0 r0 = (pq.u.j0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$j0 r0 = new pq.u$j0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            java.util.Map r2 = (java.util.Map) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L33
            goto L5a
        L33:
            r6 = move-exception
            goto L80
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            lm.d1.n(r8)
            pq.n r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7c
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L48:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L33
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L33
            r0.label = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r2 = r6.b(r0)     // Catch: java.lang.Throwable -> L33
            if (r2 != r1) goto L57
            return r1
        L57:
            r5 = r2
            r2 = r8
            r8 = r5
        L5a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L33
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r8 == 0) goto L75
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L33
            lm.t0 r8 = (lm.t0) r8     // Catch: java.lang.Throwable -> L33
            java.lang.Object r4 = r8.getFirst()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r8 = r8.getSecond()     // Catch: java.lang.Throwable -> L33
            r2.put(r4, r8)     // Catch: java.lang.Throwable -> L33
            r8 = r2
            goto L48
        L75:
            lm.l2 r6 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L33
            r6 = 0
            pq.t.a(r7, r6)
            return r2
        L7c:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L80:
            throw r6     // Catch: java.lang.Throwable -> L81
        L81:
            r8 = move-exception
            pq.t.a(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.Y(pq.f0, java.util.Map, um.d):java.lang.Object");
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object Z(pq.f0 f0Var, um.d dVar) {
        return Y(f0Var, new LinkedHashMap(), dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object a(pq.f0 f0Var, um.d dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objB = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(objB);
                pq.n it = f0Var.iterator();
                aVar.L$0 = f0Var;
                aVar.label = 1;
                objB = it.b(aVar);
                if (objB == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f0Var = (pq.f0) aVar.L$0;
                d1.n(objB);
            }
            pq.t.a(f0Var, null);
            return objB;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                pq.t.a(f0Var, th2);
                throw th3;
            }
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object a0(pq.f0 f0Var, um.d dVar) {
        return X(f0Var, new ArrayList(), dVar);
    }

    @z0
    @os.l
    public static final jn.l<Throwable, l2> b(@os.l pq.f0<?> f0Var) {
        return new b(f0Var);
    }

    @os.m
    @z0
    public static final <E> Object b0(@os.l pq.f0<? extends E> f0Var, @os.l um.d<? super Set<E>> dVar) {
        return X(f0Var, new LinkedHashSet(), dVar);
    }

    @z0
    @os.l
    public static final jn.l<Throwable, l2> c(@os.l pq.f0<?>... f0VarArr) {
        return new c(f0VarArr);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object c0(pq.f0 f0Var, um.d dVar) {
        return b0(f0Var, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066 A[Catch: all -> 0x0033, TryCatch #1 {, blocks: (B:12:0x002f, B:25:0x005e, B:27:0x0066, B:28:0x0070), top: B:41:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:25:0x005e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object d(pq.f0 r6, um.d r7) {
        /*
            boolean r0 = r7 instanceof pq.u.d
            if (r0 == 0) goto L13
            r0 = r7
            pq.u$d r0 = (pq.u.d) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$d r0 = new pq.u$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r2 = r0.L$1
            pq.f0 r2 = (pq.f0) r2
            java.lang.Object r4 = r0.L$0
            kn.k1$f r4 = (kn.k1.f) r4
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L33
            goto L5e
        L33:
            r6 = move-exception
            goto L84
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            lm.d1.n(r7)
            kn.k1$f r7 = new kn.k1$f
            r7.<init>()
            pq.n r2 = r6.iterator()     // Catch: java.lang.Throwable -> L81
            r4 = r7
            r7 = r6
            r6 = r2
        L4c:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L7e
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L7e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L7e
            r0.label = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = r6.b(r0)     // Catch: java.lang.Throwable -> L7e
            if (r2 != r1) goto L5b
            return r1
        L5b:
            r5 = r2
            r2 = r7
            r7 = r5
        L5e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L33
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L70
            r6.next()     // Catch: java.lang.Throwable -> L33
            int r7 = r4.element     // Catch: java.lang.Throwable -> L33
            int r7 = r7 + r3
            r4.element = r7     // Catch: java.lang.Throwable -> L33
            r7 = r2
            goto L4c
        L70:
            lm.l2 r6 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L33
            r6 = 0
            pq.t.a(r2, r6)
            int r6 = r4.element
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            return r7
        L7e:
            r6 = move-exception
            r2 = r7
            goto L84
        L81:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L84:
            throw r6     // Catch: java.lang.Throwable -> L85
        L85:
            r7 = move-exception
            pq.t.a(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.d(pq.f0, um.d):java.lang.Object");
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 d0(pq.f0 f0Var, um.g gVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new k0(f0Var, null), 6, null);
    }

    public static /* synthetic */ pq.f0 e0(pq.f0 f0Var, um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return d0(f0Var, gVar);
    }

    @z0
    @os.l
    public static final <E, K> pq.f0<E> f(@os.l pq.f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super K>, ? extends Object> pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new f(f0Var, pVar, null), 6, null);
    }

    public static pq.f0 g(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return f(f0Var, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E, R, V> pq.f0<V> g0(@os.l pq.f0<? extends E> f0Var, @os.l pq.f0<? extends R> f0Var2, @os.l um.g gVar, @os.l jn.p<? super E, ? super R, ? extends V> pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new c(new pq.f0[]{f0Var, f0Var2}), new m0(f0Var2, f0Var, pVar, null), 6, null);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 h(pq.f0 f0Var, int i10, um.g gVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new g(i10, f0Var, null), 6, null);
    }

    public static pq.f0 h0(pq.f0 f0Var, pq.f0 f0Var2, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = k1.g();
        }
        return g0(f0Var, f0Var2, gVar, pVar);
    }

    public static /* synthetic */ pq.f0 i(pq.f0 f0Var, int i10, um.g gVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            gVar = k1.g();
        }
        return h(f0Var, i10, gVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 j(pq.f0 f0Var, um.g gVar, jn.p pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new h(f0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ pq.f0 k(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return j(f0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0062, B:27:0x006a, B:33:0x007b, B:34:0x0092), top: B:44:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x0077  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0062). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object l(pq.f0 r9, int r10, um.d r11) {
        /*
            boolean r0 = r11 instanceof pq.u.i
            if (r0 == 0) goto L13
            r0 = r11
            pq.u$i r0 = (pq.u.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$i r0 = new pq.u$i
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 46
            r4 = 1
            java.lang.String r5 = "ReceiveChannel doesn't contain element at index "
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pq.n r2 = (pq.n) r2
            java.lang.Object r6 = r0.L$0
            pq.f0 r6 = (pq.f0) r6
            lm.d1.n(r11)     // Catch: java.lang.Throwable -> L37
            goto L62
        L37:
            r9 = move-exception
            goto Lac
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            lm.d1.n(r11)
            if (r10 < 0) goto L97
            pq.n r11 = r9.iterator()     // Catch: java.lang.Throwable -> L93
            r2 = 0
        L4c:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L93
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L93
            r0.I$0 = r10     // Catch: java.lang.Throwable -> L93
            r0.I$1 = r2     // Catch: java.lang.Throwable -> L93
            r0.label = r4     // Catch: java.lang.Throwable -> L93
            java.lang.Object r6 = r11.b(r0)     // Catch: java.lang.Throwable -> L93
            if (r6 != r1) goto L5d
            return r1
        L5d:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L62:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L37
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r11 == 0) goto L7b
            java.lang.Object r11 = r2.next()     // Catch: java.lang.Throwable -> L37
            int r7 = r9 + 1
            if (r10 != r9) goto L77
            r9 = 0
            pq.t.a(r6, r9)
            return r11
        L77:
            r11 = r2
            r9 = r6
            r2 = r7
            goto L4c
        L7b:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L37
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r11.<init>()     // Catch: java.lang.Throwable -> L37
            r11.append(r5)     // Catch: java.lang.Throwable -> L37
            r11.append(r10)     // Catch: java.lang.Throwable -> L37
            r11.append(r3)     // Catch: java.lang.Throwable -> L37
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L37
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L37
            throw r9     // Catch: java.lang.Throwable -> L37
        L93:
            r10 = move-exception
            r6 = r9
            r9 = r10
            goto Lac
        L97:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L93
            r0.append(r10)     // Catch: java.lang.Throwable -> L93
            r0.append(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L93
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L93
            throw r11     // Catch: java.lang.Throwable -> L93
        Lac:
            throw r9     // Catch: java.lang.Throwable -> Lad
        Lad:
            r10 = move-exception
            pq.t.a(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.l(pq.f0, int, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x006e A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #2 {all -> 0x007e, blocks: (B:27:0x0066, B:29:0x006e, B:23:0x0051, B:22:0x004c), top: B:47:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0062 -> B:27:0x0066). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object m(pq.f0 r8, int r9, um.d r10) {
        /*
            boolean r0 = r10 instanceof pq.u.j
            if (r0 == 0) goto L13
            r0 = r10
            pq.u$j r0 = (pq.u.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$j r0 = new pq.u$j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pq.n r2 = (pq.n) r2
            java.lang.Object r5 = r0.L$0
            pq.f0 r5 = (pq.f0) r5
            lm.d1.n(r10)     // Catch: java.lang.Throwable -> L39
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r0
            r0 = r7
            goto L66
        L39:
            r8 = move-exception
            goto L86
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            lm.d1.n(r10)
            if (r9 >= 0) goto L4c
            pq.t.a(r8, r4)
            return r4
        L4c:
            pq.n r10 = r8.iterator()     // Catch: java.lang.Throwable -> L7e
            r2 = 0
        L51:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7e
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L7e
            r0.I$0 = r9     // Catch: java.lang.Throwable -> L7e
            r0.I$1 = r2     // Catch: java.lang.Throwable -> L7e
            r0.label = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r5 = r10.b(r0)     // Catch: java.lang.Throwable -> L7e
            if (r5 != r1) goto L62
            return r1
        L62:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r7
        L66:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L7e
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L7e
            if (r10 == 0) goto L82
            java.lang.Object r10 = r0.next()     // Catch: java.lang.Throwable -> L7e
            int r6 = r2 + 1
            if (r9 != r2) goto L7a
            pq.t.a(r8, r4)
            return r10
        L7a:
            r10 = r0
            r0 = r5
            r2 = r6
            goto L51
        L7e:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L86
        L82:
            pq.t.a(r8, r4)
            return r4
        L86:
            throw r8     // Catch: java.lang.Throwable -> L87
        L87:
            r9 = move-exception
            pq.t.a(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.m(pq.f0, int, um.d):java.lang.Object");
    }

    @z0
    @os.l
    public static final <E> pq.f0<E> n(@os.l pq.f0<? extends E> f0Var, @os.l um.g gVar, @os.l jn.p<? super E, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new k(f0Var, pVar, null), 6, null);
    }

    public static pq.f0 o(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return n(f0Var, gVar, pVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 p(pq.f0 f0Var, um.g gVar, jn.q qVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new l(f0Var, qVar, null), 6, null);
    }

    public static /* synthetic */ pq.f0 q(pq.f0 f0Var, um.g gVar, jn.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return p(f0Var, gVar, qVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 r(pq.f0 f0Var, um.g gVar, jn.p pVar) {
        return n(f0Var, gVar, new m(pVar, null));
    }

    public static /* synthetic */ pq.f0 s(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return r(f0Var, gVar, pVar);
    }

    @z0
    @os.l
    public static final <E> pq.f0<E> t(@os.l pq.f0<? extends E> f0Var) {
        pq.f0<E> f0VarO = o(f0Var, null, new n(null), 1, null);
        kn.l0.n(f0VarO, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return f0VarO;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:29:0x0068, B:21:0x0048, B:31:0x006d), top: B:40:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0068 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:29:0x0068, B:21:0x0048, B:31:0x006d), top: B:40:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:31:0x006d A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:29:0x0068, B:21:0x0048, B:31:0x006d), top: B:40:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0057 -> B:25:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object u(pq.f0 r5, java.util.Collection r6, um.d r7) {
        /*
            boolean r0 = r7 instanceof pq.u.o
            if (r0 == 0) goto L13
            r0 = r7
            pq.u$o r0 = (pq.u.o) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$o r0 = new pq.u$o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            pq.n r5 = (pq.n) r5
            java.lang.Object r6 = r0.L$1
            pq.f0 r6 = (pq.f0) r6
            java.lang.Object r2 = r0.L$0
            java.util.Collection r2 = (java.util.Collection) r2
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L33
            goto L5a
        L33:
            r5 = move-exception
            goto L78
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            lm.d1.n(r7)
            pq.n r7 = r5.iterator()     // Catch: java.lang.Throwable -> L74
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L48:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L33
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L33
            r0.label = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r2 = r5.b(r0)     // Catch: java.lang.Throwable -> L33
            if (r2 != r1) goto L57
            return r1
        L57:
            r4 = r2
            r2 = r7
            r7 = r4
        L5a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L33
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L6b
            r2.add(r7)     // Catch: java.lang.Throwable -> L33
        L6b:
            r7 = r2
            goto L48
        L6d:
            lm.l2 r5 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L33
            r5 = 0
            pq.t.a(r6, r5)
            return r2
        L74:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L78:
            throw r5     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            pq.t.a(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.u(pq.f0, java.util.Collection, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0032, B:28:0x006c, B:30:0x0074, B:32:0x007a, B:36:0x008d, B:20:0x004d), top: B:47:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007a A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0032, B:28:0x006c, B:30:0x0074, B:32:0x007a, B:36:0x008d, B:20:0x004d), top: B:47:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0032, B:28:0x006c, B:30:0x0074, B:32:0x007a, B:36:0x008d, B:20:0x004d), top: B:47:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, pq.g0] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [pq.f0] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [pq.g0] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [pq.f0] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, pq.f0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0078 -> B:35:0x0089). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0086 -> B:35:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final java.lang.Object v(pq.f0 r6, pq.g0 r7, um.d r8) {
        /*
            boolean r0 = r8 instanceof pq.u.p
            if (r0 == 0) goto L13
            r0 = r8
            pq.u$p r0 = (pq.u.p) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.u$p r0 = new pq.u$p
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            pq.g0 r2 = (pq.g0) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L36
            goto L89
        L36:
            r6 = move-exception
            goto L98
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            pq.g0 r2 = (pq.g0) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L36
            goto L6c
        L51:
            lm.d1.n(r8)
            pq.n r8 = r6.iterator()     // Catch: java.lang.Throwable -> L94
        L58:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L94
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L94
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L94
            r0.label = r4     // Catch: java.lang.Throwable -> L94
            java.lang.Object r2 = r8.b(r0)     // Catch: java.lang.Throwable -> L94
            if (r2 != r1) goto L67
            return r1
        L67:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L6c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L36
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r8 == 0) goto L8d
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L36
            if (r8 == 0) goto L89
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L36
            r0.label = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = r2.L(r8, r0)     // Catch: java.lang.Throwable -> L36
            if (r8 != r1) goto L89
            return r1
        L89:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L58
        L8d:
            lm.l2 r6 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L36
            r6 = 0
            pq.t.a(r7, r6)
            return r2
        L94:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L98:
            throw r6     // Catch: java.lang.Throwable -> L99
        L99:
            r8 = move-exception
            pq.t.a(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.u.v(pq.f0, pq.g0, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:23:0x0051, B:25:0x0059, B:28:0x0062, B:29:0x0069), top: B:40:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[Catch: all -> 0x002f, TRY_ENTER, TryCatch #2 {all -> 0x002f, blocks: (B:12:0x002b, B:23:0x0051, B:25:0x0059, B:28:0x0062, B:29:0x0069), top: B:40:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object w(pq.f0 f0Var, um.d dVar) {
        q qVar;
        pq.f0 f0Var2;
        Throwable th2;
        pq.n nVar;
        if (dVar instanceof q) {
            qVar = (q) dVar;
            int i10 = qVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                qVar.label = i10 - Integer.MIN_VALUE;
            } else {
                qVar = new q(dVar);
            }
        } else {
            qVar = new q(dVar);
        }
        Object obj = qVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = qVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = (pq.n) qVar.L$1;
            f0Var2 = (pq.f0) qVar.L$0;
            try {
                d1.n(obj);
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = nVar.next();
                pq.t.a(f0Var2, null);
                return next;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    throw th2;
                } catch (Throwable th4) {
                    pq.t.a(f0Var2, th2);
                    throw th4;
                }
            }
        }
        d1.n(obj);
        try {
            pq.n it = f0Var.iterator();
            qVar.L$0 = f0Var;
            qVar.L$1 = it;
            qVar.label = 1;
            Object objB = it.b(qVar);
            if (objB == aVar) {
                return aVar;
            }
            f0Var2 = f0Var;
            nVar = it;
            obj = objB;
            if (((Boolean) obj).booleanValue()) {
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
            Object next2 = nVar.next();
            pq.t.a(f0Var2, null);
            return next2;
        } catch (Throwable th5) {
            f0Var2 = f0Var;
            th2 = th5;
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final Object x(pq.f0 f0Var, um.d dVar) {
        r rVar;
        pq.f0 f0Var2;
        Throwable th2;
        pq.n nVar;
        if (dVar instanceof r) {
            rVar = (r) dVar;
            int i10 = rVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                rVar.label = i10 - Integer.MIN_VALUE;
            } else {
                rVar = new r(dVar);
            }
        } else {
            rVar = new r(dVar);
        }
        Object obj = rVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = rVar.label;
        if (i11 == 0) {
            d1.n(obj);
            try {
                pq.n it = f0Var.iterator();
                rVar.L$0 = f0Var;
                rVar.L$1 = it;
                rVar.label = 1;
                Object objB = it.b(rVar);
                if (objB == aVar) {
                    return aVar;
                }
                f0Var2 = f0Var;
                nVar = it;
                obj = objB;
            } catch (Throwable th3) {
                f0Var2 = f0Var;
                th2 = th3;
                throw th2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = (pq.n) rVar.L$1;
            f0Var2 = (pq.f0) rVar.L$0;
            try {
                d1.n(obj);
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    throw th2;
                } catch (Throwable th5) {
                    pq.t.a(f0Var2, th2);
                    throw th5;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            pq.t.a(f0Var2, null);
            return null;
        }
        Object next = nVar.next();
        pq.t.a(f0Var2, null);
        return next;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public static final pq.f0 y(pq.f0 f0Var, um.g gVar, jn.p pVar) {
        return pq.b0.g(c2.f11831a, gVar, 0, null, new b(f0Var), new s(f0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ pq.f0 z(pq.f0 f0Var, um.g gVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.g();
        }
        return y(f0Var, gVar, pVar);
    }
}
