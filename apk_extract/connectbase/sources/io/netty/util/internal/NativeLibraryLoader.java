package io.netty.util.internal;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFilePermission;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import m.a;
import n1.e;
import p1.c;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING;
    private static final boolean DETECT_NATIVE_LIBRARY_DUPLICATES;
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final boolean TRY_TO_PATCH_SHADED_ID;
    private static final byte[] UNIQUE_ID_BYTES;
    private static final File WORKDIR;
    private static final InternalLogger logger;

    public static final class NoexecVolumeDetector {
        private NoexecVolumeDetector() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public static boolean canExecuteExecutable(File file) throws IOException {
            if (PlatformDependent.javaVersion() < 7 || file.canExecute()) {
                return true;
            }
            Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(file.toPath(), new LinkOption[0]);
            EnumSet enumSetOf = EnumSet.of(PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE);
            if (posixFilePermissions.containsAll(enumSetOf)) {
                return false;
            }
            EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) posixFilePermissions);
            enumSetCopyOf.addAll(enumSetOf);
            Files.setPosixFilePermissions(file.toPath(), enumSetCopyOf);
            return file.canExecute();
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) NativeLibraryLoader.class);
        logger = internalLoggerFactory;
        UNIQUE_ID_BYTES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(CharsetUtil.US_ASCII);
        String str = SystemPropertyUtil.get("io.netty.native.workdir");
        if (str != null) {
            File file = new File(str);
            file.mkdirs();
            try {
                file = file.getAbsoluteFile();
            } catch (Exception unused) {
            }
            WORKDIR = file;
            logger.debug("-Dio.netty.native.workdir: " + file);
        } else {
            File fileTmpdir = PlatformDependent.tmpdir();
            WORKDIR = fileTmpdir;
            internalLoggerFactory.debug("-Dio.netty.native.workdir: " + fileTmpdir + " (io.netty.tmpdir)");
        }
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.native.deleteLibAfterLoading", true);
        DELETE_NATIVE_LIB_AFTER_LOADING = z10;
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.native.deleteLibAfterLoading: {}", Boolean.valueOf(z10));
        boolean z11 = SystemPropertyUtil.getBoolean("io.netty.native.tryPatchShadedId", true);
        TRY_TO_PATCH_SHADED_ID = z11;
        internalLogger.debug("-Dio.netty.native.tryPatchShadedId: {}", Boolean.valueOf(z11));
        boolean z12 = SystemPropertyUtil.getBoolean("io.netty.native.detectNativeLibraryDuplicates", true);
        DETECT_NATIVE_LIBRARY_DUPLICATES = z12;
        internalLogger.debug("-Dio.netty.native.detectNativeLibraryDuplicates: {}", Boolean.valueOf(z12));
    }

    private NativeLibraryLoader() {
    }

    private static String calculateMangledPackagePrefix() {
        String name = NativeLibraryLoader.class.getName();
        String strReplace = "io!netty!util!internal!NativeLibraryLoader".replace('!', e.f11183c);
        if (name.endsWith(strReplace)) {
            return name.substring(0, name.length() - strReplace.length()).replace("_", "_1").replace(e.f11183c, '_');
        }
        throw new UnsatisfiedLinkError(String.format("Could not find prefix added to %s to get %s. When shading, only adding a package prefix is supported", strReplace, name));
    }

    private static byte[] classToByteArray(Class<?> cls) throws ClassNotFoundException {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        URL resource = cls.getResource(name + c.f12696d);
        if (resource == null) {
            throw new ClassNotFoundException(cls.getName());
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        InputStream inputStreamOpenStream = null;
        try {
            try {
                inputStreamOpenStream = resource.openStream();
                while (true) {
                    int i10 = inputStreamOpenStream.read(bArr);
                    if (i10 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(inputStreamOpenStream);
                        closeQuietly(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                    closeQuietly(inputStreamOpenStream);
                    closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e10) {
                throw new ClassNotFoundException(cls.getName(), e10);
            }
        } catch (Throwable th2) {
            closeQuietly(inputStreamOpenStream);
            closeQuietly(byteArrayOutputStream);
            throw th2;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static byte[] digest(MessageDigest messageDigest, URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        InputStream inputStream = null;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i10 = inputStreamOpenStream.read(bArr);
                        if (i10 == -1) {
                            byte[] bArrDigest = messageDigest.digest();
                            closeQuietly(inputStreamOpenStream);
                            return bArrDigest;
                        }
                        messageDigest.update(bArr, 0, i10);
                        th = th;
                        inputStream = inputStreamOpenStream;
                        closeQuietly(inputStream);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    logger.debug("Can't read resource.", (Throwable) e);
                    closeQuietly(inputStreamOpenStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpenStream;
            }
        } catch (IOException e11) {
            e = e11;
            inputStreamOpenStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static byte[] generateUniqueId(int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr2 = UNIQUE_ID_BYTES;
            bArr[i11] = bArr2[PlatformDependent.threadLocalRandom().nextInt(bArr2.length)];
        }
        return bArr;
    }

    private static URL getResource(String str, ClassLoader classLoader) throws Throwable {
        try {
            ArrayList list = Collections.list(classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str));
            int size = list.size();
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return (URL) list.get(0);
            }
            if (!DETECT_NATIVE_LIBRARY_DUPLICATES) {
                logger.warn("Multiple resources found for '" + str + "' with different content: " + list + ". Please fix your dependency graph.");
                return (URL) list.get(0);
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                URL url = (URL) list.get(0);
                byte[] bArrDigest = digest(messageDigest, url);
                if (bArrDigest != null) {
                    for (int i10 = 1; i10 < size; i10++) {
                        byte[] bArrDigest2 = digest(messageDigest, (URL) list.get(i10));
                        if (bArrDigest2 != null && Arrays.equals(bArrDigest, bArrDigest2)) {
                        }
                    }
                    return url;
                }
            } catch (NoSuchAlgorithmException e10) {
                logger.debug("Don't support SHA-256, can't check if resources have same content.", (Throwable) e10);
            }
            throw new IllegalStateException("Multiple resources found for '" + str + "' with different content: " + list);
        } catch (IOException e11) {
            throw new RuntimeException(a.a("An error occurred while getting the resources for ", str), e11);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0140 */
    /* JADX WARN: Code duplicated, block: B:107:0x00b5 A[EDGE_INSN: B:107:0x00b5->B:42:0x00b5 BREAK  A[LOOP:0: B:33:0x00a1->B:35:0x00a7], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7 A[Catch: all -> 0x00ab, Exception -> 0x00af, UnsatisfiedLinkError -> 0x00b2, LOOP:0: B:33:0x00a1->B:35:0x00a7, LOOP_END, TryCatch #10 {Exception -> 0x00af, UnsatisfiedLinkError -> 0x00b2, all -> 0x00ab, blocks: (B:32:0x009f, B:33:0x00a1, B:35:0x00a7, B:42:0x00b5, B:44:0x00be, B:45:0x00c1), top: B:103:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00be A[Catch: all -> 0x00ab, Exception -> 0x00af, UnsatisfiedLinkError -> 0x00b2, TryCatch #10 {Exception -> 0x00af, UnsatisfiedLinkError -> 0x00b2, all -> 0x00ab, blocks: (B:32:0x009f, B:33:0x00a1, B:35:0x00a7, B:42:0x00b5, B:44:0x00be, B:45:0x00c1), top: B:103:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0144 A[Catch: all -> 0x0140, TryCatch #0 {, blocks: (B:82:0x0144, B:83:0x0147, B:79:0x0135, B:70:0x0114, B:72:0x011a, B:74:0x0120, B:76:0x0126), top: B:92:0x0112, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0150  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void load(java.lang.String r10, java.lang.ClassLoader r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.NativeLibraryLoader.load(java.lang.String, java.lang.ClassLoader):void");
    }

    public static void loadFirstAvailable(ClassLoader classLoader, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                load(str, classLoader);
                logger.debug("Loaded library with name '{}'", str);
                return;
            } catch (Throwable th2) {
                arrayList.add(th2);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to load any of the given libraries: " + Arrays.toString(strArr));
        ThrowableUtil.addSuppressedAndClear(illegalArgumentException, arrayList);
        throw illegalArgumentException;
    }

    private static void loadLibrary(ClassLoader classLoader, String str, boolean z10) {
        try {
            try {
                loadLibraryByHelper(tryToLoadClass(classLoader, NativeLibraryUtil.class), str, z10);
                logger.debug("Successfully loaded the library {}", str);
            } catch (NoSuchMethodError e10) {
                if (0 != 0) {
                    ThrowableUtil.addSuppressed(e10, (Throwable) null);
                }
                rethrowWithMoreDetailsIfPossible(str, e10);
            }
        } catch (Exception | UnsatisfiedLinkError e11) {
            try {
                NativeLibraryUtil.loadLibrary(str, z10);
                logger.debug("Successfully loaded the library {}", str);
            } catch (UnsatisfiedLinkError e12) {
                ThrowableUtil.addSuppressed(e12, e11);
                throw e12;
            }
        }
    }

    private static void loadLibraryByHelper(final Class<?> cls, final String str, final boolean z10) throws UnsatisfiedLinkError {
        Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.NativeLibraryLoader.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    Method method = cls.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method.setAccessible(true);
                    return method.invoke(null, str, Boolean.valueOf(z10));
                } catch (Exception e10) {
                    return e10;
                }
            }
        });
        if (objDoPrivileged instanceof Throwable) {
            Throwable th2 = (Throwable) objDoPrivileged;
            Throwable cause = th2.getCause();
            if (cause instanceof UnsatisfiedLinkError) {
                throw ((UnsatisfiedLinkError) cause);
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(th2.getMessage());
            unsatisfiedLinkError.initCause(th2);
            throw unsatisfiedLinkError;
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    private static void rethrowWithMoreDetailsIfPossible(String str, NoSuchMethodError noSuchMethodError) {
        if (PlatformDependent.javaVersion() < 7) {
            throw noSuchMethodError;
        }
        throw new LinkageError(n.a.a("Possible multiple incompatible native libraries on the classpath for '", str, "'?"), noSuchMethodError);
    }

    private static boolean shouldShadedLibraryIdBePatched(String str) {
        return TRY_TO_PATCH_SHADED_ID && PlatformDependent.isOsx() && !str.isEmpty();
    }

    private static boolean tryExec(String str) {
        try {
            int iWaitFor = Runtime.getRuntime().exec(str).waitFor();
            if (iWaitFor != 0) {
                logger.debug("Execution of '{}' failed: {}", str, Integer.valueOf(iWaitFor));
                return false;
            }
            logger.debug("Execution of '{}' succeed: {}", str, Integer.valueOf(iWaitFor));
            return true;
        } catch (IOException e10) {
            logger.info("Execution of '{}' failed.", str, e10);
            return false;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        } catch (SecurityException e11) {
            logger.error("Execution of '{}' failed.", str, e11);
            return false;
        }
    }

    public static void tryPatchShadedLibraryIdAndSign(File file, String str) {
        if (!new File("/Library/Developer/CommandLineTools").exists()) {
            logger.debug("Can't patch shaded library id as CommandLineTools are not installed. Consider installing CommandLineTools with 'xcode-select --install'");
            return;
        }
        StringBuilder sbA = e.a.a("install_name_tool -id ", new String(generateUniqueId(str.length()), CharsetUtil.UTF_8), " ");
        sbA.append(file.getAbsolutePath());
        if (tryExec(sbA.toString())) {
            tryExec("codesign -s - " + file.getAbsolutePath());
        }
    }

    private static Class<?> tryToLoadClass(final ClassLoader classLoader, final Class<?> cls) throws ClassNotFoundException {
        try {
            return Class.forName(cls.getName(), false, classLoader);
        } catch (ClassNotFoundException e10) {
            if (classLoader == null) {
                throw e10;
            }
            try {
                final byte[] bArrClassToByteArray = classToByteArray(cls);
                return (Class) AccessController.doPrivileged(new PrivilegedAction<Class<?>>() { // from class: io.netty.util.internal.NativeLibraryLoader.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public Class<?> run() {
                        try {
                            Class cls2 = Integer.TYPE;
                            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2);
                            declaredMethod.setAccessible(true);
                            return (Class) declaredMethod.invoke(classLoader, cls.getName(), bArrClassToByteArray, 0, Integer.valueOf(bArrClassToByteArray.length));
                        } catch (Exception e11) {
                            throw new IllegalStateException("Define class failed!", e11);
                        }
                    }
                });
            } catch (ClassNotFoundException e11) {
                ThrowableUtil.addSuppressed(e11, e10);
                throw e11;
            } catch (Error e12) {
                ThrowableUtil.addSuppressed(e12, e10);
                throw e12;
            } catch (RuntimeException e13) {
                ThrowableUtil.addSuppressed(e13, e10);
                throw e13;
            }
        }
    }
}
