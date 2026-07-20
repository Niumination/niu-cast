package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class EmptyHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    private T thisT() {
        return this;
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, V v10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addBoolean(K k10, boolean z10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addByte(K k10, byte b10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addChar(K k10, char c10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addDouble(K k10, double d10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addFloat(K k10, float f10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addInt(K k10, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addLong(K k10, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addShort(K k10, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addTimeMillis(K k10, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T clear() {
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(K k10, boolean z10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(K k10, byte b10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(K k10, char c10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(K k10, double d10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(K k10, float f10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(K k10, int i10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(K k10, long j10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(K k10, Object obj) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(K k10, short s10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K k10, long j10) {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return isEmpty() && ((Headers) obj).isEmpty();
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k10) {
        return Collections.emptyList();
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K k10) {
        return Collections.emptyList();
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(K k10, byte b10) {
        return b10;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(K k10, byte b10) {
        return b10;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(K k10, char c10) {
        return c10;
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(K k10, char c10) {
        return c10;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(K k10, double d10) {
        return d10;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K k10, double d10) {
        return d10;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(K k10, float f10) {
        return f10;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(K k10, float f10) {
        return f10;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(K k10, int i10) {
        return i10;
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(K k10, int i10) {
        return i10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(K k10, long j10) {
        return j10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(K k10, long j10) {
        return j10;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(K k10, long j10) {
        return j10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K k10, long j10) {
        return j10;
    }

    public int hashCode() {
        return -1028477387;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        return true;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // io.netty.handler.codec.Headers
    public Set<K> names() {
        return Collections.emptySet();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(K k10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, V v10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setBoolean(K k10, boolean z10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setByte(K k10, byte b10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setChar(K k10, char c10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setDouble(K k10, double d10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setFloat(K k10, float f10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setInt(K k10, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setLong(K k10, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setShort(K k10, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setTimeMillis(K k10, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName().concat("[]");
    }

    public Iterator<V> valueIterator(K k10) {
        return Collections.emptyList().iterator();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k10, V v10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k10, V v10) {
        return v10;
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k10, V v10) {
        return v10;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(K k10, boolean z10) {
        return z10;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K k10, boolean z10) {
        return z10;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(K k10, short s10) {
        return s10;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(K k10, short s10) {
        return s10;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K k10) {
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, V... vArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }
}
