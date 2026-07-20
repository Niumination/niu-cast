package ks;

import androidx.core.app.NotificationCompat;
import el.b0;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import org.fusesource.jansi.internal.CLibrary;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e10) {
            e10.printStackTrace(System.err);
        }
    }

    public static void b(boolean z10) {
        int iIsatty = CLibrary.f12429a ? CLibrary.isatty(z10 ? CLibrary.f12431c : CLibrary.f12430b) : 0;
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder("isatty(STD");
        sb2.append(z10 ? "ERR" : "OUT");
        sb2.append("_FILENO): ");
        sb2.append(iIsatty);
        sb2.append(", System.");
        sb2.append(z10 ? NotificationCompat.CATEGORY_ERROR : "out");
        sb2.append(" ");
        sb2.append(iIsatty == 0 ? "is *NOT*" : "is");
        sb2.append(" a terminal");
        printStream.println(sb2.toString());
    }

    public static String c() {
        Package r10 = d.class.getPackage();
        if (r10 == null) {
            return null;
        }
        return r10.getImplementationVersion();
    }

    public static String d(String str) throws IOException {
        InputStream resourceAsStream = d.class.getResourceAsStream("/META-INF/maven/" + str + "/pom.properties");
        if (resourceAsStream == null) {
            return null;
        }
        try {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return properties.getProperty(lb.f.f9782f);
        } finally {
            a(resourceAsStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x008f  */
    public static void e(String... strArr) throws IOException {
        PrintStream printStream = System.out;
        printStream.println("Jansi " + c());
        printStream.println();
        printStream.println("library.jansi.path= " + System.getProperty("library.jansi.path", ""));
        printStream.println("library.jansi.version= " + System.getProperty("library.jansi.version", ""));
        if (ls.a.l()) {
            printStream.println("Jansi native library loaded from " + ls.a.f10275b);
            if (ls.a.f10276c != null) {
                printStream.println("   which was auto-extracted from " + ls.a.f10276c);
            }
        } else {
            String property = System.getProperty(c.f9472r);
            try {
                System.setProperty(c.f9472r, "false");
                ls.a.l();
                if (property != null) {
                    System.setProperty(c.f9472r, property);
                } else {
                    System.clearProperty(c.f9472r);
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace(System.out);
                    if (property == null) {
                        System.clearProperty(c.f9472r);
                    }
                } catch (Throwable th3) {
                    if (property != null) {
                        System.setProperty(c.f9472r, property);
                    } else {
                        System.clearProperty(c.f9472r);
                    }
                    throw th3;
                }
            }
        }
        PrintStream printStream2 = System.out;
        printStream2.println();
        printStream2.println("os.name= " + System.getProperty("os.name") + ", os.version= " + System.getProperty("os.version") + ", os.arch= " + System.getProperty("os.arch"));
        StringBuilder sb2 = new StringBuilder("file.encoding= ");
        sb2.append(System.getProperty("file.encoding"));
        printStream2.println(sb2.toString());
        printStream2.println("java.version= " + System.getProperty("java.version") + ", java.vendor= " + System.getProperty("java.vendor") + ", java.home= " + System.getProperty("java.home"));
        printStream2.println();
        StringBuilder sb3 = new StringBuilder("jansi.graceful= ");
        sb3.append(System.getProperty(c.f9472r, ""));
        printStream2.println(sb3.toString());
        printStream2.println("jansi.mode= " + System.getProperty(c.f9455a, ""));
        printStream2.println("jansi.out.mode= " + System.getProperty(c.f9456b, ""));
        printStream2.println("jansi.err.mode= " + System.getProperty(c.f9457c, ""));
        printStream2.println("jansi.colors= " + System.getProperty(c.f9461g, ""));
        printStream2.println("jansi.out.colors= " + System.getProperty(c.f9462h, ""));
        printStream2.println("jansi.err.colors= " + System.getProperty(c.f9463i, ""));
        printStream2.println("jansi.passthrough= " + c.e(c.f9467m));
        printStream2.println("jansi.strip= " + c.e(c.f9468n));
        printStream2.println("jansi.force= " + c.e(c.f9469o));
        printStream2.println("jansi.noreset= " + c.e(c.f9471q));
        StringBuilder sb4 = new StringBuilder();
        String str = a.f9446e;
        sb4.append(str);
        sb4.append("= ");
        sb4.append(c.e(str));
        printStream2.println(sb4.toString());
        printStream2.println();
        StringBuilder sb5 = new StringBuilder("IS_WINDOWS: ");
        boolean z10 = c.f9477w;
        sb5.append(z10);
        printStream2.println(sb5.toString());
        if (z10) {
            printStream2.println("IS_CONEMU: " + c.f9480z);
            printStream2.println("IS_CYGWIN: " + c.f9478x);
            printStream2.println("IS_MSYSTEM: " + c.f9479y);
        }
        printStream2.println();
        int i10 = 0;
        b(false);
        int i11 = 1;
        b(true);
        c.m();
        printStream2.println();
        printStream2.println("Resulting Jansi modes for stout/stderr streams:");
        printStream2.println("  - System.out: " + c.j().toString());
        printStream2.println("  - System.err: " + c.d().toString());
        printStream2.println("Processor types description:");
        for (h hVar : h.values()) {
            System.out.println("  - " + hVar + ": " + hVar.getDescription());
        }
        System.out.println("Colors support description:");
        for (b bVar : b.values()) {
            System.out.println("  - " + bVar + ": " + bVar.getDescription());
        }
        System.out.println("Modes description:");
        for (e eVar : e.values()) {
            System.out.println("  - " + eVar + ": " + eVar.getDescription());
        }
        try {
            PrintStream printStream3 = System.out;
            printStream3.println();
            g(false);
            g(true);
            if (strArr.length == 0) {
                f();
                c.n();
                return;
            }
            printStream3.println();
            if (strArr.length == 1) {
                File file = new File(strArr[0]);
                if (file.exists()) {
                    printStream3.println(a.r().U().l("\"" + strArr[0] + "\" content:").S0());
                    h(file);
                    c.n();
                    return;
                }
            }
            printStream3.println(a.r().U().l("original args:").S0());
            int length = strArr.length;
            int i12 = 0;
            int i13 = 1;
            while (i12 < length) {
                String str2 = strArr[i12];
                c.f9473s.print(i13 + ": ");
                c.f9473s.println(str2);
                i12++;
                i13++;
            }
            System.out.println(a.r().U().l("Jansi filtered args:").S0());
            int length2 = strArr.length;
            while (i10 < length2) {
                String str3 = strArr[i10];
                PrintStream printStream4 = System.out;
                StringBuilder sb6 = new StringBuilder();
                int i14 = i11 + 1;
                sb6.append(i11);
                sb6.append(": ");
                printStream4.print(sb6.toString());
                printStream4.println(str3);
                i10++;
                i11 = i14;
            }
            c.n();
        } catch (Throwable th4) {
            c.n();
            throw th4;
        }
    }

    public static void f() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.class.getResourceAsStream("jansi.txt"), "UTF-8"));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    a(bufferedReader);
                    return;
                }
                System.out.println(line);
            } catch (Throwable th2) {
                a(bufferedReader);
                throw th2;
            }
        }
    }

    public static void g(boolean z10) {
        PrintStream printStream = z10 ? System.err : System.out;
        StringBuilder sb2 = new StringBuilder("test on System.");
        sb2.append(z10 ? NotificationCompat.CATEGORY_ERROR : "out");
        sb2.append(":");
        printStream.print(sb2.toString());
        for (a.d dVar : a.d.values()) {
            printStream.print(" " + a.r().p0(dVar) + dVar + a.r().S0());
        }
        printStream.println();
        printStream.print("            bright:");
        for (a.d dVar2 : a.d.values()) {
            printStream.print(" " + a.r().s0(dVar2) + dVar2 + a.r().S0());
        }
        printStream.println();
        printStream.print("              bold:");
        for (a.d dVar3 : a.d.values()) {
            printStream.print(" " + a.r().U().p0(dVar3) + dVar3 + a.r().S0());
        }
        printStream.println();
        printStream.print("             faint:");
        for (a.d dVar4 : a.d.values()) {
            printStream.print(" " + a.r().n(a.c.INTENSITY_FAINT).p0(dVar4) + dVar4 + a.r().S0());
        }
        printStream.println();
        printStream.print("        bold+faint:");
        for (a.d dVar5 : a.d.values()) {
            printStream.print(" " + a.r().U().n(a.c.INTENSITY_FAINT).p0(dVar5) + dVar5 + a.r().S0());
        }
        printStream.println();
        a aVarR = a.r();
        aVarR.l("        256 colors: ");
        for (int i10 = 0; i10 < 216; i10++) {
            if (i10 > 0 && i10 % 36 == 0) {
                aVarR.S0();
                aVarR.O0();
                aVarR.l("                    ");
            } else if (i10 > 0 && i10 % 6 == 0) {
                aVarR.S0();
                aVarR.l("  ");
            }
            aVarR.C((((i10 / 6) % 6) * 36) + ((i10 / 36) * 6) + (i10 % 6) + 16).b(' ');
        }
        aVarR.S0();
        printStream.println(aVarR);
        a aVarR2 = a.r();
        aVarR2.l("         truecolor: ");
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 > 0 && i11 % 48 == 0) {
                aVarR2.S0();
                aVarR2.O0();
                aVarR2.l("                    ");
            }
            int i12 = 255 - i11;
            int i13 = i11 * 2;
            if (i13 > 255) {
                i13 = 255 - i13;
            }
            aVarR2.S(i12, i13, i11).H0(255 - i12, 255 - i13, i12).b(i11 % 2 == 0 ? b0.f4502a : rs.f.f14862d);
        }
        aVarR2.S0();
        printStream.println(aVarR2);
    }

    public static void h(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 < 0) {
                    a(fileInputStream);
                    return;
                }
                System.out.write(bArr, 0, i10);
            }
        } catch (Throwable th2) {
            a(fileInputStream);
            throw th2;
        }
    }
}
