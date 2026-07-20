package dn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n1#2:233\n*E\n"})
public class o extends n {

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
    public static final InputStreamReader A(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static /* synthetic */ InputStreamReader B(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T C(@os.l File file, @os.l Charset charset, @os.l jn.l<? super gq.m<String>, ? extends T> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            T tInvoke = lVar.invoke(y.h(bufferedReader));
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

    public static Object D(File file, Charset charset, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            Object objInvoke = lVar.invoke(y.h(bufferedReader));
            if (an.m.a(1, 1, 0)) {
                c.a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            return objInvoke;
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

    public static final void E(@os.l File file, @os.l byte[] bArr) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(bArr, dc.d.f3685p);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            l2 l2Var = l2.f10208a;
            c.a(fileOutputStream, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(fileOutputStream, th2);
                throw th3;
            }
        }
    }

    public static final void F(@os.l File file, @os.l String str, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(str, "text");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "getBytes(...)");
        E(file, bytes);
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        F(file, str, charset);
    }

    @an.f
    public static final OutputStreamWriter H(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void g(@os.l File file, @os.l byte[] bArr) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(bArr, dc.d.f3685p);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            l2 l2Var = l2.f10208a;
            c.a(fileOutputStream, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(fileOutputStream, th2);
                throw th3;
            }
        }
    }

    public static final void h(@os.l File file, @os.l String str, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(str, "text");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "getBytes(...)");
        g(file, bytes);
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        h(file, str, charset);
    }

    @an.f
    public static final BufferedReader j(File file, Charset charset, int i10) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i10);
    }

    public static /* synthetic */ BufferedReader k(File file, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i10);
    }

    @an.f
    public static final BufferedWriter l(File file, Charset charset, int i10) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i10);
    }

    public static /* synthetic */ BufferedWriter m(File file, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void n(@os.l File file, int i10, @os.l jn.p<? super byte[], ? super Integer, l2> pVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(pVar, k4.f.f8937e);
        if (i10 < 512) {
            i10 = 512;
        }
        ?? r10 = new byte[i10];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i11 = fileInputStream.read(r10);
                if (i11 <= 0) {
                    l2 l2Var = l2.f10208a;
                    c.a(fileInputStream, null);
                    return;
                }
                pVar.invoke(r10, Integer.valueOf(i11));
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    c.a(fileInputStream, th2);
                    throw th3;
                }
            }
        }
    }

    public static final void o(@os.l File file, @os.l jn.p<? super byte[], ? super Integer, l2> pVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(pVar, k4.f.f8937e);
        n(file, 4096, pVar);
    }

    public static final void p(@os.l File file, @os.l Charset charset, @os.l jn.l<? super String, l2> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        l0.p(lVar, k4.f.f8937e);
        y.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), lVar);
    }

    public static /* synthetic */ void q(File file, Charset charset, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        p(file, charset, lVar);
    }

    @an.f
    public static final FileInputStream r(File file) {
        l0.p(file, "<this>");
        return new FileInputStream(file);
    }

    @an.f
    public static final FileOutputStream s(File file) {
        l0.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @an.f
    public static final PrintWriter t(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    public static /* synthetic */ PrintWriter u(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    @os.l
    public static final byte[] v(@os.l File file) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrV0 = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrV0, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrV0 = Arrays.copyOf(bArrV0, i12);
                l0.o(bArrV0, "copyOf(...)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    g gVar = new g(8193);
                    gVar.write(i14);
                    b.l(fileInputStream, gVar, 0, 2, null);
                    int size = gVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = gVar.b();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrV0, size);
                    l0.o(bArrCopyOf, "copyOf(...)");
                    bArrV0 = nm.p.v0(bArrB, bArrCopyOf, i10, 0, gVar.size());
                }
            }
            c.a(fileInputStream, null);
            return bArrV0;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(fileInputStream, th2);
                throw th3;
            }
        }
    }

    @os.l
    public static final List<String> w(@os.l File file, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        p(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return w(file, charset);
    }

    @os.l
    public static final String y(@os.l File file, @os.l Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strK = y.k(inputStreamReader);
            c.a(inputStreamReader, null);
            return strK;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(inputStreamReader, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ String z(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return y(file, charset);
    }
}
