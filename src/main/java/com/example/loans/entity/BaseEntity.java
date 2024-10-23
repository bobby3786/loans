package com.example.loans.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@CreatedDate
	@Column(name = "created_at",updatable = false)
	private LocalDateTime createdAt;
	
	@CreatedBy
	@Column(updatable = false,name = "created_by")
	private String createdBy;
	
	@LastModifiedDate
	@Column(insertable = false,name = "updated_at")
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	@Column(insertable = false,name="updated_by")
	private String updatedBy;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
	    this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "BaseEntity [createdAt=" + createdAt + ", CreatedBy=" + createdBy + ", updatedAt=" + updatedAt
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	

}
