package pg;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8883a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8884b = "";

    public final sj.a a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String strA = c.a(this.f8884b, path);
        LinkedHashMap linkedHashMap = this.f8883a;
        if (linkedHashMap.containsKey(strA) || linkedHashMap.containsKey(c.a(strA, "size"))) {
            return new sj.a(linkedHashMap, strA);
        }
        return null;
    }
}
