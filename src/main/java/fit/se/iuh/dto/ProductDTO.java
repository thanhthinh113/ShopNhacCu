package fit.se.iuh.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class ProductDTO {
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private int categoryId;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private double price;

    @Min(value = 0, message = "Weight must be greater than or equal to 0")
    private double weight;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    private String imageName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
    
}
