package io.netty.util;

import androidx.recyclerview.widget.ItemTouchHelper;
import c0.b;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import ks.a;
import n1.e;

/* JADX INFO: loaded from: classes3.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final Collection<NetworkInterface> NETWORK_INTERFACES;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    public static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:55:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0046: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:15:0x0046 */
        @Override // java.security.PrivilegedAction
        public Integer run() throws Throwable {
            BufferedReader bufferedReader;
            Exception e10;
            BufferedReader bufferedReader2;
            Integer numSysctlGetInt;
            int iIntValue = PlatformDependent.isWindows() ? ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION : 128;
            File file = new File("/proc/sys/net/core/somaxconn");
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    try {
                        if (file.exists()) {
                            bufferedReader = new BufferedReader(new FileReader(file));
                            try {
                                iIntValue = Integer.parseInt(bufferedReader.readLine());
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("{}: {}", file, Integer.valueOf(iIntValue));
                                }
                                bufferedReader3 = bufferedReader;
                            } catch (Exception e11) {
                                e10 = e11;
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue), e10);
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return Integer.valueOf(iIntValue);
                            }
                        } else {
                            if (SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                                numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                                if (numSysctlGetInt == null) {
                                    numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                                    if (numSysctlGetInt != null) {
                                        iIntValue = numSysctlGetInt.intValue();
                                    }
                                } else {
                                    iIntValue = numSysctlGetInt.intValue();
                                }
                            } else {
                                numSysctlGetInt = null;
                            }
                            if (numSysctlGetInt == null) {
                                NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue));
                            }
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader3 = bufferedReader2;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    bufferedReader = null;
                    e10 = e12;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
            return Integer.valueOf(iIntValue);
        }
    }

    static {
        boolean z10 = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
        IPV4_PREFERRED = z10;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);
        logger = internalLoggerFactory;
        String str = SystemPropertyUtil.get("java.net.preferIPv6Addresses", "false");
        if ("true".equalsIgnoreCase(str.trim())) {
            IPV6_ADDRESSES_PREFERRED = true;
        } else {
            IPV6_ADDRESSES_PREFERRED = false;
        }
        internalLoggerFactory.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(z10));
        internalLoggerFactory.debug("-Djava.net.preferIPv6Addresses: {}", str);
        Collection<NetworkInterface> collectionNetworkInterfaces = NetUtilInitializations.networkInterfaces();
        NETWORK_INTERFACES = collectionNetworkInterfaces;
        Inet4Address inet4AddressCreateLocalhost4 = NetUtilInitializations.createLocalhost4();
        LOCALHOST4 = inet4AddressCreateLocalhost4;
        Inet6Address inet6AddressCreateLocalhost6 = NetUtilInitializations.createLocalhost6();
        LOCALHOST6 = inet6AddressCreateLocalhost6;
        NetUtilInitializations.NetworkIfaceAndInetAddress networkIfaceAndInetAddressDetermineLoopback = NetUtilInitializations.determineLoopback(collectionNetworkInterfaces, inet4AddressCreateLocalhost4, inet6AddressCreateLocalhost6);
        LOOPBACK_IF = networkIfaceAndInetAddressDetermineLoopback.iface();
        LOCALHOST = networkIfaceAndInetAddressDetermineLoopback.address();
        SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction())).intValue();
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = b.a(str, 1, 1);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return getIPv6ByName(str, true);
    }

    public static InetAddress createInetAddressFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            try {
                return InetAddress.getByAddress(validIpV4ToBytes(str));
            } catch (UnknownHostException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = b.a(str, 1, 1);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf < 0) {
            byte[] iPv6ByName = getIPv6ByName(str, true);
            if (iPv6ByName == null) {
                return null;
            }
            try {
                return InetAddress.getByAddress(iPv6ByName);
            } catch (UnknownHostException e11) {
                throw new IllegalStateException(e11);
            }
        }
        try {
            int i10 = Integer.parseInt(str.substring(iIndexOf + 1));
            byte[] iPv6ByName2 = getIPv6ByName(str.substring(0, iIndexOf), true);
            if (iPv6ByName2 == null) {
                return null;
            }
            try {
                return Inet6Address.getByAddress((String) null, iPv6ByName2, i10);
            } catch (UnknownHostException e12) {
                throw new IllegalStateException(e12);
            }
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int decimalDigit(String str, int i10) {
        return str.charAt(i10) - '0';
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        return PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0187, code lost:
    
        if (r7 <= 2) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] getIPv6ByName(java.lang.CharSequence r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static boolean inRangeEndExclusive(int i10, int i11, int i12) {
        return i10 >= i11 && i10 < i12;
    }

    public static String intToIpAddress(int i10) {
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append((i10 >> 24) & 255);
        sb2.append(e.f11183c);
        sb2.append((i10 >> 16) & 255);
        sb2.append(e.f11183c);
        sb2.append((i10 >> 8) & 255);
        sb2.append(e.f11183c);
        sb2.append(i10 & 255);
        return sb2.toString();
    }

    public static int ipv4AddressToInt(Inet4Address inet4Address) {
        byte[] address = inet4Address.getAddress();
        return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
    }

    private static byte ipv4WordToByte(String str, int i10, int i11) {
        int iDecimalDigit = decimalDigit(str, i10);
        int i12 = i10 + 1;
        if (i12 == i11) {
            return (byte) iDecimalDigit;
        }
        int iDecimalDigit2 = (iDecimalDigit * 10) + decimalDigit(str, i12);
        int i13 = i10 + 2;
        return i13 == i11 ? (byte) iDecimalDigit2 : (byte) ((iDecimalDigit2 * 10) + decimalDigit(str, i13));
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c10) {
        return (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'F') || (c10 >= 'a' && c10 <= 'f');
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i10, int i11, int i12) {
        boolean z10 = i12 + i11 >= 14;
        if (i10 > 12 || i10 < 2) {
            return false;
        }
        return (!z10 || i11 < 12) && isValidIPv4MappedSeparators(bArr[i10 + (-1)], bArr[i10 + (-2)], z10) && PlatformDependent.isZero(bArr, 0, i10 + (-3));
    }

    private static boolean isValidIPv4MappedChar(char c10) {
        return c10 == 'f' || c10 == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b10, byte b11, boolean z10) {
        return b10 == b11 && (b10 == 0 || (!z10 && b11 == -1));
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i10, int i11) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i12 = i11 - i10;
        return i12 <= 15 && i12 >= 7 && (iIndexOf = AsciiString.indexOf(charSequence, e.f11183c, i10 + 1)) > 0 && isValidIpV4Word(charSequence, i10, iIndexOf) && (iIndexOf2 = AsciiString.indexOf(charSequence, e.f11183c, iIndexOf + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = AsciiString.indexOf(charSequence, e.f11183c, iIndexOf2 + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(charSequence, iIndexOf3 + 1, i11);
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i10, int i11) {
        char cCharAt;
        char cCharAt2;
        int i12 = i11 - i10;
        if (i12 < 1 || i12 > 3 || (cCharAt = charSequence.charAt(i10)) < '0') {
            return false;
        }
        if (i12 != 3) {
            if (cCharAt <= '9') {
                return i12 == 1 || isValidNumericChar(charSequence.charAt(i10 + 1));
            }
            return false;
        }
        char cCharAt3 = charSequence.charAt(i10 + 1);
        if (cCharAt3 < '0' || (cCharAt2 = charSequence.charAt(i10 + 2)) < '0') {
            return false;
        }
        if (cCharAt > '1' || cCharAt3 > '9' || cCharAt2 > '9') {
            if (cCharAt != '2' || cCharAt3 > '5') {
                return false;
            }
            if (cCharAt2 > '5' && (cCharAt3 >= '5' || cCharAt2 > '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    private static boolean isValidNumericChar(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z10) {
        int length = str.length();
        if (z10) {
            StringBuilder sb2 = new StringBuilder(str2.length() + length + 1);
            sb2.append(str);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder(str2.length() + length + 3);
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb3.append(str);
            return sb3;
        }
        sb3.append(a.f9445d);
        sb3.append(str);
        sb3.append(']');
        return sb3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process processStart = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
            try {
                String line = bufferedReader.readLine();
                if (line != null && line.startsWith(str)) {
                    int length = line.length();
                    while (true) {
                        length--;
                        if (length <= str.length()) {
                            break;
                        }
                        if (!Character.isDigit(line.charAt(length))) {
                            Integer numValueOf = Integer.valueOf(line.substring(length + 1));
                            bufferedReader.close();
                            processStart.destroy();
                            return numValueOf;
                        }
                    }
                }
                bufferedReader.close();
                processStart.destroy();
                return null;
            } catch (Throwable th2) {
                bufferedReader.close();
                throw th2;
            }
        } catch (Throwable th3) {
            processStart.destroy();
            throw th3;
        }
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder sbNewSocketAddressStringBuilder;
        String strValueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            String hostname = getHostname(inetSocketAddress);
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(hostname, strValueOf, !isValidIpV6Address(hostname));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), strValueOf, address instanceof Inet4Address);
        }
        sbNewSocketAddressStringBuilder.append(e.f11184d);
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    public static byte[] validIpV4ToBytes(String str) {
        int iIndexOf = str.indexOf(46, 1);
        byte bIpv4WordToByte = ipv4WordToByte(str, 0, iIndexOf);
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(46, iIndexOf + 2);
        byte bIpv4WordToByte2 = ipv4WordToByte(str, i10, iIndexOf2);
        int iIndexOf3 = str.indexOf(46, iIndexOf2 + 2);
        return new byte[]{bIpv4WordToByte, bIpv4WordToByte2, ipv4WordToByte(str, iIndexOf2 + 1, iIndexOf3), ipv4WordToByte(str, iIndexOf3 + 1, str.length())};
    }

    public static String bytesToIpAddress(byte[] bArr, int i10, int i11) {
        if (i11 != 4) {
            if (i11 == 16) {
                return toAddressString(bArr, i10, false);
            }
            throw new IllegalArgumentException(k.b.a("length: ", i11, " (expected: 4 or 16)"));
        }
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append(bArr[i10] & 255);
        sb2.append(e.f11183c);
        sb2.append(bArr[i10 + 1] & 255);
        sb2.append(e.f11183c);
        sb2.append(bArr[i10 + 2] & 255);
        sb2.append(e.f11183c);
        sb2.append(bArr[i10 + 3] & 255);
        return sb2.toString();
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z10) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z10);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i10;
        int i11;
        int length = charSequence.length();
        int i12 = 2;
        if (length < 2) {
            return false;
        }
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == '[') {
            length--;
            if (charSequence.charAt(length) != ']') {
                return false;
            }
            cCharAt = charSequence.charAt(1);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (cCharAt != ':') {
            i11 = -1;
            i12 = 0;
        } else {
            if (charSequence.charAt(i10 + 1) != ':') {
                return false;
            }
            int i13 = i10;
            i10 += 2;
            i11 = i13;
        }
        int i14 = 0;
        for (int i15 = i10; i15 < length; i15++) {
            char cCharAt2 = charSequence.charAt(i15);
            if (!isValidHexChar(cCharAt2)) {
                if (cCharAt2 == '%') {
                    length = i15;
                    break;
                }
                if (cCharAt2 == '.') {
                    if ((i11 < 0 && i12 != 6) || ((i12 == 7 && i11 >= i10) || i12 > 7)) {
                        return false;
                    }
                    int i16 = i15 - i14;
                    int i17 = i16 - 2;
                    if (isValidIPv4MappedChar(charSequence.charAt(i17))) {
                        if (!isValidIPv4MappedChar(charSequence.charAt(i16 - 3)) || !isValidIPv4MappedChar(charSequence.charAt(i16 - 4)) || !isValidIPv4MappedChar(charSequence.charAt(i16 - 5))) {
                            return false;
                        }
                        i17 = i16 - 7;
                    }
                    while (i17 >= i10) {
                        char cCharAt3 = charSequence.charAt(i17);
                        if (cCharAt3 != '0' && cCharAt3 != ':') {
                            return false;
                        }
                        i17--;
                    }
                    int iIndexOf = AsciiString.indexOf(charSequence, '%', i16 + 7);
                    if (iIndexOf >= 0) {
                        length = iIndexOf;
                    }
                    return isValidIpV4Address(charSequence, i16, length);
                }
                if (cCharAt2 != ':' || i12 > 7) {
                    return false;
                }
                int i18 = i15 - 1;
                if (charSequence.charAt(i18) != ':') {
                    i14 = 0;
                } else {
                    if (i11 >= 0) {
                        return false;
                    }
                    i11 = i18;
                }
                i12++;
            } else {
                if (i14 >= 4) {
                    return false;
                }
                i14++;
            }
        }
        if (i11 < 0) {
            return i12 == 7 && i14 > 0;
        }
        if (i11 + 2 != length) {
            if (i14 <= 0) {
                return false;
            }
            if (i12 >= 8 && i11 > i10) {
                return false;
            }
        }
        return true;
    }

    public static String toAddressString(InetAddress inetAddress, boolean z10) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z10);
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress);
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i10, int i11) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i10, i11);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i10, i11);
        }
        return isValidIpV4Address0(charSequence, i10, i11);
    }

    private static boolean isValidIpV4Address(String str, int i10, int i11) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i12 = i11 - i10;
        return i12 <= 15 && i12 >= 7 && (iIndexOf = str.indexOf(46, i10 + 1)) > 0 && isValidIpV4Word(str, i10, iIndexOf) && (iIndexOf2 = str.indexOf(46, iIndexOf + 2)) > 0 && isValidIpV4Word(str, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = str.indexOf(46, iIndexOf2 + 2)) > 0 && isValidIpV4Word(str, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(str, iIndexOf3 + 1, i11);
    }

    private static String toAddressString(byte[] bArr, int i10, boolean z10) {
        int i11;
        int i12;
        int[] iArr = new int[8];
        boolean z11 = false;
        int i13 = 0;
        while (true) {
            i11 = 1;
            if (i13 >= 8) {
                break;
            }
            int i14 = (i13 << 1) + i10;
            iArr[i13] = (bArr[i14 + 1] & 255) | ((bArr[i14] & 255) << 8);
            i13++;
        }
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = 0;
        for (int i19 = 0; i19 < 8; i19++) {
            if (iArr[i19] == 0) {
                if (i16 < 0) {
                    i16 = i19;
                }
            } else if (i16 >= 0) {
                int i20 = i19 - i16;
                if (i20 > i18) {
                    i18 = i20;
                } else {
                    i16 = i17;
                }
                i17 = i16;
                i16 = -1;
            }
        }
        if (i16 < 0 || (i12 = 8 - i16) <= i18) {
            i16 = i17;
        } else {
            i18 = i12;
        }
        if (i18 == 1) {
            i18 = 0;
        } else {
            i15 = i16;
        }
        int i21 = i18 + i15;
        StringBuilder sb2 = new StringBuilder(39);
        if (i21 < 0) {
            sb2.append(Integer.toHexString(iArr[0]));
            while (i11 < 8) {
                sb2.append(e.f11184d);
                sb2.append(Integer.toHexString(iArr[i11]));
                i11++;
            }
        } else {
            if (inRangeEndExclusive(0, i15, i21)) {
                sb2.append("::");
                if (z10 && i21 == 5 && iArr[5] == 65535) {
                    z11 = true;
                }
            } else {
                sb2.append(Integer.toHexString(iArr[0]));
            }
            while (i11 < 8) {
                if (!inRangeEndExclusive(i11, i15, i21)) {
                    if (!inRangeEndExclusive(i11 - 1, i15, i21)) {
                        if (z11 && i11 != 6) {
                            sb2.append(e.f11183c);
                        } else {
                            sb2.append(e.f11184d);
                        }
                    }
                    if (z11 && i11 > 5) {
                        sb2.append(iArr[i11] >> 8);
                        sb2.append(e.f11183c);
                        sb2.append(iArr[i11] & 255);
                    } else {
                        sb2.append(Integer.toHexString(iArr[i11]));
                    }
                } else if (!inRangeEndExclusive(i11 - 1, i15, i21)) {
                    sb2.append("::");
                }
                i11++;
            }
        }
        return sb2.toString();
    }

    public static String toSocketAddressString(String str, int i10) {
        String strValueOf = String.valueOf(i10);
        StringBuilder sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(str, strValueOf, !isValidIpV6Address(str));
        sbNewSocketAddressStringBuilder.append(e.f11184d);
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i10, int i11) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i12 = i11 - i10;
        return i12 <= 15 && i12 >= 7 && (iIndexOf = asciiString.indexOf(e.f11183c, i10 + 1)) > 0 && isValidIpV4Word(asciiString, i10, iIndexOf) && (iIndexOf2 = asciiString.indexOf(e.f11183c, iIndexOf + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = asciiString.indexOf(e.f11183c, iIndexOf2 + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(asciiString, iIndexOf3 + 1, i11);
    }
}
