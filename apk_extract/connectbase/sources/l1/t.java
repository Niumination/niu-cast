package l1;

import f1.i3;
import f1.t3;
import i1.g1;
import i1.h1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1<File> f9624a = new b();

    public class a implements y<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f9625a = new ArrayList();

        @Override // l1.y
        public boolean b(String line) {
            this.f9625a.add(line);
            return true;
        }

        @Override // l1.y
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a() {
            return this.f9625a;
        }
    }

    public class b implements g1<File> {
        @Override // i1.g1
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public Iterable<File> b(File file) {
            File[] fileArrListFiles;
            return (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) ? i3.of() : Collections.unmodifiableList(Arrays.asList(fileArrListFiles));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class e implements c1.i0<File> {
        public static final e IS_DIRECTORY = new a("IS_DIRECTORY", 0);
        public static final e IS_FILE = new b("IS_FILE", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ e[] f9629a = a();

        public final enum a extends e {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }

            @Override // c1.i0
            public boolean apply(File file) {
                return file.isDirectory();
            }
        }

        public final enum b extends e {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }

            @Override // c1.i0
            public boolean apply(File file) {
                return file.isFile();
            }
        }

        public e(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ e[] a() {
            return new e[]{IS_DIRECTORY, IS_FILE};
        }

        public static e valueOf(String name) {
            return (e) Enum.valueOf(e.class, name);
        }

        public static e[] values() {
            return (e[]) f9629a.clone();
        }

        public e(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    @t1.a
    @Deprecated
    @e0
    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readLines(callback)")
    public static <T> T A(File file, Charset charset, y<T> yVar) throws IOException {
        return (T) e(file, charset).q(yVar);
    }

    public static List<String> B(File file, Charset charset) throws IOException {
        return (List) e(file, charset).q(new a());
    }

    public static String C(String pathname) {
        pathname.getClass();
        if (pathname.length() == 0) {
            return ".";
        }
        Iterable<String> iterableN = c1.m0.h(el.b0.f4502a).g().n(pathname);
        ArrayList arrayList = new ArrayList();
        for (String str : iterableN) {
            str.getClass();
            if (!str.equals(".")) {
                if (!str.equals("..")) {
                    arrayList.add(str);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String strK = c1.y.o(el.b0.f4502a).k(arrayList);
        if (pathname.charAt(0) == '/') {
            strK = m.a.a("/", strK);
        }
        while (strK.startsWith("/../")) {
            strK = strK.substring(3);
        }
        if (strK.equals("/..")) {
            return "/";
        }
        return "".equals(strK) ? "." : strK;
    }

    public static byte[] D(File file) throws IOException {
        return new d(file).o();
    }

    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).read()")
    @Deprecated
    public static String E(File file, Charset charset) throws IOException {
        return e(file, charset).n();
    }

    public static void F(File file) throws IOException {
        file.getClass();
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to update modification time of " + file);
    }

    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset).write(from)")
    @Deprecated
    public static void G(CharSequence from, File to2, Charset charset) throws IOException {
        d(to2, charset, new s[0]).c(from);
    }

    public static void H(byte[] from, File to2) throws IOException {
        new c(to2, new s[0]).d(from);
    }

    @t1.l(imports = {"com.google.common.io.FileWriteMode", "com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset, FileWriteMode.APPEND).write(from)")
    @Deprecated
    public static void a(CharSequence from, File to2, Charset charset) throws IOException {
        d(to2, charset, s.APPEND).c(from);
    }

    public static f b(File file, s... modes) {
        return new c(file, modes);
    }

    public static g c(File file) {
        return new d(file);
    }

    public static j d(File file, Charset charset, s... modes) {
        return new f.b(charset);
    }

    public static k e(File file, Charset charset) {
        return new g.a(charset);
    }

    public static void f(File from, File to2) throws IOException {
        c1.h0.y(!from.equals(to2), "Source %s and destination %s must be different", from, to2);
        new d(from).g(new c(to2, new s[0]));
    }

    public static void g(File from, OutputStream to2) throws IOException {
        new d(from).f(to2);
    }

    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(from, charset).copyTo(to)")
    @Deprecated
    public static void h(File from, Charset charset, Appendable to2) throws IOException {
        e(from, charset).e(to2);
    }

    public static void i(File file) throws IOException {
        file.getClass();
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create parent directories of " + file);
    }

    @b1.a
    @Deprecated
    public static File j() {
        return i0.f9587a.a();
    }

    public static boolean k(File file1, File file2) throws IOException {
        file1.getClass();
        file2.getClass();
        if (file1 == file2 || file1.equals(file2)) {
            return true;
        }
        long length = file1.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return new d(file1).e(new d(file2));
        }
        return false;
    }

    public static h1<File> l() {
        return h1.h(f9624a);
    }

    public static String m(String fullName) {
        fullName.getClass();
        String name = new File(fullName).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf + 1);
    }

    public static String n(String file) {
        file.getClass();
        String name = new File(file).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? name : name.substring(0, iLastIndexOf);
    }

    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).hash(hashFunction)")
    @Deprecated
    public static j1.q o(File file, j1.r hashFunction) throws IOException {
        return new d(file).j(hashFunction);
    }

    public static c1.i0<File> p() {
        return e.IS_DIRECTORY;
    }

    public static c1.i0<File> q() {
        return e.IS_FILE;
    }

    public static MappedByteBuffer r(File file) throws IOException {
        file.getClass();
        return u(file, FileChannel.MapMode.READ_ONLY, -1L);
    }

    public static MappedByteBuffer s(File file, FileChannel.MapMode mode) throws IOException {
        return u(file, mode, -1L);
    }

    public static MappedByteBuffer t(File file, FileChannel.MapMode mode, long size) throws IOException {
        c1.h0.p(size >= 0, "size (%s) may not be negative", size);
        return u(file, mode, size);
    }

    public static MappedByteBuffer u(File file, FileChannel.MapMode mode, long size) throws IOException {
        file.getClass();
        mode.getClass();
        n nVarB = n.b();
        try {
            FileChannel fileChannel = (FileChannel) nVarB.c(((RandomAccessFile) nVarB.c(new RandomAccessFile(file, mode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (size == -1) {
                size = fileChannel.size();
            }
            MappedByteBuffer map = fileChannel.map(mode, 0L, size);
            nVarB.close();
            return map;
        } catch (Throwable th2) {
            try {
                throw nVarB.d(th2);
            } catch (Throwable th3) {
                nVarB.close();
                throw th3;
            }
        }
    }

    public static void v(File from, File to2) throws IOException {
        from.getClass();
        to2.getClass();
        c1.h0.y(!from.equals(to2), "Source %s and destination %s must be different", from, to2);
        if (from.renameTo(to2)) {
            return;
        }
        f(from, to2);
        if (from.delete()) {
            return;
        }
        if (to2.delete()) {
            throw new IOException("Unable to delete " + from);
        }
        throw new IOException("Unable to delete " + to2);
    }

    public static BufferedReader w(File file, Charset charset) throws FileNotFoundException {
        file.getClass();
        charset.getClass();
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter x(File file, Charset charset) throws FileNotFoundException {
        file.getClass();
        charset.getClass();
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @t1.a
    @Deprecated
    @e0
    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).read(processor)")
    public static <T> T y(File file, l1.e<T> eVar) throws IOException {
        return (T) new d(file).n(eVar);
    }

    @gm.a
    @Deprecated
    @t1.l(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readFirstLine()")
    public static String z(File file, Charset charset) throws IOException {
        return e(file, charset).o();
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f9628a;

        public d(File file) {
            file.getClass();
            this.f9628a = file;
        }

        @Override // l1.g
        public byte[] o() throws IOException {
            n nVarB = n.b();
            try {
                FileInputStream fileInputStream = (FileInputStream) nVarB.c(m());
                byte[] bArrV = h.v(fileInputStream, fileInputStream.getChannel().size());
                nVarB.close();
                return bArrV;
            } catch (Throwable th2) {
                try {
                    throw nVarB.d(th2);
                } catch (Throwable th3) {
                    nVarB.close();
                    throw th3;
                }
            }
        }

        @Override // l1.g
        public long p() throws IOException {
            if (this.f9628a.isFile()) {
                return this.f9628a.length();
            }
            throw new FileNotFoundException(this.f9628a.toString());
        }

        @Override // l1.g
        public c1.c0<Long> q() {
            return this.f9628a.isFile() ? c1.c0.of(Long.valueOf(this.f9628a.length())) : c1.c0.absent();
        }

        @Override // l1.g
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public FileInputStream m() throws IOException {
            return new FileInputStream(this.f9628a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f9628a + ")";
        }

        public /* synthetic */ d(File file, a aVar) {
            this(file);
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f9626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t3<s> f9627b;

        public c(File file, s... modes) {
            file.getClass();
            this.f9626a = file;
            this.f9627b = t3.copyOf(modes);
        }

        @Override // l1.f
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public FileOutputStream c() throws IOException {
            return new FileOutputStream(this.f9626a, this.f9627b.contains(s.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.f9626a + ", " + this.f9627b + ")";
        }

        public /* synthetic */ c(File file, s[] sVarArr, a aVar) {
            this(file, sVarArr);
        }
    }
}
