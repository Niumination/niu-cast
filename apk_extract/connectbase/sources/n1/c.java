package n1;

import c1.h0;
import java.net.InetAddress;
import java.text.ParseException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@a
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11090a;

    public c(String canonicalForm) {
        this.f11090a = canonicalForm;
    }

    @t1.a
    public static c a(String specifier) throws ParseException {
        try {
            return b(specifier);
        } catch (IllegalArgumentException e10) {
            ParseException parseException = new ParseException(m.a.a("Invalid host specifier: ", specifier), 0);
            parseException.initCause(e10);
            throw parseException;
        }
    }

    public static c b(String specifier) {
        InetAddress inetAddressG;
        b bVarFromString = b.fromString(specifier);
        h0.d(!bVarFromString.hasPort());
        String host = bVarFromString.getHost();
        try {
            inetAddressG = e.g(host);
        } catch (IllegalArgumentException unused) {
            inetAddressG = null;
        }
        if (inetAddressG != null) {
            return new c(e.O(inetAddressG));
        }
        f fVarD = f.d(host);
        if (fVarD.f()) {
            return new c(fVarD.f11205a);
        }
        throw new IllegalArgumentException(m.a.a("Domain name does not have a recognized public suffix: ", host));
    }

    public static boolean c(String specifier) {
        try {
            b(specifier);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@gm.a Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof c) {
            return this.f11090a.equals(((c) other).f11090a);
        }
        return false;
    }

    public int hashCode() {
        return this.f11090a.hashCode();
    }

    public String toString() {
        return this.f11090a;
    }
}
