package fn;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
public final class d extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public l f6122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public nm.k<l> f6123c = new nm.k<>();

    public d(boolean z10) {
        this.f6121a = z10;
    }

    public final boolean a() {
        return this.f6121a;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) throws IOException {
        l0.p(path, "dir");
        l0.p(basicFileAttributes, "attrs");
        this.f6123c.addLast(new l(path, basicFileAttributes.fileKey(), this.f6122b));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        l0.o(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @os.l
    public final List<l> c(@os.l l lVar) throws IOException {
        l0.p(lVar, "directoryNode");
        this.f6122b = lVar;
        Files.walkFileTree(lVar.f6144a, j.f6137a.b(this.f6121a), 1, this);
        this.f6123c.removeFirst();
        nm.k<l> kVar = this.f6123c;
        this.f6123c = new nm.k<>();
        return kVar;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) throws IOException {
        l0.p(path, "file");
        l0.p(basicFileAttributes, "attrs");
        this.f6123c.addLast(new l(path, null, this.f6122b));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(path, basicFileAttributes);
        l0.o(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }
}
