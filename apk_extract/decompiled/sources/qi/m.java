package qi;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9153a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9154b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9155c = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(m mVar, int i8) {
        m mVarD;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            mVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f9154b;
            if (mVarD == null) {
                Object obj = atomicReferenceFieldUpdater2.get(this);
                while (true) {
                    mVarD = (m) obj;
                    if (!mVarD.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater2.get(mVarD);
                }
            }
            if (mVarD instanceof j) {
                return (((j) mVarD).f9152d & i8) == 0 && mVarD.c(mVar, i8);
            }
            atomicReferenceFieldUpdater2.set(mVar, mVarD);
            atomicReferenceFieldUpdater = f9153a;
            atomicReferenceFieldUpdater.set(mVar, this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(mVarD, this, mVar));
        mVar.e(this);
        return true;
    }

    public final m d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f9154b;
            m mVar = (m) atomicReferenceFieldUpdater2.get(this);
            m mVar2 = mVar;
            while (true) {
                m mVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f9153a;
                    obj = atomicReferenceFieldUpdater.get(mVar2);
                    if (obj == this) {
                        if (mVar != mVar2 && !atomicReferenceFieldUpdater2.compareAndSet(this, mVar, mVar2)) {
                            break;
                        }
                        return mVar2;
                    }
                    if (g()) {
                        return null;
                    }
                    if (!(obj instanceof t)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                        mVar3 = mVar2;
                        mVar2 = (m) obj;
                    } else {
                        if (mVar3 != null) {
                            break;
                        }
                        mVar2 = (m) atomicReferenceFieldUpdater2.get(mVar2);
                    }
                }
                if (!atomicReferenceFieldUpdater.compareAndSet(mVar3, mVar2, ((t) obj).f9167a)) {
                    break;
                }
                mVar2 = mVar3;
            }
        }
    }

    public final void e(m mVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        m mVar2;
        do {
            atomicReferenceFieldUpdater = f9154b;
            mVar2 = (m) atomicReferenceFieldUpdater.get(mVar);
            if (f9153a.get(this) != mVar) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(mVar, mVar2, this));
        if (g()) {
            mVar.d();
        }
    }

    public final m f() {
        m mVar;
        Object obj = f9153a.get(this);
        t tVar = obj instanceof t ? (t) obj : null;
        if (tVar != null && (mVar = tVar.f9167a) != null) {
            return mVar;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (m) obj;
    }

    public boolean g() {
        return f9153a.get(this) instanceof t;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: qi.l
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return this.receiver.getClass().getSimpleName();
            }
        } + '@' + l0.j(this);
    }
}
