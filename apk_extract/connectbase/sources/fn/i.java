package fn;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final jn.p<Path, BasicFileAttributes, FileVisitResult> f6133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final jn.p<Path, BasicFileAttributes, FileVisitResult> f6134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final jn.p<Path, IOException, FileVisitResult> f6135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final jn.p<Path, IOException, FileVisitResult> f6136d;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@os.m jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar, @os.m jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar2, @os.m jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar3, @os.m jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar4) {
        this.f6133a = pVar;
        this.f6134b = pVar2;
        this.f6135c = pVar3;
        this.f6136d = pVar4;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult postVisitDirectory(@os.l Path path, @os.m IOException iOException) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        l0.p(path, "dir");
        jn.p<Path, IOException, FileVisitResult> pVar = this.f6136d;
        if (pVar != null && (fileVisitResultInvoke = pVar.invoke(path, iOException)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(path, iOException);
        l0.o(fileVisitResultPostVisitDirectory, "postVisitDirectory(...)");
        return fileVisitResultPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        l0.p(path, "dir");
        l0.p(basicFileAttributes, "attrs");
        jn.p<Path, BasicFileAttributes, FileVisitResult> pVar = this.f6133a;
        if (pVar != null && (fileVisitResultInvoke = pVar.invoke(path, basicFileAttributes)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        l0.o(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        l0.p(path, "file");
        l0.p(basicFileAttributes, "attrs");
        jn.p<Path, BasicFileAttributes, FileVisitResult> pVar = this.f6134b;
        if (pVar != null && (fileVisitResultInvoke = pVar.invoke(path, basicFileAttributes)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(path, basicFileAttributes);
        l0.o(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFileFailed(@os.l Path path, @os.l IOException iOException) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        l0.p(path, "file");
        l0.p(iOException, "exc");
        jn.p<Path, IOException, FileVisitResult> pVar = this.f6135c;
        if (pVar != null && (fileVisitResultInvoke = pVar.invoke(path, iOException)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(path, iOException);
        l0.o(fileVisitResultVisitFileFailed, "visitFileFailed(...)");
        return fileVisitResultVisitFileFailed;
    }
}
