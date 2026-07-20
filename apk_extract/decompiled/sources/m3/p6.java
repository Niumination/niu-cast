package m3;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class p6 {
    public static void a(zg.t tVar, Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        for (Map.Entry entry : tVar.a()) {
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }
}
