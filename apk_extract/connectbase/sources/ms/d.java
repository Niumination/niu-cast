package ms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class d extends b {
    public final ks.b D;

    public d(OutputStream outputStream, ks.b bVar) {
        super(outputStream);
        this.D = bVar;
    }

    @Override // ms.b
    public boolean i(ArrayList<Object> arrayList) {
        return false;
    }

    @Override // ms.b
    public boolean w(ArrayList<Object> arrayList, int i10) throws IOException {
        ks.b bVar;
        int i11;
        int i12;
        boolean z10 = false;
        if (i10 != 109 || ((bVar = this.D) != ks.b.Colors256 && bVar != ks.b.Colors16)) {
            return false;
        }
        Iterator<Object> it = arrayList.iterator();
        boolean z11 = false;
        while (true) {
            int i13 = 48;
            if (!it.hasNext()) {
                if (!z11) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("\u001b[");
                Iterator<Object> it2 = arrayList.iterator();
                boolean z12 = true;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next != null) {
                        int iIntValue = ((Integer) next).intValue();
                        if (iIntValue == 38 || iIntValue == i13) {
                            int iA = a(it2);
                            if (iA == 2) {
                                int iA2 = a(it2);
                                int iA3 = a(it2);
                                int iA4 = a(it2);
                                if (this.D == ks.b.Colors256) {
                                    int iJ = c.j(iA2, iA3, iA4, 256);
                                    if (!z12) {
                                        sb2.append(';');
                                    }
                                    sb2.append(iIntValue);
                                    sb2.append(";5;");
                                    sb2.append(iJ);
                                } else {
                                    int iJ2 = c.j(iA2, iA3, iA4, 16);
                                    if (!z12) {
                                        sb2.append(';');
                                    }
                                    if (iIntValue == 38) {
                                        i12 = iJ2 >= 8 ? iJ2 + 82 : iJ2 + 30;
                                    } else {
                                        i12 = iJ2 >= 8 ? iJ2 + 92 : iJ2 + 40;
                                    }
                                    sb2.append(i12);
                                }
                            } else {
                                if (iA != 5) {
                                    throw new IllegalArgumentException();
                                }
                                int iA5 = a(it2);
                                if (this.D == ks.b.Colors256) {
                                    if (!z12) {
                                        sb2.append(';');
                                    }
                                    sb2.append(iIntValue);
                                    sb2.append(";5;");
                                    sb2.append(iA5);
                                } else {
                                    int iH = c.h(iA5, 16);
                                    if (!z12) {
                                        sb2.append(';');
                                    }
                                    if (iIntValue == 38) {
                                        i11 = iH >= 8 ? iH + 82 : iH + 30;
                                    } else {
                                        i11 = iH >= 8 ? iH + 92 : iH + 40;
                                    }
                                    sb2.append(i11);
                                }
                            }
                            z12 = false;
                        } else {
                            if (!z12) {
                                sb2.append(';');
                            }
                            sb2.append(iIntValue);
                            z12 = z10;
                        }
                    }
                    z10 = false;
                    i13 = 48;
                }
                sb2.append(kl.f.f9271d);
                this.f10912a.write(sb2.toString().getBytes());
                return true;
            }
            Object next2 = it.next();
            if (next2 != null && next2.getClass() != Integer.class) {
                throw new IllegalArgumentException();
            }
            Integer num = (Integer) next2;
            z11 |= num.intValue() == 38 || num.intValue() == 48;
        }
    }

    @Override // ms.b
    public boolean y(ArrayList<Object> arrayList) {
        return false;
    }
}
