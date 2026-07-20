package nk;

import fl.g1;
import fl.t0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import jq.e0;
import jq.h0;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    public static final class a extends n0 implements jn.l<String, ik.i> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final ik.i invoke(@os.l String str) {
            l0.p(str, "it");
            return ik.w.a(ik.i.f7981f, str);
        }
    }

    public static final String a(String str) {
        int iIntValue;
        Integer numValueOf = Integer.valueOf(h0.C3(str, el.b0.f4502a, 0, false, 6, null));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            Integer numValueOf2 = Integer.valueOf(h0.C3(str, rs.f.f14862d, 0, false, 6, null));
            Integer num = numValueOf2.intValue() != -1 ? numValueOf2 : null;
            iIntValue = num == null ? 0 : num.intValue();
        } else {
            iIntValue = numValueOf.intValue();
        }
        int iO3 = h0.o3(str, n1.e.f11183c, iIntValue, false, 4, null);
        if (iO3 < 0) {
            return "";
        }
        String strSubstring = str.substring(iO3);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @os.l
    public static final File b(@os.l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        if (!e0.s2(str, "jar:file:", false, 2, null)) {
            throw new IllegalArgumentException("Only local jars are supported (jar:file:)");
        }
        int iP3 = h0.p3(str, "!", 9, false, 4, null);
        if (iP3 == -1) {
            throw new IllegalArgumentException(l0.C("Jar path requires !/ separator but it is: ", str).toString());
        }
        String strSubstring = str.substring(9, iP3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new File(ik.e.i(strSubstring, 0, 0, null, 7, null));
    }

    @os.m
    public static final s c(@os.l dk.b bVar, @os.l String str, @os.m String str2, @os.l ClassLoader classLoader, @os.l jn.l<? super String, ik.i> lVar) throws IOException {
        l0.p(bVar, "<this>");
        l0.p(str, "path");
        l0.p(classLoader, "classLoader");
        l0.p(lVar, "mimeResolve");
        if (!e0.J1(str, "/", false, 2, null) && !e0.J1(str, "\\", false, 2, null)) {
            String strM3 = nm.h0.m3(g1.c(nm.h0.E4(h0.Q4(str2 == null ? "" : str2, new char[]{n1.e.f11183c, el.b0.f4502a, rs.f.f14862d}, false, 0, 6, null), h0.Q4(str, new char[]{el.b0.f4502a, rs.f.f14862d}, false, 0, 6, null))), "/", null, null, 0, null, null, 62, null);
            Enumeration<URL> resources = classLoader.getResources(strM3);
            l0.o(resources, "classLoader.getResources(normalizedPath)");
            for (URL url : gq.s.e(nm.a0.f0(resources))) {
                l0.o(url, RtspHeaders.Values.URL);
                s sVarE = e(url, strM3, lVar);
                if (sVarE != null) {
                    return sVarE;
                }
            }
        }
        return null;
    }

    public static s d(dk.b bVar, String str, String str2, ClassLoader classLoader, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            classLoader = bVar.a().I.f();
        }
        if ((i10 & 8) != 0) {
            lVar = a.INSTANCE;
        }
        return c(bVar, str, str2, classLoader, lVar);
    }

    @os.m
    @t0
    public static final s e(@os.l URL url, @os.l String str, @os.l jn.l<? super String, ik.i> lVar) {
        l0.p(url, RtspHeaders.Values.URL);
        l0.p(str, "path");
        l0.p(lVar, "mimeResolve");
        String protocol = url.getProtocol();
        if (protocol == null) {
            return null;
        }
        int iHashCode = protocol.hashCode();
        if (iHashCode == 104987) {
            if (!protocol.equals("jar") || e0.J1(str, "/", false, 2, null)) {
                return null;
            }
            String string = url.toString();
            l0.o(string, "url.toString()");
            File fileB = b(string);
            String path = url.getPath();
            l0.o(path, "url.path");
            k kVar = new k(fileB, str, lVar.invoke(a(path)));
            if (kVar.s()) {
                return kVar;
            }
            return null;
        }
        if (iHashCode == 105516) {
            if (!protocol.equals("jrt")) {
                return null;
            }
            String path2 = url.getPath();
            l0.o(path2, "url.path");
            return new z(url, lVar.invoke(a(path2)));
        }
        if (iHashCode != 3143036 || !protocol.equals("file")) {
            return null;
        }
        String path3 = url.getPath();
        l0.o(path3, "url.path");
        File file = new File(ik.e.i(path3, 0, 0, null, 7, null));
        if (file.isFile()) {
            return new n(file, lVar.invoke(dn.q.Y(file)));
        }
        return null;
    }
}
