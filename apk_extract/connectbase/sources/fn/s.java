package fn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kn.h0;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.s1;
import lm.f1;
import lm.i0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,430:1\n346#1,2:434\n354#1:436\n354#1:437\n348#1,4:438\n346#1,2:442\n354#1:444\n348#1,4:445\n354#1:449\n346#1,6:450\n346#1,2:456\n354#1:458\n348#1,4:459\n1#2:431\n1855#3,2:432\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n362#1:434,2\n371#1:436\n374#1:437\n362#1:438,4\n382#1:442,2\n383#1:444\n382#1:445,4\n394#1:449\n402#1:450,6\n420#1:456,2\n421#1:458\n420#1:459,4\n284#1:432,2\n*E\n"})
public class s extends r {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6156b;

        static {
            int[] iArr = new int[fn.b.values().length];
            try {
                iArr[fn.b.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[fn.b.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[fn.b.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6155a = iArr;
            int[] iArr2 = new int[k.values().length];
            try {
                iArr2[k.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[k.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f6156b = iArr2;
        }
    }

    public static final class b extends n0 implements jn.q {
        public static final b INSTANCE = new b();

        public b() {
            super(3);
        }

        @Override // jn.q
        @os.l
        public final Void invoke(@os.l Path path, @os.l Path path2, @os.l Exception exc) throws Exception {
            l0.p(path, "<anonymous parameter 0>");
            l0.p(path2, "<anonymous parameter 1>");
            l0.p(exc, "exception");
            throw exc;
        }
    }

    public static final class c extends n0 implements jn.q<fn.a, Path, Path, fn.b> {
        final /* synthetic */ boolean $followLinks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10) {
            super(3);
            this.$followLinks = z10;
        }

        @Override // jn.q
        @os.l
        public final fn.b invoke(@os.l fn.a aVar, @os.l Path path, @os.l Path path2) throws IllegalAccessException, IOException, InvocationTargetException {
            l0.p(aVar, "$this$copyToRecursively");
            l0.p(path, "src");
            l0.p(path2, "dst");
            LinkOption[] linkOptionArrA = j.f6137a.a(this.$followLinks);
            boolean zIsDirectory = Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
            LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
            if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !zIsDirectory) {
                if (zIsDirectory) {
                    s.R(path2);
                }
                s1 s1Var = new s1(2);
                s1Var.b(linkOptionArrA);
                s1Var.a(StandardCopyOption.REPLACE_EXISTING);
                CopyOption[] copyOptionArr = (CopyOption[]) s1Var.f9356a.toArray(new CopyOption[s1Var.f9356a.size()]);
                l0.o(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
            }
            return fn.b.CONTINUE;
        }
    }

    public static final class d extends n0 implements jn.q {
        public static final d INSTANCE = new d();

        public d() {
            super(3);
        }

        @Override // jn.q
        @os.l
        public final Void invoke(@os.l Path path, @os.l Path path2, @os.l Exception exc) throws Exception {
            l0.p(path, "<anonymous parameter 0>");
            l0.p(path2, "<anonymous parameter 1>");
            l0.p(exc, "exception");
            throw exc;
        }
    }

    public static final class e extends n0 implements jn.q<fn.a, Path, Path, fn.b> {
        final /* synthetic */ boolean $followLinks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z10) {
            super(3);
            this.$followLinks = z10;
        }

        @Override // jn.q
        @os.l
        public final fn.b invoke(@os.l fn.a aVar, @os.l Path path, @os.l Path path2) {
            l0.p(aVar, "$this$null");
            l0.p(path, "src");
            l0.p(path2, "dst");
            return aVar.a(path, path2, this.$followLinks);
        }
    }

    public static final class f extends n0 implements jn.l<g, l2> {
        final /* synthetic */ jn.q<fn.a, Path, Path, fn.b> $copyAction;
        final /* synthetic */ jn.q<Path, Path, Exception, k> $onError;
        final /* synthetic */ Path $target;
        final /* synthetic */ Path $this_copyToRecursively;

        public /* synthetic */ class a extends h0 implements jn.p<Path, BasicFileAttributes, FileVisitResult> {
            final /* synthetic */ jn.q<fn.a, Path, Path, fn.b> $copyAction;
            final /* synthetic */ jn.q<Path, Path, Exception, k> $onError;
            final /* synthetic */ Path $target;
            final /* synthetic */ Path $this_copyToRecursively;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(jn.q<? super fn.a, ? super Path, ? super Path, ? extends fn.b> qVar, Path path, Path path2, jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar2) {
                super(2, l0.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                this.$copyAction = qVar;
                this.$this_copyToRecursively = path;
                this.$target = path2;
                this.$onError = qVar2;
            }

            @Override // jn.p
            @os.l
            public final FileVisitResult invoke(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) {
                l0.p(path, "p0");
                l0.p(basicFileAttributes, "p1");
                return s.M(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, path, basicFileAttributes);
            }
        }

        public /* synthetic */ class b extends h0 implements jn.p<Path, BasicFileAttributes, FileVisitResult> {
            final /* synthetic */ jn.q<fn.a, Path, Path, fn.b> $copyAction;
            final /* synthetic */ jn.q<Path, Path, Exception, k> $onError;
            final /* synthetic */ Path $target;
            final /* synthetic */ Path $this_copyToRecursively;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(jn.q<? super fn.a, ? super Path, ? super Path, ? extends fn.b> qVar, Path path, Path path2, jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar2) {
                super(2, l0.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                this.$copyAction = qVar;
                this.$this_copyToRecursively = path;
                this.$target = path2;
                this.$onError = qVar2;
            }

            @Override // jn.p
            @os.l
            public final FileVisitResult invoke(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) {
                l0.p(path, "p0");
                l0.p(basicFileAttributes, "p1");
                return s.M(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, path, basicFileAttributes);
            }
        }

        public /* synthetic */ class c extends h0 implements jn.p<Path, Exception, FileVisitResult> {
            final /* synthetic */ jn.q<Path, Path, Exception, k> $onError;
            final /* synthetic */ Path $target;
            final /* synthetic */ Path $this_copyToRecursively;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar, Path path, Path path2) {
                super(2, l0.a.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
                this.$onError = qVar;
                this.$this_copyToRecursively = path;
                this.$target = path2;
            }

            @Override // jn.p
            @os.l
            public final FileVisitResult invoke(@os.l Path path, @os.l Exception exc) {
                l0.p(path, "p0");
                l0.p(exc, "p1");
                return s.Q(this.$onError, this.$this_copyToRecursively, this.$target, path, exc);
            }
        }

        public static final class d extends n0 implements jn.p<Path, IOException, FileVisitResult> {
            final /* synthetic */ jn.q<Path, Path, Exception, k> $onError;
            final /* synthetic */ Path $target;
            final /* synthetic */ Path $this_copyToRecursively;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar, Path path, Path path2) {
                super(2);
                this.$onError = qVar;
                this.$this_copyToRecursively = path;
                this.$target = path2;
            }

            @Override // jn.p
            @os.l
            public final FileVisitResult invoke(@os.l Path path, @os.m IOException iOException) {
                l0.p(path, "directory");
                return iOException == null ? FileVisitResult.CONTINUE : s.Q(this.$onError, this.$this_copyToRecursively, this.$target, path, iOException);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(jn.q<? super fn.a, ? super Path, ? super Path, ? extends fn.b> qVar, Path path, Path path2, jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar2) {
            super(1);
            this.$copyAction = qVar;
            this.$this_copyToRecursively = path;
            this.$target = path2;
            this.$onError = qVar2;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(g gVar) {
            invoke2(gVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l g gVar) {
            l0.p(gVar, "$this$visitFileTree");
            gVar.a(new a(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
            gVar.d(new b(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
            gVar.c(new c(this.$onError, this.$this_copyToRecursively, this.$target));
            gVar.b(new d(this.$onError, this.$this_copyToRecursively, this.$target));
        }
    }

    public static final void J(fn.e eVar, jn.a<l2> aVar) {
        try {
            aVar.invoke();
        } catch (Exception e10) {
            eVar.a(e10);
        }
    }

    @fn.f
    @f1(version = "1.8")
    @os.l
    public static final Path K(@os.l Path path, @os.l Path path2, @os.l jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar, boolean z10, @os.l jn.q<? super fn.a, ? super Path, ? super Path, ? extends fn.b> qVar2) throws IOException {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        l0.p(qVar, "onError");
        l0.p(qVar2, "copyAction");
        LinkOption[] linkOptionArrA = j.f6137a.a(z10);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
        if (!Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException(path.toString(), path2.toString(), "The source file doesn't exist.");
        }
        boolean zStartsWith = false;
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z10 || !Files.isSymbolicLink(path))) {
            boolean z11 = Files.exists(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(path2);
            if (!z11 || !Files.isSameFile(path, path2)) {
                if (l0.g(path.getFileSystem(), path2.getFileSystem())) {
                    if (z11) {
                        zStartsWith = path2.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                    } else {
                        Path parent = path2.getParent();
                        if (parent != null && Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && parent.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                            zStartsWith = true;
                        }
                    }
                }
                if (zStartsWith) {
                    throw new FileSystemException(path.toString(), path2.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        t.C1(path, 0, z10, new f(qVar2, path, path2, qVar), 1, null);
        return path2;
    }

    @fn.f
    @f1(version = "1.8")
    @os.l
    public static final Path L(@os.l Path path, @os.l Path path2, @os.l jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar, boolean z10, boolean z11) {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        l0.p(qVar, "onError");
        return z11 ? K(path, path2, qVar, z10, new c(z10)) : N(path, path2, qVar, z10, null, 8, null);
    }

    public static final FileVisitResult M(jn.q<? super fn.a, ? super Path, ? super Path, ? extends fn.b> qVar, Path path, Path path2, jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar2, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return Y(qVar.invoke(fn.c.f6120a, path3, P(path, path2, path3)));
        } catch (Exception e10) {
            return Q(qVar2, path, path2, path3, e10);
        }
    }

    public static /* synthetic */ Path N(Path path, Path path2, jn.q qVar, boolean z10, jn.q qVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            qVar = d.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            qVar2 = new e(z10);
        }
        return K(path, path2, qVar, z10, qVar2);
    }

    public static /* synthetic */ Path O(Path path, Path path2, jn.q qVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            qVar = b.INSTANCE;
        }
        return L(path, path2, qVar, z10, z11);
    }

    public static final Path P(Path path, Path path2, Path path3) {
        Path pathResolve = path2.resolve(t.q1(path3, path).toString());
        l0.o(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public static final FileVisitResult Q(jn.q<? super Path, ? super Path, ? super Exception, ? extends k> qVar, Path path, Path path2, Path path3, Exception exc) {
        return Z(qVar.invoke(path3, P(path, path2, path3), exc));
    }

    @fn.f
    @f1(version = "1.8")
    public static final void R(@os.l Path path) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(path, "<this>");
        List<Exception> listS = S(path);
        if (listS.isEmpty()) {
            return;
        }
        FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> it = listS.iterator();
        while (it.hasNext()) {
            lm.p.a(fileSystemException, (Exception) it.next());
        }
        throw fileSystemException;
    }

    public static final List<Exception> S(Path path) throws IllegalAccessException, IOException, InvocationTargetException {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        boolean z10 = false;
        boolean z11 = true;
        fn.e eVar = new fn.e(0, 1, null);
        Path parent = path.getParent();
        if (parent != null) {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStreamNewDirectoryStream = null;
            }
            if (directoryStreamNewDirectoryStream != null) {
                try {
                    if (directoryStreamNewDirectoryStream instanceof SecureDirectoryStream) {
                        eVar.f6127d = parent;
                        Path fileName = path.getFileName();
                        l0.o(fileName, "getFileName(...)");
                        U((SecureDirectoryStream) directoryStreamNewDirectoryStream, fileName, eVar);
                    } else {
                        z10 = true;
                    }
                    l2 l2Var = l2.f10208a;
                    dn.c.a(directoryStreamNewDirectoryStream, null);
                    z11 = z10;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        dn.c.a(directoryStreamNewDirectoryStream, th2);
                        throw th3;
                    }
                }
            }
        }
        if (z11) {
            W(path, eVar);
        }
        return eVar.f6126c;
    }

    public static final void T(SecureDirectoryStream<Path> secureDirectoryStream, Path path, fn.e eVar) {
        SecureDirectoryStream<Path> secureDirectoryStreamNewDirectoryStream;
        try {
            try {
                secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e10) {
                eVar.a(e10);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStreamNewDirectoryStream = null;
        }
        if (secureDirectoryStreamNewDirectoryStream != null) {
            try {
                Iterator<Path> it = secureDirectoryStreamNewDirectoryStream.iterator();
                while (it.hasNext()) {
                    Path fileName = it.next().getFileName();
                    l0.o(fileName, "getFileName(...)");
                    U(secureDirectoryStreamNewDirectoryStream, fileName, eVar);
                }
                l2 l2Var = l2.f10208a;
                dn.c.a(secureDirectoryStreamNewDirectoryStream, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    dn.c.a(secureDirectoryStreamNewDirectoryStream, th2);
                    throw th3;
                }
            }
        }
    }

    public static final void U(SecureDirectoryStream<Path> secureDirectoryStream, Path path, fn.e eVar) {
        eVar.b(path);
        try {
            try {
                if (X(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                    int i10 = eVar.f6125b;
                    T(secureDirectoryStream, path, eVar);
                    if (i10 == eVar.f6125b) {
                        secureDirectoryStream.deleteDirectory(path);
                        l2 l2Var = l2.f10208a;
                    }
                } else {
                    secureDirectoryStream.deleteFile(path);
                    l2 l2Var2 = l2.f10208a;
                }
            } catch (NoSuchFileException unused) {
            }
        } catch (Exception e10) {
            eVar.a(e10);
        }
        eVar.c(path);
    }

    public static final void V(Path path, fn.e eVar) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        try {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            } catch (Exception e10) {
                eVar.a(e10);
                return;
            }
        } catch (NoSuchFileException unused) {
            directoryStreamNewDirectoryStream = null;
        }
        if (directoryStreamNewDirectoryStream != null) {
            try {
                for (Path path2 : directoryStreamNewDirectoryStream) {
                    l0.m(path2);
                    W(path2, eVar);
                }
                l2 l2Var = l2.f10208a;
                dn.c.a(directoryStreamNewDirectoryStream, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    dn.c.a(directoryStreamNewDirectoryStream, th2);
                    throw th3;
                }
            }
        }
    }

    public static final void W(Path path, fn.e eVar) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int i10 = eVar.f6125b;
                V(path, eVar);
                if (i10 == eVar.f6125b) {
                    Files.deleteIfExists(path);
                }
            } else {
                Files.deleteIfExists(path);
            }
        } catch (Exception e10) {
            eVar.a(e10);
        }
    }

    public static final boolean X(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean boolValueOf;
        try {
            boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @fn.f
    public static final FileVisitResult Y(fn.b bVar) {
        int i10 = a.f6155a[bVar.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i10 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new i0();
    }

    @fn.f
    public static final FileVisitResult Z(k kVar) {
        int i10 = a.f6156b[kVar.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new i0();
    }

    public static final <R> R a0(jn.a<? extends R> aVar) {
        try {
            return aVar.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }
}
