package com.recruit.BaseDao;

/**
 * Created by Mklaus on 15/1/27.
 */
public class LoginBlockedException extends RuntimeException{
    public LoginBlockedException()
    {
        super();
    }

    public LoginBlockedException(String msg)
    {
        super(msg);
    }

    public LoginBlockedException(Throwable cause)
    {
        super(cause);
    }

    public LoginBlockedException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
