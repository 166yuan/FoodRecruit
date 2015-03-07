package com.recruit.BaseDao;

/**
 */
public class EntityDuplicatedException
    extends RuntimeException
{
    public EntityDuplicatedException()
    {
        super();
    }

    public EntityDuplicatedException(String msg)
    {
        super(msg);
    }

    public EntityDuplicatedException(Throwable cause)
    {
        super(cause);
    }

    public EntityDuplicatedException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
