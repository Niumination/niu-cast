package n1;

import c1.b0;
import c1.g0;
import c1.h0;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@t1.j
@a
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11089a = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    public b(String host, int port, boolean hasBracketlessColons) {
        this.host = host;
        this.port = port;
        this.hasBracketlessColons = hasBracketlessColons;
    }

    public static String[] a(String hostPortString) {
        h0.u(hostPortString.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", hostPortString);
        int iIndexOf = hostPortString.indexOf(58);
        int iLastIndexOf = hostPortString.lastIndexOf(93);
        h0.u(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", hostPortString);
        String strSubstring = hostPortString.substring(1, iLastIndexOf);
        int i10 = iLastIndexOf + 1;
        if (i10 == hostPortString.length()) {
            return new String[]{strSubstring, ""};
        }
        h0.u(hostPortString.charAt(i10) == ':', "Only a colon may follow a close bracket: %s", hostPortString);
        int i11 = iLastIndexOf + 2;
        for (int i12 = i11; i12 < hostPortString.length(); i12++) {
            h0.u(Character.isDigit(hostPortString.charAt(i12)), "Port must be numeric: %s", hostPortString);
        }
        return new String[]{strSubstring, hostPortString.substring(i11)};
    }

    public static boolean b(int port) {
        return port >= 0 && port <= 65535;
    }

    public static b fromHost(String host) {
        b bVarFromString = fromString(host);
        h0.u(!bVarFromString.hasPort(), "Host has a port: %s", host);
        return bVarFromString;
    }

    public static b fromParts(String host, int port) {
        h0.k(b(port), "Port out of range: %s", port);
        b bVarFromString = fromString(host);
        h0.u(!bVarFromString.hasPort(), "Host has a port: %s", host);
        return new b(bVarFromString.host, port, bVarFromString.hasBracketlessColons);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    @t1.a
    public static b fromString(String hostPortString) {
        String str;
        boolean z10;
        String strSubstring;
        String strSubstring2;
        hostPortString.getClass();
        int i10 = -1;
        if (!hostPortString.startsWith("[")) {
            int iIndexOf = hostPortString.indexOf(58);
            if (iIndexOf >= 0) {
                int i11 = iIndexOf + 1;
                if (hostPortString.indexOf(58, i11) == -1) {
                    strSubstring2 = hostPortString.substring(0, iIndexOf);
                    strSubstring = hostPortString.substring(i11);
                }
                if (!g0.j(strSubstring)) {
                    h0.u(strSubstring.startsWith(ps.d.ANY_NON_NULL_MARKER) && c1.e.C0050e.f1151c.C(strSubstring), "Unparseable port number: %s", hostPortString);
                    try {
                        i10 = Integer.parseInt(strSubstring);
                        h0.u(b(i10), "Port number out of range: %s", hostPortString);
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("Unparseable port number: ".concat(hostPortString));
                    }
                }
                return new b(str, i10, z10);
            }
            str = hostPortString;
            z10 = iIndexOf >= 0;
            strSubstring = null;
            if (!g0.j(strSubstring)) {
                h0.u(strSubstring.startsWith(ps.d.ANY_NON_NULL_MARKER) && c1.e.C0050e.f1151c.C(strSubstring), "Unparseable port number: %s", hostPortString);
                i10 = Integer.parseInt(strSubstring);
                h0.u(b(i10), "Port number out of range: %s", hostPortString);
            }
            return new b(str, i10, z10);
        }
        String[] strArrA = a(hostPortString);
        strSubstring2 = strArrA[0];
        strSubstring = strArrA[1];
        str = strSubstring2;
        z10 = false;
        if (!g0.j(strSubstring)) {
            h0.u(strSubstring.startsWith(ps.d.ANY_NON_NULL_MARKER) && c1.e.C0050e.f1151c.C(strSubstring), "Unparseable port number: %s", hostPortString);
            i10 = Integer.parseInt(strSubstring);
            h0.u(b(i10), "Port number out of range: %s", hostPortString);
        }
        return new b(str, i10, z10);
    }

    public boolean equals(@gm.a Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return b0.a(this.host, bVar.host) && this.port == bVar.port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        h0.g0(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int defaultPort) {
        return hasPort() ? this.port : defaultPort;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    @t1.a
    public b requireBracketsForIPv6() {
        h0.u(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb2.append(ks.a.f9445d);
            sb2.append(this.host);
            sb2.append(']');
        } else {
            sb2.append(this.host);
        }
        if (hasPort()) {
            sb2.append(e.f11184d);
            sb2.append(this.port);
        }
        return sb2.toString();
    }

    public b withDefaultPort(int defaultPort) {
        h0.d(b(defaultPort));
        return hasPort() ? this : new b(this.host, defaultPort, this.hasBracketlessColons);
    }
}
