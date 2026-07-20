package fn;

import dn.y;
import gq.v;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import lm.f1;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n1#2:327\n1#2:329\n52#3:328\n1313#4,2:330\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n202#1:329\n202#1:328\n202#1:330,2\n*E\n"})
public class r {
    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path A(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(iterable, "lines");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        Path pathWrite = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path B(Path path, gq.m mVar, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(mVar, "lines");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        Path pathWrite = Files.write(path, v.N(mVar), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path C(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(iterable, "lines");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        Path pathWrite = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static final void D(@os.l Path path, @os.l CharSequence charSequence, @os.l Charset charset, @os.l OpenOption... openOptionArr) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(charSequence, "text");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(outputStreamNewOutputStream, "newOutputStream(...)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(charSequence);
            dn.c.a(outputStreamWriter, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(outputStreamWriter, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final OutputStreamWriter F(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    public static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final void a(Path path, byte[] bArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(bArr, dc.d.f3685p);
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path b(Path path, gq.m<? extends CharSequence> mVar, Charset charset) throws IOException {
        l0.p(path, "<this>");
        l0.p(mVar, "lines");
        l0.p(charset, "charset");
        Path pathWrite = Files.write(path, v.N(mVar), charset, StandardOpenOption.APPEND);
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path c(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        l0.p(path, "<this>");
        l0.p(iterable, "lines");
        l0.p(charset, "charset");
        Path pathWrite = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path d(Path path, gq.m mVar, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(mVar, "lines");
        l0.p(charset, "charset");
        Path pathWrite = Files.write(path, v.N(mVar), charset, StandardOpenOption.APPEND);
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path e(Path path, Iterable iterable, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(iterable, "lines");
        l0.p(charset, "charset");
        Path pathWrite = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static final void f(@os.l Path path, @os.l CharSequence charSequence, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(charSequence, "text");
        l0.p(charset, "charset");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, StandardOpenOption.APPEND);
        l0.o(outputStreamNewOutputStream, "newOutputStream(...)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(charSequence);
            dn.c.a(outputStreamWriter, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(outputStreamWriter, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        f(path, charSequence, charset);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final BufferedReader h(Path path, Charset charset, int i10, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i10);
    }

    public static /* synthetic */ BufferedReader i(Path path, Charset charset, int i10, OpenOption[] openOptionArr, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final BufferedWriter j(Path path, Charset charset, int i10, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i10);
    }

    public static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i10, OpenOption[] openOptionArr, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i10);
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final void l(Path path, Charset charset, jn.l<? super String, l2> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, k4.f.f8937e);
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        l0.o(bufferedReaderNewBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = y.h(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            if (an.m.a(1, 1, 0)) {
                dn.c.a(bufferedReaderNewBufferedReader, null);
            } else {
                bufferedReaderNewBufferedReader.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(bufferedReaderNewBufferedReader, th2);
                } else {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void m(Path path, Charset charset, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, k4.f.f8937e);
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        l0.o(bufferedReaderNewBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = y.h(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            if (an.m.a(1, 1, 0)) {
                dn.c.a(bufferedReaderNewBufferedReader, null);
            } else {
                bufferedReaderNewBufferedReader.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(bufferedReaderNewBufferedReader, th2);
                } else {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final InputStream n(Path path, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(openOptionArr, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(inputStreamNewInputStream, "newInputStream(...)");
        return inputStreamNewInputStream;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final OutputStream o(Path path, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(outputStreamNewOutputStream, "newOutputStream(...)");
        return outputStreamNewOutputStream;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final byte[] p(Path path) throws IOException {
        l0.p(path, "<this>");
        byte[] allBytes = Files.readAllBytes(path);
        l0.o(allBytes, "readAllBytes(...)");
        return allBytes;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final List<String> q(Path path, Charset charset) throws IOException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        l0.o(allLines, "readAllLines(...)");
        return allLines;
    }

    public static /* synthetic */ List r(Path path, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        l0.o(allLines, "readAllLines(...)");
        return allLines;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    @os.l
    public static final String s(@os.l Path path, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String strK = y.k(inputStreamReader);
            dn.c.a(inputStreamReader, null);
            return strK;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(inputStreamReader, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return s(path, charset);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final InputStreamReader u(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    public static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] openOptionArr, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final <T> T w(Path path, Charset charset, jn.l<? super gq.m<String>, ? extends T> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, "block");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            l0.m(bufferedReaderNewBufferedReader);
            T tInvoke = lVar.invoke(y.h(bufferedReaderNewBufferedReader));
            if (an.m.a(1, 1, 0)) {
                dn.c.a(bufferedReaderNewBufferedReader, null);
            } else if (bufferedReaderNewBufferedReader != null) {
                bufferedReaderNewBufferedReader.close();
            }
            return tInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(bufferedReaderNewBufferedReader, th2);
                } else if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    public static Object x(Path path, Charset charset, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(path, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, "block");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            l0.m(bufferedReaderNewBufferedReader);
            Object objInvoke = lVar.invoke(y.h(bufferedReaderNewBufferedReader));
            if (an.m.a(1, 1, 0)) {
                dn.c.a(bufferedReaderNewBufferedReader, null);
            } else if (bufferedReaderNewBufferedReader != null) {
                bufferedReaderNewBufferedReader.close();
            }
            return objInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(bufferedReaderNewBufferedReader, th2);
                } else if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final void y(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(bArr, dc.d.f3685p);
        l0.p(openOptionArr, "options");
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path z(Path path, gq.m<? extends CharSequence> mVar, Charset charset, OpenOption... openOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(mVar, "lines");
        l0.p(charset, "charset");
        l0.p(openOptionArr, "options");
        Path pathWrite = Files.write(path, v.N(mVar), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        l0.o(pathWrite, "write(...)");
        return pathWrite;
    }
}
