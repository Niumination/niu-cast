package io.netty.handler.codec.http2;

import fl.h;
import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public final class ReadOnlyHttp2Headers implements Http2Headers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte PSEUDO_HEADER_TOKEN = 58;
    private final AsciiString[] otherHeaders;
    private final AsciiString[] pseudoHeaders;

    public final class ReadOnlyIterator implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {
        private AsciiString[] current;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f8319i;
        private AsciiString key;
        private AsciiString value;

        private ReadOnlyIterator() {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8319i != this.current.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return this.key.toString() + h.f6043c + this.value.toString();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public CharSequence getKey() {
            return this.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public CharSequence getValue() {
            return this.value;
        }

        @Override // java.util.Iterator
        public Map.Entry<CharSequence, CharSequence> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AsciiString[] asciiStringArr = this.current;
            int i10 = this.f8319i;
            this.key = asciiStringArr[i10];
            this.value = asciiStringArr[i10 + 1];
            int i11 = i10 + 2;
            this.f8319i = i11;
            if (i11 == asciiStringArr.length && asciiStringArr == ReadOnlyHttp2Headers.this.pseudoHeaders) {
                this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                this.f8319i = 0;
            }
            return this;
        }

        @Override // java.util.Map.Entry
        public CharSequence setValue(CharSequence charSequence) {
            throw new UnsupportedOperationException("read only");
        }
    }

    public final class ReadOnlyValueIterator implements Iterator<CharSequence> {
        private AsciiString[] current;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f8320i;
        private final CharSequence name;
        private final int nameHash;
        private AsciiString next;

        public ReadOnlyValueIterator(CharSequence charSequence) {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
            this.nameHash = AsciiString.hashCode(charSequence);
            this.name = charSequence;
            calculateNext();
        }

        private void calculateNext() {
            while (true) {
                int i10 = this.f8320i;
                AsciiString[] asciiStringArr = this.current;
                if (i10 >= asciiStringArr.length) {
                    if (asciiStringArr != ReadOnlyHttp2Headers.this.pseudoHeaders) {
                        this.next = null;
                        return;
                    }
                    this.f8320i = 0;
                    this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                    calculateNext();
                    return;
                }
                AsciiString asciiString = asciiStringArr[i10];
                if (asciiString.hashCode() == this.nameHash && asciiString.contentEqualsIgnoreCase(this.name)) {
                    int i11 = this.f8320i;
                    int i12 = i11 + 1;
                    AsciiString[] asciiStringArr2 = this.current;
                    if (i12 < asciiStringArr2.length) {
                        this.next = asciiStringArr2[i11 + 1];
                        this.f8320i = i11 + 2;
                        return;
                    }
                    return;
                }
                this.f8320i += 2;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CharSequence next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AsciiString asciiString = this.next;
            calculateNext();
            return asciiString;
        }
    }

    private ReadOnlyHttp2Headers(boolean z10, AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        if ((asciiStringArr2.length & 1) != 0) {
            throw newInvalidArraySizeException();
        }
        if (z10) {
            validateHeaders(asciiStringArr, asciiStringArr2);
        }
        this.pseudoHeaders = asciiStringArr;
        this.otherHeaders = asciiStringArr2;
    }

    public static ReadOnlyHttp2Headers clientHeaders(boolean z10, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, AsciiString asciiString4, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z10, new AsciiString[]{Http2Headers.PseudoHeaderName.METHOD.value(), asciiString, Http2Headers.PseudoHeaderName.PATH.value(), asciiString2, Http2Headers.PseudoHeaderName.SCHEME.value(), asciiString3, Http2Headers.PseudoHeaderName.AUTHORITY.value(), asciiString4}, asciiStringArr);
    }

    private AsciiString get0(CharSequence charSequence) {
        int iHashCode = AsciiString.hashCode(charSequence);
        int length = this.pseudoHeaders.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            AsciiString asciiString = this.pseudoHeaders[i10];
            if (asciiString.hashCode() == iHashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                return this.pseudoHeaders[i10 + 1];
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i11 = 0; i11 < length2; i11 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i11];
            if (asciiString2.hashCode() == iHashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                return this.otherHeaders[i11 + 1];
            }
        }
        return null;
    }

    private static IllegalArgumentException newInvalidArraySizeException() {
        return new IllegalArgumentException("pseudoHeaders and otherHeaders must be arrays of [name, value] pairs");
    }

    public static ReadOnlyHttp2Headers serverHeaders(boolean z10, AsciiString asciiString, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z10, new AsciiString[]{Http2Headers.PseudoHeaderName.STATUS.value(), asciiString}, asciiStringArr);
    }

    public static ReadOnlyHttp2Headers trailers(boolean z10, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z10, EmptyArrays.EMPTY_ASCII_STRINGS, asciiStringArr);
    }

    private static void validateHeaders(AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        for (int i10 = 1; i10 < asciiStringArr.length; i10 += 2) {
            ObjectUtil.checkNotNullArrayParam(asciiStringArr[i10], i10, "pseudoHeaders");
        }
        int length = asciiStringArr2.length - 1;
        boolean z10 = false;
        for (int i11 = 0; i11 < length; i11 += 2) {
            AsciiString asciiString = asciiStringArr2[i11];
            DefaultHttp2Headers.HTTP2_NAME_VALIDATOR.validateName(asciiString);
            if (z10 || asciiString.isEmpty() || asciiString.byteAt(0) == 58) {
                if (z10 && !asciiString.isEmpty() && asciiString.byteAt(0) == 58) {
                    throw new IllegalArgumentException(b.a("otherHeaders name at index ", i11, " is a pseudo header that appears after non-pseudo headers."));
                }
            } else {
                z10 = true;
            }
            int i12 = i11 + 1;
            ObjectUtil.checkNotNullArrayParam(asciiStringArr2[i12], i12, "otherHeaders");
        }
    }

    @Override // io.netty.handler.codec.Headers
    public /* bridge */ /* synthetic */ Headers addObject(CharSequence charSequence, Iterable iterable) {
        return addObject2(charSequence, (Iterable<?>) iterable);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers authority(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(CharSequence charSequence, float f10) {
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        return this.pseudoHeaders.length == 0 && this.otherHeaders.length == 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers, io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
        return new ReadOnlyIterator();
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers method(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Set<CharSequence> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        int length = this.pseudoHeaders.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            linkedHashSet.add(this.pseudoHeaders[i10]);
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i11 = 0; i11 < length2; i11 += 2) {
            linkedHashSet.add(this.otherHeaders[i11]);
        }
        return linkedHashSet;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers path(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers scheme(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public /* bridge */ /* synthetic */ Headers setObject(CharSequence charSequence, Iterable iterable) {
        return setObject2(charSequence, (Iterable<?>) iterable);
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return (this.pseudoHeaders.length + this.otherHeaders.length) >>> 1;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers status(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ReadOnlyHttp2Headers[");
        String str = "";
        for (Map.Entry<CharSequence, CharSequence> entry : this) {
            sb2.append(str);
            sb2.append(entry.getKey());
            sb2.append(": ");
            sb2.append(entry.getValue());
            str = ", ";
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
        return new ReadOnlyValueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addBoolean(CharSequence charSequence, boolean z10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addByte(CharSequence charSequence, byte b10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addChar(CharSequence charSequence, char c10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addDouble(CharSequence charSequence, double d10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addFloat(CharSequence charSequence, float f10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addInt(CharSequence charSequence, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addLong(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addShort(CharSequence charSequence, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addTimeMillis(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence authority() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.AUTHORITY.value());
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers clear() {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(CharSequence charSequence, boolean z10) {
        return contains(charSequence, (CharSequence) String.valueOf(z10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(CharSequence charSequence, byte b10) {
        return contains(charSequence, (CharSequence) String.valueOf((int) b10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(CharSequence charSequence, char c10) {
        return contains(charSequence, (CharSequence) String.valueOf(c10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(CharSequence charSequence, double d10) {
        return contains(charSequence, (CharSequence) String.valueOf(d10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(CharSequence charSequence, int i10) {
        return contains(charSequence, (CharSequence) String.valueOf(i10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(CharSequence charSequence, long j10) {
        return contains(charSequence, (CharSequence) String.valueOf(j10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(CharSequence charSequence, Object obj) {
        return obj instanceof CharSequence ? contains(charSequence, (CharSequence) obj) : contains(charSequence, (CharSequence) obj.toString());
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(CharSequence charSequence, short s10) {
        return contains(charSequence, (CharSequence) String.valueOf((int) s10));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(CharSequence charSequence, long j10) {
        return contains(charSequence, (CharSequence) String.valueOf(j10));
    }

    @Override // io.netty.handler.codec.Headers
    public List<CharSequence> getAll(CharSequence charSequence) {
        int iHashCode = AsciiString.hashCode(charSequence);
        ArrayList arrayList = new ArrayList();
        int length = this.pseudoHeaders.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            AsciiString asciiString = this.pseudoHeaders[i10];
            if (asciiString.hashCode() == iHashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.pseudoHeaders[i10 + 1]);
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i11 = 0; i11 < length2; i11 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i11];
            if (asciiString2.hashCode() == iHashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.otherHeaders[i11 + 1]);
            }
        }
        return arrayList;
    }

    @Override // io.netty.handler.codec.Headers
    public List<CharSequence> getAllAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence method() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.METHOD.value());
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence path() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.PATH.value());
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence scheme() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.SCHEME.value());
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setBoolean(CharSequence charSequence, boolean z10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setByte(CharSequence charSequence, byte b10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setChar(CharSequence charSequence, char c10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setDouble(CharSequence charSequence, double d10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setFloat(CharSequence charSequence, float f10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setInt(CharSequence charSequence, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setLong(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setShort(CharSequence charSequence, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setTimeMillis(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence status() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.STATUS.value());
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence) {
        return get(charSequence) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence get(CharSequence charSequence) {
        return get0(charSequence);
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence getAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Boolean.valueOf(CharSequenceValueConverter.INSTANCE.convertToBoolean((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Byte.valueOf(CharSequenceValueConverter.INSTANCE.convertToByte((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Character.valueOf(CharSequenceValueConverter.INSTANCE.convertToChar((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Double.valueOf(CharSequenceValueConverter.INSTANCE.convertToDouble((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Float.valueOf(CharSequenceValueConverter.INSTANCE.convertToFloat((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToLong((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence get(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3 = get(charSequence);
        return charSequence3 != null ? charSequence3 : charSequence2;
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence getAndRemove(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(CharSequence charSequence, boolean z10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(CharSequence charSequence, byte b10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(CharSequence charSequence, char c10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(CharSequence charSequence, double d10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(CharSequence charSequence, float f10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(CharSequence charSequence, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(CharSequence charSequence, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(CharSequence charSequence, long j10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    /* JADX INFO: renamed from: addObject, reason: avoid collision after fix types in other method */
    public Http2Headers addObject2(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        int iHashCode = AsciiString.hashCode(charSequence);
        HashingStrategy<CharSequence> hashingStrategy = z10 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER;
        int iHashCode2 = hashingStrategy.hashCode(charSequence2);
        if (!contains(charSequence, iHashCode, charSequence2, iHashCode2, hashingStrategy, this.otherHeaders)) {
            if (!contains(charSequence, iHashCode, charSequence2, iHashCode2, hashingStrategy, this.pseudoHeaders)) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(CharSequence charSequence, boolean z10) {
        Boolean bool = getBoolean(charSequence);
        return bool != null ? bool.booleanValue() : z10;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(CharSequence charSequence, byte b10) {
        Byte b11 = getByte(charSequence);
        return b11 != null ? b11.byteValue() : b10;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(CharSequence charSequence, char c10) {
        Character ch2 = getChar(charSequence);
        return ch2 != null ? ch2.charValue() : c10;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(CharSequence charSequence, double d10) {
        Double d11 = getDouble(charSequence);
        return d11 != null ? d11.doubleValue() : d10;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(CharSequence charSequence, float f10) {
        Float f11 = getFloat(charSequence);
        return f11 != null ? f11.floatValue() : f10;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(CharSequence charSequence, int i10) {
        Integer num = getInt(charSequence);
        return num != null ? num.intValue() : i10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(CharSequence charSequence, long j10) {
        Long l10 = getLong(charSequence);
        return l10 != null ? l10.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(CharSequence charSequence, short s10) {
        Short sh2 = getShort(charSequence);
        return sh2 != null ? sh2.shortValue() : s10;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(CharSequence charSequence, long j10) {
        Long timeMillis = getTimeMillis(charSequence);
        return timeMillis != null ? timeMillis.longValue() : j10;
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    /* JADX INFO: renamed from: setObject, reason: avoid collision after fix types in other method */
    public Http2Headers setObject2(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    private static boolean contains(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, HashingStrategy<CharSequence> hashingStrategy, AsciiString[] asciiStringArr) {
        int length = asciiStringArr.length - 1;
        for (int i12 = 0; i12 < length; i12 += 2) {
            AsciiString asciiString = asciiStringArr[i12];
            AsciiString asciiString2 = asciiStringArr[i12 + 1];
            if (asciiString.hashCode() == i10 && asciiString2.hashCode() == i11 && asciiString.contentEqualsIgnoreCase(charSequence) && hashingStrategy.equals(asciiString2, charSequence2)) {
                return true;
            }
        }
        return false;
    }
}
