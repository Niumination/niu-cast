package l3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b1 extends IOException {
    private q1 zza;

    public b1(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    public static a1 zza() {
        return new a1("Protocol message tag had invalid wire type.");
    }

    public static b1 zzb() {
        return new b1("Protocol message contained an invalid tag (zero).");
    }

    public static b1 zzc() {
        return new b1("Protocol message had invalid UTF-8.");
    }

    public static b1 zzd() {
        return new b1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static b1 zze() {
        return new b1("Failed to parse the message.");
    }

    public static b1 zzg() {
        return new b1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final b1 zzf(q1 q1Var) {
        this.zza = q1Var;
        return this;
    }

    public b1(String str) {
        super(str);
        this.zza = null;
    }
}
