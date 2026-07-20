package y1;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import v1.q;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d2.d {
    private String pendingName;
    private v1.k product;
    private final List<v1.k> stack;
    private static final Writer UNWRITABLE_WRITER = new a();
    private static final q SENTINEL_CLOSED = new q("closed");

    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = v1.m.INSTANCE;
    }

    private v1.k peek() {
        List<v1.k> list = this.stack;
        return list.get(list.size() - 1);
    }

    private void put(v1.k kVar) {
        if (this.pendingName != null) {
            if (!kVar.isJsonNull() || getSerializeNulls()) {
                ((v1.n) peek()).add(this.pendingName, kVar);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = kVar;
            return;
        }
        v1.k kVarPeek = peek();
        if (!(kVarPeek instanceof v1.h)) {
            throw new IllegalStateException();
        }
        ((v1.h) kVarPeek).add(kVar);
    }

    @Override // d2.d
    public d2.d beginArray() throws IOException {
        v1.h hVar = new v1.h();
        put(hVar);
        this.stack.add(hVar);
        return this;
    }

    @Override // d2.d
    public d2.d beginObject() throws IOException {
        v1.n nVar = new v1.n();
        put(nVar);
        this.stack.add(nVar);
        return this;
    }

    @Override // d2.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // d2.d
    public d2.d endArray() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof v1.h)) {
            throw new IllegalStateException();
        }
        List<v1.k> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // d2.d
    public d2.d endObject() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof v1.n)) {
            throw new IllegalStateException();
        }
        List<v1.k> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // d2.d, java.io.Flushable
    public void flush() throws IOException {
    }

    public v1.k get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // d2.d
    public d2.d jsonValue(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // d2.d
    public d2.d name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof v1.n)) {
            throw new IllegalStateException();
        }
        this.pendingName = str;
        return this;
    }

    @Override // d2.d
    public d2.d nullValue() throws IOException {
        put(v1.m.INSTANCE);
        return this;
    }

    @Override // d2.d
    public d2.d value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        put(new q(str));
        return this;
    }

    @Override // d2.d
    public d2.d value(boolean z10) throws IOException {
        put(new q(Boolean.valueOf(z10)));
        return this;
    }

    @Override // d2.d
    public d2.d value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        put(new q(bool));
        return this;
    }

    @Override // d2.d
    public d2.d value(float f10) throws IOException {
        if (!isLenient() && (Float.isNaN(f10) || Float.isInfinite(f10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f10);
        }
        put(new q(Float.valueOf(f10)));
        return this;
    }

    @Override // d2.d
    public d2.d value(double d10) throws IOException {
        if (!isLenient() && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
        }
        put(new q(Double.valueOf(d10)));
        return this;
    }

    @Override // d2.d
    public d2.d value(long j10) throws IOException {
        put(new q(Long.valueOf(j10)));
        return this;
    }

    @Override // d2.d
    public d2.d value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new q(number));
        return this;
    }
}
