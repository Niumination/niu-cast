package d6;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p5.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String A = "|---------------------------------------------------------------------------------------------------";
    public static final int B = 4000;
    public static final String D = "Log with null object.";
    public static final String E = "null";
    public static final String F = "args";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3550a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3551b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3552c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3553d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3554e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3555f = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3557h = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3558i = 32;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3559j = 48;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ExecutorService f3560k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f3561l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f3562m = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f3574y = "|---------------------------------------------------------------------------------------------------";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f3575z = "| ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char[] f3556g = {y5.a.K, 'D', 'I', 'W', 'E', y5.a.G};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f3563n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f3564o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f3565p = "TAG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f3566q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f3567r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f3568s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f3569t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f3570u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f3571v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f3572w = System.getProperty("file.separator");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f3573x = System.getProperty("line.separator");
    public static final Format C = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    /* JADX INFO: renamed from: d6.a$a, reason: collision with other inner class name */
    public static class RunnableC0082a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3578c;

        public RunnableC0082a(String str, String str2, String str3) {
            this.f3576a = str;
            this.f3577b = str2;
            this.f3578c = str3;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            BufferedWriter bufferedWriter;
            IOException e10;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(this.f3576a, true));
                    try {
                        try {
                            bufferedWriter.write(this.f3577b);
                            Log.d(this.f3578c, "log to " + this.f3576a + " success!");
                            bufferedWriter.close();
                        } catch (IOException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            Log.e(this.f3578c, "log to " + this.f3576a + cc.a.f1441c);
                            if (bufferedWriter == null) {
                            } else {
                                bufferedWriter.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            } catch (IOException e14) {
                bufferedWriter = null;
                e10 = e14;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                throw th;
            }
        }
    }

    public static class b {
        public b a(boolean z10) {
            boolean unused = a.f3569t = z10;
            return this;
        }

        public b b(int i10) {
            int unused = a.f3570u = i10;
            return this;
        }

        public b c(boolean z10) {
            boolean unused = a.f3564o = z10;
            return this;
        }

        public b d(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + a.f3572w;
            }
            String unused = a.f3562m = str;
            return this;
        }

        public b e(String str) {
            if (a.R(str)) {
                a.f3562m = null;
            } else {
                String str2 = a.f3572w;
                if (!str.endsWith(str2)) {
                    str = j.a.a(str, str2);
                }
                a.f3562m = str;
            }
            return this;
        }

        public b f(int i10) {
            int unused = a.f3571v = i10;
            return this;
        }

        public b g(String str) {
            if (a.R(str)) {
                a.f3565p = "";
                a.f3566q = true;
            } else {
                a.f3565p = str;
                a.f3566q = false;
            }
            return this;
        }

        public b h(boolean z10) {
            boolean unused = a.f3568s = z10;
            return this;
        }

        public b i(boolean z10) {
            boolean unused = a.f3567r = z10;
            return this;
        }

        public b j(boolean z10) {
            boolean unused = a.f3563n = z10;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("switch: ");
            sb2.append(a.f3563n);
            String str = a.f3573x;
            sb2.append(str);
            sb2.append("console: ");
            sb2.append(a.f3564o);
            sb2.append(str);
            sb2.append("tag: ");
            sb2.append(a.f3566q ? a.E : a.f3565p);
            sb2.append(str);
            sb2.append("head: ");
            sb2.append(a.f3567r);
            sb2.append(str);
            sb2.append("file: ");
            sb2.append(a.f3568s);
            sb2.append(str);
            sb2.append("dir: ");
            String str2 = a.f3562m;
            if (str2 == null) {
                str2 = a.f3561l;
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append("border: ");
            sb2.append(a.f3569t);
            sb2.append(str);
            sb2.append("consoleFilter: ");
            char[] cArr = a.f3556g;
            sb2.append(cArr[a.f3570u - 2]);
            sb2.append(str);
            sb2.append("fileFilter: ");
            sb2.append(cArr[a.f3571v - 2]);
            return sb2.toString();
        }
    }

    public a() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String B(String str) {
        if (!f3569t) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f3573x)) {
            sb2.append(f3575z);
            sb2.append(str2);
            sb2.append(f3573x);
        }
        return sb2.toString();
    }

    public static byte[] C(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(1);
        try {
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[2048];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
    }

    public static boolean D(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean E(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!D(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void F(Object obj) {
        W(3, f3565p, obj);
    }

    public static void G(String str, Object... objArr) {
        W(3, str, objArr);
    }

    public static void H(Object obj) {
        W(6, f3565p, obj);
    }

    public static void I(String str, Object... objArr) {
        W(6, str, objArr);
    }

    public static void J(int i10, Object obj) {
        W(i10 | 16, f3565p, obj);
    }

    public static void K(int i10, String str, Object obj) {
        W(i10 | 16, str, obj);
    }

    public static void L(Object obj) {
        W(19, f3565p, obj);
    }

    public static void M(String str, Object obj) {
        W(19, str, obj);
    }

    public static String N(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public static String O(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f3573x);
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static void P(Object obj) {
        W(4, f3565p, obj);
    }

    public static void Q(String str, Object... objArr) {
        W(4, str, objArr);
    }

    public static boolean R(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static void S(int i10, String str) {
        W(i10 | 32, f3565p, str);
    }

    public static void T(int i10, String str, String str2) {
        W(i10 | 32, str, str2);
    }

    public static void U(String str) {
        W(35, f3565p, str);
    }

    public static void V(String str, String str2) {
        W(35, str, str2);
    }

    public static void W(int i10, String str, Object... objArr) {
        String strSubstring = str.length() > 23 ? str.substring(0, 23) : str;
        if (!b6.b.e() && !Log.isLoggable(strSubstring, 3)) {
            if (!f3563n) {
                return;
            }
            if (!f3564o && !f3568s) {
                return;
            }
        }
        int i11 = i10 & 15;
        int i12 = i10 & m0.f12864d;
        if (i11 >= f3570u || i11 >= f3571v) {
            String[] strArrB0 = b0(str);
            String strA0 = a0(i12, objArr);
            if (f3564o && i11 >= f3570u) {
                Y(i11, strArrB0[0], strArrB0[1], strA0);
            }
            if ((f3568s || i12 == 16) && i11 >= f3571v) {
                Z(i11, strArrB0[0], strArrB0[2] + strA0);
            }
        }
    }

    public static void X(int i10, String str, String str2) {
        Log.println(i10, str, str2);
    }

    public static void Y(int i10, String str, String str2, String str3) {
        if (f3567r) {
            Log.println(i10, str, "\n" + str2);
        } else {
            Log.println(i10, str, " \n");
        }
        if (f3569t) {
            Log.println(i10, str, "|---------------------------------------------------------------------------------------------------");
            str3 = B(str3);
        }
        int length = str3.length();
        int i11 = length / B;
        if (i11 > 0) {
            int i12 = B;
            Log.println(i10, str, str3.substring(0, B));
            int i13 = 1;
            while (i13 < i11) {
                int i14 = i12 + B;
                String strSubstring = str3.substring(i12, i14);
                if (f3569t) {
                    strSubstring = m.a.a(f3575z, strSubstring);
                }
                Log.println(i10, str, strSubstring);
                i13++;
                i12 = i14;
            }
            String strSubstring2 = str3.substring(i12, length);
            if (f3569t) {
                strSubstring2 = m.a.a(f3575z, strSubstring2);
            }
            Log.println(i10, str, strSubstring2);
        } else {
            Log.println(i10, str, str3);
        }
        if (f3569t) {
            Log.println(i10, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public static void Z(int i10, String str, String str2) {
        String str3 = C.format(new Date(System.currentTimeMillis()));
        String strSubstring = str3.substring(0, 5);
        String strSubstring2 = str3.substring(6);
        StringBuilder sb2 = new StringBuilder();
        String str4 = f3562m;
        if (str4 == null) {
            str4 = f3561l;
        }
        sb2.append(str4);
        sb2.append(strSubstring);
        sb2.append(".txt");
        String string = sb2.toString();
        if (!E(string)) {
            Log.e(str, "log to " + string + cc.a.f1441c);
            return;
        }
        StringBuilder sbA = k.a.a(strSubstring2);
        sbA.append(f3556g[i10 - 2]);
        sbA.append("/");
        sbA.append(str);
        sbA.append(str2);
        sbA.append(f3573x);
        String string2 = sbA.toString();
        if (f3560k == null) {
            f3560k = Executors.newSingleThreadExecutor();
        }
        f3560k.execute(new RunnableC0082a(string, string2, str));
    }

    public static void a(Object obj) {
        W(7, f3565p, obj);
    }

    public static String a0(int i10, Object... objArr) {
        if (objArr == null) {
            return D;
        }
        int length = objArr.length;
        String string = E;
        if (length == 1) {
            Object obj = objArr[0];
            if (obj != null) {
                string = obj.toString();
            }
            if (i10 == 32) {
                return N(string);
            }
            return i10 == 48 ? O(string) : string;
        }
        StringBuilder sb2 = new StringBuilder();
        int length2 = objArr.length;
        for (int i11 = 0; i11 < length2; i11++) {
            Object obj2 = objArr[i11];
            sb2.append("args[");
            sb2.append(i11);
            sb2.append("] = ");
            sb2.append(obj2 == null ? E : obj2.toString());
            sb2.append(f3573x);
        }
        return sb2.toString();
    }

    public static void b(String str, Object... objArr) {
        W(7, str, objArr);
    }

    public static String[] b0(String str) {
        if (f3566q || f3567r) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (f3566q && R(str)) {
                str = className;
            }
            if (f3567r) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                StringBuilder sbA = k.a.a(string);
                sbA.append(f3573x);
                return new String[]{str, sbA.toString(), n.a.a(" [", string, "]: ")};
            }
        } else {
            str = f3565p;
        }
        return new String[]{str, "", ": "};
    }

    public static byte[] c0(byte[] bArr) {
        int iInflate;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        try {
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[2048];
            while (!inflater.finished()) {
                try {
                    iInflate = inflater.inflate(bArr2);
                } catch (DataFormatException e10) {
                    e10.printStackTrace();
                    iInflate = 0;
                }
                byteArrayOutputStream.write(bArr2, 0, iInflate);
            }
            inflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    public static void d0(Object obj) {
        W(2, f3565p, obj);
    }

    public static void e0(String str, Object... objArr) {
        W(2, str, objArr);
    }

    public static void f0(Object obj) {
        W(5, f3565p, obj);
    }

    public static void g0(String str, Object... objArr) {
        W(5, str, objArr);
    }

    public static void h0(int i10, String str) {
        W(i10 | 48, f3565p, str);
    }

    public static void i0(int i10, String str, String str2) {
        W(i10 | 48, str, str2);
    }

    public static void j0(String str) {
        W(51, f3565p, str);
    }

    public static void k0(String str, String str2) {
        W(51, str, str2);
    }
}
