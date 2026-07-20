package k3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
public abstract class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6416a = 1;

    public int hashCode() {
        switch (this.f6416a) {
            case 1:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f6416a) {
            case 1:
                String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
                Intrinsics.checkNotNull(simpleName);
                return simpleName;
            default:
                return super.toString();
        }
    }
}
