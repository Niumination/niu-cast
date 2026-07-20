package q3;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class a extends IllegalStateException {
    @NonNull
    public static IllegalStateException of(@NonNull f fVar) {
        String strConcat;
        if (!fVar.c()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excA = fVar.a();
        if (excA != null) {
            strConcat = "failure";
        } else if (fVar.d()) {
            strConcat = "result ".concat(String.valueOf(fVar.b()));
        } else {
            strConcat = ((k) fVar).f8960d ? "cancellation" : "unknown issue";
        }
        return new a("Complete with: ".concat(strConcat), excA);
    }
}
