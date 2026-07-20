package v1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class z<T> {

    public class a extends z<T> {
        public a() {
        }

        @Override // v1.z
        public T read(d2.a aVar) throws IOException {
            if (aVar.peek() != d2.c.NULL) {
                return (T) z.this.read(aVar);
            }
            aVar.nextNull();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, T t10) throws IOException {
            if (t10 == null) {
                dVar.nullValue();
            } else {
                z.this.write(dVar, t10);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new d2.a(reader));
    }

    public final T fromJsonTree(k kVar) {
        try {
            return read(new y1.f(kVar));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public final z<T> nullSafe() {
        return new a();
    }

    public abstract T read(d2.a aVar) throws IOException;

    public final void toJson(Writer writer, T t10) throws IOException {
        write(new d2.d(writer), t10);
    }

    public final k toJsonTree(T t10) {
        try {
            y1.g gVar = new y1.g();
            write(gVar, t10);
            return gVar.get();
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public abstract void write(d2.d dVar, T t10) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t10) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t10);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new l(e10);
        }
    }
}
