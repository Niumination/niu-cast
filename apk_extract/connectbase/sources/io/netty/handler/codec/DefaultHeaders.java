package io.netty.handler.codec;

import em.a;
import fl.h;
import io.netty.handler.codec.Headers;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HASH_CODE_SEED = -1028477387;
    private final HeaderEntry<K, V>[] entries;
    private final byte hashMask;
    private final HashingStrategy<K> hashingStrategy;
    protected final HeaderEntry<K, V> head;
    private final NameValidator<K> nameValidator;
    int size;
    private final ValueConverter<V> valueConverter;
    private final ValueValidator<V> valueValidator;

    public final class HeaderIterator implements Iterator<Map.Entry<K, V>> {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current.after != DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HeaderEntry<K, V> headerEntry = this.current.after;
            this.current = headerEntry;
            if (headerEntry != DefaultHeaders.this.head) {
                return headerEntry;
            }
            throw new NoSuchElementException();
        }
    }

    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
            public void validateName(Object obj) {
                ObjectUtil.checkNotNull(obj, "name");
            }
        };

        void validateName(K k10);
    }

    public final class ValueIterator implements Iterator<V> {
        private final int hash;
        private final K name;
        private HeaderEntry<K, V> next;
        private HeaderEntry<K, V> previous;
        private HeaderEntry<K, V> removalPrevious;

        public ValueIterator(K k10) {
            this.name = (K) ObjectUtil.checkNotNull(k10, "name");
            int iHashCode = DefaultHeaders.this.hashingStrategy.hashCode(k10);
            this.hash = iHashCode;
            calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(iHashCode)]);
        }

        private void calculateNext(HeaderEntry<K, V> headerEntry) {
            while (headerEntry != null) {
                if (headerEntry.hash == this.hash && DefaultHeaders.this.hashingStrategy.equals(this.name, headerEntry.key)) {
                    this.next = headerEntry;
                    return;
                }
                headerEntry = headerEntry.next;
            }
            this.next = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            HeaderEntry<K, V> headerEntry = this.previous;
            if (headerEntry != null) {
                this.removalPrevious = headerEntry;
            }
            HeaderEntry<K, V> headerEntry2 = this.next;
            this.previous = headerEntry2;
            calculateNext(headerEntry2.next);
            return this.previous.value;
        }

        @Override // java.util.Iterator
        public void remove() {
            HeaderEntry<K, V> headerEntry = this.previous;
            if (headerEntry == null) {
                throw new IllegalStateException();
            }
            this.removalPrevious = DefaultHeaders.this.remove0(headerEntry, this.removalPrevious);
            this.previous = null;
        }
    }

    public interface ValueValidator<V> {
        public static final ValueValidator<?> NO_VALIDATION = new ValueValidator<Object>() { // from class: io.netty.handler.codec.DefaultHeaders.ValueValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.ValueValidator
            public void validate(Object obj) {
            }
        };

        void validate(V v10);
    }

    public DefaultHeaders(ValueConverter<V> valueConverter) {
        this(HashingStrategy.JAVA_HASHER, valueConverter);
    }

    private void add0(int i10, int i11, K k10, V v10) {
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        headerEntryArr[i11] = newHeaderEntry(i10, k10, v10, headerEntryArr[i11]);
        this.size++;
    }

    private V fromBoolean(K k10, boolean z10) {
        try {
            return this.valueConverter.convertBoolean(z10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert boolean value for header '", k10, '\''), e10);
        }
    }

    private V fromByte(K k10, byte b10) {
        try {
            return this.valueConverter.convertByte(b10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert byte value for header '", k10, '\''), e10);
        }
    }

    private V fromChar(K k10, char c10) {
        try {
            return this.valueConverter.convertChar(c10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert char value for header '", k10, '\''), e10);
        }
    }

    private V fromDouble(K k10, double d10) {
        try {
            return this.valueConverter.convertDouble(d10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert double value for header '", k10, '\''), e10);
        }
    }

    private V fromFloat(K k10, float f10) {
        try {
            return this.valueConverter.convertFloat(f10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert float value for header '", k10, '\''), e10);
        }
    }

    private V fromInt(K k10, int i10) {
        try {
            return this.valueConverter.convertInt(i10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert int value for header '", k10, '\''), e10);
        }
    }

    private V fromLong(K k10, long j10) {
        try {
            return this.valueConverter.convertLong(j10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert long value for header '", k10, '\''), e10);
        }
    }

    private V fromObject(K k10, Object obj) {
        try {
            return this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, "value"));
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert object value for header '", k10, '\''), e10);
        }
    }

    private V fromShort(K k10, short s10) {
        try {
            return this.valueConverter.convertShort(s10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert short value for header '", k10, '\''), e10);
        }
    }

    private V fromTimeMillis(K k10, long j10) {
        try {
            return this.valueConverter.convertTimeMillis(j10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(a.a("Failed to convert millsecond value for header '", k10, '\''), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int index(int i10) {
        return this.hashMask & i10;
    }

    private V remove0(int i10, int i11, K k10) {
        HeaderEntry<K, V> headerEntry = this.entries[i11];
        V v10 = null;
        if (headerEntry == null) {
            return null;
        }
        for (HeaderEntry<K, V> headerEntry2 = headerEntry.next; headerEntry2 != null; headerEntry2 = headerEntry.next) {
            if (headerEntry2.hash == i10 && this.hashingStrategy.equals(k10, headerEntry2.key)) {
                v10 = headerEntry2.value;
                headerEntry.next = headerEntry2.next;
                headerEntry2.remove();
                this.size--;
            } else {
                headerEntry = headerEntry2;
            }
        }
        HeaderEntry<K, V> headerEntry3 = this.entries[i11];
        if (headerEntry3.hash == i10 && this.hashingStrategy.equals(k10, headerEntry3.key)) {
            if (v10 == null) {
                v10 = headerEntry3.value;
            }
            this.entries[i11] = headerEntry3.next;
            headerEntry3.remove();
            this.size--;
        }
        return v10;
    }

    private T thisT() {
        return this;
    }

    private boolean toBoolean(K k10, V v10) {
        try {
            return this.valueConverter.convertToBoolean(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to boolean for header '", k10, '\''));
        }
    }

    private byte toByte(K k10, V v10) {
        try {
            return this.valueConverter.convertToByte(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to byte for header '", k10, '\''));
        }
    }

    private char toChar(K k10, V v10) {
        try {
            return this.valueConverter.convertToChar(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to char for header '", k10, '\''));
        }
    }

    private double toDouble(K k10, V v10) {
        try {
            return this.valueConverter.convertToDouble(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to double for header '", k10, '\''));
        }
    }

    private float toFloat(K k10, V v10) {
        try {
            return this.valueConverter.convertToFloat(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to float for header '", k10, '\''));
        }
    }

    private int toInt(K k10, V v10) {
        try {
            return this.valueConverter.convertToInt(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to int for header '", k10, '\''));
        }
    }

    private long toLong(K k10, V v10) {
        try {
            return this.valueConverter.convertToLong(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to long for header '", k10, '\''));
        }
    }

    private short toShort(K k10, V v10) {
        try {
            return this.valueConverter.convertToShort(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to short for header '", k10, '\''));
        }
    }

    private long toTimeMillis(K k10, V v10) {
        try {
            return this.valueConverter.convertToTimeMillis(v10);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("Failed to convert header value to millsecond for header '", k10, '\''));
        }
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, V v10) {
        validateName(this.nameValidator, true, k10);
        validateValue(this.valueValidator, k10, v10);
        ObjectUtil.checkNotNull(v10, "value");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        add0(iHashCode, index(iHashCode), k10, v10);
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addBoolean(K k10, boolean z10) {
        return (T) add(k10, fromBoolean(k10, z10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addByte(K k10, byte b10) {
        return (T) add(k10, fromByte(k10, b10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addChar(K k10, char c10) {
        return (T) add(k10, fromChar(k10, c10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addDouble(K k10, double d10) {
        return (T) add(k10, fromDouble(k10, d10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addFloat(K k10, float f10) {
        return (T) add(k10, fromFloat(k10, f10));
    }

    public void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (!(headers instanceof DefaultHeaders)) {
            for (Map.Entry<? extends K, ? extends V> entry : headers) {
                add(entry.getKey(), entry.getValue());
            }
            return;
        }
        DefaultHeaders defaultHeaders = (DefaultHeaders) headers;
        HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
        if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
            while (headerEntry != defaultHeaders.head) {
                int i10 = headerEntry.hash;
                add0(i10, index(i10), headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
        } else {
            while (headerEntry != defaultHeaders.head) {
                add(headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
        }
    }

    @Override // io.netty.handler.codec.Headers
    public T addInt(K k10, int i10) {
        return (T) add(k10, fromInt(k10, i10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addLong(K k10, long j10) {
        return (T) add(k10, fromLong(k10, j10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Object obj) {
        return (T) add(k10, fromObject(k10, obj));
    }

    @Override // io.netty.handler.codec.Headers
    public T addShort(K k10, short s10) {
        return (T) add(k10, fromShort(k10, s10));
    }

    @Override // io.netty.handler.codec.Headers
    public T addTimeMillis(K k10, long j10) {
        return (T) add(k10, fromTimeMillis(k10, j10));
    }

    @Override // io.netty.handler.codec.Headers
    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k10) {
        return get(k10) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(K k10, boolean z10) {
        return contains(k10, fromBoolean(k10, z10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(K k10, byte b10) {
        return contains(k10, fromByte(k10, b10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(K k10, char c10) {
        return contains(k10, fromChar(k10, c10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(K k10, double d10) {
        return contains(k10, fromDouble(k10, d10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(K k10, float f10) {
        return contains(k10, fromFloat(k10, f10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(K k10, int i10) {
        return contains(k10, fromInt(k10, i10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(K k10, long j10) {
        return contains(k10, fromLong(k10, j10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(K k10, Object obj) {
        return contains(k10, fromObject(k10, obj));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(K k10, short s10) {
        return contains(k10, fromShort(k10, s10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K k10, long j10) {
        return contains(k10, fromTimeMillis(k10, j10));
    }

    public DefaultHeaders<K, V, T> copy() {
        DefaultHeaders<K, V, T> defaultHeaders = new DefaultHeaders<>(this.hashingStrategy, this.valueConverter, this.nameValidator, this.entries.length);
        defaultHeaders.addImpl(this);
        return defaultHeaders;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return equals((Headers) obj, HashingStrategy.JAVA_HASHER);
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k10) {
        ObjectUtil.checkNotNull(k10, "name");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        V v10 = null;
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key)) {
                v10 = headerEntry.value;
            }
        }
        return v10;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k10) {
        ObjectUtil.checkNotNull(k10, "name");
        LinkedList linkedList = new LinkedList();
        int iHashCode = this.hashingStrategy.hashCode(k10);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key)) {
                linkedList.addFirst(headerEntry.getValue());
            }
        }
        return linkedList;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K k10) {
        List<V> all = getAll(k10);
        remove(k10);
        return all;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k10) {
        int iHashCode = this.hashingStrategy.hashCode(k10);
        return (V) remove0(iHashCode, index(iHashCode), ObjectUtil.checkNotNull(k10, "name"));
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Boolean.valueOf(toBoolean(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Boolean.valueOf(toBoolean(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Byte.valueOf(toByte(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Byte.valueOf(toByte(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Character.valueOf(toChar(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Character.valueOf(toChar(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Double.valueOf(toDouble(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Double.valueOf(toDouble(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Float.valueOf(toFloat(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Float.valueOf(toFloat(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Integer.valueOf(toInt(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Integer.valueOf(toInt(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Long.valueOf(toLong(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Long.valueOf(toLong(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Short.valueOf(toShort(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Short.valueOf(toShort(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(K k10) {
        V v10 = get(k10);
        if (v10 == null) {
            return null;
        }
        try {
            return Long.valueOf(toTimeMillis(k10, v10));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K k10) {
        V andRemove = getAndRemove(k10);
        if (andRemove == null) {
            return null;
        }
        try {
            return Long.valueOf(toTimeMillis(k10, andRemove));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        HeaderEntry<K, V> headerEntry = this.head;
        return headerEntry == headerEntry.after;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator();
    }

    public NameValidator<K> nameValidator() {
        return this.nameValidator;
    }

    @Override // io.netty.handler.codec.Headers
    public Set<K> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (HeaderEntry<K, V> headerEntry = this.head.after; headerEntry != this.head; headerEntry = headerEntry.after) {
            linkedHashSet.add(headerEntry.getKey());
        }
        return linkedHashSet;
    }

    public HeaderEntry<K, V> newHeaderEntry(int i10, K k10, V v10, HeaderEntry<K, V> headerEntry) {
        return new HeaderEntry<>(i10, k10, v10, headerEntry, this.head);
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(K k10) {
        return getAndRemove(k10) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, V v10) {
        validateName(this.nameValidator, false, k10);
        validateValue(this.valueValidator, k10, v10);
        ObjectUtil.checkNotNull(v10, "value");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        add0(iHashCode, iIndex, k10, v10);
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            Iterator<? extends K> it = headers.names().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            addImpl(headers);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setBoolean(K k10, boolean z10) {
        return (T) set(k10, fromBoolean(k10, z10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setByte(K k10, byte b10) {
        return (T) set(k10, fromByte(k10, b10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setChar(K k10, char c10) {
        return (T) set(k10, fromChar(k10, c10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setDouble(K k10, double d10) {
        return (T) set(k10, fromDouble(k10, d10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setFloat(K k10, float f10) {
        return (T) set(k10, fromFloat(k10, f10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setInt(K k10, int i10) {
        return (T) set(k10, fromInt(k10, i10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setLong(K k10, long j10) {
        return (T) set(k10, fromLong(k10, j10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Object obj) {
        return (T) set(k10, ObjectUtil.checkNotNull(fromObject(k10, obj), "convertedValue"));
    }

    @Override // io.netty.handler.codec.Headers
    public T setShort(K k10, short s10) {
        return (T) set(k10, fromShort(k10, s10));
    }

    @Override // io.netty.handler.codec.Headers
    public T setTimeMillis(K k10, long j10) {
        return (T) set(k10, fromTimeMillis(k10, j10));
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    public String toString() {
        return HeadersUtils.toString(getClass(), iterator(), size());
    }

    public void validateName(NameValidator<K> nameValidator, boolean z10, K k10) {
        nameValidator.validateName(k10);
    }

    public void validateValue(ValueValidator<V> valueValidator, K k10, V v10) {
        try {
            valueValidator.validate(v10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Validation failed for header '" + k10 + "'", e10);
        }
    }

    public ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    public Iterator<V> valueIterator(K k10) {
        return new ValueIterator(k10);
    }

    public ValueValidator<V> valueValidator() {
        return this.valueValidator;
    }

    public DefaultHeaders(ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(HashingStrategy.JAVA_HASHER, valueConverter, nameValidator);
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            addObject(k10, it.next());
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k10, V v10) {
        return contains(k10, v10, HashingStrategy.JAVA_HASHER);
    }

    public final int hashCode(HashingStrategy<V> hashingStrategy) {
        int i10 = HASH_CODE_SEED;
        for (K k10 : names()) {
            int iHashCode = this.hashingStrategy.hashCode(k10) + (i10 * 31);
            List<V> all = getAll(k10);
            for (int i11 = 0; i11 < all.size(); i11++) {
                iHashCode = (iHashCode * 31) + hashingStrategy.hashCode(all.get(i11));
            }
            i10 = iHashCode;
        }
        return i10;
    }

    public static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected HeaderEntry<K, V> after;
        protected HeaderEntry<K, V> before;
        protected final int hash;
        protected final K key;
        protected HeaderEntry<K, V> next;
        protected V value;

        public HeaderEntry(int i10, K k10) {
            this.hash = i10;
            this.key = k10;
        }

        public final HeaderEntry<K, V> after() {
            return this.after;
        }

        public final HeaderEntry<K, V> before() {
            return this.before;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.value;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        public final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        public void remove() {
            HeaderEntry<K, V> headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v10) {
            ObjectUtil.checkNotNull(v10, "value");
            V v11 = this.value;
            this.value = v10;
            return v11;
        }

        public final String toString() {
            return this.key.toString() + h.f6043c + this.value.toString();
        }

        public HeaderEntry(int i10, K k10, V v10, HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
            this.hash = i10;
            this.key = k10;
            this.value = v10;
            this.next = headerEntry;
            this.after = headerEntry2;
            this.before = headerEntry2.before;
            pointNeighborsToThis();
        }

        public HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter) {
        this(hashingStrategy, valueConverter, NameValidator.NOT_NULL);
    }

    public final boolean contains(K k10, V v10, HashingStrategy<? super V> hashingStrategy) {
        ObjectUtil.checkNotNull(k10, "name");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key) && hashingStrategy.equals(v10, headerEntry.value)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Headers<K, V, ?> headers, HashingStrategy<V> hashingStrategy) {
        if (headers.size() != size()) {
            return false;
        }
        if (this == headers) {
            return true;
        }
        for (K k10 : names()) {
            List<V> all = headers.getAll(k10);
            List<V> all2 = getAll(k10);
            if (all.size() != all2.size()) {
                return false;
            }
            for (int i10 = 0; i10 < all.size(); i10++) {
                if (!hashingStrategy.equals(all.get(i10), all2.get(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k10, V v10) {
        V andRemove = getAndRemove(k10);
        return andRemove == null ? v10 : andRemove;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(K k10, boolean z10) {
        Boolean bool = getBoolean(k10);
        return bool != null ? bool.booleanValue() : z10;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K k10, boolean z10) {
        Boolean booleanAndRemove = getBooleanAndRemove(k10);
        return booleanAndRemove != null ? booleanAndRemove.booleanValue() : z10;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(K k10, byte b10) {
        Byte b11 = getByte(k10);
        return b11 != null ? b11.byteValue() : b10;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(K k10, byte b10) {
        Byte byteAndRemove = getByteAndRemove(k10);
        return byteAndRemove != null ? byteAndRemove.byteValue() : b10;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(K k10, char c10) {
        Character ch2 = getChar(k10);
        return ch2 != null ? ch2.charValue() : c10;
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(K k10, char c10) {
        Character charAndRemove = getCharAndRemove(k10);
        return charAndRemove != null ? charAndRemove.charValue() : c10;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(K k10, double d10) {
        Double d11 = getDouble(k10);
        return d11 != null ? d11.doubleValue() : d10;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K k10, double d10) {
        Double doubleAndRemove = getDoubleAndRemove(k10);
        return doubleAndRemove != null ? doubleAndRemove.doubleValue() : d10;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(K k10, float f10) {
        Float f11 = getFloat(k10);
        return f11 != null ? f11.floatValue() : f10;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(K k10, float f10) {
        Float floatAndRemove = getFloatAndRemove(k10);
        return floatAndRemove != null ? floatAndRemove.floatValue() : f10;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(K k10, int i10) {
        Integer num = getInt(k10);
        return num != null ? num.intValue() : i10;
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(K k10, int i10) {
        Integer intAndRemove = getIntAndRemove(k10);
        return intAndRemove != null ? intAndRemove.intValue() : i10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(K k10, long j10) {
        Long l10 = getLong(k10);
        return l10 != null ? l10.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(K k10, long j10) {
        Long longAndRemove = getLongAndRemove(k10);
        return longAndRemove != null ? longAndRemove.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(K k10, short s10) {
        Short sh2 = getShort(k10);
        return sh2 != null ? sh2.shortValue() : s10;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(K k10, short s10) {
        Short shortAndRemove = getShortAndRemove(k10);
        return shortAndRemove != null ? shortAndRemove.shortValue() : s10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(K k10, long j10) {
        Long timeMillis = getTimeMillis(k10);
        return timeMillis != null ? timeMillis.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K k10, long j10) {
        Long timeMillisAndRemove = getTimeMillisAndRemove(k10);
        return timeMillisAndRemove != null ? timeMillisAndRemove.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Iterable<?> iterable) {
        Object next;
        validateName(this.nameValidator, false, k10);
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        Iterator<?> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            V vFromObject = fromObject(k10, next);
            validateValue(this.valueValidator, k10, vFromObject);
            add0(iHashCode, iIndex, k10, vFromObject);
        }
        return (T) thisT();
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(hashingStrategy, valueConverter, nameValidator, 16);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i10) {
        this(hashingStrategy, valueConverter, nameValidator, i10, ValueValidator.NO_VALIDATION);
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k10, Object... objArr) {
        for (Object obj : objArr) {
            addObject(k10, obj);
        }
        return (T) thisT();
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i10, ValueValidator<V> valueValidator) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(hashingStrategy, "nameHashingStrategy");
        this.valueValidator = (ValueValidator) ObjectUtil.checkNotNull(valueValidator, "valueValidator");
        HeaderEntry<K, V>[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i10, 128)))];
        this.entries = headerEntryArr;
        this.hashMask = (byte) (headerEntryArr.length - 1);
        this.head = new HeaderEntry<>();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, Iterable<? extends V> iterable) {
        validateName(this.nameValidator, true, k10);
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        for (V v10 : iterable) {
            validateValue(this.valueValidator, k10, v10);
            add0(iHashCode, iIndex, k10, v10);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? v10 : v11;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, Iterable<? extends V> iterable) {
        V next;
        validateName(this.nameValidator, false, k10);
        ObjectUtil.checkNotNull(iterable, "values");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            validateValue(this.valueValidator, k10, next);
            add0(iHashCode, iIndex, k10, next);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k10, Object... objArr) {
        validateName(this.nameValidator, false, k10);
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        for (Object obj : objArr) {
            if (obj == null) {
                break;
            }
            V vFromObject = fromObject(k10, obj);
            validateValue(this.valueValidator, k10, vFromObject);
            add0(iHashCode, iIndex, k10, vFromObject);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k10, V... vArr) {
        validateName(this.nameValidator, true, k10);
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        for (V v10 : vArr) {
            validateValue(this.valueValidator, k10, v10);
            add0(iHashCode, iIndex, k10, v10);
        }
        return (T) thisT();
    }

    public HeaderEntry<K, V> remove0(HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
        int iIndex = index(headerEntry.hash);
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        HeaderEntry<K, V> headerEntry3 = headerEntryArr[iIndex];
        if (headerEntry3 == headerEntry) {
            headerEntry2 = headerEntry.next;
            headerEntryArr[iIndex] = headerEntry2;
        } else if (headerEntry2 == null) {
            for (HeaderEntry<K, V> headerEntry4 = headerEntry3.next; headerEntry4 != null && headerEntry4 != headerEntry; headerEntry4 = headerEntry4.next) {
                headerEntry3 = headerEntry4;
            }
            headerEntry3.next = headerEntry.next;
            headerEntry2 = headerEntry3;
        } else {
            headerEntry2.next = headerEntry.next;
        }
        headerEntry.remove();
        this.size--;
        return headerEntry2;
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k10, V... vArr) {
        validateName(this.nameValidator, false, k10);
        ObjectUtil.checkNotNull(vArr, "values");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        for (V v10 : vArr) {
            if (v10 == null) {
                break;
            }
            validateValue(this.valueValidator, k10, v10);
            add0(iHashCode, iIndex, k10, v10);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            addImpl(headers);
            return (T) thisT();
        }
        throw new IllegalArgumentException("can't add to itself.");
    }

    @Override // io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return (T) thisT();
    }
}
