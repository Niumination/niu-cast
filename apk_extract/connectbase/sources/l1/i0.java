package l1;

import c1.t0;
import f1.i3;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f9587a = c();

    public static final class b extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9588b = 10000;

        public b() {
        }

        @Override // l1.i0
        public File a() {
            File file = new File(c1.n0.JAVA_IO_TMPDIR.value());
            String str = System.currentTimeMillis() + "-";
            for (int i10 = 0; i10 < 10000; i10++) {
                File file2 = new File(file, str + i10);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + "9999)");
        }

        @Override // l1.i0
        public File b(String prefix) throws IOException {
            return File.createTempFile(prefix, null, null);
        }

        public b(a aVar) {
        }
    }

    @v
    public static final class c extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f9589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f9590c;

        public class a implements FileAttribute<i3<AclEntry>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i3 f9591a;

            public a(final i3 val$acl) {
                this.f9591a = val$acl;
            }

            @Override // java.nio.file.attribute.FileAttribute
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i3<AclEntry> value() {
                return this.f9591a;
            }

            @Override // java.nio.file.attribute.FileAttribute
            public String name() {
                return "acl:acl";
            }
        }

        @v
        public interface b {
            FileAttribute<?> get() throws IOException;
        }

        static {
            Set<String> setSupportedFileAttributeViews = FileSystems.getDefault().supportedFileAttributeViews();
            if (setSupportedFileAttributeViews.contains("posix")) {
                f9589b = new j0();
                f9590c = new k0();
            } else if (setSupportedFileAttributeViews.contains("acl")) {
                b bVarQ = q();
                f9590c = bVarQ;
                f9589b = bVarQ;
            } else {
                l0 l0Var = new l0();
                f9590c = l0Var;
                f9589b = l0Var;
            }
        }

        public c() {
        }

        public static /* synthetic */ FileAttribute g(FileAttribute fileAttribute) {
            return fileAttribute;
        }

        public static String k() {
            String strValue = c1.n0.USER_NAME.value();
            Objects.requireNonNull(strValue);
            try {
                Class<?> cls = Class.forName("java.lang.ProcessHandle");
                Class<?> cls2 = Class.forName("java.lang.ProcessHandle$Info");
                Class<?> cls3 = Class.forName("java.util.Optional");
                Method method = cls.getMethod("current", null);
                Method method2 = cls.getMethod("info", null);
                Object objInvoke = cls3.getMethod("orElse", Object.class).invoke(cls2.getMethod("user", null).invoke(method2.invoke(method.invoke(null, null), null), null), strValue);
                Objects.requireNonNull(objInvoke);
                return (String) objInvoke;
            } catch (ClassNotFoundException unused) {
                return strValue;
            } catch (IllegalAccessException | NoSuchMethodException unused2) {
                return strValue;
            } catch (InvocationTargetException e10) {
                t0.w(e10.getCause());
                return strValue;
            }
        }

        public static /* synthetic */ FileAttribute l() throws IOException {
            return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));
        }

        public static /* synthetic */ FileAttribute m() throws IOException {
            return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
        }

        public static /* synthetic */ FileAttribute n() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        public static /* synthetic */ FileAttribute o(FileAttribute fileAttribute) throws IOException {
            return fileAttribute;
        }

        public static /* synthetic */ FileAttribute p(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        public static b q() {
            try {
                final a aVar = new a(i3.of(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(k())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT).build()));
                return new b() { // from class: l1.m0
                    @Override // l1.i0.c.b
                    public final FileAttribute get() {
                        return i0.c.g(aVar);
                    }
                };
            } catch (IOException e10) {
                return new b() { // from class: l1.n0
                    @Override // l1.i0.c.b
                    public final FileAttribute get() {
                        return i0.c.p(e10);
                    }
                };
            }
        }

        @Override // l1.i0
        public File a() {
            try {
                return Files.createTempDirectory(Paths.get(c1.n0.JAVA_IO_TMPDIR.value(), new String[0]), null, f9590c.get()).toFile();
            } catch (IOException e10) {
                throw new IllegalStateException("Failed to create directory", e10);
            }
        }

        @Override // l1.i0
        public File b(String prefix) throws IOException {
            return Files.createTempFile(Paths.get(c1.n0.JAVA_IO_TMPDIR.value(), new String[0]), prefix, null, f9589b.get()).toFile();
        }

        public c(a aVar) {
        }
    }

    public static final class d extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f9592b = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        public d() {
        }

        @Override // l1.i0
        public File a() {
            throw new IllegalStateException(f9592b);
        }

        @Override // l1.i0
        public File b(String prefix) throws IOException {
            throw new IOException(f9592b);
        }

        public d(a aVar) {
        }
    }

    public i0() {
    }

    public static i0 c() {
        try {
            try {
                return new c();
            } catch (ClassNotFoundException unused) {
                return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue() ? new d() : new b();
            }
        } catch (ClassNotFoundException unused2) {
            return new d();
        } catch (IllegalAccessException unused3) {
            return new d();
        } catch (NoSuchFieldException unused4) {
            return new d();
        }
    }

    @b1.e
    @v
    public static void d() throws IOException {
        c.q().get();
    }

    public abstract File a();

    public abstract File b(String prefix) throws IOException;

    public i0(a aVar) {
    }
}
