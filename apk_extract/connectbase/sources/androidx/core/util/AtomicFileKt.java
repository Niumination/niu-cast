package androidx.core.util;

import androidx.annotation.RequiresApi;
import b.a;
import dc.d;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import jq.f;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,84:1\n34#1,13:85\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n53#1:85,13\n*E\n"})
@a({"ClassVerificationFailure"})
public final class AtomicFileKt {
    @RequiresApi(17)
    @l
    public static final byte[] readBytes(@l android.util.AtomicFile atomicFile) throws IOException {
        l0.p(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        l0.o(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    @l
    public static final String readText(@l android.util.AtomicFile atomicFile, @l Charset charset) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(charset, "charset");
        byte[] fully = atomicFile.readFully();
        l0.o(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = f.f8800b;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@l android.util.AtomicFile atomicFile, @l jn.l<? super FileOutputStream, l2> lVar) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(lVar, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            l0.o(fileOutputStreamStartWrite, "stream");
            lVar.invoke(fileOutputStreamStartWrite);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th2) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th2;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@l android.util.AtomicFile atomicFile, @l byte[] bArr) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(bArr, d.f3685p);
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            l0.o(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th2) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th2;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@l android.util.AtomicFile atomicFile, @l String str, @l Charset charset) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(str, "text");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = f.f8800b;
        }
        writeText(atomicFile, str, charset);
    }
}
