package zf;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c6.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f11497d = 0;

    static {
        new e("file");
        new e("mixed");
        new e("attachment");
        new e("inline");
    }

    public /* synthetic */ e(String str) {
        this(str, CollectionsKt.emptyList());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (Intrinsics.areEqual((String) this.f1434b, (String) eVar.f1434b)) {
                if (Intrinsics.areEqual((List) this.f1435c, (List) eVar.f1435c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((List) this.f1435c).hashCode() + (((String) this.f1434b).hashCode() * 31);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String disposition, List parameters) {
        super(disposition, parameters);
        Intrinsics.checkNotNullParameter(disposition, "disposition");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }
}
