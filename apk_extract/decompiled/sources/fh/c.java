package fh;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5053a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5054b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5055c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public final void a(yf.b node) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        Intrinsics.checkNotNullParameter(node, "node");
        while (true) {
            Object obj2 = this._prev;
            if (!(obj2 instanceof d)) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                c cVar = (c) obj2;
                if (cVar._next != this) {
                    b(cVar);
                }
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            c cVar2 = (c) obj2;
            cVar2.getClass();
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(this, "next");
            atomicReferenceFieldUpdater = f5054b;
            atomicReferenceFieldUpdater.lazySet(node, cVar2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5053a;
            atomicReferenceFieldUpdater2.lazySet(node, this);
            if (atomicReferenceFieldUpdater2.compareAndSet(cVar2, this, node)) {
                break;
            }
        }
        do {
            obj = this._prev;
            if ((obj instanceof d) || node._next != this) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, node));
        if (node._next instanceof d) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            b((c) obj);
        }
    }

    public final void b(c cVar) {
        Object obj;
        while (true) {
            c cVar2 = null;
            while (true) {
                obj = cVar._next;
                if (obj == null) {
                    return;
                }
                if (!(obj instanceof d)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof d) {
                        return;
                    }
                    if (obj != this) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        cVar2 = cVar;
                        cVar = (c) obj;
                    } else {
                        if (obj2 == cVar) {
                            return;
                        }
                        if (f5054b.compareAndSet(this, obj2, cVar) && !(cVar._prev instanceof d)) {
                            return;
                        }
                    }
                } else if (cVar2 != null) {
                    break;
                } else {
                    cVar = b.a(cVar._prev);
                }
            }
            cVar.e();
            f5053a.compareAndSet(cVar2, cVar, ((d) obj).f5056a);
            cVar = cVar2;
        }
    }

    public final Object c() {
        return this._next;
    }

    public final c d() {
        return b.a(this._next);
    }

    public void dispose() {
        Object obj;
        c cVar;
        d dVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        do {
            obj = this._next;
            if ((obj instanceof d) || obj == this) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            cVar = (c) obj;
            dVar = (d) cVar._removedRef;
            if (dVar == null) {
                dVar = new d(cVar);
                f5055c.lazySet(cVar, dVar);
            }
            atomicReferenceFieldUpdater = f5053a;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, dVar));
        c cVarE = e();
        Object obj3 = this._next;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.ktor.util.internal.Removed");
        c cVar2 = ((d) obj3).f5056a;
        loop1: while (true) {
            c cVar3 = null;
            while (true) {
                Object obj4 = cVar2._next;
                if (obj4 instanceof d) {
                    cVar2.e();
                    cVar2 = ((d) obj4).f5056a;
                } else {
                    obj2 = cVarE._next;
                    if (obj2 instanceof d) {
                        if (cVar3 != null) {
                            break;
                        } else {
                            cVarE = b.a(cVarE._prev);
                        }
                    } else if (obj2 != this) {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        c cVar4 = (c) obj2;
                        if (cVar4 == cVar2) {
                            break loop1;
                        }
                        cVar3 = cVarE;
                        cVarE = cVar4;
                    } else if (atomicReferenceFieldUpdater.compareAndSet(cVarE, this, cVar2)) {
                        break loop1;
                    }
                }
            }
            cVarE.e();
            atomicReferenceFieldUpdater.compareAndSet(cVar3, cVarE, ((d) obj2).f5056a);
            cVarE = cVar3;
        }
        cVar.b(b.a(this._prev));
    }

    public final c e() {
        Object obj;
        c cVarA;
        d dVar;
        do {
            obj = this._prev;
            if (obj instanceof d) {
                return ((d) obj).f5056a;
            }
            if (obj == this) {
                cVarA = this;
                while (!(cVarA instanceof a)) {
                    cVarA = b.a(cVarA._next);
                    if (cVarA == this) {
                        throw new IllegalStateException("Cannot loop to this while looking for list head");
                    }
                }
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                cVarA = (c) obj;
            }
            dVar = (d) cVarA._removedRef;
            if (dVar == null) {
                dVar = new d(cVarA);
                f5055c.lazySet(cVarA, dVar);
            }
        } while (!f5054b.compareAndSet(this, obj, dVar));
        return (c) obj;
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '@' + hashCode();
    }
}
