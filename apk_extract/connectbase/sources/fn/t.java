package fn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.e0;
import jq.h0;
import kn.l0;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.l2;
import lm.p2;
import lm.y;
import lm.z0;
import nm.m0;
import nm.n1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1174:1\n26#2:1175\n26#2:1179\n1#3:1176\n1855#4,2:1177\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n221#1:1175\n616#1:1179\n440#1:1177,2\n*E\n"})
public class t extends s {
    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean A0(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f
    @f1(version = "1.7")
    public static final void A1(@os.l Path path, int i10, boolean z10, @os.l jn.l<? super g, l2> lVar) throws IOException {
        l0.p(path, "<this>");
        l0.p(lVar, "builderAction");
        B1(path, G0(lVar), i10, z10);
    }

    @z0
    @os.l
    public static final Void B0(@os.l Path path, @os.l Class<?> cls) {
        l0.p(path, "path");
        l0.p(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + n1.e.f11183c);
    }

    @f
    @f1(version = "1.7")
    public static final void B1(@os.l Path path, @os.l FileVisitor<Path> fileVisitor, int i10, boolean z10) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileVisitor, "visitor");
        Files.walkFileTree(path, z10 ? n1.f(FileVisitOption.FOLLOW_LINKS) : m0.INSTANCE, i10, fileVisitor);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final <V extends FileAttributeView> V C0(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        l0.P();
        V v10 = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v10 != null) {
            return v10;
        }
        l0.P();
        B0(path, FileAttributeView.class);
        throw new y();
    }

    public static /* synthetic */ void C1(Path path, int i10, boolean z10, jn.l lVar, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        A1(path, i10, z10, lVar);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final <V extends FileAttributeView> V D0(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        l0.P();
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    public static /* synthetic */ void D1(Path path, FileVisitor fileVisitor, int i10, boolean z10, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        B1(path, fileVisitor, i10, z10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final long E0(Path path) throws IOException {
        l0.p(path, "<this>");
        return Files.size(path);
    }

    @f
    @f1(version = "1.7")
    @os.l
    public static final gq.m<Path> E1(@os.l Path path, @os.l p... pVarArr) {
        l0.p(path, "<this>");
        l0.p(pVarArr, "options");
        return new n(path, pVarArr);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final FileStore F0(Path path) throws IOException {
        l0.p(path, "<this>");
        FileStore fileStore = Files.getFileStore(path);
        l0.o(fileStore, "getFileStore(...)");
        return fileStore;
    }

    @f
    @f1(version = "1.7")
    @os.l
    public static final FileVisitor<Path> G0(@os.l jn.l<? super g, l2> lVar) {
        l0.p(lVar, "builderAction");
        h hVar = new h();
        lVar.invoke(hVar);
        return hVar.e();
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final void H0(Path path, String str, jn.l<? super Path, l2> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(str, "glob");
        l0.p(lVar, k4.f.f8937e);
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            l0.m(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            if (an.m.a(1, 1, 0)) {
                dn.c.a(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(directoryStreamNewDirectoryStream, th2);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void I0(Path path, String str, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            str = "*";
        }
        l0.p(path, "<this>");
        l0.p(str, "glob");
        l0.p(lVar, k4.f.f8937e);
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            l0.m(directoryStreamNewDirectoryStream);
            Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            if (an.m.a(1, 1, 0)) {
                dn.c.a(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(directoryStreamNewDirectoryStream, th2);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Object J0(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(str, "attribute");
        l0.p(linkOptionArr, "options");
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @os.l
    public static final String K0(@os.l Path path) {
        String string;
        String strO5;
        l0.p(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strO5 = h0.o5(string, n1.e.f11183c, "")) == null) ? "" : strO5;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static /* synthetic */ void L0(Path path) {
    }

    public static final String M0(Path path) {
        l0.p(path, "<this>");
        return O0(path);
    }

    @f
    @an.f
    @f1(version = "1.4")
    @lm.k(level = lm.m.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @a1(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void N0(Path path) {
    }

    @os.l
    public static final String O0(@os.l Path path) {
        l0.p(path, "<this>");
        String separator = path.getFileSystem().getSeparator();
        if (l0.g(separator, "/")) {
            return path.toString();
        }
        String string = path.toString();
        l0.m(separator);
        return e0.i2(string, separator, "/", false, 4, null);
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static /* synthetic */ void P0(Path path) {
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final FileTime Q0(Path path, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        l0.o(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    @os.l
    public static final String R0(@os.l Path path) {
        l0.p(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? "" : string;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static /* synthetic */ void S0(Path path) {
    }

    @os.l
    public static final String T0(@os.l Path path) {
        String string;
        String strZ5;
        l0.p(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strZ5 = h0.z5(string, ".", null, 2, null)) == null) ? "" : strZ5;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static /* synthetic */ void U0(Path path) {
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final UserPrincipal V0(Path path, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    public static final String W0(Path path) {
        l0.p(path, "<this>");
        return path.toString();
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static /* synthetic */ void X0(Path path) {
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Set<PosixFilePermission> Y0(Path path, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        l0.o(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean Z0(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean a1(Path path) {
        l0.p(path, "<this>");
        return Files.isExecutable(path);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path b0(String str) {
        l0.p(str, "path");
        Path path = Paths.get(str, new String[0]);
        l0.o(path, "get(...)");
        return path;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean b1(Path path) throws IOException {
        l0.p(path, "<this>");
        return Files.isHidden(path);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path c0(String str, String... strArr) {
        l0.p(str, "base");
        l0.p(strArr, "subpaths");
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        l0.o(path, "get(...)");
        return path;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean c1(Path path) {
        l0.p(path, "<this>");
        return Files.isReadable(path);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path d0(Path path) {
        l0.p(path, "<this>");
        Path absolutePath = path.toAbsolutePath();
        l0.o(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean d1(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final String e0(Path path) {
        l0.p(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean e1(Path path, Path path2) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, "other");
        return Files.isSameFile(path, path2);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path f0(Path path, Path path2, boolean z10) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathCopy, "copy(...)");
        return pathCopy;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean f1(Path path) {
        l0.p(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path g0(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        l0.p(copyOptionArr, "options");
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathCopy, "copy(...)");
        return pathCopy;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean g1(Path path) {
        l0.p(path, "<this>");
        return Files.isWritable(path);
    }

    public static /* synthetic */ Path h0(Path path, Path path2, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathCopy, "copy(...)");
        return pathCopy;
    }

    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    @os.l
    public static final List<Path> h1(@os.l Path path, @os.l String str) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(str, "glob");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            l0.m(directoryStreamNewDirectoryStream);
            List<Path> listV5 = nm.h0.V5(directoryStreamNewDirectoryStream);
            dn.c.a(directoryStreamNewDirectoryStream, null);
            return listV5;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(directoryStreamNewDirectoryStream, th2);
                throw th3;
            }
        }
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path i0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateDirectories, "createDirectories(...)");
        return pathCreateDirectories;
    }

    public static /* synthetic */ List i1(Path path, String str, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = "*";
        }
        return h1(path, str);
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path j0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateDirectory, "createDirectory(...)");
        return pathCreateDirectory;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path j1(Path path, Path path2, boolean z10) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathMove, "move(...)");
        return pathMove;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path k0(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateFile, "createFile(...)");
        return pathCreateFile;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path k1(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        l0.p(copyOptionArr, "options");
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathMove, "move(...)");
        return pathMove;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path l0(Path path, Path path2) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        Path pathCreateLink = Files.createLink(path, path2);
        l0.o(pathCreateLink, "createLink(...)");
        return pathCreateLink;
    }

    public static /* synthetic */ Path l1(Path path, Path path2, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        l0.o(pathMove, "move(...)");
        return pathMove;
    }

    @f1(version = "1.9")
    @os.l
    public static final Path m0(@os.l Path path, @os.l FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileAttributeArr, "attributes");
        Path parent = path.getParent();
        if (parent != null && !Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                FileAttribute[] fileAttributeArr2 = (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length);
                l0.o(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(fileAttributeArr2, fileAttributeArr2.length)), "createDirectories(...)");
            } catch (FileAlreadyExistsException e10) {
                if (!Files.isDirectory(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw e10;
                }
            }
        }
        return path;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean m1(Path path, LinkOption... linkOptionArr) {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path n0(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateSymbolicLink, "createSymbolicLink(...)");
        return pathCreateSymbolicLink;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final <A extends BasicFileAttributes> A n1(Path path, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(linkOptionArr, "options");
        l0.P();
        A a10 = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        l0.o(a10, "readAttributes(...)");
        return a10;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path o0(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Map<String, Object> o1(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(str, "attributes");
        l0.p(linkOptionArr, "options");
        Map<String, Object> attributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        l0.o(attributes, "readAttributes(...)");
        return attributes;
    }

    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    @os.l
    public static final Path p0(@os.m Path path, @os.m String str, @os.l FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(fileAttributeArr, "attributes");
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            l0.o(pathCreateTempDirectory, "createTempDirectory(...)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempDirectory2, "createTempDirectory(...)");
        return pathCreateTempDirectory2;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path p1(Path path) throws IOException {
        l0.p(path, "<this>");
        Path symbolicLink = Files.readSymbolicLink(path);
        l0.o(symbolicLink, "readSymbolicLink(...)");
        return symbolicLink;
    }

    public static /* synthetic */ Path q0(String str, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = null;
        }
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempDirectory, "createTempDirectory(...)");
        return pathCreateTempDirectory;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    @os.l
    public static final Path q1(@os.l Path path, @os.l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "base");
        try {
            return m.f6148a.a(path, path2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(e10.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e10);
        }
    }

    public static /* synthetic */ Path r0(Path path, String str, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return p0(path, str, fileAttributeArr);
    }

    @os.m
    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    public static final Path r1(@os.l Path path, @os.l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "base");
        try {
            return m.f6148a.a(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path s0(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    @f1(version = "1.5")
    @p2(markerClass = {f.class})
    @os.l
    public static final Path s1(@os.l Path path, @os.l Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "base");
        Path pathR1 = r1(path, path2);
        return pathR1 == null ? path : pathR1;
    }

    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    @os.l
    public static final Path t0(@os.m Path path, @os.m String str, @os.m String str2, @os.l FileAttribute<?>... fileAttributeArr) throws IOException {
        l0.p(fileAttributeArr, "attributes");
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            l0.o(pathCreateTempFile, "createTempFile(...)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempFile2, "createTempFile(...)");
        return pathCreateTempFile2;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path t1(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        l0.p(path, "<this>");
        l0.p(str, "attribute");
        l0.p(linkOptionArr, "options");
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        l0.o(attribute, "setAttribute(...)");
        return attribute;
    }

    public static /* synthetic */ Path u0(String str, String str2, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        l0.p(fileAttributeArr, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        l0.o(pathCreateTempFile, "createTempFile(...)");
        return pathCreateTempFile;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path u1(Path path, FileTime fileTime) throws IOException {
        l0.p(path, "<this>");
        l0.p(fileTime, "value");
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        l0.o(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    public static /* synthetic */ Path v0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return t0(path, str, str2, fileAttributeArr);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path v1(Path path, UserPrincipal userPrincipal) throws IOException {
        l0.p(path, "<this>");
        l0.p(userPrincipal, "value");
        Path owner = Files.setOwner(path, userPrincipal);
        l0.o(owner, "setOwner(...)");
        return owner;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final void w0(Path path) throws IOException {
        l0.p(path, "<this>");
        Files.delete(path);
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final Path w1(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        l0.p(path, "<this>");
        l0.p(set, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        l0.o(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final boolean x0(Path path) throws IOException {
        l0.p(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path x1(URI uri) {
        l0.p(uri, "<this>");
        Path path = Paths.get(uri);
        l0.o(path, "get(...)");
        return path;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path y0(Path path, String str) {
        l0.p(path, "<this>");
        l0.p(str, "other");
        Path pathResolve = path.resolve(str);
        l0.o(pathResolve, "resolve(...)");
        return pathResolve;
    }

    @an.f
    @p2(markerClass = {f.class})
    @f1(version = "1.5")
    public static final <T> T y1(Path path, String str, jn.l<? super gq.m<? extends Path>, ? extends T> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        l0.p(str, "glob");
        l0.p(lVar, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            l0.m(directoryStreamNewDirectoryStream);
            T tInvoke = lVar.invoke(nm.h0.A1(directoryStreamNewDirectoryStream));
            if (an.m.a(1, 1, 0)) {
                dn.c.a(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
            return tInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(directoryStreamNewDirectoryStream, th2);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {f.class})
    public static final Path z0(Path path, Path path2) {
        l0.p(path, "<this>");
        l0.p(path2, "other");
        Path pathResolve = path.resolve(path2);
        l0.o(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public static Object z1(Path path, String str, jn.l lVar, int i10, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i10 & 1) != 0) {
            str = "*";
        }
        l0.p(path, "<this>");
        l0.p(str, "glob");
        l0.p(lVar, "block");
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            l0.m(directoryStreamNewDirectoryStream);
            Object objInvoke = lVar.invoke(nm.h0.A1(directoryStreamNewDirectoryStream));
            if (an.m.a(1, 1, 0)) {
                dn.c.a(directoryStreamNewDirectoryStream, null);
            } else if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
            }
            return objInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    dn.c.a(directoryStreamNewDirectoryStream, th2);
                } else if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }
}
