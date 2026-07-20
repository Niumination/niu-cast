package fn;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f
@f1(version = "1.7")
public interface g {
    void a(@os.l jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);

    void b(@os.l jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);

    void c(@os.l jn.p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);

    void d(@os.l jn.p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);
}
