package yk;

import java.io.File;
import java.security.KeyStore;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends w implements c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public KeyStore f21365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public String f21366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public jn.a<char[]> f21367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final jn.a<char[]> f21368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public File f21369h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(@os.l KeyStore keyStore, @os.l String str, @os.l jn.a<char[]> aVar, @os.l jn.a<char[]> aVar2) {
        super(q.f21430d);
        l0.p(keyStore, "keyStore");
        l0.p(str, "keyAlias");
        l0.p(aVar, "keyStorePassword");
        l0.p(aVar2, "privateKeyPassword");
        q.f21428b.getClass();
        this.f21365d = keyStore;
        this.f21366e = str;
        this.f21367f = aVar;
        this.f21368g = aVar2;
    }

    @Override // yk.c0
    @os.l
    public String c() {
        return this.f21366e;
    }

    @Override // yk.c0
    @os.l
    public jn.a<char[]> d() {
        return this.f21367f;
    }

    @Override // yk.c0
    @os.l
    public KeyStore e() {
        return this.f21365d;
    }

    @Override // yk.c0
    @os.m
    public File f() {
        return this.f21369h;
    }

    @Override // yk.c0
    @os.l
    public jn.a<char[]> g() {
        return this.f21368g;
    }

    public void j(@os.l String str) {
        l0.p(str, "<set-?>");
        this.f21366e = str;
    }

    public void k(@os.l KeyStore keyStore) {
        l0.p(keyStore, "<set-?>");
        this.f21365d = keyStore;
    }

    public void l(@os.l jn.a<char[]> aVar) {
        l0.p(aVar, "<set-?>");
        this.f21367f = aVar;
    }

    public void m(@os.m File file) {
        this.f21369h = file;
    }
}
