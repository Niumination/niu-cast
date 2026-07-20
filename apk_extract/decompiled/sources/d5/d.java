package d5;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import v4.h0;
import v4.l;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private String deferredName;
    private String formattedColon;
    private String formattedComma;
    private l formattingStyle;
    private boolean htmlSafe;
    private final Writer out;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;
    private h0 strictness;
    private boolean usesEmptyNewlineAndIndent;
    private static final Pattern VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] REPLACEMENT_CHARS = new String[128];

    static {
        for (int i8 = 0; i8 <= 31; i8++) {
            REPLACEMENT_CHARS[i8] = String.format("\\u%04x", Integer.valueOf(i8));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        push(6);
        this.strictness = h0.LEGACY_STRICT;
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
        setFormattingStyle(l.COMPACT);
    }

    private static boolean alwaysCreatesValidJsonNumber(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void beforeName() throws IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.out.write(this.formattedComma);
        } else if (iPeek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            replaceTop(2);
            newline();
            return;
        }
        if (iPeek == 2) {
            this.out.append((CharSequence) this.formattedComma);
            newline();
        } else {
            if (iPeek == 4) {
                this.out.append((CharSequence) this.formattedColon);
                replaceTop(5);
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.strictness != h0.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
        }
    }

    private d closeScope(int i8, int i9, char c9) throws IOException {
        int iPeek = peek();
        if (iPeek != i9 && iPeek != i8) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stackSize--;
        if (iPeek == i9) {
            newline();
        }
        this.out.write(c9);
        return this;
    }

    private void newline() throws IOException {
        if (this.usesEmptyNewlineAndIndent) {
            return;
        }
        this.out.write(this.formattingStyle.getNewline());
        int i8 = this.stackSize;
        for (int i9 = 1; i9 < i8; i9++) {
            this.out.write(this.formattingStyle.getIndent());
        }
    }

    private d openScope(int i8, char c9) throws IOException {
        beforeValue();
        push(i8);
        this.out.write(c9);
        return this;
    }

    private int peek() {
        int i8 = this.stackSize;
        if (i8 != 0) {
            return this.stack[i8 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i8) {
        int i9 = this.stackSize;
        int[] iArr = this.stack;
        if (i9 == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i9 * 2);
        }
        int[] iArr2 = this.stack;
        int i10 = this.stackSize;
        this.stackSize = i10 + 1;
        iArr2[i10] = i8;
    }

    private void replaceTop(int i8) {
        this.stack[this.stackSize - 1] = i8;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void string(String str) throws IOException {
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write(34);
        int length = str.length();
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i8 < i9) {
                        this.out.write(str, i8, i9 - i8);
                    }
                    this.out.write(str2);
                    i8 = i9 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i8 < i9) {
                    this.out.write(str, i8, i9 - i8);
                }
                this.out.write(str2);
                i8 = i9 + 1;
            }
        }
        if (i8 < length) {
            this.out.write(str, i8, length - i8);
        }
        this.out.write(34);
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public d beginArray() throws IOException {
        writeDeferredName();
        return openScope(1, '[');
    }

    public d beginObject() throws IOException {
        writeDeferredName();
        return openScope(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i8 = this.stackSize;
        if (i8 > 1 || (i8 == 1 && this.stack[i8 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public d endArray() throws IOException {
        return closeScope(1, 2, ']');
    }

    public d endObject() throws IOException {
        return closeScope(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public final l getFormattingStyle() {
        return this.formattingStyle;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final h0 getStrictness() {
        return this.strictness;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.strictness == h0.LENIENT;
    }

    public d jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public d name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.deferredName != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iPeek = peek();
        if (iPeek != 3 && iPeek != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.deferredName = str;
        return this;
    }

    public d nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setFormattingStyle(l lVar) {
        Objects.requireNonNull(lVar);
        this.formattingStyle = lVar;
        this.formattedComma = ",";
        if (lVar.usesSpaceAfterSeparators()) {
            this.formattedColon = ": ";
            if (this.formattingStyle.getNewline().isEmpty()) {
                this.formattedComma = ", ";
            }
        } else {
            this.formattedColon = ":";
        }
        this.usesEmptyNewlineAndIndent = this.formattingStyle.getNewline().isEmpty() && this.formattingStyle.getIndent().isEmpty();
    }

    public final void setHtmlSafe(boolean z2) {
        this.htmlSafe = z2;
    }

    public final void setIndent(String str) {
        if (str.isEmpty()) {
            setFormattingStyle(l.COMPACT);
        } else {
            setFormattingStyle(l.PRETTY.withIndent(str));
        }
    }

    @Deprecated
    public final void setLenient(boolean z2) {
        setStrictness(z2 ? h0.LENIENT : h0.LEGACY_STRICT);
    }

    public final void setSerializeNulls(boolean z2) {
        this.serializeNulls = z2;
    }

    public final void setStrictness(h0 h0Var) {
        Objects.requireNonNull(h0Var);
        this.strictness = h0Var;
    }

    public d value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public d value(boolean z2) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z2 ? "true" : "false");
        return this;
    }

    public d value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public d value(float f) throws IOException {
        writeDeferredName();
        if (this.strictness != h0.LENIENT && (Float.isNaN(f) || Float.isInfinite(f))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f);
        }
        beforeValue();
        this.out.append((CharSequence) Float.toString(f));
        return this;
    }

    public d value(double d7) throws IOException {
        writeDeferredName();
        if (this.strictness != h0.LENIENT && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d7);
        }
        beforeValue();
        this.out.append((CharSequence) Double.toString(d7));
        return this;
    }

    public d value(long j8) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j8));
        return this;
    }

    public d value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!alwaysCreatesValidJsonNumber(cls)) {
            if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
                if (cls != Float.class && cls != Double.class && !VALID_JSON_NUMBER_PATTERN.matcher(string).matches()) {
                    throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
                }
            } else if (this.strictness != h0.LENIENT) {
                throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
            }
        }
        beforeValue();
        this.out.append((CharSequence) string);
        return this;
    }
}
