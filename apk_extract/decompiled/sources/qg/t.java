package qg;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends ClassLoader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(ClassLoader delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    public final ArrayList a() {
        Package[] packages = getPackages();
        Intrinsics.checkNotNullExpressionValue(packages, "getPackages(...)");
        ArrayList arrayList = new ArrayList(packages.length);
        for (Package r7 : packages) {
            arrayList.add(r7.getName());
        }
        return arrayList;
    }
}
