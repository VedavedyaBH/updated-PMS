package com.hexaware.policymanagementsystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")

public class Admin {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "adminid")
		private Long adminId;
		
		@Column(name = "password")
		private String password;
		
		public Admin() {
		}

			public Admin(Long adminId) {
				super();
				this.adminId = adminId;
			}
			public Admin(Long adminId, String password) {
				super();
				this.adminId = adminId;
				this.password = password;
			}
//			@OneToMany( mappedBy = "admin")
//			
//			private List<Policy> policies;
//				
//		public List<Policy> getPolicies() {
//				return policies;
//			}
//
//			public void setPolicies(List<Policy> policies) {
//				this.policies = policies;
//			}
			
//			@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//			@JoinColumn(name="admin_id_fk",referencedColumnName="admin_id")
//			private 

		public Long getAdminId() {
			return adminId;
		}
		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
