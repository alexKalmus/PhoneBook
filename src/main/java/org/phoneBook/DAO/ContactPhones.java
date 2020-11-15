package org.phoneBook.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ContactPhones {

    private List<String> faxPhones;
    private List<String> homePhones;
    private List<String> mobilePhones;

//    public ContactPhones(List<String> faxPhones, List<String> homePhones, List<String> mobilePhones) {
//        this.faxPhones = faxPhones;
//        this.homePhones = homePhones;
//        this.mobilePhones = mobilePhones;
//    }

    public ContactPhones() {
        faxPhones = new ArrayList<>();
        homePhones = new ArrayList<>();
        mobilePhones = new ArrayList<>();
    }

    public void addFax (String fax){
        faxPhones.add(fax);
    }
    public void addMobile (String mobile){
        mobilePhones.add(mobile);
    }
    public void addHome (String home){
        homePhones.add(home);
    }
    public void deleteFax(String number){faxPhones.remove(number);}
    public void deleteMobile(String number){mobilePhones.remove(number);}
    public void deleteHome(String number){homePhones.remove(number);}

//    public List<String> getFaxPhones() {
//        return faxPhones;
//    }
//
//    public void setFaxPhones(List<String> faxPhones) {
//        this.faxPhones = faxPhones;
//    }
//
//    public List<String> getHomePhones() {
//        return homePhones;
//    }
//
//    public void setHomePhones(List<String> homePhones) {
//        this.homePhones = homePhones;
//    }
//
//    public List<String> getMobilePhones() {
//        return mobilePhones;
//    }
//
//    public void setMobilePhones(List<String> mobilePhones) {
//        this.mobilePhones = mobilePhones;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ContactPhones that = (ContactPhones) o;
//        return Objects.equals(faxPhones, that.faxPhones) &&
//                Objects.equals(homePhones, that.homePhones) &&
//                Objects.equals(mobilePhones, that.mobilePhones);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(faxPhones, homePhones, mobilePhones);
//    }
//
//    @Override
//    public String toString() {
//        return '\t' + "ContactPhones[" +
//                "faxPhones=" + faxPhones +
//                ", homePhones=" + homePhones +
//                ", mobilePhones=" + mobilePhones +
//                ']';
//    }

    public boolean isEmpty (){
        return faxPhones.isEmpty() && homePhones.isEmpty() && mobilePhones.isEmpty();
    }
}
