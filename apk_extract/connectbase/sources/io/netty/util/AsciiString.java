package io.netty.util;

import c.a;
import h.b;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    public static final int INDEX_NOT_FOUND = -1;
    private static final char MAX_CHAR_VALUE = 255;
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };

    public static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c10, char c11) {
            return AsciiString.equalsIgnoreCase(c10, c11);
        }
    }

    public interface CharEqualityComparator {
        boolean equals(char c10, char c11);
    }

    public static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        private DefaultCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c10, char c11) {
            return c10 == c11;
        }
    }

    public static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c10, char c11) {
            return Character.toUpperCase(c10) == Character.toUpperCase(c11) || Character.toLowerCase(c10) == Character.toLowerCase(c11);
        }
    }

    public AsciiString(byte[] bArr) {
        this(bArr, true);
    }

    public static char b2c(byte b10) {
        return (char) (b10 & 255);
    }

    public static byte c2b(char c10) {
        if (c10 > 255) {
            c10 = '?';
        }
        return (byte) c10;
    }

    private static byte c2b0(char c10) {
        return (byte) c10;
    }

    public static AsciiString cached(String str) {
        AsciiString asciiString = new AsciiString(str);
        asciiString.string = str;
        return asciiString;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> collection, Collection<CharSequence> collection2) {
        Iterator<CharSequence> it = collection2.iterator();
        while (it.hasNext()) {
            if (!containsContentEqualsIgnoreCase(collection, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence charSequence) {
        Iterator<CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            if (contentEqualsIgnoreCase(charSequence, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    private static boolean equalsIgnoreCase(byte b10, byte b11) {
        return b10 == b11 || toLowerCase(b10) == toLowerCase(b11);
    }

    private int forEachByte0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        int i12 = this.offset;
        int i13 = i12 + i10 + i11;
        for (int i14 = i12 + i10; i14 < i13; i14++) {
            if (!byteProcessor.process(this.value[i14])) {
                return i14 - this.offset;
            }
        }
        return -1;
    }

    private int forEachByteDesc0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        int i12 = this.offset;
        int i13 = i12 + i10;
        for (int i14 = ((i12 + i10) + i11) - 1; i14 >= i13; i14--) {
            if (!byteProcessor.process(this.value[i14])) {
                return i14 - this.offset;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence != null && charSequence2 != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i10 > length2) {
                return -1;
            }
            if (length == 0) {
                return i10;
            }
            while (i10 < length2) {
                if (regionMatches(charSequence, true, i10, charSequence2, 0, length)) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence != null && charSequence2 != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i10 > length2) {
                return -1;
            }
            if (length == 0) {
                return i10;
            }
            while (i10 < length2) {
                if (regionMatchesAscii(charSequence, true, i10, charSequence2, 0, length)) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    private static boolean isLowerCase(byte b10) {
        return b10 >= 97 && b10 <= 122;
    }

    public static boolean isUpperCase(byte b10) {
        return b10 >= 65 && b10 <= 90;
    }

    public static AsciiString of(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? (AsciiString) charSequence : new AsciiString(charSequence);
    }

    public static boolean regionMatchesAscii(CharSequence charSequence, boolean z10, int i10, CharSequence charSequence2, int i11, int i12) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(false, i10, (String) charSequence2, i11, i12);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z10, i10, charSequence2, i11, i12);
        }
        return regionMatchesCharSequences(charSequence, i10, charSequence2, i11, i12, z10 ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    private static boolean regionMatchesCharSequences(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, CharEqualityComparator charEqualityComparator) {
        if (i10 < 0 || i12 > charSequence.length() - i10 || i11 < 0 || i12 > charSequence2.length() - i11) {
            return false;
        }
        int i13 = i12 + i10;
        while (i10 < i13) {
            int i14 = i10 + 1;
            int i15 = i11 + 1;
            if (!charEqualityComparator.equals(charSequence.charAt(i10), charSequence2.charAt(i11))) {
                return false;
            }
            i10 = i14;
            i11 = i15;
        }
        return true;
    }

    private static AsciiString[] toAsciiStringArray(String[] strArr) {
        AsciiString[] asciiStringArr = new AsciiString[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            asciiStringArr[i10] = new AsciiString(strArr[i10]);
        }
        return asciiStringArr;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).trim();
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length() - 1;
        int i10 = 0;
        while (i10 <= length && charSequence.charAt(i10) <= ' ') {
            i10++;
        }
        int i11 = length;
        while (i11 >= i10 && charSequence.charAt(i11) <= ' ') {
            i11--;
        }
        return (i10 == 0 && i11 == length) ? charSequence : charSequence.subSequence(i10, i11);
    }

    public byte[] array() {
        return this.value;
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public byte byteAt(int i10) {
        if (i10 < 0 || i10 >= this.length) {
            throw new IndexOutOfBoundsException(a.a(b.a("index: ", i10, " must be in the range [0,"), this.length, ")"));
        }
        return PlatformDependent.hasUnsafe() ? PlatformDependent.getByte(this.value, i10 + this.offset) : this.value[i10 + this.offset];
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return b2c(byteAt(i10));
    }

    public AsciiString concat(CharSequence charSequence) {
        int length = length();
        int length2 = charSequence.length();
        if (length2 == 0) {
            return this;
        }
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            if (isEmpty()) {
                return asciiString;
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length + length2);
            System.arraycopy(this.value, arrayOffset(), bArrAllocateUninitializedArray, 0, length);
            System.arraycopy(asciiString.value, asciiString.arrayOffset(), bArrAllocateUninitializedArray, length, length2);
            return new AsciiString(bArrAllocateUninitializedArray, false);
        }
        if (isEmpty()) {
            return new AsciiString(charSequence);
        }
        byte[] bArrAllocateUninitializedArray2 = PlatformDependent.allocateUninitializedArray(length2 + length);
        System.arraycopy(this.value, arrayOffset(), bArrAllocateUninitializedArray2, 0, length);
        int i10 = 0;
        while (length < bArrAllocateUninitializedArray2.length) {
            bArrAllocateUninitializedArray2[length] = c2b(charSequence.charAt(i10));
            length++;
            i10++;
        }
        return new AsciiString(bArrAllocateUninitializedArray2, false);
    }

    public boolean contains(CharSequence charSequence) {
        return indexOf(charSequence) >= 0;
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            return equals(charSequence);
        }
        int iArrayOffset = arrayOffset();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (b2c(this.value[iArrayOffset]) != charSequence.charAt(i10)) {
                return false;
            }
            iArrayOffset++;
        }
        return true;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (!(charSequence instanceof AsciiString)) {
            int iArrayOffset = arrayOffset();
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!equalsIgnoreCase(b2c(this.value[iArrayOffset]), charSequence.charAt(i10))) {
                    return false;
                }
                iArrayOffset++;
            }
            return true;
        }
        AsciiString asciiString = (AsciiString) charSequence;
        int iArrayOffset2 = arrayOffset();
        int iArrayOffset3 = asciiString.arrayOffset();
        int length2 = length() + iArrayOffset2;
        while (iArrayOffset2 < length2) {
            if (!equalsIgnoreCase(this.value[iArrayOffset2], asciiString.value[iArrayOffset3])) {
                return false;
            }
            iArrayOffset2++;
            iArrayOffset3++;
        }
        return true;
    }

    public void copy(int i10, byte[] bArr, int i11, int i12) {
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            System.arraycopy(this.value, i10 + this.offset, ObjectUtil.checkNotNull(bArr, "dst"), i11, i12);
            return;
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= srcIdx(", i10, ") <= srcIdx + length(", i12, ") <= srcLen(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public boolean endsWith(CharSequence charSequence) {
        int length = charSequence.length();
        return regionMatches(length() - length, charSequence, 0, length);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != AsciiString.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        AsciiString asciiString = (AsciiString) obj;
        return length() == asciiString.length() && hashCode() == asciiString.hashCode() && PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length());
    }

    public int forEachByte(ByteProcessor byteProcessor) throws Exception {
        return forEachByte0(0, length(), byteProcessor);
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) throws Exception {
        return forEachByteDesc0(0, length(), byteProcessor);
    }

    public int hashCode() {
        int i10 = this.hash;
        if (i10 != 0) {
            return i10;
        }
        int iHashCodeAscii = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
        this.hash = iHashCodeAscii;
        return iHashCodeAscii;
    }

    public int indexOf(CharSequence charSequence) {
        return indexOf(charSequence, 0);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public int lastIndexOf(CharSequence charSequence) {
        return lastIndexOf(charSequence, this.length);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    public boolean matches(String str) {
        return Pattern.matches(str, this);
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar() {
        return parseChar(0);
    }

    public double parseDouble() {
        return parseDouble(0, length());
    }

    public float parseFloat() {
        return parseFloat(0, length());
    }

    public int parseInt() {
        return parseInt(0, length(), 10);
    }

    public long parseLong() {
        return parseLong(0, length(), 10);
    }

    public short parseShort() {
        return parseShort(0, length(), 10);
    }

    public boolean regionMatches(int i10, CharSequence charSequence, int i11, int i12) {
        ObjectUtil.checkNotNull(charSequence, "string");
        if (i11 >= 0 && charSequence.length() - i11 >= i12) {
            int length = length();
            if (i10 >= 0 && length - i10 >= i12) {
                if (i12 <= 0) {
                    return true;
                }
                int i13 = i12 + i11;
                int iArrayOffset = arrayOffset() + i10;
                while (i11 < i13) {
                    if (b2c(this.value[iArrayOffset]) != charSequence.charAt(i11)) {
                        return false;
                    }
                    i11++;
                    iArrayOffset++;
                }
                return true;
            }
        }
        return false;
    }

    public AsciiString replace(char c10, char c11) {
        if (c10 > 255) {
            return this;
        }
        byte bC2b0 = c2b0(c10);
        byte bC2b = c2b(c11);
        int i10 = this.offset;
        int i11 = this.length + i10;
        while (i10 < i11) {
            if (this.value[i10] == bC2b0) {
                byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                byte[] bArr = this.value;
                int i12 = this.offset;
                System.arraycopy(bArr, i12, bArrAllocateUninitializedArray, 0, i10 - i12);
                bArrAllocateUninitializedArray[i10 - this.offset] = bC2b;
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        return new AsciiString(bArrAllocateUninitializedArray, false);
                    }
                    byte b10 = this.value[i10];
                    int i13 = i10 - this.offset;
                    if (b10 == bC2b0) {
                        b10 = bC2b;
                    }
                    bArrAllocateUninitializedArray[i13] = b10;
                }
            } else {
                i10++;
            }
        }
        return this;
    }

    public AsciiString[] split(String str, int i10) {
        return toAsciiStringArray(Pattern.compile(str).split(this, i10));
    }

    public boolean startsWith(CharSequence charSequence) {
        return startsWith(charSequence, 0);
    }

    public byte[] toByteArray() {
        return toByteArray(0, length());
    }

    public char[] toCharArray() {
        return toCharArray(0, length());
    }

    public AsciiString toLowerCase() {
        int iArrayOffset = arrayOffset() + length();
        for (int iArrayOffset2 = arrayOffset(); iArrayOffset2 < iArrayOffset; iArrayOffset2++) {
            byte b10 = this.value[iArrayOffset2];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                int iArrayOffset3 = arrayOffset();
                int i10 = 0;
                while (i10 < bArrAllocateUninitializedArray.length) {
                    bArrAllocateUninitializedArray[i10] = toLowerCase(this.value[iArrayOffset3]);
                    i10++;
                    iArrayOffset3++;
                }
                return new AsciiString(bArrAllocateUninitializedArray, false);
            }
        }
        return this;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        String string = toString(0);
        this.string = string;
        return string;
    }

    public AsciiString toUpperCase() {
        int iArrayOffset = arrayOffset() + length();
        for (int iArrayOffset2 = arrayOffset(); iArrayOffset2 < iArrayOffset; iArrayOffset2++) {
            byte b10 = this.value[iArrayOffset2];
            if (b10 >= 97 && b10 <= 122) {
                byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                int iArrayOffset3 = arrayOffset();
                int i10 = 0;
                while (i10 < bArrAllocateUninitializedArray.length) {
                    bArrAllocateUninitializedArray[i10] = toUpperCase(this.value[iArrayOffset3]);
                    i10++;
                    iArrayOffset3++;
                }
                return new AsciiString(bArrAllocateUninitializedArray, false);
            }
        }
        return this;
    }

    public AsciiString(byte[] bArr, boolean z10) {
        this(bArr, 0, bArr.length, z10);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, DefaultCharEqualityComparator.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsIgnoreCase(char c10, char c11) {
        return c10 == c11 || toLowerCase(c10) == toLowerCase(c11);
    }

    public static boolean isUpperCase(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        int i10 = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int iMin = Math.min(length, length2);
        int iArrayOffset = arrayOffset();
        while (i10 < iMin) {
            int iB2c = b2c(this.value[iArrayOffset]) - charSequence.charAt(i10);
            if (iB2c != 0) {
                return iB2c;
            }
            i10++;
            iArrayOffset++;
        }
        return length - length2;
    }

    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i10, i11, length())) {
            return forEachByte0(i10, i11, byteProcessor);
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= index(", i10, ") <= start + length(", i11, ") <= length(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i10, i11, length())) {
            return forEachByteDesc0(i10, i11, byteProcessor);
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= index(", i10, ") <= start + length(", i11, ") <= length(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public int indexOf(CharSequence charSequence, int i10) {
        char cCharAt;
        int length = charSequence.length();
        if (i10 < 0) {
            i10 = 0;
        }
        if (length <= 0) {
            int i11 = this.length;
            return i10 < i11 ? i10 : i11;
        }
        if (length > this.length - i10 || (cCharAt = charSequence.charAt(0)) > 255) {
            return -1;
        }
        byte bC2b0 = c2b0(cCharAt);
        int i12 = this.offset;
        int i13 = (this.length + i12) - length;
        for (int i14 = i10 + i12; i14 <= i13; i14++) {
            if (this.value[i14] == bC2b0) {
                int i15 = i14;
                int i16 = 0;
                do {
                    i16++;
                    if (i16 >= length) {
                        break;
                    }
                    i15++;
                } while (b2c(this.value[i15]) == charSequence.charAt(i16));
                if (i16 == length) {
                    return i14 - this.offset;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int iMin = Math.min(i10, this.length - length);
        if (iMin < 0) {
            return -1;
        }
        if (length == 0) {
            return iMin;
        }
        char cCharAt = charSequence.charAt(0);
        if (cCharAt > 255) {
            return -1;
        }
        byte bC2b0 = c2b0(cCharAt);
        for (int i11 = this.offset + iMin; i11 >= this.offset; i11--) {
            if (this.value[i11] == bC2b0) {
                int i12 = 0;
                int i13 = i11;
                do {
                    i12++;
                    if (i12 >= length) {
                        break;
                    }
                    i13++;
                } while (b2c(this.value[i13]) == charSequence.charAt(i12));
                if (i12 == length) {
                    return i11 - this.offset;
                }
            }
        }
        return -1;
    }

    public char parseChar(int i10) {
        if (i10 + 1 >= length()) {
            throw new IndexOutOfBoundsException(k.b.a("2 bytes required to convert to character. index ", i10, " would go out of bounds."));
        }
        int i11 = i10 + this.offset;
        return (char) (b2c(this.value[i11 + 1]) | (b2c(this.value[i11]) << '\b'));
    }

    public double parseDouble(int i10, int i11) {
        return Double.parseDouble(toString(i10, i11));
    }

    public float parseFloat(int i10, int i11) {
        return Float.parseFloat(toString(i10, i11));
    }

    public int parseInt(int i10) {
        return parseInt(0, length(), i10);
    }

    public long parseLong(int i10) {
        return parseLong(0, length(), i10);
    }

    public short parseShort(int i10) {
        return parseShort(0, length(), i10);
    }

    public AsciiString[] split(char c10) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList();
        int length = length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (charAt(i11) == c10) {
                if (i10 == i11) {
                    arrayList.add(EMPTY_STRING);
                } else {
                    arrayList.add(new AsciiString(this.value, arrayOffset() + i10, i11 - i10, false));
                }
                i10 = i11 + 1;
            }
        }
        if (i10 == 0) {
            arrayList.add(this);
        } else if (i10 != length) {
            arrayList.add(new AsciiString(this.value, arrayOffset() + i10, length - i10, false));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((AsciiString) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (AsciiString[]) arrayList.toArray(EmptyArrays.EMPTY_ASCII_STRINGS);
    }

    public boolean startsWith(CharSequence charSequence, int i10) {
        return regionMatches(i10, charSequence, 0, charSequence.length());
    }

    public AsciiString subSequence(int i10) {
        return subSequence(i10, length());
    }

    public byte[] toByteArray(int i10, int i11) {
        byte[] bArr = this.value;
        int i12 = this.offset;
        return Arrays.copyOfRange(bArr, i10 + i12, i11 + i12);
    }

    public char[] toCharArray(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (MathUtil.isOutOfBounds(i10, i12, length())) {
            StringBuilder sbA = i0.a.a("expected: 0 <= start(", i10, ") <= srcIdx + length(", i12, ") <= srcLen(");
            sbA.append(length());
            sbA.append(')');
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        char[] cArr = new char[i12];
        int iArrayOffset = arrayOffset() + i10;
        int i13 = 0;
        while (i13 < i12) {
            cArr[i13] = b2c(this.value[iArrayOffset]);
            i13++;
            iArrayOffset++;
        }
        return cArr;
    }

    public AsciiString(byte[] bArr, int i10, int i11, boolean z10) {
        if (z10) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            this.value = bArr2;
            this.offset = 0;
        } else if (!MathUtil.isOutOfBounds(i10, i11, bArr.length)) {
            this.value = bArr;
            this.offset = i10;
        } else {
            throw new IndexOutOfBoundsException(u.a.a(i0.a.a("expected: 0 <= start(", i10, ") <= start + length(", i11, ") <= value.length("), bArr.length, ')'));
        }
        this.length = i11;
    }

    private static boolean contains(CharSequence charSequence, CharSequence charSequence2, CharEqualityComparator charEqualityComparator) {
        if (charSequence != null && charSequence2 != null && charSequence.length() >= charSequence2.length()) {
            if (charSequence2.length() == 0) {
                return true;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < charSequence.length(); i11++) {
                if (charEqualityComparator.equals(charSequence2.charAt(i10), charSequence.charAt(i11))) {
                    i10++;
                    if (i10 == charSequence2.length()) {
                        return true;
                    }
                } else {
                    if (charSequence.length() - i11 < charSequence2.length()) {
                        return false;
                    }
                    i10 = 0;
                }
            }
        }
        return false;
    }

    public int parseInt(int i10, int i11) {
        return parseInt(i10, i11, 10);
    }

    public long parseLong(int i10, int i11) {
        return parseLong(i10, i11, 10);
    }

    public short parseShort(int i10, int i11) {
        return parseShort(i10, i11, 10);
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int i10, int i11) {
        return subSequence(i10, i11, true);
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence instanceof AsciiString) {
            return charSequence.hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public int parseInt(int i10, int i11, int i12) {
        if (i12 < 2 || i12 > 36) {
            throw new NumberFormatException();
        }
        if (i10 != i11) {
            boolean z10 = byteAt(i10) == 45;
            if (z10) {
                int i13 = i10 + 1;
                if (i13 == i11) {
                    throw new NumberFormatException(subSequence(i10, i11, false).toString());
                }
                i10 = i13;
            }
            return parseInt(i10, i11, i12, z10);
        }
        throw new NumberFormatException();
    }

    public long parseLong(int i10, int i11, int i12) {
        if (i12 < 2 || i12 > 36) {
            throw new NumberFormatException();
        }
        if (i10 != i11) {
            boolean z10 = byteAt(i10) == 45;
            if (z10) {
                int i13 = i10 + 1;
                if (i13 == i11) {
                    throw new NumberFormatException(subSequence(i10, i11, false).toString());
                }
                i10 = i13;
            }
            return parseLong(i10, i11, i12, z10);
        }
        throw new NumberFormatException();
    }

    public short parseShort(int i10, int i11, int i12) {
        int i13 = parseInt(i10, i11, i12);
        short s10 = (short) i13;
        if (s10 == i13) {
            return s10;
        }
        throw new NumberFormatException(subSequence(i10, i11, false).toString());
    }

    public AsciiString subSequence(int i10, int i11, boolean z10) {
        int i12 = i11 - i10;
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            if (i10 == 0 && i11 == length()) {
                return this;
            }
            if (i11 == i10) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, i10 + this.offset, i12, z10);
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= start(", i10, ") <= end (", i11, ") <= length(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public String toString(int i10) {
        return toString(i10, length());
    }

    public String toString(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            return new String(this.value, 0, i10 + this.offset, i12);
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= start(", i10, ") <= srcIdx + length(", i12, ") <= srcLen(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEquals(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEquals(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean regionMatches(boolean z10, int i10, CharSequence charSequence, int i11, int i12) {
        if (!z10) {
            return regionMatches(i10, charSequence, i11, i12);
        }
        ObjectUtil.checkNotNull(charSequence, "string");
        int length = length();
        if (i10 < 0 || i12 > length - i10 || i11 < 0 || i12 > charSequence.length() - i11) {
            return false;
        }
        int iArrayOffset = arrayOffset() + i10;
        int i13 = i12 + iArrayOffset;
        while (iArrayOffset < i13) {
            int i14 = iArrayOffset + 1;
            int i15 = i11 + 1;
            if (!equalsIgnoreCase(b2c(this.value[iArrayOffset]), charSequence.charAt(i11))) {
                return false;
            }
            i11 = i15;
            iArrayOffset = i14;
        }
        return true;
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!equalsIgnoreCase(charSequence.charAt(i10), charSequence2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    private static byte toLowerCase(byte b10) {
        return isUpperCase(b10) ? (byte) (b10 + 32) : b10;
    }

    private static byte toUpperCase(byte b10) {
        return isLowerCase(b10) ? (byte) (b10 - 32) : b10;
    }

    private int parseInt(int i10, int i11, int i12, boolean z10) {
        int i13 = Integer.MIN_VALUE / i12;
        int i14 = i10;
        int i15 = 0;
        while (i14 < i11) {
            int i16 = i14 + 1;
            int iDigit = Character.digit((char) (this.value[i14 + this.offset] & 255), i12);
            if (iDigit == -1) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            if (i13 > i15) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            int i17 = (i15 * i12) - iDigit;
            if (i17 > i15) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            i15 = i17;
            i14 = i16;
        }
        if (z10 || (i15 = -i15) >= 0) {
            return i15;
        }
        throw new NumberFormatException(subSequence(i10, i11, false).toString());
    }

    private long parseLong(int i10, int i11, int i12, boolean z10) {
        long j10 = i12;
        long j11 = Long.MIN_VALUE / j10;
        int i13 = i10;
        long j12 = 0;
        while (i13 < i11) {
            int i14 = i13 + 1;
            int iDigit = Character.digit((char) (this.value[i13 + this.offset] & 255), i12);
            if (iDigit == -1) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            if (j11 > j12) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            long j13 = (j12 * j10) - ((long) iDigit);
            if (j13 > j12) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
            j12 = j13;
            i13 = i14;
        }
        if (!z10) {
            j12 = -j12;
            if (j12 < 0) {
                throw new NumberFormatException(subSequence(i10, i11, false).toString());
            }
        }
        return j12;
    }

    public static char toLowerCase(char c10) {
        return isUpperCase(c10) ? (char) (c10 + ' ') : c10;
    }

    public AsciiString trim() {
        int iArrayOffset = arrayOffset();
        int length = (length() + arrayOffset()) - 1;
        while (iArrayOffset <= length && this.value[iArrayOffset] <= 32) {
            iArrayOffset++;
        }
        int i10 = length;
        while (i10 >= iArrayOffset && this.value[i10] <= 32) {
            i10--;
        }
        return (iArrayOffset == 0 && i10 == length) ? this : new AsciiString(this.value, iArrayOffset, (i10 - iArrayOffset) + 1, false);
    }

    public int indexOf(char c10, int i10) {
        if (c10 > 255) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        byte bC2b0 = c2b0(c10);
        int i11 = this.offset;
        int i12 = this.length + i11;
        for (int i13 = i10 + i11; i13 < i12; i13++) {
            if (this.value[i13] == bC2b0) {
                return i13 - this.offset;
            }
        }
        return -1;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z10, int i10, CharSequence charSequence2, int i11, int i12) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z10, i10, (String) charSequence2, i11, i12);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z10, i10, charSequence2, i11, i12);
        }
        return regionMatchesCharSequences(charSequence, i10, charSequence2, i11, i12, z10 ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public void copy(int i10, char[] cArr, int i11, int i12) {
        ObjectUtil.checkNotNull(cArr, "dst");
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            int i13 = i12 + i11;
            int iArrayOffset = arrayOffset() + i10;
            while (i11 < i13) {
                cArr[i11] = b2c(this.value[iArrayOffset]);
                i11++;
                iArrayOffset++;
            }
            return;
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= srcIdx(", i10, ") <= srcIdx + length(", i12, ") <= srcLen(");
        sbA.append(length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public static int indexOf(CharSequence charSequence, char c10, int i10) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).indexOf(c10, i10);
        }
        if (charSequence == null) {
            return -1;
        }
        int length = charSequence.length();
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < length) {
            if (charSequence.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public AsciiString(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    public AsciiString(ByteBuffer byteBuffer, boolean z10) {
        this(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), z10);
    }

    public AsciiString(ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        if (!MathUtil.isOutOfBounds(i10, i11, byteBuffer.capacity())) {
            if (!byteBuffer.hasArray()) {
                byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i11);
                this.value = bArrAllocateUninitializedArray;
                int iPosition = byteBuffer.position();
                byteBuffer.get(bArrAllocateUninitializedArray, 0, i11);
                byteBuffer.position(iPosition);
                this.offset = 0;
            } else if (z10) {
                int iArrayOffset = byteBuffer.arrayOffset() + i10;
                this.value = Arrays.copyOfRange(byteBuffer.array(), iArrayOffset, iArrayOffset + i11);
                this.offset = 0;
            } else {
                this.value = byteBuffer.array();
                this.offset = i10;
            }
            this.length = i11;
            return;
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= start(", i10, ") <= start + length(", i11, ") <= value.capacity(");
        sbA.append(byteBuffer.capacity());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public AsciiString(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public AsciiString(char[] cArr, int i10, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11, cArr.length)) {
            this.value = PlatformDependent.allocateUninitializedArray(i11);
            int i12 = 0;
            while (i12 < i11) {
                this.value[i12] = c2b(cArr[i10]);
                i12++;
                i10++;
            }
            this.offset = 0;
            this.length = i11;
            return;
        }
        throw new IndexOutOfBoundsException(u.a.a(i0.a.a("expected: 0 <= start(", i10, ") <= start + length(", i11, ") <= value.length("), cArr.length, ')'));
    }

    public AsciiString(char[] cArr, Charset charset) {
        this(cArr, charset, 0, cArr.length);
    }

    public AsciiString(char[] cArr, Charset charset, int i10, int i11) {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i10, i11);
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(charset);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (charsetEncoderEncoder.maxBytesPerChar() * i11));
        charsetEncoderEncoder.encode(charBufferWrap, byteBufferAllocate, true);
        int iArrayOffset = byteBufferAllocate.arrayOffset();
        byte[] bArrCopyOfRange = Arrays.copyOfRange(byteBufferAllocate.array(), iArrayOffset, byteBufferAllocate.position() + iArrayOffset);
        this.value = bArrCopyOfRange;
        this.offset = 0;
        this.length = bArrCopyOfRange.length;
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, int i10, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11, charSequence.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(i11);
            int i12 = 0;
            while (i12 < i11) {
                this.value[i12] = c2b(charSequence.charAt(i10));
                i12++;
                i10++;
            }
            this.offset = 0;
            this.length = i11;
            return;
        }
        StringBuilder sbA = i0.a.a("expected: 0 <= start(", i10, ") <= start + length(", i11, ") <= value.length(");
        sbA.append(charSequence.length());
        sbA.append(')');
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public AsciiString(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, Charset charset, int i10, int i11) {
        CharBuffer charBufferWrap = CharBuffer.wrap(charSequence, i10, i10 + i11);
        CharsetEncoder charsetEncoderEncoder = CharsetUtil.encoder(charset);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (charsetEncoderEncoder.maxBytesPerChar() * i11));
        charsetEncoderEncoder.encode(charBufferWrap, byteBufferAllocate, true);
        int iArrayOffset = byteBufferAllocate.arrayOffset();
        byte[] bArrCopyOfRange = Arrays.copyOfRange(byteBufferAllocate.array(), iArrayOffset, byteBufferAllocate.position() + iArrayOffset);
        this.value = bArrCopyOfRange;
        this.offset = 0;
        this.length = bArrCopyOfRange.length;
    }
}
