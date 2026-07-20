package x4;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import y4.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {
    private c0() {
        throw new UnsupportedOperationException();
    }

    public static v4.u parse(d5.b bVar) throws v4.y {
        boolean z2;
        try {
            try {
                bVar.peek();
                z2 = false;
                try {
                    return (v4.u) n1.JSON_ELEMENT.read(bVar);
                } catch (EOFException e) {
                    e = e;
                    if (z2) {
                        return v4.w.INSTANCE;
                    }
                    throw new v4.a0(e);
                }
            } catch (EOFException e4) {
                e = e4;
                z2 = true;
            }
        } catch (d5.e e10) {
            throw new v4.a0(e10);
        } catch (IOException e11) {
            throw new v4.v(e11);
        } catch (NumberFormatException e12) {
            throw new v4.a0(e12);
        }
    }

    public static void write(v4.u uVar, d5.d dVar) throws IOException {
        n1.JSON_ELEMENT.write(dVar, uVar);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b0(appendable);
    }
}
