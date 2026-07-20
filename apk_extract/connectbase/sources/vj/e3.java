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
public final class e3 extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f17123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<KeyManager> f17125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f17126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<TrustManager> f17127g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f17129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f17130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<KeyManager> f17132e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f17133f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<TrustManager> f17134g;

        public b() {
        }

        public g h() {
            return new e3(this);
        }

        public final void i() {
            this.f17129b = null;
            this.f17130c = null;
            this.f17131d = null;
            this.f17132e = null;
        }

        public final void j() {
            this.f17133f = null;
            this.f17134g = null;
        }

        public b k(File file, File file2) throws IOException {
            return l(file, file2, null);
        }

        public b l(File file, File file2, String str) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    b bVarN = n(fileInputStream, fileInputStream, str);
                    fileInputStream.close();
                    return bVarN;
                } finally {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }

        public b m(InputStream inputStream, InputStream inputStream2) throws IOException {
            return n(inputStream, inputStream2, null);
        }

        public b n(InputStream inputStream, InputStream inputStream2, String str) throws IOException {
            byte[] bArrU = l1.h.u(inputStream);
            byte[] bArrU2 = l1.h.u(inputStream2);
            i();
            this.f17129b = bArrU;
            this.f17130c = bArrU2;
            this.f17131d = str;
            return this;
        }

        public b o(KeyManager... keyManagerArr) {
            List<KeyManager> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(Arrays.asList(keyManagerArr)));
            i();
            this.f17132e = listUnmodifiableList;
            return this;
        }

        public b p() {
            this.f17128a = true;
            return this;
        }

        public b q(File file) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return r(fileInputStream);
            } finally {
                fileInputStream.close();
            }
        }

        public b r(InputStream inputStream) throws IOException {
            byte[] bArrU = l1.h.u(inputStream);
            j();
            this.f17133f = bArrU;
            return this;
        }

        public b s(TrustManager... trustManagerArr) {
            List<TrustManager> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(Arrays.asList(trustManagerArr)));
            j();
            this.f17134g = listUnmodifiableList;
            return this;
        }

        public b(a aVar) {
        }
    }

    public enum c {
        FAKE,
        MTLS,
        CUSTOM_MANAGERS
    }

    public e3(b bVar) {
        this.f17121a = bVar.f17128a;
        this.f17122b = bVar.f17129b;
        this.f17123c = bVar.f17130c;
        this.f17124d = bVar.f17131d;
        this.f17125e = bVar.f17132e;
        this.f17126f = bVar.f17133f;
        this.f17127g = bVar.f17134g;
    }

    public static g b() {
        return new e3(new b());
    }

    public static b j() {
        return new b();
    }

    public static void k(Set<c> set, Set<c> set2, c cVar) {
        if (set.contains(cVar)) {
            return;
        }
        set2.add(cVar);
    }

    @Override // vj.g
    public g a() {
        return this;
    }

    public byte[] c() {
        byte[] bArr = this.f17122b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public List<KeyManager> d() {
        return this.f17125e;
    }

    public byte[] e() {
        byte[] bArr = this.f17123c;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String f() {
        return this.f17124d;
    }

    public byte[] g() {
        byte[] bArr = this.f17126f;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public List<TrustManager> h() {
        return this.f17127g;
    }

    public Set<c> i(Set<c> set) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(c.class);
        if (this.f17121a) {
            k(set, enumSetNoneOf, c.FAKE);
        }
        if (this.f17126f != null || this.f17123c != null || this.f17125e != null) {
            k(set, enumSetNoneOf, c.MTLS);
        }
        if (this.f17125e != null || this.f17127g != null) {
            k(set, enumSetNoneOf, c.CUSTOM_MANAGERS);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
