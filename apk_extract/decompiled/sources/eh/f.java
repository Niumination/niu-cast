package eh;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f4960b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4961a;

    public f() {
        ArrayList eventOrder = new ArrayList();
        Intrinsics.checkNotNullParameter(eventOrder, "eventOrder");
        super(f4960b);
        this.f4961a = eventOrder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && Intrinsics.areEqual(this.f4961a, ((f) obj).f4961a);
    }

    public final int hashCode() {
        return this.f4961a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("PluginsTrace("), CollectionsKt___CollectionsKt.joinToString$default(this.f4961a, null, null, null, 0, null, null, 63, null), ')');
    }
}
