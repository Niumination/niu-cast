package hg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f5334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f5337d;
    public final String e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f5341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final jg.b f5343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jg.j f5344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f5345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f5346o;
    public final int p;

    public c(short s2, String name, String openSSLName, p exchangeType, String jdkCipherName, int i8, int i9, int i10, int i11, String macName, int i12, jg.b hash, jg.j signatureAlgorithm, d cipherType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(openSSLName, "openSSLName");
        Intrinsics.checkNotNullParameter(exchangeType, "exchangeType");
        Intrinsics.checkNotNullParameter(jdkCipherName, "jdkCipherName");
        Intrinsics.checkNotNullParameter(macName, "macName");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(signatureAlgorithm, "signatureAlgorithm");
        Intrinsics.checkNotNullParameter(cipherType, "cipherType");
        this.f5334a = s2;
        this.f5335b = name;
        this.f5336c = openSSLName;
        this.f5337d = exchangeType;
        this.e = jdkCipherName;
        this.f = i8;
        this.f5338g = i9;
        this.f5339h = i10;
        this.f5340i = i11;
        this.f5341j = macName;
        this.f5342k = i12;
        this.f5343l = hash;
        this.f5344m = signatureAlgorithm;
        this.f5345n = cipherType;
        this.f5346o = i8 / 8;
        this.p = i12 / 8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5334a == cVar.f5334a && Intrinsics.areEqual(this.f5335b, cVar.f5335b) && Intrinsics.areEqual(this.f5336c, cVar.f5336c) && this.f5337d == cVar.f5337d && Intrinsics.areEqual(this.e, cVar.e) && this.f == cVar.f && this.f5338g == cVar.f5338g && this.f5339h == cVar.f5339h && this.f5340i == cVar.f5340i && Intrinsics.areEqual(this.f5341j, cVar.f5341j) && this.f5342k == cVar.f5342k && this.f5343l == cVar.f5343l && this.f5344m == cVar.f5344m && this.f5345n == cVar.f5345n;
    }

    public final int hashCode() {
        return this.f5345n.hashCode() + ((this.f5344m.hashCode() + ((this.f5343l.hashCode() + a1.a.c(this.f5342k, a1.a.e(a1.a.c(this.f5340i, a1.a.c(this.f5339h, a1.a.c(this.f5338g, a1.a.c(this.f, a1.a.e((this.f5337d.hashCode() + a1.a.e(a1.a.e(Short.hashCode(this.f5334a) * 31, 31, this.f5335b), 31, this.f5336c)) * 31, 31, this.e), 31), 31), 31), 31), 31, this.f5341j), 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CipherSuite(code=" + ((int) this.f5334a) + ", name=" + this.f5335b + ", openSSLName=" + this.f5336c + ", exchangeType=" + this.f5337d + ", jdkCipherName=" + this.e + ", keyStrength=" + this.f + ", fixedIvLength=" + this.f5338g + ", ivLength=" + this.f5339h + ", cipherTagSizeInBytes=" + this.f5340i + ", macName=" + this.f5341j + ", macStrength=" + this.f5342k + ", hash=" + this.f5343l + ", signatureAlgorithm=" + this.f5344m + ", cipherType=" + this.f5345n + ')';
    }

    public /* synthetic */ c(short s2, String str, String str2, p pVar, int i8, jg.b bVar, jg.j jVar) {
        this(s2, str, str2, pVar, "AES/GCM/NoPadding", i8, 4, 12, 16, "AEAD", 0, bVar, jVar, d.GCM);
    }
}
