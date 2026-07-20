package jg;

import j3.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final z e = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f6272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hg.i f6273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6274d;

    public c(b hash, j sign, hg.i iVar) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(sign, "sign");
        this.f6271a = hash;
        this.f6272b = sign;
        this.f6273c = iVar;
        this.f6274d = hash.name() + "with" + sign.name();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6271a == cVar.f6271a && this.f6272b == cVar.f6272b && Intrinsics.areEqual(this.f6273c, cVar.f6273c);
    }

    public final int hashCode() {
        int iHashCode = (this.f6272b.hashCode() + (this.f6271a.hashCode() * 31)) * 31;
        hg.i iVar = this.f6273c;
        return iHashCode + (iVar == null ? 0 : iVar.f5365a.hashCode());
    }

    public final String toString() {
        return "HashAndSign(hash=" + this.f6271a + ", sign=" + this.f6272b + ", oid=" + this.f6273c + ')';
    }
}
