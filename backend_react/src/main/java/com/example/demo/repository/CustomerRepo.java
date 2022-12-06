package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where status_delete = 0 and name like %:name% order by id desc", nativeQuery = true)
    Page<Customer> getCustomerListPage(Pageable pageable, @Param("name") String name);

    @Query(value = "select * from customer where status_delete = 0 and name like %:name% order by id desc", nativeQuery = true)
    List<Customer> getCustomerList(@Param("name") String name);

    @Query(value = "select * from customer where status_delete = 0 and id = :id", nativeQuery = true)
    Customer findByIdCustomer(@Param("id") Integer id);

    @Modifying
    @Query(value = "update customer set status_delete = 1 where id = :id", nativeQuery = true)
    void deleteCustomer(@Param("id") Integer id);

    @Modifying
    @Query(value = "update customer set `name` = :name, age = :age, address = :address, phone_number = :phoneNumber," +
            " gender = :gender, create_date = :createDate,status_delete = 0 where id = :id", nativeQuery = true )
    void updateCustomer(@Param("name") String name,
                        @Param("age") Integer age,
                        @Param("address") String address,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("gender") Integer gender,
                        @Param("createDate") Date createDate,
                        @Param("id") Integer id);
}
