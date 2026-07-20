package vj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public final class f3 extends n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f17140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<KeyManager> f17142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f17143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f17144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<TrustManager> f17145h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f17147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f17148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<KeyManager> f17150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f17151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f17152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<TrustManager> f17153h;

        public n2 i() {
            if (this.f17147b == null && this.f17150e == null) {
                throw new IllegalStateException("A key manager is required");
            }
            return new f3(this);
        }

        public final void j() {
            this.f17147b = null;
            this.f17148c = null;
            this.f17149d = null;
            this.f17150e = null;
        }

        public final void k() {
            this.f17152g = null;
            this.f17153h = null;
        }

        public b l(c cVar) {
            c1.h0.F(cVar, "clientAuth");
            this.f17151f = cVar;
            return this;
        }

        public b m(File file, File file2) throws IOException {
            return n(file, file2, null);
        }

        public b n(File file, File file2, String str) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    b bVarP = p(fileInputStream, fileInputStream, str);
                    fileInputStream.close();
                    return bVarP;
                } finally {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }

        public b o(InputStream inputStream, InputStream inputStream2) throws IOException {
            return p(inputStream, inputStream2, null);
        }

        public b p(InputStream inputStream, InputStream inputStream2, String str) throws IOException {
            byte[] bArrU = l1.h.u(inputStream);
            byte[] bArrU2 = l1.h.u(inputStream2);
            j();
            this.f17147b = bArrU;
            this.f17148c = bArrU2;
            this.f17149d = str;
            return this;
        }

        public b q(KeyManager... keyManagerArr) {
            List<KeyManager> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(Arrays.asList(keyManagerArr)));
            j();
            this.f17150e = listUnmodifiableList;
            return this;
        }

        public b r() {
            this.f17146a = true;
            return this;
        }

        public b s(File file) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return t(fileInputStream);
            } finally {
                fileInputStream.close();
            }
        }

        public b t(InputStream inputStream) throws IOException {
            byte[] bArrU = l1.h.u(inputStream);
            k();
            this.f17152g = bArrU;
            return this;
        }

        public b u(TrustManager... trustManagerArr) {
            List<TrustManager> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(Arrays.asList(trustManagerArr)));
            k();
            this.f17153h = listUnmodifiableList;
            return this;
        }

        public b() {
            this.f17151f = c.NONE;
        }
    }

    public enum c {
        NONE,
        OPTIONAL,
        REQUIRE
    }

    public enum d {
        FAKE,
        MTLS,
        CUSTOM_MANAGERS
    }

    public f3(b bVar) {
        this.f17138a = bVar.f17146a;
        this.f17139b = bVar.f17147b;
        this.f17140c = bVar.f17148c;
        this.f17141d = bVar.f17149d;
        this.f17142e = bVar.f17150e;
        this.f17143f = bVar.f17151f;
        this.f17144g = bVar.f17152g;
        this.f17145h = bVar.f17153h;
    }

    public static n2 a(File file, File file2) throws IOException {
        return new b().n(file, file2, null).i();
    }

    public static n2 b(InputStream inputStream, InputStream inputStream2) throws IOException {
        return new b().p(inputStream, inputStream2, null).i();
    }

    public static b k() {
        return new b();
    }

    public static void l(Set<d> set, Set<d> set2, d dVar) {
        if (set.contains(dVar)) {
            return;
        }
        set2.add(dVar);
    }

    public byte[] c() {
        byte[] bArr = this.f17139b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public c d() {
        return this.f17143f;
    }

    public List<KeyManager> e() {
        return this.f17142e;
    }

    public byte[] f() {
        byte[] bArr = this.f17140c;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String g() {
        return this.f17141d;
    }

    public byte[] h() {
        byte[] bArr = this.f17144g;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public List<TrustManager> i() {
        return this.f17145h;
    }

    public Set<d> j(Set<d> set) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(d.class);
        if (this.f17138a) {
            l(set, enumSetNoneOf, d.FAKE);
        }
        if (this.f17143f != c.NONE) {
            l(set, enumSetNoneOf, d.MTLS);
        }
        if (this.f17142e != null || this.f17145h != null) {
            l(set, enumSetNoneOf, d.CUSTOM_MANAGERS);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
