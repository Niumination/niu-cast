package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        if (strNextString.length() == 1) {
            return Character.valueOf(strNextString.charAt(0));
        }
        StringBuilder sbY = a1.a.y("Expecting character, got: ", strNextString, "; at ");
        sbY.append(bVar.getPreviousPath());
        throw new v4.a0(sbY.toString());
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Character ch2 = (Character) obj;
        dVar.value(ch2 == null ? null : String.valueOf(ch2));
    }
}
