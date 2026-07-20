package i4;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends t0 {
    @Override // i4.t0
    public s1 createEntrySet() {
        return new n0(this);
    }

    @Override // i4.t0
    public s1 createKeySet() {
        return new x0(this);
    }

    @Override // i4.t0
    public a0 createValues() {
        return new a1(this);
    }

    public abstract h5 entryIterator();

    @Override // i4.t0, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // i4.t0, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // i4.t0, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
