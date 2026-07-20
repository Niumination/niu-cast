package io.netty.handler.codec.http;

import fl.h;
import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.util.AsciiString;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ReadOnlyHttpHeaders extends HttpHeaders {
    private final CharSequence[] nameValuePairs;

    public final class ReadOnlyIterator implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {
        private CharSequence key;
        private int nextNameIndex;
        private CharSequence value;

        private ReadOnlyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length;
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
            this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex];
            CharSequence[] charSequenceArr = ReadOnlyHttpHeaders.this.nameValuePairs;
            int i10 = this.nextNameIndex;
            this.value = charSequenceArr[i10 + 1];
            this.nextNameIndex = i10 + 2;
            return this;
        }

        @Override // java.util.Map.Entry
        public CharSequence setValue(CharSequence charSequence) {
            throw new UnsupportedOperationException("read only");
        }
    }

    public final class ReadOnlyStringIterator implements Map.Entry<String, String>, Iterator<Map.Entry<String, String>> {
        private String key;
        private int nextNameIndex;
        private String value;

        private ReadOnlyStringIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return this.key + h.f6043c + this.value;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            return this.value;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex].toString();
            this.value = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1].toString();
            this.nextNameIndex += 2;
            return this;
        }

        @Override // java.util.Map.Entry
        public String setValue(String str) {
            throw new UnsupportedOperationException("read only");
        }
    }

    public final class ReadOnlyStringValueIterator implements Iterator<String> {
        private final CharSequence name;
        private final int nameHash;
        private int nextNameIndex = findNextValue();

        public ReadOnlyStringValueIterator(CharSequence charSequence) {
            this.name = charSequence;
            this.nameHash = AsciiString.hashCode(charSequence);
        }

        private int findNextValue() {
            for (int i10 = this.nextNameIndex; i10 < ReadOnlyHttpHeaders.this.nameValuePairs.length; i10 += 2) {
                CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i10];
                if (this.nameHash == AsciiString.hashCode(charSequence) && AsciiString.contentEqualsIgnoreCase(this.name, charSequence)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != -1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String string = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1].toString();
            this.nextNameIndex = findNextValue();
            return string;
        }
    }

    public final class ReadOnlyValueIterator implements Iterator<CharSequence> {
        private final CharSequence name;
        private final int nameHash;
        private int nextNameIndex = findNextValue();

        public ReadOnlyValueIterator(CharSequence charSequence) {
            this.name = charSequence;
            this.nameHash = AsciiString.hashCode(charSequence);
        }

        private int findNextValue() {
            for (int i10 = this.nextNameIndex; i10 < ReadOnlyHttpHeaders.this.nameValuePairs.length; i10 += 2) {
                CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i10];
                if (this.nameHash == AsciiString.hashCode(charSequence) && AsciiString.contentEqualsIgnoreCase(this.name, charSequence)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != -1;
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
            CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1];
            this.nextNameIndex = findNextValue();
            return charSequence;
        }
    }

    public ReadOnlyHttpHeaders(boolean z10, CharSequence... charSequenceArr) {
        if ((charSequenceArr.length & 1) != 0) {
            throw newInvalidArraySizeException();
        }
        if (z10) {
            validateHeaders(charSequenceArr);
        }
        this.nameValuePairs = charSequenceArr;
    }

    private CharSequence get0(CharSequence charSequence) {
        int iHashCode = AsciiString.hashCode(charSequence);
        int i10 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i10 >= charSequenceArr.length) {
                return null;
            }
            CharSequence charSequence2 = charSequenceArr[i10];
            if (AsciiString.hashCode(charSequence2) == iHashCode && AsciiString.contentEqualsIgnoreCase(charSequence2, charSequence)) {
                return this.nameValuePairs[i10 + 1];
            }
            i10 += 2;
        }
    }

    private static IllegalArgumentException newInvalidArraySizeException() {
        return new IllegalArgumentException("nameValuePairs must be arrays of [name, value] pairs");
    }

    private static void validateHeaders(CharSequence... charSequenceArr) {
        for (int i10 = 0; i10 < charSequenceArr.length; i10 += 2) {
            DefaultHttpHeaders.HttpNameValidator.validateName(charSequenceArr[i10]);
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addInt(CharSequence charSequence, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addShort(CharSequence charSequence, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders clear() {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str) {
        return get0(str) != null;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (z10) {
            int i10 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.nameValuePairs;
                if (i10 >= charSequenceArr.length) {
                    break;
                }
                if (AsciiString.contentEqualsIgnoreCase(charSequenceArr[i10], charSequence) && AsciiString.contentEqualsIgnoreCase(this.nameValuePairs[i10 + 1], charSequence2)) {
                    return true;
                }
                i10 += 2;
            }
        } else {
            int i11 = 0;
            while (true) {
                CharSequence[] charSequenceArr2 = this.nameValuePairs;
                if (i11 < charSequenceArr2.length) {
                    if (AsciiString.contentEqualsIgnoreCase(charSequenceArr2[i11], charSequence) && AsciiString.contentEquals(this.nameValuePairs[i11 + 1], charSequence2)) {
                        return true;
                    }
                    i11 += 2;
                }
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(size());
        for (int i10 = 0; i10 < this.nameValuePairs.length; i10 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(this.nameValuePairs[i10].toString(), this.nameValuePairs[i10 + 1].toString()));
        }
        return arrayList;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(String str) {
        CharSequence charSequence = get0(str);
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(String str) {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        int iHashCode = AsciiString.hashCode(str);
        ArrayList arrayList = new ArrayList(4);
        int i10 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i10 >= charSequenceArr.length) {
                return arrayList;
            }
            CharSequence charSequence = charSequenceArr[i10];
            if (AsciiString.hashCode(charSequence) == iHashCode && AsciiString.contentEqualsIgnoreCase(charSequence, str)) {
                arrayList.add(this.nameValuePairs[i10 + 1].toString());
            }
            i10 += 2;
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Integer getInt(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Short getShort(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Long getTimeMillis(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean isEmpty() {
        return this.nameValuePairs.length == 0;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders, java.lang.Iterable
    public Iterator<Map.Entry<String, String>> iterator() {
        return new ReadOnlyStringIterator();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return new ReadOnlyIterator();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Set<String> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        int i10 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i10 >= charSequenceArr.length) {
                return linkedHashSet;
            }
            linkedHashSet.add(charSequenceArr[i10].toString());
            i10 += 2;
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(String str) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setInt(CharSequence charSequence, int i10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setShort(CharSequence charSequence, short s10) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int size() {
        return this.nameValuePairs.length >>> 1;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return new ReadOnlyValueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        return new ReadOnlyStringValueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str, String str2, boolean z10) {
        return containsValue(str, str2, z10);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int getInt(CharSequence charSequence, int i10) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? i10 : CharSequenceValueConverter.INSTANCE.convertToInt(charSequence2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public short getShort(CharSequence charSequence, short s10) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? s10 : CharSequenceValueConverter.INSTANCE.convertToShort(charSequence2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public long getTimeMillis(CharSequence charSequence, long j10) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? j10 : CharSequenceValueConverter.INSTANCE.convertToTimeMillis(charSequence2);
    }
}
