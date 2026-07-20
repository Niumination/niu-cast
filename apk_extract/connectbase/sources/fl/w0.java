package fl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class w0<K, V> extends LinkedHashMap<K, V> {

    @os.l
    private final jn.l<V, l2> close;
    private final int maxSize;

    @os.l
    private final jn.l<K, V> supplier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public w0(@os.l jn.l<? super K, ? extends V> lVar, @os.l jn.l<? super V, l2> lVar2, int i10) {
        super(10, 0.75f, true);
        kn.l0.p(lVar, "supplier");
        kn.l0.p(lVar2, "close");
        this.supplier = lVar;
        this.close = lVar2;
        this.maxSize = i10;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (this.maxSize == 0) {
            return this.supplier.invoke(obj);
        }
        synchronized (this) {
            V v10 = (V) super.get(obj);
            if (v10 != null) {
                return v10;
            }
            V vInvoke = this.supplier.invoke(obj);
            put(obj, vInvoke);
            return vInvoke;
        }
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(@os.l Map.Entry<? extends K, ? extends V> entry) {
        kn.l0.p(entry, "eldest");
        boolean z10 = size() > this.maxSize;
        if (z10) {
            this.close.invoke(entry.getValue());
        }
        return z10;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }
}
