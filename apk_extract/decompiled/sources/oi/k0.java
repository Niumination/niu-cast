package oi;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends pi.b implements y, h, pi.s {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(k0.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8558d;

    public k0(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009d A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0095, B:34:0x009d, B:37:0x00a4, B:38:0x00a8, B:40:0x00ab, B:50:0x00cc, B:53:0x00dc, B:42:0x00b1, B:46:0x00b8, B:22:0x005f), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ab A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0095, B:34:0x009d, B:37:0x00a4, B:38:0x00a8, B:40:0x00ab, B:50:0x00cc, B:53:0x00dc, B:42:0x00b1, B:46:0x00b8, B:22:0x005f), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b1 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0095, B:34:0x009d, B:37:0x00a4, B:38:0x00a8, B:40:0x00ab, B:50:0x00cc, B:53:0x00dc, B:42:0x00b1, B:46:0x00b8, B:22:0x005f), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:53:0x00dc A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0095, B:34:0x009d, B:37:0x00a4, B:38:0x00a8, B:40:0x00ab, B:50:0x00cc, B:53:0x00dc, B:42:0x00b1, B:46:0x00b8, B:22:0x005f), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [pi.d] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, oi.l0] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [oi.l0] */
    /* JADX WARN: Type inference failed for: r7v1, types: [pi.b] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00db -> B:32:0x0095). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ec -> B:32:0x0095). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00ab
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // oi.h
    public final java.lang.Object a(oi.i r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oi.k0.a(oi.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // pi.s
    public final h b(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        return (((i8 < 0 || i8 >= 2) && i8 != -2) || cVar != ni.c.DROP_OLDEST) ? j.i(this, coroutineContext, i8, cVar) : this;
    }

    @Override // pi.b
    public final pi.d d() {
        return new l0();
    }

    @Override // pi.b
    public final pi.d[] e() {
        return new l0[2];
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        g(obj);
        return Unit.INSTANCE;
    }

    public final void g(Object obj) {
        int i8;
        pi.d[] dVarArr;
        a8.a aVar;
        if (obj == null) {
            obj = pi.c.f8895b;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            if (Intrinsics.areEqual(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i9 = this.f8558d;
            if ((i9 & 1) != 0) {
                this.f8558d = i9 + 2;
                return;
            }
            int i10 = i9 + 1;
            this.f8558d = i10;
            pi.d[] dVarArr2 = this.f8888a;
            Unit unit = Unit.INSTANCE;
            while (true) {
                l0[] l0VarArr = (l0[]) dVarArr2;
                if (l0VarArr != null) {
                    for (l0 l0Var : l0VarArr) {
                        if (l0Var != null) {
                            AtomicReference atomicReference = l0Var.f8559a;
                            while (true) {
                                Object obj2 = atomicReference.get();
                                if (obj2 == null || obj2 == (aVar = j.f8556c)) {
                                    break;
                                }
                                a8.a aVar2 = j.f8555b;
                                if (obj2 != aVar2) {
                                    if (atomicReference.compareAndSet(obj2, aVar2)) {
                                        Result.Companion companion = Result.INSTANCE;
                                        ((li.l) obj2).resumeWith(Result.m159constructorimpl(Unit.INSTANCE));
                                        break;
                                    }
                                } else {
                                    if (atomicReference.compareAndSet(obj2, aVar)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i8 = this.f8558d;
                    if (i8 == i10) {
                        this.f8558d = i10 + 1;
                        return;
                    } else {
                        dVarArr = this.f8888a;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                dVarArr2 = dVarArr;
                i10 = i8;
            }
        }
    }

    @Override // oi.i0
    public final Object getValue() {
        a8.a aVar = pi.c.f8895b;
        Object obj = e.get(this);
        if (obj == aVar) {
            return null;
        }
        return obj;
    }
}
