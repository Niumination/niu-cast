package li;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f7449b = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7450a;

    public f0(String str) {
        super(f7449b);
        this.f7450a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && Intrinsics.areEqual(this.f7450a, ((f0) obj).f7450a);
    }

    public final int hashCode() {
        return this.f7450a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("CoroutineName("), this.f7450a, ')');
    }
}
