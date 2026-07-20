package zg;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import k3.bc;
import kotlin.collections.CollectionsKt;
import li.c2;
import li.f0;
import li.g2;
import li.j0;
import li.j1;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11599a = CollectionsKt.listOf((Object[]) new String[]{"NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG"});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ni.m f11600b = bc.a(1024, 6, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g2 f11601c;

    static {
        f0 f0Var = new f0("nonce-generator");
        j1 j1Var = j1.f7459a;
        v0 v0Var = v0.f7498a;
        f11601c = l0.o(j1Var, si.e.f10118a.plus(c2.f7440a).plus(f0Var), j0.LAZY, new o(null));
    }

    public static final SecureRandom a(String str) {
        try {
            return str != null ? SecureRandom.getInstance(str) : new SecureRandom();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
