package oh;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends ObservableProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f8486b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Object obj, i0 i0Var, int i8) {
        super(obj);
        this.f8485a = i8;
        this.f8486b = i0Var;
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty property, Object obj, Object obj2) {
        switch (this.f8485a) {
            case 0:
                Intrinsics.checkNotNullParameter(property, "property");
                long jLongValue = ((Number) obj2).longValue();
                ((Number) obj).longValue();
                this.f8486b.e.f8514c = jLongValue;
                break;
            default:
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                ((Boolean) obj).getClass();
                this.f8486b.f8491d.f8477c = zBooleanValue;
                break;
        }
    }
}
