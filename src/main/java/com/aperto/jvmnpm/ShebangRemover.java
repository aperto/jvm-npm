package com.aperto.jvmnpm;

import java.io.*;
import java.util.*;

/**
 * @author noreply@aperto.com
 */
public class ShebangRemover {

    private String   _content;
    
    public ShebangRemover(File file) throws Exception {
        _content = removeShebang(new Scanner(file).useDelimiter("\\A").next());
    }

    public ShebangRemover(InputStream instream) {
        _content = removeShebang(new Scanner(instream).useDelimiter("\\A").next());
    }
    
    private String removeShebang(String content) {
        String result = content;
        int idx = content.indexOf('\n');
        if (idx != -1) {
            String firstLine = content.substring(0, idx + 1);
            if (firstLine.startsWith("#!")) {
                // drop the shebang line
                result = result.substring(idx + 1);
            }
        }
        return result;
    }

    public String next() {
        return _content;
    }
    
}
