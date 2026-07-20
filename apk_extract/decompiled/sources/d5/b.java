package d5;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;
import v4.h0;
import x4.d0;
import x4.k;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private h0 strictness = h0.LEGACY_STRICT;
    private int nestingLimit = 255;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4293a = 0;
    private int stackSize = 1;

    static {
        k.INSTANCE = new a();
    }

    public b(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws e {
        if (this.strictness != h0.LENIENT) {
            throw syntaxError("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i8 = this.pos;
        this.pos = i8 - 1;
        if (i8 + 4 <= this.limit || fillBuffer(5)) {
            int i9 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i9] == ')' && cArr[i9 + 1] == ']' && cArr[i9 + 2] == '}' && cArr[i9 + 3] == '\'' && cArr[i9 + 4] == '\n') {
                this.pos = i9 + 5;
            }
        }
    }

    private boolean fillBuffer(int i8) throws IOException {
        int i9;
        int i10;
        char[] cArr = this.buffer;
        int i11 = this.lineStart;
        int i12 = this.pos;
        this.lineStart = i11 - i12;
        int i13 = this.limit;
        if (i13 != i12) {
            int i14 = i13 - i12;
            this.limit = i14;
            System.arraycopy(cArr, i12, cArr, 0, i14);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i15 = this.limit;
            int i16 = reader.read(cArr, i15, cArr.length - i15);
            if (i16 == -1) {
                return false;
            }
            i9 = this.limit + i16;
            this.limit = i9;
            if (this.lineNumber == 0 && (i10 = this.lineStart) == 0 && i9 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i10 + 1;
                i8++;
            }
        } while (i9 < i8);
        return true;
    }

    private String getPath(boolean z2) {
        StringBuilder sb2 = new StringBuilder("$");
        int i8 = 0;
        while (true) {
            int i9 = this.stackSize;
            if (i8 >= i9) {
                return sb2.toString();
            }
            int i10 = this.stack[i8];
            switch (i10) {
                case 1:
                case 2:
                    int i11 = this.pathIndices[i8];
                    if (z2 && i11 > 0 && i8 == i9 - 1) {
                        i11--;
                    }
                    sb2.append('[');
                    sb2.append(i11);
                    sb2.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb2.append('.');
                    String str = this.pathNames[i8];
                    if (str != null) {
                        sb2.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(a1.a.o(i10, "Unknown scope value: "));
            }
            i8++;
        }
    }

    private boolean isLiteral(char c9) throws IOException {
        if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
            return false;
        }
        if (c9 != '#') {
            if (c9 == ',') {
                return false;
            }
            if (c9 != '/' && c9 != '=') {
                if (c9 == '{' || c9 == '}' || c9 == ':') {
                    return false;
                }
                if (c9 != ';') {
                    switch (c9) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z2) throws IOException {
        char[] cArr = this.buffer;
        int i8 = this.pos;
        int i9 = this.limit;
        while (true) {
            if (i8 == i9) {
                this.pos = i8;
                if (!fillBuffer(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i8 = this.pos;
                i9 = this.limit;
            }
            int i10 = i8 + 1;
            char c9 = cArr[i8];
            if (c9 == '\n') {
                this.lineNumber++;
                this.lineStart = i10;
            } else if (c9 != ' ' && c9 != '\r' && c9 != '\t') {
                if (c9 == '/') {
                    this.pos = i10;
                    if (i10 == i9) {
                        this.pos = i8;
                        boolean zFillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!zFillBuffer) {
                            return c9;
                        }
                    }
                    checkLenient();
                    int i11 = this.pos;
                    char c10 = cArr[i11];
                    if (c10 == '*') {
                        this.pos = i11 + 1;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        i8 = this.pos + 2;
                        i9 = this.limit;
                    } else {
                        if (c10 != '/') {
                            return c9;
                        }
                        this.pos = i11 + 1;
                        skipToEndOfLine();
                        i8 = this.pos;
                        i9 = this.limit;
                    }
                } else {
                    if (c9 != '#') {
                        this.pos = i10;
                        return c9;
                    }
                    this.pos = i10;
                    checkLenient();
                    skipToEndOfLine();
                    i8 = this.pos;
                    i9 = this.limit;
                }
            }
            i8 = i10;
        }
    }

    private String nextQuotedValue(char c9) throws IOException {
        int i8;
        char[] cArr = this.buffer;
        StringBuilder sb2 = null;
        do {
            int i9 = this.pos;
            int i10 = this.limit;
            while (true) {
                int i11 = i10;
                i8 = i9;
                while (true) {
                    if (i9 < i11) {
                        int i12 = i9 + 1;
                        char c10 = cArr[i9];
                        if (this.strictness == h0.STRICT && c10 < ' ') {
                            throw syntaxError("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                        }
                        if (c10 == c9) {
                            this.pos = i12;
                            int i13 = (i12 - i8) - 1;
                            if (sb2 == null) {
                                return new String(cArr, i8, i13);
                            }
                            sb2.append(cArr, i8, i13);
                            return sb2.toString();
                        }
                        if (c10 == '\\') {
                            this.pos = i12;
                            int i14 = i12 - i8;
                            int i15 = i14 - 1;
                            if (sb2 == null) {
                                sb2 = new StringBuilder(Math.max(i14 * 2, 16));
                            }
                            sb2.append(cArr, i8, i15);
                            sb2.append(readEscapeCharacter());
                            i9 = this.pos;
                            i10 = this.limit;
                        } else {
                            if (c10 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i12;
                            }
                            i9 = i12;
                        }
                    }
                }
            }
            if (sb2 == null) {
                sb2 = new StringBuilder(Math.max((i9 - i8) * 2, 16));
            }
            sb2.append(cArr, i8, i9 - i8);
            this.pos = i9;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String nextUnquotedValue() throws IOException {
        String string;
        StringBuilder sb2 = null;
        int i8 = 0;
        while (true) {
            int i9 = 0;
            while (true) {
                int i10 = this.pos;
                if (i10 + i9 < this.limit) {
                    char c9 = this.buffer[i10 + i9];
                    if (c9 != '\t' && c9 != '\n' && c9 != '\f' && c9 != '\r' && c9 != ' ') {
                        if (c9 != '#') {
                            if (c9 != ',') {
                                if (c9 != '/' && c9 != '=') {
                                    if (c9 != '{' && c9 != '}' && c9 != ':') {
                                        if (c9 != ';') {
                                            switch (c9) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i9++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    i8 = i9;
                } else if (i9 >= this.buffer.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i9, 16));
                    }
                    sb2.append(this.buffer, this.pos, i9);
                    this.pos += i9;
                    if (!fillBuffer(1)) {
                    }
                } else if (!fillBuffer(i9 + 1)) {
                    i8 = i9;
                }
                if (sb2 == null) {
                    string = new String(this.buffer, this.pos, i8);
                } else {
                    sb2.append(this.buffer, this.pos, i8);
                    string = sb2.toString();
                }
                this.pos += i8;
                return string;
            }
        }
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i8;
        char c9 = this.buffer[this.pos];
        if (c9 == 't' || c9 == 'T') {
            str = "true";
            str2 = "TRUE";
            i8 = 5;
        } else if (c9 == 'f' || c9 == 'F') {
            str = "false";
            str2 = "FALSE";
            i8 = 6;
        } else {
            if (c9 != 'n' && c9 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i8 = 7;
        }
        boolean z2 = this.strictness != h0.STRICT;
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            if (this.pos + i9 >= this.limit && !fillBuffer(i9 + 1)) {
                return 0;
            }
            char c10 = this.buffer[this.pos + i9];
            if (c10 != str.charAt(i9) && (!z2 || c10 != str2.charAt(i9))) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.f4293a = i8;
        return i8;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00ec  */
    private int peekNumber() throws IOException {
        char c9;
        char c10;
        char[] cArr = this.buffer;
        int i8 = this.pos;
        int i9 = this.limit;
        int i10 = 0;
        int i11 = 0;
        char c11 = 0;
        boolean z2 = false;
        boolean z3 = true;
        long j8 = 0;
        while (true) {
            if (i8 + i11 != i9) {
                c9 = cArr[i8 + i11];
                if (c9 != '+') {
                    if (c9 != 'E' || c9 == 'e') {
                        i10 = 0;
                        if (c11 == 2 && c11 != 4) {
                            return 0;
                        }
                        c11 = 5;
                    } else if (c9 != '-') {
                        c10 = 3;
                        if (c9 == '.') {
                            i10 = 0;
                            if (c11 != 2) {
                                return 0;
                            }
                        } else {
                            if (c9 < '0' || c9 > '9') {
                                if (!isLiteral(c9)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c11 == 1 || c11 == 0) {
                                j8 = -(c9 - '0');
                                c11 = 2;
                            } else if (c11 == 2) {
                                if (j8 == 0) {
                                    return 0;
                                }
                                long j10 = (10 * j8) - ((long) (c9 - '0'));
                                z3 &= j8 > MIN_INCOMPLETE_INTEGER || (j8 == MIN_INCOMPLETE_INTEGER && j10 < j8);
                                j8 = j10;
                            } else if (c11 == 3) {
                                i10 = 0;
                                c11 = 4;
                            } else if (c11 == 5 || c11 == 6) {
                                i10 = 0;
                                c11 = 7;
                            }
                            i10 = 0;
                        }
                    } else {
                        c10 = 6;
                        i10 = 0;
                        if (c11 == 0) {
                            c11 = 1;
                            z2 = true;
                        } else if (c11 != 5) {
                            return 0;
                        }
                    }
                    i11++;
                } else {
                    c10 = 6;
                    i10 = 0;
                    if (c11 != 5) {
                        return 0;
                    }
                }
                c11 = c10;
                i11++;
            } else {
                if (i11 == cArr.length) {
                    return i10;
                }
                if (!fillBuffer(i11 + 1)) {
                    break;
                }
                i8 = this.pos;
                i9 = this.limit;
                c9 = cArr[i8 + i11];
                if (c9 != '+') {
                    if (c9 != 'E') {
                        i10 = 0;
                        if (c11 == 2) {
                        }
                        c11 = 5;
                    } else {
                        i10 = 0;
                        if (c11 == 2) {
                        }
                        c11 = 5;
                    }
                    i11++;
                } else {
                    c10 = 6;
                    i10 = 0;
                    if (c11 != 5) {
                        return 0;
                    }
                }
                c11 = c10;
                i11++;
            }
        }
        if (c11 == 2 && z3 && ((j8 != Long.MIN_VALUE || z2) && (j8 != 0 || !z2))) {
            if (!z2) {
                j8 = -j8;
            }
            this.peekedLong = j8;
            this.pos += i11;
            this.f4293a = 15;
            return 15;
        }
        if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        }
        this.peekedNumberLength = i11;
        this.f4293a = 16;
        return 16;
    }

    private void push(int i8) throws e {
        int i9 = this.stackSize;
        if (i9 - 1 >= this.nestingLimit) {
            throw new e("Nesting limit " + this.nestingLimit + " reached" + locationString());
        }
        int[] iArr = this.stack;
        if (i9 == iArr.length) {
            int i10 = i9 * 2;
            this.stack = Arrays.copyOf(iArr, i10);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i10);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i10);
        }
        int[] iArr2 = this.stack;
        int i11 = this.stackSize;
        this.stackSize = i11 + 1;
        iArr2[i11] = i8;
    }

    private char readEscapeCharacter() throws IOException {
        int i8;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i9 = this.pos;
        int i10 = i9 + 1;
        this.pos = i10;
        char c9 = cArr[i9];
        if (c9 != '\n') {
            if (c9 != '\"') {
                if (c9 != '\'') {
                    if (c9 != '/' && c9 != '\\') {
                        if (c9 == 'b') {
                            return '\b';
                        }
                        if (c9 == 'f') {
                            return '\f';
                        }
                        if (c9 == 'n') {
                            return '\n';
                        }
                        if (c9 == 'r') {
                            return '\r';
                        }
                        if (c9 == 't') {
                            return '\t';
                        }
                        if (c9 != 'u') {
                            throw syntaxError("Invalid escape sequence");
                        }
                        if (i9 + 5 > this.limit && !fillBuffer(4)) {
                            throw syntaxError("Unterminated escape sequence");
                        }
                        int i11 = this.pos;
                        int i12 = i11 + 4;
                        int i13 = 0;
                        while (i11 < i12) {
                            char[] cArr2 = this.buffer;
                            char c10 = cArr2[i11];
                            int i14 = i13 << 4;
                            if (c10 >= '0' && c10 <= '9') {
                                i8 = c10 - '0';
                            } else if (c10 >= 'a' && c10 <= 'f') {
                                i8 = c10 - 'W';
                            } else {
                                if (c10 < 'A' || c10 > 'F') {
                                    throw syntaxError("Malformed Unicode escape \\u".concat(new String(cArr2, this.pos, 4)));
                                }
                                i8 = c10 - '7';
                            }
                            i13 = i8 + i14;
                            i11++;
                        }
                        this.pos += 4;
                        return (char) i13;
                    }
                }
            }
            return c9;
        }
        if (this.strictness == h0.STRICT) {
            throw syntaxError("Cannot escape a newline character in strict mode");
        }
        this.lineNumber++;
        this.lineStart = i10;
        if (this.strictness == h0.STRICT) {
            throw syntaxError("Invalid escaped character \"'\" in strict mode");
        }
        return c9;
    }

    private void skipQuotedValue(char c9) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i8 = this.pos;
            int i9 = this.limit;
            while (i8 < i9) {
                int i10 = i8 + 1;
                char c10 = cArr[i8];
                if (c10 == c9) {
                    this.pos = i10;
                    return;
                }
                if (c10 == '\\') {
                    this.pos = i10;
                    readEscapeCharacter();
                    i8 = this.pos;
                    i9 = this.limit;
                } else {
                    if (c10 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i10;
                    }
                    i8 = i10;
                }
            }
            this.pos = i8;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i8 = this.pos;
            if (cArr[i8] != '\n') {
                for (int i9 = 0; i9 < length; i9++) {
                    if (this.buffer[this.pos + i9] == str.charAt(i9)) {
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i8 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c9;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 + 1;
            this.pos = i9;
            c9 = cArr[i8];
            if (c9 == '\n') {
                this.lineNumber++;
                this.lineStart = i9;
                return;
            }
        } while (c9 != '\r');
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i8 = 0;
            while (true) {
                int i9 = this.pos;
                if (i9 + i8 < this.limit) {
                    char c9 = this.buffer[i9 + i8];
                    if (c9 != '\t' && c9 != '\n' && c9 != '\f' && c9 != '\r' && c9 != ' ') {
                        if (c9 != '#') {
                            if (c9 != ',') {
                                if (c9 != '/' && c9 != '=') {
                                    if (c9 != '{' && c9 != '}' && c9 != ':') {
                                        if (c9 != ';') {
                                            switch (c9) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i8++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    this.pos += i8;
                    return;
                }
                this.pos = i9 + i8;
            }
        } while (fillBuffer(1));
    }

    private e syntaxError(String str) throws e {
        StringBuilder sbS = o.d.s(str);
        sbS.append(locationString());
        sbS.append("\nSee ");
        sbS.append(d0.createUrl("malformed-json"));
        throw new e(sbS.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IllegalStateException unexpectedTokenError(String str) throws IOException {
        String str2 = peek() == c.NULL ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbY = a1.a.y("Expected ", str, " but was ");
        sbY.append(peek());
        sbY.append(locationString());
        sbY.append("\nSee ");
        sbY.append(d0.createUrl(str2));
        return new IllegalStateException(sbY.toString());
    }

    public void beginArray() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 3) {
            throw unexpectedTokenError("BEGIN_ARRAY");
        }
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.f4293a = 0;
    }

    public void beginObject() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 1) {
            throw unexpectedTokenError("BEGIN_OBJECT");
        }
        push(3);
        this.f4293a = 0;
    }

    public final int c() throws IOException {
        int iNextNonWhitespace;
        int[] iArr = this.stack;
        int i8 = this.stackSize;
        int i9 = iArr[i8 - 1];
        if (i9 == 1) {
            iArr[i8 - 1] = 2;
        } else if (i9 == 2) {
            int iNextNonWhitespace2 = nextNonWhitespace(true);
            if (iNextNonWhitespace2 != 44) {
                if (iNextNonWhitespace2 != 59) {
                    if (iNextNonWhitespace2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.f4293a = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i9 == 3 || i9 == 5) {
                iArr[i8 - 1] = 4;
                if (i9 == 5 && (iNextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (iNextNonWhitespace != 59) {
                        if (iNextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.f4293a = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                if (iNextNonWhitespace3 == 34) {
                    this.f4293a = 13;
                    return 13;
                }
                if (iNextNonWhitespace3 == 39) {
                    checkLenient();
                    this.f4293a = 12;
                    return 12;
                }
                if (iNextNonWhitespace3 == 125) {
                    if (i9 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.f4293a = 2;
                    return 2;
                }
                checkLenient();
                this.pos--;
                if (!isLiteral((char) iNextNonWhitespace3)) {
                    throw syntaxError("Expected name");
                }
                this.f4293a = 14;
                return 14;
            }
            if (i9 == 4) {
                iArr[i8 - 1] = 5;
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                if (iNextNonWhitespace4 != 58) {
                    if (iNextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i10 = this.pos;
                        if (cArr[i10] == '>') {
                            this.pos = i10 + 1;
                        }
                    }
                }
            } else if (i9 == 6) {
                if (this.strictness == h0.LENIENT) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i9 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.f4293a = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i9 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iNextNonWhitespace5 = nextNonWhitespace(true);
        if (iNextNonWhitespace5 == 34) {
            this.f4293a = 9;
            return 9;
        }
        if (iNextNonWhitespace5 == 39) {
            checkLenient();
            this.f4293a = 8;
            return 8;
        }
        if (iNextNonWhitespace5 != 44 && iNextNonWhitespace5 != 59) {
            if (iNextNonWhitespace5 == 91) {
                this.f4293a = 3;
                return 3;
            }
            if (iNextNonWhitespace5 != 93) {
                if (iNextNonWhitespace5 == 123) {
                    this.f4293a = 1;
                    return 1;
                }
                this.pos--;
                int iPeekKeyword = peekKeyword();
                if (iPeekKeyword != 0) {
                    return iPeekKeyword;
                }
                int iPeekNumber = peekNumber();
                if (iPeekNumber != 0) {
                    return iPeekNumber;
                }
                if (!isLiteral(this.buffer[this.pos])) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.f4293a = 10;
                return 10;
            }
            if (i9 == 1) {
                this.f4293a = 4;
                return 4;
            }
        }
        if (i9 != 1 && i9 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos--;
        this.f4293a = 7;
        return 7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4293a = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 4) {
            throw unexpectedTokenError("END_ARRAY");
        }
        int i8 = this.stackSize;
        this.stackSize = i8 - 1;
        int[] iArr = this.pathIndices;
        int i9 = i8 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f4293a = 0;
    }

    public void endObject() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 2) {
            throw unexpectedTokenError("END_OBJECT");
        }
        int i8 = this.stackSize;
        int i9 = i8 - 1;
        this.stackSize = i9;
        this.pathNames[i9] = null;
        int[] iArr = this.pathIndices;
        int i10 = i8 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f4293a = 0;
    }

    public final int getNestingLimit() {
        return this.nestingLimit;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public final h0 getStrictness() {
        return this.strictness;
    }

    public boolean hasNext() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        return (iC == 2 || iC == 4 || iC == 17) ? false : true;
    }

    public final boolean isLenient() {
        return this.strictness == h0.LENIENT;
    }

    public final String locationString() {
        StringBuilder sbR = o.d.r(this.lineNumber + 1, (this.pos - this.lineStart) + 1, " at line ", " column ", " path ");
        sbR.append(getPath());
        return sbR.toString();
    }

    public boolean nextBoolean() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 5) {
            this.f4293a = 0;
            int[] iArr = this.pathIndices;
            int i8 = this.stackSize - 1;
            iArr[i8] = iArr[i8] + 1;
            return true;
        }
        if (iC != 6) {
            throw unexpectedTokenError("a boolean");
        }
        this.f4293a = 0;
        int[] iArr2 = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr2[i9] = iArr2[i9] + 1;
        return false;
    }

    public double nextDouble() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f4293a = 0;
            int[] iArr = this.pathIndices;
            int i8 = this.stackSize - 1;
            iArr[i8] = iArr[i8] + 1;
            return this.peekedLong;
        }
        if (iC == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (iC == 8 || iC == 9) {
            this.peekedString = nextQuotedValue(iC == 8 ? '\'' : Typography.quote);
        } else if (iC == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iC != 11) {
            throw unexpectedTokenError("a double");
        }
        this.f4293a = 11;
        double d7 = Double.parseDouble(this.peekedString);
        if (this.strictness != h0.LENIENT && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw syntaxError("JSON forbids NaN and infinities: " + d7);
        }
        this.peekedString = null;
        this.f4293a = 0;
        int[] iArr2 = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr2[i9] = iArr2[i9] + 1;
        return d7;
    }

    public int nextInt() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            long j8 = this.peekedLong;
            int i8 = (int) j8;
            if (j8 != i8) {
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            this.f4293a = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return i8;
        }
        if (iC == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw unexpectedTokenError("an int");
            }
            if (iC == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iC == 8 ? '\'' : Typography.quote);
            }
            try {
                int i10 = Integer.parseInt(this.peekedString);
                this.f4293a = 0;
                int[] iArr2 = this.pathIndices;
                int i11 = this.stackSize - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return i10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4293a = 11;
        double d7 = Double.parseDouble(this.peekedString);
        int i12 = (int) d7;
        if (i12 != d7) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.f4293a = 0;
        int[] iArr3 = this.pathIndices;
        int i13 = this.stackSize - 1;
        iArr3[i13] = iArr3[i13] + 1;
        return i12;
    }

    public long nextLong() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f4293a = 0;
            int[] iArr = this.pathIndices;
            int i8 = this.stackSize - 1;
            iArr[i8] = iArr[i8] + 1;
            return this.peekedLong;
        }
        if (iC == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw unexpectedTokenError("a long");
            }
            if (iC == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iC == 8 ? '\'' : Typography.quote);
            }
            try {
                long j8 = Long.parseLong(this.peekedString);
                this.f4293a = 0;
                int[] iArr2 = this.pathIndices;
                int i9 = this.stackSize - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return j8;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4293a = 11;
        double d7 = Double.parseDouble(this.peekedString);
        long j10 = (long) d7;
        if (j10 != d7) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.f4293a = 0;
        int[] iArr3 = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr3[i10] = iArr3[i10] + 1;
        return j10;
    }

    public String nextName() throws IOException {
        String strNextQuotedValue;
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 14) {
            strNextQuotedValue = nextUnquotedValue();
        } else if (iC == 12) {
            strNextQuotedValue = nextQuotedValue('\'');
        } else {
            if (iC != 13) {
                throw unexpectedTokenError("a name");
            }
            strNextQuotedValue = nextQuotedValue(Typography.quote);
        }
        this.f4293a = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    public void nextNull() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 7) {
            throw unexpectedTokenError("null");
        }
        this.f4293a = 0;
        int[] iArr = this.pathIndices;
        int i8 = this.stackSize - 1;
        iArr[i8] = iArr[i8] + 1;
    }

    public String nextString() throws IOException {
        String str;
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 10) {
            str = nextUnquotedValue();
        } else if (iC == 8) {
            str = nextQuotedValue('\'');
        } else if (iC == 9) {
            str = nextQuotedValue(Typography.quote);
        } else if (iC == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (iC == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (iC != 16) {
                throw unexpectedTokenError("a string");
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.f4293a = 0;
        int[] iArr = this.pathIndices;
        int i8 = this.stackSize - 1;
        iArr[i8] = iArr[i8] + 1;
        return str;
    }

    public c peek() throws IOException {
        int iC = this.f4293a;
        if (iC == 0) {
            iC = c();
        }
        switch (iC) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Deprecated
    public final void setLenient(boolean z2) {
        setStrictness(z2 ? h0.LENIENT : h0.LEGACY_STRICT);
    }

    public final void setNestingLimit(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "Invalid nesting limit: "));
        }
        this.nestingLimit = i8;
    }

    public final void setStrictness(h0 h0Var) {
        Objects.requireNonNull(h0Var);
        this.strictness = h0Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void skipValue() throws IOException {
        int i8 = 0;
        do {
            int iC = this.f4293a;
            if (iC == 0) {
                iC = c();
            }
            switch (iC) {
                case 1:
                    push(3);
                    i8++;
                    this.f4293a = 0;
                    break;
                case 2:
                    if (i8 == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    i8--;
                    this.f4293a = 0;
                    break;
                case 3:
                    push(1);
                    i8++;
                    this.f4293a = 0;
                    break;
                case 4:
                    this.stackSize--;
                    i8--;
                    this.f4293a = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f4293a = 0;
                    break;
                case 8:
                    skipQuotedValue('\'');
                    this.f4293a = 0;
                    break;
                case 9:
                    skipQuotedValue(Typography.quote);
                    this.f4293a = 0;
                    break;
                case 10:
                    skipUnquotedValue();
                    this.f4293a = 0;
                    break;
                case 12:
                    skipQuotedValue('\'');
                    if (i8 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f4293a = 0;
                    break;
                case 13:
                    skipQuotedValue(Typography.quote);
                    if (i8 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f4293a = 0;
                    break;
                case 14:
                    skipUnquotedValue();
                    if (i8 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f4293a = 0;
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    this.f4293a = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i8 > 0);
        int[] iArr = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr[i9] = iArr[i9] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
