package com.whackon.itrip.pojo.vo;



/**
 * 前端输入-修改常用联系人VO
 */
public class ModifyUserLinkUserVO {

    private Long id;                //主键
    private String linkUserName;    //常用刚联系人姓名
    private Integer linkIdCardType;  //证件类型
    private String linkIdCard;       //证件号码
    private String linkPhone;        //联系电话
    private Long userId;             //用户ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLinkUserName (String  linkUserName){
        this.linkUserName=linkUserName;
    }

    public  String getLinkUserName(){
        return this.linkUserName;
    }
    public void setLinkIdCard (String  linkIdCard){
        this.linkIdCard=linkIdCard;
    }

    public Integer getLinkIdCardType() {
        return linkIdCardType;
    }

    public void setLinkIdCardType(Integer linkIdCardType) {
        this.linkIdCardType = linkIdCardType;
    }

    public  String getLinkIdCard(){
        return this.linkIdCard;
    }
    public void setLinkPhone (String  linkPhone){
        this.linkPhone=linkPhone;
    }

    public  String getLinkPhone(){
        return this.linkPhone;
    }
    public void setUserId (Long  userId){
        this.userId=userId;
    }

    public  Long getUserId(){
        return this.userId;
    }
}
