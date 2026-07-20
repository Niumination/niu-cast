package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelId.class);
    private static final AtomicInteger nextSequence = new AtomicInteger();
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data;
    private final int hashCode;
    private transient String longValue;
    private transient String shortValue;

    static {
        int i10;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int iDefaultProcessId = -1;
        if (str != null) {
            try {
                i10 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i10 = -1;
            }
            if (i10 < 0) {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i10));
                }
                iDefaultProcessId = i10;
            }
        }
        if (iDefaultProcessId < 0) {
            iDefaultProcessId = defaultProcessId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(iDefaultProcessId));
            }
        }
        PROCESS_ID = iDefaultProcessId;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        byte[] mac = null;
        if (str2 != null) {
            try {
                mac = MacAddressUtil.parseMAC(str2);
            } catch (Exception e10) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2, e10);
            }
            if (mac != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            }
        }
        if (mac == null) {
            mac = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger3 = logger;
            if (internalLogger3.isDebugEnabled()) {
                internalLogger3.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(mac));
            }
        }
        MACHINE_ID = mac;
    }

    private DefaultChannelId() {
        byte[] bArr = MACHINE_ID;
        byte[] bArr2 = new byte[bArr.length + 20];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        writeInt(writeLong(writeInt(writeInt(bArr.length, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(bArr2);
    }

    private int appendHexDumpField(StringBuilder sb2, int i10, int i11) {
        sb2.append(ByteBufUtil.hexDump(this.data, i10, i11));
        sb2.append('-');
        return i10 + i11;
    }

    public static int defaultProcessId() {
        ClassLoader classLoader = PlatformDependent.getClassLoader(DefaultChannelId.class);
        int iProcessHandlePid = processHandlePid(classLoader);
        return iProcessHandlePid != -1 ? iProcessHandlePid : jmxPid(classLoader);
    }

    public static int jmxPid(ClassLoader classLoader) {
        String string;
        int i10;
        try {
            Class<?> cls = Class.forName("java.lang.management.ManagementFactory", true, classLoader);
            Class<?> cls2 = Class.forName("java.lang.management.RuntimeMXBean", true, classLoader);
            Class<?>[] clsArr = EmptyArrays.EMPTY_CLASSES;
            Method method = cls.getMethod("getRuntimeMXBean", clsArr);
            Object[] objArr = EmptyArrays.EMPTY_OBJECTS;
            string = (String) cls2.getMethod("getName", clsArr).invoke(method.invoke(null, objArr), objArr);
        } catch (Throwable th2) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", th2);
            try {
                string = Class.forName("android.os.Process", true, classLoader).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            } catch (Throwable th3) {
                logger.debug("Could not invoke Process.myPid(); not Android?", th3);
                string = "";
            }
        }
        int iIndexOf = string.indexOf(64);
        if (iIndexOf >= 0) {
            string = string.substring(0, iIndexOf);
        }
        try {
            i10 = Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            i10 = -1;
        }
        if (i10 >= 0) {
            return i10;
        }
        int iNextInt = PlatformDependent.threadLocalRandom().nextInt();
        logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", string, Integer.valueOf(iNextInt));
        return iNextInt;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    private String newLongValue() {
        StringBuilder sb2 = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb2, appendHexDumpField(sb2, appendHexDumpField(sb2, appendHexDumpField(sb2, appendHexDumpField(sb2, 0, MACHINE_ID.length), 4), 4), 8), 4);
        return sb2.substring(0, sb2.length() - 1);
    }

    public static int processHandlePid(ClassLoader classLoader) {
        if (PlatformDependent.javaVersion() >= 9) {
            try {
                Class<?> cls = Class.forName("java.lang.ProcessHandle", true, classLoader);
                Long l10 = (Long) cls.getMethod("pid", null).invoke(cls.getMethod("current", null).invoke(null, null), null);
                if (l10.longValue() <= 2147483647L && l10.longValue() >= -2147483648L) {
                    return l10.intValue();
                }
                throw new IllegalStateException("Current process ID exceeds int range: " + l10);
            } catch (Exception e10) {
                logger.debug("Could not invoke ProcessHandle.current().pid();", (Throwable) e10);
            }
        }
        return -1;
    }

    private int writeInt(int i10, int i11) {
        byte[] bArr = this.data;
        bArr[i10] = (byte) (i11 >>> 24);
        bArr[i10 + 1] = (byte) (i11 >>> 16);
        int i12 = i10 + 3;
        bArr[i10 + 2] = (byte) (i11 >>> 8);
        int i13 = i10 + 4;
        bArr[i12] = (byte) i11;
        return i13;
    }

    private int writeLong(int i10, long j10) {
        byte[] bArr = this.data;
        bArr[i10] = (byte) (j10 >>> 56);
        bArr[i10 + 1] = (byte) (j10 >>> 48);
        bArr[i10 + 2] = (byte) (j10 >>> 40);
        bArr[i10 + 3] = (byte) (j10 >>> 32);
        bArr[i10 + 4] = (byte) (j10 >>> 24);
        bArr[i10 + 5] = (byte) (j10 >>> 16);
        int i11 = i10 + 7;
        bArr[i10 + 6] = (byte) (j10 >>> 8);
        int i12 = i10 + 8;
        bArr[i11] = (byte) j10;
        return i12;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str != null) {
            return str;
        }
        String strNewLongValue = newLongValue();
        this.longValue = strNewLongValue;
        return strNewLongValue;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.data;
        String strHexDump = ByteBufUtil.hexDump(bArr, bArr.length - 4, 4);
        this.shortValue = strHexDump;
        return strHexDump;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId defaultChannelId = (DefaultChannelId) obj;
        return this.hashCode == defaultChannelId.hashCode && Arrays.equals(this.data, defaultChannelId.data);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return asShortText();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (this == channelId) {
            return 0;
        }
        if (!(channelId instanceof DefaultChannelId)) {
            return asLongText().compareTo(channelId.asLongText());
        }
        byte[] bArr = ((DefaultChannelId) channelId).data;
        int length = this.data.length;
        int length2 = bArr.length;
        int iMin = Math.min(length, length2);
        for (int i10 = 0; i10 < iMin; i10++) {
            byte b10 = this.data[i10];
            byte b11 = bArr[i10];
            if (b10 != b11) {
                return (b10 & 255) - (b11 & 255);
            }
        }
        return length - length2;
    }
}
