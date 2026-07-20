package i4;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class q4 extends h0 {
    final /* synthetic */ r4 this$0;

    public q4(r4 r4Var) {
        this.this$0 = r4Var;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.this$0.f5686h;
    }

    @Override // java.util.List
    public Map.Entry<Object, Object> get(int i8) {
        v8.h(i8, this.this$0.f5686h);
        int i9 = i8 * 2;
        Object obj = this.this$0.f5685d[this.this$0.e + i9];
        Objects.requireNonNull(obj);
        Object obj2 = this.this$0.f5685d[i9 + (this.this$0.e ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }
}
