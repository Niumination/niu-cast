package v4;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class p0 {
    public final Object fromJson(Reader reader) throws IOException {
        return read(new d5.b(reader));
    }

    public final Object fromJsonTree(u uVar) {
        try {
            return read(new y4.q(uVar));
        } catch (IOException e) {
            throw new v(e);
        }
    }

    public final p0 nullSafe() {
        return !(this instanceof o0) ? new o0(this) : this;
    }

    public abstract Object read(d5.b bVar) throws IOException;

    public final void toJson(Writer writer, Object obj) throws IOException {
        write(new d5.d(writer), obj);
    }

    public final u toJsonTree(Object obj) {
        try {
            y4.s sVar = new y4.s();
            write(sVar, obj);
            return sVar.get();
        } catch (IOException e) {
            throw new v(e);
        }
    }

    public abstract void write(d5.d dVar, Object obj) throws IOException;

    public final Object fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new v(e);
        }
    }
}
