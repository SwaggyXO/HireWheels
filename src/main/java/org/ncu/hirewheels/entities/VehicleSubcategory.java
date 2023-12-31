package org.ncu.hirewheels.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "vehicle_subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_subcategoryID", nullable = false, unique = true)
    private Long vehicleSubcategoryID;

    @NotBlank
    @Size(max = 50)
    @Column(name = "vehicle_subcategory_name", nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @NotNull
    @Column(name = "price_per_day", nullable = false, columnDefinition = "NUMERIC(10,2)")
    private Double pricePerDay;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_categoryID", nullable = false)
    private VehicleCategory vehicleCategory;
    
    @OneToMany(mappedBy = "vehicleSubcategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vehicle> vehicles;


    // Other methods as needed
    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubcategoryID +
                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

}
