package com.cyssxt.stream;

import com.cyssxt.exception.YunDbException;

public interface Stream {

    void seek(long offset) throws YunDbException;
    /**
     * write db to files
     */
    void write() throws YunDbException;

    /**
     * read db from files
     */
    void read() throws YunDbException;

}
