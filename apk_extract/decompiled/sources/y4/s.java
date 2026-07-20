package y4;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends d5.d {
    private String pendingName;
    private v4.u product;
    private final List<v4.u> stack;
    private static final Writer UNWRITABLE_WRITER = new r();
    private static final v4.z SENTINEL_CLOSED = new v4.z("closed");

    public s() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = v4.w.INSTANCE;
    }

    private v4.u peek() {
        return (v4.u) a1.a.j(1, this.stack);
    }

    private void put(v4.u uVar) {
        if (this.pendingName != null) {
            if (!uVar.isJsonNull() || getSerializeNulls()) {
                ((v4.x) peek()).add(this.pendingName, uVar);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = uVar;
            return;
        }
        v4.u uVarPeek = peek();
        if (!(uVarPeek instanceof v4.t)) {
            throw new IllegalStateException();
        }
        ((v4.t) uVarPeek).add(uVar);
    }

    @Override // d5.d
    public d5.d beginArray() throws IOException {
        v4.t tVar = new v4.t();
        put(tVar);
        this.stack.add(tVar);
        return this;
    }

    @Override // d5.d
    public d5.d beginObject() throws IOException {
        v4.x xVar = new v4.x();
        put(xVar);
        this.stack.add(xVar);
        return this;
    }

    @Override // d5.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // d5.d
    public d5.d endArray() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof v4.t)) {
            throw new IllegalStateException();
        }
        List<v4.u> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // d5.d
    public d5.d endObject() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof v4.x)) {
            throw new IllegalStateException();
        }
        List<v4.u> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // d5.d, java.io.Flushable
    public void flush() throws IOException {
    }

    public v4.u get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // d5.d
    public d5.d jsonValue(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // d5.d
    public d5.d name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(peek() instanceof v4.x)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.pendingName = str;
        return this;
    }

    @Override // d5.d
    public d5.d nullValue() throws IOException {
        put(v4.w.INSTANCE);
        return this;
    }

    @Override // d5.d
    public d5.d value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        put(new v4.z(str));
        return this;
    }

    @Override // d5.d
    public d5.d value(boolean z2) throws IOException {
        put(new v4.z(Boolean.valueOf(z2)));
        return this;
    }

    @Override // d5.d
    public d5.d value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        put(new v4.z(bool));
        return this;
    }

    @Override // d5.d
    public d5.d value(float f) throws IOException {
        if (!isLenient() && (Float.isNaN(f) || Float.isInfinite(f))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f);
        }
        put(new v4.z(Float.valueOf(f)));
        return this;
    }

    @Override // d5.d
    public d5.d value(double d7) throws IOException {
        if (!isLenient() && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d7);
        }
        put(new v4.z(Double.valueOf(d7)));
        return this;
    }

    @Override // d5.d
    public d5.d value(long j8) throws IOException {
        put(new v4.z(Long.valueOf(j8)));
        return this;
    }

    @Override // d5.d
    public d5.d value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new v4.z(number));
        return this;
    }
}
