package com.blog.model;

/**
 * 模型类，，对应表sys_option.
 */
public class SysOption extends Model{ 
    /** 参数配置值 */
    private String optionValue;
    /** 参数配置分类 */
    private String optionCategory;
    /** 参数配置值 */
    public String getOptionValue(){ 
        return optionValue;
    } 
    /** 参数配置值 */
    public void setOptionValue(String optionValue){ 
        this.optionValue = optionValue;
    }
    /** 参数配置分类 */
    public String getOptionCategory(){ 
        return optionCategory;
    } 
    /** 参数配置分类 */
    public void setOptionCategory(String optionCategory){ 
        this.optionCategory = optionCategory;
    }
}