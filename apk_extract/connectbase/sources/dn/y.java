package dn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1313#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
@in.i(name = "TextStreamsKt")
public final class y {

    public static final class a extends n0 implements jn.l<String, l2> {
        final /* synthetic */ ArrayList<String> $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ArrayList<String> arrayList) {
            super(1);
            this.$result = arrayList;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(String str) {
            invoke2(str);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str) {
            l0.p(str, "it");
            this.$result.add(str);
        }
    }

    @an.f
    public static final BufferedReader a(Reader reader, int i10) {
        l0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i10);
    }

    @an.f
    public static final BufferedWriter b(Writer writer, int i10) {
        l0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i10);
    }

    public static /* synthetic */ BufferedReader c(Reader reader, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        l0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i10);
    }

    public static /* synthetic */ BufferedWriter d(Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8192;
        }
        l0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i10);
    }

    public static final long e(@os.l Reader reader, @os.l Writer writer, int i10) throws IOException {
        l0.p(reader, "<this>");
        l0.p(writer, "out");
        char[] cArr = new char[i10];
        int i11 = reader.read(cArr);
        long j10 = 0;
        while (i11 >= 0) {
            writer.write(cArr, 0, i11);
            j10 += (long) i11;
            i11 = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return e(reader, writer, i10);
    }

    public static final void g(@os.l Reader reader, @os.l jn.l<? super String, l2> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(reader, "<this>");
        l0.p(lVar, k4.f.f8937e);
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = h(bufferedReader).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            c.a(bufferedReader, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(bufferedReader, th2);
                throw th3;
            }
        }
    }

    @os.l
    public static final gq.m<String> h(@os.l BufferedReader bufferedReader) {
        l0.p(bufferedReader, "<this>");
        return gq.s.f(new s(bufferedReader));
    }

    @os.l
    public static final byte[] i(@os.l URL url) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(url, "<this>");
        InputStream inputStreamOpenStream = url.openStream();
        try {
            l0.m(inputStreamOpenStream);
            byte[] bArrP = b.p(inputStreamOpenStream);
            c.a(inputStreamOpenStream, null);
            return bArrP;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(inputStreamOpenStream, th2);
                throw th3;
            }
        }
    }

    @os.l
    public static final List<String> j(@os.l Reader reader) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        g(reader, new a(arrayList));
        return arrayList;
    }

    @os.l
    public static final String k(@os.l Reader reader) {
        l0.p(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        f(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    @an.f
    public static final String l(URL url, Charset charset) {
        l0.p(url, "<this>");
        l0.p(charset, "charset");
        return new String(i(url), charset);
    }

    public static /* synthetic */ String m(URL url, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(url, "<this>");
        l0.p(charset, "charset");
        return new String(i(url), charset);
    }

    @an.f
    public static final StringReader n(String str) {
        l0.p(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T o(@os.l Reader reader, @os.l jn.l<? super gq.m<String>, ? extends T> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(reader, "<this>");
        l0.p(lVar, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T tInvoke = lVar.invoke(h(bufferedReader));
            if (an.m.a(1, 1, 0)) {
                c.a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            return tInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    c.a(bufferedReader, th2);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }
}
