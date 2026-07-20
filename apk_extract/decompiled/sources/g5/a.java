package g5;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends LinkedHashMap {
    final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, int i8, float f, boolean z2) {
        super(i8, f, z2);
        this.this$0 = bVar;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Object, Object> entry) {
        return size() > this.this$0.f5113b;
    }
}
