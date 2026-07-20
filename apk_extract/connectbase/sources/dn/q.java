package dn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import dn.k.b;
import el.b0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import jq.e0;
import jq.h0;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1284#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
public class q extends p {

    public static final class a extends n0 implements jn.p {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Void invoke(@os.l File file, @os.l IOException iOException) throws IOException {
            l0.p(file, "<anonymous parameter 0>");
            l0.p(iOException, "exception");
            throw iOException;
        }
    }

    public static final class b extends n0 implements jn.p<File, IOException, l2> {
        final /* synthetic */ jn.p<File, IOException, u> $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.p<? super File, ? super IOException, ? extends u> pVar) {
            super(2);
            this.$onError = pVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(File file, IOException iOException) throws x {
            invoke2(file, iOException);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l File file, @os.l IOException iOException) throws x {
            l0.p(file, "f");
            l0.p(iOException, "e");
            if (this.$onError.invoke(file, iOException) == u.TERMINATE) {
                throw new x(file);
            }
        }
    }

    public static final boolean N(@os.l File file, @os.l File file2, boolean z10, @os.l jn.p<? super File, ? super IOException, ? extends u> pVar) {
        l0.p(file, "<this>");
        l0.p(file2, TypedValues.AttributesType.S_TARGET);
        l0.p(pVar, "onError");
        if (!file.exists()) {
            return pVar.invoke(file, new t(file, null, "The source file doesn't exist.", 2, null)) != u.TERMINATE;
        }
        try {
            k kVarK = p.M(file).k(new b(pVar));
            kVarK.getClass();
            k.b bVar = kVarK.new b();
            while (bVar.hasNext()) {
                File next = bVar.next();
                if (next.exists()) {
                    File file3 = new File(file2, n0(next, file));
                    if (file3.exists() && (!next.isDirectory() || !file3.isDirectory())) {
                        if (z10) {
                            if (file3.isDirectory()) {
                                if (!V(file3)) {
                                }
                            } else if (!file3.delete()) {
                            }
                        }
                        if (pVar.invoke(file3, new h(next, file3, "The destination file already exists.")) == u.TERMINATE) {
                            return false;
                        }
                    }
                    if (next.isDirectory()) {
                        file3.mkdirs();
                    } else if (Q(next, file3, z10, 0, 4, null).length() != next.length() && pVar.invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == u.TERMINATE) {
                        return false;
                    }
                } else if (pVar.invoke(next, new t(next, null, "The source file doesn't exist.", 2, null)) == u.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (x unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            pVar = a.INSTANCE;
        }
        return N(file, file2, z10, pVar);
    }

    @os.l
    public static final File P(@os.l File file, @os.l File file2, boolean z10, int i10) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(file, "<this>");
        l0.p(file2, TypedValues.AttributesType.S_TARGET);
        if (!file.exists()) {
            throw new t(file, null, "The source file doesn't exist.", 2, null);
        }
        if (file2.exists()) {
            if (!z10) {
                throw new h(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new h(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    dn.b.k(fileInputStream, fileOutputStream, i10);
                    c.a(fileOutputStream, null);
                    c.a(fileInputStream, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        c.a(fileOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    c.a(fileInputStream, th4);
                    throw th5;
                }
            }
        } else if (!file2.mkdirs()) {
            throw new j(file, file2, "Failed to create target directory.");
        }
        return file2;
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 8192;
        }
        return P(file, file2, z10, i10);
    }

    @lm.k(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @os.l
    public static final File R(@os.l String str, @os.m String str2, @os.m File file) throws IOException {
        l0.p(str, "prefix");
        File fileCreateTempFile = File.createTempFile(str, str2, file);
        fileCreateTempFile.delete();
        if (fileCreateTempFile.mkdir()) {
            l0.m(fileCreateTempFile);
            return fileCreateTempFile;
        }
        throw new IOException("Unable to create temporary directory " + fileCreateTempFile + n1.e.f11183c);
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "tmp";
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @lm.k(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @os.l
    public static final File T(@os.l String str, @os.m String str2, @os.m File file) throws IOException {
        l0.p(str, "prefix");
        File fileCreateTempFile = File.createTempFile(str, str2, file);
        l0.o(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "tmp";
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@os.l File file) {
        l0.p(file, "<this>");
        while (true) {
            boolean z10 = true;
            for (File file2 : p.L(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z10) {
                    }
                }
                z10 = false;
            }
            return z10;
        }
    }

    public static final boolean W(@os.l File file, @os.l File file2) {
        l0.p(file, "<this>");
        l0.p(file2, "other");
        i iVarF = n.f(file);
        i iVarF2 = n.f(file2);
        if (iVarF2.i()) {
            return l0.g(file, file2);
        }
        int size = iVarF.f3759b.size() - iVarF2.f3759b.size();
        if (size < 0) {
            return false;
        }
        List<File> list = iVarF.f3759b;
        return list.subList(size, list.size()).equals(iVarF2.f3759b);
    }

    public static final boolean X(@os.l File file, @os.l String str) {
        l0.p(file, "<this>");
        l0.p(str, "other");
        return W(file, new File(str));
    }

    @os.l
    public static String Y(@os.l File file) {
        l0.p(file, "<this>");
        String name = file.getName();
        l0.o(name, "getName(...)");
        return h0.o5(name, n1.e.f11183c, "");
    }

    @os.l
    public static final String Z(@os.l File file) {
        l0.p(file, "<this>");
        char c10 = File.separatorChar;
        String path = file.getPath();
        l0.o(path, "getPath(...)");
        return c10 != '/' ? e0.h2(path, c10, b0.f4502a, false, 4, null) : path;
    }

    @os.l
    public static final String a0(@os.l File file) {
        l0.p(file, "<this>");
        String name = file.getName();
        l0.o(name, "getName(...)");
        return h0.z5(name, ".", null, 2, null);
    }

    @os.l
    public static File b0(@os.l File file) {
        l0.p(file, "<this>");
        i iVarF = n.f(file);
        File file2 = iVarF.f3758a;
        List<File> listD0 = d0(iVarF.f3759b);
        String str = File.separator;
        l0.o(str, "separator");
        return i0(file2, nm.h0.m3(listD0, str, null, null, 0, null, null, 62, null));
    }

    public static final i c0(i iVar) {
        return new i(iVar.f3758a, d0(iVar.f3759b));
    }

    public static final List<File> d0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!l0.g(name, ".")) {
                if (!l0.g(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || l0.g(((File) nm.h0.p3(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    @os.l
    public static final File e0(@os.l File file, @os.l File file2) {
        l0.p(file, "<this>");
        l0.p(file2, "base");
        return new File(n0(file, file2));
    }

    @os.m
    public static final File f0(@os.l File file, @os.l File file2) throws IOException {
        l0.p(file, "<this>");
        l0.p(file2, "base");
        String strO0 = o0(file, file2);
        if (strO0 != null) {
            return new File(strO0);
        }
        return null;
    }

    @os.l
    public static final File g0(@os.l File file, @os.l File file2) throws IOException {
        l0.p(file, "<this>");
        l0.p(file2, "base");
        String strO0 = o0(file, file2);
        return strO0 != null ? new File(strO0) : file;
    }

    @os.l
    public static File h0(@os.l File file, @os.l File file2) {
        l0.p(file, "<this>");
        l0.p(file2, "relative");
        if (n.d(file2)) {
            return file2;
        }
        String string = file.toString();
        l0.o(string, "toString(...)");
        if (string.length() != 0) {
            char c10 = File.separatorChar;
            if (!h0.Y2(string, c10, false, 2, null)) {
                return new File(string + c10 + file2);
            }
        }
        return new File(string + file2);
    }

    @os.l
    public static final File i0(@os.l File file, @os.l String str) {
        l0.p(file, "<this>");
        l0.p(str, "relative");
        return h0(file, new File(str));
    }

    @os.l
    public static final File j0(@os.l File file, @os.l File file2) {
        l0.p(file, "<this>");
        l0.p(file2, "relative");
        i iVarF = n.f(file);
        return h0(h0(iVarF.f3758a, iVarF.f3759b.size() == 0 ? new File("..") : iVarF.j(0, iVarF.f3759b.size() - 1)), file2);
    }

    @os.l
    public static final File k0(@os.l File file, @os.l String str) {
        l0.p(file, "<this>");
        l0.p(str, "relative");
        return j0(file, new File(str));
    }

    public static final boolean l0(@os.l File file, @os.l File file2) {
        l0.p(file, "<this>");
        l0.p(file2, "other");
        i iVarF = n.f(file);
        i iVarF2 = n.f(file2);
        if (l0.g(iVarF.f3758a, iVarF2.f3758a) && iVarF.f3759b.size() >= iVarF2.f3759b.size()) {
            return iVarF.f3759b.subList(0, iVarF2.f3759b.size()).equals(iVarF2.f3759b);
        }
        return false;
    }

    public static boolean m0(@os.l File file, @os.l String str) {
        l0.p(file, "<this>");
        l0.p(str, "other");
        return l0(file, new File(str));
    }

    @os.l
    public static final String n0(@os.l File file, @os.l File file2) throws IOException {
        l0.p(file, "<this>");
        l0.p(file2, "base");
        String strO0 = o0(file, file2);
        if (strO0 != null) {
            return strO0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + n1.e.f11183c);
    }

    public static final String o0(File file, File file2) throws IOException {
        i iVarC0 = c0(n.f(file));
        i iVarC1 = c0(n.f(file2));
        if (!l0.g(iVarC0.f3758a, iVarC1.f3758a)) {
            return null;
        }
        int size = iVarC1.f3759b.size();
        int size2 = iVarC0.f3759b.size();
        int iMin = Math.min(size2, size);
        int i10 = 0;
        while (i10 < iMin && l0.g(iVarC0.f3759b.get(i10), iVarC1.f3759b.get(i10))) {
            i10++;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = size - 1;
        if (i10 <= i11) {
            while (!l0.g(iVarC1.f3759b.get(i11).getName(), "..")) {
                sb2.append("..");
                if (i11 != i10) {
                    sb2.append(File.separatorChar);
                }
                if (i11 != i10) {
                    i11--;
                }
            }
            return null;
        }
        if (i10 < size2) {
            if (i10 < size) {
                sb2.append(File.separatorChar);
            }
            List listC2 = nm.h0.c2(iVarC0.f3759b, i10);
            String str = File.separator;
            l0.o(str, "separator");
            nm.h0.j3(listC2, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : str, (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null);
        }
        return sb2.toString();
    }
}
