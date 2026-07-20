package j1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public final class p {

    public enum a implements o<byte[]> {
        INSTANCE;

        public static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        @Override // j1.o
        public void funnel(byte[] from, j0 into) {
            into.a(from);
        }
    }

    public enum b implements o<Integer> {
        INSTANCE;

        public static /* synthetic */ b[] a() {
            return new b[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        @Override // j1.o
        public void funnel(Integer from, j0 into) {
            into.putInt(from.intValue());
        }
    }

    public enum c implements o<Long> {
        INSTANCE;

        public static /* synthetic */ c[] a() {
            return new c[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        @Override // j1.o
        public void funnel(Long from, j0 into) {
            into.putLong(from.longValue());
        }
    }

    public static class d<E> implements o<Iterable<? extends E>>, Serializable {
        private final o<E> elementFunnel;

        public d(o<E> elementFunnel) {
            elementFunnel.getClass();
            this.elementFunnel = elementFunnel;
        }

        public boolean equals(@gm.a Object o10) {
            if (o10 instanceof d) {
                return this.elementFunnel.equals(((d) o10).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return this.elementFunnel.hashCode() ^ d.class.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }

        @Override // j1.o
        public void funnel(Iterable<? extends E> from, j0 into) {
            Iterator<? extends E> it = from.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), into);
            }
        }
    }

    public static class e extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f8454a;

        public e(j0 sink) {
            sink.getClass();
            this.f8454a = sink;
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.f8454a + ")";
        }

        @Override // java.io.OutputStream
        public void write(int b10) {
            this.f8454a.c((byte) b10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes) {
            this.f8454a.a(bytes);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes, int off, int len) {
            this.f8454a.e(bytes, off, len);
        }
    }

    public static class f implements o<CharSequence>, Serializable {
        private final Charset charset;

        public static class a implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            public a(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return new f(Charset.forName(this.charsetCanonicalName));
            }
        }

        public f(Charset charset) {
            charset.getClass();
            this.charset = charset;
        }

        private void readObject(ObjectInputStream stream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        public boolean equals(@gm.a Object o10) {
            if (o10 instanceof f) {
                return this.charset.equals(((f) o10).charset);
            }
            return false;
        }

        public int hashCode() {
            return this.charset.hashCode() ^ f.class.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        public Object writeReplace() {
            return new a(this.charset);
        }

        @Override // j1.o
        public void funnel(CharSequence from, j0 into) {
            into.g(from, this.charset);
        }
    }

    public enum g implements o<CharSequence> {
        INSTANCE;

        public static /* synthetic */ g[] a() {
            return new g[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        @Override // j1.o
        public void funnel(CharSequence from, j0 into) {
            into.d(from);
        }
    }

    public static OutputStream a(j0 sink) {
        return new e(sink);
    }

    public static o<byte[]> b() {
        return a.INSTANCE;
    }

    public static o<Integer> c() {
        return b.INSTANCE;
    }

    public static o<Long> d() {
        return c.INSTANCE;
    }

    public static <E> o<Iterable<? extends E>> e(o<E> elementFunnel) {
        return new d(elementFunnel);
    }

    public static o<CharSequence> f(Charset charset) {
        return new f(charset);
    }

    public static o<CharSequence> g() {
        return g.INSTANCE;
    }
}
