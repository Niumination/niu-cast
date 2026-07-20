package hg;

import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublicKey f5354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublicKey f5355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrivateKey f5356c;

    public g(PublicKey serverPublic, PublicKey clientPublic, PrivateKey clientPrivate) {
        Intrinsics.checkNotNullParameter(serverPublic, "serverPublic");
        Intrinsics.checkNotNullParameter(clientPublic, "clientPublic");
        Intrinsics.checkNotNullParameter(clientPrivate, "clientPrivate");
        this.f5354a = serverPublic;
        this.f5355b = clientPublic;
        this.f5356c = clientPrivate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.f5354a, gVar.f5354a) && Intrinsics.areEqual(this.f5355b, gVar.f5355b) && Intrinsics.areEqual(this.f5356c, gVar.f5356c);
    }

    public final int hashCode() {
        return this.f5356c.hashCode() + ((this.f5355b.hashCode() + (this.f5354a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "EncryptionInfo(serverPublic=" + this.f5354a + ", clientPublic=" + this.f5355b + ", clientPrivate=" + this.f5356c + ')';
    }
}
