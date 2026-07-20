package c1;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1255a;

    public class a extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1256b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y prototype, final String val$nullText) {
            super(prototype);
            this.f1256b = val$nullText;
        }

        @Override // c1.y
        public y q() {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // c1.y
        public CharSequence r(@gm.a Object part) {
            return part == null ? this.f1256b : y.this.r(part);
        }

        @Override // c1.y
        public y s(String nullText) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public class b extends y {
        public b(y prototype) {
            super(prototype);
        }

        @Override // c1.y
        public <A extends Appendable> A d(A appendable, Iterator<? extends Object> parts) throws IOException {
            h0.F(appendable, "appendable");
            h0.F(parts, "parts");
            while (parts.hasNext()) {
                Object next = parts.next();
                if (next != null) {
                    appendable.append(y.this.r(next));
                    break;
                }
            }
            while (parts.hasNext()) {
                Object next2 = parts.next();
                if (next2 != null) {
                    appendable.append(y.this.f1255a);
                    appendable.append(y.this.r(next2));
                }
            }
            return appendable;
        }

        @Override // c1.y
        public y s(String nullText) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // c1.y
        public d u(String kvs) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    public class c extends AbstractList<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f1259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f1260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1261c;

        public c(final Object[] val$rest, final Object val$first, final Object val$second) {
            this.f1259a = val$rest;
            this.f1260b = val$first;
            this.f1261c = val$second;
        }

        @Override // java.util.AbstractList, java.util.List
        @gm.a
        public Object get(int index) {
            if (index != 0) {
                return index != 1 ? this.f1259a[index - 2] : this.f1261c;
            }
            return this.f1260b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1259a.length + 2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f1262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1263b;

        public /* synthetic */ d(y yVar, String str, a aVar) {
            this(yVar, str);
        }

        @t1.a
        public <A extends Appendable> A a(A a10, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) b(a10, iterable.iterator());
        }

        @t1.a
        public <A extends Appendable> A b(A appendable, Iterator<? extends Map.Entry<?, ?>> parts) throws IOException {
            appendable.getClass();
            if (parts.hasNext()) {
                Map.Entry<?, ?> next = parts.next();
                appendable.append(this.f1262a.r(next.getKey()));
                appendable.append(this.f1263b);
                appendable.append(this.f1262a.r(next.getValue()));
                while (parts.hasNext()) {
                    appendable.append(this.f1262a.f1255a);
                    Map.Entry<?, ?> next2 = parts.next();
                    appendable.append(this.f1262a.r(next2.getKey()));
                    appendable.append(this.f1263b);
                    appendable.append(this.f1262a.r(next2.getValue()));
                }
            }
            return appendable;
        }

        @t1.a
        public <A extends Appendable> A c(A a10, Map<?, ?> map) throws IOException {
            return (A) a(a10, map.entrySet());
        }

        @t1.a
        public StringBuilder d(StringBuilder builder, Iterable<? extends Map.Entry<?, ?>> entries) {
            return e(builder, entries.iterator());
        }

        @t1.a
        public StringBuilder e(StringBuilder builder, Iterator<? extends Map.Entry<?, ?>> entries) {
            try {
                b(builder, entries);
                return builder;
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @t1.a
        public StringBuilder f(StringBuilder builder, Map<?, ?> map) {
            return d(builder, map.entrySet());
        }

        public String g(Iterable<? extends Map.Entry<?, ?>> entries) {
            return h(entries.iterator());
        }

        public String h(Iterator<? extends Map.Entry<?, ?>> entries) {
            return e(new StringBuilder(), entries).toString();
        }

        public String i(Map<?, ?> map) {
            return g(map.entrySet());
        }

        public d j(String nullText) {
            return new d(this.f1262a.s(nullText), this.f1263b);
        }

        public d(y joiner, String keyValueSeparator) {
            this.f1262a = joiner;
            keyValueSeparator.getClass();
            this.f1263b = keyValueSeparator;
        }
    }

    public /* synthetic */ y(y yVar, a aVar) {
        this(yVar);
    }

    public static Iterable<Object> j(@gm.a Object first, @gm.a Object second, Object[] rest) {
        rest.getClass();
        return new c(rest, first, second);
    }

    public static y o(char separator) {
        return new y(String.valueOf(separator));
    }

    public static y p(String separator) {
        return new y(separator);
    }

    @t1.a
    public <A extends Appendable> A b(A a10, Iterable<? extends Object> iterable) throws IOException {
        return (A) d(a10, iterable.iterator());
    }

    @t1.a
    public final <A extends Appendable> A c(A a10, @gm.a Object obj, @gm.a Object obj2, Object... objArr) throws IOException {
        return (A) b(a10, j(obj, obj2, objArr));
    }

    @t1.a
    public <A extends Appendable> A d(A appendable, Iterator<? extends Object> parts) throws IOException {
        appendable.getClass();
        if (parts.hasNext()) {
            appendable.append(r(parts.next()));
            while (parts.hasNext()) {
                appendable.append(this.f1255a);
                appendable.append(r(parts.next()));
            }
        }
        return appendable;
    }

    @t1.a
    public final <A extends Appendable> A e(A a10, Object[] objArr) throws IOException {
        return (A) b(a10, Arrays.asList(objArr));
    }

    @t1.a
    public final StringBuilder f(StringBuilder builder, Iterable<? extends Object> parts) {
        return h(builder, parts.iterator());
    }

    @t1.a
    public final StringBuilder g(StringBuilder builder, @gm.a Object first, @gm.a Object second, Object... rest) {
        return f(builder, j(first, second, rest));
    }

    @t1.a
    public final StringBuilder h(StringBuilder builder, Iterator<? extends Object> parts) {
        try {
            d(builder, parts);
            return builder;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @t1.a
    public final StringBuilder i(StringBuilder builder, Object[] parts) {
        return f(builder, Arrays.asList(parts));
    }

    public final String k(Iterable<? extends Object> parts) {
        return m(parts.iterator());
    }

    public final String l(@gm.a Object first, @gm.a Object second, Object... rest) {
        return k(j(first, second, rest));
    }

    public final String m(Iterator<? extends Object> parts) {
        return h(new StringBuilder(), parts).toString();
    }

    public final String n(Object[] parts) {
        return k(Arrays.asList(parts));
    }

    public y q() {
        return new b(this);
    }

    public CharSequence r(@gm.a Object part) {
        Objects.requireNonNull(part);
        return part instanceof CharSequence ? (CharSequence) part : part.toString();
    }

    public y s(String nullText) {
        nullText.getClass();
        return new a(this, nullText);
    }

    public d t(char keyValueSeparator) {
        return u(String.valueOf(keyValueSeparator));
    }

    public d u(String keyValueSeparator) {
        return new d(this, keyValueSeparator);
    }

    public y(String separator) {
        separator.getClass();
        this.f1255a = separator;
    }

    public y(y prototype) {
        this.f1255a = prototype.f1255a;
    }
}
