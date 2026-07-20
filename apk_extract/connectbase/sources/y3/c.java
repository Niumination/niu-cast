package y3;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Comparator<File> {
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
