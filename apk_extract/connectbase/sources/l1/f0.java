package l1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class f0 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f9553a;

    public f0(String patternStr) {
        this(Pattern.compile(patternStr));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File dir, String fileName) {
        return this.f9553a.matcher(fileName).matches();
    }

    public f0(Pattern pattern) {
        pattern.getClass();
        this.f9553a = pattern;
    }
}
