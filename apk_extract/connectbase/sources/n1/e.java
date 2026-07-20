package n1;

import c1.h0;
import c1.z;
import j1.t;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import lm.g2;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@n1.a
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11181a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11182b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f11183c = '.';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c1.e f11185e = new c1.e.m(f11183c);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f11184d = ':';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c1.e f11186f = new c1.e.m(f11184d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Inet4Address f11187g = (Inet4Address) g("127.0.0.1");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Inet4Address f11188h = (Inet4Address) g("0.0.0.0");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Inet4Address f11189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Inet4Address f11190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11192d;

        public a(@gm.a Inet4Address server, @gm.a Inet4Address client, int port, int flags) {
            boolean z10 = false;
            h0.k(port >= 0 && port <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", port);
            if (flags >= 0 && flags <= 65535) {
                z10 = true;
            }
            h0.k(z10, "flags '%s' is out of range (0 <= flags <= 0xffff)", flags);
            this.f11189a = (Inet4Address) z.a(server, e.f11188h);
            this.f11190b = (Inet4Address) z.a(client, e.f11188h);
            this.f11191c = port;
            this.f11192d = flags;
        }

        public Inet4Address a() {
            return this.f11190b;
        }

        public int b() {
            return this.f11192d;
        }

        public int c() {
            return this.f11191c;
        }

        public Inet4Address d() {
            return this.f11189a;
        }
    }

    public static boolean A(Inet6Address ip2) {
        byte[] address = ip2.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean B(Inet6Address ip2) {
        byte b10;
        if (!ip2.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = ip2.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b10 = address[15]) == 0 || b10 == 1)) ? false : true;
    }

    public static boolean C(String ipString) {
        return z(ipString) != null;
    }

    public static boolean D(Inet6Address ip2) {
        if (G(ip2)) {
            return false;
        }
        byte[] address = ip2.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean E(String ipString) {
        byte[] bArrZ = z(ipString);
        if (bArrZ == null || bArrZ.length != 16) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 10) {
                for (int i11 = 10; i11 < 12; i11++) {
                    if (bArrZ[i11] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (bArrZ[i10] != 0) {
                return false;
            }
            i10++;
        }
    }

    public static boolean F(InetAddress address) {
        for (byte b10 : address.getAddress()) {
            if (b10 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(Inet6Address ip2) {
        byte[] address = ip2.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean H(String ipString) {
        return i(ipString) != null;
    }

    public static short I(String ipString, int start, int end) {
        int i10 = end - start;
        if (i10 <= 0 || i10 > 4) {
            throw new NumberFormatException();
        }
        int iDigit = 0;
        while (start < end) {
            iDigit = (iDigit << 4) | Character.digit(ipString.charAt(start), 16);
            start++;
        }
        return (short) iDigit;
    }

    public static byte J(String ipString, int start, int end) {
        int i10 = end - start;
        if (i10 <= 0 || i10 > 3) {
            throw new NumberFormatException();
        }
        if (i10 > 1 && ipString.charAt(start) == '0') {
            throw new NumberFormatException();
        }
        int i11 = 0;
        while (start < end) {
            int i12 = i11 * 10;
            int iDigit = Character.digit(ipString.charAt(start), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i11 = i12 + iDigit;
            start++;
        }
        if (i11 <= 255) {
            return (byte) i11;
        }
        throw new NumberFormatException();
    }

    @gm.a
    public static byte[] K(String ipString) {
        if (f11185e.i(ipString) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int iIndexOf = ipString.indexOf(46, i10);
            if (iIndexOf == -1) {
                iIndexOf = ipString.length();
            }
            try {
                bArr[i11] = J(ipString, i10, iIndexOf);
                i10 = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @gm.a
    public static byte[] L(String ipString) {
        int i10 = f11186f.i(ipString);
        if (i10 >= 2 && i10 <= 8) {
            int i11 = 1;
            int i12 = i10 + 1;
            int i13 = 8 - i12;
            boolean z10 = false;
            for (int i14 = 0; i14 < ipString.length() - 1; i14++) {
                if (ipString.charAt(i14) == ':' && ipString.charAt(i14 + 1) == ':') {
                    if (z10) {
                        return null;
                    }
                    int i15 = i13 + 1;
                    if (i14 == 0) {
                        i15 = i13 + 2;
                    }
                    if (i14 == ipString.length() - 2) {
                        i15++;
                    }
                    i13 = i15;
                    z10 = true;
                }
            }
            if (ipString.charAt(0) == ':' && ipString.charAt(1) != ':') {
                return null;
            }
            if (ipString.charAt(ipString.length() - 1) == ':' && ipString.charAt(ipString.length() - 2) != ':') {
                return null;
            }
            if (z10 && i13 <= 0) {
                return null;
            }
            if (!z10 && i12 != 8) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            try {
                if (ipString.charAt(0) != ':') {
                    i11 = 0;
                }
                while (i11 < ipString.length()) {
                    int iIndexOf = ipString.indexOf(58, i11);
                    if (iIndexOf == -1) {
                        iIndexOf = ipString.length();
                    }
                    if (ipString.charAt(i11) == ':') {
                        for (int i16 = 0; i16 < i13; i16++) {
                            byteBufferAllocate.putShort((short) 0);
                        }
                    } else {
                        byteBufferAllocate.putShort(I(ipString, i11, iIndexOf));
                    }
                    i11 = iIndexOf + 1;
                }
                return byteBufferAllocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String M(InetAddress ip2) {
        ip2.getClass();
        if (ip2 instanceof Inet4Address) {
            return ip2.getHostAddress();
        }
        h0.d(ip2 instanceof Inet6Address);
        byte[] address = ip2.getAddress();
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = i10 * 2;
            iArr[i10] = o1.l.k((byte) 0, (byte) 0, address[i11], address[i11 + 1]);
        }
        d(iArr);
        return x(iArr);
    }

    public static BigInteger N(InetAddress address) {
        return new BigInteger(1, address.getAddress());
    }

    public static String O(InetAddress ip2) {
        if (!(ip2 instanceof Inet6Address)) {
            return M(ip2);
        }
        return "[" + M(ip2) + "]";
    }

    public static InetAddress b(byte[] addr) {
        try {
            return InetAddress.getByAddress(addr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static int c(InetAddress ip2) {
        return l1.h.h(q(ip2).getAddress()).readInt();
    }

    public static void d(int[] hextets) {
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < hextets.length + 1; i13++) {
            if (i13 >= hextets.length || hextets[i13] != 0) {
                if (i12 >= 0) {
                    int i14 = i13 - i12;
                    if (i14 > i10) {
                        i11 = i12;
                        i10 = i14;
                    }
                    i12 = -1;
                }
            } else if (i12 < 0) {
                i12 = i13;
            }
        }
        if (i10 >= 2) {
            Arrays.fill(hextets, i11, i10 + i11, -1);
        }
    }

    @gm.a
    public static String e(String ipString) {
        int iLastIndexOf = ipString.lastIndexOf(58) + 1;
        String strSubstring = ipString.substring(0, iLastIndexOf);
        byte[] bArrK = K(ipString.substring(iLastIndexOf));
        if (bArrK == null) {
            return null;
        }
        return strSubstring + Integer.toHexString(((bArrK[0] & 255) << 8) | (bArrK[1] & 255)) + ":" + Integer.toHexString((bArrK[3] & 255) | ((bArrK[2] & 255) << 8));
    }

    public static InetAddress f(InetAddress address) {
        byte[] address2 = address.getAddress();
        int length = address2.length - 1;
        while (length >= 0 && address2[length] == 0) {
            address2[length] = -1;
            length--;
        }
        h0.u(length >= 0, "Decrementing %s would wrap.", address);
        address2[length] = (byte) (address2[length] - 1);
        return b(address2);
    }

    @t1.a
    public static InetAddress g(String ipString) {
        byte[] bArrZ = z(ipString);
        if (bArrZ != null) {
            return b(bArrZ);
        }
        throw j("'%s' is not an IP string literal.", ipString);
    }

    public static InetAddress h(String hostAddr) {
        InetAddress inetAddressI = i(hostAddr);
        if (inetAddressI != null) {
            return inetAddressI;
        }
        throw j("Not a valid URI IP literal: '%s'", hostAddr);
    }

    @gm.a
    public static InetAddress i(String hostAddr) {
        int i10;
        hostAddr.getClass();
        if (hostAddr.startsWith("[") && hostAddr.endsWith("]")) {
            hostAddr = c0.b.a(hostAddr, 1, 1);
            i10 = 16;
        } else {
            i10 = 4;
        }
        byte[] bArrZ = z(hostAddr);
        if (bArrZ == null || bArrZ.length != i10) {
            return null;
        }
        return b(bArrZ);
    }

    public static IllegalArgumentException j(String format, Object... args) {
        return new IllegalArgumentException(String.format(Locale.ROOT, format, args));
    }

    public static InetAddress k(BigInteger address, boolean isIpv6) {
        h0.e(address.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i10 = isIpv6 ? 16 : 4;
        byte[] byteArray = address.toByteArray();
        byte[] bArr = new byte[i10];
        int iMax = Math.max(0, byteArray.length - i10);
        int length = byteArray.length - iMax;
        int i11 = i10 - length;
        for (int i12 = 0; i12 < iMax; i12++) {
            if (byteArray[i12] != 0) {
                throw j("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i10), address);
            }
        }
        System.arraycopy(byteArray, iMax, bArr, i11, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static Inet4Address l(BigInteger address) {
        return (Inet4Address) k(address, false);
    }

    public static Inet6Address m(BigInteger address) {
        return (Inet6Address) k(address, true);
    }

    public static Inet4Address n(int address) {
        return t(o1.l.E(address));
    }

    public static InetAddress o(byte[] addr) throws UnknownHostException {
        byte[] bArr = new byte[addr.length];
        for (int i10 = 0; i10 < addr.length; i10++) {
            bArr[i10] = addr[(addr.length - i10) - 1];
        }
        return InetAddress.getByAddress(bArr);
    }

    public static Inet4Address p(Inet6Address ip2) {
        h0.u(A(ip2), "Address '%s' is not a 6to4 address.", M(ip2));
        return t(Arrays.copyOfRange(ip2.getAddress(), 2, 6));
    }

    public static Inet4Address q(InetAddress ip2) {
        boolean z10;
        if (ip2 instanceof Inet4Address) {
            return (Inet4Address) ip2;
        }
        byte[] address = ip2.getAddress();
        int i10 = 0;
        while (true) {
            if (i10 >= 15) {
                z10 = true;
                break;
            }
            if (address[i10] != 0) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10 && address[15] == 1) {
            return f11187g;
        }
        if (z10 && address[15] == 0) {
            return f11188h;
        }
        Inet6Address inet6Address = (Inet6Address) ip2;
        int iAsInt = t.B().hashLong(w(inet6Address) ? s(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (iAsInt == -1) {
            iAsInt = -2;
        }
        return t(o1.l.E(iAsInt));
    }

    public static Inet4Address r(Inet6Address ip2) {
        h0.u(B(ip2), "Address '%s' is not IPv4-compatible.", M(ip2));
        return t(Arrays.copyOfRange(ip2.getAddress(), 12, 16));
    }

    public static Inet4Address s(Inet6Address ip2) {
        if (B(ip2)) {
            return r(ip2);
        }
        if (A(ip2)) {
            return p(ip2);
        }
        if (G(ip2)) {
            return v(ip2).f11190b;
        }
        throw j("'%s' has no embedded IPv4 address.", M(ip2));
    }

    public static Inet4Address t(byte[] bytes) {
        h0.k(bytes.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bytes.length);
        return (Inet4Address) b(bytes);
    }

    public static Inet4Address u(Inet6Address ip2) {
        h0.u(D(ip2), "Address '%s' is not an ISATAP address.", M(ip2));
        return t(Arrays.copyOfRange(ip2.getAddress(), 12, 16));
    }

    public static a v(Inet6Address ip2) {
        h0.u(G(ip2), "Address '%s' is not a Teredo address.", M(ip2));
        byte[] address = ip2.getAddress();
        Inet4Address inet4AddressT = t(Arrays.copyOfRange(address, 4, 8));
        int i10 = l1.h.i(address, 8).readShort() & g2.f10190d;
        int i11 = 65535 & (~l1.h.i(address, 10).readShort());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i12 = 0; i12 < bArrCopyOfRange.length; i12++) {
            bArrCopyOfRange[i12] = (byte) (~bArrCopyOfRange[i12]);
        }
        return new a(inet4AddressT, t(bArrCopyOfRange), i11, i10);
    }

    public static boolean w(Inet6Address ip2) {
        return B(ip2) || A(ip2) || G(ip2);
    }

    public static String x(int[] hextets) {
        StringBuilder sb2 = new StringBuilder(39);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < hextets.length) {
            boolean z11 = hextets[i10] >= 0;
            if (z11) {
                if (z10) {
                    sb2.append(f11184d);
                }
                sb2.append(Integer.toHexString(hextets[i10]));
            } else if (i10 == 0 || z10) {
                sb2.append("::");
            }
            i10++;
            z10 = z11;
        }
        return sb2.toString();
    }

    public static InetAddress y(InetAddress address) {
        byte[] address2 = address.getAddress();
        int length = address2.length - 1;
        while (true) {
            if (length < 0 || address2[length] != -1) {
                break;
            }
            address2[length] = 0;
            length--;
        }
        h0.u(length >= 0, "Incrementing %s would wrap.", address);
        address2[length] = (byte) (address2[length] + 1);
        return b(address2);
    }

    @gm.a
    public static byte[] z(String ipStringParam) {
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            if (i10 >= ipStringParam.length()) {
                i10 = -1;
                break;
            }
            char cCharAt = ipStringParam.charAt(i10);
            if (cCharAt == '.') {
                z10 = true;
            } else if (cCharAt == ':') {
                if (z10) {
                    return null;
                }
                z11 = true;
            } else {
                if (cCharAt == '%') {
                    break;
                }
                if (Character.digit(cCharAt, 16) == -1) {
                    return null;
                }
            }
            i10++;
        }
        if (!z11) {
            if (z10 && i10 == -1) {
                return K(ipStringParam);
            }
            return null;
        }
        if (z10 && (ipStringParam = e(ipStringParam)) == null) {
            return null;
        }
        if (i10 != -1) {
            ipStringParam = ipStringParam.substring(0, i10);
        }
        return L(ipStringParam);
    }
}
