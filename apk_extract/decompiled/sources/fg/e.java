package fg;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.g0;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Closeable, g0, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectorProvider f5034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5036c;
    private volatile boolean closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f5037d;
    public final se.e e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f5038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineContext f5039i;
    private volatile boolean inSelect;
    private volatile Selector selectorRef;

    public e(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SelectorProvider selectorProviderProvider = SelectorProvider.provider();
        Intrinsics.checkNotNullExpressionValue(selectorProviderProvider, "provider(...)");
        this.f5034a = selectorProviderProvider;
        this.f5037d = new AtomicLong();
        this.e = new se.e(8);
        this.f5038h = new n();
        this.f5039i = context.plus(new f0("selector"));
        l0.p(this, null, null, new a(this, null), 3);
    }

    public static void A(AbstractSelector selector, Throwable th2) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (th2 == null) {
            th2 = new v();
        }
        Set<SelectionKey> setKeys = selector.keys();
        Intrinsics.checkNotNullExpressionValue(setKeys, "keys(...)");
        for (SelectionKey selectionKey : setKeys) {
            try {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
            } catch (CancelledKeyException unused) {
            }
            Object objAttachment = selectionKey.attachment();
            s sVar = objAttachment instanceof s ? (s) objAttachment : null;
            if (sVar != null) {
                t(sVar, th2);
            }
            selectionKey.cancel();
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x010e A[LOOP:1: B:21:0x007b->B:52:0x010e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:65:0x0083 A[EDGE_INSN: B:65:0x0083->B:23:0x0083 BREAK  A[LOOP:1: B:21:0x007b->B:52:0x010e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009f -> B:19:0x0077). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b9 -> B:19:0x0077). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c9 -> B:19:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:65:0x0083
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(fg.e r9, fg.n r10, java.nio.channels.spi.AbstractSelector r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fg.e.a(fg.e, fg.n, java.nio.channels.spi.AbstractSelector, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void t(s attachment, Throwable cause) {
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(cause, "cause");
        m mVarP = attachment.p();
        r.Companion.getClass();
        for (r interest : r.AllInterests) {
            mVarP.getClass();
            Intrinsics.checkNotNullParameter(interest, "interest");
            li.j jVar = (li.j) m.f5041a[interest.ordinal()].getAndSet(mVarP, null);
            if (jVar != null) {
                Result.Companion companion = Result.INSTANCE;
                jVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(cause)));
            }
        }
    }

    public final void H(Set selectedKeys, Set keys) {
        Intrinsics.checkNotNullParameter(selectedKeys, "selectedKeys");
        Intrinsics.checkNotNullParameter(keys, "keys");
        int size = selectedKeys.size();
        this.f5035b = keys.size() - size;
        this.f5036c = 0;
        if (size <= 0) {
            return;
        }
        Iterator it = selectedKeys.iterator();
        while (it.hasNext()) {
            SelectionKey key = (SelectionKey) it.next();
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                int i8 = key.readyOps();
                int iInterestOps = key.interestOps();
                Object objAttachment = key.attachment();
                s sVar = objAttachment instanceof s ? (s) objAttachment : null;
                if (sVar == null) {
                    key.cancel();
                    this.f5036c++;
                } else {
                    m mVarP = sVar.p();
                    r.Companion.getClass();
                    int[] iArr = r.flags;
                    int length = iArr.length;
                    for (int i9 = 0; i9 < length; i9++) {
                        if ((iArr[i9] & i8) != 0) {
                            mVarP.getClass();
                            li.j jVar = (li.j) m.f5041a[i9].getAndSet(mVarP, null);
                            if (jVar != null) {
                                Result.Companion companion = Result.INSTANCE;
                                jVar.resumeWith(Result.m159constructorimpl(Unit.INSTANCE));
                            }
                        }
                    }
                    int i10 = (~i8) & iInterestOps;
                    if (i10 != iInterestOps) {
                        key.interestOps(i10);
                    }
                    if (i10 != 0) {
                        this.f5035b++;
                    }
                }
            } catch (Throwable th2) {
                key.cancel();
                this.f5036c++;
                Object objAttachment2 = key.attachment();
                s sVar2 = objAttachment2 instanceof s ? (s) objAttachment2 : null;
                if (sVar2 != null) {
                    t(sVar2, th2);
                    key.attach(null);
                }
            }
            it.remove();
        }
    }

    public final void L(s selectable) {
        SelectionKey selectionKeyKeyFor;
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        t(selectable, new ClosedChannelException());
        Selector selector = this.selectorRef;
        if (selector == null || (selectionKeyKeyFor = selectable.u().keyFor(selector)) == null) {
            return;
        }
        selectionKeyKeyFor.cancel();
        m0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object S(n nVar, ContinuationImpl continuationImpl) {
        c cVar;
        Object coroutine_suspended;
        if (continuationImpl instanceof c) {
            cVar = (c) continuationImpl;
            int i8 = cVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                cVar.label = i8 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, continuationImpl);
            }
        } else {
            cVar = new c(this, continuationImpl);
        }
        Object obj = cVar.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = cVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            n nVar2 = (n) cVar.L$1;
            e eVar = (e) cVar.L$0;
            ResultKt.throwOnFailure(obj);
            nVar = nVar2;
            this = eVar;
        }
        do {
            s sVar = (s) nVar.d();
            if (sVar != null) {
                return sVar;
            }
            coroutine_suspended = null;
            if (this.closed) {
                return null;
            }
            cVar.L$0 = this;
            cVar.L$1 = nVar;
            cVar.label = 1;
            se.e eVar2 = this.e;
            if (nVar.c() && !this.closed) {
                if (!((AtomicReference) eVar2.f9720b).compareAndSet(null, cVar)) {
                    throw new IllegalStateException("Continuation is already set");
                }
                if ((nVar.c() && !this.closed) || !((AtomicReference) eVar2.f9720b).compareAndSet(cVar, null)) {
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                }
            }
            if (coroutine_suspended == null) {
                coroutine_suspended = Unit.INSTANCE;
            }
            if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(cVar);
            }
        } while (coroutine_suspended != coroutine_suspended2);
        return coroutine_suspended2;
    }

    public final Object a0(s selectable, r interest, ContinuationImpl continuationImpl) throws IOException {
        int iY = selectable.y();
        int flag = interest.getFlag();
        if (selectable.isClosed()) {
            throw new IOException("Selectable is already closed");
        }
        if ((iY & flag) == 0) {
            throw new IllegalStateException(("Selectable is invalid state: " + iY + ", " + flag).toString());
        }
        li.l continuation = new li.l(1, IntrinsicsKt.intercepted(continuationImpl));
        continuation.s();
        continuation.v(w.f5052a);
        m mVarP = selectable.p();
        mVarP.getClass();
        Intrinsics.checkNotNullParameter(interest, "interest");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        if (!m.f5041a[interest.ordinal()].compareAndSet(mVarP, null, continuation)) {
            throw new IllegalStateException(("Handler for " + interest.name() + " is already registered").toString());
        }
        if (!(li.l.f7465i.get(continuation) instanceof li.m)) {
            Intrinsics.checkNotNullParameter(selectable, "selectable");
            try {
                if (!this.f5038h.a(selectable)) {
                    if (selectable.u().isOpen()) {
                        throw new ClosedSelectorException();
                    }
                    throw new ClosedChannelException();
                }
                se.e eVar = this.e;
                Unit unit = Unit.INSTANCE;
                Continuation continuation2 = (Continuation) ((AtomicReference) eVar.f9720b).getAndSet(null);
                if (continuation2 != null) {
                    continuation2.resumeWith(Result.m159constructorimpl(unit));
                }
                m0();
            } catch (Throwable th2) {
                t(selectable, th2);
            }
        }
        Object objR = continuation.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuationImpl);
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.closed = true;
        this.f5038h.b();
        se.e eVar = this.e;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) ((AtomicReference) eVar.f9720b).getAndSet(null);
        if (continuation == null) {
            m0();
        } else {
            continuation.resumeWith(Result.m159constructorimpl(unit));
        }
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f5039i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l0(Selector selector, ContinuationImpl continuationImpl) throws IOException {
        d dVar;
        int iSelectNow;
        if (continuationImpl instanceof d) {
            dVar = (d) continuationImpl;
            int i8 = dVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                dVar.label = i8 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, continuationImpl);
            }
        } else {
            dVar = new d(this, continuationImpl);
        }
        Object obj = dVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = dVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            this.inSelect = true;
            dVar.L$0 = this;
            dVar.L$1 = selector;
            dVar.label = 1;
            if (l0.v(dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            selector = (Selector) dVar.L$1;
            this = (e) dVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (this.f5037d.get() == 0) {
            iSelectNow = selector.select(500L);
            this.inSelect = false;
        } else {
            this.inSelect = false;
            this.f5037d.set(0L);
            iSelectNow = selector.selectNow();
        }
        return Boxing.boxInt(iSelectNow);
    }

    public final void m0() {
        Selector selector;
        if (this.f5037d.incrementAndGet() == 1 && this.inSelect && (selector = this.selectorRef) != null) {
            selector.wakeup();
        }
    }

    public final void s(Selector selector, s selectable) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        try {
            SelectableChannel selectableChannelU = selectable.u();
            SelectionKey selectionKeyKeyFor = selectableChannelU.keyFor(selector);
            int iY = selectable.y();
            if (selectionKeyKeyFor == null) {
                if (iY != 0) {
                    selectableChannelU.register(selector, iY, selectable);
                }
            } else if (selectionKeyKeyFor.interestOps() != iY) {
                selectionKeyKeyFor.interestOps(iY);
            }
            if (iY != 0) {
                this.f5035b++;
            }
        } catch (Throwable th2) {
            SelectionKey selectionKeyKeyFor2 = selectable.u().keyFor(selector);
            if (selectionKeyKeyFor2 != null) {
                selectionKeyKeyFor2.cancel();
            }
            t(selectable, th2);
        }
    }
}
