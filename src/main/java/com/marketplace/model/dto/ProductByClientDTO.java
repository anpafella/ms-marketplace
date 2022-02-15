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
public class ProductByClientDTO {

	private int id;

	private int edad;

	private int estado;

	private String name;

	private ProductDTO productDTO;

}
