package dn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements gq.m<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final BufferedReader f3792a;

    public static final class a implements Iterator<String>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public String f3793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3794b;

        public a() {
        }

        @Override // java.util.Iterator
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f3793a;
            this.f3793a = null;
            l0.m(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f3793a == null && !this.f3794b) {
                String line = s.this.f3792a.readLine();
                this.f3793a = line;
                if (line == null) {
                    this.f3794b = true;
                }
            }
            return this.f3793a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public s(@os.l BufferedReader bufferedReader) {
        l0.p(bufferedReader, "reader");
        this.f3792a = bufferedReader;
    }

    @Override // gq.m
    @os.l
    public Iterator<String> iterator() {
        return new a();
    }
}
