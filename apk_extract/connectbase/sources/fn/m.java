package fn;

import java.nio.file.Path;
import java.nio.file.Paths;
import jq.e0;
import jq.j0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m f6148a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Path f6149b = Paths.get("", new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f6150c = Paths.get("..", new String[0]);

    @os.l
    public final Path a(@os.l Path path, @os.l Path path2) {
        l0.p(path, "path");
        l0.p(path2, "base");
        Path pathNormalize = path2.normalize();
        Path pathNormalize2 = path.normalize();
        Path pathRelativize = pathNormalize.relativize(pathNormalize2);
        int iMin = Math.min(pathNormalize.getNameCount(), pathNormalize2.getNameCount());
        for (int i10 = 0; i10 < iMin; i10++) {
            Path name = pathNormalize.getName(i10);
            Path path3 = f6150c;
            if (!l0.g(name, path3)) {
                break;
            }
            if (!l0.g(pathNormalize2.getName(i10), path3)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (l0.g(pathNormalize2, pathNormalize) || !l0.g(pathNormalize, f6149b)) {
            String string = pathRelativize.toString();
            String separator = pathRelativize.getFileSystem().getSeparator();
            l0.o(separator, "getSeparator(...)");
            pathNormalize2 = e0.J1(string, separator, false, 2, null) ? pathRelativize.getFileSystem().getPath(j0.A6(string, pathRelativize.getFileSystem().getSeparator().length()), new String[0]) : pathRelativize;
        }
        l0.m(pathNormalize2);
        return pathNormalize2;
    }
}
