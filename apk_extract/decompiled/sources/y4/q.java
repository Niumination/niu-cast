package y4;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends d5.b {
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;
    private static final Reader UNREADABLE_READER = new o();
    private static final Object SENTINEL_CLOSED = new Object();

    public q(v4.u uVar) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(uVar);
    }

    private void expect(d5.c cVar) throws IOException {
        if (peek() == cVar) {
            return;
        }
        throw new IllegalStateException("Expected " + cVar + " but was " + peek() + locationString());
    }

    private String getPath(boolean z2) {
        StringBuilder sb2 = new StringBuilder("$");
        int i8 = 0;
        while (true) {
            int i9 = this.stackSize;
            if (i8 >= i9) {
                return sb2.toString();
            }
            Object[] objArr = this.stack;
            Object obj = objArr[i8];
            if (obj instanceof v4.t) {
                i8++;
                if (i8 < i9 && (objArr[i8] instanceof Iterator)) {
                    int i10 = this.pathIndices[i8];
                    if (z2 && i10 > 0 && (i8 == i9 - 1 || i8 == i9 - 2)) {
                        i10--;
                    }
                    sb2.append('[');
                    sb2.append(i10);
                    sb2.append(']');
                }
            } else if ((obj instanceof v4.x) && (i8 = i8 + 1) < i9 && (objArr[i8] instanceof Iterator)) {
                sb2.append('.');
                String str = this.pathNames[i8];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i8++;
        }
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private String nextName(boolean z2) throws IOException {
        expect(d5.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = z2 ? "<skipped>" : str;
        push(entry.getValue());
        return str;
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] objArr = this.stack;
        int i8 = this.stackSize - 1;
        this.stackSize = i8;
        Object obj = objArr[i8];
        objArr[i8] = null;
        return obj;
    }

    private void push(Object obj) {
        int i8 = this.stackSize;
        Object[] objArr = this.stack;
        if (i8 == objArr.length) {
            int i9 = i8 * 2;
            this.stack = Arrays.copyOf(objArr, i9);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i9);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i9);
        }
        Object[] objArr2 = this.stack;
        int i10 = this.stackSize;
        this.stackSize = i10 + 1;
        objArr2[i10] = obj;
    }

    @Override // d5.b
    public void beginArray() throws IOException {
        expect(d5.c.BEGIN_ARRAY);
        push(((v4.t) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // d5.b
    public void beginObject() throws IOException {
        expect(d5.c.BEGIN_OBJECT);
        push(((v4.x) peekStack()).entrySet().iterator());
    }

    @Override // d5.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // d5.b
    public void endArray() throws IOException {
        expect(d5.c.END_ARRAY);
        popStack();
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // d5.b
    public void endObject() throws IOException {
        expect(d5.c.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    public final v4.u g() throws IOException {
        d5.c cVarPeek = peek();
        if (cVarPeek != d5.c.NAME && cVarPeek != d5.c.END_ARRAY && cVarPeek != d5.c.END_OBJECT && cVarPeek != d5.c.END_DOCUMENT) {
            v4.u uVar = (v4.u) peekStack();
            skipValue();
            return uVar;
        }
        throw new IllegalStateException("Unexpected " + cVarPeek + " when reading a JsonElement.");
    }

    @Override // d5.b
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // d5.b
    public boolean hasNext() throws IOException {
        d5.c cVarPeek = peek();
        return (cVarPeek == d5.c.END_OBJECT || cVarPeek == d5.c.END_ARRAY || cVarPeek == d5.c.END_DOCUMENT) ? false : true;
    }

    @Override // d5.b
    public boolean nextBoolean() throws IOException {
        expect(d5.c.BOOLEAN);
        boolean asBoolean = ((v4.z) popStack()).getAsBoolean();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return asBoolean;
    }

    @Override // d5.b
    public double nextDouble() throws IOException {
        d5.c cVarPeek = peek();
        d5.c cVar = d5.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d5.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        double asDouble = ((v4.z) peekStack()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new d5.e("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return asDouble;
    }

    @Override // d5.b
    public int nextInt() throws IOException {
        d5.c cVarPeek = peek();
        d5.c cVar = d5.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d5.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        int asInt = ((v4.z) peekStack()).getAsInt();
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return asInt;
    }

    @Override // d5.b
    public long nextLong() throws IOException {
        d5.c cVarPeek = peek();
        d5.c cVar = d5.c.NUMBER;
        if (cVarPeek != cVar && cVarPeek != d5.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        long asLong = ((v4.z) peekStack()).getAsLong();
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return asLong;
    }

    @Override // d5.b
    public void nextNull() throws IOException {
        expect(d5.c.NULL);
        popStack();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // d5.b
    public String nextString() throws IOException {
        d5.c cVarPeek = peek();
        d5.c cVar = d5.c.STRING;
        if (cVarPeek != cVar && cVarPeek != d5.c.NUMBER) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarPeek + locationString());
        }
        String asString = ((v4.z) popStack()).getAsString();
        int i8 = this.stackSize;
        if (i8 > 0) {
            int[] iArr = this.pathIndices;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return asString;
    }

    @Override // d5.b
    public d5.c peek() throws IOException {
        if (this.stackSize == 0) {
            return d5.c.END_DOCUMENT;
        }
        Object objPeekStack = peekStack();
        if (objPeekStack instanceof Iterator) {
            boolean z2 = this.stack[this.stackSize - 2] instanceof v4.x;
            Iterator it = (Iterator) objPeekStack;
            if (!it.hasNext()) {
                return z2 ? d5.c.END_OBJECT : d5.c.END_ARRAY;
            }
            if (z2) {
                return d5.c.NAME;
            }
            push(it.next());
            return peek();
        }
        if (objPeekStack instanceof v4.x) {
            return d5.c.BEGIN_OBJECT;
        }
        if (objPeekStack instanceof v4.t) {
            return d5.c.BEGIN_ARRAY;
        }
        if (objPeekStack instanceof v4.z) {
            v4.z zVar = (v4.z) objPeekStack;
            if (zVar.isString()) {
                return d5.c.STRING;
            }
            if (zVar.isBoolean()) {
                return d5.c.BOOLEAN;
            }
            if (zVar.isNumber()) {
                return d5.c.NUMBER;
            }
            throw new AssertionError();
        }
        if (objPeekStack instanceof v4.w) {
            return d5.c.NULL;
        }
        if (objPeekStack == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new d5.e("Custom JsonElement subclass " + objPeekStack.getClass().getName() + " is not supported");
    }

    public void promoteNameToValue() throws IOException {
        expect(d5.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        push(entry.getValue());
        push(new v4.z((String) entry.getKey()));
    }

    @Override // d5.b
    public void skipValue() throws IOException {
        int i8 = p.f11065a[peek().ordinal()];
        if (i8 == 1) {
            nextName(true);
            return;
        }
        if (i8 == 2) {
            endArray();
            return;
        }
        if (i8 == 3) {
            endObject();
            return;
        }
        if (i8 != 4) {
            popStack();
            int i9 = this.stackSize;
            if (i9 > 0) {
                int[] iArr = this.pathIndices;
                int i10 = i9 - 1;
                iArr[i10] = iArr[i10] + 1;
            }
        }
    }

    @Override // d5.b
    public String toString() {
        return q.class.getSimpleName() + locationString();
    }

    @Override // d5.b
    public String nextName() throws IOException {
        return nextName(false);
    }

    @Override // d5.b
    public String getPath() {
        return getPath(false);
    }
}
