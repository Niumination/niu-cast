package y3;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Comparator<File> {
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        File file3 = file;
        File file4 = file2;
        if (file3.lastModified() < file4.lastModified()) {
            return -1;
        }
        return file3.lastModified() == file4.lastModified() ? 0 : 1;
    }
}
