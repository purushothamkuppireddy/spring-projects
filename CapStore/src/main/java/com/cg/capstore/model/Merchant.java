package com.cg.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Merchant {
	
		
		@Id
		@GeneratedValue(generator="merchantSequence",strategy=GenerationType.SEQUENCE)
		@SequenceGenerator(name="merchantSequence",sequenceName="Merchant_Sequence",initialValue=4001,allocationSize=1)
		private int merchantId;
		private String merchantName;
		private String merchantEmail;
		private long merchantContactNumber;
		private String merchantPassword;
		private String approvalStatus;
		
		public int getMerchantId() {
			return merchantId;
		}
		public void setMerchantId(int merchantId) {
			this.merchantId = merchantId;
		}
		public String getMerchantName() {
			return merchantName;
		}
		public void setMerchantName(String merchantName) {
			this.merchantName = merchantName;
		}
		public String getMerchantEmail() {
			return merchantEmail;
		}
		public void setMerchantEmail(String merchantEmail) {
			this.merchantEmail = merchantEmail;
		}
		public long getMerchantContactNumber() {
			return merchantContactNumber;
		}
		public void setMerchantContactNumber(long merchantContactNumber) {
			this.merchantContactNumber = merchantContactNumber;
		}
		public String getMerchantPassword() {
			return merchantPassword;
		}
		public void setMerchantPassword(String merchantPassword) {
			this.merchantPassword = merchantPassword;
		}
		public String getApprovalStatus() {
			return approvalStatus;
		}
		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}
		
		
		
		
	}


