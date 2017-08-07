package com.test.models;

import com.sun.org.glassfish.gmbal.NameValue;
import org.hibernate.validator.constraints.Email;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;



    @NotNull
    @Size(min=1, max=50)
    @NameValue
    private String name;



    @NotNull
    @Size(min=1, max=50, message = "Must enter your email address.")
    @Email
    private String emailAddress;

    @NotNull
    @Size(min=1, max=50)
    private String organisation;


    @Valid
    @Pattern(regexp= "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "Must enter yyyy-MM-dd")
    private String startDate;

    private String endDate;





    private long employedDays;


    // setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getEmployedDays()
    {
        return employedDays;
    }

    public void setEmployedDays(long employedDays)
    {
        this.employedDays = employedDays;
    }






/* Process date as LocalDate
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) { this.startDate = LocalDate.parse(startDate); }

    public LocalDate getEndDate()  {  return endDate;    }
    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }
*/

    //public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

}
