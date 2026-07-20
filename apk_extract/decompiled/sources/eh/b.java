package eh;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4955b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4956a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String pluginName) {
        super(f4955b);
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        this.f4956a = pluginName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && Intrinsics.areEqual(this.f4956a, ((b) obj).f4956a);
    }

    public final int hashCode() {
        return this.f4956a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("PluginName("), this.f4956a, ')');
    }
}
