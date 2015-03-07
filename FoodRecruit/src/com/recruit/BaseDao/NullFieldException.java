package com.recruit.BaseDao;

/**
 */
public class NullFieldException
    extends RuntimeException
{
    public NullFieldException()
    {
        super();
    }

    public NullFieldException(String msg)
    {
        super(msg);
    }

    public NullFieldException(Throwable cause)
    {
        super(cause);
    }

    public NullFieldException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
