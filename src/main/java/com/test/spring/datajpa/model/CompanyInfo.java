package com.test.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyInfo{
    @JsonProperty("symbol") 
    public String getSymbol() { 
		 return this.symbol; } 
    public void setSymbol(String symbol) { 
		 this.symbol = symbol; } 
    String symbol;
    @JsonProperty("xid") 
    public String getXid() { 
		 return this.xid; } 
    public void setXid(String xid) { 
		 this.xid = xid; } 
    String xid;
    @JsonProperty("ASXSecurityType") 
    public int getASXSecurityType() { 
		 return this.aSXSecurityType; } 
    public void setASXSecurityType(int aSXSecurityType) { 
		 this.aSXSecurityType = aSXSecurityType; } 
    int aSXSecurityType;
    @JsonProperty("displayName") 
    public String getDisplayName() { 
		 return this.displayName; } 
    public void setDisplayName(String displayName) { 
		 this.displayName = displayName; } 
    String displayName;
    @JsonProperty("issueType") 
    public String getIssueType() { 
		 return this.issueType; } 
    public void setIssueType(String issueType) { 
		 this.issueType = issueType; } 
    String issueType;
    @JsonProperty("issueTypeName") 
    public String getIssueTypeName() { 
		 return this.issueTypeName; } 
    public void setIssueTypeName(String issueTypeName) { 
		 this.issueTypeName = issueTypeName; } 
    String issueTypeName;
    @JsonProperty("issueTypeCode") 
    public int getIssueTypeCode() { 
		 return this.issueTypeCode; } 
    public void setIssueTypeCode(int issueTypeCode) { 
		 this.issueTypeCode = issueTypeCode; } 
    int issueTypeCode;
    @JsonProperty("isin") 
    public String getIsin() { 
		 return this.isin; } 
    public void setIsin(String isin) { 
		 this.isin = isin; } 
    String isin;
    @JsonProperty("xidEntity") 
    public int getXidEntity() { 
		 return this.xidEntity; } 
    public void setXidEntity(int xidEntity) { 
		 this.xidEntity = xidEntity; } 
    int xidEntity;
    @JsonProperty("sector") 
    public String getSector() { 
		 return this.sector; } 
    public void setSector(String sector) { 
		 this.sector = sector; } 
    String sector;
    @JsonProperty("industryGroup") 
    public String getIndustryGroup() { 
		 return this.industryGroup; } 
    public void setIndustryGroup(String industryGroup) { 
		 this.industryGroup = industryGroup; } 
    String industryGroup;
    @JsonProperty("industry") 
    public String getIndustry() { 
		 return this.industry; } 
    public void setIndustry(String industry) { 
		 this.industry = industry; } 
    String industry;
    @JsonProperty("subIndustry") 
    public String getSubIndustry() { 
		 return this.subIndustry; } 
    public void setSubIndustry(String subIndustry) { 
		 this.subIndustry = subIndustry; } 
    String subIndustry;
}

