package rq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import gq.o;
import gq.q;
import gq.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import jn.p;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import lm.z0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
@z0
public final class e {

    @os.m
    @in.f
    public volatile WeakReference<xm.e> _lastObservedFrame;

    @in.f
    @os.l
    public volatile String _state = f.f14826a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final m f14822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public final long f14823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final WeakReference<um.g> f14824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14825d;

    @os.m
    @in.f
    public volatile Thread lastObservedThread;

    @xm.f(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.k implements p<o<? super StackTraceElement>, um.d<? super l2>, Object> {
        final /* synthetic */ m $bottom;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$bottom = mVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = e.this.new a(this.$bottom, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l o<? super StackTraceElement> oVar, @os.m um.d<? super l2> dVar) {
            return ((a) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                o<? super StackTraceElement> oVar = (o) this.L$0;
                e eVar = e.this;
                xm.e eVar2 = this.$bottom.f14847a;
                this.label = 1;
                if (eVar.k(oVar, eVar2, this) == aVar) {
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
    }

    @xm.f(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0}, l = {171}, m = "yieldFrames", n = {"this", "$this$yieldFrames", TypedValues.AttributesType.S_FRAME}, s = {"L$0", "L$1", "L$2"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return e.this.k(null, null, this);
        }
    }

    public e(@os.m um.g gVar, @os.m m mVar, long j10) {
        this.f14822a = mVar;
        this.f14823b = j10;
        this.f14824c = new WeakReference<>(gVar);
    }

    public final List<StackTraceElement> b() {
        m mVar = this.f14822a;
        return mVar == null ? k0.INSTANCE : v.c3(q.b(new a(mVar, null)));
    }

    @os.m
    public final um.g c() {
        return this.f14824c.get();
    }

    @os.m
    public final m d() {
        return this.f14822a;
    }

    @os.l
    public final List<StackTraceElement> e() {
        return b();
    }

    @os.m
    public final xm.e f() {
        WeakReference<xm.e> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @os.l
    public final String g() {
        return this._state;
    }

    @os.l
    public final List<StackTraceElement> h() {
        xm.e eVarF = f();
        if (eVarF == null) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        while (eVarF != null) {
            StackTraceElement stackTraceElement = eVarF.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            eVarF = eVarF.getCallerFrame();
        }
        return arrayList;
    }

    public final void i(@os.m xm.e eVar) {
        this._lastObservedFrame = eVar != null ? new WeakReference<>(eVar) : null;
    }

    public final synchronized void j(@os.l String str, @os.l um.d<?> dVar, boolean z10) {
        try {
            if (l0.g(this._state, f.f14827b) && l0.g(str, f.f14827b) && z10) {
                this.f14825d++;
            } else if (this.f14825d > 0 && l0.g(str, f.f14828c)) {
                this.f14825d--;
                return;
            }
            if (l0.g(this._state, str) && l0.g(str, f.f14828c) && f() != null) {
                return;
            }
            this._state = str;
            i(dVar instanceof xm.e ? (xm.e) dVar : null);
            this.lastObservedThread = l0.g(str, f.f14827b) ? Thread.currentThread() : null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0047 -> B:25:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:24:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x0049
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object k(gq.o<? super java.lang.StackTraceElement> r6, xm.e r7, um.d<? super lm.l2> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof rq.e.b
            if (r0 == 0) goto L13
            r0 = r8
            rq.e$b r0 = (rq.e.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            rq.e$b r0 = new rq.e$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            xm.e r5 = (xm.e) r5
            java.lang.Object r6 = r0.L$1
            gq.o r6 = (gq.o) r6
            java.lang.Object r7 = r0.L$0
            rq.e r7 = (rq.e) r7
            lm.d1.n(r8)
            goto L5b
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            lm.d1.n(r8)
        L3e:
            if (r7 != 0) goto L43
            lm.l2 r5 = lm.l2.f10208a
            return r5
        L43:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L5e
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r4 = r7
            r7 = r5
            r5 = r4
        L5b:
            r4 = r7
            r7 = r5
            r5 = r4
        L5e:
            xm.e r7 = r7.getCallerFrame()
            if (r7 == 0) goto L65
            goto L3e
        L65:
            lm.l2 r5 = lm.l2.f10208a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rq.e.k(gq.o, xm.e, um.d):java.lang.Object");
    }

    @os.l
    public String toString() {
        return "DebugCoroutineInfo(state=" + this._state + ",context=" + c() + ')';
    }
}
