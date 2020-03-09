package com.cyssxt.stream;

import com.cyssxt.exception.YunDbException;

public abstract class DefaultStream implements Stream{
    long offset;
    protected StreamUtil streamUtil;

    public DefaultStream(StreamUtil streamUtil) {
        this.streamUtil = streamUtil;
    }

    @Override
    public void seek(long offset) throws YunDbException {
        streamUtil.seek(offset);
    }

    public void checkOffset() throws YunDbException {
        if(offset>0){
            seek(offset);
        }else{
            this.offset = offset;
        }
    }

}
