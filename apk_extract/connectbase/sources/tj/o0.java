package tj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 implements sj.r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<LinkedList<o0>> f15706d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f15707e = 50;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f15708f = "application/json";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f15709g = "text/x-java-properties";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f15710h = "application/hocon";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sj.e f15711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sj.q f15712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public sj.o f15713c;

    public static class a extends ThreadLocal<LinkedList<o0>> {
        public LinkedList<o0> a() {
            return new LinkedList<>();
        }

        @Override // java.lang.ThreadLocal
        public LinkedList<o0> initialValue() {
            return new LinkedList<>();
        }
    }

    public static class b extends FilterReader {
        public b(Reader reader) {
            super(reader);
        }

        @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15714a;

        static {
            int[] iArr = new int[sj.v.values().length];
            f15714a = iArr;
            try {
                iArr[sj.v.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15714a[sj.v.CONF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15714a[sj.v.PROPERTIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class d extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final File f15715i;

        public d(File file, sj.q qVar) {
            this.f15715i = file;
            D(qVar);
        }

        @Override // tj.o0
        public Reader I() throws IOException {
            if (m.M()) {
                o0.O("Loading config from a file: " + this.f15715i);
            }
            return o0.L(new FileInputStream(this.f15715i), "UTF-8");
        }

        @Override // tj.o0
        public sj.r a(String str) {
            File file = new File(str).isAbsolute() ? new File(str) : o0.M(this.f15715i, str);
            if (file == null) {
                return null;
            }
            if (file.exists()) {
                o0.O(file + " exists, so loading it as a file");
                return new d(file, this.f15712b.l(null));
            }
            o0.O(file + " does not exist, so trying it as a classpath resource");
            return super.a(str);
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.q(this.f15715i.getPath());
        }

        @Override // tj.o0
        public sj.v l() {
            return n.l(this.f15715i.getName());
        }

        @Override // tj.o0
        public String toString() {
            return d.class.getSimpleName() + "(" + this.f15715i.getPath() + ")";
        }
    }

    public static final class e extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f15716i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f15717j;

        public e(String str, String str2, sj.q qVar) {
            this.f15716i = str;
            this.f15717j = str2;
            D(qVar);
        }

        @Override // tj.o0
        public Reader I() throws IOException {
            throw new FileNotFoundException(this.f15717j);
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.t(this.f15716i);
        }
    }

    public static final class f extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Properties f15718i;

        public f(Properties properties, sj.q qVar) {
            this.f15718i = properties;
            D(qVar);
        }

        @Override // tj.o0
        public Reader I() throws IOException {
            throw new sj.c.d("reader() should not be called on props");
        }

        @Override // tj.o0
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public tj.c H(sj.o oVar, sj.q qVar) {
            if (m.M()) {
                o0.O("Loading config from properties " + this.f15718i);
            }
            return s0.e(oVar, this.f15718i);
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.t("properties");
        }

        @Override // tj.o0
        public sj.v l() {
            return sj.v.PROPERTIES;
        }

        @Override // tj.o0
        public String toString() {
            return f.class.getSimpleName() + "(" + this.f15718i.size() + " props)";
        }
    }

    public static final class g extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Reader f15719i;

        public g(Reader reader, sj.q qVar) {
            this.f15719i = reader;
            D(qVar);
        }

        @Override // tj.o0
        public Reader I() {
            if (m.M()) {
                o0.O("Loading config from reader " + this.f15719i);
            }
            return this.f15719i;
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.t("Reader");
        }
    }

    public static final class h extends k {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final l f15720k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f15721l;

        public h(URL url, sj.q qVar, String str, l lVar) {
            super(url);
            this.f15720k = lVar;
            this.f15721l = str;
            D(qVar);
        }

        @Override // tj.o0.k, tj.o0
        public sj.r a(String str) {
            return this.f15720k.a(str);
        }

        @Override // tj.o0.k, tj.o0
        public sj.o h() {
            return g1.s(this.f15721l, this.f15724i);
        }
    }

    public static final class i extends o0 implements l {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f15722i;

        public i(String str, sj.q qVar) {
            this.f15722i = str;
            D(qVar);
        }

        public static String P(String str) {
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf < 0) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        }

        @Override // tj.o0
        public Reader I() throws IOException {
            throw new sj.c.d("reader() should not be called on resources");
        }

        @Override // tj.o0
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public tj.c H(sj.o oVar, sj.q qVar) throws IOException {
            ClassLoader classLoaderD = qVar.d();
            if (classLoaderD == null) {
                throw new sj.c.d("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
            }
            Enumeration<URL> resources = classLoaderD.getResources(this.f15722i);
            if (!resources.hasMoreElements()) {
                if (m.M()) {
                    o0.O("Loading config from class loader " + classLoaderD + " but there were no resources called " + this.f15722i);
                }
                throw new IOException("resource not found on classpath: " + this.f15722i);
            }
            tj.c cVarEmpty = f1.empty(oVar);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                if (m.M()) {
                    o0.O("Loading config from resource '" + this.f15722i + "' URL " + urlNextElement.toExternalForm() + " from class loader " + classLoaderD);
                }
                cVarEmpty = cVarEmpty.withFallback((sj.m) new h(urlNextElement, qVar, this.f15722i, this).A());
            }
            return cVarEmpty;
        }

        @Override // tj.o0
        public sj.r a(String str) {
            if (str.startsWith("/")) {
                return o0.t(str.substring(1), this.f15712b.l(null));
            }
            String strP = P(this.f15722i);
            if (strP == null) {
                return o0.t(str, this.f15712b.l(null));
            }
            return o0.t(strP + "/" + str, this.f15712b.l(null));
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.s(this.f15722i, null);
        }

        @Override // tj.o0
        public sj.v l() {
            return n.l(this.f15722i);
        }

        @Override // tj.o0
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i.class.getSimpleName());
            sb2.append("(");
            return j.c.a(sb2, this.f15722i, ")");
        }
    }

    public static final class j extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f15723i;

        public j(String str, sj.q qVar) {
            this.f15723i = str;
            D(qVar);
        }

        @Override // tj.o0
        public Reader I() {
            if (m.M()) {
                o0.O("Loading config from a String " + this.f15723i);
            }
            return new StringReader(this.f15723i);
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.t("String");
        }

        @Override // tj.o0
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j.class.getSimpleName());
            sb2.append("(");
            return j.c.a(sb2, this.f15723i, ")");
        }
    }

    public interface l {
        sj.r a(String str);
    }

    public static Reader K(InputStream inputStream) {
        return L(inputStream, "UTF-8");
    }

    public static Reader L(InputStream inputStream, String str) {
        try {
            return new BufferedReader(new InputStreamReader(inputStream, str));
        } catch (UnsupportedEncodingException e10) {
            throw new sj.c.d("Java runtime does not support UTF-8", e10);
        }
    }

    public static File M(File file, String str) {
        File parentFile;
        if (new File(str).isAbsolute() || (parentFile = file.getParentFile()) == null) {
            return null;
        }
        return new File(parentFile, str);
    }

    public static URL N(URL url, String str) {
        if (new File(str).isAbsolute()) {
            return null;
        }
        try {
            return url.toURI().resolve(new URI(str)).toURL();
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            return null;
        }
    }

    public static void O(String str) {
        if (m.M()) {
            m.L(str);
        }
    }

    public static Reader d(InputStream inputStream) {
        return L(inputStream, "UTF-8");
    }

    public static o0 e(URL url, sj.q qVar, String str, l lVar) {
        return new h(url, qVar, str, lVar);
    }

    public static String g(Class<?> cls, String str) {
        if (str.startsWith("/")) {
            return str.substring(1);
        }
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return str;
        }
        return name.substring(0, iLastIndexOf).replace(n1.e.f11183c, el.b0.f4502a) + "/" + str;
    }

    public static Reader i(Reader reader) {
        return new b(reader);
    }

    public static tj.c k(sj.x xVar) {
        if (xVar instanceof tj.c) {
            return (tj.c) xVar;
        }
        throw new sj.c.n(xVar.origin(), "", "object at file root", xVar.valueType().name());
    }

    public static o0 n(File file, sj.q qVar) {
        return new d(file, qVar);
    }

    public static o0 o(String str, String str2, sj.q qVar) {
        return new e(str, str2, qVar);
    }

    public static o0 p(Properties properties, sj.q qVar) {
        return new f(properties, qVar);
    }

    public static o0 q(Reader reader, sj.q qVar) {
        return new g(new b(reader), qVar);
    }

    public static o0 r(URL url, sj.q qVar, String str, l lVar) {
        return new h(url, qVar, str, lVar);
    }

    public static o0 s(Class<?> cls, String str, sj.q qVar) {
        return t(g(cls, str), qVar.j(cls.getClassLoader()));
    }

    public static o0 t(String str, sj.q qVar) {
        if (qVar.d() != null) {
            return new i(str, qVar);
        }
        throw new sj.c.d("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
    }

    public static o0 u(String str, sj.q qVar) {
        return new j(str, qVar);
    }

    public static o0 v(URL url, sj.q qVar) {
        return url.getProtocol().equals("file") ? new d(n.p(url), qVar) : new k(url, qVar);
    }

    public tj.d A() {
        return C(b());
    }

    public final tj.d B(sj.o oVar, sj.q qVar) {
        try {
            return H(oVar, qVar);
        } catch (IOException e10) {
            if (qVar.f15092c) {
                O(e10.getMessage() + ". Allowing Missing File, this can be turned off by setting ConfigParseOptions.allowMissing = false");
                return f1.emptyMissing(oVar);
            }
            O("exception loading " + oVar.description() + ": " + e10.getClass().getName() + ": " + e10.getMessage());
            throw new sj.c.f(oVar, e10.getClass().getName() + ": " + e10.getMessage(), e10);
        }
    }

    public final tj.d C(sj.q qVar) {
        sj.q qVarJ = j(qVar);
        String str = qVarJ.f15091b;
        return B(str != null ? g1.t(str) : this.f15713c, qVarJ);
    }

    public void D(sj.q qVar) {
        this.f15712b = j(qVar);
        this.f15711a = new h1(this);
        String str = this.f15712b.f15091b;
        if (str != null) {
            this.f15713c = g1.t(str);
        } else {
            this.f15713c = h();
        }
    }

    public final uj.a E(Reader reader, sj.o oVar, sj.q qVar) throws IOException {
        return new d1(tj.k.a(m1.d(oVar, reader, qVar.f15090a), oVar, qVar), qVar);
    }

    public uj.a F(sj.o oVar, sj.q qVar) throws IOException {
        Reader readerJ = J(qVar);
        sj.v vVarF = f();
        if (vVarF != null) {
            if (m.M() && qVar.f15090a != null) {
                O("Overriding syntax " + qVar.f15090a + " with Content-Type which specified " + vVarF);
            }
            qVar = qVar.m(vVarF);
        }
        try {
            return E(readerJ, oVar, qVar);
        } finally {
            readerJ.close();
        }
    }

    public final tj.d G(Reader reader, sj.o oVar, sj.q qVar) throws IOException {
        sj.v vVar = qVar.f15090a;
        return vVar == sj.v.PROPERTIES ? s0.i(reader, oVar) : e0.a(tj.k.a(m1.d(oVar, reader, vVar), oVar, qVar), oVar, qVar, m());
    }

    public tj.d H(sj.o oVar, sj.q qVar) throws IOException {
        Reader readerJ = J(qVar);
        sj.v vVarF = f();
        if (vVarF != null) {
            if (m.M() && qVar.f15090a != null) {
                O("Overriding syntax " + qVar.f15090a + " with Content-Type which specified " + vVarF);
            }
            qVar = qVar.m(vVarF);
        }
        try {
            return G(readerJ, oVar, qVar);
        } finally {
            readerJ.close();
        }
    }

    public abstract Reader I() throws IOException;

    public Reader J(sj.q qVar) throws IOException {
        return I();
    }

    public sj.r a(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        return t(str, b().l(null));
    }

    @Override // sj.r
    public sj.q b() {
        return this.f15712b;
    }

    @Override // sj.r
    public sj.n c(sj.q qVar) {
        LinkedList<o0> linkedList = f15706d.get();
        if (linkedList.size() >= 50) {
            throw new sj.c.j(this.f15713c, "include statements nested more than 50 times, you probably have a cycle in your includes. Trace: " + linkedList);
        }
        linkedList.addFirst(this);
        try {
            tj.c cVarK = k(C(qVar));
            linkedList.removeFirst();
            if (linkedList.isEmpty()) {
            }
            return cVarK;
        } finally {
            linkedList.removeFirst();
            if (linkedList.isEmpty()) {
                f15706d.remove();
            }
        }
    }

    public sj.v f() {
        return null;
    }

    public abstract sj.o h();

    public final sj.q j(sj.q qVar) {
        sj.v vVarL = qVar.f15090a;
        if (vVarL == null) {
            vVarL = l();
        }
        if (vVarL == null) {
            vVarL = sj.v.CONF;
        }
        sj.q qVarA = qVar.m(vVarL).a(m.f());
        return qVarA.k(i1.l(qVarA.f15093d));
    }

    public sj.v l() {
        return null;
    }

    public sj.e m() {
        return this.f15711a;
    }

    @Override // sj.r
    public final sj.o origin() {
        return this.f15713c;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public sj.n w() {
        return k(C(b()));
    }

    public uj.a x() {
        return z(b());
    }

    public final uj.a y(sj.o oVar, sj.q qVar) {
        try {
            return F(oVar, qVar);
        } catch (IOException e10) {
            if (qVar.f15092c) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new x(new ArrayList()));
                return new d1(new z(arrayList, oVar), qVar);
            }
            O("exception loading " + oVar.description() + ": " + e10.getClass().getName() + ": " + e10.getMessage());
            throw new sj.c.f(oVar, e10.getClass().getName() + ": " + e10.getMessage(), e10);
        }
    }

    public final uj.a z(sj.q qVar) {
        sj.q qVarJ = j(qVar);
        String str = qVarJ.f15091b;
        return y(str != null ? g1.t(str) : this.f15713c, qVarJ);
    }

    public static class k extends o0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final URL f15724i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f15725j;

        public k(URL url) {
            this.f15725j = null;
            this.f15724i = url;
        }

        public static String P(sj.q qVar) {
            sj.v vVar = qVar.f15090a;
            if (vVar == null) {
                return null;
            }
            int i10 = c.f15714a[vVar.ordinal()];
            if (i10 == 1) {
                return "application/json";
            }
            if (i10 == 2) {
                return o0.f15710h;
            }
            if (i10 != 3) {
                return null;
            }
            return o0.f15709g;
        }

        @Override // tj.o0
        public Reader I() throws IOException {
            throw new sj.c.d("reader() without options should not be called on ParseableURL");
        }

        @Override // tj.o0
        public Reader J(sj.q qVar) throws IOException {
            try {
                if (m.M()) {
                    o0.O("Loading config from a URL: " + this.f15724i.toExternalForm());
                }
                URLConnection uRLConnectionOpenConnection = this.f15724i.openConnection();
                String strP = P(qVar);
                if (strP != null) {
                    uRLConnectionOpenConnection.setRequestProperty("Accept", strP);
                }
                uRLConnectionOpenConnection.connect();
                String contentType = uRLConnectionOpenConnection.getContentType();
                this.f15725j = contentType;
                if (contentType != null) {
                    if (m.M()) {
                        o0.O("URL sets Content-Type: '" + this.f15725j + "'");
                    }
                    String strTrim = this.f15725j.trim();
                    this.f15725j = strTrim;
                    int iIndexOf = strTrim.indexOf(59);
                    if (iIndexOf >= 0) {
                        this.f15725j = this.f15725j.substring(0, iIndexOf);
                    }
                }
                return o0.L(uRLConnectionOpenConnection.getInputStream(), "UTF-8");
            } catch (FileNotFoundException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new sj.c.d("Cannot load config from URL: " + this.f15724i.toExternalForm(), e11);
            }
        }

        @Override // tj.o0
        public sj.r a(String str) {
            URL urlN = o0.N(this.f15724i, str);
            if (urlN == null) {
                return null;
            }
            return o0.v(urlN, b().l(null));
        }

        @Override // tj.o0
        public sj.v f() {
            String str = this.f15725j;
            if (str != null) {
                if (str.equals("application/json")) {
                    return sj.v.JSON;
                }
                if (this.f15725j.equals(o0.f15709g)) {
                    return sj.v.PROPERTIES;
                }
                if (this.f15725j.equals(o0.f15710h)) {
                    return sj.v.CONF;
                }
                if (m.M()) {
                    o0.O("'" + this.f15725j + "' isn't a known content type");
                }
            }
            return null;
        }

        @Override // tj.o0
        public sj.o h() {
            return g1.u(this.f15724i);
        }

        @Override // tj.o0
        public sj.v l() {
            return n.l(this.f15724i.getPath());
        }

        @Override // tj.o0
        public String toString() {
            return getClass().getSimpleName() + "(" + this.f15724i.toExternalForm() + ")";
        }

        public k(URL url, sj.q qVar) {
            this(url);
            D(qVar);
        }
    }
}
