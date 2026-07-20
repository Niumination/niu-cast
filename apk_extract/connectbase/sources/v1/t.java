package v1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterator<k> {
    private final Object lock;
    private final d2.a parser;

    public t(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z10;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z10 = this.parser.peek() != d2.c.END_DOCUMENT;
                    } catch (IOException e10) {
                        throw new l(e10);
                    }
                } catch (d2.e e11) {
                    throw new u(e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public t(Reader reader) {
        d2.a aVar = new d2.a(reader);
        this.parser = aVar;
        aVar.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator
    public k next() throws o {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return x1.o.parse(this.parser);
        } catch (OutOfMemoryError e10) {
            throw new o("Failed parsing JSON source to Json", e10);
        } catch (StackOverflowError e11) {
            throw new o("Failed parsing JSON source to Json", e11);
        }
    }
}
