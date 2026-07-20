package androidx.window.layout;

import android.app.Activity;
import androidx.constraintlayout.widget.ConstraintLayout;
import jn.p;
import kn.l0;
import kn.w;
import lm.l2;
import os.l;
import os.m;
import sq.i;
import sq.i0;
import sq.j;
import um.d;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private final WindowBackend windowBackend;

    @l
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    @f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {"$this$flow", "listener", "$this$flow", "listener"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends o implements p<j<? super WindowLayoutInfo>, d<? super l2>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m14invokeSuspend$lambda0(pq.l lVar, WindowLayoutInfo windowLayoutInfo) {
            l0.o(windowLayoutInfo, "info");
            lVar.w(windowLayoutInfo);
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            AnonymousClass1 anonymousClass1 = WindowInfoTrackerImpl.this.new AnonymousClass1(this.$activity, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0070 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0071  */
        /* JADX WARN: Code duplicated, block: B:24:0x007c A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:7:0x0018, B:18:0x0062, B:22:0x0074, B:24:0x007c, B:14:0x0034, B:17:0x005e), top: B:31:0x0006 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0090 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0091  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008e -> B:8:0x001b). Please report as a decompilation issue!!! */
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L38
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                java.lang.Object r1 = r9.L$2
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r9.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r9.L$0
                sq.j r5 = (sq.j) r5
                lm.d1.n(r10)     // Catch: java.lang.Throwable -> L1d
            L1b:
                r10 = r5
                goto L62
            L1d:
                r10 = move-exception
                goto L9d
            L20:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L28:
                java.lang.Object r1 = r9.L$2
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r9.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r9.L$0
                sq.j r5 = (sq.j) r5
                lm.d1.n(r10)     // Catch: java.lang.Throwable -> L1d
                goto L74
            L38:
                lm.d1.n(r10)
                java.lang.Object r10 = r9.L$0
                sq.j r10 = (sq.j) r10
                pq.i r1 = pq.i.DROP_OLDEST
                r4 = 4
                r5 = 10
                r6 = 0
                pq.l r1 = pq.o.d(r5, r1, r6, r4, r6)
                androidx.window.layout.a r4 = new androidx.window.layout.a
                r4.<init>()
                androidx.window.layout.WindowInfoTrackerImpl r5 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
                android.app.Activity r6 = r9.$activity
                h0.c r7 = new h0.c
                r7.<init>()
                r5.registerLayoutChangeCallback(r6, r7, r4)
                pq.n r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1d
            L62:
                r9.L$0 = r10     // Catch: java.lang.Throwable -> L1d
                r9.L$1 = r4     // Catch: java.lang.Throwable -> L1d
                r9.L$2 = r1     // Catch: java.lang.Throwable -> L1d
                r9.label = r3     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r5 = r1.b(r9)     // Catch: java.lang.Throwable -> L1d
                if (r5 != r0) goto L71
                return r0
            L71:
                r8 = r5
                r5 = r10
                r10 = r8
            L74:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1d
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1d
                if (r10 == 0) goto L91
                java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L1d
                androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> L1d
                r9.L$0 = r5     // Catch: java.lang.Throwable -> L1d
                r9.L$1 = r4     // Catch: java.lang.Throwable -> L1d
                r9.L$2 = r1     // Catch: java.lang.Throwable -> L1d
                r9.label = r2     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r10 = r5.emit(r10, r9)     // Catch: java.lang.Throwable -> L1d
                if (r10 != r0) goto L1b
                return r0
            L91:
                androidx.window.layout.WindowInfoTrackerImpl r9 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r9)
                r9.unregisterLayoutChangeCallback(r4)
                lm.l2 r9 = lm.l2.f10208a
                return r9
            L9d:
                androidx.window.layout.WindowInfoTrackerImpl r9 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r9)
                r9.unregisterLayoutChangeCallback(r4)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l j<? super WindowLayoutInfo> jVar, @m d<? super l2> dVar) {
            return ((AnonymousClass1) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public WindowInfoTrackerImpl(@l WindowMetricsCalculator windowMetricsCalculator, @l WindowBackend windowBackend) {
        l0.p(windowMetricsCalculator, "windowMetricsCalculator");
        l0.p(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    @l
    public i<WindowLayoutInfo> windowLayoutInfo(@l Activity activity) {
        l0.p(activity, "activity");
        return new i0(new AnonymousClass1(activity, null));
    }
}
