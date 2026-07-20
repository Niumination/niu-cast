package y1;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import v1.q;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d2.a {
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;
    private static final Reader UNREADABLE_READER = new a();
    private static final Object SENTINEL_CLOSED = new Object();

    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20619a;

        static {
            int[] iArr = new int[d2.c.values().length];
            f20619a = iArr;
            try {
                iArr[d2.c.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20619a[d2.c.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20619a[d2.c.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20619a[d2.c.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(v1.k kVar) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(kVar);
    }

    private void expect(d2.c cVar) throws IOException {
        if (peek() == cVar) {
            return;
        }
        throw new IllegalStateException("Expected " + cVar + " but was " + peek() + locationString());
    }

    private String getPath(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.stackSize;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.stack;
            Object obj = objArr[i10];
            if (obj instanceof v1.h) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.pathIndices[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append(ks.a.f9445d);
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof v1.n) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append(n1.e.f11183c);
                String str = this.pathNames[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private String nextName(boolean z10) throws IOException {
        expect(d2.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = z10 ? "<skipped>" : str;
        push(entry.getValue());
        return str;
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] objArr = this.stack;
        int i10 = this.stackSize - 1;
        this.stackSize = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private void push(Object obj) {
        int i10 = this.stackSize;
        Object[] objArr = this.stack;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.stack = Arrays.copyOf(objArr, i11);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i11);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i11);
        }
        Object[] objArr2 = this.stack;
        int i12 = this.stackSize;
        this.stackSize = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // d2.a
    public void beginArray() throws IOException {
        expect(d2.c.BEGIN_ARRAY);
        push(((v1.h) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // d2.a
    public void beginObject() throws IOException {
        expect(d2.c.BEGIN_OBJECT);
        push(((v1.n) peekStack()).entrySet().iterator());
    }

    public v1.k c() throws IOException {
        d2.c cVarPeek = peek();
        if (cVarPeek != d2.c.NAME && cVarPeek != d2.c.END_ARRAY && cVarPeek != d2.c.END_OBJECT && cVarPeek != d2.c.END_DOCUMENT) {
            v1.k kVar = (v1.k) peekStack();
            skipValue();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + cVarPeek + " when reading a JsonElement.");
    }

    @Override // d2.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // d2.a
    public void endArray() throws IOException {
        expect(d2.c.END_ARRAY);
        popStack();
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // d2.a
    public void endObject() throws IOException {
        expect(d2.c.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // d2.a
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // d2.a
    public boolean hasNext() throws IOException {
        d2.c cVarPeek = peek();
        return (cVarPeek == d2.c.END_OBJECT || cVarPeek == d2.c.END_ARRAY || cVarPeek == d2.c.END_DOCUMENT) ? false : true;
    }

    @Override // d2.a
    public boolean nextBoolean() throws IOException {
        expect(d2.c.BOOLEAN);
        boolean asBoolean = ((q) popStack()).getAsBoolean();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asBoolean;
    }

    @Override // d2.a
    public double nextDouble() throws IOException {
        d2.c cVarPeek = peek();
        d2.c cVar = d2.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d2.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        double asDouble = ((q) peekStack()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new d2.e("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asDouble;
    }

    @Override // d2.a
    public int nextInt() throws IOException {
        d2.c cVarPeek = peek();
        d2.c cVar = d2.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d2.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        int asInt = ((q) peekStack()).getAsInt();
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asInt;
    }

    @Override // d2.a
    public long nextLong() throws IOException {
        d2.c cVarPeek = peek();
        d2.c cVar = d2.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d2.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        long asLong = ((q) peekStack()).getAsLong();
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asLong;
    }

    @Override // d2.a
    public void nextNull() throws IOException {
        expect(d2.c.NULL);
        popStack();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // d2.a
    public String nextString() throws IOException {
        d2.c cVarPeek = peek();
        d2.c cVar = d2.c.STRING;
        if (cVarPeek != cVar && cVarPeek != d2.c.NUMBER) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        String asString = ((q) popStack()).getAsString();
        int i10 = this.stackSize;
        if (i10 > 0) {
            int[] iArr = this.pathIndices;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asString;
    }

    @Override // d2.a
    public d2.c peek() throws IOException {
        if (this.stackSize == 0) {
            return d2.c.END_DOCUMENT;
        }
        Object objPeekStack = peekStack();
        if (objPeekStack instanceof Iterator) {
            boolean z10 = this.stack[this.stackSize - 2] instanceof v1.n;
            Iterator it = (Iterator) objPeekStack;
            if (!it.hasNext()) {
                return z10 ? d2.c.END_OBJECT : d2.c.END_ARRAY;
            }
            if (z10) {
                return d2.c.NAME;
            }
            push(it.next());
            return peek();
        }
        if (objPeekStack instanceof v1.n) {
            return d2.c.BEGIN_OBJECT;
        }
        if (objPeekStack instanceof v1.h) {
            return d2.c.BEGIN_ARRAY;
        }
        if (objPeekStack instanceof q) {
            q qVar = (q) objPeekStack;
            if (qVar.isString()) {
                return d2.c.STRING;
            }
            if (qVar.isBoolean()) {
                return d2.c.BOOLEAN;
            }
            if (qVar.isNumber()) {
                return d2.c.NUMBER;
            }
            throw new AssertionError();
        }
        if (objPeekStack instanceof v1.m) {
            return d2.c.NULL;
        }
        if (objPeekStack == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new d2.e("Custom JsonElement subclass " + objPeekStack.getClass().getName() + " is not supported");
    }

    public void promoteNameToValue() throws IOException {
        expect(d2.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        push(entry.getValue());
        push(new q((String) entry.getKey()));
    }

    @Override // d2.a
    public void skipValue() throws IOException {
        int i10 = b.f20619a[peek().ordinal()];
        if (i10 == 1) {
            nextName(true);
            return;
        }
        if (i10 == 2) {
            endArray();
            return;
        }
        if (i10 == 3) {
            endObject();
            return;
        }
        if (i10 != 4) {
            popStack();
            int i11 = this.stackSize;
            if (i11 > 0) {
                int[] iArr = this.pathIndices;
                int i12 = i11 - 1;
                iArr[i12] = iArr[i12] + 1;
            }
        }
    }

    @Override // d2.a
    public String toString() {
        return f.class.getSimpleName() + locationString();
    }

    @Override // d2.a
    public String nextName() throws IOException {
        return nextName(false);
    }

    @Override // d2.a
    public String getPath() {
        return getPath(false);
    }
}
