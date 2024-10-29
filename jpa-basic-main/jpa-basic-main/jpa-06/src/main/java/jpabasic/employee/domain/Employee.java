package jpabasic.employee.domain;

import jakarta.persistence.*;
import jpabasic.common.Address;

@Entity
public class Employee {
    @Id
    private String id;


    @Embedded
    private Address homeAddress;


    @AttributeOverrides({//embedded 해주는데 같은 클래스를 사용하므로 필드를 재정의 하는 형태로 매핑해 줄 컬럼을 지정
            @AttributeOverride(name = "address1", column = @Column(name = "waddr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "waddr2")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "wzipcode"))
    })
    @Embedded
    private Address workAddress;

    protected Employee() {
    }

    public Employee(String id, Address homeAddress, Address workAddress) {
        this.id = id;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public String getId() {
        return id;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }
}
