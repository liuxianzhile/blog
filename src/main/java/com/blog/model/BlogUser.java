package com.blog.model;

/**
 * 模型类 对应表blog_user.
 */
public class BlogUser extends Model{ 
    /** 用户编号 */
    private Integer userNo;
    /** 姓名 */
    private String userName;
    /** 密码（MD5） */
    private String userPassword;
    /** 昵称 */
    private String userNickName;
    /** 用户自评标签 */
    private String userTags;
    /** 用户 QQ */
    private String userQq;
    /** 用户邮箱 **/
    private String userEmail;
    /** 0：Gravatar，1：外链 */
    private Integer userAvatarType;
    /** 头像图片 URL */
    private String userAvatarUrl;
    /** 用户是否在线 */
    private String userOnlineFlag;
    /** 用户角色 */
    private String userRole;
    /** 0：正常，1：封禁 */
    private Integer userStatus;
    /** 最近一次登录时间 */
    private Long userLatestLoginTime;
    /** 最近一次登录 IP */
    private String userLatestLoginIp;
    /** 最近一次签到时间 */
    private Long userCheckinTime;
    /** 用户皮肤 */
    private String userSkin;
    /** 用户所在国家 */
    private String userCountry;
    /** 用户所在省份 */
    private String userProvince;
    /** 用户所在城市 */
    private String userCity;
    /** 用户更新时间 */
    private Long userUpdateTime;
    /** 0：公开地理位置，1：不公开地理位置 */
    private Integer userGeoStatus;
    /** 用户所选语言 */
    private String userLanguage;
    /** 用户所在时区 */
    private String userTimezone;
    /** 新注册后向导到达第几步 */
    private Integer userGuideStep;
    /** 0：使用重定向页面，1：禁用重定向页面 */
    private Integer userForwardPageStatus;
    
