package fg;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KCallable;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater[] f5041a;
    private volatile li.j acceptHandlerReference;
    private volatile li.j connectHandlerReference;
    private volatile li.j readHandlerReference;
    private volatile li.j writeHandlerReference;

    static {
        KCallable kCallable;
        r.Companion.getClass();
        r[] rVarArr = r.AllInterests;
        ArrayList arrayList = new ArrayList(rVarArr.length);
        for (r rVar : rVarArr) {
            int i8 = l.$EnumSwitchMapping$0[rVar.ordinal()];
            if (i8 == 1) {
                kCallable = new MutablePropertyReference1Impl() { // from class: fg.g
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((m) obj).readHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((m) obj).readHandlerReference = (li.j) obj2;
                    }
                };
            } else if (i8 == 2) {
                kCallable = new MutablePropertyReference1Impl() { // from class: fg.h
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((m) obj).writeHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((m) obj).writeHandlerReference = (li.j) obj2;
                    }
                };
            } else if (i8 == 3) {
                kCallable = new MutablePropertyReference1Impl() { // from class: fg.i
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((m) obj).acceptHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((m) obj).acceptHandlerReference = (li.j) obj2;
                    }
                };
            } else {
                if (i8 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                kCallable = new MutablePropertyReference1Impl() { // from class: fg.j
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((m) obj).connectHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((m) obj).connectHandlerReference = (li.j) obj2;
                    }
                };
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(m.class, li.j.class, kCallable.getName());
            Intrinsics.checkNotNull(atomicReferenceFieldUpdaterNewUpdater, "null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReferenceFieldUpdater<io.ktor.network.selector.InterestSuspensionsMap, kotlinx.coroutines.CancellableContinuation<kotlin.Unit>?>");
            arrayList.add(atomicReferenceFieldUpdaterNewUpdater);
        }
        f5041a = (AtomicReferenceFieldUpdater[]) arrayList.toArray(new AtomicReferenceFieldUpdater[0]);
    }

    public final String toString() {
        return "R " + this.readHandlerReference + " W " + this.writeHandlerReference + " C " + this.connectHandlerReference + " A " + this.acceptHandlerReference;
    }
}
