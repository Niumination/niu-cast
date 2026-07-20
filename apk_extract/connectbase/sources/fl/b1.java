package fl;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {
    @os.l
    public static final File a(@os.l File file, @os.l Path path) {
        kn.l0.p(file, "<this>");
        kn.l0.p(path, "relativePath");
        Path pathE = e(path);
        if (!pathE.startsWith("..")) {
            if (pathE.isAbsolute()) {
                throw new IllegalStateException(kn.l0.C("Bad relative path ", path).toString());
            }
            return new File(file, pathE.toString());
        }
        throw new InvalidPathException(path.toString(), "Relative path " + path + " beginning with .. is invalid");
    }

    @os.l
    public static final File b(@os.l Path path, @os.l Path path2) {
        kn.l0.p(path, "<this>");
        kn.l0.p(path2, "relativePath");
        Path pathE = e(path2);
        if (pathE.startsWith("..")) {
            throw new InvalidPathException(path2.toString(), "Relative path " + path2 + " beginning with .. is invalid");
        }
        if (pathE.isAbsolute()) {
            throw new IllegalStateException(kn.l0.C("Bad relative path ", path2).toString());
        }
        File file = path.resolve(pathE).toFile();
        kn.l0.o(file, "resolve(normalized).toFile()");
        return file;
    }

    public static final Path c(Path path) {
        Iterator it = path.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = it.next();
            if (i10 < 0) {
                nm.y.Z();
            }
            if (!kn.l0.g(((Path) next).toString(), "..")) {
                break;
            }
            i10++;
        }
        if (i10 == 0) {
            return path;
        }
        Path pathSubpath = path.subpath(i10, path.getNameCount());
        kn.l0.o(pathSubpath, "subpath(startIndex, nameCount)");
        return pathSubpath;
    }

    @os.l
    public static final String d(@os.l Path path) {
        kn.l0.p(path, "<this>");
        return jq.h0.r5(path.getFileName().toString(), ".", null, 2, null);
    }

    @os.l
    public static final Path e(@os.l Path path) {
        Path pathRelativize;
        Path pathNormalize;
        kn.l0.p(path, "<this>");
        Path root = path.getRoot();
        Path pathC = null;
        if (root != null && (pathRelativize = root.relativize(path)) != null && (pathNormalize = pathRelativize.normalize()) != null) {
            pathC = c(pathNormalize);
        }
        if (pathC != null) {
            return pathC;
        }
        Path pathNormalize2 = path.normalize();
        kn.l0.o(pathNormalize2, "normalize()");
        return c(pathNormalize2);
    }
}
