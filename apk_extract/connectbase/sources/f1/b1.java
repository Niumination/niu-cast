package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
@b1.d
public final class b1<K extends Enum<K>, V extends Enum<V>> extends a<K, V> {

    @b1.c
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;
    transient Class<V> valueTypeOrObjectUnderJ2cl;

    public b1(Class<K> keyTypeOrObjectUnderJ2cl, Class<V> valueTypeOrObjectUnderJ2cl) {
        super(new EnumMap(keyTypeOrObjectUnderJ2cl), new EnumMap(valueTypeOrObjectUnderJ2cl));
        this.keyTypeOrObjectUnderJ2cl = keyTypeOrObjectUnderJ2cl;
        this.valueTypeOrObjectUnderJ2cl = valueTypeOrObjectUnderJ2cl;
    }

    public static <K extends Enum<K>, V extends Enum<V>> b1<K, V> create(Class<K> keyType, Class<V> valueType) {
        return new b1<>(keyType, valueType);
    }

    public static <K extends Enum<K>> Class<K> inferKeyTypeOrObjectUnderJ2cl(Map<K, ?> map) {
        if (map instanceof b1) {
            return ((b1) map).keyTypeOrObjectUnderJ2cl;
        }
        if (map instanceof c1) {
            return ((c1) map).keyTypeOrObjectUnderJ2cl;
        }
        c1.h0.d(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    @b1.c
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Object object = stream.readObject();
        Objects.requireNonNull(object);
        this.keyTypeOrObjectUnderJ2cl = (Class) object;
        Object object2 = stream.readObject();
        Objects.requireNonNull(object2);
        this.valueTypeOrObjectUnderJ2cl = (Class) object2;
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new EnumMap(this.valueTypeOrObjectUnderJ2cl));
        i6.b(this, stream);
    }

    public static <V extends Enum<V>> Class<V> s(Map<?, V> map) {
        if (map instanceof b1) {
            return ((b1) map).valueTypeOrObjectUnderJ2cl;
        }
        c1.h0.d(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    @b1.c
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.keyTypeOrObjectUnderJ2cl);
        stream.writeObject(this.valueTypeOrObjectUnderJ2cl);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.a, f1.w
    @gm.a
    @t1.a
    public /* bridge */ /* synthetic */ Object forcePut(@m5 Object key, @m5 Object value) {
        return super.forcePut(key, value);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.a, f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    public /* bridge */ /* synthetic */ Object put(@m5 Object key, @m5 Object value) {
        return super.put(key, value);
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

    @b1.c
    public Class<V> valueType() {
        return this.valueTypeOrObjectUnderJ2cl;
    }

    @Override // f1.a, f1.d2, java.util.Map, f1.w
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> b1<K, V> create(Map<K, V> map) {
        b1<K, V> b1VarCreate = create(inferKeyTypeOrObjectUnderJ2cl(map), s(map));
        b1VarCreate.putAll(map);
        return b1VarCreate;
    }

    @Override // f1.a
    public K checkKey(K key) {
        key.getClass();
        return key;
    }

    @Override // f1.a
    public V checkValue(V value) {
        value.getClass();
        return value;
    }
}
