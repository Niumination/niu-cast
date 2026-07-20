package l1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class h0 {

    public class a implements y<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f9582a = new ArrayList();

        @Override // l1.y
        public boolean b(String line) {
            this.f9582a.add(line);
            return true;
        }

        @Override // l1.y
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a() {
            return this.f9582a;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f9583a;

        public /* synthetic */ b(URL url, a aVar) {
            this(url);
        }

        @Override // l1.g
        public InputStream m() throws IOException {
            return this.f9583a.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.f9583a + ")";
        }

        public b(URL url) {
            url.getClass();
            this.f9583a = url;
        }
    }

    public static g a(URL url) {
        return new b(url);
    }

    public static k b(URL url, Charset charset) {
        return new g.a(charset);
    }

    public static void c(URL from, OutputStream to2) throws IOException {
        new b(from).f(to2);
    }

    @t1.a
    public static URL d(Class<?> contextClass, String resourceName) {
        URL resource = contextClass.getResource(resourceName);
        c1.h0.y(resource != null, "resource %s relative to %s not found.", resourceName, contextClass.getName());
        return resource;
    }

    @t1.a
    public static URL e(String resourceName) {
        URL resource = ((ClassLoader) c1.z.a(Thread.currentThread().getContextClassLoader(), h0.class.getClassLoader())).getResource(resourceName);
        c1.h0.u(resource != null, "resource %s not found.", resourceName);
        return resource;
    }

    @t1.a
    @e0
    public static <T> T f(URL url, Charset charset, y<T> yVar) throws IOException {
        return (T) b(url, charset).q(yVar);
    }

    public static List<String> g(URL url, Charset charset) throws IOException {
        return (List) f(url, charset, new a());
    }

    public static byte[] h(URL url) throws IOException {
        return new b(url).o();
    }

    public static String i(URL url, Charset charset) throws IOException {
        return b(url, charset).n();
    }
}
