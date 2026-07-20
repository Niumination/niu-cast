package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
@b1.d
public final class c1<K extends Enum<K>, V> extends a<K, V> {

    @b1.c
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;

    public c1(Class<K> keyType) {
        super(new EnumMap(keyType), new HashMap());
        this.keyTypeOrObjectUnderJ2cl = keyType;
    }

    public static <K extends Enum<K>, V> c1<K, V> create(Class<K> keyType) {
        return new c1<>(keyType);
    }

    @b1.c
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Object object = stream.readObject();
        Objects.requireNonNull(object);
        this.keyTypeOrObjectUnderJ2cl = (Class) object;
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new HashMap());
        i6.b(this, stream);
    }

    @b1.c
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.keyTypeOrObjectUnderJ2cl);
        i6.i(this, stream);
    }

    @Override // f1.a, f1.d2, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // f1.a, f1.d2, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@gm.a Object value) {
        return super.containsValue(value);
    }

    @Override // f1.a, f1.d2, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // f1.a, f1.w
    public /* bridge */ /* synthetic */ w inverse() {
        return super.inverse();
    }

    @Override // f1.a, f1.d2, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @b1.c
    public Class<K> keyType() {
        return this.keyTypeOrObjectUnderJ2cl;
    }

    @Override // f1.a, f1.d2, java.util.Map, f1.w
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // f1.a, f1.d2, java.util.Map
    @gm.a
    @t1.a
    public /* bridge */ /* synthetic */ Object remove(@gm.a Object key) {
        return super.remove(key);
    }

    @Override // f1.a, f1.d2, java.util.Map, f1.w
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> c1<K, V> create(Map<K, ? extends V> map) {
        c1<K, V> c1VarCreate = create(b1.inferKeyTypeOrObjectUnderJ2cl(map));
        c1VarCreate.putAll(map);
        return c1VarCreate;
    }

    @Override // f1.a
    public K checkKey(K key) {
        key.getClass();
        return key;
    }

    @Override // f1.a, f1.w
    @gm.a
    @t1.a
    public V forcePut(K k10, @m5 V v10) {
        return (V) super.forcePut(k10, (Object) v10);
    }

    @Override // f1.a, f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    public V put(K k10, @m5 V v10) {
        return (V) super.put(k10, (Object) v10);
    }
}