    /** 用户编号 */
    public Integer getUserNo(){ 
        return userNo;
    } 
    /** 用户编号 */
    public void setUserNo(Integer userNo){ 
        this.userNo = userNo;
    }
    /** 姓名 */
    public String getUserName(){ 
        return userName;
    } 
    /** 姓名 */
    public void setUserName(String userName){ 
        this.userName = userName;
    }
    /** 密码（MD5） */
    public String getUserPassword(){ 
        return userPassword;
    } 
    /** 密码（MD5） */
    public void setUserPassword(String userPassword){ 
        this.userPassword = userPassword;
    }
    /** 昵称 */
    public String getUserNickName(){ 
        return userNickName;
    } 
    /** 昵称 */
    public void setUserNickName(String userNickName){ 
        this.userNickName = userNickName;
    }
    /** 用户自评标签 */
    public String getUserTags(){ 
        return userTags;
    } 
    /** 用户自评标签 */
    public void setUserTags(String userTags){ 
        this.userTags = userTags;
    }
    /** 用户 QQ */
    public String getUserQq(){ 
        return userQq;
    } 
    /** 用户 QQ */
    public void setUserQq(String userQq){ 
        this.userQq = userQq;
    }
    /** 0：Gravatar，1：外链 */
    public Integer getUserAvatarType(){ 
        return userAvatarType;
    } 
    /** 0：Gravatar，1：外链 */
    public void setUserAvatarType(Integer userAvatarType){ 
        this.userAvatarType = userAvatarType;
    }
    /** 头像图片 URL */
    public String getUserAvatarUrl(){ 
        return userAvatarUrl;
    } 
    /** 头像图片 URL */
    public void setUserAvatarUrl(String userAvatarUrl){ 
        this.userAvatarUrl = userAvatarUrl;
    }
    /** 用户是否在线 */
    public String getUserOnlineFlag(){ 
        return userOnlineFlag;
    } 
    /** 用户是否在线 */
    public void setUserOnlineFlag(String userOnlineFlag){ 
        this.userOnlineFlag = userOnlineFlag;
    }
    /** 用户角色 */
    public String getUserRole(){ 
        return userRole;
    } 
    /** 用户角色 */
    public void setUserRole(String userRole){ 
        this.userRole = userRole;
    }
    /** 0：正常，1：封禁 */
    public Integer getUserStatus(){ 
        return userStatus;
    } 
    /** 0：正常，1：封禁 */
    public void setUserStatus(Integer userStatus){ 
        this.userStatus = userStatus;
    }
    /** 最近一次登录时间 */
    public Long getUserLatestLoginTime(){ 
        return userLatestLoginTime;
    } 
    /** 最近一次登录时间 */
    public void setUserLatestLoginTime(Long userLatestLoginTime){ 
        this.userLatestLoginTime = userLatestLoginTime;
    }
    /** 最近一次登录 IP */
    public String getUserLatestLoginIp(){ 
        return userLatestLoginIp;
    } 
    /** 最近一次登录 IP */
    public void setUserLatestLoginIp(String userLatestLoginIp){ 
        this.userLatestLoginIp = userLatestLoginIp;
    }
    /** 最近一次签到时间 */
    public Long getUserCheckinTime(){ 
        return userCheckinTime;
    } 
    /** 最近一次签到时间 */
    public void setUserCheckinTime(Long userCheckinTime){ 
        this.userCheckinTime = userCheckinTime;
    }
    /** 用户皮肤 */
    public String getUserSkin(){ 
        return userSkin;
    } 
    /** 用户皮肤 */
    public void setUserSkin(String userSkin){ 
        this.userSkin = userSkin;
    }
    /** 用户所在国家 */
    public String getUserCountry(){ 
        return userCountry;
    } 
    /** 用户所在国家 */
    public void setUserCountry(String userCountry){ 
        this.userCountry = userCountry;
    }
    /** 用户所在省份 */
    public String getUserProvince(){ 
        return userProvince;
    } 
    /** 用户所在省份 */
    public void setUserProvince(String userProvince){ 
        this.userProvince = userProvince;
    }
    /** 用户所在城市 */
    public String getUserCity(){ 
        return userCity;
    } 
    /** 用户所在城市 */
    public void setUserCity(String userCity){ 
        this.userCity = userCity;
    }
    /** 用户更新时间 */
    public Long getUserUpdateTime(){ 
        return userUpdateTime;
    } 
    /** 用户更新时间 */
    public void setUserUpdateTime(Long userUpdateTime){ 
        this.userUpdateTime = userUpdateTime;
    }
    /** 0：公开地理位置，1：不公开地理位置 */
    public Integer getUserGeoStatus(){ 
        return userGeoStatus;
    } 
    /** 0：公开地理位置，1：不公开地理位置 */
    public void setUserGeoStatus(Integer userGeoStatus){ 
        this.userGeoStatus = userGeoStatus;
    }
    /** 用户所选语言 */
    public String getUserLanguage(){ 
        return userLanguage;
    } 
    /** 用户所选语言 */
    public void setUserLanguage(String userLanguage){ 
        this.userLanguage = userLanguage;
    }
    /** 用户所在时区 */
    public String getUserTimezone(){ 
        return userTimezone;
    } 
    /** 用户所在时区 */
    public void setUserTimezone(String userTimezone){ 
        this.userTimezone = userTimezone;
    }
    /** 新注册后向导到达第几步 */
    public Integer getUserGuideStep(){ 
        return userGuideStep;
    } 
    /** 新注册后向导到达第几步 */
    public void setUserGuideStep(Integer userGuideStep){ 
        this.userGuideStep = userGuideStep;
    }
    /** 0：使用重定向页面，1：禁用重定向页面 */
    public Integer getUserForwardPageStatus(){ 
        return userForwardPageStatus;
    } 
    /** 0：使用重定向页面，1：禁用重定向页面 */
    public void setUserForwardPageStatus(Integer userForwardPageStatus){ 
        this.userForwardPageStatus = userForwardPageStatus;
    }
    /** 用户邮箱 **/
	public String getUserEmail() {
		return userEmail;
	}
	/** 用户邮箱 **/
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}