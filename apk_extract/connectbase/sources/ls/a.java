package ls;

import el.b0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import ks.c;
import lb.f;
import n1.e;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f10274a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f10277d = false;

    /* JADX INFO: renamed from: ls.a$a, reason: collision with other inner class name */
    public class C0271a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10278a = "jansi-" + a.j();

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f10278a) && !str.endsWith(".lck");
        }
    }

    public static void a() {
        File[] fileArrListFiles = new File(i().getAbsolutePath()).listFiles(new C0271a());
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!new File(file.getAbsolutePath() + ".lck").exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e10) {
                        System.err.println("Failed to delete old native lib" + e10.getMessage());
                    }
                }
            }
        }
    }

    public static String b(InputStream inputStream, InputStream inputStream2) throws IOException {
        byte[] bArr = new byte[8192];
        byte[] bArr2 = new byte[8192];
        do {
            int iQ = q(inputStream, bArr);
            int iQ2 = q(inputStream2, bArr2);
            if (iQ <= 0) {
                if (iQ2 > 0) {
                    return "EOF on first stream but not second";
                }
                return null;
            }
            if (iQ2 <= 0) {
                return "EOF on second stream but not first";
            }
            if (iQ2 != iQ) {
                return "Read size different (" + iQ + " vs " + iQ2 + ")";
            }
        } while (Arrays.equals(bArr, bArr2));
        return "Content differs";
    }

    public static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i10);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean d(String str, String str2, String str3) {
        String str4 = str + "/" + str2;
        String str5 = String.format("jansi-%s-%s-%s", j(), p(), str2);
        String strConcat = str5.concat(".lck");
        File file = new File(str3, str5);
        File file2 = new File(str3, strConcat);
        try {
            try {
                InputStream resourceAsStream = a.class.getResourceAsStream(str4);
                try {
                    if (!file2.exists()) {
                        new FileOutputStream(file2).close();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        c(resourceAsStream, fileOutputStream);
                        fileOutputStream.close();
                        if (resourceAsStream != null) {
                            resourceAsStream.close();
                        }
                        file.deleteOnExit();
                        file2.deleteOnExit();
                        file.setReadable(true);
                        file.setWritable(true);
                        file.setExecutable(true);
                        InputStream resourceAsStream2 = a.class.getResourceAsStream(str4);
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                String strB = b(resourceAsStream2, fileInputStream);
                                if (strB != null) {
                                    throw new RuntimeException(String.format("Failed to write a native library file at %s because %s", file, strB));
                                }
                                fileInputStream.close();
                                if (resourceAsStream2 != null) {
                                    resourceAsStream2.close();
                                }
                                if (!o(file)) {
                                    return false;
                                }
                                f10276c = a.class.getResource(str4).toExternalForm();
                                return true;
                            } catch (Throwable th2) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            if (resourceAsStream2 != null) {
                                try {
                                    resourceAsStream2.close();
                                } catch (Throwable th5) {
                                    th4.addSuppressed(th5);
                                }
                            }
                            throw th4;
                        }
                        if (resourceAsStream2 != null) {
                            resourceAsStream2.close();
                        }
                        throw th4;
                    } catch (Throwable th6) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th7) {
                            th6.addSuppressed(th7);
                        }
                        throw th6;
                    }
                } catch (Throwable th8) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (Throwable th9) {
                            th8.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            } catch (IOException e10) {
                System.err.println(e10.getMessage());
                return false;
            }
        } catch (Throwable th10) {
            file.deleteOnExit();
            file2.deleteOnExit();
            throw th10;
        }
    }

    public static int e() {
        String[] strArrSplit = j().split("\\.");
        if (strArrSplit.length > 0) {
            return Integer.parseInt(strArrSplit[0]);
        }
        return 1;
    }

    public static int f() {
        String[] strArrSplit = j().split("\\.");
        if (strArrSplit.length > 1) {
            return Integer.parseInt(strArrSplit[1]);
        }
        return 0;
    }

    public static String g() {
        return f10275b;
    }

    public static String h() {
        return f10276c;
    }

    public static File i() {
        return new File(System.getProperty("jansi.tmpdir", System.getProperty("java.io.tmpdir")));
    }

    public static String j() {
        URL resource = a.class.getResource("/org/fusesource/jansi/jansi.properties");
        if (resource == null) {
            return "unknown";
        }
        try {
            Properties properties = new Properties();
            properties.load(resource.openStream());
            return properties.getProperty(f.f9782f, "unknown").trim().replaceAll("[^0-9.]", "");
        } catch (IOException e10) {
            System.err.println(e10);
            return "unknown";
        }
    }

    public static boolean k(String str) {
        return a.class.getResource(str) != null;
    }

    public static synchronized boolean l() {
        if (!f10274a) {
            a();
        }
        try {
            n();
        } catch (Exception e10) {
            if (!Boolean.parseBoolean(System.getProperty(c.f9472r, "true"))) {
                throw new RuntimeException("Unable to load jansi native library. You may want set the `jansi.graceful` system property to true to be able to use Jansi on your platform", e10);
            }
        }
        return f10274a;
    }

    public static String m(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String str2 : list) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(str);
            }
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public static void n() throws Exception {
        if (f10274a) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        String property = System.getProperty("library.jansi.path");
        String property2 = System.getProperty("library.jansi.name");
        if (property2 == null) {
            property2 = System.mapLibraryName("jansi");
            if (property2.endsWith(".dylib")) {
                property2 = property2.replace(".dylib", ".jnilib");
            }
        }
        if (property != null) {
            StringBuilder sbA = k.c.a(property, "/");
            sbA.append(b.c());
            String string = sbA.toString();
            if (o(new File(string, property2))) {
                f10274a = true;
                return;
            }
            linkedList.add(string);
            if (o(new File(property, property2))) {
                f10274a = true;
                return;
            }
            linkedList.add(property);
        }
        String str = String.format("/%s/native/%s", a.class.getPackage().getName().replace(e.f11183c, b0.f4502a), b.c());
        if (k(str + "/" + property2)) {
            if (d(str, property2, i().getAbsolutePath())) {
                f10274a = true;
                return;
            }
            linkedList.add(str);
        }
        for (String str2 : System.getProperty("java.library.path", "").split(File.pathSeparator)) {
            if (!str2.isEmpty()) {
                if (o(new File(str2, property2))) {
                    f10274a = true;
                    return;
                }
                linkedList.add(str2);
            }
        }
        throw new Exception(String.format("No native library found for os.name=%s, os.arch=%s, paths=[%s]", b.d(), b.a(), m(linkedList, File.pathSeparator)));
    }

    public static boolean o(File file) {
        if (file.exists()) {
            try {
                String absolutePath = file.getAbsolutePath();
                System.load(absolutePath);
                f10275b = absolutePath;
                return true;
            } catch (UnsatisfiedLinkError e10) {
                if (file.canExecute()) {
                    System.err.printf("Failed to load native library:%s. osinfo: %s%n", file.getName(), b.c());
                } else {
                    System.err.printf("Failed to load native library:%s. The native library file at %s is not executable, make sure that the directory is mounted on a partition without the noexec flag, or set the jansi.tmpdir system property to point to a proper location.  osinfo: %s%n", file.getName(), file, b.c());
                }
                System.err.println(e10);
            }
        }
        return false;
    }

    public static String p() {
        return Long.toHexString(new Random().nextLong());
    }

    public static int q(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = inputStream.read(bArr, i10, length - i10);
            if (i11 <= 0) {
                break;
            }
            i10 += i11;
        }
        return i10;
    }
}
