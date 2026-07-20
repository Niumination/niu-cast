package l1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class j {
    public Writer a() throws IOException {
        Writer writerB = b();
        return writerB instanceof BufferedWriter ? (BufferedWriter) writerB : new BufferedWriter(writerB);
    }

    public abstract Writer b() throws IOException;

    public void c(CharSequence charSequence) throws IOException {
        charSequence.getClass();
        n nVarB = n.b();
        try {
            Writer writer = (Writer) nVarB.c(b());
            writer.append(charSequence);
            writer.flush();
            nVarB.close();
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    @t1.a
    public long d(Readable readable) throws IOException {
        readable.getClass();
        n nVarB = n.b();
        try {
            Writer writer = (Writer) nVarB.c(b());
            long jB = l.b(readable, writer);
            writer.flush();
            nVarB.close();
            return jB;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public void e(Iterable<? extends CharSequence> lines) throws IOException {
        f(lines, System.getProperty("line.separator"));
    }

    public void f(Iterable<? extends CharSequence> lines, String lineSeparator) throws IOException {
        lines.getClass();
        lineSeparator.getClass();
        n nVarB = n.b();
        try {
            Writer writer = (Writer) nVarB.c(a());
            Iterator<? extends CharSequence> it = lines.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((CharSequence) lineSeparator);
            }
            writer.flush();
            nVarB.close();
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }
}
