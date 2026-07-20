package gl;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import kn.l0;
import lm.a1;
import lm.l2;
import os.m;
import pl.n;
import pl.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    @os.l
    public static final BufferedWriter a(@os.l n nVar, @os.l Charset charset) {
        l0.p(nVar, "<this>");
        l0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(yl.b.h(nVar, null, 1, null), charset), 8192);
    }

    public static /* synthetic */ BufferedWriter b(n nVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return a(nVar, charset);
    }

    @m
    @lm.k(message = "This is going to be removed or renamed.", replaceWith = @a1(expression = "writeFully(string.toByteArray(charset))", imports = {"io.ktor.utils.io.writeFully"}))
    public static final Object c(@os.l n nVar, @os.l String str, @os.l Charset charset, @os.l um.d<? super l2> dVar) {
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        Object objF = o.f(nVar, bytes, dVar);
        return objF == wm.a.COROUTINE_SUSPENDED ? objF : l2.f10208a;
    }

    public static /* synthetic */ Object d(n nVar, String str, Charset charset, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        return c(nVar, str, charset, dVar);
    }

    @os.l
    public static final Writer e(@os.l n nVar, @os.l Charset charset) {
        l0.p(nVar, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(yl.b.h(nVar, null, 1, null), charset);
    }

    public static /* synthetic */ Writer f(n nVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return e(nVar, charset);
    }
}
