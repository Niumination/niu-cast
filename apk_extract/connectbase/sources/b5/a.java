package b5;

import com.transsion.backup.model.BackupMessage;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ji.a<Object> {
    @Override // ji.a
    @os.l
    public Short a() {
        return Short.valueOf(v4.g.U);
    }

    @Override // ji.a
    public void b(@os.l Object obj) {
        l0.p(obj, "data");
        BackupMessage backupMessage = (BackupMessage) ji.a.f8709a.a(obj.toString(), BackupMessage.class);
        k4.m.e("BackupController", "data : " + backupMessage);
        if (backupMessage != null) {
            b4.a.f725a.l(backupMessage.getType(), obj);
            return;
        }
        k4.m.c("BackupController", "BackupController: data is not a correct BackupMessage , data: " + obj);
    }
}
