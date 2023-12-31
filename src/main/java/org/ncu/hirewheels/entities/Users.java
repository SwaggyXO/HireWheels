package org.ncu.hirewheels.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false, unique = true)
    private Long userID;

    @Size(max = 50)
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Size(max = 50)
    @Column(name = "lastName")
    private String lastName;

    @Size(min = 6, max = 50)
    @Column(name = "password", nullable = false)
    private String password;

    @Email
    @Size(max = 50)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(name = "mobileNo", nullable = false, unique = true)
    private String mobileNo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID", nullable = false)
    @JsonBackReference
    private Role roleID;

    @Column(name = "walletMoney", nullable = false, columnDefinition = "NUMERIC(10,2) default 10000.00")
    private Double walletMoney;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings;
    
    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", roleId=" + roleID.getRoleName() +
                ", walletMoney=" + walletMoney +
                '}';
    }

	

}
