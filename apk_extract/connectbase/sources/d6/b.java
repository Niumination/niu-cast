package d6;

import android.os.Environment;
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
public final class b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3579o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f3580p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3581q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f3582r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f3583s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3584t = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final char[] f3585u = {y5.a.K, 'D', 'I', 'W', 'E', y5.a.G};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f3586v = System.getProperty("file.separator");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f3587w = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f3591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Format f3596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0083b f3600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3601n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3604c;

        public a(String str, String str2, String str3) {
            this.f3602a = str;
            this.f3603b = str2;
            this.f3604c = str3;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            BufferedWriter bufferedWriter;
            IOException e10;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(this.f3602a, true));
                    try {
                        try {
                            bufferedWriter.write(this.f3603b);
                            Log.d(this.f3604c, "log to " + this.f3602a + " success!");
                            bufferedWriter.close();
                        } catch (IOException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            Log.e(this.f3604c, "log to " + this.f3602a + cc.a.f1441c);
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

    /* JADX INFO: renamed from: d6.b$b, reason: collision with other inner class name */
    public static class C0083b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3606a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3607b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3608c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3609d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3610e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3611f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3612g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3613h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3614i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f3615j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f3616k;

        public b m() {
            return new b(this);
        }

        public C0083b n(boolean z10) {
            this.f3612g = z10;
            return this;
        }

        public C0083b o(int i10) {
            this.f3613h = i10;
            return this;
        }

        public C0083b p(boolean z10) {
            this.f3607b = z10;
            return this;
        }

        public C0083b q(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + b.f3586v;
            }
            this.f3616k = str;
            return this;
        }

        public C0083b r(String str) {
            if (b.x(str)) {
                this.f3616k = null;
            } else {
                String str2 = b.f3586v;
                if (!str.endsWith(str2)) {
                    str = j.a.a(str, str2);
                }
                this.f3616k = str;
            }
            return this;
        }

        public C0083b s(int i10) {
            this.f3614i = i10;
            return this;
        }

        public C0083b t(String str) {
            if (b.x(str)) {
                this.f3608c = "";
                this.f3609d = true;
            } else {
                this.f3608c = str;
                this.f3609d = false;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("switch: ");
            sb2.append(this.f3606a);
            sb2.append(b.f3587w);
            sb2.append("console: ");
            sb2.append(this.f3607b);
            String str = b.f3587w;
            sb2.append(str);
            sb2.append("tag: ");
            sb2.append(this.f3609d ? d6.a.E : this.f3608c);
            sb2.append(str);
            sb2.append("head: ");
            sb2.append(this.f3610e);
            sb2.append(str);
            sb2.append("file: ");
            sb2.append(this.f3611f);
            sb2.append(str);
            sb2.append("dir: ");
            String str2 = this.f3616k;
            if (str2 == null) {
                str2 = this.f3615j;
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append("border: ");
            sb2.append(this.f3612g);
            sb2.append(str);
            sb2.append("consoleFilter: ");
            char[] cArr = b.f3585u;
            sb2.append(cArr[this.f3613h - 2]);
            sb2.append(str);
            sb2.append("fileFilter: ");
            sb2.append(cArr[this.f3614i - 2]);
            return sb2.toString();
        }

        public C0083b u(boolean z10) {
            this.f3611f = z10;
            return this;
        }

        public C0083b v(boolean z10) {
            this.f3610e = z10;
            return this;
        }

        public C0083b w(boolean z10) {
            this.f3606a = z10;
            return this;
        }
    }

    public /* synthetic */ b(C0083b c0083b, a aVar) {
        this(c0083b);
    }

    public static void D(int i10, String str, String str2) {
        Log.println(i10, str, str2);
    }

    public static byte[] J(byte[] bArr) {
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

    public static byte[] h(byte[] bArr) {
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

    public static boolean i(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean j(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!i(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String s(String str) {
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

    public static boolean x(String str) {
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

    public void A(String str) {
        C(35, this.f3600m.f3608c, str);
    }

    public void B(String str, String str2) {
        C(35, str, str2);
    }

    public final void C(int i10, String str, Object... objArr) {
        try {
            if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
                C0083b c0083b = this.f3600m;
                if (!c0083b.f3606a) {
                    return;
                }
                if (!c0083b.f3607b && !c0083b.f3611f) {
                    return;
                }
            }
            int i11 = i10 & 15;
            int i12 = i10 & m0.f12864d;
            C0083b c0083b2 = this.f3600m;
            if (i11 >= c0083b2.f3613h || i11 >= c0083b2.f3614i) {
                String[] strArrH = H(str);
                String strG = G(i12, objArr);
                C0083b c0083b3 = this.f3600m;
                if (c0083b3.f3607b && i11 >= c0083b3.f3613h) {
                    E(i11, strArrH[0], strArrH[1], strG);
                }
                C0083b c0083b4 = this.f3600m;
                if ((c0083b4.f3611f || i12 == 16) && i11 >= c0083b4.f3614i) {
                    F(i11, strArrH[0], strArrH[2] + strG);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void E(int i10, String str, String str2, String str3) {
        if (this.f3600m.f3610e) {
            Log.println(i10, str, "\n" + str2);
        } else {
            Log.println(i10, str, " \n");
        }
        if (this.f3600m.f3612g) {
            Log.println(i10, str, "|---------------------------------------------------------------------------------------------------");
            str3 = g(str3);
        }
        int length = str3.length();
        int i11 = length / d6.a.B;
        if (i11 > 0) {
            int i12 = d6.a.B;
            Log.println(i10, str, str3.substring(0, d6.a.B));
            int i13 = 1;
            while (i13 < i11) {
                int i14 = i12 + d6.a.B;
                String strSubstring = str3.substring(i12, i14);
                if (this.f3600m.f3612g) {
                    strSubstring = m.a.a(d6.a.f3575z, strSubstring);
                }
                Log.println(i10, str, strSubstring);
                i13++;
                i12 = i14;
            }
            String strSubstring2 = str3.substring(i12, length);
            if (this.f3600m.f3612g) {
                strSubstring2 = m.a.a(d6.a.f3575z, strSubstring2);
            }
            Log.println(i10, str, strSubstring2);
        } else {
            Log.println(i10, str, str3);
        }
        if (this.f3600m.f3612g) {
            Log.println(i10, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public final void F(int i10, String str, String str2) {
        String str3 = this.f3596i.format(new Date(System.currentTimeMillis()));
        String strSubstring = str3.substring(0, 5);
        String strSubstring2 = str3.substring(6);
        if (this.f3600m.f3615j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || f6.b.a(b6.b.a()) == null) {
                C0083b c0083b = this.f3600m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b6.b.a().getCacheDir());
                String str4 = f3586v;
                sb2.append(str4);
                sb2.append("log");
                sb2.append(str4);
                c0083b.f3615j = sb2.toString();
            } else {
                C0083b c0083b2 = this.f3600m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f6.b.a(b6.b.a()));
                String str5 = f3586v;
                sb3.append(str5);
                sb3.append("log");
                sb3.append(str5);
                c0083b2.f3615j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        C0083b c0083b3 = this.f3600m;
        String str6 = c0083b3.f3616k;
        if (str6 == null) {
            str6 = c0083b3.f3615j;
        }
        sb4.append(str6);
        sb4.append(strSubstring);
        sb4.append(".txt");
        String string = sb4.toString();
        if (!j(string)) {
            Log.e(str, "log to " + string + cc.a.f1441c);
            return;
        }
        StringBuilder sbA = k.a.a(strSubstring2);
        sbA.append(f3585u[i10 - 2]);
        sbA.append("/");
        sbA.append(str);
        sbA.append(str2);
        sbA.append(f3587w);
        String string2 = sbA.toString();
        if (this.f3591d == null) {
            this.f3591d = Executors.newSingleThreadExecutor();
        }
        this.f3591d.execute(new a(string, string2, str));
    }

    public final String G(int i10, Object... objArr) {
        if (objArr == null) {
            return d6.a.D;
        }
        int length = objArr.length;
        String string = d6.a.E;
        if (length == 1) {
            Object obj = objArr[0];
            if (obj != null) {
                string = obj.toString();
            }
            if (i10 == 32) {
                return s(string);
            }
            return i10 == 48 ? t(string) : string;
        }
        StringBuilder sb2 = new StringBuilder();
        int length2 = objArr.length;
        for (int i11 = 0; i11 < length2; i11++) {
            Object obj2 = objArr[i11];
            sb2.append("args[");
            sb2.append(i11);
            sb2.append("] = ");
            sb2.append(obj2 == null ? d6.a.E : obj2.toString());
            sb2.append(f3587w);
        }
        return sb2.toString();
    }

    public final String[] H(String str) {
        String str2;
        C0083b c0083b = this.f3600m;
        if (c0083b.f3609d || c0083b.f3610e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f3601n + 5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f3600m.f3609d && x(str)) {
                str = className;
            }
            if (this.f3600m.f3610e) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                StringBuilder sbA = k.a.a(string);
                sbA.append(f3587w);
                return new String[]{str, sbA.toString(), n.a.a(" [", string, "]: ")};
            }
            str2 = str;
        } else {
            str2 = c0083b.f3608c;
        }
        return new String[]{str2, "", ": "};
    }

    public void I(int i10) {
        this.f3601n = i10;
    }

    public void K(Object obj) {
        C(2, this.f3600m.f3608c, obj);
    }

    public void L(String str, Object... objArr) {
        C(2, str, objArr);
    }

    public void M(Object obj) {
        C(5, this.f3600m.f3608c, obj);
    }

    public void N(String str, Object... objArr) {
        C(5, str, objArr);
    }

    public void O(int i10, String str) {
        C(i10 | 48, this.f3600m.f3608c, str);
    }

    public void P(int i10, String str, String str2) {
        C(i10 | 48, str, str2);
    }

    public void Q(String str) {
        C(51, this.f3600m.f3608c, str);
    }

    public void R(String str, String str2) {
        C(51, str, str2);
    }

    public void a(Object obj) {
        C(7, this.f3600m.f3608c, obj);
    }

    public void b(String str, Object... objArr) {
        C(7, str, objArr);
    }

    public final String g(String str) {
        if (!this.f3600m.f3612g) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f3587w)) {
            sb2.append(d6.a.f3575z);
            sb2.append(str2);
            sb2.append(f3587w);
        }
        return sb2.toString();
    }

    public void k(Object obj) {
        C(3, this.f3600m.f3608c, obj);
    }

    public void l(String str, Object... objArr) {
        C(3, str, objArr);
    }

    public void m(Object obj) {
        C(6, this.f3600m.f3608c, obj);
    }

    public void n(String str, Object... objArr) {
        C(6, str, objArr);
    }

    public void o(int i10, Object obj) {
        C(i10 | 16, this.f3600m.f3608c, obj);
    }

    public void p(int i10, String str, Object obj) {
        C(i10 | 16, str, obj);
    }

    public void q(Object obj) {
        C(19, this.f3600m.f3608c, obj);
    }

    public void r(String str, Object obj) {
        C(19, str, obj);
    }

    public final String t(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f3587w);
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public C0083b u() {
        return this.f3600m;
    }

    public void v(Object obj) {
        C(4, this.f3600m.f3608c, obj);
    }

    public void w(String str, Object... objArr) {
        C(4, str, objArr);
    }

    public void y(int i10, String str) {
        C(i10 | 32, this.f3600m.f3608c, str);
    }

    public void z(int i10, String str, String str2) {
        C(i10 | 32, str, str2);
    }

    public b(C0083b c0083b) {
        this.f3588a = 16;
        this.f3589b = 32;
        this.f3590c = 48;
        this.f3592e = "|---------------------------------------------------------------------------------------------------";
        this.f3593f = d6.a.f3575z;
        this.f3594g = "|---------------------------------------------------------------------------------------------------";
        this.f3595h = d6.a.B;
        this.f3596i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f3597j = d6.a.D;
        this.f3598k = d6.a.E;
        this.f3599l = d6.a.F;
        new C0083b();
        this.f3601n = 0;
        this.f3600m = c0083b;
    }
}
