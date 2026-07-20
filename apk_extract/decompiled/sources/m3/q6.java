package m3;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class q6 {
    public static final void a(zg.u uVar, zg.u builder) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (Map.Entry entry : builder.a()) {
            uVar.c((String) entry.getKey(), (List) entry.getValue());
        }
    }
}
