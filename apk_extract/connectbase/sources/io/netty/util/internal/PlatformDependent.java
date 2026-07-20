package io.netty.util.internal;

import c1.c;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscUnboundedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ks.g;
import ls.b;

/* JADX INFO: loaded from: classes3.dex */
public final class PlatformDependent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    private static final String[] ALLOWED_LINUX_OS_CLASSIFIERS;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER;
    private static final int BIT_MODE;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    private static final Cleaner CLEANER;
    private static final boolean DIRECT_BUFFER_PREFERRED;
    private static final AtomicLong DIRECT_MEMORY_COUNTER;
    private static final long DIRECT_MEMORY_LIMIT;
    private static final boolean IS_IVKVM_DOT_NET;
    private static final boolean IS_J9_JVM;
    private static final boolean IS_OSX;
    private static final boolean IS_WINDOWS;
    private static final String LINUX_ID_LIKE_PREFIX = "ID_LIKE=";
    private static final String LINUX_ID_PREFIX = "ID=";
    private static final Set<String> LINUX_OS_CLASSIFIERS;
    private static final int MAX_ALLOWED_MPSC_CAPACITY = 1073741824;
    private static final long MAX_DIRECT_MEMORY;
    private static Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = null;
    private static final boolean MAYBE_SUPER_USER;
    private static final int MIN_MAX_MPSC_CAPACITY = 2048;
    private static final int MPSC_CHUNK_SIZE = 1024;
    private static final Cleaner NOOP;
    private static final String NORMALIZED_ARCH;
    private static final String NORMALIZED_OS;
    private static final String[] OS_RELEASE_FILES;
    private static final ThreadLocalRandomProvider RANDOM_PROVIDER;
    private static final File TMPDIR;
    private static final int UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
    private static final InternalLogger logger;

    public static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 4074772784610639305L;

        private AtomicLongCounter() {
        }

        @Override // io.netty.util.internal.LongCounter
        public void add(long j10) {
            addAndGet(j10);
        }

        @Override // io.netty.util.internal.LongCounter
        public void decrement() {
            decrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public void increment() {
            incrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public long value() {
            return get();
        }
    }

    public interface ThreadLocalRandomProvider {
        Random current();
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent.class);
        logger = internalLoggerFactory;
        CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = !isAndroid();
        UNSAFE_UNAVAILABILITY_CAUSE = unsafeUnavailabilityCause0();
        long jEstimateMaxDirectMemory = estimateMaxDirectMemory();
        MAX_DIRECT_MEMORY = jEstimateMaxDirectMemory;
        BYTE_ARRAY_BASE_OFFSET = byteArrayBaseOffset0();
        TMPDIR = tmpdir0();
        BIT_MODE = bitMode0();
        NORMALIZED_ARCH = normalizeArch(SystemPropertyUtil.get("os.arch", ""));
        NORMALIZED_OS = normalizeOs(SystemPropertyUtil.get("os.name", ""));
        String[] strArr = {"fedora", "suse", "arch"};
        ALLOWED_LINUX_OS_CLASSIFIERS = strArr;
        IS_WINDOWS = isWindows0();
        IS_OSX = isOsx0();
        IS_J9_JVM = isJ9Jvm0();
        IS_IVKVM_DOT_NET = isIkvmDotNet0();
        ADDRESS_SIZE = addressSize0();
        OS_RELEASE_FILES = new String[]{"/etc/os-release", "/usr/lib/os-release"};
        boolean z10 = false;
        BIG_ENDIAN_NATIVE_ORDER = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        Cleaner cleaner = new Cleaner() { // from class: io.netty.util.internal.PlatformDependent.1
            @Override // io.netty.util.internal.Cleaner
            public void freeDirectBuffer(ByteBuffer byteBuffer) {
            }
        };
        NOOP = cleaner;
        if (javaVersion() >= 7) {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() { // from class: io.netty.util.internal.PlatformDependent.2
                @Override // io.netty.util.internal.PlatformDependent.ThreadLocalRandomProvider
                @SuppressJava6Requirement(reason = "Usage guarded by java version check")
                public Random current() {
                    return java.util.concurrent.ThreadLocalRandom.current();
                }
            };
        } else {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() { // from class: io.netty.util.internal.PlatformDependent.3
                @Override // io.netty.util.internal.PlatformDependent.ThreadLocalRandomProvider
                public Random current() {
                    return ThreadLocalRandom.current();
                }
            };
        }
        long j10 = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1L);
        if (j10 != 0 && hasUnsafe() && PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            USE_DIRECT_BUFFER_NO_CLEANER = true;
            if (j10 < 0) {
                if (jEstimateMaxDirectMemory <= 0) {
                    DIRECT_MEMORY_COUNTER = null;
                } else {
                    DIRECT_MEMORY_COUNTER = new AtomicLong();
                }
                j10 = jEstimateMaxDirectMemory;
            } else {
                DIRECT_MEMORY_COUNTER = new AtomicLong();
            }
        } else {
            USE_DIRECT_BUFFER_NO_CLEANER = false;
            DIRECT_MEMORY_COUNTER = null;
        }
        internalLoggerFactory.debug("-Dio.netty.maxDirectMemory: {} bytes", Long.valueOf(j10));
        if (j10 >= 1) {
            jEstimateMaxDirectMemory = j10;
        }
        DIRECT_MEMORY_LIMIT = jEstimateMaxDirectMemory;
        int i10 = SystemPropertyUtil.getInt("io.netty.uninitializedArrayAllocationThreshold", 1024);
        if (javaVersion() < 9 || !PlatformDependent0.hasAllocateArrayMethod()) {
            i10 = -1;
        }
        UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD = i10;
        internalLoggerFactory.debug("-Dio.netty.uninitializedArrayAllocationThreshold: {}", Integer.valueOf(i10));
        MAYBE_SUPER_USER = maybeSuperUser0();
        if (isAndroid()) {
            CLEANER = cleaner;
        } else if (javaVersion() >= 9) {
            CLEANER = CleanerJava9.isSupported() ? new CleanerJava9() : cleaner;
        } else {
            CLEANER = CleanerJava6.isSupported() ? new CleanerJava6() : cleaner;
        }
        Cleaner cleaner2 = CLEANER;
        if (cleaner2 != cleaner && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false)) {
            z10 = true;
        }
        DIRECT_BUFFER_PREFERRED = z10;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(true ^ z10));
        }
        if (cleaner2 == cleaner && !PlatformDependent0.isExplicitNoUnsafe()) {
            internalLoggerFactory.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!addPropertyOsClassifiers(setUnmodifiableSet, linkedHashSet)) {
            addFilesystemOsClassifiers(setUnmodifiableSet, linkedHashSet);
        }
        LINUX_OS_CLASSIFIERS = Collections.unmodifiableSet(linkedHashSet);
    }

    private PlatformDependent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addClassifier(Set<String> set, Set<String> set2, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                set2.add(str);
            }
        }
    }

    public static void addFilesystemOsClassifiers(final Set<String> set, final Set<String> set2) {
        for (final String str : OS_RELEASE_FILES) {
            final File file = new File(str);
            if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: io.netty.util.internal.PlatformDependent.4
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Code duplicated, block: B:50:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.security.PrivilegedAction
                public Boolean run() throws Throwable {
                    Throwable th2;
                    BufferedReader bufferedReader;
                    SecurityException e10;
                    IOException e11;
                    try {
                        if (file.exists()) {
                            BufferedReader bufferedReader2 = null;
                            try {
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), CharsetUtil.UTF_8));
                                    while (true) {
                                        try {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            if (line.startsWith(PlatformDependent.LINUX_ID_PREFIX)) {
                                                PlatformDependent.addClassifier(set, set2, PlatformDependent.normalizeOsReleaseVariableValue(line.substring(3)));
                                            } else if (line.startsWith(PlatformDependent.LINUX_ID_LIKE_PREFIX)) {
                                                PlatformDependent.addClassifier(set, set2, PlatformDependent.normalizeOsReleaseVariableValue(line.substring(8)).split("[ ]+"));
                                            }
                                        } catch (IOException e12) {
                                            e11 = e12;
                                            PlatformDependent.logger.debug("Error while reading content of {}", str, e11);
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (IOException unused) {
                                                }
                                            }
                                            return Boolean.TRUE;
                                        } catch (SecurityException e13) {
                                            e10 = e13;
                                            PlatformDependent.logger.debug("Unable to read {}", str, e10);
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            return Boolean.TRUE;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    if (0 != 0) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (IOException e14) {
                                bufferedReader = null;
                                e11 = e14;
                            } catch (SecurityException e15) {
                                bufferedReader = null;
                                e10 = e15;
                            } catch (Throwable th4) {
                                th2 = th4;
                                if (0 != 0) {
                                    bufferedReader2.close();
                                }
                                throw th2;
                            }
                            bufferedReader.close();
                            return Boolean.TRUE;
                        }
                    } catch (SecurityException e16) {
                        PlatformDependent.logger.debug("Unable to check if {} exists", str, e16);
                    }
                    return Boolean.FALSE;
                }
            })).booleanValue()) {
                return;
            }
        }
    }

    public static boolean addPropertyOsClassifiers(Set<String> set, Set<String> set2) {
        String str = SystemPropertyUtil.get("io.netty.osClassifiers");
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return true;
        }
        String[] strArrSplit = str.split(g.f9491d);
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("io.netty.osClassifiers property is not empty, but contains no classifiers: ".concat(str));
        }
        if (strArrSplit.length > 2) {
            throw new IllegalArgumentException("io.netty.osClassifiers property contains more than 2 classifiers: ".concat(str));
        }
        for (String str2 : strArrSplit) {
            addClassifier(set, set2, str2);
        }
        return true;
    }

    public static int addressSize() {
        return ADDRESS_SIZE;
    }

    private static int addressSize0() {
        if (hasUnsafe()) {
            return PlatformDependent0.addressSize();
        }
        return -1;
    }

    public static long align(long j10, int i10) {
        return Pow2.align(j10, i10);
    }

    public static ByteBuffer alignDirectBuffer(ByteBuffer byteBuffer, int i10) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Cannot get aligned slice of non-direct byte buffer.");
        }
        if (PlatformDependent0.hasAlignSliceMethod()) {
            return PlatformDependent0.alignSlice(byteBuffer, i10);
        }
        if (!hasUnsafe()) {
            throw new UnsupportedOperationException("Cannot align direct buffer. Needs either Unsafe or ByteBuffer.alignSlice method available.");
        }
        long jDirectBufferAddress = directBufferAddress(byteBuffer);
        byteBuffer.position((int) (align(jDirectBufferAddress, i10) - jDirectBufferAddress));
        return byteBuffer.slice();
    }

    public static ByteBuffer allocateDirectNoCleaner(int i10) throws Throwable {
        incrementMemoryCounter(i10);
        try {
            return PlatformDependent0.allocateDirectNoCleaner(i10);
        } catch (Throwable th2) {
            decrementMemoryCounter(i10);
            throwException(th2);
            return null;
        }
    }

    public static long allocateMemory(long j10) {
        return PlatformDependent0.allocateMemory(j10);
    }

    public static byte[] allocateUninitializedArray(int i10) {
        int i11 = UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
        return (i11 < 0 || i11 > i10) ? new byte[i10] : PlatformDependent0.allocateUninitializedArray(i10);
    }

    public static int bitMode() {
        return BIT_MODE;
    }

    private static int bitMode0() {
        int i10 = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if (i10 > 0) {
            logger.debug("-Dio.netty.bitMode: {}", Integer.valueOf(i10));
            return i10;
        }
        int i11 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if (i11 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(i11));
            return i11;
        }
        int i12 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if (i12 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(i12));
            return i12;
        }
        String str = SystemPropertyUtil.get("os.arch", "");
        Locale locale = Locale.US;
        String strTrim = str.toLowerCase(locale).trim();
        if ("amd64".equals(strTrim) || b.f10280b.equals(strTrim)) {
            i12 = 64;
        } else if ("i386".equals(strTrim) || "i486".equals(strTrim) || "i586".equals(strTrim) || "i686".equals(strTrim)) {
            i12 = 32;
        }
        if (i12 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i12), strTrim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(SystemPropertyUtil.get("java.vm.name", "").toLowerCase(locale));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    private static long byteArrayBaseOffset0() {
        if (hasUnsafe()) {
            return PlatformDependent0.byteArrayBaseOffset();
        }
        return -1L;
    }

    public static boolean canEnableTcpNoDelayByDefault() {
        return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    }

    public static void copyMemory(long j10, long j11, long j12) {
        PlatformDependent0.copyMemory(j10, j11, j12);
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    public static File createTempFile(String str, String str2, File file) throws IOException {
        if (javaVersion() >= 7) {
            return file == null ? Files.createTempFile(str, str2, new FileAttribute[0]).toFile() : Files.createTempFile(file.toPath(), str, str2, new FileAttribute[0]).toFile();
        }
        File fileCreateTempFile = file == null ? File.createTempFile(str, str2) : File.createTempFile(str, str2, file);
        if (!fileCreateTempFile.setReadable(false, false)) {
            throw new IOException("Failed to set permissions on temporary file " + fileCreateTempFile);
        }
        if (fileCreateTempFile.setReadable(true, true)) {
            return fileCreateTempFile;
        }
        throw new IOException("Failed to set permissions on temporary file " + fileCreateTempFile);
    }

    private static void decrementMemoryCounter(int i10) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            atomicLong.addAndGet(-i10);
        }
    }

    public static ByteBuffer directBuffer(long j10, int i10) {
        if (PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            return PlatformDependent0.newDirectBuffer(j10, i10);
        }
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent0.directBufferAddress(byteBuffer);
    }

    public static boolean directBufferPreferred() {
        return DIRECT_BUFFER_PREFERRED;
    }

    public static boolean equals(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.equals(bArr, i10, bArr2, i11, i12) : equalsSafe(bArr, i10, bArr2, i11, i12);
    }

    public static int equalsConstantTime(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.equalsConstantTime(bArr, i10, bArr2, i11, i12) : ConstantTimeUtils.equalsConstantTime(bArr, i10, bArr2, i11, i12);
    }

    private static boolean equalsSafe(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if (r4 != 'm') goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long estimateMaxDirectMemory() {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.estimateMaxDirectMemory():long");
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        CLEANER.freeDirectBuffer(byteBuffer);
    }

    public static void freeDirectNoCleaner(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(byteBuffer));
        decrementMemoryCounter(iCapacity);
    }

    public static void freeMemory(long j10) {
        PlatformDependent0.freeMemory(j10);
    }

    public static byte getByte(long j10) {
        return PlatformDependent0.getByte(j10);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return PlatformDependent0.getClassLoader(cls);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static int getInt(Object obj, long j10) {
        return PlatformDependent0.getInt(obj, j10);
    }

    private static int getIntSafe(byte[] bArr, int i10) {
        int i11;
        int i12;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i11 = (bArr[i10] << c.B) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
            i12 = bArr[i10 + 3] & 255;
        } else {
            i11 = (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
            i12 = bArr[i10 + 3] << c.B;
        }
        return i12 | i11;
    }

    public static int getIntVolatile(long j10) {
        return PlatformDependent0.getIntVolatile(j10);
    }

    public static long getLong(long j10) {
        return PlatformDependent0.getLong(j10);
    }

    private static long getLongSafe(byte[] bArr, int i10) {
        long j10;
        long j11;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            j10 = ((((long) bArr[i10 + 6]) & 255) << 8) | ((((long) bArr[i10 + 1]) & 255) << 48) | (((long) bArr[i10]) << 56) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16);
            j11 = ((long) bArr[i10 + 7]) & 255;
        } else {
            j10 = ((((long) bArr[i10 + 1]) & 255) << 8) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
            j11 = ((long) bArr[i10 + 7]) << 56;
        }
        return j11 | j10;
    }

    private static Pattern getMaxDirectMemorySizeArgPattern() {
        Pattern pattern = MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN;
        if (pattern != null) {
            return pattern;
        }
        Pattern patternCompile = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
        MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = patternCompile;
        return patternCompile;
    }

    public static Object getObject(Object obj, long j10) {
        return PlatformDependent0.getObject(obj, j10);
    }

    public static short getShort(long j10) {
        return PlatformDependent0.getShort(j10);
    }

    private static short getShortSafe(byte[] bArr, int i10) {
        int i11;
        int i12;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i11 = bArr[i10] << 8;
            i12 = bArr[i10 + 1] & 255;
        } else {
            i11 = bArr[i10] & 255;
            i12 = bArr[i10 + 1] << 8;
        }
        return (short) (i12 | i11);
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasAlignDirectByteBuffer() {
        return hasUnsafe() || PlatformDependent0.hasAlignSliceMethod();
    }

    public static boolean hasDirectBufferNoCleanerConstructor() {
        return PlatformDependent0.hasDirectBufferNoCleanerConstructor();
    }

    public static boolean hasUnsafe() {
        return UNSAFE_UNAVAILABILITY_CAUSE == null;
    }

    public static int hashCodeAscii(byte[] bArr, int i10, int i11) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.hashCodeAscii(bArr, i10, i11) : hashCodeAsciiSafe(bArr, i10, i11);
    }

    private static int hashCodeAsciiCompute(CharSequence charSequence, int i10, int i11) {
        int iHashCodeAsciiSanitizeInt;
        int iHashCodeAsciiSanitizeInt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            iHashCodeAsciiSanitizeInt = (hashCodeAsciiSanitizeInt(charSequence, i10 + 4) * 461845907) + (i11 * (-862048943));
            iHashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i10);
        } else {
            iHashCodeAsciiSanitizeInt = (hashCodeAsciiSanitizeInt(charSequence, i10) * 461845907) + (i11 * (-862048943));
            iHashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i10 + 4);
        }
        return iHashCodeAsciiSanitizeInt + iHashCodeAsciiSanitizeInt2;
    }

    public static int hashCodeAsciiSafe(byte[] bArr, int i10, int i11) {
        int iHashCodeAsciiSanitize;
        int iHashCodeAsciiSanitize2;
        int i12 = i11 & 7;
        int i13 = i10 + i12;
        int iHashCodeAsciiCompute = -1028477387;
        for (int i14 = (i10 - 8) + i11; i14 >= i13; i14 -= 8) {
            iHashCodeAsciiCompute = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(bArr, i14), iHashCodeAsciiCompute);
        }
        switch (i12) {
            case 1:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * (-862048943);
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(bArr[i10]);
                break;
            case 2:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * (-862048943);
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i10));
                break;
            case 3:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * (-862048943)) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i10])) * 461845907;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i10 + 1));
                break;
            case 4:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * (-862048943);
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i10));
                break;
            case 5:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * (-862048943)) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i10])) * 461845907;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i10 + 1));
                break;
            case 6:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * (-862048943)) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i10))) * 461845907;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i10 + 2));
                break;
            case 7:
                iHashCodeAsciiSanitize = ((((iHashCodeAsciiCompute * (-862048943)) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i10])) * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i10 + 1))) * (-862048943);
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i10 + 3));
                break;
            default:
                return iHashCodeAsciiCompute;
        }
        return iHashCodeAsciiSanitize + iHashCodeAsciiSanitize2;
    }

    private static int hashCodeAsciiSanitizeByte(char c10) {
        return c10 & s1.c.f14922b;
    }

    private static int hashCodeAsciiSanitizeInt(CharSequence charSequence, int i10) {
        int iCharAt;
        int iCharAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            iCharAt = (charSequence.charAt(i10 + 3) & s1.c.f14922b) | ((charSequence.charAt(i10 + 2) & s1.c.f14922b) << 8) | ((charSequence.charAt(i10 + 1) & s1.c.f14922b) << 16);
            iCharAt2 = (charSequence.charAt(i10) & s1.c.f14922b) << 24;
        } else {
            iCharAt = ((charSequence.charAt(i10 + 3) & s1.c.f14922b) << 24) | ((charSequence.charAt(i10 + 2) & s1.c.f14922b) << 16) | ((charSequence.charAt(i10 + 1) & s1.c.f14922b) << 8);
            iCharAt2 = charSequence.charAt(i10) & s1.c.f14922b;
        }
        return iCharAt2 | iCharAt;
    }

    private static int hashCodeAsciiSanitizeShort(CharSequence charSequence, int i10) {
        int iCharAt;
        int iCharAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            iCharAt = charSequence.charAt(i10 + 1) & s1.c.f14922b;
            iCharAt2 = (charSequence.charAt(i10) & s1.c.f14922b) << 8;
        } else {
            iCharAt = (charSequence.charAt(i10 + 1) & s1.c.f14922b) << 8;
            iCharAt2 = charSequence.charAt(i10) & s1.c.f14922b;
        }
        return iCharAt2 | iCharAt;
    }

    private static void incrementMemoryCounter(int i10) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            long j10 = i10;
            long jAddAndGet = atomicLong.addAndGet(j10);
            long j11 = DIRECT_MEMORY_LIMIT;
            if (jAddAndGet <= j11) {
                return;
            }
            atomicLong.addAndGet(-i10);
            StringBuilder sbA = h.b.a("failed to allocate ", i10, " byte(s) of direct memory (used: ");
            sbA.append(jAddAndGet - j10);
            sbA.append(", max: ");
            sbA.append(j11);
            sbA.append(')');
            throw new OutOfDirectMemoryError(sbA.toString());
        }
    }

    public static boolean isAndroid() {
        return PlatformDependent0.isAndroid();
    }

    public static boolean isIkvmDotNet() {
        return IS_IVKVM_DOT_NET;
    }

    private static boolean isIkvmDotNet0() {
        return SystemPropertyUtil.get("java.vm.name", "").toUpperCase(Locale.US).equals("IKVM.NET");
    }

    public static boolean isJ9Jvm() {
        return IS_J9_JVM;
    }

    private static boolean isJ9Jvm0() {
        String lowerCase = SystemPropertyUtil.get("java.vm.name", "").toLowerCase();
        return lowerCase.startsWith("ibm j9") || lowerCase.startsWith("eclipse openj9");
    }

    public static boolean isOsx() {
        return IS_OSX;
    }

    private static boolean isOsx0() {
        boolean zEquals = "osx".equals(NORMALIZED_OS);
        if (zEquals) {
            logger.debug("Platform: MacOS");
        }
        return zEquals;
    }

    public static boolean isUnaligned() {
        return PlatformDependent0.isUnaligned();
    }

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    private static boolean isWindows0() {
        boolean zEquals = "windows".equals(NORMALIZED_OS);
        if (zEquals) {
            logger.debug("Platform: Windows");
        }
        return zEquals;
    }

    public static boolean isZero(byte[] bArr, int i10, int i11) {
        return (hasUnsafe() && PlatformDependent0.unalignedAccess()) ? PlatformDependent0.isZero(bArr, i10, i11) : isZeroSafe(bArr, i10, i11);
    }

    private static boolean isZeroSafe(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            if (bArr[i10] != 0) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public static int javaVersion() {
        return PlatformDependent0.javaVersion();
    }

    public static long maxDirectMemory() {
        return DIRECT_MEMORY_LIMIT;
    }

    public static boolean maybeSuperUser() {
        return MAYBE_SUPER_USER;
    }

    private static boolean maybeSuperUser0() {
        String str = SystemPropertyUtil.get("user.name");
        if (isWindows()) {
            return "Administrator".equals(str);
        }
        return "root".equals(str) || "toor".equals(str);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <C> Deque<C> newConcurrentDeque() {
        return javaVersion() < 7 ? new LinkedBlockingDeque() : new ConcurrentLinkedDeque();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap();
    }

    public static <T> Queue<T> newFixedMpscQueue(int i10) {
        return hasUnsafe() ? new MpscArrayQueue(i10) : new MpscAtomicArrayQueue(i10);
    }

    public static LongCounter newLongCounter() {
        return javaVersion() >= 8 ? new LongAdderCounter() : new AtomicLongCounter();
    }

    public static <T> Queue<T> newMpscQueue() {
        return Mpsc.newMpscQueue();
    }

    public static <T> Queue<T> newSpscQueue() {
        return hasUnsafe() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue();
    }

    private static String normalize(String str) {
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static String normalizeArch(String str) {
        String strNormalize = normalize(str);
        if (strNormalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return b.f10280b;
        }
        if (strNormalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return "x86_32";
        }
        if (strNormalize.matches("^(ia64|itanium64)$")) {
            return "itanium_64";
        }
        if (strNormalize.matches("^(sparc|sparc32)$")) {
            return "sparc_32";
        }
        if (strNormalize.matches("^(sparcv9|sparc64)$")) {
            return "sparc_64";
        }
        if (strNormalize.matches("^(arm|arm32)$")) {
            return "arm_32";
        }
        if ("aarch64".equals(strNormalize)) {
            return "aarch_64";
        }
        if (strNormalize.matches("^(ppc|ppc32)$")) {
            return "ppc_32";
        }
        if (b.f10284f.equals(strNormalize)) {
            return "ppc_64";
        }
        if ("ppc64le".equals(strNormalize)) {
            return "ppcle_64";
        }
        if ("s390".equals(strNormalize)) {
            return "s390_32";
        }
        if ("s390x".equals(strNormalize)) {
            return "s390_64";
        }
        return "loongarch64".equals(strNormalize) ? "loongarch_64" : "unknown";
    }

    private static String normalizeOs(String str) {
        String strNormalize = normalize(str);
        if (strNormalize.startsWith("aix")) {
            return "aix";
        }
        if (strNormalize.startsWith("hpux")) {
            return "hpux";
        }
        if (strNormalize.startsWith("os400") && (strNormalize.length() <= 5 || !Character.isDigit(strNormalize.charAt(5)))) {
            return "os400";
        }
        if (strNormalize.startsWith("linux")) {
            return "linux";
        }
        String str2 = "osx";
        if (!strNormalize.startsWith("macosx") && !strNormalize.startsWith("osx") && !strNormalize.startsWith("darwin")) {
            if (strNormalize.startsWith("freebsd")) {
                return "freebsd";
            }
            if (strNormalize.startsWith("openbsd")) {
                return "openbsd";
            }
            if (strNormalize.startsWith("netbsd")) {
                return "netbsd";
            }
            str2 = "sunos";
            if (!strNormalize.startsWith("solaris") && !strNormalize.startsWith("sunos")) {
                return strNormalize.startsWith("windows") ? "windows" : "unknown";
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizeOsReleaseVariableValue(String str) {
        return str.trim().replaceAll("[\"']", "");
    }

    public static String normalizedArch() {
        return NORMALIZED_ARCH;
    }

    public static Set<String> normalizedLinuxClassifiers() {
        return LINUX_OS_CLASSIFIERS;
    }

    public static String normalizedOs() {
        return NORMALIZED_OS;
    }

    public static long objectFieldOffset(Field field) {
        return PlatformDependent0.objectFieldOffset(field);
    }

    public static void putByte(long j10, byte b10) {
        PlatformDependent0.putByte(j10, b10);
    }

    public static void putInt(long j10, int i10) {
        PlatformDependent0.putInt(j10, i10);
    }

    public static void putIntOrdered(long j10, int i10) {
        PlatformDependent0.putIntOrdered(j10, i10);
    }

    public static void putLong(long j10, long j11) {
        PlatformDependent0.putLong(j10, j11);
    }

    public static void putObject(Object obj, long j10, Object obj2) {
        PlatformDependent0.putObject(obj, j10, obj2);
    }

    public static void putShort(long j10, short s10) {
        PlatformDependent0.putShort(j10, s10);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i10) throws Throwable {
        int iCapacity = i10 - byteBuffer.capacity();
        incrementMemoryCounter(iCapacity);
        try {
            return PlatformDependent0.reallocateDirectNoCleaner(byteBuffer, i10);
        } catch (Throwable th2) {
            decrementMemoryCounter(iCapacity);
            throwException(th2);
            return null;
        }
    }

    public static long reallocateMemory(long j10, long j11) {
        return PlatformDependent0.reallocateMemory(j10, j11);
    }

    public static void safeConstructPutInt(Object obj, long j10, int i10) {
        PlatformDependent0.safeConstructPutInt(obj, j10, i10);
    }

    public static void setMemory(byte[] bArr, int i10, long j10, byte b10) {
        PlatformDependent0.setMemory(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), j10, b10);
    }

    public static Random threadLocalRandom() {
        return RANDOM_PROVIDER.current();
    }

    public static void throwException(Throwable th2) throws Throwable {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(th2);
        } else {
            throwException0(th2);
        }
    }

    private static <E extends Throwable> void throwException0(Throwable th2) throws Throwable {
        throw th2;
    }

    public static File tmpdir() {
        return TMPDIR;
    }

    private static File tmpdir0() {
        try {
            File directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
            if (directory != null) {
                logger.debug("-Dio.netty.tmpdir: {}", directory);
                return directory;
            }
            File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
            if (directory2 != null) {
                logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", directory2);
                return directory2;
            }
            if (isWindows()) {
                File directory3 = toDirectory(System.getenv("TEMP"));
                if (directory3 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", directory3);
                    return directory3;
                }
                String str = System.getenv("USERPROFILE");
                if (str != null) {
                    File directory4 = toDirectory(str.concat("\\AppData\\Local\\Temp"));
                    if (directory4 != null) {
                        logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", directory4);
                        return directory4;
                    }
                    File directory5 = toDirectory(str.concat("\\Local Settings\\Temp"));
                    if (directory5 != null) {
                        logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", directory5);
                        return directory5;
                    }
                }
            } else {
                File directory6 = toDirectory(System.getenv("TMPDIR"));
                if (directory6 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", directory6);
                    return directory6;
                }
            }
            File file = isWindows() ? new File("C:\\Windows\\Temp") : new File("/tmp");
            logger.warn("Failed to get the temporary directory; falling back to: {}", file);
            return file;
        } catch (Throwable unused) {
        }
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception unused) {
            return file;
        }
    }

    private static Throwable unsafeUnavailabilityCause0() {
        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (Android)");
        }
        if (isIkvmDotNet()) {
            logger.debug("sun.misc.Unsafe: unavailable (IKVM.NET)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (IKVM.NET)");
        }
        Throwable unsafeUnavailabilityCause = PlatformDependent0.getUnsafeUnavailabilityCause();
        if (unsafeUnavailabilityCause != null) {
            return unsafeUnavailabilityCause;
        }
        try {
            boolean zHasUnsafe = PlatformDependent0.hasUnsafe();
            logger.debug("sun.misc.Unsafe: {}", zHasUnsafe ? "available" : "unavailable");
            if (zHasUnsafe) {
                return null;
            }
            return PlatformDependent0.getUnsafeUnavailabilityCause();
        } catch (Throwable th2) {
            logger.trace("Could not determine if Unsafe is available", th2);
            return new UnsupportedOperationException("Could not determine if Unsafe is available", th2);
        }
    }

    public static boolean useDirectBufferNoCleaner() {
        return USE_DIRECT_BUFFER_NO_CLEANER;
    }

    public static long usedDirectMemory() {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return -1L;
    }

    public static final class Mpsc {
        private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;

        static {
            if ((PlatformDependent.hasUnsafe() ? AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent.Mpsc.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return UnsafeAccess.UNSAFE;
                }
            }) : null) == null) {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
            } else {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
            }
        }

        private Mpsc() {
        }

        public static <T> Queue<T> newChunkedMpscQueue(int i10, int i11) {
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscChunkedArrayQueue(i10, i11) : new MpscChunkedAtomicArrayQueue(i10, i11);
        }

        public static <T> Queue<T> newMpscQueue(int i10) {
            return newChunkedMpscQueue(1024, Math.max(Math.min(i10, 1073741824), 2048));
        }

        public static <T> Queue<T> newMpscQueue() {
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscUnboundedArrayQueue(1024) : new MpscUnboundedAtomicArrayQueue(1024);
        }
    }

    public static void copyMemory(byte[] bArr, int i10, long j10, long j11) {
        PlatformDependent0.copyMemory(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), null, j10, j11);
    }

    public static byte getByte(byte[] bArr, int i10) {
        return PlatformDependent0.getByte(bArr, i10);
    }

    public static int getInt(long j10) {
        return PlatformDependent0.getInt(j10);
    }

    public static long getLong(byte[] bArr, int i10) {
        return PlatformDependent0.getLong(bArr, i10);
    }

    public static short getShort(byte[] bArr, int i10) {
        return PlatformDependent0.getShort(bArr, i10);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i10) {
        return new ConcurrentHashMap(i10);
    }

    public static <T> Queue<T> newMpscQueue(int i10) {
        return Mpsc.newMpscQueue(i10);
    }

    public static void putByte(byte[] bArr, int i10, byte b10) {
        PlatformDependent0.putByte(bArr, i10, b10);
    }

    public static void putInt(byte[] bArr, int i10, int i11) {
        PlatformDependent0.putInt(bArr, i10, i11);
    }

    public static void putLong(byte[] bArr, int i10, long j10) {
        PlatformDependent0.putLong(bArr, i10, j10);
    }

    public static void putShort(byte[] bArr, int i10, short s10) {
        PlatformDependent0.putShort(bArr, i10, s10);
    }

    public static void setMemory(long j10, long j11, byte b10) {
        PlatformDependent0.setMemory(j10, j11, b10);
    }

    public static void copyMemory(byte[] bArr, int i10, byte[] bArr2, int i11, long j10) {
        long j11 = BYTE_ARRAY_BASE_OFFSET;
        PlatformDependent0.copyMemory(bArr, j11 + ((long) i10), bArr2, j11 + ((long) i11), j10);
    }

    public static byte getByte(byte[] bArr, long j10) {
        return PlatformDependent0.getByte(bArr, j10);
    }

    public static int getInt(byte[] bArr, int i10) {
        return PlatformDependent0.getInt(bArr, i10);
    }

    public static long getLong(long[] jArr, long j10) {
        return PlatformDependent0.getLong(jArr, j10);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i10, float f10) {
        return new ConcurrentHashMap(i10, f10);
    }

    public static <T> Queue<T> newMpscQueue(int i10, int i11) {
        return Mpsc.newChunkedMpscQueue(i10, i11);
    }

    public static void putByte(Object obj, long j10, byte b10) {
        PlatformDependent0.putByte(obj, j10, b10);
    }

    public static void copyMemory(long j10, byte[] bArr, int i10, long j11) {
        PlatformDependent0.copyMemory(null, j10, bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), j11);
    }

    public static int getInt(int[] iArr, long j10) {
        return PlatformDependent0.getInt(iArr, j10);
    }

    public static int hashCodeAscii(CharSequence charSequence) {
        int i10;
        int length = charSequence.length();
        int i11 = length & 7;
        int iHashCodeAsciiCompute = -1028477387;
        if (length >= 32) {
            for (int i12 = length - 8; i12 >= i11; i12 -= 8) {
                iHashCodeAsciiCompute = hashCodeAsciiCompute(charSequence, i12, iHashCodeAsciiCompute);
            }
        } else if (length >= 8) {
            iHashCodeAsciiCompute = hashCodeAsciiCompute(charSequence, length - 8, -1028477387);
            if (length >= 16) {
                iHashCodeAsciiCompute = hashCodeAsciiCompute(charSequence, length - 16, iHashCodeAsciiCompute);
                if (length >= 24) {
                    iHashCodeAsciiCompute = hashCodeAsciiCompute(charSequence, length - 24, iHashCodeAsciiCompute);
                }
            }
        }
        if (i11 == 0) {
            return iHashCodeAsciiCompute;
        }
        if (((i11 != 2) && (i11 != 4)) && (i11 != 6)) {
            iHashCodeAsciiCompute = (iHashCodeAsciiCompute * (-862048943)) + hashCodeAsciiSanitizeByte(charSequence.charAt(0));
            i10 = 1;
        } else {
            i10 = 0;
        }
        if ((i11 != 1) & (i11 != 4) & (i11 != 5)) {
            iHashCodeAsciiCompute = (iHashCodeAsciiCompute * (i10 == 0 ? -862048943 : 461845907)) + PlatformDependent0.hashCodeAsciiSanitize(hashCodeAsciiSanitizeShort(charSequence, i10));
            i10 += 2;
        }
        if (i11 >= 4) {
            return (iHashCodeAsciiCompute * (((i10 == 0) || (i10 == 3)) ? -862048943 : 461845907)) + hashCodeAsciiSanitizeInt(charSequence, i10);
        }
        return iHashCodeAsciiCompute;
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i10, float f10, int i11) {
        return new ConcurrentHashMap(i10, f10, i11);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> map) {
        return new ConcurrentHashMap(map);
    }
}
