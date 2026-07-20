package d4;

import com.transsion.backup.model.BackupMessage;
import k4.j;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @l
    public static final String a(@l BackupMessage<?> backupMessage) {
        l0.p(backupMessage, "<this>");
        String strG = j.a.f8962a.g(backupMessage);
        l0.o(strG, "toJson(...)");
        return strG;
    }
}
