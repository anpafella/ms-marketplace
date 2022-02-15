package com.marketplace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDTO {
	private Integer status;

	private String name;

	private String description;

	private Double precio;

	private Integer categoryId;
}
