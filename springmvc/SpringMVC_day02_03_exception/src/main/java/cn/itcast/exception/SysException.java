package cn.itcast.exception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SysException.java
 * @Description TODO
 * @createTime 2020年02月20日 10:16:00
 */
//Exception是异常的最顶层父类，所有的异常有直接或间接的继承Exception类
public class SysException extends Exception {

//    做异常的提示信息
    private  String sysMessage;

    public SysException(String sysMessage) {
        this.sysMessage = sysMessage;
    }

    public String getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(String sysMessage) {
        this.sysMessage = sysMessage;
    }
}
