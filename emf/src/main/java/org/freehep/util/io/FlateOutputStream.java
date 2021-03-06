// Copyright 2001-2005, FreeHEP.
package org.freehep.util.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

/**
 * The FlateOutputStream uses the Deflate mechanism to compress data. The exact
 * definition of Deflate encoding can be found in the PostScript Language
 * Reference (3rd ed.) chapter 3.13.3.
 * 
 * @author Mark Donszelmann
 * @version $Id: FlateOutputStream.java 8584 2006-08-10 23:06:37Z duns $
 */
public class FlateOutputStream extends DeflaterOutputStream implements
        FinishableOutputStream {

    /**
     * Creates a (In-)Flate output stream.
     * 
     * @param out stream to write to
     */
    public FlateOutputStream(OutputStream out) {
        super(out);
    }

    public void finish() throws IOException {
        super.finish();
        if (out instanceof FinishableOutputStream) {
            ((FinishableOutputStream) out).finish();
        }
    }
}
