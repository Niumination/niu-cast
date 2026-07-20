package d2;

import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import x1.g;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {
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

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3511b = 1024;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final Reader f3513in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3512a = 0;
    private int stackSize = 1;

    /* JADX INFO: renamed from: d2.a$a, reason: collision with other inner class name */
    public class C0081a extends g {
        @Override // x1.g
        public void promoteNameToValue(a aVar) throws IOException {
            if (aVar instanceof y1.f) {
                ((y1.f) aVar).promoteNameToValue();
                return;
            }
            int iB = aVar.f3512a;
            if (iB == 0) {
                iB = aVar.b();
            }
            if (iB == 13) {
                aVar.f3512a = 9;
                return;
            }
            if (iB == 12) {
                aVar.f3512a = 8;
            } else {
                if (iB == 14) {
                    aVar.f3512a = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + aVar.peek() + aVar.locationString());
            }
        }
    }

    static {
        g.INSTANCE = new C0081a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f3513in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i10 = this.pos;
        this.pos = i10 - 1;
        if (i10 + 4 <= this.limit || fillBuffer(5)) {
            int i11 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
                this.pos = i11 + 5;
            }
        }
    }

    private boolean fillBuffer(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.buffer;
        int i13 = this.lineStart;
        int i14 = this.pos;
        this.lineStart = i13 - i14;
        int i15 = this.limit;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.limit = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f3513in;
            int i17 = this.limit;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.limit + i18;
            this.limit = i11;
            if (this.lineNumber == 0 && (i12 = this.lineStart) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    private String getPath(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.stackSize;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.stack[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.pathIndices[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append(ks.a.f9445d);
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(n1.e.f11183c);
                String str = this.pathNames[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private boolean isLiteral(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case ms.a.T /* 91 */:
                        case ms.a.U /* 93 */:
                            return false;
                        case ms.a.W /* 92 */:
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

    private int nextNonWhitespace(boolean z10) throws IOException {
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = this.limit;
        while (true) {
            if (i10 == i11) {
                this.pos = i10;
                if (!fillBuffer(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i10 = this.pos;
                i11 = this.limit;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.lineNumber++;
                this.lineStart = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.pos = i12;
                    if (i12 == i11) {
                        this.pos = i10;
                        boolean zFillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!zFillBuffer) {
                            return c10;
                        }
                    }
                    checkLenient();
                    int i13 = this.pos;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.pos = i13 + 1;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        i10 = this.pos + 2;
                        i11 = this.limit;
                    } else {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.pos = i13 + 1;
                        skipToEndOfLine();
                        i10 = this.pos;
                        i11 = this.limit;
                    }
                } else {
                    if (c10 != '#') {
                        this.pos = i12;
                        return c10;
                    }
                    this.pos = i12;
                    checkLenient();
                    skipToEndOfLine();
                    i10 = this.pos;
                    i11 = this.limit;
                }
            }
            i10 = i12;
        }
    }

    private String nextQuotedValue(char c10) throws IOException {
        int i10;
        char[] cArr = this.buffer;
        StringBuilder sb2 = null;
        do {
            int i11 = this.pos;
            int i12 = this.limit;
            while (true) {
                int i13 = i12;
                i10 = i11;
                while (true) {
                    if (i11 < i13) {
                        int i14 = i11 + 1;
                        char c11 = cArr[i11];
                        if (c11 == c10) {
                            this.pos = i14;
                            int i15 = (i14 - i10) - 1;
                            if (sb2 == null) {
                                return new String(cArr, i10, i15);
                            }
                            sb2.append(cArr, i10, i15);
                            return sb2.toString();
                        }
                        if (c11 == '\\') {
                            this.pos = i14;
                            int i16 = i14 - i10;
                            int i17 = i16 - 1;
                            if (sb2 == null) {
                                sb2 = new StringBuilder(Math.max(i16 * 2, 16));
                            }
                            sb2.append(cArr, i10, i17);
                            sb2.append(readEscapeCharacter());
                            i11 = this.pos;
                            i12 = this.limit;
                        } else {
                            if (c11 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i14;
                            }
                            i11 = i14;
                        }
                    }
                }
            }
            if (sb2 == null) {
                sb2 = new StringBuilder(Math.max((i11 - i10) * 2, 16));
            }
            sb2.append(cArr, i10, i11 - i10);
            this.pos = i11;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String nextUnquotedValue() throws IOException {
        String string;
        StringBuilder sb2 = null;
        int i10 = 0;
        while (true) {
            int i11 = 0;
            while (true) {
                int i12 = this.pos;
                if (i12 + i11 < this.limit) {
                    char c10 = this.buffer[i12 + i11];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case ms.a.T /* 91 */:
                                                case ms.a.U /* 93 */:
                                                    break;
                                                case ms.a.W /* 92 */:
                                                    break;
                                                default:
                                                    i11++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    i10 = i11;
                } else if (i11 >= this.buffer.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i11, 16));
                    }
                    sb2.append(this.buffer, this.pos, i11);
                    this.pos += i11;
                    if (!fillBuffer(1)) {
                    }
                } else if (!fillBuffer(i11 + 1)) {
                    i10 = i11;
                }
                if (sb2 == null) {
                    string = new String(this.buffer, this.pos, i10);
                } else {
                    sb2.append(this.buffer, this.pos, i10);
                    string = sb2.toString();
                }
                this.pos += i10;
                return string;
            }
        }
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i10;
        char c10 = this.buffer[this.pos];
        if (c10 == 't' || c10 == 'T') {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = d6.a.E;
            str2 = "NULL";
            i10 = 7;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.pos + i11 >= this.limit && !fillBuffer(i11 + 1)) {
                return 0;
            }
            char c11 = this.buffer[this.pos + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.f3512a = i10;
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00ec  */
    private int peekNumber() throws IOException {
        char c10;
        char c11;
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = this.limit;
        int i12 = 0;
        int i13 = 0;
        char c12 = 0;
        boolean z10 = false;
        boolean z11 = true;
        long j10 = 0;
        while (true) {
            if (i10 + i13 != i11) {
                c10 = cArr[i10 + i13];
                if (c10 != '+') {
                    if (c10 != 'E' || c10 == 'e') {
                        i12 = 0;
                        if (c12 == 2 && c12 != 4) {
                            return 0;
                        }
                        c12 = 5;
                    } else if (c10 != '-') {
                        c11 = 3;
                        if (c10 == '.') {
                            i12 = 0;
                            if (c12 != 2) {
                                return 0;
                            }
                        } else {
                            if (c10 < '0' || c10 > '9') {
                                if (!isLiteral(c10)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c12 == 1 || c12 == 0) {
                                j10 = -(c10 - '0');
                                c12 = 2;
                            } else if (c12 == 2) {
                                if (j10 == 0) {
                                    return 0;
                                }
                                long j11 = (10 * j10) - ((long) (c10 - '0'));
                                z11 &= j10 > -922337203685477580L || (j10 == -922337203685477580L && j11 < j10);
                                j10 = j11;
                            } else if (c12 == 3) {
                                i12 = 0;
                                c12 = 4;
                            } else if (c12 == 5 || c12 == 6) {
                                i12 = 0;
                                c12 = 7;
                            }
                            i12 = 0;
                        }
                    } else {
                        c11 = 6;
                        i12 = 0;
                        if (c12 == 0) {
                            c12 = 1;
                            z10 = true;
                        } else if (c12 != 5) {
                            return 0;
                        }
                    }
                    i13++;
                } else {
                    c11 = 6;
                    i12 = 0;
                    if (c12 != 5) {
                        return 0;
                    }
                }
                c12 = c11;
                i13++;
            } else {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!fillBuffer(i13 + 1)) {
                    break;
                }
                i10 = this.pos;
                i11 = this.limit;
                c10 = cArr[i10 + i13];
                if (c10 != '+') {
                    if (c10 != 'E') {
                        i12 = 0;
                        if (c12 == 2) {
                        }
                        c12 = 5;
                    } else {
                        i12 = 0;
                        if (c12 == 2) {
                        }
                        c12 = 5;
                    }
                    i13++;
                } else {
                    c11 = 6;
                    i12 = 0;
                    if (c12 != 5) {
                        return 0;
                    }
                }
                c12 = c11;
                i13++;
            }
        }
        if (c12 == 2 && z11 && ((j10 != Long.MIN_VALUE || z10) && (j10 != 0 || !z10))) {
            if (!z10) {
                j10 = -j10;
            }
            this.peekedLong = j10;
            this.pos += i13;
            this.f3512a = 15;
            return 15;
        }
        if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        }
        this.peekedNumberLength = i13;
        this.f3512a = 16;
        return 16;
    }

    private void push(int i10) {
        int i11 = this.stackSize;
        int[] iArr = this.stack;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.stack = Arrays.copyOf(iArr, i12);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i12);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i12);
        }
        int[] iArr2 = this.stack;
        int i13 = this.stackSize;
        this.stackSize = i13 + 1;
        iArr2[i13] = i10;
    }

    private char readEscapeCharacter() throws IOException {
        int i10;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i11 = this.pos;
        int i12 = i11 + 1;
        this.pos = i12;
        char c10 = cArr[i11];
        if (c10 == '\n') {
            this.lineNumber++;
            this.lineStart = i12;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return StringUtil.CARRIAGE_RETURN;
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                throw syntaxError("Invalid escape sequence");
            }
            if (i11 + 5 > this.limit && !fillBuffer(4)) {
                throw syntaxError("Unterminated escape sequence");
            }
            int i13 = this.pos;
            int i14 = i13 + 4;
            char c11 = 0;
            while (i13 < i14) {
                char c12 = this.buffer[i13];
                char c13 = (char) (c11 << 4);
                if (c12 >= '0' && c12 <= '9') {
                    i10 = c12 - '0';
                } else if (c12 >= 'a' && c12 <= 'f') {
                    i10 = c12 - 'W';
                } else {
                    if (c12 < 'A' || c12 > 'F') {
                        throw new NumberFormatException("\\u".concat(new String(this.buffer, this.pos, 4)));
                    }
                    i10 = c12 - '7';
                }
                c11 = (char) (i10 + c13);
                i13++;
            }
            this.pos += 4;
            return c11;
        }
        return c10;
    }

    private void skipQuotedValue(char c10) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i10 = this.pos;
            int i11 = this.limit;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.pos = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.pos = i12;
                    readEscapeCharacter();
                    i10 = this.pos;
                    i11 = this.limit;
                } else {
                    if (c11 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i12;
                    }
                    i10 = i12;
                }
            }
            this.pos = i10;
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
            int i10 = this.pos;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.buffer[this.pos + i11] == str.charAt(i11)) {
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i10 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c10;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 + 1;
            this.pos = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.lineNumber++;
                this.lineStart = i11;
                return;
            }
        } while (c10 != '\r');
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i10 = 0;
            while (true) {
                int i11 = this.pos;
                if (i11 + i10 < this.limit) {
                    char c10 = this.buffer[i11 + i10];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case ms.a.T /* 91 */:
                                                case ms.a.U /* 93 */:
                                                    break;
                                                case ms.a.W /* 92 */:
                                                    break;
                                                default:
                                                    i10++;
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
                    this.pos += i10;
                    return;
                }
                this.pos = i11 + i10;
            }
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        StringBuilder sbA = k.a.a(str);
        sbA.append(locationString());
        throw new e(sbA.toString());
    }

    public int b() throws IOException {
        int iNextNonWhitespace;
        int[] iArr = this.stack;
        int i10 = this.stackSize;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iNextNonWhitespace2 = nextNonWhitespace(true);
            if (iNextNonWhitespace2 != 44) {
                if (iNextNonWhitespace2 != 59) {
                    if (iNextNonWhitespace2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.f3512a = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5 && (iNextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (iNextNonWhitespace != 59) {
                        if (iNextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.f3512a = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                if (iNextNonWhitespace3 == 34) {
                    this.f3512a = 13;
                    return 13;
                }
                if (iNextNonWhitespace3 == 39) {
                    checkLenient();
                    this.f3512a = 12;
                    return 12;
                }
                if (iNextNonWhitespace3 == 125) {
                    if (i11 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.f3512a = 2;
                    return 2;
                }
                checkLenient();
                this.pos--;
                if (!isLiteral((char) iNextNonWhitespace3)) {
                    throw syntaxError("Expected name");
                }
                this.f3512a = 14;
                return 14;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                if (iNextNonWhitespace4 != 58) {
                    if (iNextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i12 = this.pos;
                        if (cArr[i12] == '>') {
                            this.pos = i12 + 1;
                        }
                    }
                }
            } else if (i11 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i11 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.f3512a = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iNextNonWhitespace5 = nextNonWhitespace(true);
        if (iNextNonWhitespace5 == 34) {
            this.f3512a = 9;
            return 9;
        }
        if (iNextNonWhitespace5 == 39) {
            checkLenient();
            this.f3512a = 8;
            return 8;
        }
        if (iNextNonWhitespace5 != 44 && iNextNonWhitespace5 != 59) {
            if (iNextNonWhitespace5 == 91) {
                this.f3512a = 3;
                return 3;
            }
            if (iNextNonWhitespace5 != 93) {
                if (iNextNonWhitespace5 == 123) {
                    this.f3512a = 1;
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
                this.f3512a = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f3512a = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos--;
        this.f3512a = 7;
        return 7;
    }

    public void beginArray() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.f3512a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 1) {
            push(3);
            this.f3512a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3512a = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f3513in.close();
    }

    public void endArray() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i10 = this.stackSize;
        this.stackSize = i10 - 1;
        int[] iArr = this.pathIndices;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f3512a = 0;
    }

    public void endObject() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i10 = this.stackSize;
        int i11 = i10 - 1;
        this.stackSize = i11;
        this.pathNames[i11] = null;
        int[] iArr = this.pathIndices;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f3512a = 0;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        return (iB == 2 || iB == 4 || iB == 17) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        StringBuilder sbA = i0.a.a(" at line ", this.lineNumber + 1, " column ", (this.pos - this.lineStart) + 1, " path ");
        sbA.append(getPath());
        return sbA.toString();
    }

    public boolean nextBoolean() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 5) {
            this.f3512a = 0;
            int[] iArr = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iB != 6) {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
        this.f3512a = 0;
        int[] iArr2 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }

    public double nextDouble() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            this.f3512a = 0;
            int[] iArr = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.peekedLong;
        }
        if (iB == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (iB == 8 || iB == 9) {
            this.peekedString = nextQuotedValue(iB == 8 ? '\'' : '\"');
        } else if (iB == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iB != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.f3512a = 11;
        double d10 = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new e("JSON forbids NaN and infinities: " + d10 + locationString());
        }
        this.peekedString = null;
        this.f3512a = 0;
        int[] iArr2 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    public int nextInt() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            long j10 = this.peekedLong;
            int i10 = (int) j10;
            if (j10 != i10) {
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            this.f3512a = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return i10;
        }
        if (iB == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iB != 8 && iB != 9 && iB != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (iB == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iB == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.peekedString);
                this.f3512a = 0;
                int[] iArr2 = this.pathIndices;
                int i13 = this.stackSize - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3512a = 11;
        double d10 = Double.parseDouble(this.peekedString);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.f3512a = 0;
        int[] iArr3 = this.pathIndices;
        int i15 = this.stackSize - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public long nextLong() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            this.f3512a = 0;
            int[] iArr = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.peekedLong;
        }
        if (iB == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iB != 8 && iB != 9 && iB != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (iB == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iB == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.peekedString);
                this.f3512a = 0;
                int[] iArr2 = this.pathIndices;
                int i11 = this.stackSize - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3512a = 11;
        double d10 = Double.parseDouble(this.peekedString);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.f3512a = 0;
        int[] iArr3 = this.pathIndices;
        int i12 = this.stackSize - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String nextName() throws IOException {
        String strNextQuotedValue;
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 14) {
            strNextQuotedValue = nextUnquotedValue();
        } else if (iB == 12) {
            strNextQuotedValue = nextQuotedValue('\'');
        } else {
            if (iB != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            strNextQuotedValue = nextQuotedValue('\"');
        }
        this.f3512a = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    public void nextNull() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 7) {
            throw new IllegalStateException("Expected null but was " + peek() + locationString());
        }
        this.f3512a = 0;
        int[] iArr = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public String nextString() throws IOException {
        String str;
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 10) {
            str = nextUnquotedValue();
        } else if (iB == 8) {
            str = nextQuotedValue('\'');
        } else if (iB == 9) {
            str = nextQuotedValue('\"');
        } else if (iB == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (iB == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (iB != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.f3512a = 0;
        int[] iArr = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public c peek() throws IOException {
        int iB = this.f3512a;
        if (iB == 0) {
            iB = b();
        }
        switch (iB) {
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

    public final void setLenient(boolean z10) {
        this.lenient = z10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void skipValue() throws IOException {
        int i10 = 0;
        do {
            int iB = this.f3512a;
            if (iB == 0) {
                iB = b();
            }
            switch (iB) {
                case 1:
                    push(3);
                    i10++;
                    this.f3512a = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    i10--;
                    this.f3512a = 0;
                    break;
                case 3:
                    push(1);
                    i10++;
                    this.f3512a = 0;
                    break;
                case 4:
                    this.stackSize--;
                    i10--;
                    this.f3512a = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f3512a = 0;
                    break;
                case 8:
                    skipQuotedValue('\'');
                    this.f3512a = 0;
                    break;
                case 9:
                    skipQuotedValue('\"');
                    this.f3512a = 0;
                    break;
                case 10:
                    skipUnquotedValue();
                    this.f3512a = 0;
                    break;
                case 12:
                    skipQuotedValue('\'');
                    if (i10 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f3512a = 0;
                    break;
                case 13:
                    skipQuotedValue('\"');
                    if (i10 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f3512a = 0;
                    break;
                case 14:
                    skipUnquotedValue();
                    if (i10 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.f3512a = 0;
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    this.f3512a = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
