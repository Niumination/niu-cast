package fn;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kn.r1;
import nm.m0;
import nm.n1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final j f6137a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final LinkOption[] f6138b = {LinkOption.NOFOLLOW_LINKS};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final LinkOption[] f6139c = new LinkOption[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Set<FileVisitOption> f6140d = m0.INSTANCE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final Set<FileVisitOption> f6141e = n1.f(FileVisitOption.FOLLOW_LINKS);

    @os.l
    public final LinkOption[] a(boolean z10) {
        return z10 ? f6139c : f6138b;
    }

    @os.l
    public final Set<FileVisitOption> b(boolean z10) {
        return z10 ? f6141e : f6140d;
    }
}
