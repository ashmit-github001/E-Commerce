/*
 * package com.ashmitagarwal.ecommerce.dto;
 * 
 * import java.io.Serializable; import java.util.Objects;
 * 
 * import jakarta.persistence.Embeddable;
 * 
 * @Embeddable public class ShoppingCartPk implements Serializable{
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * private String userId;
 * 
 * private String productId;
 * 
 * public ShoppingCartPk(){
 * 
 * }
 * 
 * public ShoppingCartPk(String userId, String productId) { this.userId =
 * userId; this.productId = productId; }
 * 
 * public String getUserId() { return userId; }
 * 
 * public void setUserId(String userId) { this.userId = userId; }
 * 
 * public String getProductId() { return productId; }
 * 
 * public void setProductId(String productId) { this.productId = productId; }
 * 
 * @Override public boolean equals(Object o) { if (this == o) return true; if (o
 * == null || getClass() != o.getClass()) return false; ShoppingCartPk that =
 * (ShoppingCartPk) o; return Objects.equals(userId, that.userId) &&
 * Objects.equals(productId, that.productId); }
 * 
 * @Override public int hashCode() { return Objects.hash(userId, productId); } }
 */