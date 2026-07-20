package ai;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
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
public final class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f218o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f219p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f220q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f221r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f222s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f223t = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final char[] f224u = {y5.a.K, 'D', 'I', 'W', 'E', y5.a.G};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f225v = System.getProperty("file.separator");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f226w = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Format f235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f239m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f240n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f243c;

        public a(final String val$fullPath, final String val$content, final String val$tag) {
            this.f241a = val$fullPath;
            this.f242b = val$content;
            this.f243c = val$tag;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            BufferedWriter bufferedWriter;
            IOException e10;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(this.f241a, true));
                    try {
                        try {
                            bufferedWriter.write(this.f242b);
                            Log.d(this.f243c, "log to " + this.f241a + " success!");
                            bufferedWriter.close();
                        } catch (IOException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            Log.e(this.f243c, "log to " + this.f241a + cc.a.f1441c);
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f245a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f246b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f247c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f248d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f249e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f250f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f251g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f252h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f253i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f254j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f255k;

        public d m() {
            return new d(this);
        }

        public b n(boolean borderSwitch) {
            this.f251g = borderSwitch;
            return this;
        }

        public b o(int consoleFilter) {
            this.f252h = consoleFilter;
            return this;
        }

        public b p(boolean consoleSwitch) {
            this.f246b = consoleSwitch;
            return this;
        }

        public b q(final File dir) {
            String str;
            if (dir == null) {
                str = null;
            } else {
                str = dir.getAbsolutePath() + d.f225v;
            }
            this.f255k = str;
            return this;
        }

        public b r(final String dir) {
            if (d.y(dir)) {
                this.f255k = null;
            } else {
                String str = d.f225v;
                if (!dir.endsWith(str)) {
                    dir = j.a.a(dir, str);
                }
                this.f255k = dir;
            }
            return this;
        }

        public b s(int fileFilter) {
            this.f253i = fileFilter;
            return this;
        }

        public b t(final String tag) {
            if (d.y(tag)) {
                this.f247c = "";
                this.f248d = true;
            } else {
                this.f247c = tag;
                this.f248d = false;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("switch: ");
            sb2.append(this.f245a);
            sb2.append(d.f226w);
            sb2.append("console: ");
            sb2.append(this.f246b);
            String str = d.f226w;
            sb2.append(str);
            sb2.append("tag: ");
            sb2.append(this.f248d ? d6.a.E : this.f247c);
            sb2.append(str);
            sb2.append("head: ");
            sb2.append(this.f249e);
            sb2.append(str);
            sb2.append("file: ");
            sb2.append(this.f250f);
            sb2.append(str);
            sb2.append("dir: ");
            String str2 = this.f255k;
            if (str2 == null) {
                str2 = this.f254j;
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append("border: ");
            sb2.append(this.f251g);
            sb2.append(str);
            sb2.append("consoleFilter: ");
            char[] cArr = d.f224u;
            sb2.append(cArr[this.f252h - 2]);
            sb2.append(str);
            sb2.append("fileFilter: ");
            sb2.append(cArr[this.f253i - 2]);
            return sb2.toString();
        }

        public b u(boolean log2FileSwitch) {
            this.f250f = log2FileSwitch;
            return this;
        }

        public b v(boolean logHeadSwitch) {
            this.f249e = logHeadSwitch;
            return this;
        }

        public b w(boolean logSwitch) {
            this.f245a = logSwitch;
            return this;
        }
    }

    public /* synthetic */ d(b bVar, a aVar) {
        this(bVar);
    }

    public static void E(final int type, final String tag, String msg) {
        Log.println(type, tag, msg);
    }

    public static byte[] K(byte[] input) {
        int iInflate;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        try {
            inflater.setInput(input);
            byte[] bArr = new byte[2048];
            while (!inflater.finished()) {
                try {
                    iInflate = inflater.inflate(bArr);
                } catch (DataFormatException e10) {
                    e10.printStackTrace();
                    iInflate = 0;
                }
                byteArrayOutputStream.write(bArr, 0, iInflate);
            }
            inflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    public static byte[] h(byte[] input) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(1);
        try {
            deflater.setInput(input);
            deflater.finish();
            byte[] bArr = new byte[2048];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
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

    public static boolean j(String filePath) {
        File file = new File(filePath);
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

    public static String s(String json) {
        try {
            if (json.startsWith("{")) {
                json = new JSONObject(json).toString(4);
            } else if (json.startsWith("[")) {
                json = new JSONArray(json).toString(4);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return json;
    }

    public static File v(Context context) {
        boolean z10 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z10) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean y(String s10) {
        if (s10 == null) {
            return true;
        }
        int length = s10.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(s10.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public void A(int type, String tag, String contents) {
        D(type | 32, tag, contents);
    }

    public void B(String contents) {
        D(35, this.f239m.f247c, contents);
    }

    public void C(String tag, String contents) {
        D(35, tag, contents);
    }

    public final void D(final int type, String tag, final Object... contents) {
        if (!Log.isLoggable(tag.length() > 23 ? tag.substring(0, 23) : tag, 3)) {
            b bVar = this.f239m;
            if (!bVar.f245a) {
                return;
            }
            if (!bVar.f246b && !bVar.f250f) {
                return;
            }
        }
        int i10 = type & 15;
        int i11 = type & m0.f12864d;
        b bVar2 = this.f239m;
        if (i10 >= bVar2.f252h || i10 >= bVar2.f253i) {
            String[] strArrI = I(tag);
            String strH = H(i11, contents);
            b bVar3 = this.f239m;
            if (bVar3.f246b && i10 >= bVar3.f252h) {
                F(i10, strArrI[0], strArrI[1], strH);
            }
            b bVar4 = this.f239m;
            if ((bVar4.f250f || i11 == 16) && i10 >= bVar4.f253i) {
                G(i10, strArrI[0], j.c.a(new StringBuilder(), strArrI[2], strH));
            }
        }
    }

    public final void F(final int type, String tag, String header, String msg) {
        if (this.f239m.f249e) {
            Log.println(type, tag, "\n" + header);
        } else {
            Log.println(type, tag, " \n");
        }
        if (this.f239m.f251g) {
            Log.println(type, tag, "|---------------------------------------------------------------------------------------------------");
            msg = g(msg);
        }
        int length = msg.length();
        int i10 = length / d6.a.B;
        if (i10 > 0) {
            int i11 = d6.a.B;
            Log.println(type, tag, msg.substring(0, d6.a.B));
            int i12 = 1;
            while (i12 < i10) {
                int i13 = i11 + d6.a.B;
                String strSubstring = msg.substring(i11, i13);
                if (this.f239m.f251g) {
                    strSubstring = m.a.a(d6.a.f3575z, strSubstring);
                }
                Log.println(type, tag, strSubstring);
                i12++;
                i11 = i13;
            }
            String strSubstring2 = msg.substring(i11, length);
            if (this.f239m.f251g) {
                strSubstring2 = m.a.a(d6.a.f3575z, strSubstring2);
            }
            Log.println(type, tag, strSubstring2);
        } else {
            Log.println(type, tag, msg);
        }
        if (this.f239m.f251g) {
            Log.println(type, tag, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public final void G(final int type, final String tag, final String msg) {
        String str = this.f235i.format(new Date(System.currentTimeMillis()));
        String strSubstring = str.substring(0, 5);
        String strSubstring2 = str.substring(6);
        if (this.f239m.f254j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || v(ai.a.a()) == null) {
                b bVar = this.f239m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ai.a.a().getCacheDir());
                String str2 = f225v;
                sb2.append(str2);
                sb2.append("log");
                sb2.append(str2);
                bVar.f254j = sb2.toString();
            } else {
                b bVar2 = this.f239m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(v(ai.a.a()));
                String str3 = f225v;
                sb3.append(str3);
                sb3.append("log");
                sb3.append(str3);
                bVar2.f254j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        b bVar3 = this.f239m;
        String str4 = bVar3.f255k;
        if (str4 == null) {
            str4 = bVar3.f254j;
        }
        sb4.append(str4);
        sb4.append(strSubstring);
        sb4.append(".txt");
        String string = sb4.toString();
        if (!j(string)) {
            Log.e(tag, "log to " + string + cc.a.f1441c);
            return;
        }
        StringBuilder sbA = k.a.a(strSubstring2);
        sbA.append(f224u[type - 2]);
        sbA.append("/");
        sbA.append(tag);
        sbA.append(msg);
        sbA.append(f226w);
        String string2 = sbA.toString();
        if (this.f230d == null) {
            this.f230d = Executors.newSingleThreadExecutor();
        }
        this.f230d.execute(new a(string, string2, tag));
    }

    public final String H(int type, Object... contents) {
        if (contents == null) {
            return d6.a.D;
        }
        int length = contents.length;
        String string = d6.a.E;
        if (length == 1) {
            Object obj = contents[0];
            if (obj != null) {
                string = obj.toString();
            }
            if (type == 32) {
                return s(string);
            }
            return type == 48 ? t(string) : string;
        }
        StringBuilder sb2 = new StringBuilder();
        int length2 = contents.length;
        for (int i10 = 0; i10 < length2; i10++) {
            Object obj2 = contents[i10];
            sb2.append("args[");
            sb2.append(i10);
            sb2.append("] = ");
            sb2.append(obj2 == null ? d6.a.E : obj2.toString());
            sb2.append(f226w);
        }
        return sb2.toString();
    }

    public final String[] I(String tag) {
        String str;
        b bVar = this.f239m;
        if (bVar.f248d || bVar.f249e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f240n + 5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f239m.f248d && y(tag)) {
                tag = className;
            }
            if (this.f239m.f249e) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                StringBuilder sbA = k.a.a(string);
                sbA.append(f226w);
                return new String[]{tag, sbA.toString(), n.a.a(" [", string, "]: ")};
            }
            str = tag;
        } else {
            str = bVar.f247c;
        }
        return new String[]{str, "", ": "};
    }

    public void J(int layer) {
        this.f240n = layer;
    }

    public void L(Object contents) {
        D(2, this.f239m.f247c, contents);
    }

    public void M(String tag, Object... contents) {
        D(2, tag, contents);
    }

    public void N(Object contents) {
        D(5, this.f239m.f247c, contents);
    }

    public void O(String tag, Object... contents) {
        D(5, tag, contents);
    }

    public void P(int type, String contents) {
        D(type | 48, this.f239m.f247c, contents);
    }

    public void Q(int type, String tag, String contents) {
        D(type | 48, tag, contents);
    }

    public void R(String contents) {
        D(51, this.f239m.f247c, contents);
    }

    public void S(String tag, String contents) {
        D(51, tag, contents);
    }

    public void a(Object contents) {
        D(7, this.f239m.f247c, contents);
    }

    public void b(String tag, Object... contents) {
        D(7, tag, contents);
    }

    public final String g(String msg) {
        if (!this.f239m.f251g) {
            return msg;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : msg.split(f226w)) {
            sb2.append(d6.a.f3575z);
            sb2.append(str);
            sb2.append(f226w);
        }
        return sb2.toString();
    }

    public void k(Object contents) {
        D(3, this.f239m.f247c, contents);
    }

    public void l(String tag, Object... contents) {
        D(3, tag, contents);
    }

    public void m(Object contents) {
        D(6, this.f239m.f247c, contents);
    }

    public void n(String tag, Object... contents) {
        D(6, tag, contents);
    }

    public void o(int type, Object contents) {
        D(type | 16, this.f239m.f247c, contents);
    }

    public void p(int type, String tag, Object contents) {
        D(type | 16, tag, contents);
    }

    public void q(Object contents) {
        D(19, this.f239m.f247c, contents);
    }

    public void r(String tag, Object contents) {
        D(19, tag, contents);
    }

    public final String t(String xml) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(xml));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f226w);
        } catch (Exception e10) {
            e10.printStackTrace();
            return xml;
        }
    }

    public b u() {
        return this.f239m;
    }

    public void w(Object contents) {
        D(4, this.f239m.f247c, contents);
    }

    public void x(String tag, Object... contents) {
        D(4, tag, contents);
    }

    public void z(int type, String contents) {
        D(type | 32, this.f239m.f247c, contents);
    }

    public d(b builder) {
        this.f227a = 16;
        this.f228b = 32;
        this.f229c = 48;
        this.f231e = "|---------------------------------------------------------------------------------------------------";
        this.f232f = d6.a.f3575z;
        this.f233g = "|---------------------------------------------------------------------------------------------------";
        this.f234h = d6.a.B;
        this.f235i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f236j = d6.a.D;
        this.f237k = d6.a.E;
        this.f238l = d6.a.F;
        new b();
        this.f240n = 0;
        this.f239m = builder;
    }
}
