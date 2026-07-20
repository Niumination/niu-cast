package pq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kn.r1;
import lm.l2;
import nm.k0;
import nq.s0;
import nq.t0;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
public final class e<E> extends j<E> implements pq.d<E> {

    @os.m
    public Object H;

    @os.l
    public final HashMap<yq.m<?>, Object> I;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final ReentrantLock f13238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public List<? extends j<E>> f13239z;

    @r1({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    public final class a extends j<E> {
        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            super(e.this.f13237x, null, 2, 0 == true ? 1 : 0);
        }

        @Override // pq.j
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public boolean R(@os.m Throwable th2) {
            e<E> eVar = e.this;
            ReentrantLock reentrantLock = eVar.f13238y;
            reentrantLock.lock();
            try {
                eVar.Q1(this);
                return super.R(th2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final class b extends y<E> {
        public b() {
            super(1, i.DROP_OLDEST, null, 4, null);
        }

        @Override // pq.j
        /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
        public boolean R(@os.m Throwable th2) {
            e.this.Q1(this);
            return super.R(th2);
        }
    }

    @r1({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ Object $element;
        final /* synthetic */ yq.m<?> $select;
        int label;
        final /* synthetic */ e<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e<E> eVar, Object obj, yq.m<?> mVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.this$0 = eVar;
            this.$element = obj;
            this.$select = mVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new c(this.this$0, this.$element, this.$select, dVar);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to pq.e$c for r4v4 'this'  um.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r5) {
            /*
                r4 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                lm.d1.n(r5)     // Catch: java.lang.Throwable -> Ld
                goto L3c
            Ld:
                r5 = move-exception
                goto L27
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L17:
                lm.d1.n(r5)
                pq.e<E> r5 = r4.this$0     // Catch: java.lang.Throwable -> Ld
                java.lang.Object r1 = r4.$element     // Catch: java.lang.Throwable -> Ld
                r4.label = r2     // Catch: java.lang.Throwable -> Ld
                java.lang.Object r5 = r5.L(r1, r4)     // Catch: java.lang.Throwable -> Ld
                if (r5 != r0) goto L3c
                return r0
            L27:
                pq.e<E> r0 = r4.this$0
                boolean r0 = r0.J()
                if (r0 == 0) goto L7b
                boolean r0 = r5 instanceof pq.w
                if (r0 != 0) goto L3b
                pq.e<E> r0 = r4.this$0
                java.lang.Throwable r0 = r0.o0()
                if (r0 != r5) goto L7b
            L3b:
                r2 = 0
            L3c:
                pq.e<E> r5 = r4.this$0
                java.util.concurrent.locks.ReentrantLock r5 = pq.e.I1(r5)
                pq.e<E> r0 = r4.this$0
                yq.m<?> r4 = r4.$select
                r5.lock()
                java.util.HashMap<yq.m<?>, java.lang.Object> r1 = r0.I     // Catch: java.lang.Throwable -> L50
                if (r2 == 0) goto L52
                lm.l2 r2 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L50
                goto L56
            L50:
                r4 = move-exception
                goto L77
            L52:
                vq.u0 r2 = pq.k.z()     // Catch: java.lang.Throwable -> L50
            L56:
                r1.put(r4, r2)     // Catch: java.lang.Throwable -> L50
                java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>"
                kn.l0.n(r4, r1)     // Catch: java.lang.Throwable -> L50
                r1 = r4
                yq.l r1 = (yq.l) r1     // Catch: java.lang.Throwable -> L50
                r1 = r4
                yq.l r1 = (yq.l) r1     // Catch: java.lang.Throwable -> L50
                lm.l2 r2 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L50
                yq.r r1 = r1.K(r0, r2)     // Catch: java.lang.Throwable -> L50
                yq.r r3 = yq.r.REREGISTER     // Catch: java.lang.Throwable -> L50
                if (r1 == r3) goto L73
                java.util.HashMap<yq.m<?>, java.lang.Object> r0 = r0.I     // Catch: java.lang.Throwable -> L50
                r0.remove(r4)     // Catch: java.lang.Throwable -> L50
            L73:
                r5.unlock()
                return r2
            L77:
                r5.unlock()
                throw r4
            L7b:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.e.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {230}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ e<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e<E> eVar, um.d<? super d> dVar) {
            super(dVar);
            this.this$0 = eVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.L(null, this);
        }
    }

    public e(int i10) {
        super(0, null);
        this.f13237x = i10;
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException(k.b.a("BroadcastChannel capacity must be positive or Channel.CONFLATED, but ", i10, " was specified").toString());
        }
        this.f13238y = new ReentrantLock();
        this.f13239z = k0.INSTANCE;
        this.H = f.f13243a;
        this.I = new HashMap<>();
    }

    public static /* synthetic */ void N1() {
    }

    public static /* synthetic */ void P1() {
    }

    @Override // pq.j, pq.g0
    public boolean J() {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            return super.J();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:33:0x008b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007f -> B:12:0x0033). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pq.j, pq.g0
    @os.m
    public java.lang.Object L(E r7, @os.l um.d<? super lm.l2> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof pq.e.d
            if (r0 == 0) goto L13
            r0 = r8
            pq.e$d r0 = (pq.e.d) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.e$d r0 = new pq.e$d
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            pq.e r2 = (pq.e) r2
            lm.d1.n(r8)
            r5 = r0
            r0 = r7
            r7 = r2
        L33:
            r2 = r5
            goto L83
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            lm.d1.n(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f13238y
            r8.lock()
            boolean r2 = r6.J()     // Catch: java.lang.Throwable -> L53
            if (r2 != 0) goto L9d
            int r2 = r6.f13237x     // Catch: java.lang.Throwable -> L53
            r4 = -1
            if (r2 != r4) goto L55
            r6.H = r7     // Catch: java.lang.Throwable -> L53
            goto L55
        L53:
            r6 = move-exception
            goto La2
        L55:
            java.util.List<? extends pq.j<E>> r2 = r6.f13239z     // Catch: java.lang.Throwable -> L53
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L64:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L9a
            java.lang.Object r2 = r6.next()
            pq.j r2 = (pq.j) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r2 = r2.n1(r8, r0)
            if (r2 != r1) goto L7f
            return r1
        L7f:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L33
        L83:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L97
            boolean r8 = r7.J()
            if (r8 != 0) goto L92
            goto L97
        L92:
            java.lang.Throwable r6 = r7.o0()
            throw r6
        L97:
            r8 = r0
            r0 = r2
            goto L64
        L9a:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L9d:
            java.lang.Throwable r6 = r6.o0()     // Catch: java.lang.Throwable -> L53
            throw r6     // Catch: java.lang.Throwable -> L53
        La2:
            r8.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.e.L(java.lang.Object, um.d):java.lang.Object");
    }

    public final int L1() {
        return this.f13237x;
    }

    public final E M1() {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            if (J()) {
                Throwable thG0 = g0();
                if (thG0 == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw thG0;
            }
            if (this.H == f.f13243a) {
                throw new IllegalStateException("No value");
            }
            E e10 = (E) this.H;
            reentrantLock.unlock();
            return e10;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @os.m
    public final E O1() {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            E e10 = null;
            if (!r() && this.H != f.f13243a) {
                e10 = (E) this.H;
            }
            return e10;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q1(f0<? extends E> f0Var) {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            List<? extends j<E>> list = this.f13239z;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((j) obj) != f0Var) {
                    arrayList.add(obj);
                }
            }
            this.f13239z = arrayList;
            l2 l2Var = l2.f10208a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // pq.j
    public boolean R(@os.m Throwable th2) {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f13239z.iterator();
            while (it.hasNext()) {
                ((j) it.next()).R(th2);
            }
            this.H = f.f13243a;
            return super.R(th2);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pq.j, pq.g0
    public boolean f(@os.m Throwable th2) {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f13239z.iterator();
            while (it.hasNext()) {
                ((j) it.next()).f(th2);
            }
            List<? extends j<E>> list = this.f13239z;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((j) obj).q0()) {
                    arrayList.add(obj);
                }
            }
            this.f13239z = arrayList;
            return V(th2, false);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // pq.j
    public void h1(@os.l yq.m<?> mVar, @os.m Object obj) {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            Object objRemove = this.I.remove(mVar);
            if (objRemove != null) {
                mVar.f(objRemove);
                reentrantLock.unlock();
            } else {
                l2 l2Var = l2.f10208a;
                reentrantLock.unlock();
                nq.k.f(t0.a(mVar.getContext()), null, u0.UNDISPATCHED, new c(this, obj, mVar, null), 1, null);
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // pq.j
    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.H != f.f13243a ? j.e.a(new StringBuilder("CONFLATED_ELEMENT="), this.H, "; ") : "");
        sb2.append("BROADCAST=<");
        sb2.append(super.toString());
        sb2.append(">; SUBSCRIBERS=");
        sb2.append(nm.h0.m3(this.f13239z, ";", "<", ">", 0, null, null, 56, null));
        return sb2.toString();
    }

    @Override // pq.d
    @os.l
    public f0<E> v() {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            a bVar = this.f13237x == -1 ? new b() : new a();
            if (J() && this.H == f.f13243a) {
                ((j) bVar).f(g0());
                return bVar;
            }
            if (this.H != f.f13243a) {
                ((j) bVar).w(M1());
            }
            this.f13239z = nm.h0.F4(this.f13239z, bVar);
            return bVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // pq.j, pq.g0
    @os.l
    public Object w(E e10) {
        ReentrantLock reentrantLock = this.f13238y;
        reentrantLock.lock();
        try {
            if (J()) {
                Object objW = super.w(e10);
                reentrantLock.unlock();
                return objW;
            }
            List<? extends j<E>> list = this.f13239z;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).u1()) {
                        p.f13308b.getClass();
                        p.c cVar = p.f13309c;
                        reentrantLock.unlock();
                        return cVar;
                    }
                }
            }
            if (this.f13237x == -1) {
                this.H = e10;
            }
            Iterator<T> it2 = this.f13239z.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).w(e10);
            }
            p.b bVar = p.f13308b;
            l2 l2Var = l2.f10208a;
            bVar.getClass();
            Object objC = p.c(l2Var);
            reentrantLock.unlock();
            return objC;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
