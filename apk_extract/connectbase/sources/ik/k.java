package ik;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    @os.m
    public static final Charset a(@os.l z zVar) {
        kn.l0.p(zVar, "<this>");
        String strC = zVar.c("charset");
        if (strC == null) {
            return null;
        }
        try {
            return Charset.forName(strC);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @os.l
    public static final i b(@os.l i iVar, @os.l Charset charset) {
        kn.l0.p(iVar, "<this>");
        kn.l0.p(charset, "charset");
        return iVar.j("charset", rl.a.p(charset));
    }
}
