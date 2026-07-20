package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface Headers<K, V, T extends Headers<K, V, T>> extends Iterable<Map.Entry<K, V>> {
    T add(Headers<? extends K, ? extends V, ?> headers);

    T add(K k10, Iterable<? extends V> iterable);

    T add(K k10, V v10);

    T add(K k10, V... vArr);

    T addBoolean(K k10, boolean z10);

    T addByte(K k10, byte b10);

    T addChar(K k10, char c10);

    T addDouble(K k10, double d10);

    T addFloat(K k10, float f10);

    T addInt(K k10, int i10);

    T addLong(K k10, long j10);

    T addObject(K k10, Iterable<?> iterable);

    T addObject(K k10, Object obj);

    T addObject(K k10, Object... objArr);

    T addShort(K k10, short s10);

    T addTimeMillis(K k10, long j10);

    T clear();

    boolean contains(K k10);

    boolean contains(K k10, V v10);

    boolean containsBoolean(K k10, boolean z10);

    boolean containsByte(K k10, byte b10);

    boolean containsChar(K k10, char c10);

    boolean containsDouble(K k10, double d10);

    boolean containsFloat(K k10, float f10);

    boolean containsInt(K k10, int i10);

    boolean containsLong(K k10, long j10);

    boolean containsObject(K k10, Object obj);

    boolean containsShort(K k10, short s10);

    boolean containsTimeMillis(K k10, long j10);

    V get(K k10);

    V get(K k10, V v10);

    List<V> getAll(K k10);

    List<V> getAllAndRemove(K k10);

    V getAndRemove(K k10);

    V getAndRemove(K k10, V v10);

    Boolean getBoolean(K k10);

    boolean getBoolean(K k10, boolean z10);

    Boolean getBooleanAndRemove(K k10);

    boolean getBooleanAndRemove(K k10, boolean z10);

    byte getByte(K k10, byte b10);

    Byte getByte(K k10);

    byte getByteAndRemove(K k10, byte b10);

    Byte getByteAndRemove(K k10);

    char getChar(K k10, char c10);

    Character getChar(K k10);

    char getCharAndRemove(K k10, char c10);

    Character getCharAndRemove(K k10);

    double getDouble(K k10, double d10);

    Double getDouble(K k10);

    double getDoubleAndRemove(K k10, double d10);

    Double getDoubleAndRemove(K k10);

    float getFloat(K k10, float f10);

    Float getFloat(K k10);

    float getFloatAndRemove(K k10, float f10);

    Float getFloatAndRemove(K k10);

    int getInt(K k10, int i10);

    Integer getInt(K k10);

    int getIntAndRemove(K k10, int i10);

    Integer getIntAndRemove(K k10);

    long getLong(K k10, long j10);

    Long getLong(K k10);

    long getLongAndRemove(K k10, long j10);

    Long getLongAndRemove(K k10);

    Short getShort(K k10);

    short getShort(K k10, short s10);

    Short getShortAndRemove(K k10);

    short getShortAndRemove(K k10, short s10);

    long getTimeMillis(K k10, long j10);

    Long getTimeMillis(K k10);

    long getTimeMillisAndRemove(K k10, long j10);

    Long getTimeMillisAndRemove(K k10);

    boolean isEmpty();

    @Override // java.lang.Iterable
    Iterator<Map.Entry<K, V>> iterator();

    Set<K> names();

    boolean remove(K k10);

    T set(Headers<? extends K, ? extends V, ?> headers);

    T set(K k10, Iterable<? extends V> iterable);

    T set(K k10, V v10);

    T set(K k10, V... vArr);

    T setAll(Headers<? extends K, ? extends V, ?> headers);

    T setBoolean(K k10, boolean z10);

    T setByte(K k10, byte b10);

    T setChar(K k10, char c10);

    T setDouble(K k10, double d10);

    T setFloat(K k10, float f10);

    T setInt(K k10, int i10);

    T setLong(K k10, long j10);

    T setObject(K k10, Iterable<?> iterable);

    T setObject(K k10, Object obj);

    T setObject(K k10, Object... objArr);

    T setShort(K k10, short s10);

    T setTimeMillis(K k10, long j10);

    int size();
}
